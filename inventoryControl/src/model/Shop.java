package model;
import controller.*;
import java.io.*;
import java.util.*;


public class Shop {
	
	
	private String shopName ;

	private int totalSales ;

	private List<Customer> customers;

	private Inventory inventory ;

	private InventoryController inventoryController ;

	private SaleController  saleController ;

	private Scanner in;
	
	Customer customer;

		public Shop() {
		Properties p = new Properties();
		p.setProperty("shopName","Inventory Shoppie");
		p.setProperty("State","");
		p.setProperty("Addrss","");
		p.setProperty("Street","");
		p.setProperty("District","");
		p.setProperty("Contry","");
		try {
			p.store(new FileWriter("configuration"),"Details");
			FileReader reader;
			reader = new FileReader("configuration");
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.getProperty("shopName"));
		
		home();
		

		//@Create Customers in Shop

		setCustomers(new ArrayList<Customer>());
		

		//@Create Inventory in Shop

		inventory = new Inventory();
		try {
			inventoryController = new InventoryController(inventory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		saleController = new SaleController();


		}
 
		public void home()
			{
			System.out.println("[1.SignUp]    [2.Start buy]");
			in = new Scanner(System.in);
			int selectInput=in.nextInt();
			switch(selectInput)
			{
			case 1://customerSignUp();			
			break;
			case 2:initSale();
			        break;
			}
			
			}

       
        
      //@Conduct sale
		 public void initSale(){

		inventoryController.displayStock();	
		
		System.out.print("Select product and quantity : ");
		int selection=in.nextInt();
		int quantity=in.nextInt();
		
		Product product=inventoryController.getProduct(selection,quantity);
		double cost=product.getPrice()*quantity;
		//customerDetails();
			if(customer.getCashInHand()>=cost)
			{
				saleController.sell(product,quantity);
				inventoryController.changeStock(product,quantity);
				customer.setCashInHand(customer.getCashInHand()-cost);
				setTotalSales(getTotalSales() + cost);
			}
			else
			{
				System.out.println("Sorry... \n You have less Money...");
			}
		}
   

		public void setShopName(String shopName)
		{
			this.shopName = shopName;
		}

		public String getShopName()
		{
			return shopName;
		}

		public void setInventory(Inventory inventory)
		{
			this.inventory = inventory;
		}

		public Inventory getInventory()
		{
			return inventory;
		}

		public int getTotalSales() {
			return totalSales;
		}

		public void setTotalSales(double d) {
			this.totalSales = (int) d;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}

}
