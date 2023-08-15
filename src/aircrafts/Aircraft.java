package aircrafts;

import java.util.ArrayList;

public abstract class Aircraft implements Flyable {
	protected static ArrayList<Aircraft> aircraftList = new ArrayList<>();
	protected String brandAndModel;
	protected double aircraftPrice;
	protected double totalFlightDistance;
	protected double age;
		
	

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public static int getAircraftQuantity() {
		return aircraftList.size();
	}

	public String getBrandAndModel() {
		return brandAndModel;
	}

	public void setBrandAndModel(String brandAndModel) {
		this.brandAndModel = brandAndModel;
	}

	public double getAircraftPrice() {
		return aircraftPrice;
	}

	public void setAircraftPrice(double aircraftPrice) {
		this.aircraftPrice = aircraftPrice;
	}

	public double getTotalFlightDistance() {
		return totalFlightDistance;
	}

	public void setTotalFlightDistance(double totalFlightDistance) {
		this.totalFlightDistance = totalFlightDistance;
	}

	public static ArrayList<Aircraft> getAircraftList() {
		return aircraftList;
	}

	public static void setAircraftList(ArrayList<Aircraft> aircraftList) {
		Aircraft.aircraftList = aircraftList;
	}

	public abstract void fly(double km);

	public Aircraft(String brandAndModel, double aircraftPrice) {
		if (brandAndModel == null || brandAndModel.isEmpty()) {
			this.brandAndModel = "Anonymous";
		} else {
			this.brandAndModel = brandAndModel;
		}

		if (aircraftPrice < 0) {
			this.aircraftPrice = 0;
		} else {
			this.aircraftPrice = aircraftPrice;
		}
		this.
		aircraftList.add(this);
	}
	
	public String toString() {
		return String.format(
				"Name: %s \n"
				+ "Price: %.1f $ \n"
				+ "Total Flight Distance: %.1f \n",
				getBrandAndModel(),getAircraftPrice(),getTotalFlightDistance());
	}
}
