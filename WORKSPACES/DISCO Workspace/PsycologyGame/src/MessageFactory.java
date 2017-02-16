
public class MessageFactory {
	
	Load load;
	
	MessageFactory (Load load){
		
		this.load = load;
		
	}
	
	void createMessage(UnitsController controller, int code){
		
		// 0 when new unit is loaded
		// 1 when units are active
		
		String color ;
        if ( controller.group.compareToIgnoreCase("Blue") == 0) {
		  color = "Blue";
		 } else {
		 color = "Red";
	     }
		
		 /*switch (code) {
		 
		 
		 
		 case 0: load.updatesTextArea.append(color + " Units " + 
		         " : are not seeking yet \n\n");
				 break; 
		 
		 case 1: load.updatesTextArea.append(color + " Units " +
				   " are active \n\n");
				  break; 
			     
		 
		 case 2: if (load.redUnits.isActive && load.blueUnits.isActive) {
			        load.updatesTextArea.append("Both the Red and Blue Units are seeking \n\n");
		          } else if  ( load.redUnits.isActive) {
		        	  load.updatesTextArea.append("Red Units are seeking \n\n");
		          } else if (load.blueUnits.isActive){
		        	  load.updatesTextArea.append("Blue Units are seeking \n\n");
		          } else {
		        	  load.updatesTextArea.append("None of the Red and Blue Units are seeking \n\n"); 
		          }
			      break;
		 
		 case 3: break;
		 
		 case 4: break;
		 
		 case 5: break;
		 
		 case 6: break;
			 
	     default:  load.updatesTextArea.append("Invald Message Code \n");
	               break; 
		 }*/
		
	}
	
	void createMessage(Target target, int code){
		
		// 0 when new target is loaded 
		
		 /*switch (code) {
		 
		 case 0:  load.updatesTextArea.append(" Target " +
				 target.id + ": is moving " +  target.movement + " \n\n");
				 break; 
		 
		 case 1: break;
		 
		 case 2: break;
		 
		 case 3: break;
		 
		 case 4: break;
		 
		 case 5: break;
		 
		 case 6: break;
			 
	     default:  load.updatesTextArea.append("Invald Message Code \n");
	               break; 
		 }*/
		
		
		
		
		
	}

}
