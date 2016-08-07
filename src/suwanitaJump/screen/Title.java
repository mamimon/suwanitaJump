package suwanitaJump.screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;

import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.judge.ClickCheck;
import suwanitaJump.judge.KeyCheck;

public class Title implements ImageObserver{
	/** 背景の画像 */
	private BufferedImage backGroundImage = null;

	/** スタートボタンの画像 */
	private BufferedImage startButtonImage = null;

	/**
	 * Titleクラスのコンストラクタ
	 */
	public Title(){
		// 背景画像の初期化
		backGroundImage = loadImage(SuwanitaJumpConst.TITLE_BACKGROUND_IMAGE);
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
		g.drawImage(backGroundImage, 0, 0, this);
	}

	/**
	 * 画像のURLから画像を読み込む
	 * @param path 画像のURL
	 * @return 読み込んだ画像
	 */
	public BufferedImage loadImage(String path){
		int transcl = new Color(0, 0, 0, 0).getRGB();
		MediaTracker tr = new MediaTracker(new Canvas());
		Image img = Toolkit.getDefaultToolkit().getImage(path);
		tr.addImage(img, 0);
		try {
			tr.waitForAll();
		} catch (InterruptedException e) {
		}
		int wd = img.getWidth(null);
		int ht = img.getHeight(null);
		int[] buf = new int[wd*ht];
		PixelGrabber grab = new PixelGrabber(img, 0, 0, wd, ht, buf, 0, wd);
		try {
			grab.grabPixels();
		} catch (InterruptedException e) {
		}
		BufferedImage retimg = new BufferedImage(wd, ht, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < ht; y++) {
			for (int x = 0; x < wd; x++) {
				int cl = buf[y*wd+x];
				if (cl == buf[0]) {
					cl = transcl;
				}
				retimg.setRGB(x, y, cl);
			}
		}
		return retimg;
	}

	/**
	 *
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
