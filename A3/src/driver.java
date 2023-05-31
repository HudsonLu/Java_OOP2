/** 
 *  @author Hudson Xingcheng Lu
 *  @version 29 Wednesday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 3
 * Due Date Wednesday 29 March
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import CheckedExceptions.BadIsbn10Exception;
import CheckedExceptions.BadIsbn13Exception;
import CheckedExceptions.BadPriceException;
import CheckedExceptions.BadYearException;
import CheckedExceptions.MissingFieldException;
import CheckedExceptions.TooFewFieldsException;
import CheckedExceptions.TooManyFieldsException;
import CheckedExceptions.UnknownGenreException;

/**
 * @author hudsonlu
 *
 */
public class driver {
	
		/**
		 * @param args main method that combines the three parts of the A3
		 */
		public static void main(String[] args) 
		
		{
			
	
		   part1.do_part1(); // validating syntax, partition book records based on genre.
		   part2.do_part2(); // validating semantics, read the genre files each into arrays of Book objects,
		               // then serialize the arrays of Book objects each into binary files.
		   part3.do_part3(); // reading the binary files, deserialize the array objects in each file, and
		
		
		}
	
	}


