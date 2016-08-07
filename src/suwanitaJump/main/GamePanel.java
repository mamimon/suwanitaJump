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
import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.screen.Result;
import suwanitaJump.screen.Stage;
import suwanitaJump.screen.Title;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {
	/** 表示する画面の状態 */
	private int scene = SuwanitaJumpConst.TITLE_SCENE;

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

	/**
	 * GamePanelクラスのコンストラクタ
	 */
	public GamePanel() {
		// JPanelの大きさを設定
		setPreferredSize(new Dimension(SuwanitaJumpConst.PANEL_WIDTH, SuwanitaJumpConst.PANEL_HEIGHT));
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

	/**
	 * 描画する
	 * @param g 描画操作のためのオブジェクト
	 * @return なし
	 */
	public void paintComponent(Graphics g) {
		// スーパークラスのpaintComponentを呼び出す
		super.paintComponent(g);

		// 描画に使う色を白に設定
		g.setColor(Color.WHITE);
		// JPanelの幅、高さの分だけ白い四角で塗りつぶす
		g.fillRect(0, 0, SuwanitaJumpConst.PANEL_WIDTH, SuwanitaJumpConst.PANEL_HEIGHT);

		// 今のシーンがどこかを見る
		switch (scene) {
		// タイトル画面の場合
		case SuwanitaJumpConst.TITLE_SCENE:
			// タイトル画面を描画
			title.drawTitle(g);
			break;
		// ゲーム画面の場合
		case SuwanitaJumpConst.STAGE_SCENE:
			// ゲーム画面を描画
			stage.drawStage(g);
			break;
		// リザルト画面の場合
		case SuwanitaJumpConst.RESULT_SCENE:
			// リザルト画面を描画
			result.drawResult(g);
			break;
		}

	}

	/**
	 * スレッドを実行すると呼ばれるメソッド
	 * @return なし
	 */
	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ
		long error = 0;
        long idealSleep = (1000 << 16) / SuwanitaJumpConst.FPS;
        long oldTime;
        long newTime = System.currentTimeMillis() << 16;
        //スレッドがnullではない場合
        while (thread != null) {
            oldTime = newTime;
            //paintComponentメソッドを呼び出す
            repaint();
            newTime = System.currentTimeMillis() << 16;
            long sleepTime = idealSleep - (newTime - oldTime) - error;
            if (sleepTime < 0x20000)
                sleepTime = 0x20000;
            oldTime = newTime;
            try {
                Thread.sleep(sleepTime >> 16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newTime = System.currentTimeMillis() << 16;
            error = newTime - oldTime - sleepTime;
        }
	}

	/**
	 * キーボードを押して、離したときに呼ばれる(未使用予定)
	 * @param e キー入力のイベント
	 * @return なし
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * マウスを押したときに呼ばれる
	 * @param e キー入力のイベント
	 * @return なし
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		keyCheck.keyPressed(e);
	}

	/**
	 * マウスを離したときに呼ばれる
	 * @param e キー入力のイベント
	 * @return なし
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		keyCheck.keyReleased(e);
	}

	/**
	 * マウスを押して、離したときに呼ばれる(未使用予定)
	 * @param e マウス入力のイベント
	 * @return なし
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		clickCheck.mouseClicked(e);
	}

	/**
	 * マウスを押したときに呼ばれる
	 * @param e マウス入力のイベント
	 * @return なし
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		clickCheck.mousePressed(e);
	}

	/**
	 * マウスを離したときに呼ばれる
	 * @param e マウス入力のイベント
	 * @return なし
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		clickCheck.mouseReleased(e);
	}

	/**
	 * マウスが入ったときに呼ばれる(未使用予定)
	 * @param e マウス入力のイベント
	 * @return なし
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * マウスが出て行ったときに呼ばれる(未使用予定)
	 * @param e マウス入力のイベント
	 * @return なし
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}




}
