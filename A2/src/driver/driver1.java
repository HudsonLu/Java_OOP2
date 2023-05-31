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

public class driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aircraft air1 = new Aircraft(7212.5, 70);
		WorldWarIIAirplane WWII1 = new WorldWarIIAirplane(423.5, 90, true);
		Ferry ferry1 = new Ferry(1232.3, 200.0);
		Metro metro1 = new 	Metro(12, 60.0 ,13 , "Toronto","Ottawa", 1999);
		Train train1 = new Train(12, 60.0 ,13, "Toronto","Ottawa");
		Tram tram1 = new Tram(12, 60.0 ,13, "Toronto","Ottawa", 1999, 2003);
		Monowheel monowheel1 = new Monowheel(12, 60.0 ,13.8);
		WheeledTransportation wheel1 = new WheeledTransportation(12, 60.0);
		
		//parametrized constructors
		Aircraft air2 = new Aircraft(921.5, 530);
		WorldWarIIAirplane WWII2 = new WorldWarIIAirplane(43.5, 60, true);//
		Ferry ferry2 = new Ferry(123.3, 200.0);
		Metro metro2 = new 	Metro(12, 60.0 ,13, "Toronto","Ottawa", 1999);
		Train train2 = new Train(12, 60.0 ,13, "Toronto","Ottawa");
		Tram tram2 = new Tram(12, 60.0 ,13 , "Toronto","Ottawa", 1999, 2003);
		Monowheel monowheel2 = new Monowheel(12, 60.0 ,13.8);
		WheeledTransportation wheel2 = new WheeledTransportation(15, 60.0);
		
		Aircraft air3 = new Aircraft(1222.5, 50);
		WorldWarIIAirplane WWII3 = new WorldWarIIAirplane(129.5, 60, false);
		Ferry ferry3 = new Ferry(123.8, 200.0);
		Metro metro3 = new 	Metro(12, 60.0 ,13 , "Montreal","Ottawa", 1999);
		Train train3 = new Train(12, 60.0 ,13, "Gatineau","Ottawa");
		Tram tram3 = new Tram(123, 64.0 ,17 , "Toronto","Ottawa", 1999, 2003);
		Monowheel monowheel3 = new Monowheel(12, 60.0 ,13.8);
		WheeledTransportation wheel3 = new WheeledTransportation(12, 60.0);
		
		Transport[] array1 = {air1, air3, WWII3,  WWII1, ferry1, monowheel2, monowheel1, metro1, train1, tram1, wheel1, air2, WWII2, ferry2, metro2, train2, tram2, wheel2 };
		Transport[] array2 = {ferry1, monowheel3, metro1, train1, tram1, monowheel2, monowheel1, wheel1, ferry2, metro2, train2, tram2, wheel2, ferry3, metro3, train3, tram3, wheel3 };
		

		System.out.println("Welcome to the second assignment: Part A!");
		System.out.println();	
		System.out.println("First array: ");
		
		for (int i = 0; i < array1.length; i++)
		{
			System.out.println(array1[i].toString());
			
		}
		System.out.println();
		System.out.println("Second array:");
		
		for (int j = 0; j < array2.length; j++)
		{
			System.out.println(array2[j].toString());
			
		}
		
		System.out.println();
		System.out.println(air1.equals(null)); // False
		System.out.println(WWII1.equals(air1)); // False
		System.out.println(air1.equals(air1)); // True
		System.out.println(WWII3.equals(WWII2)); // False
		System.out.println(ferry1.equals(air1)); // False
		System.out.println(train1.equals(wheel1)); // False
		System.out.println(train1.equals(monowheel1)); // False
		System.out.println(train2.equals(wheel1)); // False
		System.out.println(train3.equals(monowheel2)); // False
		System.out.println(metro2.equals(train2)); // False 
		System.out.println(train2.equals(metro2)); // False
		System.out.println(train2.equals(wheel1)); // False
		System.out.println(train3.equals(monowheel1)); // False
		System.out.println(tram1.equals(metro1)); // False
		System.out.println(train1.equals(train2)); // True   
		System.out.println(tram1.equals(wheel1)); // False 
		System.out.println(wheel1.equals(tram1)); // False 
		System.out.println(wheel1.equals(wheel2)); //False
		
		System.out.println();
		System.out.println("For the first array :\n" +findLeastAndMostExpensiveAircraft(array1) );
		System.out.println();
		System.out.println("For the second array has " +findLeastAndMostExpensiveAircraft(array2) );
		
		System.out.println();
		System.out.println("Thank you for using this application!");
		
	}
	
	
	
	public static String findLeastAndMostExpensiveAircraft(Transport[] objs) 
	{
		
		int count = 0;
		// count number of objects in the array to create a new array of the size of the number of aircrafts
		for (int i = 0; i < objs.length; i++)
		{
			if (objs[i] instanceof Aircraft)
				count++;	
		}
		
		if (count == 0)
			return "no aircraft found.";
		
		else if (count == 1)
			return "one aircraft found";
					
		Aircraft[] x = new Aircraft[count];
		
		//create array of aircrafts
		for (int p = 0;p < x.length; p++)
			{
		
			for (int j = 0; j < objs.length; j++)
			{		
				if 	(objs[j] instanceof Aircraft)	
				{
					x[p] = (Aircraft) objs[j];
					objs[j] = null;
					break;
				}
			}
			
		}
		
		//Sorting aircrafts
		for (int u = 0; u < x.length-1; u++)
		{
			int min = u;
			for (int v = u+1; v < x.length; v++)
				{	
					Aircraft temp = new Aircraft();
					if (x[v].price < x[min].price)
						min = v;
					
					temp = x[min];
					x[min] = x[u];  
					x[u] = temp;  
				}
		}	
			

	    return "The most expensive aircraft is: $"+ x[count-1].price+"."+x[count-1]+
	    "\nThe least expensive aircraft is: $"+ x[0].price+"."+x[0];
	
	}	
	
	
}
