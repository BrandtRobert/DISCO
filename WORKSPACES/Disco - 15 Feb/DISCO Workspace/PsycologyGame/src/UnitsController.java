import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;


public class UnitsController {
	
	// unit group flags
    public boolean isSeeking;
    public boolean isTracking;
    public boolean isReLocating;
    public boolean onAutoMode;
    public boolean isActive;
    public String trackedTargetID;
    public Target target;
    public Sea sea;
    public Track track;
    String group; 
    double searchRadius;
    double proximity;
    public ArrayList<Unit> list = new ArrayList<Unit>();
    public ArrayList<Unit> inTransitList = new ArrayList<Unit>();
    Point currentCenter;
    public TargetView targetView;
    
     
    UnitsController(Sea sea, String group){
    	
    	this.sea = sea;
    	this.group = group;
    	isSeeking = false;
        isTracking = false; 
        isReLocating = false;
        isActive =   false;
        onAutoMode = false;
        searchRadius =0;
        proximity = 0;
   }
    
	   	
    Point center(){
        
    	Random rand = new Random();
		
		int pointX = rand.nextInt(Constants.xBORDER);
		int pointY = rand.nextInt(Constants.lBORDER);
    	
		if (!list.isEmpty()) {
			
			int sumX = 0;
			int sumY = 0;
			
    		for (Unit unit:list) {
    			
    			sumX+= unit.positionX;
    			sumY+= unit.positionY;
    		}
    		
    		pointX= sumX/list.size();
    		pointY= sumY/list.size();
    	
    		
    	}
		//System.out.println("in unitscontrollller center is :"  + pointX+pointY +"for id" + list.get(0).id );
    	
    	return new Point(pointX,pointY);
    	
    }


    public String getTrackedTargetID() {
		return trackedTargetID;
	}



	public void setTrackedTargetID(String trackedTargetID) {
		this.trackedTargetID = trackedTargetID;
	}



	public Target getTarget() {
		return target;
	}



	public void setTarget(Target target) {
		this.target = target;
	}


	public boolean isReLocating() {
		return isReLocating;
	}
	public void setReLocating(boolean isReLocating) {
		this.isReLocating = isReLocating;
	}
	public double getProximity() {
		return proximity;
	}
	public void setProximity(double proximity) {
		this.proximity = proximity;
	}
	public double getSearchRadius() {
		return searchRadius;
	}
	
	public void setSearchRadius(double searchRadius) {
		this.searchRadius = searchRadius;
	}
	
	
	public String getTrackedTagrgetID() {
		return trackedTargetID;
	}



	public void setTrackedTagrgetID(String trackedTagrgetID) {
		this.trackedTargetID = trackedTagrgetID;
	}



	public boolean isSeeking() {
		return isSeeking;
	}



	public void setSeeking(boolean isSeeking) {
		this.isSeeking = isSeeking;
	}



	public boolean isTracking() {
		return isTracking;
	}



	public void setTracking(boolean isTracking) {
		this.isTracking = isTracking;
	}



	public boolean isOnAutoMode() {
		return onAutoMode;
	}



