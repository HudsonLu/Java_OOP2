/** 
 *  @author Hudson Xingcheng Lu
 *  @version 04 Saturday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 2
 * Due Date Saturday 04 February
*/
package driver;

import AircraftAndWWII.Aircraft;
import AircraftAndWWII.WorldWarIIAirplane;
import Ferry.Ferry;
import Metro.Metro;
import Monowheel.Monowheel;
import TrainAndTram.Train;
import TrainAndTram.Tram;
import WheeledTransportation.WheeledTransportation;

public class driver2 {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		//parametrized constructors
				Aircraft air2 = new Aircraft(12.5, 50);
				WorldWarIIAirplane WWII2 = new WorldWarIIAirplane(12.5, 60, true);
				Ferry ferry2 = new Ferry(123.3, 200.0);
				Metro metro2 = new 	Metro(12, 60.0 ,13 , "Toronto","Ottawa", 1999);
				Train train2 = new Train(12, 60.0 ,13, "Toronto","Ottawa");
				Tram tram2 = new Tram(12, 60.0 ,13 , "Toronto","Ottawa", 1999, 2003);
				Monowheel monowheel2 = new Monowheel(12, 60.0 ,13.8);
				WheeledTransportation wheel2 = new WheeledTransportation(12, 60.0);
				
				Aircraft air3 = new Aircraft(122.5, 50);
				WorldWarIIAirplane WWII3 = new WorldWarIIAirplane(129.5, 60, true);
				Ferry ferry3 = new Ferry(123.8, 200.0);
				Metro metro3 = new 	Metro(12, 60.0 ,13 , "Montreal","Ottawa", 1999);
				Train train3 = new Train(12, 60.0 ,13, "Gatineau","Ottawa");
				Tram tram3 = new Tram(123, 64.0 ,17 , "Toronto","Ottawa", 1999, 2003);
				Monowheel monowheel3 = new Monowheel(12, 60.0 ,13.8);
				WheeledTransportation wheel3 = new WheeledTransportation(12, 60.0);
				
				Transport[] originalArray = {monowheel3, air3,wheel3, ferry3,tram3, train3, metro3 , WWII3, monowheel2, air2, WWII2, ferry2, metro2, train2, tram2, wheel2 };
	
				
				Transport[] copiedArray = copyTheObjects(originalArray);
				
				System.out.println("Welcome to the second assignment: Part B!");
				System.out.println();	
				System.out.println("Original array: ");
				
				for (int i = 0; i < originalArray.length; i++)
				{
					System.out.println(originalArray[i].toString());
					
				}
				System.out.println();
				System.out.println("Copied array:");
				
				for (int j = 0; j < copiedArray.length; j++)
				{
					System.out.println(copiedArray[j].toString());
					
				}
		      
				System.out.println();
				System.out.println("Thank you for using this application!");
		    }
	
	
	public static Transport[] copyTheObjects(Transport[] originalArray) 
	{
        
		Transport[] copiedArray = new Transport[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) 
        {
        	copiedArray[i] = new Transport(originalArray[i]);
        }
        return copiedArray;
    }

}



	
