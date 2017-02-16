import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.*;
import java.util.Timer;


public class Track {

    //int numSteps = 300;                 // Number of time-steps in simulation.

    Load load;
    UnitsController controller;
    Boolean run = true;
   // String currentGroup = "";
    //Timer timer;
    int numpoints;                  // unit data.
    Point[] points = null;
    int numNeighbors = 1;               // Each unit observes some of its neighbors.

    int leader = 0;                     // The current leader.
    //double direction = Math.PI/ 4;   // Current direction for leader.
    //double leaderChangeProb = 0.0;     // The probability that we'll change the leader.

    double randomMoveProb = 0;        // Sometimes, a unit moves in a random direction. // last updated
    int numMoveAttempts = 20;            // Move attempts before giving up. // last updated

    int[] maxStepSize ;               // Distance moved each step.
    int minDistSquare = 1;      
    //int radius = 10;                    // Drawing parameters.

    
    
   public void start (Load load, UnitsController controller){
    
     this.load = load;
     this.controller = controller;
     
       
     final Timer timer = new Timer();

     final TimerTask task = new TimerTask() {
         @Override
         public void run() {
             if(run) {
                simulate();
             } else {
                timer.cancel();
                timer.purge();
             }
         }
     };

     timer.schedule(task, 0);
     
  
   	 
   	}
    
    public void stop(){
    	
    	run = false;
    	controller.trackedTargetID= null;
    	
    }

  
    
    void loadUnits (ArrayList<Unit> list)
    {
	// Pick random locations.
    	numpoints = list.size() + 1;
        points = new Point [numpoints];
        maxStepSize = new int[numpoints];
        
        
        points[0] = new Point (controller.getTarget().positionX,
        		                  controller.getTarget().positionY);
        maxStepSize[0] = controller.getTarget().speed;
        int i = 1;
        
        for (Unit unit:list) {
	    
		int x = unit.positionX;
	    int y = unit.positionY;
	    points[i] = new Point (x,y);
	    maxStepSize[i] = 5 * unit.speed; // updated
	    i++;
	}
	
	
    
    }


    void simulate ()
    
    {
           	
        if (controller.isTracking && controller.trackedTargetID !=null) {
    	
        	loadUnits (controller.list);
    	            }
        	       
               
        while (run) {

            nextStep ();
            
            lostTarget();
            
                        
            // Sleep for animation effect.
            try {
                Thread.sleep (150);
            }
            catch (InterruptedException e) {
                break;
            }

            load.render ();
            
            
        } // keep looping to move units and targets
    
    }
    

  void lostTarget(){
    	
    	int sumX = 0, sumY =0, avgX=0, avgY = 0;
    	double  sumDetect =0, avgDetect = 0;
    	int i = 1;  
        
    	for (Unit unit:controller.list) {
    	    
    		unit.positionX = points[i].x;
    		unit.positionY = points[i].y;
    		
    		// count average of unit positions
    		sumX+= unit.positionX;
    		sumY+= unit.positionY;
    		sumDetect+= unit.detectionRadius;
    	    
    		i++;
    	}
        
       avgX = sumX / controller.list.size();
       avgY = sumY  / controller.list.size();
       avgDetect = sumDetect / controller.list.size();
        
        Point unitAVG = new Point(avgX,avgY);
        double dis = avgDetect;
        
           
       // stop tracking 
       if(Math.sqrt( unitAVG.distanceSq(new Point (controller.getTarget().positionX,
    		   controller.getTarget().positionY))) >= 2 * dis ) {
        
     		 
        		 controller.trackButton_clicked();
        		 load.offset.x = 0;
                 load.offset.y = 0;
                 controller.trackedTargetID = null;
                 
              } 
    }
    
    
  void nextStep ()
    {
        // First, compute the new locations, then copy them into points[] array.
	Point[] newLocations = new Point [numpoints];


        // Except for the leader, move the others towards neighbors.
	for (int i=0; i<numpoints; i++) {
	    if (i == leader) {
                // Apply different rules for leader.
            newLocations[leader] = moveLeader ();
	    }
            else {
            	
                newLocations[i] = crossBorder(moveOther (i));
            }
        }
        
        // Synchronous update for all.
        for (int i=0; i<numpoints; i++) {
            points[i] = newLocations[i];
        }
    }

    
    Point crossBorder (Point point){
    	
    	if (point.y > Constants.lBORDER-10) {
    		
    		return new Point (point.x,400); // it smaller than the lBORDER = 440
    		
    	
    	} else if (point.y < 2) {
    		
    		return new Point (point.x,1);
    		
    	} else if (point.x > Constants.xBORDER) {
    		
    		return new Point (Constants.xBORDER-2,point.y);
    	
    	} else if (point.x < 0) {
    		
    		return new Point (2,point.y);
    		
    	}	
    	
    	return new Point (point.x,point.y);
    }

    
    Point moveLeader () {
	
       	return new Point (controller.getTarget().positionX,
    			controller.getTarget().positionY);
    }
    

