import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;


public class DataCollection extends TimerTask {
    
	Load load;
	User user;
	String data;
	//public static final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
	private String redUnitsData;
	static int totalunits=0;
	
	
	
	DataCollection(Load load, User user){
		this.load = load;
		this.user = user;
		dataHeader();
		        
		
		Timer timer = new Timer();
		timer.schedule(this,100,100);
	}
	
	private void dataHeader() {

		 data = "Timestamp, " +  "Scenario Name, "  + "Participant Number, " + "Number of Targets, " + "Number of Active Units, " + "Number of In-Active Units, " + "Score, " + "Resource Pool, " + " , ";
		
		 // blue group  
		 if (load.blueUnits.list.size() > 0 )
			data += "Blue Group Center X, " + "Blue Group Center Y, " + "Blue Group Proximity Min, " +
					"Blue Group Proximity Max, " + "Blue Group Search Radius, " +
					"Blue Group Mode, " + "Blue Group Number of Active Units, " + "Blue Group Number of In-Active Units, " + "Blue Group Unit Names, " + " , ";
		
		// red group
		if (load.redUnits.list.size() >0 )
			data +=  "Red Group Center X, " + "Red Group Center Y, " + 
		             "Red Group Proximity Min, " + "Red Group Proximity Max, " +
		             "Red Group Search Radius, " + "Red Group Mode, " + "Red Group Number of Active Units, " + "Red Group Unit Names, "  + " , ";
		// target data
		
		int counter =0;
		for (Target target:Load.targetList) {
			counter = counter +1;
			
			if(counter==load.targetList.size()){
				
				data += "Target ID: " + target.id + " Priority, " +
						"Target ID: " + target.id + " True Identity, " +
						"Target ID: " + target.id + " Mark Status, " +
						"Target ID: " + target.id + " Marked Identity, " +
						"Target ID: " + target.id + " Score Generated, " +
						"Target ID: " + target.id + " Location X, " +
						"Target ID: " + target.id + " Location Y, " +
						"Target ID: " + target.id + " Detection, "  +
						"Target ID: " + target.id + " Interception, " + " , ";
				
			}else{
			
			data += "Target ID: " + target.id + " Priority, " +
					"Target ID: " + target.id + " True Identity, " +
					"Target ID: " + target.id + " Mark Status, " +
					"Target ID: " + target.id + " Marked Identity, " +
					"Target ID: " + target.id + " Score Generated, " +
					"Target ID: " + target.id + " Location X, " +
					"Target ID: " + target.id + " Location Y, " +
					"Target ID: " + target.id + " Detection, "  +
					"Target ID: " + target.id + " Interception, ";
			}
		}
		
		
		// blue unit
		if (load.blueUnits.list.size() > 0 ){
			for (Unit unit:load.blueUnits.list) {
				data += "Unit ID: " + unit.id +  " Group, " +
						"Unit ID: " + unit.id +  " Location X, " +
						"Unit ID: " + unit.id +  " Location Y, " +
						"Unit ID: " + unit.id +  " Launch Status, " +
						"Unit ID: " + unit.id +  " Detection Radius, " +
						"Unit ID: " + unit.id +  " Target Detection Status, " +
						"Unit ID: " + unit.id +  " Speed, " +
						"Unit ID: " + unit.id +  " Price, " ;
			}
			
			
			
			for (Unit unit:load.inActiveUnits) {
				
				if(unit.colorID==1){
					data += "Unit ID: " + unit.id +  " Group, " +
							"Unit ID: " + unit.id +  " Location X, " +
							"Unit ID: " + unit.id +  " Location Y, " +
							"Unit ID: " + unit.id +  " Launch Status, " +
							"Unit ID: " + unit.id +  " Detection Radius, " +
							"Unit ID: " + unit.id +  " Target Detection Status, " +
							"Unit ID: " + unit.id +  " Speed, " +
							"Unit ID: " + unit.id +  " Price, " ;
				}
			}
			
		}
		
		// blue unit
				if (load.redUnits.list.size() > 0 ){
					for (Unit unit:load.redUnits.list) {
						data += "Unit ID: " + unit.id +  " Group, " +
								"Unit ID: " + unit.id +  " Location X, " +
								"Unit ID: " + unit.id +  " Location Y, " +
								"Unit ID: " + unit.id +  " Launch Status, " +
								"Unit ID: " + unit.id +  " Detection Radius, " +
								"Unit ID: " + unit.id +  " Target Detection Status, " +
								"Unit ID: " + unit.id +  " Speed, " +
								"Unit ID: " + unit.id +  " Price, " ;
					}
					
					
					
					for (Unit unit:load.inActiveUnits) {
						
						if(unit.colorID==2){
							data += "Unit ID: " + unit.id +  " Group, " +
									"Unit ID: " + unit.id +  " Location X, " +
									"Unit ID: " + unit.id +  " Location Y, " +
									"Unit ID: " + unit.id +  " Launch Status, " +
									"Unit ID: " + unit.id +  " Detection Radius, " +
									"Unit ID: " + unit.id +  " Target Detection Status, " +
									"Unit ID: " + unit.id +  " Speed, " +
									"Unit ID: " + unit.id +  " Price, " ;
						}
					}
				}
				
				
				data += "Mouse Position X, " +  "Mouse Position Y, " + "Launch Button, " + "Briefing Button, " + "Briefing Close Button, " + "Status Button, " + "Status Close Button, " + "Overlay Button, " + "View Target Button, " + "Target Detection Submit Button, " + " Target Detection Detection Close Button, " + "Red Unit to Blue Unit Switch Button, " + "Blue Unit to Red Unit Switch Button, " + "Blue Group Auto Mode Button, " + "Blue Group Button, Blue Group Seek Button, Blue Group Track Button, Red Group Auto Mode, Red Group Button, Red Group Seek Button, Red Group Track Button";
				
				
				data+= "\n";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		collect();
		
	}
	

