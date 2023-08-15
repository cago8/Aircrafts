package aircrafts;

import java.util.ArrayList;

public class Glider extends Aircraft {
	protected static ArrayList<Glider> gliderList = new ArrayList<>();
	private Plane helperPlane;
	protected final static double MAX_AGE = 10;
	
	public static double getMaxAge() {
		return MAX_AGE;
	}

	public Glider(String brandAndModel, double aircraftPrice, Plane helperPlane) {
		super(brandAndModel, aircraftPrice);
		this.helperPlane = helperPlane;
		gliderList.add(this);
	}

	public static int getGliderQuantity() {
		return gliderList.size();
	}

	public String toString() {
		return "Aircraft Type: Glider \n" + super.toString() + String.format("Helper Plane: %s%n%n", helperPlane.getBrandAndModel());
	}

	public Plane getHelperPlane() {
		return helperPlane;
	}

	public void setHelperPlane(Plane helperPlane) {
		this.helperPlane = helperPlane;
	}
	
	public void fly(double km) {
		double range = helperPlane.getFuelAmount() * helperPlane.getFueltoRangeRatio();
		if (km < 0) {
			System.out.println("Fly Glider input is invalid !!%n%n");
		} else {
			if (km/4 < range) {
				helperPlane.fly(km/4);
				totalFlightDistance += km;
				System.out.printf("Glider %s flew %.1f kilometers.%n%n",getBrandAndModel(),km);
			} else {
				System.out.printf("Glider %s could not fly...%n%n",getBrandAndModel());
			}
		}
	}
}
