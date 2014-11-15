package com.srisqlite.sqliteinsert;

public class Product {
	
	
	private int serial_no;
	private String product_name;
	private double price;
	
	
	public int getSerial_no() {
		return serial_no;
	}


	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	
	public String toString() {
	
	    return product_name;
	    }


}
