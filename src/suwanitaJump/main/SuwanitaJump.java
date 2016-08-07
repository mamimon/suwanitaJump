package suwanitaJump.main;

import java.awt.Container;

import javax.swing.JFrame;

public class SuwanitaJump extends JFrame {
	public SuwanitaJump() {
		// JFrameのタイトルを設定
		setTitle("スワニータジャンプ");
		// JPanelを生成
		MainPanel panel = new MainPanel();
		// JPanelを貼りつけるためにJFrameのContentPaneを取得
		Container contentPane = getContentPane();
		// JPanelを貼りつける
		contentPane.add(panel);
		// JFrameの大きさをJPanelの大きさに合わせる
		pack();
	}

	public static void main(String[] args) {
		// JFrameを生成
		SuwanitaJump frame = new SuwanitaJump();
		// アプリケーション終了をクローズ処理として設定
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JFrameを見えるようにする
		frame.setVisible(true);
	}
}
