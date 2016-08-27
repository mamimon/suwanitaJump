package suwanitaJump.screen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.judge.ClickCheck;
import suwanitaJump.judge.KeyCheck;
import suwanitaJump.load.LoadData;

public class Title implements ImageObserver{
	/** 背景の画像 */
	private BufferedImage backgroundImage = null;

	/** スタートボタンの画像 */
	private BufferedImage startButtonImage = null;

	/** 画像・SE・BGMを読み込むクラスのインスタンス */
	private LoadData loadData = null;

	/**
	 * Titleクラスのコンストラクタ
	 */
	public Title(){
		// 画像・SE・BGMを読み込むクラスのインスタンスの初期化
		loadData = new LoadData();
		// 背景画像の初期化
		backgroundImage = loadData.loadImage(SuwanitaJumpConst.TITLE_BACKGROUND_IMAGE);
		// スタートボタン画像の初期化
		//startButtonImage = loadImage(SuwanitaJumpConst.TITLE_START_BUTTON_IMAGE);
	}

	/**
	 * タイトル画面を描画する
	 * @param g 描画操作のためのオブジェクト
	 * @return なし
	 */
	public void drawTitle(Graphics g){
		//タイトル画面の背景を描画
		g.drawImage(backgroundImage, 0, 0, this);
	}

	/**
	 * スタート条件を判定する
	 * @param key KeyCheckクラスのインスタンス
	 * @param click ClickCheckクラスのインスタンス
	 * @return
	 */
	public boolean startCheck(KeyCheck key, ClickCheck click){
		//Enterキーが押されたら
		if(key.keepEnter && key.enter){
			//長押し防止フラグをfalseにする
			key.keepEnter = false;
			return true;
		}
		return false;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
