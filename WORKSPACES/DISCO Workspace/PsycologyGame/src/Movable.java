import java.awt.Point;


public interface Movable {
	
	
	/*final static int xBORDER = 750;
	final static int yBORDER = 570;
	final static int lineBORDER = 450;
	final static int MAXFUELINGTIME = 5000;*/
		
	
	public void move(Target target);

	//public void move(Load load, Unit unit, Point center);
	
	public void move(Unit unit, UnitsController controller, Point center);
	
	

}
