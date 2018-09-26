package com.lxisoft.ekart;
import com.lxisoft.ekart.outlet.OutletController; 
import com.lxisoft.ekart.warehouse.WarehouseController;
import com.lxisoft.ekart.customer.CustomerController;
import com.lxisoft.ekart.product.Product;
import com.lxisoft.ekart.warehouse.Warehouse;
import com.lxisoft.ekart.customer.Customer;
public class Test
{
    public static void main( String[] args )
    {
        OutletController outletController=new OutletController(new Warehouse(),new Customer());
        WarehouseController warehouseController=new WarehouseController(outletController.getOutlet().getWarehouse());
        warehouseController.addProducts(warehouseController.getAllProducts());
        CustomerController customerController=new CustomerController(outletController.getOutlet().getCustomer());
        customerController.customerLogin();
        do
        {
        	warehouseController.printStock();
        	int requirement;
        	Product product=warehouseController.getProduct(customerController.getSelection(),requirement=customerController.getRequirement());
        	if(product!=null)
            {
                customerController.addToCart(product,requirement);
                warehouseController.removeStock(product,requirement);
            }
        }
        while(customerController.continueShopping());
        outletController.receivePayment(customerController.makePayment());
    }
}
