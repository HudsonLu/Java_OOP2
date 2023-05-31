/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package Ferry;
import driver.Transport;


public class Ferry extends Transport {

	public double maxSpeed;
	public double maxLoad;
	


	
	public Ferry() {
		super();
		maxSpeed = 0.0;
		maxLoad = 0.0;
		
	}
	
	
	/**
	 * @param maxSpeed
	 * @param maxLoad
	 */
	
	public Ferry(double maxSpeed, double maxLoad) {
		super();
		this.maxSpeed = maxSpeed;
		this.maxLoad = maxLoad;
	}
	
	/**
	 * @param obj
	 */
	public Ferry (Ferry obj)
	{
		super(obj);
		maxSpeed = obj.maxSpeed;
		maxLoad = obj.maxLoad;
	}
	

	@Override
	public String toString() {
		return " This object " + getClass() +" has a maximum speed of " + maxSpeed + " km/hr, a maximum load of " + maxLoad + " kg.";	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		
		Ferry other = (Ferry) obj;
		return (this.maxSpeed == other.maxSpeed && this.maxLoad == other.maxLoad);
		
	}
	
	
	
	
	
}
