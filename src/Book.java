/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 6
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.io.Serializable;

public class Book implements Serializable {
	
	private String title, author, publisher, isbn;
	/**
	 * Creates a Book object with no parameters.
	 */
	Book() {
	}
	/**
	 * Creates a Book object with parameters.
	 * @param title: the desired title of the book
	 * @param author: the desired author of the book
	 * @param publisher: the desired publisher of the book
	 * @Param isbn: the desired isbn of the book
	 */
	Book(String title, String author, String publisher, String isbn) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	/**
	 * Returns the title of the book object.
	 * @return: the title as a String
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Returns the author of the book object.
	 * @return: the author as a String
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Returns the publisher of the book object.
	 * @return: the publisher as a String
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * Returns the ISBN of the book object.
	 * @return: the isbn as a String
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Sets the title of the book object.
	 * @param title: desired title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Sets the author of the book object,
	 * @param author: desired author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * Sets the publisher of the book object.
	 * @param publisher: desired publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * Sets the ISBN of the book object.
	 * @param isbn: desired isbn
	 */
	public  void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * Strings the isbn, title and author of a book object into one String.
	 * @return: a string representation of a book object
	 */
	public String toString() {
		return isbn + ": " + title + " by " + author;
	}
	/**
	 * Prints a formatted String representation of a book object.
	 */
	public void printFormat() {
		System.out.printf("%-15s%-37s%-20s%-15s",isbn, title, author, publisher);
		System.out.println();
	}
}
