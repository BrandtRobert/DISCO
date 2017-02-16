import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class User {
	
	String number;
	String scenario;
	String path;
	String dateTime = "";
	
	User(String number, String scenario){
	
	this.number = number;
	this.scenario = scenario.replace(JarPath.getClassPath() +"scenarios//", "");
	this.scenario = this.scenario.replace(".xml", "");
	//System.out.println("-- file -- " + this.scenario); 
	
	
	   DateFormat dateFormat = new SimpleDateFormat("'_'EEE,MMMd,yyyy'_'HH-mm-ss");
	   //get current date time with Date()
	   Date date = new Date();
	   dateTime =  dateFormat.format(date).toString();
	
	createDataFolder();
	//addData("");
	
	//removeDataFile();
	
	// create a file for a user
	
	}
	
	/*public boolean add(){
		
		return true;
	}
	
   public boolean remove(){
	   
	   	   
	   return true;
		
	}
   
  public boolean login(){
	   
	   return true;
		
	}*/
  
  public boolean addData(String data){
	  
	  
	   //System.out.println(dateFormat.format(date).toString());
	   
	// create list text file
		try {
          // Assume default encoding.
		  String path = this.path+"\\"+ "P" + number   + dateTime +  ".csv"; 
		  //String path = this.path+"\\"+number+".txt";
          FileWriter fileWriter =
              new FileWriter(path, true);

          // Always wrap FileWriter in BufferedWriter.
          BufferedWriter bufferedWriter =
              new BufferedWriter(fileWriter);

          // Note that write() does not automatically
          // append a newline character.
          bufferedWriter.write(data);
          bufferedWriter.newLine();
          
          // Always close files.
          bufferedWriter.close();
      }
      catch(IOException ex) {
          /*System.out.println(
              "Error writing to file '"
              + "List.txt" + "'");*/
          
          JOptionPane.showMessageDialog(null,
          		"Error Writing To File '"
			                + "List.txt" + "'",
      		    "Error", JOptionPane.ERROR_MESSAGE);
          ex.printStackTrace();
          System.out.println("I am here: ");
          // Or we could just do this:
          // ex.printStackTrace();
      }
  			


	  
	  
	  
	   return true;
		
  }
  
  
  public boolean createDataFolder() {
	  
	  
	   this.path = JarPath.getClassPath() + "data//" + scenario;
	   
	   File file = new File(this.path);
	   if (!file.exists()) {
			if (file.mkdirs()) {
				System.out.println("Directory is created!");
				 return true;
			} else {
				System.out.println("Failed to create directory!");
				 return false;
			}
		}
	   //new File(path).mkdirs();
	   
		return false;
		
 } 
  
  
  /*public boolean removeDataFolder() {
	  
	    this.path = "C:\\Workspace\\PsycologyGame\\data\\" + scenario;
	   
	    File file = new File(this.path);
		
	    if (file.exists()) {
			if (file.delete()) {
				System.out.println("Directory is removed!");
				return true;
			} else {
				System.out.println("Failed to remove a directory!");
				return false;
			}
		}
	 
	   //new File(path).mkdirs();
	   
	   return false;
		
}  */

}
