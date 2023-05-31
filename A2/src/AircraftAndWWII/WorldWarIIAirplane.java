/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package AircraftAndWWII;

/**
 * @author hudsonlu
 *
 */
public class WorldWarIIAirplane extends Aircraft{

	/**
	 * twinEngine check if it has twin engine.
	 */
	public boolean twinEngine = false;

	
	public WorldWarIIAirplane() {
		super();
		twinEngine = false;
		
	}
	

	/**
	 * @param price: cost of the aircraft.
	 * @param maxElevation: maximum elevation in meters.
	 * @param twinEngine: check whether it has a twin engine.
	 */
	public WorldWarIIAirplane(double price, double maxElevation, boolean twinEngine) {
		super(price, maxElevation);
		this.twinEngine = twinEngine;
	}
	
	/**
	 * @param obj object of the same type
	 */
	public WorldWarIIAirplane (WorldWarIIAirplane obj)
	
	{ 
		super(obj); 
		twinEngine = obj.twinEngine;
	}

	@Override
	public String toString() {
		return super.toString()+ "TwinEngine=" +twinEngine;
				
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj==null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		WorldWarIIAirplane other = (WorldWarIIAirplane) obj;
		if (twinEngine != other.twinEngine)
			return false;
		return true;
	}


	
	
	
}
