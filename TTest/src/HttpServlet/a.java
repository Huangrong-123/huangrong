package HttpServlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class a {
	public static void main(String[] args) {
		CreateVerificationCodeImage cc=new CreateVerificationCodeImage();
		String randomCode =cc.createCode();
		BufferedImage createImage = cc.CreateImage(randomCode);
		File file =new File("E:/test.jpeg");
		try {
			ImageIO.write(createImage, "jpeg", file);
			System.out.println("保存图片成功");
		} catch (IOException e) {
			System.out.println("保存失败");
			e.printStackTrace();
		}
		
	}
	
}
