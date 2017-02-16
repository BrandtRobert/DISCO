
public class UncertinityDetection {
	
	
	boolean targetDetected(double currentDis, double detectDis, double performance){
		
		//System.out.println("Uncertain Performance"+ performance);
		//System.out.println("Current= " + currentDis + "  DetectDistance= " + detectDis);
		
		if (currentDis > detectDis)
			return false;
		
		
		double prop = ((detectDis - currentDis) / 100) * performance;
		double rand = Math.random();
		
		
		if (rand < prop)
			return true;
		else 
			return false;

	}
	
	double areaPerformance(){
		
		double r = Math.random();
		double[] performanceLevel = {0.25, 0.5, 0.75, 1.0};
		
		
		double cdf = 0.0;
		for (int i = 0; i < performanceLevel.length; i++) {
		    cdf += 0.25;
		    if (r < cdf) {
		        return performanceLevel[i];
		    }
		}
		
		return performanceLevel[performanceLevel.length - 1];
	}

}
