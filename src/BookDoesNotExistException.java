/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 6
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
public class BookDoesNotExistException extends Exception {
	/**
	 * Creates an instance of the BookDoesNotExistException class.
	 */
	BookDoesNotExistException() {
		System.out.println("This book does not exist in the records.");
	}
}
