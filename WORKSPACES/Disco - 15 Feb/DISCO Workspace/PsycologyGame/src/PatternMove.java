import java.awt.Point;


public class PatternMove implements Movable{
	int dimeter;

	@Override
	public void move(Target oval) {
		
		if (oval.movement.compareToIgnoreCase("Vertical") == 0){
			
			//int fuels = (750 / oval.fulePoints + 1);
			vertical(oval);
			
		} else if (oval.movement.compareToIgnoreCase("Horizontal") == 0){
			
			horizontal(oval);
			
		}
		// TODO Auto-generated method stub
		
	}
	
	public void vertical(Target oval) {
		
		//System.out.println(" --  vertical -- "  );
		//dimeter = oval.image.getWidth();
		
		oval.positionY+=oval.fulePoints;
	    if (oval.positionY > Constants.yBORDER ) // hit border
	    {
	    	oval.positionY= Constants.yBORDER;        // undo movement oval.fulePoints
	    	oval.fulePoints=-oval.fulePoints;    // change direction of velocity
	    } else if ( oval.positionY < 0) {
	    	oval.positionY -=oval.fulePoints;        // undo movement oval.fulePoints
	    	oval.fulePoints=-oval.fulePoints;    // change direction of velocity
	    }
	    	
		
	}
	
	public void horizontal(Target oval) {
		
		 	  //  dimeter = oval.image.getWidth();
				
				oval.positionX+=oval.fulePoints;
			    if (oval.positionX >=  Constants.xBORDER ) // hit border
			    {
			    	oval.positionX=Constants.xBORDER;    	
			    	oval.fulePoints=-oval.fulePoints;	// change direction of velocity
			    	
			    } else if ( oval.positionX < 0) {
			    	oval.positionX -=oval.fulePoints;        // undo movement oval.fulePoints
			    	oval.fulePoints=-oval.fulePoints;    // change direction of velocity
			    }
	}

	@Override
	public void move(Unit unit, UnitsController controller, Point center) {
		// TODO Auto-generated method stub
		
	}


	
}
