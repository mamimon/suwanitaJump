package suwanitaJump.object;

import java.awt.image.BufferedImage;

import com.sun.prism.Graphics;

public class SuwaObject {

	/** オブジェクトのx座標 */
	private int x = 0;

	/** オブジェクトのy座標 */
	private int y = 0;

	/** オブジェクトの幅 */
	private int width = 0;

	/** オブジェクトの高さ */
	private int heigth = 0;

	/** オブジェクトの画像のパス */
	private BufferedImage image = null;

	/**
	 * SwaObjectクラスのコンストラクタ
	 * @param x　オブジェクトのx座標
	 * @param y　オブジェクトのx座標
	 * @param wigth　オブジェクトの幅
	 * @oaram heigth　オブジェクトの高さ
	 * @param path　オブジェクトの画像のパス
	 * @return なし
	 */
	public SuwaObject(int x, int y, int width, int heigth, String path){

	}

	/**
	 * オブジェクトの画像を描画する
	 * @param g
	 * @return なし
	 */
    public void draw(Graphics g){


	}

    /**
     * 画像のURLから画像を読み込む
     * @param path
     * @return
     */
    public BufferedImage loadImage(String path){

		return image;
    }

    /**
     * オブジェクトのx座標を返す
     * @return x
     */
    public int getX(){

		return x;

    }

    /**
     * オブジェクトのy座標を返す
     * @return y
     */
    public int getY(){

		return y;
    }

    /**
     * オブジェクトの幅を返す
     * @return width
     */
    public int getWidth(){

    	return width;
    }

    /**
     * オブジェクトの高さを返す
     * @return heigth
     */
    public int getHeigth(){

    	return heigth;
    }

}
