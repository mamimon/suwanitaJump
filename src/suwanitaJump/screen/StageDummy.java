package suwanitaJump.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import suwanitaJump.cnst.SuwanitaJumpConst;
import suwanitaJump.judge.KeyCheck;
import suwanitaJump.load.LoadData;
import suwanitaJump.object.Eru;

public class StageDummy implements ImageObserver{
	/** 背景の画像 */
	private BufferedImage backgroundImage = null;

	/** 左右の壁の画像 */
	private BufferedImage wallImage = null;

	/** クリスタルの数 */
	private int crystalCount = 0;

	/** 進んだ距離 */
	private int distance = 0;

	/** 画像・SE・BGMを読み込むクラスのインスタンス */
	private LoadData loadData = null;

	/** エルのインスタンス */
	private Eru eru = null;

	/**
	 * Stageクラスのコンストラクタ
	 */
	public StageDummy(){
		// 画像・SE・BGMを読み込むクラスのインスタンスの初期化
		loadData = new LoadData();
		// エルのインスタンスの初期化
		eru = new Eru(180, 650, 25, 25, SuwanitaJumpConst.ERU_IMAGE);
	}

	/**
	 * ゲーム画面を描画する
	 * @param g 描画操作のためのオブジェクト
	 */
	public void drawStage(Graphics g, KeyCheck key){
		// ダミー用の壁を描画
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 30, 700);
		g.fillRect(400-30, 0, 30, 700);

		g.setColor(Color.BLACK);
		// エルの移動 ※このクラスではダミーの移動
		eru.move(key);
		// エルの描画
		g.fillOval(eru.getX(), eru.getY(), eru.getWidth(), eru.getHeight());
	}

	/**
	 * クリスタルの数を返す
	 * @return クリスタルの数
	 */
	public int getCrystalCount(){
		return this.crystalCount;
	}

	/**
	 * 衝突判定を行う
	 * @return true : 衝突した場合
	 *         false: 衝突していない場合
	 */
	public boolean collisionCheck(){
		// TODO
		return false;
	}

	/**
	 * 大納言モードの処理を行う
	 */
	public void dainagonMode(){

	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
