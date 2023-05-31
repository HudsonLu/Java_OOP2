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
import java.util.Scanner;


/**
 * @author hudsonlu
 *
 */
public class part3 {
	
	
	/**
	 * reading the binary files, deserialize the array objects in each file, and
		
		
	 */
	public static void do_part3()
	
	{
	
	
		String[] genresFiles = new String[8];
		
		genresFiles[0]= "Cartoons_Comics_Books.csv.scr.txt";
		genresFiles[1]= "Hobbies_Collectibles_Books.csv.scr.txt";
		genresFiles[2]= "Movies_TV.csv.scr.txt";
		genresFiles[3]= "Music_Radio_Books.csv.scr.txt";
		genresFiles[4]= "Nostalgia_Eclectic_Books.csv.scr.txt";
		genresFiles[5]= "Old_Time_Radio.csv.scr.txt";
		genresFiles[6]= "Sports_Sports_Memorabilia.csv.scr.txt";
		genresFiles[7]= "Trains_Planes_Automobiles.csv.scr.txt";
    
		
		int counts[] = new int[8];
		counts[0]=0;
		counts[1]=0;
		counts[2]=0;
		counts[3]=0;
		counts[4]=0;
		counts[5]=0;
		counts[6]=0;
		counts[7]=0;
		
		
		
	    try
	    {
	    	for (int n = 0; n< genresFiles.length;n++)  	
	    		{
	    		FileInputStream fis1 = null;	    		
	    	    ObjectInputStream ois1 = null; 
		    	 fis1 = new FileInputStream(genresFiles[n]);
		         ois1 = new ObjectInputStream(fis1);
		
		         while (fis1.available() > 0) {
		             Object obj = ois1.readObject();
		             if (obj instanceof Book) {
		                 counts[n]++;
		             }
		         }
		         ois1.close();
		         fis1.close();
		    		}
	     }
	    
	    
	    catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	     }
			

	System.out.println("Welcome!");
    Scanner scanner = new Scanner(System.in);
    int choice2 = 0;

   
    do
    {  	
        System.out.println("----------------------------");
        System.out.println("     Main Menu      ");
        System.out.println("----------------------------");
        System.out.println(" v  View the selected file: "+genresFiles[choice2]+" ("+counts[choice2]+" records)");
        System.out.println(" s  Select a file to view");
        System.out.println(" x  Exit");
        System.out.println("----------------------------");   
        System.out.print("Enter Your Choice: ");
        String choice = scanner.nextLine();
        System.out.println(); 
	    	
        ////////////////////////////////////////////////////// ////////////////////////////////////////////////////// ////////////////
	    	if (choice.equals("v"))
	    	{
	
	    		System.out.println("Viewing:"+genresFiles[0]);
	    		System.out.println();
	    	    FileInputStream fis = null;
	    	    ObjectInputStream ois = null;    	    
			    	    try
			    	    {
			    	    	 fis = new FileInputStream(genresFiles[choice2]);
			    	         ois = new ObjectInputStream(fis);
			    	         
			    	         int count1 = 0;
			    	         while (fis.available() > 0) {
			    	             Object obj = ois.readObject();
			    	             if (obj instanceof Book) {
			    	                 System.out.println(obj);
			    	                 count1++;
			    	             }
			    	         }

			    	         ois.close();
			    	         fis.close();
			    	     }
			    	    catch (ClassNotFoundException e) {
			    	         e.printStackTrace();
			    	      } catch (FileNotFoundException e) {
			    	         e.printStackTrace();
			    	      } catch (IOException e) {
			    	         e.printStackTrace();
			    	     }
	    	    
	    	    System.out.println();
	    		
	    	}
	    	    
	    	////////////////////////////////////////////// ////////////////////////////////////////////////////// ////////////////
	    	else if (choice.equals("s"))
	    	{
	    	    System.out.println("------------------------------");
	    	    System.out.println("        File Sub-Menu        ");
	    	    System.out.println("------------------------------");
	    	    System.out.println("1  " + genresFiles[0] + "\t\t(" + counts[0] + " records)");
	    	    System.out.println("2  " + genresFiles[1] + "\t(" + counts[1] + " records)");
	    	    System.out.println("3  " + genresFiles[2] + "\t\t\t(" + counts[2] + " records)");
	    	    System.out.println("4  " + genresFiles[3] + "\t\t(" + counts[3] + " records)");
	    	    System.out.println("5  " + genresFiles[4] + "\t\t(" + counts[4] + " records)");
	    	    System.out.println("6  " + genresFiles[5] + "\t\t\t(" + counts[5] + " records)");
	    	    System.out.println("7  " + genresFiles[6] + "\t(" + counts[6] + " records)");
	    	    System.out.println("8  " + genresFiles[7] + "\t(" + counts[7] + " records)");
	    	    System.out.println("9  Exit");
	    	    System.out.println("------------------------------");
	    	    
	    	    System.out.print("Enter Your Choice: ");
	    	    
	    	    
	    	    String fileChoice = scanner.nextLine();
	    	    switch (fileChoice) {
	    	        case "1":
	    	            choice2 = 0;
	    	            break;
	    	        case "2":
	    	            choice2 = 1;
	    	            break;
	    	        case "3":
	    	            choice2 = 2;
	    	            break;
	    	        case "4":
	    	            choice2 = 3;
	    	            break;
	    	        case "5":
	    	            choice2 = 4;
	    	            break;
	    	        case "6":
	    	            choice2 = 5;
	    	            break;
	    	        case "7":
	    	            choice2 = 6;
	    	            break;
	    	        case "8":
	    	            choice2 = 7;
	    	            break;
	    	        case "9":
	    	            {
	    	            	System.out.println("Thank you for using our platform!");
	    	            	System.exit(0);
	    	            }
	    	        default:
	    	            System.out.println("Invalid input.");
	    	    }
	    	    
	    	    	
	    	}	    		
	    	else if (choice.equals("x") || choice.equals("X"))
	    	{
	    		System.out.println("Thank you for using our platform!");
	    		System.exit(0);
	    	}
	    		
	    } while(true);
    
    }
  
}
	
	
	
	
	
	
	
    
    


   
