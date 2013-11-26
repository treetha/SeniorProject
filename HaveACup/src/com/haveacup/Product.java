package com.haveacup;


public class Product {
	private long id;
	private String name;
	private String type;
	private double price;
	
	public long getId() {
	    return id;
	  }
	public void setId(long id) {
	    this.id = id;
	  }
	public String getName() {
	    return name;
	  }
	public void setName(String name) {
		    this.name = name;
		}
	public String getType() {
	    return type;
	  }
	public void setType(String type) {
		    this.type = type;
		}
	public double getPrice() {
	    return price;
	  }
	public void setPrice(double price) {
		    this.price = price;
		}
	// Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return name;
	  }
		 
}
