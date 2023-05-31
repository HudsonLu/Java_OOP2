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
import CheckedExceptions.MissingFieldException;
import CheckedExceptions.TooFewFieldsException;
import CheckedExceptions.TooManyFieldsException;
import CheckedExceptions.UnknownGenreException;




/**
 * @author hudsonlu
 *
 */
public class part1 {
    // constants for the genres
	
	
	 /**
    * validating syntax, partition book records based on genre, creating a syntax-file.txt
    */
	public static void do_part1 () 
	{	
		try {	
			Scanner kb= new Scanner(new FileInputStream("part1_input_file_names.txt"));
	
			kb.nextLine();
			
			//can put it in an array all records
			String record1 = kb.nextLine();
			String record2 = kb.nextLine();
			String record3 = kb.nextLine();
			String record4 = kb.nextLine();
			String record5 = kb.nextLine();
			String record6 = kb.nextLine();
			String record7 = kb.nextLine();
			String record8 = kb.nextLine();
			String record9 = kb.nextLine();
			String record10 = kb.nextLine();
			String record11 = kb.nextLine();
			String record12 = kb.nextLine();
			String record13 = kb.nextLine();
			String record14 = kb.nextLine();
			String record15 = kb.nextLine();
			String record16 = kb.nextLine();
			
			String[] records = new String[16];
			
			records[0] = record1;
			records[1] = record2;
			records[2] = record3;
			records[3] = record4;
			records[4] = record5;
			records[5] = record6;
			records[6] = record7;
			records[7] = record8;
			records[8] = record9;
			records[9] = record10;
			records[10] = record11;
			records[11] = record12;
			records[12] = record13;
			records[13] = record14;
			records[14] = record15;
			records[15] = record16;

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
				
			
			String[] genresFiles = new String[8];
			
			genresFiles[0]= "Cartoons_Comics_Books.csv.txt";
			genresFiles[1]= "Hobbies_Collectibles_Books.csv.txt";
			genresFiles[2]= "Movies_TV.csv.txt";
			genresFiles[3]= "Music_Radio_Books.csv.txt";
			genresFiles[4]= "Nostalgia_Eclectic_Books.csv.txt";
			genresFiles[5]= "Old_Time_Radio.csv.txt";
			genresFiles[6]= "Sports_Sports_Memorabilia.csv.txt";
			genresFiles[7]= "Trains_Planes_Automobiles.csv.txt";
			
			String filename = "part1_output_file_names.txt";
			String syntaxFile = "syntax_error_file.txt";
			
			PrintWriter pw = new PrintWriter (new FileOutputStream(filename));
			
			for (int t = 0; t < genresFiles.length; t++)
			{
				
				pw.println(genresFiles[t]);
			}
			pw.println("syntax_error_file.txt");
			pw.close();	
			
			////////////
			
			PrintWriter PrintWriter1 = new PrintWriter (new FileOutputStream(genresFiles[0]));	
			PrintWriter PrintWriter2 = new PrintWriter (new FileOutputStream(genresFiles[1]));
			PrintWriter PrintWriter3 = new PrintWriter (new FileOutputStream(genresFiles[2]));
			PrintWriter PrintWriter4 = new PrintWriter (new FileOutputStream(genresFiles[3]));
			PrintWriter PrintWriter5 = new PrintWriter (new FileOutputStream(genresFiles[4]));
			PrintWriter PrintWriter6 = new PrintWriter (new FileOutputStream(genresFiles[5]));
			PrintWriter PrintWriter7 = new PrintWriter (new FileOutputStream(genresFiles[6]));
			PrintWriter PrintWriter8 = new PrintWriter (new FileOutputStream(genresFiles[7]));


		    PrintWriter OSNsyntax = new PrintWriter (new FileOutputStream(syntaxFile));
		    PrintWriter[] OSNall = new PrintWriter[8];

			OSNall[0]= PrintWriter1;
			OSNall[1]= PrintWriter2;
			OSNall[2]= PrintWriter3;
			OSNall[3]= PrintWriter4;
			OSNall[4]= PrintWriter5;
			OSNall[5]= PrintWriter6;
			OSNall[6]= PrintWriter7;
			OSNall[7]= PrintWriter8;
			
			
			for (int i = 0; i < 16; i++) //all records
			{
				kb = new Scanner(new FileInputStream(records[i]));// all records using while loop
				String line;
				
				while(kb.hasNextLine()) // each record
				{
					line = kb.nextLine();
			
					String copyline = line;
					//System.out.println(line);
					
					
					String[] fields;
		
					
					fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)(?<!\")");
					//}

					if (fields.length == 5 && line.endsWith(",")) {
					    String[] newFields = new String[6];
					    System.arraycopy(fields, 0, newFields, 0, 5);
					    newFields[5] = "";
					    fields = newFields;
					}
					//System.out.println(Arrays.toString(fields));
					//System.out.println(fields[4]);
					//System.out.println(fields.length);
					
			try
			{	
		
				//Exceptions
				
				//genre
						int count = 0;
						for (int v = 0; v < genres.length; v++)
						{
							if (genres[v].equals(fields[4]))
								{
								count = 1;
								break;
								}
							else
								count = 0;
						}
				//number of empty fields
					int check = 0;
						for (int l = 0; l < fields.length; l++)
						{
							if (fields[l]=="")
								check = check+1;
							
						}
						
						
						//Exceptions
					if (check >= 2)
						{
						throw new TooFewFieldsException("TooFewFieldException");
						}
					else if  (fields[0]=="" ||fields[1]==""||fields[2]==""||fields[3]==""||fields[4]=="" || fields[5]=="") //
				    	{	
						throw new MissingFieldException("MissingFieldException");
				    	}
						
					else if (fields.length < 6) //
					{
						
						throw new TooManyFieldsException("TooManyFieldsException");
						}	
						
					else if (count == 0)
						{			
						throw new UnknownGenreException("UnknownGenreException");	
						}
				    
					for (int t = 0; t < genres.length; t++)
					{
						String Book_file;
						if (genres[t].equals(fields[4]))
							{
							Book_file = genresFiles[t];			
							OSNall[t].println(copyline);
							
							break;		
							}
			
					}
				
			} // try statement
			
			
			catch (TooManyFieldsException e) {
				OSNsyntax.println("syntax error in file: "+records[i]);
				OSNsyntax.println("-------------------");
				OSNsyntax.println("-------------------");
				OSNsyntax.println("Error: Too Many Fields Exception");
				OSNsyntax.println("record: "+copyline);
				OSNsyntax.println();
				
		}   
			catch (TooFewFieldsException e) {
				OSNsyntax.println("syntax error in file: "+records[i]);
				OSNsyntax.println("-------------------");
				OSNsyntax.println("-------------------");
				OSNsyntax.println("Error: Too Few Fields Exception");
				OSNsyntax.println("record: "+copyline);
				OSNsyntax.println();    
	    } 
			catch (MissingFieldException e) {
				
				String missingOne = "year";
			
				for(int p = 0; p< fields.length;p++)
				{
					if (fields[p]=="")
					{	
						switch(p)
						{
						case 0: missingOne  = "title";
						break;
						case 1: missingOne  = "author";
						break;
						case 2: missingOne  = "price";
						break;
						case 3: missingOne  = "ISBN";
						break;
						case 4: missingOne  = "genre";
						break;
						case 5: missingOne  = "year";
						break;
						}
					}
				}
				
				OSNsyntax.println("syntax error in file: "+records[i]);
				OSNsyntax.println("-------------------");
				OSNsyntax.println("-------------------");
				OSNsyntax.println("Error: Missing Field Exception: "+ missingOne);
				OSNsyntax.println("record: "+copyline);
				OSNsyntax.println();
			}
		
			catch (UnknownGenreException e) {
				OSNsyntax.println("syntax error in file: "+records[i]);
				OSNsyntax.println("-------------------");
				OSNsyntax.println("-------------------");
				OSNsyntax.println("Error: Unknown Genre Exception");
				OSNsyntax.println("record: "+copyline);
				OSNsyntax.println();
		}	
			
			
				} //while loop read each line
				
			} //for loop read each record
			kb.close();
			OSNsyntax.flush();
			PrintWriter1.flush();
			PrintWriter2.flush();
			PrintWriter3.flush();
			PrintWriter4.flush();
			PrintWriter5.flush();
			PrintWriter6.flush();
			PrintWriter7.flush();
			PrintWriter8.flush();

			OSNsyntax.close();
			PrintWriter1.close();
			PrintWriter2.close();
			PrintWriter3.close();
			PrintWriter4.close();
			PrintWriter5.close();
			PrintWriter6.close();
			PrintWriter7.close();
			PrintWriter8.close();
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file stuff.txt.");
		    System.exit(0);
        } 
		catch (IOException e) {
			System.out.println("Error opening the file stuff.txt.");
		    System.exit(0);
        }
		
	
	}
	
	
	
}
