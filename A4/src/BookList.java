/** 
 *  @author Hudson Xingcheng Lu
 *  @version 17 Monday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 4
 * Due Date Monday 17 April
*/

	import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
	import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

	/**
	 * @author hudsonlu
	 *
	 */
	public class BookList {

	    /**
	     * @author hudsonlu
	     *
	     */
	    private class Node {
	        private Book b;
	        private Node next;
	        
	        public Node(Book b) {
	            this.b = b;
	            this.next = null;
	        }
	    }
	    /**
	     * 
	     */
	    private Node head;
	    /**
	     * 
	     */
	    public BookList() {
	        head = null;
	    }
	    
	    
	    /**
	     * 
	     * @return node
	     */
	    private Node getEnd() {
	        if (head == null) {
	            return null;
	        }
	        Node current = head;
	        while (current.next != head) {
	            current = current.next;
	        }
	        return current;
	    }

	    /**
	     * 
	     * @param record book
	     */
	    public void addToEnd(Book record) {
	        Node end = getEnd();
	        Node newNode = new Node(record);
	        if (head == null) {
	            head = newNode;
	            head.next = head;
	        } 
	        else {
	            end.next = newNode;
	            newNode.next = head;
	        }
	    }

	     /**
	      * 
	      * @param b book
	      */
	    public void addToStart(Book b) {
	        Node newNode = new Node(b);
	        
	        if (head == null) {
	            newNode.next = newNode;
	        } 
	        else 
	        {
	            Node last = head;
	            while (last.next != head) 
	            {
	                last = last.next;
	            }
	            
	            last.next = newNode;
	            newNode.next = head;
	        }
	        
	        head = newNode;
	    }
	    /**
	     * 
	     * @param yr year
	     */
	    public void storeRecordsByYear(int yr) {
	        String fileName = yr + ".txt";
	          
	        try {
	            PrintWriter pw0 = new PrintWriter(new FileOutputStream(fileName));
	            Node current = head;
	           
	            
	            do {
	                if (current.b.getYear() == yr) 
	                {
	                	pw0.println(current.b.toString());             
	                }
	                current = current.next;
	            } while (current != head);
	            
	            pw0.flush();
	            pw0.close();     
	            
	        } catch (IOException e) {
	            System.out.println("An error occurred while creating the file: " + e.getMessage());
	        }
	    }
	    
	    /**
	     * 
	     * @param isbn the id of a book
	     * @param b book
	     * @return boolean
	     */
	    public boolean insertBefore(long isbn, Book b) {
	        if (head == null) { 
	            return false;
	        }
	        Node current = head;
	        Node previous = null;
	        while (current != null && current.b.getIsbn() != isbn) {//until if it finds matching ISBN
	            previous = current;
	            current = current.next;
	        }
	        if (current == null) { 
	            return false;
	        }
	        Node newNode = new Node(b);
	        if (previous == null) { 
	            newNode.next = head;
	            head = newNode;
	        } else { 
	            previous.next = newNode; //references from previous and next
	            newNode.next = current;
	        }
	        return true;
	    }

/**
 * 
 * @param isbn1 id of a book
 * @param isbn2 id of a book
 * @param b book
 * @return boolean
 */
	    public boolean insertBetween(long isbn1, long isbn2, Book b) {
	        Node prev = head;
	        Node curr = head.next;
	        while (curr != null) {
	            if (curr.b.getIsbn() == isbn2 && prev.b.getIsbn() == isbn1) 
	            {
	                Node newNode = new Node(b);
	                prev.next = newNode;
	                newNode.next = curr;
	                return true;
	            }
	            prev = curr;
	            curr = curr.next;
	        }
	        return false;
	    }
	    /**
	     * 
	     */
	    public void displayContent() {
	        if (head == null) {
	            System.out.println("The list is empty.");
	            return;
	        }
	       Node current = head;
	        do {
	            System.out.println(current.b.toString() + " ==> ");
	            current = current.next;
	        } while (current != head);
	        System.out.println("===> head");
	    }
/**
 * 
 * @return boolean
 */
	    public boolean delConsecutiveRepeatedRecords() {
	        if (head == null) {
	            return false;
	        }
	        
	        Node current = head;
	        boolean deleted = false;
	        
	        while (current.next != head) {
	            if (current.b.equals(current.next.b)) {
	                current.next = current.next.next;
	                deleted = true;
	            } else {
	                current = current.next;
	            }
	        }	        
	        
	        if (head.b.equals(head.next.b)) {
	            head = head.next.next;
	            deleted = true;
	        }
	        
	        Node lastNode = getEnd();
	        if (head.b.equals(lastNode.b)) {
	            head = head.next;
	            lastNode.next = head;
	            deleted = true;
	        }
	        
	        return deleted;
	    }
   
/**
 * 
 * @param aut authors
 * @return Booklist
 */
	    public BookList extractAuthList(String aut) {
	        BookList authList = new BookList();
	        ArrayList<Book> tempList = new ArrayList<Book>();
	        
	        if (head == null) 
	        {
	            return authList;
	        }
	        
	        Node current = head;
	        do {
	            if (current.b.getAuthors().equals(aut)) 
	            {
	                tempList.add(current.b);
	            }
	            current = current.next;
	        } while (current != head);
	        
	        for (int i = 0; i < tempList.size(); i++) 
	        {
	            authList.addToStart(tempList.get(i));
	        }
	        
	        return authList;
	    }


/**
 * 
 * @param isbn1 id of a book
 * @param isbn2 id of a book
 * @return boolean
 */
	    public boolean swap(long isbn1, long isbn2) 
	    {
	        if (head == null) { // empty list
	            return false;
	        }
	        
	        // nodes based on ISBNs
	        Node prev1 = null, curr1 = head;
	        while (curr1 != null && curr1.b.getIsbn() != isbn1) 
	        {
	            prev1 = curr1;
	            curr1 = curr1.next;
	        }
	        Node prev2 = null, curr2 = head;
	        while (curr2 != null && curr2.b.getIsbn() != isbn2) 
	        {
	            prev2 = curr2;
	            curr2 = curr2.next;
	            
	        }
	        if (curr1 == null || curr2 == null) 
	        {
	            return false; 
	        }
	        
	        // swap nodes
	        if (prev1 != null) 
	        {
	            prev1.next = curr2;
	        } 
	        else {
	            head = curr2;
	        }
	        if (prev2 != null) 
	        {
	            prev2.next = curr1;
	        } 
	        else {
	            head = curr1;
	        }
	        if (curr1 == head) 
	        {
	            Node temp = curr2.next;
	            curr2.next = curr1;
	            curr1.next = temp;
	            head = curr2;
	        } 
	        else if (curr2 == head) 
	        {
	            Node temp = curr1.next;
	            curr1.next = curr2;
	            curr2.next = temp;
	            head = curr1;
	        } 
	        else
	        {
	            Node temp = curr1.next;
	            curr1.next = curr2.next;
	            curr2.next = temp;
	        }
	        
	        return true;
	    }

	  /**
	   *   
	   */
	    public void commit() {
	        try {
	        	PrintWriter pw2 = new PrintWriter (new FileOutputStream("Update_Books.txt"));
	            Node current = head;
	                   
		        if (head == null) {
		            System.out.println("The list is empty.");
		           
		        }
		     
	            do {
	                pw2.println(current.b.toString());
	                current = current.next;
	            } while (current != head);
	            
	            pw2.flush();
	            pw2.close();
	        } 
	        catch (IOException e) {
	            System.out.println("Creation File Error.");
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	}


