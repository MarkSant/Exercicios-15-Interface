package services;

public class Paypal implements PaymentService
{

		double interest = 0.01;
		double tax = 0.02;

		@Override
		public double paymentService(double ammount)
		{
				return ammount * tax ;
				
		}
		@Override
		public double getInterest(double ammount, int months) {
				return ammount * interest * months;
		}

		
		
		

	
}
