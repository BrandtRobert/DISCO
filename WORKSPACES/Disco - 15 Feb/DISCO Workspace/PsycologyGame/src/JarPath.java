import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;



public class JarPath {
	
	static String getClassPath(){
		
		URL url = JarPath.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
	    String parentPath = new File(jarPath).getParentFile().getPath(); //Path of the jar
			parentPath = parentPath + File.separator;
	    
	    	    
	    BufferedWriter writer = null;
	    
	    try
	    {
	        writer = new BufferedWriter( new FileWriter( parentPath+"files\\Path.txt"));
	        
	        writer.write(parentPath);

	    }
	    catch ( IOException e)
	    {
	    }finally
	    {
	        try
	        {
	            if ( writer != null)
	            writer.close( );
	        }
	        catch ( IOException e)
	        {
	        }
	    }

		
		return parentPath;
		
	}
	
 }
 

