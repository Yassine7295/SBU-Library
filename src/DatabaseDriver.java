/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 6
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Scanner;


public class DatabaseDriver implements Serializable {
	public static void main(String[] args) throws Exception {
		HashedLibrary myLibrary = new HashedLibrary();
		Scanner s = new Scanner(System.in);
		String input;
		Book b;
		
		try {
		     FileInputStream file = new FileInputStream("filename.obj");
		     ObjectInputStream fin  = new ObjectInputStream(file);
		     myLibrary.library = (Hashtable<String, Book>) fin.readObject(); 
		     fin.close();
		} catch(IOException e) {
			 System.out.println("library.obj is not found. Using a new HashedLibrary.");
		}
		
		printMenu();
		input = s.nextLine();
		while(!input.equalsIgnoreCase("Q")) {
			if(input.equalsIgnoreCase("D")) {
				System.out.println();
				System.out.printf("%-15s%-37s%-20s%-15s","ISBN","Title","Author","Publisher");
				System.out.println();
				System.out.println("---------------------------------------------------------------------------------------------------------");
				myLibrary.printCatalog();
			}
			else if(input.equalsIgnoreCase("G")) {
				System.out.print("Enter Book ISBN: ");
				input = s.nextLine();
				System.out.print(myLibrary.getBookByIsbn(input).toString());
			}
			else if(input.equalsIgnoreCase("L")) {
				System.out.print("Enter the name of the file: ");
				input = s.nextLine();
				myLibrary.addAllBookInfo(input);
			}
			else if(input.equalsIgnoreCase("R")) {
				b = new Book();
				System.out.print("Enter book title: ");
				input = s.nextLine();
				b.setTitle(input);
				System.out.print("Enter book author: ");
				input = s.nextLine();
				b.setAuthor(input);
				System.out.print("Enter book publisher: ");
				input = s.nextLine();
				b.setPublisher(input);
				System.out.print("Enter book ISBN: ");
				input = s.nextLine();
				b.setIsbn(input);
				myLibrary.addBook(b.getTitle(), b.getAuthor(), b.getPublisher(), b.getIsbn());
				System.out.println("The following book has been added to the library: \n" + b.toString());
			}
			else {
				System.out.println("Invalid Command.");
			}
			System.out.println();
			printMenu();
			input = s.nextLine();
		}
		System.out.print("\nLibrary database closed.");
	}
	
	public static void printMenu(){
		System.out.print("(D) Displays Books\n"
				+ "(G) Get Book\n"
				+ "(L) Load File\n"
				+ "(R) Record Book\n"
				+ "(Q) Quit\n\n"
				+ "Enter a selection: ");
	}
}
