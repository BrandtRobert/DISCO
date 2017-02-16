import java.awt.Point;


public class VerticalMove implements Movable {
    
	Load load;
	
	
	VerticalMove (Load load){
	 this.load = load;	
	}
	
	@Override
	public void move(Target oval) {
		
		int maxStepSize = 5 * oval.speed;
    			
    	// to find fuel points
    	int current = oval.positionY;
    	int fuel = oval.fulePoints;
    	
    	
    	    	
    	while (true) {
	          	 
   		        		
    		maxStepSize = nextStep (oval,maxStepSize);
    		
    		
    		// checking the fuel points
    		if (current < oval.positionY) {
    		  
    			 fuel = downwardFeuling(oval, fuel);
    		
    		} else if (current > oval.positionY) {
    			fuel = upwardFeuling(oval, fuel);
    			
    		}
    			
    			// Sleep for animation effect.
             try {
                 Thread.sleep (100);
             }
             catch (InterruptedException e) {
                 //break;
             }
            
    		
            current = oval.positionY; 
    		load.render();
             
       
        }

		
		// The previous movement algorithm
		/*oval.positionY+=oval.fulePoints;
	    if (oval.positionY > yBORDER ) // hit border
	    {
	    	oval.positionY=yBORDER;        // undo movement oval.fulePoints
	    	oval.fulePoints=-oval.fulePoints;    // change direction of velocity
	    
	    } else if ( oval.positionY < 0) {
	    	oval.positionY -=oval.fulePoints;        // undo movement oval.fulePoints
	    	oval.fulePoints=-oval.fulePoints;    // change direction of velocity
	    }
	    
	    load.render();*/
		
	}
	
	
	// find next fuel points in forward (Top to Down)
		int downwardFeuling(Target oval, int fuel){
			
			// reset fueling point to the first fueling downward
			if (fuel == 0) {
				fuel = oval.fulePoints;

		     }
			
			
			if ( (oval.positionY != 0) && (fuel / oval.positionY) < 1 ) {
				
			     oval.positionY = fuel;
				
				
				System.out.println(" Current Forward Fuling Point:  " + fuel
						+ " In Position: " + oval.positionY);
				   
				// update next fueling point
				fuel = fuel + oval.fulePoints;
				
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
		int upwardFeuling(Target oval, int fuel){
			
			// reset fueling point to the first fueling upward
			if (fuel > ( ((Constants.yBORDER / oval.fulePoints) -1) * oval.fulePoints)) {
				fuel = ((Constants.yBORDER / oval.fulePoints) -1) * oval.fulePoints;

		     }
			
			if ((oval.positionY != 0) &&( fuel / oval.positionY) >= 1  ){
				
				oval.positionY = fuel;
				
				System.out.println(" Current Backward Fuling Point:  " 
				+ fuel  + " In Position: " + oval.positionY);
			
				fuel = fuel - oval.fulePoints; 
				
							
				try {
	                Thread.sleep (Constants.MAXFUELINGTIME);
	            }
	            catch (InterruptedException e) {
	                //break;
	            }
			}
			
			return fuel;
		}
		
		int  nextStep (Target oval, int maxStepSize){
			   			
			   oval.positionY+=maxStepSize;
			   
			    if (oval.positionY > Constants.yBORDER || oval.positionY < 0) // hit border
			    {
			    	oval.positionY-=maxStepSize;        // undo movement
			    	maxStepSize=-maxStepSize;    // change direction of velocity
			    }
			    
			    return maxStepSize;
		 }

		@Override
		public void move(Unit unit, UnitsController controller, Point center) {
			// TODO Auto-generated method stub
			
		}

		
		
	    	
	}
