package com.lxisoft.metro.controller;
import com.lxisoft.metro.model.*;
import com.lxisoft.metro.view.*;
import java.util.*;
import java.io.*;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class MetroController{
	Metro metro;
	MetroView metroView;
	TrainController trainControl;
	Passenger passenger;
	Scanner scan= new Scanner(System.in);
	Date date=new Date();
	File adminDetails= new File("./com/lxisoft/metro/file/AdminDetails.txt");

	public MetroController(){
		metro = new Metro();
		metroView = new MetroView();
		trainControl = new TrainController();
	}
	
	public void homePage(){	
	dateFormating();
	int x;
	metroView.printHomeView(date);
		String choice = scan.nextLine();
		int key = Integer.parseInt(choice);			
		switch(key){
		case 1: adminLogin();	
		break;
		case 2:trainControl.loadTrainDetailsFile(metro);
			   printTrains();
		break;
		default: metroView.defaultCase();
		homePage();}
	}
	private void dateFormating(){
	String strDate;
	date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
    strDate = dateFormat.format(date);

	}
	
	public void adminLogin(){
		String userName,passWord,line;
		Admin admin;
		Console con = System.console(); 
       
		int count=0;
		metroView.enterUserName();userName=scan.next();
		metroView.enterPassWord();
		char[] ch=con.readPassword();    
		passWord=String.valueOf(ch);//converting char array into string  
		try{
			
				FileReader fr=new FileReader(adminDetails);
				BufferedReader br=new BufferedReader(fr);	
				while((line=br.readLine())!=null){
					String[] data = line.split(";");
					String userName1=data[0];
					String passWord1=data[1];
					admin=new Admin(userName1,passWord1);
					metro.setAdmin(admin);
				}
				do{		
				if(userName.equals(metro.getAdmin().getUserName()) && passWord.equals(metro.getAdmin().getPassWord())){
					metroView.loginSucceed();
					String choice = scan.next();
					int key = Integer.parseInt(choice);			
					switch(key){
					case 1: trainControl.addTrainDetails(metro,metroView);
							//printTrains();					
					break;
					case 2:addPassengerDetails();
							printPassengerDeatils();
							searchForPassenger();
					break;
					default: metroView.defaultCase();}
							count++;
					}else {
					metroView.loginFailed();
					adminLogin();
					}
				}while(false);
			}catch(IOException e){
			System.out.println("Error");}		
	}
	
	
	public void printTrains(){
		int x;
		do{
		metroView.selectOrder();
		String option = scan.next();
		int key = Integer.parseInt(option);			
		switch(key){
			/*case 1: trainControl.sortTrainsByName(metro);;					
			break;
			case 2:trainControl.sortTrainsByArraivalTime(metro);
			break;
			case 3:trainControl.sortByDestination(metro);
			break;
			case 4:trainControl.iteratorMethod(metro);
			break;*/
			case 1:trainControl.printTrainSet(metro);
			break;
			case 2:trainControl.searchingTrains(metro,metroView);
			break;
			/*case 6:trainControl.searchByStartAndDestination(metro,metroView);
			break;*/
			
			
			default:metroView.defaultCase();
		}
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);	
	}
	
	public void addPassengerDetails(){
		String name,mobileNumber;int x;
		do{
		metroView.enterPassengerName();
		metro.setPassenger(new Passenger(scan.next().toUpperCase()));
		metroView.enterMobileNumber();
		metro.getPassenger().setMobileNumber(scan.next());
		metro.getPassengers().put(metro.getPassenger().getName(),metro.getPassenger());
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);	
		
	}
//backed collection methods.......
	
/*	public void passengerSorting(){
	
	SortedMap<String, Passenger> submap;
//submap = metro.getPassengers().subMap("C","T"); // #1 create a backed collection
//submap = metro.getPassengers().headMap("C");
submap = metro.getPassengers().tailMap("C");
System.out.println(metro.getPassengers() + " " + submap);
	}*/
	public void printPassengerDeatils(){
		System.out.println(metro.getPassengers());
		
		
		// String methods...............
		/*String s1 = "spring ";
String s2 = s1 + "summer ";
String s3=s1.concat("fall ");
System.out.println(s1);
System.out.println(s2);
System.out.println(s3);
String s4=s2.concat(s1);
s1 += "wiNter ";
System.out.println(s1+"123".toString());
System.out.println(s1+"123");
System.out.println(s1.toLowerCase());
System.out.println(s1.toUpperCase());
System.out.println(s1.length());
System.out.println(s1.replace("s","X"));
System.out.println(s1 + " " + s2);*/

	}
	
	public void searchForPassenger(){
		// searching passenger using the backed collections
		String search;int x;
		SortedMap<String, Passenger> submap;
		do{
		metroView.enterSearchKey();
		search=scan.next().toUpperCase();
		submap = metro.getPassengers().tailMap(search);

		//System.out.println(submap);
		System.out.println(submap.get(search));
		metroView.enterOption();String choice = scan.next();
		x = Integer.parseInt(choice);}while(x==1);		
	}
	
//not working code block
/*public void addPlatform(){	

metro.setPlatform(new Platform());}	
try {
FileOutputStream fs = new FileOutputStream("./com/lxisoft/metro/file/Platform.txt");
ObjectOutputStream os = new ObjectOutputStream(fs);

os.writeObject(metro.getPlatform());
os.close();
} catch (Exception e) { e.printStackTrace(); }
try{
FileInputStream fis = new FileInputStream("./com/lxisoft/metro/file/Platform.txt");
ObjectInputStream ois = new ObjectInputStream(fis);
for(int i=0;i<5;i++){
platform = (Platform[]) ois.readObject();
System.out.println(platform);
}
ois.close();
} catch (Exception e) { e.printStackTrace(); }
}
*/
// example of console readPassword() method....
/*Console c=System.console();
        char[] ch=c.readPassword();    
		String name=String.valueOf(ch);//converting char array into string    
        System.out.println(name); */
}