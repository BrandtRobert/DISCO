import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;


public class Unit {
	
	
		
	public String id;
	public int positionX;
	public int positionY;
	public int speed;
	public int fuelpoints;
	public int colorID; // it is '1' for blue units, '0' for red units 
	public BufferedImage image;
	public Point2D.Double location;
	public double detectionRadius;
	boolean isActive =true;
	public static boolean isSwitch=false;
	public static ArrayList<Timer> relocationThread = new ArrayList<Timer>();
	public String price="";
	public String targetDetected="N/A";
	public double relocationDetectRadius=0;
	public double relocationSpeed = 0;
	
	
	
	Unit (String id, int positionX, int positionY, int speed, int fuelpoints, int colorID, 
			double detectionRadius,String status,String price,double relocationDetectRadius, double relocationSpeed){
		
		
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		this.speed = speed;
		this.fuelpoints = fuelpoints;
		this.colorID = colorID;
		location =  new Point2D.Double(positionX,positionY);
		this.detectionRadius = detectionRadius;
		this.price=price;
		this.relocationDetectRadius = relocationDetectRadius;
		this.relocationSpeed = relocationSpeed;
		
		
		if(status.equalsIgnoreCase("ACTIVE")){
			this.isActive=true;
		}else{
			this.isActive=false;
		}
		
				
		if (colorID == 1 ) { // blue unit
		
		try {
			
			image = ImageIO.read(UserMain.class.getResourceAsStream("/Blue_Pentagon.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} else { // red unit
			try {
				
				image = ImageIO.read(UserMain.class.getResourceAsStream("/Red_Pentagon.png"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	}
	
	boolean scaleUnitDistance(ArrayList<Unit> list, double min, double max) {
		
		
		//for (int i =0; i< list.size(); i++)     
		//flyTowardsCenterOfMass(list);
		  
		Boolean stop = true;  
		
		for (Unit unit : list){ 
			if (this!= unit) {
					  
				  
				 if ( distance(unit)  > max ) {
			  
				      scaleMax(unit, max);
				      
				      stop = false;
	
			    }	
				
				if ( distance(unit)  < min ) {
					  					 
					     scaleMin(unit, min);
					     
					     stop = false;
			
					 }
			} //if 
				  
			} // for
	
		return stop;
		
	}
	   		  
   void scaleMax (Unit unit, double max) {
			  
			     Scaling scaling = new Scaling();
				 
				 
					 float[] point1= scaling.getPoint(this);
					 float[] point2= scaling.getPoint(unit);
					 
					 float scale = (float) max / (float) distance(unit) - 0.01f;
					 //System.out.println(" -- Scale Value " + scale);
					 
					 
					 scaling.scale(point1, point2, scale);
					 
					 scaling.setPoint(this,point1);
					 scaling.setPoint(unit,point2);
		} 
				 
			 
  void scaleMin (Unit unit, double min) {
				 
				 	 Scaling scaling = new Scaling();
					 Border border = new Border();
			         
					 float[] point1 = scaling.getPoint(this);
					 float[] point2 = scaling.getPoint(unit);
					 
					 float dis =(float) distance(unit);
					 if ( dis < 1) {
						 dis =1;
					 }
					 
					float scale =  ((float) min / dis) + 0.1f;
					 
					 
					if ( border.unitToMove(this,unit,min) == 1 ) {
					 
						 scaling.scale(point1, point2, scale);
					 } 
						 else { 
							 
							 scaling.scale(point2, point1, scale);
					 }
					 
										 
					 scaling.setPoint(this,point1);
					 scaling.setPoint(unit,point2);
					 
							 
				  
				}
				  
				
		
 
	
  double distance(Unit unit) {
				 
				 return  Math.sqrt(Math.pow((this.positionX-unit.positionX), 2) 
					        + Math.pow((this.positionY-unit.positionY), 2));
				 
			 }
		  
   
  public void move(double time, double vx, double vy, double weight) {
		this.positionX += vx * weight * time;
		this.positionY += vy * weight * time;
		
			}
 /*// Keep away from walls and other boids
	
public void keepAway(ArrayList<Unit> list) {
		
		int time = 250;
		double vx = 0;
		double vy = 0;

		// Do not try to keep away from himself
		for (Unit unit : list) {
			//double distance = boid.location.distance(location);
			double distance = distance(unit);
			if (unit != this && distance < Constants.keepAwayDistance) {
				// Handle degenerate case when boids are at the same location.
				if (distance < 1)
					distance = 1;

				// Make force inverse proportional to the distance.
				double s = 1 / distance;
				vx += s * (this.positionX - unit.positionX);
				vy += s * (this.positionY - unit.positionY );
			}
		}
		move(time, vx, vy, Constants.avoidNeibourthood);
	}*/
	
	public void flyTowardsCenterOfMass(ArrayList<Unit> list) {

		// Compute the perceive center.
		int time = 250;
		double x = 0;
		double y = 0;

		// Do not count self
		int n = list.size() - 1;
		for (Unit unit : list)
			if (unit != this) {
				x += unit.positionX;
				y += unit.positionY;
			}

		x /= n;
		y /= n;
		
		
		// Compute the vector toward center
		double vx = x - this.positionX;
		double vy = y - this.positionY;

		/*// If scared, fly AWAY from the center of mass
		if (flock.scared) {
			vx = -vx;
			vy = -vy;
		}*/
		move(time, vx, vy, Constants.holdFlockCenter);
	}

	
	
	// seeking for a target part
	void startSeeking(final Load load, final UnitsController controller, final ArrayList<Unit> list,String unitType){
		
		
		/*Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
    	
    	
    	Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
    	
    	//Loop to stop all the other threads while the unit is relocating
    	
    	for (int i=0;i<threadArray.length;i++){
    		
    		   			
    			if(threadArray[i].toString().contains(unitType)){
    			try{
    			threadArray[i].interrupt();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		
    		}
    	}
    	*/
    	
		
		       
		// seeking for a target within a search Radius
				final Timer timer = new Timer(unitType);
                
			     final TimerTask task = new TimerTask() {
			         @Override
			         public void run() {
			             
			        	 if(controller.isSeeking) {
			        		 
			        		 if ( load.offset.x == 0 && load.offset.y == 0 ){
			            	 
			        		 /*int sumX = 0, sumY = 0;
			            	 
			            	 for (Unit unit:list){
			            		 sumX+=unit.positionX;
			            		 sumY+=unit.positionY;
			            	 }
			            	 
			            	 int centerX = sumX/list.size();
			            	 int centerY = sumY/list.size();
			            	*/ seek(controller.center(), controller, load.randomSeeking);
			        	 
			        		 } else {
			        		 
			        			 seek(new Point(load.offset.x, load.offset.y), controller ,load.randomSeeking);
			        	 
			        		 }
			        		 
			             } else {
			                timer.cancel();
			                timer.purge();
			             }
			         }
			     };

			     timer.schedule(task, 0);
		
	}
	
	void seek(Point center, UnitsController controller, Movable movable){
		
		movable.move(this, controller, center);
	}
	
	
	
	// relocate Unit to another search area
	void startReLocation (final Load load, final UnitsController controller,String group){
		
		try{
		
		
			// seeking for a target within a search Radius
			
		final Timer timer1 = new Timer(group+this.id+"RelocationTimer");
		
        
	     final TimerTask task1 = new TimerTask() {
	         @Override
	         public void run() {
				             
				 // you can move to another location only if not tracking or a unit is in transit 
	        	 // to the group
	        	 
	        	 if(!controller.isSeeking && !controller.isTracking) {
				    	   
	        		 if (controller.group.compareToIgnoreCase("Blue") == 0)
				    	   reLocate(controller, load.reLocateBlue);
	        		 else if (controller.group.compareToIgnoreCase("Red") == 0)
	        			 reLocate(controller, load.reLocateRed);
				             
				       } else {
				            	//System.out.println("I am not relocating"); 
				                timer1.cancel();
				                timer1.purge();
				             }
				         
	         }
				     
	     };

				     timer1.schedule(task1, 0);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
	}
	
	void reLocate (UnitsController controller, Movable movable){
		movable.move(this, controller, controller.currentCenter);
	}
	
	
	
	// relocate Unit to another search area
		void startMoving (final Load load, final Point center, final UnitsController controller,String unitType,String movementType){
			
	        
				// seeking for a target within a search Radius
			final Timer timer1 = new Timer(unitType);
	        
		     final TimerTask task1 = new TimerTask() {
		         @Override
		         public void run() {
					             
					 // only move units to a group in case it is not tracking!      
		        	 if(!controller.isTracking) {
		        		 
					    	  moveUnit(center, controller, load.moveUnit);
					            
					       } else {
					            	//System.out.println("I am not relocating"); 
					                timer1.cancel();
					                timer1.purge();
					             }
					         
		         }
					     
		     };

					     timer1.schedule(task1, 0);

			
		}
		
		void moveUnit (Point center, UnitsController controller, Movable movable){
	    	   System.out.println("center "+center.toString());

			movable.move(this, controller, center);
		}

	
} // end of class



