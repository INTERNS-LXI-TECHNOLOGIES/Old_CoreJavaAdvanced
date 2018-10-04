package model;

import java.util.HashMap;

public class Customer {

	public Customer() {
		// TODO Auto-generated constructor stub
	}   private String userName;
		private String name ;
		private double cashInHand ;
		private String passWord;
		private String email;
		private String address;
		private int postCode;
		private long contactNumber;
		private HashMap<Product,Integer> cart;

		public void setName(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}

		public void setCashInHand(double cashInHand){
			this.cashInHand = cashInHand;
		}

		public double getCashInHand(){
			return cashInHand;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}


		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getPostCode() {
			return postCode;
		}

		public void setPostCode(int postCode) {
			this.postCode = postCode;
		}

		public long getContactNumber() {
			return contactNumber;
		}

		public void setContactNum(long contactNumber) {
			this.contactNumber = contactNumber;
		}

		public HashMap<Product,Integer> getCart() {
			return cart;
		}

		public void setCart(HashMap<Product,Integer> cart) {
			this.cart = cart;
		}

}