	void collect(){
		
		String blueGroupData ="";
		String blueUnitsData ="";
		String redGroupData ="";
		String redUnitsData ="";
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int mousePositionX = (int) b.getX();
		int mousePositionY = (int) b.getY();
		
		
		// Unit data
		if (load.blueUnits.list.size() != 0) {
		    blueGroupData = groupData(load.blueUnits.list, load.blueUnits.isActive, "Blue");
		    
		    
		    blueUnitsData = unitsData(load.blueUnits.list, load.blueUnits.isActive, "Blue","ACTIVE");
		    
		    blueUnitsData += unitsData(load.blueUnits.inTransitList, true, "Blue","TRANSIT IN-PROGRESS");
		    ArrayList<Unit> blue = new ArrayList<Unit>();
		    
		    for(int i=0;i<Load.inActiveUnits.size();i++){
		    	if(Load.inActiveUnits.get(i).colorID==1){
		    		blue.add(Load.inActiveUnits.get(i));
		    	}
		    }
		    blueUnitsData+= unitsData(blue, true, "Blue","INACTIVE");
		}
		
		if (load.redUnits.list.size() != 0) {
		   redGroupData =  groupData(load.redUnits.list, load.redUnits.isActive, "Red");
		   redUnitsData =  unitsData(load.redUnits.list, load.redUnits.isActive, "Red","ACTIVE");
		   redUnitsData +=  unitsData(load.redUnits.inTransitList, load.redUnits.isActive, "Red","TRANSIT IN-PROGRESS");
		   
		   ArrayList<Unit> red = new ArrayList<Unit>();
		    
		    for(int i=0;i<Load.inActiveUnits.size();i++){
		    	if(Load.inActiveUnits.get(i).colorID==2){
		    		red.add(Load.inActiveUnits.get(i));
		    	}
		    }
		    redUnitsData +=  unitsData(red, load.redUnits.isActive, "Red","INACTIVE");
		   
		}
		
		
		// Target Data
		String targetData = targetData();
		
		//Timestamp
		// Convert the milliseconds since the epoch into a  
        // java.util.Date object.  
        Date instant = new Date( System.currentTimeMillis() );  
   
        // Set up a simple date format, to give the view  
        // of the date object that we want.  
        //SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss:SSS" );  
        SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
        // Define the String, time, to be our formatted  
        // view of the milliseconds since the epoch.  
        String time = sdf.format( instant );  
   
        // Print out this "view" of MSEC_SINCE_EPOCH.  
        //System.out.println( "Time: " + time );  
        
        int numberofunits = load.blueUnits.list.size() + load.redUnits.list.size();
        
        String text = Sea.targetInterceptedTitleLabel.getText();
        
        String arrScore[] = text.split(":");
        
        String text2 = Sea.resourcePoolAvailableLimit.getText();
        
        String resourcePool[] = text2.split(":");
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        
        
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
    	
    	//Loop to stop all the other threads while the unit is relocating
    	
    	for (int i=0;i<threadArray.length;i++){
    		
    		   			
    			if(threadArray[i].toString().contains("LaunchTimer") ){
    				numberofunits = numberofunits +1;
    			try{
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		
    		}
    	}
        
        
				
		data +=    time + ", "+
				  user.scenario + ", "+
				  user.number + ", "+ Load.targetList.size() + ", " + String.valueOf(numberofunits) + ", " + String.valueOf(Load.inActiveUnits.size()) + ", " + arrScore[1] + ", " + resourcePool[1] + ", " + " " + ", " +  
				  blueGroupData  + " " + ", "  + 
		          redGroupData  + " " + ", "  +
		          targetData +
		          blueUnitsData +
		          redUnitsData + String.valueOf(mousePositionX) + ", " + String.valueOf(mousePositionY) + ", " + Sea.launchButtonPressed + ", " + Sea.briefingButtonPressed + ", " + PilotTaskMessage.briefingCloseButtonPressed + ", " + Sea.statusButtonPressed + ", " + Status.statusClosedButtonPressed + ", "  + Sea.overlayButtonPressed
		          + ", " + Sea.viewTargetButtonPressed + ", " + TargetView.targetDetectionSubmitButtonPressed + ", " + TargetView.targetDetectionCloseButtonPressed + ", " + Sea.redToBlueSwitchButtonPressed + ", " + Sea.blueToRedSwitchButtonPressed + ", " + Sea.blueGroupAutoModeButtonPressed + ", " + Sea.blueGroupButtonPressed + ", " + Sea.blueGroupSeekModeButtonPressed + ", "  + Sea.blueGroupTrackModeButtonPressed + ", " +  Sea.redGroupAutoModeButtonPressed + ", " + Sea.redGroupButtonPressed + ", " + Sea.redGroupSeekModeButtonPressed + ", "  + Sea.redGroupTrackModeButtonPressed;
    	
    	
		          
		//data += "\n";          
		user.addData(data);
		
		data = "";
		
	}
	
	String groupData(ArrayList<Unit> list, boolean group, String color){
	   
	  
       String data = "";
       boolean seeking = false, tracking = false;
       
       if (list.size() != 0) {
		// Blue Unit Data
		int sumX = 0, sumY =0, bx, by; 
		
		// Group data
		for (Unit unit:list) {
			
			// Compute Center Point of blue group
			sumX+=unit.positionX;
			sumY+= unit.positionY;
		}
			// center point of blue Group
		    
		    bx = sumX/list.size();
			by = sumY/list.size();
			data += bx + "," + by + ", " ;
			
			double radius = 0;
			double min = 0; 	    	   
	    	double   max = 0; 
			
			if(color.compareTo("Blue") == 0) {
					
					min = (load.blueUnits.proximity * Constants.MINIMUM_DISTANCE_TWO_UNITS) 
			    			   +  Constants.MINIMUM_DISTANCE_TWO_UNITS;
			    	max = (load.blueUnits.proximity * Constants.MAX_DISTANCE_TWO_UNITS)
			    			+  Constants.MAX_DISTANCE_TWO_UNITS;
			    	
					radius = (int) ((load.blueUnits.searchRadius * Constants.SEARCH_RADIUS) +
							   Constants.SEARCH_RADIUS);
					seeking = load.blueUnits.isSeeking;
					tracking = load.blueUnits.isTracking;
			}
			
			if(color.compareTo("Red") == 0){
				min = (load.redUnits.proximity * Constants.MINIMUM_DISTANCE_TWO_UNITS) 
		    			   +  Constants.MINIMUM_DISTANCE_TWO_UNITS;
		    	max = (load.redUnits.proximity * Constants.MAX_DISTANCE_TWO_UNITS)
		    			+  Constants.MAX_DISTANCE_TWO_UNITS;
		    	
				radius = (int) ((load.redUnits.searchRadius * Constants.SEARCH_RADIUS) +
						   Constants.SEARCH_RADIUS);
				seeking = load.redUnits.isSeeking;
				tracking = load.redUnits.isTracking;
			}
			
			
			DecimalFormat df = new DecimalFormat("#.00");
		     
			data += df.format(min) + ", " + df.format(max) +  ", " + df.format(radius) + ", ";
		
			String state = "Nothing,";
			if (group) {
				if (seeking)
					state= "Seeking, ";
				else
					state= "Not Seeking, ";
				
				if (tracking)
					state= "Is Tracking,";
				else
					state =  "Not Tracking, ";
			}
		    
				
			data += state;
       }
			
       if(color.compareTo("Blue") == 0) {
    	   String groupname="";
    	  
    	   
    	   String blueText = Sea.blueUnitsTextField.getText();
    	   
    	   String arrBlueUnits[] = blueText.split(":");
    	   
    	   String blueUnits = arrBlueUnits[1].trim();
    	   
    	   String arr2[] = blueUnits.split(",");
    	   
    	   
    	   for(int i=0;i<arr2.length;i++){
    		   groupname += arr2[i] + " ";
    	   }
    	   
    	   
    	   data += arr2.length + ", ";
    	   int inactiveunits=0;
    	   
    	   for(int i=0;i<Load.inActiveUnits.size();i++){
    		   if(Load.inActiveUnits.get(i).colorID==1){
    			   inactiveunits = inactiveunits+1;
    		   }
    	   }
    	   data += inactiveunits + ", ";
    	   data+= groupname + ", ";
    	   
    	   
       }else{
    	   String groupname="";
    	   for(int i=0;i<load.redUnits.list.size();i++){
    		   groupname+= load.redUnits.list.get(i).id+ " ";
    	   }
    	   data += load.redUnits.list.size() + ", ";
    	   data+= groupname + ", ";
       }
		
		return data;
		
	}
	
	
	String unitsData(ArrayList<Unit> list, boolean group, String color,String status){
		
		String data = "";
		for (Unit unit:list) {
			if(unit.colorID==1){
				color="Blue";
			}else{
				color="Red";
			}
			
			String launchstatus="";
			data += color + ", " + unit.positionX +", " +
			unit.positionY + ", " + status + ", " + String.valueOf(unit.detectionRadius) + ", " + unit.targetDetected + ", " + String.valueOf(unit.speed) + "," +  "$" + unit.price + ", "; 
		}
		
		return data;
		
	}
	
   String targetData(){
	
			String data = "";
			
			for (Target target:Load.targetList) {
				
				data += target.level + "," + target.trueIdentity + ", " + target.markStatus + ", " + target.markedIdentity + "," +  String.valueOf(target.scoreGenerated) + ", " +
						target.positionX + "," + 
						target.positionY + ", ";
				
				if (load.targetDetectedLabel.getText().compareTo("") == 0)
					  data += "Undetected" + ", ";
					  else 
						data += "Detected" + ", ";	
				
				
				if (load.targetInterceptedLabel.getText().compareTo("") == 0)
					data += "Unintercepted" + ", ";
				  else 
					data += "Intercepted" + ", ";
				 }
			
			data +=  ", "; 
	   
			return data;
   }

   
   String scores(){
	
	   return null;
	   
   }
   
   
}
