package templateMethod;
import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;


class GreyImageConverter extends Template{
	public void colorConvert(BufferedImage image) {
		 Color newColor = null;
		 for (int y = 0; y < image.getHeight(); y++) {
		 	for (int x = 0; x < image.getWidth(); x++) {
		         Color color = new Color(image.getRGB(x, y));    
		     //        newColor = colorConverter.convert(color);
		         		newColor = convert(color);
		             image.setRGB(x, y, newColor.getRGB());
		         }
		     }
		}
	
    public Color convert(Color color) {
        int outputRed = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        int outputGreen = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        int outputBlue = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        return new Color(outputRed, outputGreen, outputBlue);
    }


}