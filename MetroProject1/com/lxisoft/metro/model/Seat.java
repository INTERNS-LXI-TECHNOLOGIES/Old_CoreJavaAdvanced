package com.lxisoft.metro.model;

public class Seat{

	private int seatNo;

	public Seat(int seatNo){

		this.seatNo=seatNo;
	}
	public int getSeatNo(){

		return seatNo;
	}
	public String toString(){

		return seatNo+" ";
	}
}