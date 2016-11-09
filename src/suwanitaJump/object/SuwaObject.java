package suwanitaJump.object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import suwanitaJump.load.LoadData;

public class SuwaObject implements ImageObserver{

	/** オブジェクトのx座標 */
	protected int x = 0;

	/** オブジェクトのy座標 */
	protected int y = 0;

	/** オブジェクトの幅 */
	protected int width = 0;

	/** オブジェクトの高さ */
	protected int height = 0;

	/** オブジェクトの画像のパス */
	protected BufferedImage image = null;

	/** 画像・SE・BGMを読み込むクラスのインスタンス */
	private LoadData loadData = null;

	/**
	 * SwaObjectクラスのコンストラクタ
	 * @param x　オブジェクトのx座標
	 * @param y　オブジェクトのx座標
	 * @param wigth　オブジェクトの幅
	 * @oaram heigth　オブジェクトの高さ
	 * @param path　オブジェクトの画像のパス
	 * @return なし
	 */
	public SuwaObject(int x, int y, int width, int height, String path){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// 画像・SE・BGMを読み込むクラスのインスタンスの初期化
		loadData = new LoadData();
		// オブジェクト画像の初期化
		image = loadData.loadImage(path);
	}

	/**
	 * オブジェクトの画像を描画する
	 * @param g
	 * @return なし
	 */
    public void draw(Graphics g){
    	g.drawImage(this.image, this.x, this.y, this);
	}

    /**
     * オブジェクトのx座標を返す
     * @return x
     */
    public int getX(){

		return this.x;

    }

    /**
     * オブジェクトのy座標を返す
     * @return y
     */
    public int getY(){

		return this.y;
    }

    /**
     * オブジェクトの幅を返す
     * @return width
     */
    public int getWidth(){

    	return this.width;
    }

    /**
     * オブジェクトの高さを返す
     * @return heigth
     */
    public int getHeight(){

    	return this.height;
    }

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
