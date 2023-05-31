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

import WheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {

	public int numberOfVehicles;
	public String startingStation;
	public String destinationStation;

	public Train()
	{
		super();
		numberOfVehicles = 0;
		startingStation = null;
		destinationStation = null;
	}

	/**
	 * @param numberOfWheels
	 * @param maxSpeed
	 * @param numberOfVehicles
	 * @param startingStation
	 * @param destinationStation
	 */
	public Train(int numberOfWheels, double maxSpeed, int numberOfVehicles, String startingStation, String destinationStation) {
		super(numberOfWheels, maxSpeed);
		this.numberOfVehicles = numberOfVehicles;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
	}
	
	/**
	 * @param obj
	 */
	public Train(Train obj)
	{
		super(obj);
		numberOfVehicles = obj.numberOfVehicles;
		startingStation = obj.startingStation;
		destinationStation = obj.destinationStation;
	}

	@Override
	public String toString() {
		return super.toString() + "It has "+ numberOfVehicles + " vehicles and its starting and destination stations are "+ startingStation + " and "+ destinationStation +". ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (this.getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (destinationStation == null) {
			if (other.destinationStation != null)
				return false;
		} else if (!destinationStation.equals(other.destinationStation))
			return false;
		if (numberOfVehicles != other.numberOfVehicles)
			return false;
		if (startingStation == null) {
			if (other.startingStation != null)
				return false;
		} else if (!startingStation.equals(other.startingStation))
			return false;
		return true;
	}



	
	
	
	
	
	
	
	
}
