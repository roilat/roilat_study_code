
package cn.roilat.study.java.basic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageToByteStrs {

	static BASE64Encoder encoder = new sun.misc.BASE64Encoder();

	static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	public static void main(String[] args) throws Exception {
		File f = new File("./logo.png");
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);
			byte[] bytes = baos.toByteArray();
			System.out.println(encoder.encodeBuffer(bytes).trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
