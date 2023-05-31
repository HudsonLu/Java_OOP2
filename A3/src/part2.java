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



/**
 * @author hudsonlu
 *
 */
public class part2 {
    // constants for the genres
	
	 /**
    *validating semantics, read the genre files each into arrays of Book objects,
		               // then serialize the arrays of Book objects each into binary files.
    */
	public static void do_part2 () {
		
		try
		{
			Scanner kb = new Scanner(new FileInputStream("part1_output_file_names.txt"));
	
			kb.close();
			
			String[] genres = new String[8];
			
			genres[0]= "CCB";
			genres[1]= "HCB";
			genres[2]= "MTV";
			genres[3]= "MRB";
			genres[4]= "NEB";
			genres[5]= "OTR";
			genres[6]= "SSM";
			genres[7]= "TPA";
				
			//
			String[] genresFilesBefore = new String[8];
			
			genresFilesBefore[0]= "Cartoons_Comics_Books.csv.txt";
			genresFilesBefore[1]= "Hobbies_Collectibles_Books.csv.txt";
			genresFilesBefore[2]= "Movies_TV.csv.txt";
			genresFilesBefore[3]= "Music_Radio_Books.csv.txt";
			genresFilesBefore[4]= "Nostalgia_Eclectic_Books.csv.txt";
			genresFilesBefore[5]= "Old_Time_Radio.csv.txt";
			genresFilesBefore[6]= "Sports_Sports_Memorabilia.csv.txt";
			genresFilesBefore[7]= "Trains_Planes_Automobiles.csv.txt";
			

			
			
			String[] genresFiles = new String[8];
			
			genresFiles[0]= "Cartoons_Comics_Books.csv.scr.txt";
			genresFiles[1]= "Hobbies_Collectibles_Books.csv.scr.txt";
			genresFiles[2]= "Movies_TV.csv.scr.txt";
			genresFiles[3]= "Music_Radio_Books.csv.scr.txt";
			genresFiles[4]= "Nostalgia_Eclectic_Books.csv.scr.txt";
			genresFiles[5]= "Old_Time_Radio.csv.scr.txt";
			genresFiles[6]= "Sports_Sports_Memorabilia.csv.scr.txt";
			genresFiles[7]= "Trains_Planes_Automobiles.csv.scr.txt";
			
			
			String filename = "part2_output_file_names.txt";
			String semanticFile = "semantic_error_file.txt";
			
			PrintWriter pw = new PrintWriter (new FileOutputStream(filename));
			PrintWriter OSNsemantic = new PrintWriter (new FileOutputStream(semanticFile));
			

			for (int t = 0; t <genresFiles.length; t++)
			{
				
				pw.println(genresFiles[t]);
			}
			pw.close();
			
		
			
////////////////////////////////////////////
					
		ObjectOutputStream outputStreamName1 = new ObjectOutputStream (new FileOutputStream(genresFiles[0]));
		ObjectOutputStream outputStreamName2 = new ObjectOutputStream (new FileOutputStream(genresFiles[1]));
		ObjectOutputStream outputStreamName3 = new ObjectOutputStream (new FileOutputStream(genresFiles[2]));
		ObjectOutputStream outputStreamName4 = new ObjectOutputStream (new FileOutputStream(genresFiles[3]));
		ObjectOutputStream outputStreamName5 = new ObjectOutputStream (new FileOutputStream(genresFiles[4]));
		ObjectOutputStream outputStreamName6 = new ObjectOutputStream (new FileOutputStream(genresFiles[5]));
		ObjectOutputStream outputStreamName7 = new ObjectOutputStream (new FileOutputStream(genresFiles[6]));
		ObjectOutputStream outputStreamName8 = new ObjectOutputStream (new FileOutputStream(genresFiles[7]));					


		ObjectOutputStream[] OSNall = new ObjectOutputStream[8];
		OSNall[0]= outputStreamName1;
		OSNall[1]= outputStreamName2;
		OSNall[2]= outputStreamName3;
		OSNall[3]= outputStreamName4;
		OSNall[4]= outputStreamName5;
		OSNall[5]= outputStreamName6;
		OSNall[6]= outputStreamName7;
		OSNall[7]= outputStreamName8;
		
		
		for (int i = 0; i < 8; i++) //all records
		{
			kb = new Scanner(new FileInputStream(genresFilesBefore[i]));// all records using while loop
			String line;
			
			while(kb.hasNextLine()) // each record
			{
				line = kb.nextLine();
		
				String copyline = line;
				//System.out.println(line);
				
				String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)(?<!\")");
				
				double price = Double.parseDouble(fields[2]);
				int year = Integer.parseInt(fields[5]);

				//System.out.println(Arrays.toString(fields));
				//System.out.println(fields[4]);
				//System.out.println(fields.length);
				
		try
		{	
				
					//Exceptions
				if (isValidISBN(fields[3])==false)
					{					
					throw new BadIsbn10Exception("BadIsbn10Exception");
					}
				else if  (isValidISBN(fields[3])==false) 
			    	{
			    	
					throw new BadIsbn13Exception("BadIsbn13Exception");
			    	}
					
				else if (price < 0.00) 
				{	
					throw new BadPriceException("BadPriceException");
				}	
					
				else if (year< 1995 && year > 2010)
					{			
					throw new BadYearException ("BadYearException");
					}
			    
				
				
				Book book = new Book(fields[0],fields[1],price,fields[3], fields[4],year);
				
				OSNall[i].writeObject(book);
				
			
		} // try statement
		
		
		catch (BadIsbn10Exception e) {
			OSNsemantic.println("semantic error in file: "+genresFiles[i]);
			OSNsemantic.println("-------------------");
			OSNsemantic.println("-------------------");
			OSNsemantic.println("Error: Bad Isbn10 Exception");
			OSNsemantic.println("record: "+copyline);
			OSNsemantic.println();
			
	}   
		catch (BadIsbn13Exception e) {
			OSNsemantic.println("semantic error in file: "+genresFiles[i]);
			OSNsemantic.println("-------------------");
			OSNsemantic.println("-------------------");
			OSNsemantic.println("Error: Bad Isbn13 Exception");
			OSNsemantic.println("record: "+copyline);
			OSNsemantic.println();   
    } 
		catch (BadPriceException e) {
			OSNsemantic.println("semantic error in file: "+genresFiles[i]);
			OSNsemantic.println("-------------------");
			OSNsemantic.println("-------------------");
			OSNsemantic.println("Error: Bad Price Exception");
			OSNsemantic.println("record: "+copyline);
			OSNsemantic.println();
	   
	}
		catch (BadYearException e) {
			OSNsemantic.println("semantic error in file: "+genresFiles[i]);
			OSNsemantic.println("-------------------");
			OSNsemantic.println("-------------------");
			OSNsemantic.println("Error: Bad Year Exception");
			OSNsemantic.println("record: "+copyline);
			OSNsemantic.println();
	}	

			} //while loop read each line
			
		} //for loop read each record
		kb.close();
		OSNsemantic.flush();
		outputStreamName1.flush();
		outputStreamName2.flush();
		outputStreamName3.flush();
		outputStreamName4.flush();
		outputStreamName5.flush();
		outputStreamName6.flush();
		outputStreamName7.flush();
		outputStreamName8.flush();

		OSNsemantic.close();
		outputStreamName1.close();
		outputStreamName2.close();
		outputStreamName3.close();
		outputStreamName4.close();
		outputStreamName5.close();
		outputStreamName6.close();
		outputStreamName7.close();
		outputStreamName8.close();
		
	}// end try{}
		
