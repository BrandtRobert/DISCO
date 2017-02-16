import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class Utilities {
	

	/*public static String getPropertyValue(String propName){
		String propValue =null;
		Properties prop = new Properties();
		try{
		InputStream in = new FileInputStream("disco_config.properties");
		prop.load(in);
		propValue=prop.getProperty(propName);
		
		}catch(Exception e){
			System.out.println("Exception caught while accessing the properties file " + e);
			e.printStackTrace();
		}
		
		return propValue;
	}*/
	
	
	
	
	
	
	public static BufferedImage getScaledImage(Image srcImg, int w, int h) {
	    BufferedImage resizedImg = new BufferedImage(w, h, Transparency.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	} 
	
	
}
