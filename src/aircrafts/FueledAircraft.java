package aircrafts;

public class FueledAircraft extends Aircraft implements Refuelable{
	private double fuelTankCapacity;
	private double fuelAmount;
	private double fueltoRangeRatio;

	FueledAircraft(String brandAndModel, double aircraftPrice, double fuelTankCapacity, double fuelAmount,
			double fueltoRangeRatio) {
		super(brandAndModel, aircraftPrice);
		if (fuelTankCapacity < 10) {
			this.fuelTankCapacity = 10;
		} else {
			this.fuelTankCapacity = fuelTankCapacity;
		}

		if (fuelAmount < 0) {
			this.fuelAmount = 0;
		} else if (fuelAmount > fuelTankCapacity) {
			this.fuelAmount = fuelTankCapacity;
		} else {
			this.fuelAmount = fuelAmount;
		}

		if (fueltoRangeRatio < 1) {
			this.fueltoRangeRatio = 1;
		} else {
			this.fueltoRangeRatio = fueltoRangeRatio;
		}

	}

	public double getFuelTankCapacity() {
		return fuelTankCapacity;
	}

	public void setFuelTankCapacity(double fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}

	public double getFuelAmount() {
		return fuelAmount;
	}

	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public double getFueltoRangeRatio() {
		return fueltoRangeRatio;
	}

	public void setFueltoRangeRatio(double fueltoRangeRatio) {
		this.fueltoRangeRatio = fueltoRangeRatio;
	}

	public void fly(double km) {
		double range = getFuelAmount() * getFueltoRangeRatio();
		if (km < 0) {
			System.out.println("Fly Fueled Aircraft input is invalid !!");
		} else {
			double fuelUsed = km / getFueltoRangeRatio();
			if (km < range) {
				setFuelAmount(getFuelAmount() - fuelUsed);
				System.out.printf("Fueled Aircraft %s flew %.2f kilometers, %.2f liters of fuel left.%n",
						getBrandAndModel(), km, getFuelAmount());
				System.out.printf("Fueled Aircraft Current Range: %.2f kilometers%n%n",
						getFuelAmount() * getFueltoRangeRatio());

			} else {
				setFuelAmount(0);
				System.out.printf("Fueled Aircraft %s could only fly %.2f kilometers, 0.00 liters of fuel left.%n", getBrandAndModel(),
						range);
				System.out.printf("Fueled Aircraft Current Range: 0.00 kilometers%n%n");
			}
		}
	}

	public String toString() {
		return super.toString()
				+ String.format("Max Range: %.1f \n" + "Current Fuel Level: %.1f liters \n" + "Current Range: %.1f kms \n\n",
						getFuelTankCapacity() * getFueltoRangeRatio(), getFuelAmount(),
						getFuelAmount() * getFueltoRangeRatio());
	}
	
	public void refuel(double addedFuelAmount) {
		if(addedFuelAmount>0 && addedFuelAmount<fuelTankCapacity) {
			fuelAmount += addedFuelAmount;
			System.out.printf("Fueled Aircraft %s's tank is refueled! Added: %.2f liters of fuel!",getBrandAndModel(),addedFuelAmount);
			System.out.printf("Fueled Aircraft %s's Current Range: %.2f kms%n",getBrandAndModel(),getFuelAmount() * getFueltoRangeRatio());
		}
		else if ( addedFuelAmount>fuelTankCapacity) {
			fuelAmount = fuelTankCapacity;
			System.out.printf("Fueled Aircraft %s's tank is refueled! Added: %.2f liters of fuel!",getBrandAndModel(),addedFuelAmount);
			System.out.printf("Fueled Aircraft %s's Current Range: %.2f kms%n",getBrandAndModel(),getFuelAmount() * getFueltoRangeRatio());
		}
		else {
			System.out.println("Refuel tank level input is invalid !!");
		}
		
		
	}
}
