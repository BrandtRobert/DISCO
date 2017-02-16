import java.util.ArrayList;


public class UnitsDistance {
	
	
void groupDistance(UnitsController controller) {
    	
    	
    	if (controller.list.size() > 1)   {
    	   
    		double min =   Constants.MINIMUM_DISTANCE_TWO_UNITS;
    	    double max =   Constants.MAX_DISTANCE_TWO_UNITS; 
    	   
    	     	   
    	   if ( controller.proximity > 0 ) {
    		   
    		   
    		   min = (controller.proximity * Constants.MINIMUM_DISTANCE_TWO_UNITS) 
    			   +  Constants.MINIMUM_DISTANCE_TWO_UNITS;
    	   
    		   max = (controller.proximity * Constants.MAX_DISTANCE_TWO_UNITS) 
    			   +  Constants.MAX_DISTANCE_TWO_UNITS;
    		
    	   } 
    	   
    	   keepDisatnce(controller.list,min,max);
    	   
    	}  
          
    } // method ends


void allUnitsDistance(ArrayList<Unit> list) {
	 
	   double min = Constants.MINIMUM_DISTANCE_TWO_UNITS;
	   double max = 800;
	   
	 keepDisatnce(list,min,max);
	  
	} // method end

	
void keepDisatnce (ArrayList<Unit> list, double min, double max) {
	
	 boolean stop = false;
     
	  for (int i =0; i < list.size(); i++ ) {
  	  if (!stop) {
  		   stop = true;
             for (Unit u :list) { // inner loop
          	   //u.flyTowardsCenterOfMass(list);
          	  stop &=u.scaleUnitDistance(list,min,max);
  	  		}
             
             
  	   } else {
  		   
  		 return;

     		}
 	  
     } // outer loop 
	} // 1st if statement

}


