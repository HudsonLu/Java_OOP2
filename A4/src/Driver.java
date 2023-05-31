
/** 
 *  @author Hudson Xingcheng Lu
 *  @version 17 Monday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 4
 * Due Date Monday 17 April
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/**
 * 
 * @author hudsonlu
 *
 */
class Driver{
/**
 * 
 * @param args
 */
public static void main(String[] args) {
	
    ArrayList<Book> arrLst = new ArrayList<Book>(30);
    BookList bkLst = new BookList();
    
    try {
    	Scanner kb = new Scanner(new FileInputStream("Books.txt"));
    
	    PrintWriter pw = new PrintWriter (new FileOutputStream("YearErr.txt"));	
	    System.out.println("YearError File Created");
	    String line;
    
    while (kb.hasNextLine()) {
    	line = kb.nextLine();
    	
		String[] fields;	
		fields = line.split(",");
		// year fields[5] from 0 to 5, 6 fields
		
		double price = Double.parseDouble(fields[2]);
		int year = Integer.parseInt(fields[5]);
		long isbn = Long.parseLong(fields[3]);
		Book book = new Book(fields[0],fields[1],price,isbn, fields[4],year);
		
		
		if (year > 2023) 
			{
			arrLst.add(book);
			pw.println(line);
			}
			
		else	
			bkLst.addToEnd(book);
			
    }
    pw.flush();
    pw.close();
    kb.close();
    
    }
    catch (FileNotFoundException e) {
		System.out.println("Error opening the file stuff.txt1.");
	    System.exit(0);
    } 
	catch (IOException e) {
		System.out.println("Error opening the file stuff.txt2.");
	    System.exit(0);
    }
    
    
    // display contents of bkLst List
    System.out.println("Here are the contents of the list");
    System.out.println("--------------------------------");
    System.out.println("--------------------------------");
    
    bkLst.displayContent();
    
    
    Scanner scanner = new Scanner(System.in);
    boolean stop = false;

    while (!stop) {
        System.out.println("Tell me what you want to do? Let's Chat since this is trending now! Here are the options:");
        System.out.println("1) Give me a year # and I would extract all records of that year and store them in a file for that year");
        System.out.println("2) Ask me to delete all consecutive repeated records");
        System.out.println("3) Give me an author name and I will create a new list with the records of this author and display them");
        System.out.println("4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN");
        System.out.println("5) Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
        System.out.println("6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
        System.out.println("7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books");
        System.out.println("8) Tell me to STOP TALKING. Remember, if you do not commit, I will not!");
        System.out.print("Enter your selection:");
        
        int choice = scanner.nextInt();
       
       
        
        switch (choice) {
            case 1:
            {
                System.out.print("Enter a year: ");
                int year = scanner.nextInt();
                System.out.println();
                System.out.println("Here are the contents of "+year+".txt");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
                bkLst.storeRecordsByYear(year);
                Scanner kb0;
				try {
					kb0 = new Scanner(new FileInputStream(year+".txt"));          
	        	    String line;
	            
	            while (kb0.hasNextLine()) {
	            	line = kb0.nextLine();      
	            	System.out.println(line);
	
	            	}
	            	
	            	kb0.close();
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	break;
            }

            case 2:
            {
            	System.out.println("Here are the contents of the list after removing consecutive duplicates");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
            	bkLst.delConsecutiveRepeatedRecords();
            	bkLst.displayContent();
                break;
            }

            case 3:
            {
                System.out.print("Please enter the name of the author to create an extracted list: ");
                scanner.nextLine();
                String author = scanner.nextLine();
                System.out.println("Here are the contents of the author list"+author+".");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
                bkLst.extractAuthList(author).displayContent();
                break;
            }

            case 4:
            {
                System.out.println("Enter an ISBN and a valid Book object to insert before the record with this ISBN ");
                System.out.print("Enter the ISBN: ");
                long isbn = scanner.nextLong();
                System.out.println("Enter the Book object ");
                System.out.print("Enter the title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.print("Enter the author: ");
                String author = scanner.nextLine();
                System.out.print("Enter the price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter the ISBN: ");
                long isbn1 = scanner.nextLong();
                System.out.print("Enter the genre: ");
                String genre = scanner.next();
                System.out.print("Enter the year: ");
                int year = scanner.nextInt();
                
                Book book = new Book(title, author, price, isbn1, genre, year);
                bkLst.insertBefore(isbn, book);
                System.out.println("Here are the contents of the list after inserting a Node before the record with the ISBN");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
                bkLst.displayContent();
                break;
            }

            case 5:
            {
                System.out.print("Enter two ISBN to insert a Node between them: ");
                long isbn111 = scanner.nextLong();
                long isbn222 = scanner.nextLong();
                System.out.println("Enter the Book object ");
                System.out.print("Enter the title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.print("Enter the author: ");
                String author = scanner.nextLine();
                System.out.print("Enter the price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter the ISBN: ");
                long isbn1 = scanner.nextLong();
                System.out.print("Enter the genre: ");
                String genre = scanner.next();
                System.out.print("Enter the year: ");
                int year = scanner.nextInt();
               
                Book book2 = new Book(title, author, price, isbn1, genre, year);
                           
                bkLst.insertBetween(isbn111, isbn222, book2);
                System.out.println("Here are the contents of the list after inserting a Node between two ISBN");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
                bkLst.displayContent();
                break;
            }

            case 6:
            {
            	System.out.print("Enter two ISBN to insert a Node between them: ");
                long isbn1111 = scanner.nextLong();
                long isbn2222 = scanner.nextLong();
 
                bkLst.swap(isbn1111, isbn2222);
                System.out.println("Records with ISBN "+isbn1111 + " and "+isbn2222 + " were found and swapped.");
                System.out.println("Here are the contents of the list after rearranging the record");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
                bkLst.displayContent();
                break;
            }

            case 7:
            {
            	bkLst.commit();
            	System.out.println("You have committed. Here are the contents of the list after commiting:");
            	System.out.println("-----------------------------------------------------------------------");
            	System.out.println("-----------------------------------------------------------------------");
            	bkLst.displayContent();
                break;
              
            }

            case 8:
            {
                stop = true;
                break;
            }

            default:
                System.out.println("Invalid choice!");
        }

        System.out.println();
    }
    System.out.println("Thank you for using this program!");
    
}



}



















