import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;



public class Target extends TimerTask {

	public String id;
	public int positionX;
	public int positionY;
	public int speed;
	public int score;
	public String movement;
	public String imageType;
	//public Timer timer;
	public int fulePoints;
	public BufferedImage image;
	public Movable movable;
	public String level;
	public boolean showMessage = false;
	public TargetDetectedMessage dialogBox = null;
	//Added by Praveen for Image Location
	public String imageLocation;
	public String inspectionImagePath;
	public String priority;
	public String trueIdentity;
	public double directionValue;
	public int timerCounter=0;
	public String description="";
	public String markedIdentity="N/A";
	public String markStatus="N/A";
	public double scoreGenerated =0;
	
	public static boolean displayToTextArea = true;
	//To specify if a direction has been set for a target, do a call hierarchy to see where the variable is used
	
	
	public boolean isTargetdetected() {
		return isTargetdetected;
	}


	public void setTargetdetected(boolean isTargetdetected) {
		this.isTargetdetected = isTargetdetected;
	}



	public String[] arrpriorityLevels;
	public boolean isTargetdetected;
	
		

public Target(String id, int positionX, int positionY, int speed, String imageType, 
		    String movement, int fulePoints, Movable movable,String imageLocation,String trueIdentity,String[] arrpriorityLevels,String priority,String description, String inspectionImagePath) {
	
	this.id = id;
	this.positionX = positionX;
	this.positionY = positionY;
	this.speed = speed;
	this.movement = movement;
	this.imageType = imageType;
	this.movable = movable;
	this.fulePoints = fulePoints;
	this.imageLocation = imageLocation;
	this.trueIdentity = trueIdentity;
	this.priority = priority;
	this.arrpriorityLevels = arrpriorityLevels;
	this.isTargetdetected=false;
	loadImage(imageType,imageLocation,priority);
	this.inspectionImagePath = inspectionImagePath;
	this.description=description;
	this.timerCounter=Integer.parseInt(ConfigProps.TARGET_TIMER_COUNTER)+1;

}


public void startMoving (){
	 
	 Timer timer = new Timer();
	 //timer.schedule(this,speed,speed);
	 //timer.schedule(this, 10);
	 timer.scheduleAtFixedRate(this, 1, 1);
	 
	}

	
@Override
public void run() {
	
	movable.move(this);
	

}


public void loadImage(String imageType,String imageLocation,String priority) {
	
	
	try {
		
		image = Utilities.getScaledImage(ImageIO.read(new File("images/"+imageLocation)),Integer.parseInt(ConfigProps.TARGET_SCREEN_RES_WIDTH),Integer.parseInt(ConfigProps.TARGET_SCREEN_RES_HEIGHT));
		score = 1;
	    level = priority;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} 


public void largeImage() {
	
	try {
		
		image = ImageIO.read(new File("images/Ovel-Large.png"));
		
	   } catch (IOException e) {
		
		e.printStackTrace();
	   }
  }


public void smallImage() {
	
	try {
		
		image = ImageIO.read(new File("images/Ovel-Smal.png"));
		
	   } catch (IOException e) {
		
		e.printStackTrace();
	   }
  }

 void intercepted(Load load){
	
	
	 ArrayList<Unit> list = new ArrayList<Unit>(); 
	// which group is tracking / seeking
	if (load.redUnits.isActive)
	  list = load.redUnits.list;
	if (load.blueUnits.isActive)
	  list = load.blueUnits.list;
	
	  // target is intercepted
	   for (Unit unit:list)
	   	if (distanceTU(this,unit) <= Constants.TRAGET_INTERCEPTED_DISTANCE) {
		     //load.targetInterceptedLabel.setText(Integer.toString(this.id));
		     return;
	   } /*else {
		     load.targetInterceptedLabel.setText("");
	   }*/
}
 
 
double distanceTU(Target target, Unit unit){
	 
	 return  Math.sqrt(Math.pow((target.positionX-unit.positionX), 2) 
		        + Math.pow((target.positionY-unit.positionY), 2));
	 
 }
 
 
 
 boolean hideTarget(final Load load, final UnitsController controller) {
	  	   
	   for (Unit unit : controller.list){
	
		  if ( load.prop.targetDetected( distanceTU(this,unit), unit.detectionRadius, load.performance)) {
			  
			  unit.targetDetected = this.id;
			   
		  if (controller.onAutoMode) 
				     
				   if (controller.targetView == null || (controller.targetView !=null 
				        && !controller.targetView.low))
			            this.largeImage();
				     
			  // update tracking target	   
			  if(!controller.isTracking){
		      	  
				  tarckThisTarget(load, controller);
			
			  } else if (controller.isTracking && !String.valueOf(controller.trackedTargetID).equals(this.id)) {
				  
			      // switch to track this current target!
				  if (!showMessage && dialogBox == null) {
					  
					  EventQueue.invokeLater(new Runnable() {

				            public void run() {

				            	//dialogBox = new AutoCloseMessageDialog();
				            	ShowMessage(load,controller);
				            	

				            }

				        });
					 }
			  
			  }
				  
			
			
			  
			  
			  // update target status labels
			   load.statusDetectedLabel.setEnabled(true);
			   load.statusDetectedLabel.setBackground(Color.YELLOW);
			   //statusDetectedLabel.setOpaque(true);
			   load.updateLableColor(load.statusDetectedLabel,50,153,255);
		       load.statusViewLabel.setEnabled(true);
		       //statusViewLabel.setBackground(Color.yellow);
		       load.updateLableColor(load.statusViewLabel,50,153,255);
			   load.unitNumberLable.setText(unit.id);
			   
			   double trackingBonusForHighPriority = Double.parseDouble(ConfigProps.TB_POINTS_HIGH)/60.0;
			   double trackingBonusForLowPriority = Double.parseDouble(ConfigProps.TB_POINTS_LOW)/60.0;
			   
			   String targetID = String.valueOf(controller.target.id);
			   String priority = String.valueOf(controller.target.priority);
			   DecimalFormat df = new DecimalFormat("#.00"); 
			   
			   if(TargetView.markingBonusArray.contains(targetID)){
				   if(priority.equals("HIGH")){
					String label = Sea.targetInterceptedTitleLabel.getText();
       				String[] arrLabel = label.split(":");
       				double currentScore = Double.parseDouble(arrLabel[1]);
       				currentScore = currentScore + trackingBonusForHighPriority;
       				
       				for(int i=0;i<Load.targetList.size();i++){
       	    			if(targetID.equals(Load.targetList.get(i).id)){
       	    				Load.targetList.get(i).scoreGenerated += trackingBonusForHighPriority;
       	    			}
       	    		}
       				
       				
       				currentScore = Double.parseDouble(df.format(currentScore));
       				Sea.targetInterceptedTitleLabel.setText("Score:"+currentScore);
				   }else{
					String label = Sea.targetInterceptedTitleLabel.getText();
	       		    String[] arrLabel = label.split(":");
	       			double currentScore = Double.parseDouble(arrLabel[1]);
	       			currentScore = currentScore + trackingBonusForLowPriority;
	       			
	       			for(int i=0;i<Load.targetList.size();i++){
	        			if(targetID.equals(Load.targetList.get(i).id)){
	        				Load.targetList.get(i).scoreGenerated += trackingBonusForLowPriority;
	        			}
	        		}
	       			
	       			
	       			currentScore = Double.parseDouble(df.format(currentScore));
	       			Sea.targetInterceptedTitleLabel.setText("Score:"+currentScore); 
				   }
			   }
			  		  
			   // target is intercepted
			   intercepted(load);
			  
			  
			   // auto track
			   if (controller.onAutoMode) {
				   
				   if (controller.isSeeking && !controller.isTracking ){
					   
					    controller.seekButton_clicked();
		        		controller.trackButton_clicked();
		            }
			   
			   
			   } 
			   
			  			   
			   return false;
			   
	       } 
	  
	   } // end of for loop
	   //prop = null;
	   
	  	   
	   if ( String.valueOf(controller.trackedTargetID).equals(this.id) ) {
		   
		   // timer to delay view target list  on viewtarget object.
		   load.timerCounter++;
		   
		   this.timerCounter = load.timerCounter;
		   
		   
		   if ( load.timerCounter > Integer.parseInt(ConfigProps.TARGET_TIMER_COUNTER)) {
		   
			   if(Load.activityFeed.getTargetOutOfRange().equals("Y"))
			   Sea.updatesTextArea.append("Target ( " + this.id + " ) has  moved outside the range." + "\n\n"); 
			   
			   this.displayToTextArea = true;
			   
		   
		   load.targetDetectedLabel.setText("");
		   load.targetInterceptedLabel.setText("");
		  	      
			   controller.setTrackedTagrgetID(null); 
			   controller.setTarget(null);
			   
		   // update target status
		   load.statusDetectedLabel.setEnabled(false);
		   load.updateLableColor(load.statusDetectedLabel,224,224,224);
	       load.statusViewLabel.setEnabled(false);
	       load.updateLableColor(load.statusViewLabel,224,224,224);
		   load.unitNumberLable.setText("");
		 
		   //Commented by Praveen for not closing the target inspection tab
		   //TargetView.dispose();
		   
		   
		   // update tracking list
		   if (controller.targetView!=null) {
			  // controller.targetView.updateTargetComboIds();
			 //  TargetView.dispose();
			   //controller.targetView = null;
		   }
		   
		   load.timerCounter = 0;
		   
		   } // end of timer statement
		   
	     
	     } 	// end of removing target from tracking list. 
	   
	 
		   return true;	
		
	}

 
 boolean view(Load load){
	 
	 
	 
	 boolean show = false;
	 
	 if (!load.blueUnits.isReLocating && !load.blueUnits.isSeeking && !load.blueUnits.isTracking
				&&	!load.redUnits.isReLocating && !load.redUnits.isSeeking && !load.redUnits.isTracking 
				&& !load.mousePressed) {
	// false done by karishma for targets not being visible when group button is clicked		
		        show = false;
	  
		      
	 } else if ( (load.redUnits.isReLocating || load.redUnits.isSeeking) && load.redUnits.isActive 
		    		       && !hideTarget(load, load.redUnits) ) {
		 		 if(this.displayToTextArea == true){ 
		 			 if(!this.isTargetdetected()){
		 				if(Load.activityFeed.getNewTargetSpotted().equals("Y"))
		 				 Sea.updatesTextArea.append("New Target Spotted - A New Target ( " + this.id + " ) has come inside the range of Red Units" + "\n\n");
		 			 }else{
		 				if(Load.activityFeed.getOldTargetSpotted().equals("Y")) 
		 				Sea.updatesTextArea.append("Detected Target Spotted - A New Target ( " + this.id + " ) has come inside the range of Red Units" + "\n\n"); 
		 			 }
		 		 
		 		 this.displayToTextArea = false;
		 		 }
		 		  load.timerCounter = 0;
		    	  show = true;
		            //System.out.println( " -- Tracked Unit ID " +  trackedTargetID );
		  
			
	 } else if ( (load.blueUnits.isReLocating || load.blueUnits.isSeeking) && load.blueUnits.isActive 
					      && !hideTarget(load, load.blueUnits)) {
		 if(this.displayToTextArea == true){ 
 			 if(!this.isTargetdetected()){
 				if(Load.activityFeed.getNewTargetSpotted().equals("Y"))
 				Sea.updatesTextArea.append("New Target Spotted - A New Target ( " + this.id + " ) has come inside the range of Blue Units" + "\n\n");
 			 }else{
 				if(Load.activityFeed.getOldTargetSpotted().equals("Y")) 
 				Sea.updatesTextArea.append("Detected Target Spotted - A New Target ( " + this.id + " ) has come inside the range of Blue Units" + "\n\n"); 
 			 }
 		 
 		 this.displayToTextArea = false;
 		 }
		 
		 
		 load.timerCounter = 0;
				show = true;
	  
		    
	 } else if ( (load.redUnits.isTracking || load.blueUnits.isTracking) 
		    		   && (String.valueOf(load.redUnits.trackedTargetID).equals(this.id) || 
		    				   String.valueOf(load.blueUnits.trackedTargetID).equals(this.id))){
		 
		    	show = true;
				
			
	 } 
	 
	 
	return show;
	 
	 
 }
 
 
/* //show message dialog
 void showMessage (){
			
		   	// seeking for a target within a search Radius
			final Timer timer = new Timer();
	        
		     final TimerTask task = new TimerTask() {
		         @Override
		         public void run() {
					             
					 // only move units to a group in case it is not tracking!      
		        	 if(!showMessage) {
					    	   
		        		     startShowing();
					            
					       } else {
					            	//System.out.println("I am not relocating"); 
					                timer.cancel();
					                timer.purge();
					             }
					         
		         }
					     
		     };

					     timer.schedule(task, 0);

			
		}
*/ 
 
void ShowMessage(Load load, UnitsController controller) {
	
	showMessage = true;
	dialogBox = new TargetDetectedMessage(this, load,controller);
}



void tarckThisTarget(Load load, UnitsController controller){
	
	controller.setTarget(this);
	controller.setTrackedTagrgetID(this.id);
   // load.targetDetectedLabel.setText(Integer.toString(this.id));

	  
}
 
} 
