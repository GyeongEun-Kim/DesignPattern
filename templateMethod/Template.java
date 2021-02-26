package templateMethod;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Template {
	  
	String imageFormat;
	String srcFileName;
	BufferedImage image;
	String destFileName;
	public abstract void colorConvert(BufferedImage image); //서브에서 구현

	
	final void templateMethod (String srcFileName, String destFileName,String formatName) {
		setFormat(formatName);
		setSrcFileName(srcFileName);
		setDestFileName(destFileName);
		readImage();
		colorConvert(image); //서브에서 구현
		createNewImage();
		
	}
	
	public void setSrcFileName(String srcFileName) {
		this.srcFileName=srcFileName;
	}
	
	public void createNewImage() {
		try {
			ImageIO.write(image, imageFormat, new File(destFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setDestFileName(String destFileName) {
		this.destFileName=destFileName;
	}
		
	
	
	public void setFormat(String imageFormat) {
	      this.imageFormat = imageFormat;
	    }
	
	public void readImage() {
		 try {
			
			image = ImageIO.read(new File(srcFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
