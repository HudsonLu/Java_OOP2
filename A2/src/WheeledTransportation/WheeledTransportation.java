/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package WheeledTransportation;
import driver.Transport;

public class WheeledTransportation extends Transport {

	public int numberOfWheels;
	public double maxSpeed;

	

	public WheeledTransportation()
	{
		numberOfWheels = 0;
		maxSpeed = 0;
	}
	
	/**
	 * @param numberOfWheels
	 * @param maxSpeed
	 */
	public WheeledTransportation(int numberOfWheels, double maxSpeed) {
		super();
		this.numberOfWheels = numberOfWheels;
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @param obj
	 */
	public WheeledTransportation(WheeledTransportation obj)
	{
		super(obj);
		numberOfWheels = obj.numberOfWheels;
		maxSpeed = obj.maxSpeed;
	}
	
	/**
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		WheeledTransportation other = (WheeledTransportation) obj;
		return Double.doubleToLongBits(maxSpeed) == Double.doubleToLongBits(other.maxSpeed)
				&& numberOfWheels == other.numberOfWheels;
	}

	@Override
	public String toString() {
		return " This object of " + getClass() + " has " + numberOfWheels + " wheels, has a maximum speed of "+ maxSpeed +" km/hr. ";
	}


	
	
	
	
		
	
}
