package controller;
import model.*;
import java.util.*;

public class InventoryController {
	
	Inventory inventories;
	List<Product> inventory ;

		public InventoryController(Inventory inventories) throws Exception
		{
			this.inventories=inventories;
			addProducts();
		}
	//add products to map
		public void addProducts() throws Exception
		{
			Product product=createProduct(1,"Mango","Fruits",20);
			addStockToInventory(product,3);
			product=createProduct(2,"Mobile","Electronics",1500);
			addStockToInventory(product,7);
			product=createProduct(3,"Froke","Kids wear",300);
			addStockToInventory(product,5);
			product=createProduct(4,"fan","Electronics",400);
			addStockToInventory(product,6);
		}
		
	//create product
		public Product createProduct(int id,String name,String description,double price)
		{
			return new Product(id,name,description,price);
		}
	//@override
		public void addStockToInventory( Product productToAdd, int quantityToadd)
		{
			inventories.getStock().put(productToAdd,quantityToadd);
		}
	//@override
		public void removeStockFromInventory(Product productToRemove,int quantityToRemove)
		{
			int availableQuantity=(int)(inventories.getStock().get(productToRemove));
			availableQuantity-=quantityToRemove;
			inventories.getStock().put(productToRemove,availableQuantity);
		}
		
		public void displayStock()
		{
				HashMap<Product,Integer> stock=inventories.getStock();
				int count=0;
				for(Map.Entry entry:stock.entrySet())
				{  
					System.out.println("\n"+(++count)+". "+entry.getKey()+"\n\tStock: "+entry.getValue()+"\n\tUnit price:Rs."+((Product)entry.getKey()).getPrice());  
				}  
		}
		public Product getProduct(int selection,int quantity)
		{
			HashMap<Product,Integer> storage=inventories.getStock();
			inventory = new ArrayList<Product>(storage.keySet());
			Product product= inventory.get(selection-1);
			//if(isAvailable(product,quantity))
			return product;
			}
		//}
		//else 
		//{
		//	System.out.println("Sorry, the quantity you selected is not currently available.");
		//	return null;
		//}
			/*public boolean isAvailable(Product product, int quantity)
			{
				int availableQuantity=(int)(inventories.getStock().get(product));
				if(quantity<=availableQuantity)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

		
		}*/
		public void changeStock(Product product,int quantity)
		{
			int availableQuantity=(int)(inventories.getStock().get(product));
			if(quantity<=availableQuantity)
			{
				removeStockFromInventory(product,quantity);
			}
			else
			{
				System.out.println("Out of stock");
				System.exit(0);
			}
		}
	}


