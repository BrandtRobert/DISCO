

public class Scaling{
	public void translate(float[] point, float xDistance, float yDistance){
		point[0] = point [0] - xDistance;
		point[1] = point [1] - yDistance;
	}

	public static void scale(float[] point, float scaleRate){
		point[0] = point[0] * scaleRate;
		point[1] = point[1] * scaleRate;
	}

	public void scale(float[] point1, float[] point2, float scaleRate){
		float[] distanceToZero 	= new float[2];
		
		
		distanceToZero[0]		= point2[0];
		distanceToZero[1]		= point2[1];
		
		
		
		
		//translate to origin
		translate(point1, distanceToZero[0], distanceToZero[1]);
		translate(point2, distanceToZero[0], distanceToZero[1]);
		//scale to origin
		scale(point1,scaleRate);
		scale(point2,scaleRate);
		//translate back from origin
		translate(point1, -distanceToZero[0], -distanceToZero[1]);
		translate(point2, -distanceToZero[0], -distanceToZero[1]);
		
	}
	
	
	float[] getPoint (Unit unit){
		float[] point={unit.positionX,unit.positionY};
		return point  ;
	}
	
	void setPoint (Unit unit, float[] point){
		
		unit.positionX = (int) point[0]; 
		unit.positionY = (int) point[1];		
	}
	
	
}