    Point moveOther (int i)
    {
        // Identify nearest neighbors.
        int[] neighbors = findNearestNeighbors (i);
        
        // Compute centroid.
        Point centroid = computeCentroid (neighbors);
        
      /*  if (RandTool.uniform() < randomMoveProb) {*/
        if(false){
            // Random move: pick a random direction.
            return randomMove (i);
        }
        else {
            // Apply rules.
            return applyRules (i, neighbors, centroid);
        }
               
    } 


    Point computeCentroid (int[] neighbors)
    {
        int sumX = 0, sumY = 0;
        for (int k=0; k<numNeighbors; k++) {
            sumX += points[neighbors[k]].x;
            sumY += points[neighbors[k]].y;
        }
        int centX = (int) ( (double) sumX / (double) numNeighbors);
        int centY = (int) ( (double) sumY / (double) numNeighbors);
        return new Point (centX, centY);
    }
    

    Point randomMove (int i)
    {
        double theta = RandTool.uniform (0.0, 2.0*Math.PI);
        int x = (int) (points[i].x + maxStepSize[i] * Math.cos (theta));
        int y = (int) (points[i].y + maxStepSize[i] * Math.sin (theta));
        return new Point (x,y);
    }


    Point applyRules (int i, int[] neighbors, Point centroid)
    {
        double centDist = Math.sqrt (distance (points[i].x, points[i].y, centroid.x, centroid.y));
        double maxAlpha = 1.0;
        if (centDist < (double) maxStepSize[i]) {
            maxAlpha = 1.0;
        }
        else {
            maxAlpha = (double) maxStepSize[i] / centDist;
        }
        
        boolean succ = false;
        double alpha = maxAlpha;
        int x=0,y=0;
        
        for (int m=0; m<numMoveAttempts; m++) {
            // Compute new x,y.
            int tempX = (int) (points[i].x + alpha * (centroid.x - points[i].x));
            int tempY = (int) (points[i].y + alpha * (centroid.y - points[i].y));
            int setDist = setDistance (tempX, tempY, neighbors);
            if (setDist > minDistSquare) {
                // Valid.
                x = tempX;
                y = tempY;
                succ = true;
                break;
            }
            // Otherwise, try a smaller move.
            alpha = alpha / 2.0;
        }
        
        // If not successful, try moving away from centroid.
        alpha = maxAlpha;
        if (!succ) {
            x = (int) (points[i].x - alpha * (centroid.x - points[i].x));
            y = (int) (points[i].y - alpha * (centroid.y - points[i].y));
        }

        return new Point (x,y);
    }

    
    int[] findNearestNeighbors (int i)
    {
	int[] neighbors = new int [numNeighbors];
	int current = i;
	for (int k=0; k<numNeighbors; k++) {
	    current = nextpoint (current);
	    neighbors[k] = current;
	}
	return neighbors;
    }


    int nextpoint (int i) 
    {
	if (i < numpoints-1) {
	    return i+1;
	}
	else {
	    return 0;
	}
    }


    int distance (int x1, int y1, int x2, int y2) 
    {
	return ( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) );
    }


    int setDistance (int x, int y, int[] neighbors) 
    {
	// Distance to closest neighbor.
	Point p = points[neighbors[0]];
	int min = distance (x, y, p.x, p.y);
	for (int k=1; k<numNeighbors; k++) {
	    p = points[neighbors[k]];
	    int d = distance (x,y, p.x, p.y);
	    if (d < min) {
		min = d;
	    }
	}
	return min;
    }

}  // End Class Track

    
  