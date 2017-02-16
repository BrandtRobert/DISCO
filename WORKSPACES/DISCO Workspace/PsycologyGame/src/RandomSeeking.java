
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;


public class RandomSeeking implements Movable {
	 
	 Load load;
	 Random rand;
	 static double poolXValue=0;
	 static double poolYValue=0;
	 Point blueCenter;
	 Point redCenter;
	 //final static int MAXFUELINGPOINTS = 100;
	 
	 //double leaderTheta;
	 
    
    // Constructor 
    RandomSeeking(long seed, Load load){
    	 rand = new Random();
    	 rand.setSeed(seed);
    	 this.load = load;
     }

	
 // unit seeking
    public void move(Unit unit, UnitsController controller, Point center) {
    	int maxStepSize = unit.speed;
    	double direction = Math.PI / rand.nextInt(10);
    	
    	if(unit.colorID==1){
    		Sea.blueUnits.currentCenter = center;
    		
    	}else{
    		Sea.redUnits.currentCenter=center;
    	}
    	//int fuel = 0;
    	 
    	
    	
    	while (controller.isSeeking) {
    		
    		/*if(unit.colorID==1){
    			if(blueCenter==null)
    				blueCenter=center;
    		}else{
    			if(redCenter==null)
    				redCenter=center;
    		}
    		if(unit.colorID==2){
        		System.out.println(redCenter.x + " After " + redCenter.y);
        	}
    		
    		if(unit.colorID==1){
    		direction = nextStep (unit,direction,maxStepSize, blueCenter, controller.searchRadius);
    		}else{
    			direction = nextStep (unit,direction,maxStepSize, redCenter, controller.searchRadius);
    		}*/
    		
    		
    		direction = nextStep (unit,direction,maxStepSize, center, controller.searchRadius);
    	//	System.out.println("Unit Detect Radius while seeking " + unit.detectionRadius);
    		/*fuel++;
    		
    		if (fuel == Constants.MAXFUELINGPOINTS){
    			
    			fuel = 0;
    			 try {
                     Thread.sleep (Constants.MAXFUELINGTIME);
                 }
                 catch (InterruptedException e) {
                     //break;
                 }
    			
    		}*/
    		

             // Sleep for animation effect.
             try {
            	 Thread.sleep (200);
             }
             catch (InterruptedException e) {
                 //break;
             }

             load.render();
        }
    }

	private double nextStep(Unit unit, double d, int maxStepSize, Point center, double searchRedius) {
		
		double direction = d;
		


    	int locationX = (int) (unit.positionX + maxStepSize * Math.cos (direction));
    	int locationY = (int) (unit.positionY + maxStepSize * Math.sin (direction));
    	String directionString = String.valueOf(direction);
    	
    	
    	
    	if(!directionString.contains("Infinity")){
    	poolXValue = poolXValue + maxStepSize * Math.cos (direction);
    	locationX=locationX+(int)poolXValue;
    	locationY=locationY+(int)poolXValue;
    	if(poolXValue>1){
    		poolXValue = poolXValue-1;
    	}else if(poolXValue<-1){
    		poolXValue=poolXValue+1;
    	}
    	
    	poolYValue = poolYValue + maxStepSize * Math.sin (direction);
    	locationX=locationX+(int)poolYValue;
    	locationY=locationY+(int)poolYValue;
    	if(poolYValue>1){
    		poolYValue = poolYValue-1;
    	}else if(poolYValue<-1){
    		poolYValue=poolYValue+1;
    	}
    	}
    	int dis = (int) ((searchRedius * Constants.SEARCH_RADIUS) +
				   Constants.SEARCH_RADIUS);
    	
    	if ( (Math.sqrt(center.distanceSq(locationX, locationY)) > (dis/2)) //|| (unit.distance(center) > 200)
    			|| (locationX < 2 || (locationX > Constants.xBORDER-2) // passing x Border
        	    || (locationY < 2) || (locationY > Constants.lBORDER))) // passing y border
    	{ 
    	    // Change direction: either opposite, or random.
    	    if (RandTool.uniform() < 0.5) {
    		
    	    	direction = RandTool.uniform (0.0, Math.PI);
    	    	
    	    } else {
    		
    	    	// Opposite.
    			   direction = 2*Math.PI - direction;
    	    
    	    }
    	       	    
    	    int x = rand.nextInt(5);
    	    //System.out.println( " -- x -- " + x);
    	    switch (x) {
    	    
    	    case 0: locationX = unit.positionX ;
                    locationY = unit.positionY ;
	       	        break;
    	    
    	    case 1: locationX = unit.positionX - rand.nextInt(4);
    	            locationY = unit.positionY - rand.nextInt(4);	
    	            break;
    	            
    	    case 2: locationX = unit.positionX + rand.nextInt(4);
                    locationY = unit.positionY + rand.nextInt(4);	
                    break; 
                    
    	    case 3: locationX = unit.positionX + rand.nextInt(4);
                    locationY = unit.positionY - rand.nextInt(4);	
                    break; 
                   
    	    case 4: locationX = unit.positionX - rand.nextInt(4);
                    locationY = unit.positionY + rand.nextInt(4);	
                    break;
                    
                    
            default: break;
    	    	
    	    }
    	}
    	
    	
    
    	
    	
    	
    	unit.positionX = locationX;
    	unit.positionY = locationY;
    	return direction;
	}


	@Override
	public void move(Target target) {
		// TODO Auto-generated method stub
		
	}



}