/*
 * Change CAI1 to allow for random correct/incorrect response mesages
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
 * 			Randomly select 1 of 4 responses for correct answer
 * 		displayIncorrectResponse() method displays "No. Please try again."
 * 			Randomly select 1 of 4 responses for incorrect answer
 * 
 * Create main method to test program
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 
{
// Instance variables to hold values for multiplication
	private int num1;
	private int num2;
	private int answer;
	private int response;
	private SecureRandom rand = new SecureRandom();
	private Scanner stdin = new Scanner(System.in);
	
	// Assigns num1 and num2 to values and outputs problem to screen
	private void askQuestion()
	{
		// Random numbers in the range of 0-9 inclusive
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		
		// Calculates answer and stores in instance variable
		answer = num1 * num2;
		
		// Outputs question to screen
		System.out.println("How much is " + num1 + " times " + num2 + "?");
	}
	
	// Reads input from User
	private void readResponse()
	{
		response = stdin.nextInt();
	}
	
	// Checks if User input equals the correct answer
	private boolean isAnswerCorrect()
	{
		if (answer == response)
		{
			displayCorrectResponse();
			return true;
		}
		else
		{
			displayIncorrectResponse();
			return false;
		}
	}
	
	private void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	
	private void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
	
	// Prints multiplication question to screen and loops until correct response given
	public void quiz()
	{
		boolean isCorrect;
		
		askQuestion();
		do
		{
			readResponse();
			isCorrect = isAnswerCorrect();
		} while(isCorrect == false);
	}
}