	public void setOnAutoMode(boolean onAutoMode) {
		this.onAutoMode = onAutoMode;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    
    
	////////////////////////////////////////////////////////////////////
	// business logic of the units activities
	/////////////////////////////
	
	public void groupButton_clicked() {
		
		//on button clicked
        if(!isActive)
        {
            
        	//logic here
        	
   
        	
        	seekButton_clicked();
        	setActive(true);
        	
        	if (group.compareToIgnoreCase("Blue") == 0){
        	
        	
        	sea.blueGroupButton.setForeground(java.awt.Color.blue);
        	((Load) sea).mFactory.createMessage(this, 1);
        	
        	//Blue Group Buttons
            sea.blueSeekModeButton.setEnabled(true);
            sea.blueTrackModeButton.setEnabled(true);
            sea.blueAutoModeButton.setEnabled(true);
            
        	} else if (group.compareToIgnoreCase("Red") == 0){
        		
        		//Red Group Buttons
        		sea.redGroupButton.setForeground(java.awt.Color.red);
            	((Load) sea).mFactory.createMessage(this, 1);
            	
            	// Red Group Buttons
                sea.redSeekModeButton.setEnabled(true);
                sea.redTrackModeButton.setEnabled(true);
                sea.redAutoModeButton.setEnabled(true);
        		
        	}
             
        }
        //off button clicked
        else if(isActive)  {
        	
        	// 2 commands added by karishma
        	setTrackedTagrgetID(null);
        	setTarget(null);
            
        	if (onAutoMode)
        		autoMode_clicked();
        	
        	if (isTracking ){
        		trackButton_clicked();
            }
        	
        	if (isSeeking ){
        		
        		seekButton_clicked();
        		
            }
        	
            	setActive(false);
        	
        	if (group.compareToIgnoreCase("Blue") == 0){
        	
        		//Blue Group Buttons
        	sea.blueGroupButton.setForeground(java.awt.Color.GRAY);
            sea.blueSeekModeButton.setEnabled(false);
            sea.blueTrackModeButton.setEnabled(false);
            sea.blueAutoModeButton.setEnabled(false);
        	
        	} else if (group.compareToIgnoreCase("Red") == 0){
        		
        		//Red Group Buttons
        		sea.redGroupButton.setForeground(java.awt.Color.GRAY);
            	sea.redSeekModeButton.setEnabled(false);
                sea.redTrackModeButton.setEnabled(false);
                sea.redAutoModeButton.setEnabled(false);
        		
        	}
        
        }// end of else if statement

	} // groupButton_clicked()
	
	
	// seeking
	public void seekButton_clicked() {

        //on button clicked
        if(!isSeeking)
        {
        	
    //    	System.out.println("in the !isseeking part");
               	
        	//logic here
        	setSeeking(true);
     
        	if (group.compareToIgnoreCase("Blue") == 0){
        	
        	BufferedImage bufferedImage = null;
			try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
			
			sea.blueSeekModeButton.setText("");
            sea.blueSeekModeButton.setIcon(new javax.swing.ImageIcon(bufferedImage));
            ((Load) sea).mFactory.createMessage(this, 2);
           
            for(Unit unit: list) { 
            	String unitType="";
                if(unit.colorID==1){
                	unitType="BlueUnit"+unit.id+"SeekTimer";
                }else{
                	unitType="RedUnit"+unit.id+"SeekTimer";
                }
                
                
            	unit.startSeeking((Load) sea, this, list,unitType);
            }
			
        	
        	} else if (group.compareToIgnoreCase("Red") == 0){
        		
        		BufferedImage bufferedImage = null;
        		sea.redSeekModeButton.setText("");
                try {
        			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                sea.redSeekModeButton.setIcon(new javax.swing.ImageIcon
                		(bufferedImage));
                ((Load) sea).mFactory.createMessage(this, 2);
                
                for(Unit unit: list){
                	String unitType="";
                    if(unit.colorID==1){
                    	unitType="BlueUnit"+unit.id+"SeekTimer";
                    }else{
                    	unitType="RedUnit"+unit.id+"SeekTimer";
                    }
                    
                	unit.startSeeking((Load) sea, this, list,unitType);
                }
                	
        		
        	}
            
        }        //off button clicked
        
        else if(isSeeking ) {
      //  	System.out.println("in the +++++++++++++ isseeking part");

        	
            //logic here
        	setSeeking(false); 
            
        	if (group.compareToIgnoreCase("Blue") == 0){
        	
        		sea.blueSeekModeButton.setIcon(null);
                sea.blueSeekModeButton.setText("");
                sea.blueSeekModeButton.setText("Seek");
        	
        	} else if (group.compareToIgnoreCase("Red") == 0){
        		
        		sea.redSeekModeButton.setIcon(null);
        		sea.redSeekModeButton.setText("");
                sea.redSeekModeButton.setText("Seek");
        		
        	}
        }

		
	} // end seekButton_clicked()
	
	// tracking
	public void trackButton_clicked() {
		//on button clicked
        
		
		if(!isTracking && trackedTargetID != null) {
            
			//logic here
        	setTracking(true);
        	
            
            // start tracking
            track = new Track();
            //track.makeFrame ();
            track.start ((Load) sea, this);
            
            
            if (group.compareToIgnoreCase("Blue") == 0){
            
            BufferedImage bufferedImage = null;
			try {
    			bufferedImage  = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
			sea.blueTrackModeButton.setText("");
            sea.blueTrackModeButton.setIcon(new javax.swing.ImageIcon
            		      (bufferedImage));
            
            } else if (group.compareToIgnoreCase("Red") == 0) {
            	
            	BufferedImage bufferedImage = null;
            	try {
        			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                sea.redTrackModeButton.setText("");
                sea.redTrackModeButton.setIcon(new javax.swing.ImageIcon
                		(bufferedImage));
            
            }
            
        }
        //off button clicked
        else if(isTracking ) {
            
        	//logic here
        	setTracking(false); 
            track.stop(); // delete the object
            track = null;
                     
            if (!isSeeking)
               seekButton_clicked();
            
            
            if (group.compareToIgnoreCase("Blue") == 0){
            	
            	sea.blueTrackModeButton.setIcon(null);
                sea.blueTrackModeButton.setText("");
                sea.blueTrackModeButton.setText("Track");
                if (!sea.blueSeekModeButton.isEnabled() && !onAutoMode)
                  sea.blueSeekModeButton.setEnabled(true);
            
            } else if (group.compareToIgnoreCase("Red") == 0){
            
            sea.redTrackModeButton.setIcon(null);
            sea.redTrackModeButton.setText("");
            sea.redTrackModeButton.setText("Track");
            if (!sea.redSeekModeButton.isEnabled() && !onAutoMode)
            sea.redSeekModeButton.setEnabled(true);
            
            }
            
             ((Load) sea).render(); 
            
        }

		
	} // end of trackButton_clicked()
	
	
	// auto mode
	public void autoMode_clicked() {
		
		
		if (!onAutoMode) {
			
			// update auto mode staus
   		    setOnAutoMode(true); 
    		
			if (group.compareToIgnoreCase("Blue") == 0){
    		
				BufferedImage bufferedImage = null;
			    try {
    			bufferedImage  = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
			sea.blueAutoModeButton.setText("");
			sea.blueAutoModeButton.setIcon(new javax.swing.ImageIcon
    	  			(bufferedImage));
			
			sea.blueSeekModeButton.setEnabled(false);
    	  	sea.blueTrackModeButton.setEnabled(false);
    	  	
    	  	if (!isSeeking)
    	  		seekButton_clicked(); 
    	  
    	  		 
			
			} else if(group.compareToIgnoreCase("Red") == 0){
				
				BufferedImage bufferedImage = null;
	    		try {
	    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		
	    		sea.redAutoModeButton.setText("");
	    		sea.redAutoModeButton.setIcon(new javax.swing.ImageIcon
	    	  			(bufferedImage));
	    		sea.redSeekModeButton.setEnabled(false);
	    	  	sea.redTrackModeButton.setEnabled(false);
			
			}
    	  	
    	 	if(!isSeeking && !isTracking)
      	  	   seekButton_clicked();
    	    
    	} else if (onAutoMode) {
    		
    		
    		if (group.compareToIgnoreCase("Blue") == 0){
    		
    		sea.blueAutoModeButton.setIcon(null);
    		sea.blueAutoModeButton.setText("");
    		sea.blueAutoModeButton.setText("Auto");
    		
    		//enable seek/track buttons
    		sea.blueSeekModeButton.setEnabled(true);
    	  	sea.blueTrackModeButton.setEnabled(true);
    	  	
    		} if (group.compareToIgnoreCase("Red") == 0){
    			
    			sea.redAutoModeButton.setIcon(null);
    			sea.redAutoModeButton.setText("");
        		sea.redAutoModeButton.setText("Auto");
        		
        		//enable seek/track buttons
        		sea.redSeekModeButton.setEnabled(true);
        	  	sea.redTrackModeButton.setEnabled(true);
    		}
    		
    		setOnAutoMode(false); 
    		
    		if(!isSeeking)
      	  	   seekButton_clicked();
    		
    		if(isTracking) {
       	  	   trackButton_clicked();
       	  	   seekButton_clicked();
    		}
    		
    		// to load the correct target image    	
    	
  	for(Target target: ((Load) sea).targetList)
		 target.loadImage(target.imageType,"","");
    		
    	}
		
		
  	} // end of autoMode_clicked()
	
	
	
	
	
	
	
	
	
	
}