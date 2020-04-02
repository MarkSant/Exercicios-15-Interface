package entities;
import java.util.*;
import services.*;

public class Contract
{
		int numContract;
		Date dataContrato;
		double valorTotal;
		PaymentService paymentService;

		public Contract(int numContract, Date dataContrato, double valorTotal, PaymentService paymentService)
		{
				this.numContract = numContract;
				this.dataContrato = dataContrato;
				this.valorTotal = valorTotal;
				this.paymentService = paymentService;
		}
		
		public double[] valoresParcelas (int nMeses) {
				double valorBase = valorTotal / nMeses;
				double[] parcelas = new double[nMeses];

				for (int i = 0; i < nMeses; i++){

						double val1 = valorBase + paymentService.getInterest(valorBase, i);
						double val2 = val1 + paymentService.paymentService(valorBase);
					
						parcelas[i] = val2;


				}
				
				return parcelas;
		}
		
		public Date[] datasParcelas(int nMeses){
				
				Date[] datas = new Date[nMeses];
				for (int i = 0; i < nMeses; i++){
						Calendar cal = Calendar.getInstance();
						cal.setTime(dataContrato);
						cal.add(Calendar.MONTH, i+1);
						Date vencimento = cal.getTime();
						
						datas[i] = vencimento;
				}
				return datas;
		}

		public void setNumContract(int numContract)
		{
				this.numContract = numContract;
		}

		public int getNumContract()
		{
				return numContract;
		}

		public void setDataContrato(Date dataContrato)
		{
				this.dataContrato = dataContrato;
		}

		public Date getDataContrato()
		{
				return dataContrato;
		}

		public void setValorTotal(double valorTotal)
		{
				this.valorTotal = valorTotal;
		}

		public double getValorTotal()
		{
				return valorTotal;
		}
}
