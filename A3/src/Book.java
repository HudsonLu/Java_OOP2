/** 
 *  @author Hudson Xingcheng Lu
 *  @version 29 Wednesday 2023
 * 
 * Written by: Hudson Xingcheng Lu 40254326
 * COMP249
 * Assignment # 3
 * Due Date Wednesday 29 March
*/


import java.io.Serializable;

/**
 * @author hudsonlu
 *
 */
public class Book implements Serializable {
    /**
     * author of the book
     */
    private String title; /**  title of the book */
    private String authors; /**  authors of the book */
    private double price; /**  price of the book */
    private String isbn; /**  ISBN of the book */
    private String genre; /**  genre of the book */
    private int year; /**  year of the book */
    
    /**
     * @param title of the book
     * @param authors of the book
     * @param price of the book
     * @param isbn of the book
     * @param genre of the book
     * @param year of the book
     */
    public Book(String title, String authors, double price, String isbn, String genre, int year) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.year = year;
    }
    
    // getters and setters for all fields
    
    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return authors
     */
    public String getAuthors() {
        return authors;
    }
    
    /**
     * @param authors of the book
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    /**
    * @return price of the book
    */
    public double getPrice() {
        return price;
    }
    /**
    * @param price of the book
    */
    public void setPrice(double price) {
        this.price = price;
    }
  
    /**
     * @return ISBN
     */
    public String getIsbn() {
        return isbn;
    }
    /**
    * @param isbn of the book
    */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
    *  @return genre of the book
    */
    public String getGenre() {
        return genre;
    }
    /**
    * @param genre of the book
    */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**
    * @return year of the book
    */
    public int getYear() {
        return year;
    }
    /**
    *@param year of the book
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    // override toString() method to print out Book object
    /**
     *
     */
    @Override
    public String toString() {
        return title + "," + authors + "," + price + "," + isbn + "," + genre + "," + year;
    }
    
    /**
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Double.compare(book.price, price) == 0 &&
                year == book.year &&
                title.equals(book.title) &&
                authors.equals(book.authors) &&
                isbn.equals(book.isbn) &&
                genre.equals(book.genre);
    }

	/**
	 * @param line of the book
	 * @return null empty
	 */
	public static Book parseBook(String line) {
		// TODO Auto-generated method stub
		return null;
	}
}
