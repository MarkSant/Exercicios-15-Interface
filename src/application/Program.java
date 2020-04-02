package application;
import java.util.*;
import java.text.*;
import entities.*;
import services.*;

public class Program
{
		public static void main(String[] args) throws ParseException
		{
				Locale.setDefault(Locale.US);
				Scanner sc = new Scanner(System.in);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				System.out.println("Enter contract data");
				System.out.print("Number - ");
				int numContract = sc.nextInt();
				System.out.print("Date (dd/MM/yyyy) - ");
				Date dateContract = sdf.parse(sc.next());
				System.out.println("Value - ");
				double valorTotal = sc.nextDouble();
				
				Contract contract = new Contract(numContract, dateContract, valorTotal, new Paypal());
				
				System.out.println();
				System.out.print("Enter the number of installments - ");
				int nMeses = sc.nextInt();
				
				System.out.println();
				System.out.println("Installents");
				for(int i = 0; i < nMeses; i++){
						Date[] datasV = contract.datasParcelas(nMeses);
						double[] vaoresV = contract.valoresParcelas(nMeses);
						System.out.println(sdf.format(datasV[i]) + " - " + vaoresV[i]);
				}
				sc.close();	
		}
}