	//////////////////////////

			catch (FileNotFoundException e) {
				e.printStackTrace();
			    
	        } 
			catch (IOException e) {
				e.printStackTrace();
			   
	        }
	}
	
	public static boolean isValidISBN(String isbn) {
	    // Remove any hyphens or spaces
	    isbn = isbn.replaceAll("[\\-\\s]", "");

	    // Check for 10-digit ISBN
	    if (isbn.length() == 10) {
	        int sum = 0;
	        for (int i = 0; i < 10; i++) {
	            char c = isbn.charAt(i);
	            if (!Character.isDigit(c)) {
	                return false;
	            }
	            int digit = Character.getNumericValue(c); //convert the character '1' to the integer value 1
	            sum += (10 - i) * digit;
	        }
	        return (sum % 11 == 0);
	    }

	    // Check for 13-digit ISBN
	    else if (isbn.length() == 13) {
	        int sum = 0;
	        for (int i = 0; i < 13; i++) {
	            char c = isbn.charAt(i);
	            if (!Character.isDigit(c)) {
	                return false;
	            }
	            int digit = Character.getNumericValue(c);
	            if (i % 2 == 0) {
	                sum += digit;
	            } else {
	                sum += 3 * digit;
	            }
	        }
	        return (sum % 10 == 0);
	    }

	    // Invalid ISBN length
	    else {
	        return false;
	    }
	}

	
	
}
