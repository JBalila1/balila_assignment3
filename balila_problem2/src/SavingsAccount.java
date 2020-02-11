public class SavingsAccount 
{
	// Instance variables for SavingsAccount
	private static double annualInterestRate;
	private double savingsBalance;
	
	// Constructor to instantiate savingsBalance variable
	public SavingsAccount(double s)
	{
		setSavingsBalance(s);
	}
	
	// Sets annualInterestRate
	public static void modifyInterestRate(double rate)
	{
		annualInterestRate = rate;
	}
	
	// Calculates one month's interest based on the annual interest rate
	public void calculateMonthlyInterest()
	{
		savingsBalance += (savingsBalance * annualInterestRate) / 12.0;
	}
	
	// Sets savingsBalance and checks to make sure that it is greater than or equal to 0
	public void setSavingsBalance(double balance)
	{
		if (balance < 0)
		{
			System.out.println("Balance cannot be negative.");
			return;
		}
		
		savingsBalance = balance;
	}
	
	// Returns savingsBalance
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
}
