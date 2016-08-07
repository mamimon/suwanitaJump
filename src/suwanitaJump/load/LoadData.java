package suwanitaJump.load;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public class LoadData {

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
}
