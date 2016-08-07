package suwanitaJump.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import suwanita.judge.ClickCheck;
import suwanita.judge.KeyCheck;
import suwanitaJump.screen.Result;
import suwanitaJump.screen.Stage;
import suwanitaJump.screen.Title;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {
	/** 表示する画面の状態 */
	private int scene = SuwanitaConst.TITLE_SCENE;

	/** スレッド */
	private Thread thread = null;

	/** キーボードの判定を行うKeyCheckクラスのインスタンス */
	private KeyCheck keyCheck = null;

	/** マウスの判定を行うClickCheckクラスのインスタンス */
	private ClickCheck clickCheck = null;

	/** タイトル画面の表示を行うTitleクラスのインスタンス */
	private Title title = null;

	/** ゲーム画面の表示を行うStageクラスのインスタンス */
	private Stage stage = null;

	/** リザルト画面の表示を行うResultクラスのインスタンス */
	private Result result = null;

	public GamePanel() {
		// JPanelの大きさを設定
		setPreferredSize(new Dimension(SuwanitaConst.PANEL_WIDTH, SuwanitaConst.PANEL_HEIGHT));
		// JPanelでフォーカスを使るようにする
		setFocusable(true);
		// キー入力を使えるようにする
		addKeyListener(this);
		// マウス入力を使えるようにする
		addMouseListener(this);

		keyCheck = new KeyCheck();
		clickCheck = new ClickCheck();
		title = new Title();
		stage = new Stage();
		result = new Result();

		// スレッドがnullだった場合
		if (thread == null) {
			// スレッドを宣言
			thread = new Thread(this);
			// スレッドをスタート
			thread.start();
		}
	}

	public void paintComponent(Graphics g) {
		// スーパークラスのpaintComponentを呼び出す
		super.paintComponent(g);

		// 描画に使う色を白に設定
		g.setColor(Color.WHITE);
		// JPanelの幅、高さの分だけ白い四角で塗りつぶす
		g.fillRect(0, 0, SuwanitaConst.PANEL_WIDTH, SuwanitaConst.PANEL_HEIGHT);

		// 今のシーンがどこかを見る
		switch (scene) {
		// タイトル画面の場合
		case SuwanitaConst.TITLE_SCENE:
			// タイトル画面を描画
			title.drawTitle(g);
			break;
		// ゲーム画面の場合
		case SuwanitaConst.STAGE_SCENE:
			// ゲーム画面を描画
			stage.drawStage(g);
			break;
		// リザルト画面の場合
		case SuwanitaConst.STAGE_SCENE:
			// ステージ画面を描画
			result.drawResult(g);
			break;
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
