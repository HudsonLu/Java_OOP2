/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package TrainAndTram;
import Metro.Metro;

public class Tram extends Metro {

	public int yearOfCreation1;
	
	
	public Tram() {
		super();
		yearOfCreation1 = 0;
		// TODO Auto-generated constructor stub
	}


	
	/**
	 * @param numberOfWheels
	 * @param maxSpeed
	 * @param numberOfVehicles
	 * @param startingStation
	 * @param destinationStation
	 * @param yearOfCreation
	 * @param yearOfCreation1
	 */
	public Tram(int numberOfWheels, double maxSpeed, int numberOfVehicles, String startingStation, String destinationStation, int yearOfCreation, int yearOfCreation1) {
		super(numberOfWheels, maxSpeed, numberOfVehicles, startingStation, destinationStation, yearOfCreation);
		this.yearOfCreation1 = yearOfCreation1;
	}

	/**
	 * @param obj
	 */
	public Tram(Tram obj)
	{
		super(obj);
		yearOfCreation1 = obj.yearOfCreation1;
	}


	@Override
	public String toString() {
		return super.toString()+ "Its year of creation is "+ yearOfCreation1+ ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		Tram other = (Tram) obj;
		if (yearOfCreation != other.yearOfCreation)
			return false;
		return true;
	}
	
	
	
}
