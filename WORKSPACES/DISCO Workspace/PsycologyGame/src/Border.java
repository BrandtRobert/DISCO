

// this class to check the border
public class Border {

	int unitToMove (Unit unitA, Unit unitB, double min) {
		
		if (leftBorder(unitA,unitB,min) != 0) {
			
			return leftBorder(unitA,unitB,min);
		
		} else if (rightBorder(unitA,unitB,min) != 0) {
			
			return rightBorder(unitA,unitB,min);
		
		} else if (topBorder(unitA,unitB,min) != 0) {
			
			return topBorder(unitA,unitB,min);
		
		} else if (lineBorder(unitA,unitB,min) != 0) {
			
			return lineBorder(unitA,unitB,min);
		}
		
		return 1;
	}
	
	int leftBorder(Unit unitA, Unit unitB, double min){
		if ( unitA.positionX - min < 0 || unitB.positionX - min < 0) // hit X border
	    {
			 	if ( unitA.positionX > unitB.positionX ) {
	    			
	    			return 1;
	    			
	    		} else {
	    			
	    			return 2;
	    		}
	   
	    } 
	    
		return 0;
	
	}
	
	int rightBorder(Unit unitA, Unit unitB, double min){
		if ( unitA.positionX + min > Constants.xBORDER 
				|| unitB.positionX + min > Constants.xBORDER) // hit X border
	    {
			 	if ( unitA.positionX < unitB.positionX ) {
	    			
	    			return 1;
	    			
	    		} else {
	    			
	    			return 2;
	    		}
	   
	    } 
	    
		return 0;
	}
	
	
	int topBorder(Unit unitA, Unit unitB, double min){
		
		if ( unitA.positionY - min < 0 || unitB.positionY - min < 0) // hit X border
	    {
			 	if ( unitA.positionY > unitB.positionY ) {
	    			
	    			return 1;
	    			
	    		} else {
	    			
	    			return 2;
	    		}
	   
	    } 
	    
		return 0;
	
	}
	
	
	int lineBorder(Unit unitA, Unit unitB, double min){
		if ( unitA.positionY + min > Constants.lBORDER 
				|| unitB.positionY + min > Constants.lBORDER) // hit X border
	    {
			 	if ( unitA.positionY < unitB.positionY ) {
	    			
	    			return 1;
	    			
	    		} else {
	    			
	    			return 2;
	    		}
	   
	    } 
	    
		return 0;
	}
	
}

