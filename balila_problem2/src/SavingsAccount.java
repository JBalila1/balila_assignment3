
public class SavingsAccount 
{
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double s)
	{
		savingsBalance = s;
	}
	
	public static void modifyInterestRate(double rate)
	{
		annualInterestRate = rate;
	}
	
	public void calculateMonthlyInterest()
	{
		savingsBalance = (savingsBalance * annualInterestRate) / 12;
	}
}
