package com.lxisoft.metro.view;
import com.lxisoft.metro.model.*;
import java.util.*;

public class MetroView{
	
	public void printHomeView(Date date){
		System.out.println("---------------------------");
		System.out.println(">>>>>>>>>>>METRO<<<<<<<<<<<<");
		System.out.println("---------------------------");
		System.out.println(date);
		System.out.println("1.Admin 2.Train details 3.Passenger Details");
		
	}
	public void enterUserName(){
		System.out.println("******ADMIN LOGIN******");
		
		System.out.println("UserName");
	}
	
	public void enterPassWord(){
		System.out.println("Password::");
		
	}
	public void defaultCase(){
		System.out.println("Invalied Input..... Try Again");
	}
	public void loginSucceed(){
		
		System.out.println("Login Successfull......");
		System.out.println("1.Add Train details ");
	}
	public void loginFailed(){
		
		System.out.println("Login Failed......Try Again.........");
	}
	
	public void enterTrainName(){
		System.out.println("Train Name::");
	}
	public void enterTrainNum(){
		System.out.println("Train Number::");
	}
	public void enterArraivalTime(){
		System.out.println("Arraival Time::");
	}
	public void enterDepartureTime(){
		System.out.println("Departure Time::");
	}
	public void enterStartPoint(){
		System.out.println("Starting point::");
	}
	public void enterDestination(){
		System.out.println("Destination::");
	}
	public void enterOption(){
		System.out.println("Do you want to continue?  [1.Continue]  [0.Exit] ");
	}
	public void printTrainDetails(Train trains){
		System.out.println("Train:"+trains);
	}
	public void selectSortOrder(){
		System.out.println("Select your order.......\n[1.Sort by Train Names][2.Sort by ArraivalTimes][3.Sort By Destination]");
		
	}
	public void enterSearchKey(){
		System.out.println("Enter the search key");
	}
	public void enterPassengerName(){
		System.out.println("Name::");
	}
	public void enterMobileNumber(){
		System.out.println("Mobile Number::");
	}
}