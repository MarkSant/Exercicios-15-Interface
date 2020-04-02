package services;

public interface PaymentService
{
		double paymentService(double amount);
		
		double getInterest(double amount, int months);
}
