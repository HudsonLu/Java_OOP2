/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package Metro;

import TrainAndTram.Train;

public class Metro extends Train {
	
	public int yearOfCreation;

	
	public Metro() {
		super();
		yearOfCreation = 0 ;
	}



	/**
	 * @param numberOfWheels
	 * @param maxSpeed
	 * @param numberOfVehicles
	 * @param startingStation
	 * @param destinationStation
	 * @param yearOfCreation
	 */
	public Metro(int numberOfWheels, double maxSpeed, int numberOfVehicles, String startingStation, String destinationStation, int yearOfCreation) {
		super( numberOfWheels, maxSpeed, numberOfVehicles, startingStation, destinationStation);
		this.yearOfCreation = yearOfCreation;
	}

	/**
	 * @param obj
	 */
	public Metro(Metro obj)
	{
		super(obj);
		yearOfCreation = obj.yearOfCreation;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "The metro year of creation is "+ yearOfCreation + ". ";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		Metro other = (Metro) obj;
		if (yearOfCreation != other.yearOfCreation)
			return false;
		return true;
	}



	
	
	
	
	
	
}
