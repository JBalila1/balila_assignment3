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
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Randomly selects 1 of 4 responses upon receiving a correct answer
	private void displayCorrectResponse()
	{
		int choice = rand.nextInt(4);
		switch(choice)
		{
		case 0:
			System.out.println("Very good!");
			break;
		case 1:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice work!");
			break;
		case 3:
			System.out.println("Keep up the good work!");
			break;
		default:
			// Should not reach default case based on range of choice (0 - 3)
			break;
		}
	}
	
	// Randomly selects 1 of 4 responses upon receiving an incorrect answer
	private void displayIncorrectResponse()
	{
		int choice = rand.nextInt(4);
		switch(choice)
		{
		case 0:
			System.out.println("No. Please try again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don't give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		default:
			// Should not reach default case based on range of choice (0 - 3)
			break;
		}
	}
	
	// Prints multiplication question to screen and loops until correct response given
	public void quiz()
	{
		askQuestion();
		do
		{
			readResponse();
			if (isAnswerCorrect() == true)
			{
				displayCorrectResponse();
			}
			else
			{
				displayIncorrectResponse();
			}
		} while(isAnswerCorrect() == false);
	}
	
	// To test CAI1 class
	public static void main(String[] args)
	{
		CAI2 student = new CAI2();
		
		student.quiz();
	}
}
