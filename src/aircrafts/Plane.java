package aircrafts;

import java.util.ArrayList;

public class Plane extends FueledAircraft{
	protected static ArrayList<Plane> planeList = new ArrayList<>();
	protected final static double MAX_AGE = 20;
	
	public Plane(String brandAndModel, double aircraftPrice, double tank, double fuel, double ratio) {
		super(brandAndModel, aircraftPrice, tank, fuel, ratio);
		planeList.add(this);
	}
	
	public static double getMaxAge() {
		return MAX_AGE;
	}

	public static int getPlaneQuantity() {
		return planeList.size();
	}
	
	public String toString() {
		return "\nAircraft Type: Plane\n" + super.toString(); 
	}
}
