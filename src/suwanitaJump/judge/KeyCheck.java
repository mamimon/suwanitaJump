package suwanitaJump.judge;

import java.awt.event.KeyEvent;

public class KeyCheck {
	/** Enterキーの入力判定フラグ */
	public boolean enter = false;

	/** Enterキーの長押し防止フラグ */
	public boolean keepEnter = true;

	/** →キーの入力判定フラグ */
	public boolean right = false;

	/** →キーの長押し防止フラグ */
	public boolean keepRight = true;

	/** ←キーの入力判定フラグ */
	public boolean left = false;

	/** ←キーの長押し防止フラグ */
	public boolean keepLeft = true;

	/** Spaceキーの入力判定フラグ */
	public boolean space = false;

	/** Spaceキーの長押し防止フラグ */
	public boolean keepSpace = true;

	/**
	 * KeyCheckクラスのコンストラクタ
	 */
	public KeyCheck(){

	}

	/**
	 * キーが押されたときの判定を行う
	 * @param e キー入力のイベント
	 */
	public void keyPressed(KeyEvent e){
		//押されたキーを見る
        switch(e.getKeyCode()){
            //「Enter」キーが押された場合
            case KeyEvent.VK_ENTER:
            	//「Enter」キーが押された判定をtrueにする
                enter = true;
                break;
            //「→」キーが押された場合
            case KeyEvent.VK_RIGHT:
            	//「→」キーが押された判定をtrueにする
                right = true;
                break;
            //「←」キーが押された場合
            case KeyEvent.VK_LEFT:
            	//「←」キーが押された判定をtrueにする
                left = true;
                break;
            case KeyEvent.VK_SPACE:
            	//「Space」キーが押された判定をtrueにする
            	space = true;
            	break;
        }
	}

	/**
	 * キーが離されたときの判定を行う
	 * @param e キー入力のイベント
	 */
	public void keyReleased(KeyEvent e){
		//離されたキーを見る
        switch(e.getKeyCode()){
        //「Enter」キーが離された場合
        case KeyEvent.VK_ENTER:
        	//「Enter」キーが押された判定をfalseにする
            enter = false;
            //長押し防止のフラグを戻す
            keepEnter = true;
            break;
        //「→」キーが離された場合
        case KeyEvent.VK_RIGHT:
        	//「→」キーが押された判定をfalseにする
            right = false;
            //長押し防止のフラグを戻す
            keepRight = true;
            break;
        //「←」キーが離された場合
        case KeyEvent.VK_LEFT:
        	//「←」キーが押された判定をfalseにする
            left = false;
            //長押し防止のフラグを戻す
            keepLeft = true;
            break;
        //「Space」キーが離された場合
        case KeyEvent.VK_SPACE:
        	//「Space」キーが押された判定をfalseにする
        	space = false;
        	//長押し防止フラグを戻す
        	keepSpace = true;
        	break;
        }
	}
}
