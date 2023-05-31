/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package Monowheel;

import WheeledTransportation.WheeledTransportation;

public class Monowheel extends WheeledTransportation {
	
	public double maxWeight;

	
	public Monowheel()
	{}


	/**
	 * @param numberOfWheels
	 * @param maxSpeed
	 * @param maxWeight
	 */
	public Monowheel(int numberOfWheels, double maxSpeed, double maxWeight) {
		super(numberOfWheels, maxSpeed);
		this.maxWeight = maxWeight;
	}

	/**
	 * @param obj
	 */
	public Monowheel(Monowheel obj) {
		super(obj);
		maxWeight = obj.maxWeight;
	}


	@Override
	public String toString() {
		return super.toString()+ "It has a maximum weight of "+ maxWeight + " .";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		Monowheel other = (Monowheel) obj;
		return Double.doubleToLongBits(maxWeight) == Double.doubleToLongBits(other.maxWeight);
	}

	

	
	
	
	
	
	
	
	
	
	
}
