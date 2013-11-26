package com.haveacup;

public class Sale_Item {
	private long item_id;
	private long id;
	private String item_size;
	private String item_type;
	private int item_unit;
	private int item_sugar;
	private boolean item_milk;
	private boolean item_cream;
	private boolean item_syrub;
	private boolean item_shot;
	private double item_total;
	

	public long getId() {
	    return id;
	  }
	public void setId(long id) {
	    this.id = id;
	  }
	
	public long getItemId() {
	    return item_id;
	  }
	public void setItemId(long item_id) {
	    this.item_id = item_id;
	  }
	
	public String getItemSize() {
	    return item_size;
	  }
	public void setItemSize(String size) {
		    this.item_size = size;
		}
	
	public String getItemType() {
	    return item_type;
	  }
	public void setItemType(String type) {
		    this.item_type = type;
		}
	
	public int getItemUnit() {
	    return item_unit;
	  }
	public void setItemUnit(int unit) {
		    this.item_unit = unit;
		}
	
	public int getItemSugar() {
	    return item_sugar;
	  }
	public void setItemSugar(int sugar) {
		    this.item_sugar = sugar;
		}
	
	public boolean getItemMilk() {
	    return item_milk;
	  }
	public void setItemMilk(boolean milk) {
		    this.item_milk = milk;
		}
	
	public boolean getItemCream() {
	    return item_cream;
	  }
	public void setItemCream(boolean cream) {
		    this.item_cream = cream;
		}
	
	public boolean getItemSyrub() {
	    return item_syrub;
	  }
	public void setItemSyrub(boolean syrub) {
		    this.item_syrub = syrub;
		}
	
	public boolean getItemShot() {
	    return item_shot;
	  }
	public void setItemShot(boolean shot) {
		    this.item_shot = shot;
		}
	
	public double getTotalPrice() {
	    return item_total;
	  }
	public void setTotalPrice(double price) {
		    this.item_total = price;
		}
	// Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return item_size;
	  }
		 

}
