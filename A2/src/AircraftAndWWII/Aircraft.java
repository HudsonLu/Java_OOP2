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
import driver.Transport;

/**
 * @author hudsonlu
 * 
 */
public class Aircraft extends Transport {

		/**
		 * price of the plane.
		 */
		public double price;
		/**
		 * Elevation in meters maximum.
		 */
		public double maxElevation;
		
		
		/**
		 * default constructor
		 */
		public Aircraft() {
			super();
			price = 0.0;
			maxElevation = 0.0;
		}

		/**
		 * @param price cost of the plane.
		 * @param maxElevation maximum elevation in km.
		 */
		public Aircraft(double price, double maxElevation) {
			super();
			this.price = price;
			this.maxElevation = maxElevation;
		}
		
		/**
		 * @param obj object of the same type as class
		 */
		public Aircraft(Aircraft  obj)
		{
			super();
			price = obj.price;
			maxElevation = obj.maxElevation;
		}

		@Override
		public String toString() {
			return " This object "+getClass()+ " cost $"+ price + ", and it has a maximum elevation of "+ maxElevation +". ";
			
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;
			Aircraft other = (Aircraft) obj;
			if (Double.doubleToLongBits(maxElevation) != Double.doubleToLongBits(other.maxElevation))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			return true;
		}


		
		
		
		
}
