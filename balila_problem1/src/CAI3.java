/*
 * Change CAI2 to ask only 10 questions and record a percentage of correct answers
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
 * displayCompletionMessage() prints out percentage of questions correct
 * 		If percentage greater than 75%, prints positive message
 * 		If percentage less than 75%, prints negative message
 * 
 * Create main method to test program
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 
{
	// Define constant to limit number of questions asked
	private final int NUM_QUESTIONS = 10;
	
	// Instance variables to hold values for multiplication
	private int num1;
	private int num2;
	private int answer;
	private int response;
	private int correct;
	private double percentage;
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
	
	// Displays percentage of student based on correct and incorrect answers
	private void displayCompletionMessage()
	{
		percentage = (double)correct/NUM_QUESTIONS;
		System.out.printf("Your score was %.0f%%.\n", percentage * 100);
		
		if (percentage < 0.75)
		{
			System.out.println("Please ask your teacher for extra help.");
		}
		else
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
	}
	
	// Prints multiplication question to screen and loops until correct response given
	public void quiz()
	{	
		char choice;
		
		do
		{
			// Resets correct/incorrect responses to 0
			correct = 0;
			
			// Asks 10 questions
			for (int i = 0; i < NUM_QUESTIONS; i++)
			{
				askQuestion();
				readResponse();
				if (isAnswerCorrect() == true)
				{
					correct++;
					displayCorrectResponse();
				}
				else
				{
					displayIncorrectResponse();
				}
			}
			
			displayCompletionMessage();
			
			System.out.println("Would you like to solve another set of problems? (Y/N)");
			choice = stdin.next().charAt(0);
		} while(choice == 'y' || choice == 'Y');
	}
	
	// To test CAI3 class
	public static void main(String[] args)
	{
		CAI3 student = new CAI3();
		
		student.quiz();
	}
}
