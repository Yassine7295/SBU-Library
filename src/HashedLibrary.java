/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 6
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Scanner;

import big.data.*;

public class HashedLibrary implements Serializable {

	Hashtable<String, Book> library;
	String title, author, publisher, isbn, line;
	File f;
	Scanner loadFile;
	/**
	 * Creates an instance of the HashedLibrary class.
	 */
	HashedLibrary() {
		library = new Hashtable<String, Book>();
	}
	/**
	 * Adds a book to the hash table.
	 * @param title: the desired title of the book to be added
	 * @param author: the desired author of the book to be added
	 * @param publisher: the desired publisher of the book to be added
	 * @param isbn: the desired isbn of the book to be added
	 * <dt><b>Precondition:</b><dd> A hash table object has been initialized.
	 * <dt><b>Postcondition:</b><dd> The book has been added to the hash table.
	 */
	public void addBook(String title, String author, String publisher, String isbn) {
		if(library.containsKey(isbn)){
			System.out.println(library.get(isbn).toString() + " is already in our records.");
		}
		else {
			Book b = new Book(title, author, publisher, isbn);
			library.put(isbn, b);
			try {
			      FileOutputStream file = new FileOutputStream("filename.obj");
			      ObjectOutputStream fout = new ObjectOutputStream(file);
			      fout.writeObject(library); 
			      fout.close();
			} catch (IOException e){
				
			}
		}
	}
	/**
	 * Adds all of the book in the file to the hash table.
	 * @param filename: the name of the file, where the information of the XML files is located.
	 * <dt><b>Precondition:</b><dd> A hash table object has been initialized.
	 * <dt><b>Postcondition:</b><dd> All of the books have been added to the hash table.
	 */
	public void addAllBookInfo(String fileName) throws Exception {
		f = new File(fileName);
		loadFile = new Scanner(f);
		while(loadFile.hasNextLine()){
			line = loadFile.nextLine();
			DataSource ds = DataSource.connect("http://www.cs.stonybrook.edu/~cse214/hw/hw6/" + line + ".xml").load();
			title = ds.fetchString("title");
			author = ds.fetchString("author");
			publisher = ds.fetchString("publisher");
			isbn = ds.fetchString("isbn");
			addBook(title, author, publisher, isbn);
		}
	}
	/**
	 * Returns the book with that isbn, if it is in the records.
	 * @param isbn: the isbn of the book to be returned
	 * <dt><b>Precondition:</b><dd> A hash table object has been initialized.
	 * @return: the book with that isbn, if it is in the records
	 * @throws BookDoesNotExistException: the book does not exist in the records
	 */
	public Book getBookByIsbn(String isbn) throws BookDoesNotExistException {
		if(library.containsKey(isbn)) {
			return library.get(isbn);
		}
		else {
			throw new BookDoesNotExistException();
		}
	}
	/**
	 * Prints the books in the library in a neatly formatted table.
	 * <dt><b>Precondition:</b><dd> A hash table object has been initialized.
	 */
	public void printCatalog() {
		if(!library.isEmpty()) {
			Object[] array = library.keySet().toArray();
			for(int i = 0; i < array.length; i++){
				String s = (String) array[i];
				try {
					getBookByIsbn(s).printFormat();
				} catch (BookDoesNotExistException e) {
					e.getMessage();
				}
			}
		}
	}
	
}
