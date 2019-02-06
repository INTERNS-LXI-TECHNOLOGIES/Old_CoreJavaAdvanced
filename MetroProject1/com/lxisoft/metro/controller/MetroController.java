package com.lxisoft.metro.controller;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import com.lxisoft.metro.model.Metro;
import com.lxisoft.metro.model.Train;
import com.lxisoft.metro.model.Admin;
import com.lxisoft.metro.model.Ticket;
import com.lxisoft.metro.model.Passenger;
public class MetroController{

	Metro metro=new Metro();
	TrainController traincntrl=new TrainController();
	Scanner input=new Scanner(System.in);
	File file=new File("./com/lxisoft/metro/AdminDetails.txt");
	File file1=new File("./com/lxisoft/metro/PaasengerDetails.txt");
	

	public void homePage(){
		traincntrl.trainDetails(metro);
		String yn;
		do{
			
			System.out.println("1.Train Details........2.Ticket Reservation.....3.Search Train......4.Admin Login......\n ");
			String ch=input.next();
			int choice=Integer.parseInt(ch);
			switch(choice)
			{
				case 1:traincntrl.viewTrains();
						break;
				case 2:ticketReservation();
						break;
				case 3:traincntrl.searching();
						break;
				case 4:adminLogin();
						break;		

			}
			System.out.println("Do u wanna continue(Y/N)");
			yn=input.next();
		}while(yn.equals("Y")||yn.equals("y"));
	}
	public void ticketReservation(){
		try{
			FileWriter fw=new FileWriter(file1,true);
			Train train;
			System.out.println("Ticket Reservation");
			train=traincntrl.searching();
			fw.write(train.getTrainName()+";");
			System.out.println("Do you want to reserve the ticket?(1/0)");
			String choice=input.next();
			int ch=Integer.parseInt(choice);
			if(ch==1){
				System.out.println("Enter the Passenger name:");
				String pName=input.next();
				fw.write(pName+";");
				System.out.println("Enter the age");
				String age=input.next();
				fw.write(age+";");
				Passenger pass=new Passenger(pName,age);
				ArrayList<Passenger> passList=new ArrayList<Passenger>();
				passList.add(pass);
				metro.setPassenger(passList);
				int no=1;
				System.out.println("Compartments");
				for(int c=0;c<train.getCompartment().size();c++){
					
					System.out.println(no+" "+train.getCompartment().get(c).getCompartmentType());
					no++;
				}
				System.out.println("select the compartment");
				String sele=input.next();
				int select=Integer.parseInt(sele);
				for(int se=1;se<=train.getCompartment().size();se++){

					if(select==se){
						
						int s=se;
						s--;
						fw.write(train.getCompartment().get(s).getCompartmentType()+";");
						System.out.println(train.getCompartment().get(s).getSeats());
						System.out.println("select the seat number");
						String seno=input.next();
						int seat=Integer.parseInt(seno);
						System.out.println(train.getCompartment().get(s).getSeats().size());
						for(int sel=1;sel<=train.getCompartment().get(s).getSeats().size();sel++){

							if(seat==sel){
								int rs=0;
								rs=seat;
								rs--;
								fw.write(train.getCompartment().get(s).getSeats().get(rs).getSeatNo()+"\n");
								
								System.out.println("you reserved the ticket\n");
								createTicket(pName,age,train.getTrainName(),train.getCompartment().get(s).getCompartmentType(),train.getCompartment().get(s).getSeats().get(rs).getSeatNo());
								train.getCompartment().get(s).getSeats().remove(rs);
								
								break;
							}
							
						}
					}


				}
			}
			fw.close();
		}
		catch(Exception e){

			e.printStackTrace();
		}

	}
	public void adminLogin(){


		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			Admin admin;
			int flag=0;
			String line;

			while((line=br.readLine())!=null){
				String data[]=line.split(";");
				admin=new Admin(data[0],data[1]);
				metro.setAdmin(admin);
			}
			do{
				System.out.println("*****ADMIN LOGIN*****");
				String uname,pwd;
			
				System.out.println("User Name: ");
				uname=input.next();
				System.out.println("Password: ");
				pwd=input.next();
				

				if((uname.equals(metro.getAdmin().getUserName()))&&(pwd.equals(metro.getAdmin().getPassword()))){
					System.out.println("login success");
					flag=1;
				}
				else {
					System.out.println("login failure...please Re-enter username and Password");
					flag=0;
				}

				
			}while(flag==0);
			
		String con;
		do{
			System.out.println("1.Add Train Details...2.Delete Train Details....3.View Passenger Details....");
			String ch=input.next();
			int choice=Integer.parseInt(ch);
			
			switch(choice){

				case 1:traincntrl.addTrainDetails(metro);
					break;
				case 2:traincntrl.deleteTrain();
					break;
				case 3:passengerDetails();
					break;
			}
			System.out.println("Do u wanna continue(Y/N)");
			con=input.next();
		}while(con.equals("Y")||con.equals("y"));
		br.close();
			fr.close();
		

		}
		catch(Exception e){

			e.printStackTrace();
		}
		
	}
	public void passengerDetails(){
		try{

			FileReader fr=new FileReader(file1);
			BufferedReader br=new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null){
				
				String data[]=line.split(";");
				System.out.println("Passenger Name:"+data[1]);

				System.out.println("Age: "+data[2]);

				System.out.println("Train: "+data[0]);

				System.out.println("Compartment: "+data[3]);

				System.out.println("Seat No: "+data[4]);

			}
			br.close();
			fr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	public void createTicket(String passName,String agee,String tName,String compartType,int seatNo){

		Ticket ticket=new Ticket(passName,agee,tName,compartType,seatNo);
		ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
		ticketList.add(ticket);
		metro.setTicket(ticketList);
		System.out.println("*************Train Ticket***************");
		System.out.println("| Name :	"+passName+"		");
		System.out.println("|"+"						");
		System.out.println("| Age :		"+agee+"				");
		System.out.println("|"+"						");
		System.out.println("| Train Name :	"+tName+"				");
		System.out.println("|"+"						"); 
		System.out.println("| Compartment :	"+compartType+"		");
		System.out.println("|"+"			");
		System.out.println("|"+" Seat No :	"+seatNo+"		");
		System.out.println("|"+"						");
		System.out.println("****************************************");
	}
 	

}