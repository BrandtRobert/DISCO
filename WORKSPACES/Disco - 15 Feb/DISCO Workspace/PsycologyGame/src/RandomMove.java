import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;


public class RandomMove implements Movable {
	 
	 Load load;
	 Random rand;
	 static double poolXValue=0;
	 static double poolYValue=0;
	 //final static int MAXFUELINGPOINTS = 100;
	 
	 //double leaderTheta;
	 
    
    // Constructor 
    RandomMove(long seed, Load load){
    	 rand = new Random();
    	 rand.setSeed(seed);
    	 this.load = load;
    }
	
    // moving targets 
    @Override
	public void move(Target target) {
    	int maxStepSize = target.speed;
    	double direction = Math.PI / (5 - rand.nextInt(10));
    	int fuel = 0;
    	 
    	while (true) {
    		   		          	 
                		 
    		direction = nextStep (target,direction,maxStepSize);
    		
    		fuel++;
    		
    		if (fuel == Constants.MAXFUELINGPOINTS){
    			
    			fuel = 0;
    			 try {
                     Thread.sleep (Constants.MAXFUELINGTIME);
                 }
                 catch (InterruptedException e) {
                     //break;
                 }
    			
    		}
    		

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
    
    double  nextStep (Target target, double d, int maxStepSize){
    	double direction = d;
    	int locationX = (int) (target.positionX + maxStepSize * Math.cos (direction));
    	int locationY = (int) (target.positionY + maxStepSize * Math.sin (direction));
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
    	
    	
    	if ((locationX < 2) || (locationX > Constants.xBORDER-2)
    	    || (locationY < 2) || (locationY > Constants.yBORDER-2)) {
    	    // Change direction: either opposite, or random.
    	    if (RandTool.uniform() < 0.5) {
    		direction = RandTool.uniform (0.0, Math.PI);
    	    }
    	    else {
    		// Opposite.
    		//direction = 2*Math.PI - direction;
    	    }
    	   locationX = target.positionX;
    	   locationY = target.positionY;
    	}
    	
    	target.positionX = locationX;
    	target.positionY = locationY;
    	return direction;
    	
    }

	@Override
	public void move(Unit unit, UnitsController controller, Point center) {
		// TODO Auto-generated method stub
		
	}


    
    
   /* // unit seeking
    public void move(Unit unit, Point center, double searchRadius) {
    	
    	int maxStepSize = 5 * unit.speed;
    	double direction = Math.PI / rand.nextInt(10);
    	int fuel = 0;
    	 
    	while (Load.seeking) {
    		   		          	 
          direction = nextStep (unit,direction,maxStepSize,center, searchRadius);
    		fuel++;
    		
    		if (fuel == Constants.MAXFUELINGPOINTS){
    			
    			fuel = 0;
    			 try {
                     Thread.sleep (Constants.MAXFUELINGTIME);
                 }
                 catch (InterruptedException e) {
                     //break;
                 }
    			
    		}
    		

             // Sleep for animation effect.
             try {
                 Thread.sleep (100);
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
    	
    	int dis = (int) ((searchRedius * Constants.SEARCH_RADIUS) +
				   Constants.SEARCH_RADIUS);
    	
    	if ( Math.sqrt(center.distanceSq(locationX, locationY)) > (dis-20)) { //|| (unit.distance(center) > 200)
    	    // Change direction: either opposite, or random.
    	    if (RandTool.uniform() < 0.5) {
    		direction = RandTool.uniform (0.0, Math.PI);
    	    }
    	    else {
    		// Opposite.
    		direction = 2*Math.PI - direction;
    	    }
    	   locationX = unit.positionX;
    	   locationY = unit.positionY;
    	}
    	
    	unit.positionX = locationX;
    	unit.positionY = locationY;
    	return direction;
	}
*/
}
