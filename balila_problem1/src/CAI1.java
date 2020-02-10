/*
 * Generate rand numbers with SecureRandom object
 * 
 * Ask student to solve multiplication question
 * 		Two numbers in the range from 0 - 9 (inclusive)
 * 
 * Display "Very good!" if correct
 * Display "No. Please try again." if incorrect
 * 
 * Program ends when correct response is given
 * 		Program asks problem repeatedly until correct response given
 * 
 * -----------------------------------------------------------------------
 * 
 * quiz() method contains program logic
 * 
 * askQuestion() method prints problem
 * 		Uses rand to generate two numbers
 * readResponse() method reads answer
 * isAnswerCorrect() method verifies answer
 * 		displayCorrectResponse() method displays "Very good!"
 * 		displayIncorrectResponse() method displays "No. Please try again."
 * 
 * Create main method to test program
 */
import java.security.SecureRandom;

public class CAI1 
{
	// Instance variables to hold values for multiplication
	private int num1;
	private int num2;
	private int answer;
	private SecureRandom rand = new SecureRandom();
	
	// Assigns num1 and num2 to values and outputs problem to screen
	private void askQuestion()
	{
		// Random numbers in the range of 0-9 inclusive
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		
		// Calculates answer and stores in instance variable
		answer = num1 * num2;
		
		System.out.println("How much is " + num1 + " times " + num2 + "?");
	}
}

