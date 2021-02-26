package templateMethod;
import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;

class InverseImageConverter extends Template{
	
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
        int outputRed = 255 - color.getRed();
        int outputGreen = 255 - color.getGreen();
        int outputBlue = 255 - color.getBlue();
        return new Color(outputRed, outputGreen, outputBlue);
    }
}