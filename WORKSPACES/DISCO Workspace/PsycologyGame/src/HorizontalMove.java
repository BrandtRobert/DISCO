import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;


public class HorizontalMove implements Movable {
    
	Load load;
	
	
	HorizontalMove (Load load){
		 this.load = load;	
		 
		}
	
	@Override
	public void move(Target target) {
		
		int maxStepSize = 5 * target.speed;
    	
    			
    	// to find fuel points
    	int current = target.positionX;
    	int fuel = target.fulePoints;
    	  	
    	    	
    	while (true) {
	        
    		maxStepSize = nextStep (target,maxStepSize);
    		
    		// checking the fuel points
    		if (current < target.positionX) {
    		  
    			 fuel = forwardFeuling(target, fuel);
    		
    		} else if (current > target.positionX) {
    			fuel = backwardFeuling(target, fuel);
    			
    		}
    			
    		// Sleep for animation effect.
             try {
                 Thread.sleep (100);
             }
             catch (InterruptedException e) {
                   // break;
             }
                		
            current = target.positionX; 
    		load.render();
             
       
        }
		
	}
    	// The previous movement algorithm
    	/*target.positionX+=target.fulePoints; // the movement
	    
		if (target.positionX >  xBORDER ) // hit border
	    {
	    	target.positionX=xBORDER;    	
	    	target.fulePoints=-target.fulePoints;	// change direction of velocity
	    	
	    } else if ( target.positionX < 0) {
	    	target.positionX -=target.fulePoints;        // undo movement target.fulePoints
	    	target.fulePoints=-target.fulePoints;    // change direction of velocity
	    }
	    
	    load.render();*/
		
	//}
	
	
	// find next fuel points in forward (left to right)
	int forwardFeuling(Target target, int fuel){
		
		if (fuel == 0) {
			fuel = target.fulePoints;

	     }
		
		
		if ( (target.positionX != 0) && (fuel / target.positionX) < 1 ) {
			
		     target.positionX = fuel;
			
			
			System.out.println(" Current Forward Fuling Point:  " + fuel
					+ " In Position: " + target.positionX);
			   
			fuel = fuel + target.fulePoints;
			
			try {
                Thread.sleep (Constants.MAXFUELINGTIME);
            }
            catch (InterruptedException e) {
                //break;
            }
			
		}  
		
		return fuel;
		
	}
	
	// find next fuel points in backward (right to left)
	int backwardFeuling(Target target, int fuel){
		
		if (fuel > ( ((Constants.xBORDER / target.fulePoints) -1) * target.fulePoints)) {
			fuel = ((Constants.xBORDER / target.fulePoints) -1) * target.fulePoints;

	     } 
		
		if ((target.positionX != 0) && ( fuel / target.positionX) >= 1  ){
			
			target.positionX = fuel;
			
			System.out.println(" Current Backward Fuling Point:  " 
			+ fuel  + " In Position: " + target.positionX);
		
			fuel = fuel - target.fulePoints; 
			
						
			try {
                Thread.sleep (Constants.MAXFUELINGTIME);
            }
            catch (InterruptedException e) {
                //break;
            }
		}
		
		return fuel;
	}
	

	
   int  nextStep (Target target, int maxStepSize){
	   
		   target.positionX+=maxStepSize;
	    
	   if (target.positionX > Constants.xBORDER || target.positionX < 0) // hit border
	    {
	    	target.positionX-=maxStepSize;        // undo movement
	    	maxStepSize=-maxStepSize;    // change direction of velocity
	    }
	   
	   return maxStepSize;
    	    	
    }

@Override
public void move(Unit unit, UnitsController controller, Point center) {
	// TODO Auto-generated method stub
	
}





}
