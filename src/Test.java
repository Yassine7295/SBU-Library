import big.data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		String fileName = "book_list.txt";
		File f = new File(fileName);
		Scanner loadFile = new Scanner(f);
		String line, title, author, publisher, isbn;
		while(loadFile.hasNextLine()){
			line = loadFile.nextLine();
			DataSource ds = DataSource.connect("http://www.cs.stonybrook.edu/~cse214/hw/hw6/" + line + ".xml").load();
			title = ds.fetchString("title");
			author = ds.fetchString("author");
			publisher = ds.fetchString("publisher");
			isbn = ds.fetchString("isbn");
			Book b = new Book(title, author, publisher, isbn);
			System.out.println(b.toString());
		}
//		Hashtable<String, String> h = new Hashtable<String, String>();
//		h.put("one", "a");
//		h.put("two", "b");
//		h.put("three", "c");
//		h.put("four", "d");
//		h.put("five", "e");
//		Object[] array = h.keySet().toArray();
//		for(int i = 0; i < array.length; i++){
//			System.out.println(array[i]);
//		}
	}
}
