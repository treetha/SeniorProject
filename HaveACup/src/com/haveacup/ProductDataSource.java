package com.haveacup;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ProductDataSource {
	// Database fields
	  private SQLiteDatabase database;
	  private MySQLiteHelper dbHelper;
	  private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
	      MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_TYPE, MySQLiteHelper.COLUMN_PRICE };

	  public ProductDataSource(Context context) {
	    dbHelper = new MySQLiteHelper(context);
	  }

	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public Product createProduct(String name, String type,double price) {
		  name = "Espresso";
		  type = "COFFEE";
		  price = 40;
	    ContentValues values = new ContentValues();
	    values.put(MySQLiteHelper.COLUMN_NAME, name);
	    values.put(MySQLiteHelper.COLUMN_TYPE, type);
	    values.put(MySQLiteHelper.COLUMN_PRICE, price);
	    
	    long insertId = database.insert(MySQLiteHelper.TABLE_PRODUCT, null,
	        values);
	    
	    Cursor cursor = database.query(MySQLiteHelper.TABLE_PRODUCT,
	        allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Product newProduct = cursorToProduct(cursor);
	    cursor.close();
	    return newProduct;
	  }

	  public void deleteProduct(Product name) {
	    long id = name.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(MySQLiteHelper.TABLE_PRODUCT, MySQLiteHelper.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<Product> getAllProduct() {
	    List<Product> products = new ArrayList<Product>();

	    Cursor cursor = database.query(MySQLiteHelper.TABLE_PRODUCT,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Product product = cursorToProduct(cursor);
	      products.add(product);
	      cursor.moveToNext();
	    }
	    // make sure to close the cursor
	    cursor.close();
	    return products;
	  }

	  private Product cursorToProduct(Cursor cursor) {
	    Product product = new Product();
	    product.setId(cursor.getLong(0));
	    product.setName(cursor.getString(1));
	    product.setType(cursor.getString(2));
	    product.setPrice(cursor.getDouble(3));
	    
	    return product;
	  }
}
