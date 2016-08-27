package suwanitaJump.object;

import java.awt.Graphics;

import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.judge.KeyCheck;

public class Eru extends SuwaObject {

	/** 横の移動量 */
	final private int DX = 100;
	/** 縦の移動量 */
	final private int DY = 50;
	/** 死亡判定 */
	private boolean isDead = false;

	private int nowRightD = 0;
	private boolean isRight = false;
	private int nowLeftD = 0;
	private boolean isLeft = false;
	private int nowYD = 0;
	private int gravity = 1;

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
			nowRightD = 0;
			nowYD = 0;
			isRight = true;
		}

		// ←キーが押されたら
		if (key.keepLeft && key.left) {
			// 長押し防止フラグをfalseにする
			key.keepLeft = false;
			nowLeftD = 0;
			nowYD = 0;
			isLeft = true;
		}

		// 右への移動処理
		if (isRight && nowRightD + 10 <= DX) {
			nowRightD += 10;
			// エルを右に移動
			x += 10;
			// エルが右の壁に衝突したときの処理
			if (x > SuwanitaJumpConst.PANEL_WIDTH - 30 - width) {
				x = SuwanitaJumpConst.PANEL_WIDTH - 30 - width;
			}
		} else {
			isRight = false;
		}

		// 左への移動処理
		if (isLeft && nowLeftD + 10 <= DX) {
			nowLeftD += 10;
			// エルを左に移動
			x -= 10;
			// エルが左の壁に衝突したときの処理
			if (x < 0 + 30) {
				x = 0 + 30;
			}
		}else{
			isLeft = false;
		}

		// 上への移動処理
		if((isRight || isLeft) && nowYD + 8 <= DY){
			nowYD += 8;
			y -= 8;
		}
		y += 2;

		judgeIsDead();
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

	/**
	 * 死亡判定を行う
	 */
	private void judgeIsDead() {
		// 画面外(下)を超えたかどうか
		if (y - height > SuwanitaJumpConst.PANEL_HEIGHT) {
			isDead = true;
		}
	}

	/**
	 * 死亡判定を返す
	 *
	 * @return 死亡判定
	 */
	public boolean getIsDead() {
		return this.isDead;
	}
}
