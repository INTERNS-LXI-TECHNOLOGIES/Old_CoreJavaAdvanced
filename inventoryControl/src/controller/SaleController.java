package controller;
import java.util.Date;
import model.*;

public class SaleController {

	public SaleController() {
		// TODO Auto-generated constructor stub
	}

	public void sell(Product productShopped, int quantity){
			Date date= new Date();
			System.out.println(date+"\n\nItem sold :"+productShopped+"\n"+"Quantity : "+quantity);
			double cost=totalAmount(productShopped,quantity);
			System.out.println("Total cost : "+cost);
		}
	public double totalAmount(Product productShopped,int quantity){
			return productShopped.getPrice()*quantity;
		}

}
