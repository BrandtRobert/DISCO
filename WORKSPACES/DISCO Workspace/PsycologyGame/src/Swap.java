import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Swap {
	
	Load load;
	Random rand;
	
	public Swap(Load load){
		
		this.load = load;
	
	} // end of constructor
	
	/*void chnageTo (int index, ArrayList<Unit> fromList, ArrayList<Unit> toList) {
		
		int sumX = 0;
		int sumY = 0;
		boolean found = false;
		rand = new Random();
		
		int positionX = rand.nextInt(Constants.xBORDER);
		int positionY = rand.nextInt(Constants.lBORDER);
		
				
		// get the method to be moved
		Unit curretntUnit = fromList.get(index);
		fromList.remove(index); // remove the unit out of fromList
		load.unitList.remove(index);
		
		
		
		// find a proper position for the new unit in toList
		if (!toList.isEmpty() & toList.size() > 1) { // toList is not empty list
		    
			for (Unit unit:toList){
			   
				if (unit.id == curretntUnit.id) {
					positionX = unit.positionX;
					positionY = unit.positionY;
					toList.remove(unit); // remove the unit from list
					found = true;
					break;
					
				} else { // unit id is not in toList
				   
					  sumX+=unit.positionX;
					  sumY+=unit.positionY;
				   
				//}
			} // end of for loop
		   
		   	
		  // if (!found) { 
			    positionX = sumX/toList.size();
			    positionY = sumY/toList.size();
			    
		 //    } 
		   
		}  // end of if 
		
		else { // toList is empty list
			   
			   positionX = rand.nextInt(Constants.xBORDER);
			   positionY = rand.nextInt(Constants.yBORDER);
			
		} // end of else if
		
		
		
		// create a new unit to be added to toList	
		Unit newUnit = new Unit(curretntUnit.id, positionX, 
				positionY, curretntUnit.speed, curretntUnit.fuelpoints, 
				reverseColor(curretntUnit.colorID));
		
		Unit unit = new Unit(curretntUnit.id, positionX, 
				positionY, curretntUnit.speed, curretntUnit.fuelpoints, 
				reverseColor(curretntUnit.colorID), curretntUnit.detectionRadius);
		
		toList.add(unit); // add a new Unit into toList
		unit.flyTowardsCenterOfMass(toList);
		String color;
		if (unit.colorID == 1 ) {
			color = "Blue";
		} else {
			color = "Red";
		}
		
		load.keepUnitDistance(toList, color);
		
		Load.unitList.add(new Unit(curretntUnit.id, positionX, 
				positionY, curretntUnit.speed, curretntUnit.fuelpoints, 
				reverseColor(curretntUnit.colorID), curretntUnit.detectionRadius));
		
		updateStatus(fromList,toList);
		//load.render();
		//System.out.println( " Red List" + redUnitList.get(0).id + "  " + redUnitList.get(0).positionX);		
		
	
	}// end of method
	*/
	
/*	int reverseColor(int colorID){
		
		if (colorID == 1) {
			return 0; 
		} else {
			return 1;
		}
	} // end of method
	*/
	
		
	void updateComboBox(javax.swing.JComboBox b, UnitsController controller){
		
		String[] comboBoxList;
		ArrayList<Unit> list = new ArrayList<Unit>();
		list.addAll(controller.list);
		
		if (!controller.inTransitList.isEmpty())
		list.addAll(controller.inTransitList);
		
		
		if (list.size() >=1 ) { 
	    	int size = list.size() + 1;
	    	comboBoxList = new String[size];
	    	comboBoxList[0] = "";
            int index = 1;
       
           for (Unit u: list){
        	   comboBoxList[index] = u.id;
       	index++;
           }
           
           Arrays.sort(comboBoxList);
           
           b.setModel(new javax.swing.DefaultComboBoxModel(comboBoxList));
           
     	 } else {
     		b.setModel(new javax.swing.DefaultComboBoxModel(new String[] {""}));
     	 }
	}
	
	
void updateUnit (Unit unit, UnitsController toList,String movementType) {
		
		/*int sumX = 0;
		int sumY = 0;
		
		boolean found = false;
		rand = new Random();
		
		int positionX = rand.nextInt(Constants.xBORDER);
		int positionY = rand.nextInt(Constants.lBORDER);*/
		
        
            if (!toList.list.isEmpty() ) { // toList is not empty list
			
            	for (Unit u:toList.list){
			   	  if (u.id == unit.id) {
					//positionX = u.positionX;
					//positionY = u.positionY;
					//Load.unitList.remove(u);
					toList.list.remove(u);
					break;
				  }
            	
            	}
            }
		
		/*unit.positionX = positionX;
		unit.positionY = positionY;*/
            String unitType="";
           if(movementType.equals("Launch"))
           {
            
            if(unit.colorID==1){
            	unitType="BlueUnit"+unit.id+"LaunchTimer";
            	if(Load.activityFeed.getUnitLaunchStart().equals("Y"))
            	Sea.updatesTextArea.append("Unit Launch - Blue Unit (  " + unit.id + " )" + " is getting launched" + "\n\n");
            }else{
            	unitType="RedUnit"+unit.id+"LaunchTimer";
            	if(Load.activityFeed.getUnitLaunchStart().equals("Y"))
            	Sea.updatesTextArea.append("Unit Launch - Red Unit (  " + unit.id + " )" + " is getting launched" + "\n\n");
            }
           }else{
        	   
        	   if(unit.colorID==1){
               	unitType="BlueUnit"+unit.id+"LaunchTimer";
               	movementType="RedSwitch";
               	unit.isSwitch=true;
               	if(Load.activityFeed.getUnitSwitchStart().equals("Y"))
               	Sea.updatesTextArea.append("Unit Switch - Red Unit (  " + unit.id + " )" + " is getting switched to Blue Units" + "\n\n");
               }else{
               	unitType="RedUnit"+unit.id+"LaunchTimer";
               	movementType="BlueSwitch";
            	unit.isSwitch=true;
            	if(Load.activityFeed.getUnitSwitchStart().equals("Y"))
               	Sea.updatesTextArea.append("Unit Switch - Blue Unit (  " + unit.id + " )" + " is getting switched to Red Units" + "\n\n");
               }
           }
            
                       unit.startMoving(load, toList.center(), toList,unitType,movementType);
            

                       
}



void updateStatus (ArrayList<Unit> fromList, ArrayList<Unit> toList) {
	
	load.blueUnitsTextField.setText("");
	load.redUnitsTextField.setText("");
	
	// blue info
	int countBlue = 0;
	String blueID = "";
	
	// red info
	int countRed = 0;
	String redID = "";
	
	
	for (Unit unit:fromList){
		
		if (unit.colorID == 1) {
    		
    		countBlue++;
    		blueID += unit.id + ", ";
    		//color = "Blue";
    			    	
    	} else {
    		countRed++;
    		redID += unit.id + ", ";
    		
    	}
    	
		
	}
	
    
	for (Unit unit:toList){
		
         if (unit.colorID == 1) {
    		
    		countBlue++;
    		blueID += unit.id + ", ";
    		//color = "Blue";
    			    	
    	} else {
    		countRed++;
    		redID += unit.id + ", ";
    		
    	}
         
      
	 }
	
	
	load.blueUnitsTextField.setText("[" + countBlue + "]" + " Blue Units: " + blueID);
    load.redUnitsTextField.setText("[" + countRed + "]" + " Red Units: " + redID);
    
      
    /*// positioning units in each group
	 for (Unit u:toList)
    	  u.flyTowardsCenterOfMass(toList);
     load.keepDistance(toList);
      
     
     for (Unit u:fromList)
    	  u.flyTowardsCenterOfMass(fromList);
     load.keepDistance(fromList);*/

} // end of method


}
