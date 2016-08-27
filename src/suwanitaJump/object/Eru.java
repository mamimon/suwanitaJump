package suwanitaJump.object;

import java.awt.Graphics;

import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.judge.KeyCheck;

public class Eru extends SuwaObject {

	/** 横の移動量 */
	final private int DX = 10;
	/** 縦の移動量 */
	final private int DY = 10;

	/**
	 * Eruクラスのコンストラクタ
	 *
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 * @param path
	 */
	public Eru(int x, int y, int width, int heigth, String path) {
		super(x, y, width, heigth, path);
	}

	/**
	 * エルを動かす
	 */
	public void move(KeyCheck key) {
		// →キーが押されたら
		if (key.keepRight && key.right) {
			// 長押し防止フラグをfalseにする
			key.keepRight = false;
			x += DX;
			if(x > SuwanitaJumpConst.PANEL_WIDTH - 30 - width){
				x = SuwanitaJumpConst.PANEL_WIDTH - 30 - width;
			}
		}

		// ←キーが押されたら
		if (key.keepLeft && key.left) {
			// 長押し防止フラグをfalseにする
			key.keepLeft = false;
			x -= DX;
			if(x < 0 + 30){
				x = 0 + 30;
			}
		}
	}

	/**
	 * ディスプレイ用のエルを描画する
	 *
	 * @param g
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 */
	public void displayEruDraw(Graphics g, int x, int y, int width, int heigth) {

	}
}
