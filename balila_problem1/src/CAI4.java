/*
 * Change CAI3 to allow for different difficulty settings
 * 
 * -----------------------------------------------------------------------
 * 
 * quiz() method contains program logic
 * 
 * readDifficulty() asks user to choose their difficulty
 * generateQuestionArgument() uses chosen difficulty to create random number
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

public class CAI4 
{
// Define constant to limit number of questions asked
private final int NUM_QUESTIONS = 10;

// Instance variables to hold values for multiplication
private int num1;
private int num2;
private int answer;
private int response;
private int correct;
private int incorrect;
private double percentage;
private int difficulty;
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

// Assigns answer to product of num1 and num2 and outputs problem to screen
private void askQuestion()
{
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
		incorrect = 0;
		
		// Asks user to choose difficulty setting (1 - 4)
		readDifficulty();
		
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
				incorrect++;
				displayIncorrectResponse();
			}
		}
		
		displayCompletionMessage();
		
		System.out.println("Would you like to solve another problem? (Y/N)");
		choice = stdin.next().charAt(0);
	} while(choice == 'y' || choice == 'Y');
}

// To test CAI1 class
public static void main(String[] args)
{
	CAI4 student = new CAI4();
	
	student.quiz();
}
}
