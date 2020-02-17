/*
 * Change CAI4 to allow for different difficulty settings
 * 
 * -----------------------------------------------------------------------
 * 
 * quiz() method contains program logic
 * 
 * readDifficulty() asks user to choose their difficulty
 * generateQuestionArgument() uses chosen difficulty to create random number
 * readProblemType() asks user to choose type of problem (add., subt., mult., divis.)
 * askQuestion() method prints problem
 * 		Uses rand to generate two numbers
 * 		Uses chosen problem type to change problem output (add., subt., mult., divis.) 
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

public class CAI5 
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
	private int difficulty;
	private int problemType;
	private SecureRandom rand = new SecureRandom();
	private Scanner stdin = new Scanner(System.in);
	
	// Allows user to input a difficulty level (1 - 4)
	private void readDifficulty()
	{
		int choice;
		
		System.out.println("Enter a difficulty level from 1 to 4.");
		do
		{
			choice = stdin.nextInt();
			
			if (choice < 1 || choice > 4)
			{
				System.out.println("Please enter a number from 1 to 4.");
			}
		} while (choice < 1 || choice > 4);
		
		difficulty = choice;
	}
	
	// Creates two random numbers based on readDifficulty()
	private void generateQuestionArgument()
	{
		switch(difficulty)
		{
		case 1:
			// Random numbers in the range of 0-9 inclusive
			num1 = rand.nextInt(10);
			num2 = rand.nextInt(10);
			break;
		case 2:
			// Random numbers in the range of 0-99 inclusive
			num1 = rand.nextInt(100);
			num2 = rand.nextInt(100);
			break;
		case 3:
			// Random numbers in the range of 0-999 inclusive
			num1 = rand.nextInt(1000);
			num2 = rand.nextInt(1000);
			break;
		case 4:
			// Random numbers in the range of 0-9999 inclusive
			num1 = rand.nextInt(10000);
			num2 = rand.nextInt(10000);
			break;
		default:
		}
	}
	
	// Asks user to choose their problem type
	private void readProblemType()
	{
		int choice;
		
		System.out.println("Choose from one of the following problem types:");
		System.out.println("1 - Addition");
		System.out.println("2 - Multiplication");
		System.out.println("3 - Subtraction");
		System.out.println("4 - Division");
		System.out.println("5 - Mixed");
		
		do
		{
			choice = stdin.nextInt();
			
			if (choice < 1 || choice > 5)
			{
				System.out.println("Please enter a number from 1 to 4.");
			}
		} while (choice < 1 || choice > 5);
		
		problemType = choice;
	}
	
	// Assigns answer to product of num1 and num2 and outputs problem to screen based on problemType
	private void askQuestion()
	{
		// Changes output based on problemType
		switch(problemType)
		{
		// Addition problems
		case 1:
			answer = num1 + num2;
			System.out.println("How much is " + num1 + " plus " + num2 + "?");
			break;
			
		// Multiplication problems
		case 2:
			answer = num1 * num2;
			System.out.println("How much is " + num1 + " times " + num2 + "?");
			break;
			
		// Subtraction problems
		case 3:
			answer = num1 - num2;
			System.out.println("How much is " + num1 + " minus " + num2 + "?");
			break;
			
		// Division problems
		case 4:
			// Prevents division by 0
			while (num2 == 0)
			{
				generateQuestionArgument();
			}
			
			// Ensures num1 divides evenly into num2
			num1 += num2 - (num1 % num2);
			
			answer = num1 / num2;
			System.out.println("How much is " + num1 + " divided by " + num2 + "?");
			break;
			
		// Mixed problems
		case 5:
			// Stores problemType temporarily so it can be overwritten
			int temp = problemType;
			
			// Restricts range to 1 - 4 (excludes 5) for recursive call to askQuestion()
			problemType = rand.nextInt(4) + 1;
			askQuestion();
			
			// Resets problemType to original value
			problemType = temp;
			break;
		default:
		}
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
			
			// Asks user to choose difficulty setting (1 - 4)
			readDifficulty();
			
			// Asks user to choose problem type (1 - 5)
			readProblemType();
			
			// Asks 10 questions
			for (int i = 0; i < NUM_QUESTIONS; i++)
			{
				generateQuestionArgument();
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
	
	// To test CAI5 class
	public static void main(String[] args)
	{
		CAI5 student = new CAI5();
		
		student.quiz();
	}
}
