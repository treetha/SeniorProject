package com.haveacup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

  public static final String TABLE_PRODUCT = "product";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_TYPE = "type";
  public static final String COLUMN_PRICE = "price";
  ///////////////////////////////////////////////////
  public static final String TABLE_SALE_ITEM = "sale_item";
  public static final String COLUMN_ITEM_ID = "_id_item";
  public static final String COLUMN_ITEM_SIZE = "item_size";
  public static final String COLUMN_ITEM_TYPE = "item_type";
  public static final String COLUMN_ITEM_UNIT = "item_unit";
  public static final String COLUMN_ITEM_SUGAR = "item_sugar";
  public static final String COLUMN_ITEM_MILK = "item_milk";
  public static final String COLUMN_ITEM_CREAM = "item_cream";
  public static final String COLUMN_ITEM_SYRUB = "item_syrub";
  public static final String COLUMN_ITEM_SHOT = "item_shot";
  public static final String COLUMN_ITEM_TOTAL = "item_total";
  public static final String COLUMN_ITEM_PRODUCT = "item_pro";
  
  
  


  private static final String DATABASE_NAME = "haveacup.db";
  private static final int DATABASE_VERSION = 2;
  
  //constructor
  public MySQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

  // Database creation sql statement
  private static final String DATABASE_CREATE = "create table "
      + TABLE_PRODUCT + "(" + COLUMN_ID + " integer primary key autoincrement," 
	  + COLUMN_NAME + " text , " 
      + COLUMN_TYPE + " text , "
      + COLUMN_PRICE + " real);";
  
  
  private static final String DATABASE_CREATE_SALE_ITEM = "create table "
	      + TABLE_SALE_ITEM + "(" + COLUMN_ITEM_ID + " integer primary key autoincrement," 
		  + COLUMN_ITEM_SIZE + " text , " 
	      + COLUMN_ITEM_TYPE + " text , "
	      + COLUMN_ITEM_SUGAR + " integer,"
	      + COLUMN_ITEM_MILK + " integer,"
	      + COLUMN_ITEM_CREAM + " integer,"
	      + COLUMN_ITEM_SYRUB + " integer,"
	      + COLUMN_ITEM_SHOT + " integer,"
	      + COLUMN_ITEM_TOTAL + " real,"
	      + COLUMN_ITEM_UNIT + " integer,"
	      + COLUMN_ITEM_PRODUCT + " integer,"
	      + " FOREIGN KEY ("+COLUMN_ITEM_PRODUCT+") REFERENCES "+TABLE_PRODUCT+" ("+COLUMN_ID+"));";

  

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
    database.execSQL(DATABASE_CREATE_SALE_ITEM);
    
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w(MySQLiteHelper.class.getName(),
        "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_SALE_ITEM);
    onCreate(db);
  }
  
  public long addProduct(String name,String type,double price)
  {
	  ContentValues values = new ContentValues();
	    values.put(COLUMN_NAME, name);
	    values.put(COLUMN_TYPE, type);
	    values.put(COLUMN_PRICE, price);
	    SQLiteDatabase db = this.getWritableDatabase();
	    long row = db.insert(MySQLiteHelper.TABLE_PRODUCT,null,values);
	    Log.d(TABLE_PRODUCT,"insert at row " + row + "" + name + type + price);
	    db.close();
	    return row; 
  }
  
  public long addSaleItem(String size,String type,int sugar,int milk,int cream,int shot,int syrub,double total,int unit,long id)
  {
	  ContentValues values = new ContentValues();
	    values.put(COLUMN_ITEM_SIZE, size);
	    values.put(COLUMN_ITEM_TYPE, type);
	    values.put(COLUMN_ITEM_SUGAR, sugar);
	    values.put(COLUMN_ITEM_MILK, milk);
	    values.put(COLUMN_ITEM_CREAM, cream);
	    values.put(COLUMN_ITEM_SHOT, shot);
	    values.put(COLUMN_ITEM_SYRUB, syrub);
	    values.put(COLUMN_ITEM_TOTAL, total);
	    values.put(COLUMN_ITEM_UNIT, unit);
	    values.put(COLUMN_ITEM_PRODUCT, id);
	   
	    SQLiteDatabase db = this.getWritableDatabase();
	    long row = db.insert(MySQLiteHelper.TABLE_SALE_ITEM,null,values);
	    Log.d(TABLE_SALE_ITEM,"insert at row " + row + "" + size + type + sugar+ milk+ cream+ shot+ syrub+ total+unit+ id);
	    db.close();
	    return row; 
  }
  
  public String[] getMenu(long id)
  {
	  String[] data = null;
	  SQLiteDatabase db = this.getWritableDatabase();
	  String[] column = {"_id","name","type","price"};
	  Cursor c = db.query(TABLE_PRODUCT,
			  column,
			  "_id=?",new String[] {String.valueOf(id)},
			  null,null,null,null
			  );
	  if (c != null)
	  {
		  if(c.moveToFirst())
		  {
			  int idCol = c.getColumnIndex("_id");
			  int nameCol = c.getColumnIndex("name");
			  int typeCol = c.getColumnIndex("type");
			  int priceCol = c.getColumnIndex("price");
			  
			  String strId = Integer.toString(0);
			  String strName = c.getString(1);
			  String strType = c.getString(2);
			  String strPrice = Integer.toString(c.getInt(priceCol));
			  
			  data = new String[]{strName,strType,strPrice};
		  }
	  }
	  c.close();
	  return data;
  }
  
  public Cursor getAllProduct()
  {
	  SQLiteDatabase db = this.getWritableDatabase();
	  String[] columns = {"_id","name","type","price"};
	  String[] conditionArgs = {"COFFEE"};
	  Cursor cur = db.query(TABLE_PRODUCT, columns, "type = ?", conditionArgs, null, null, null);
	  Log.d(TABLE_PRODUCT,"count" + cur.getCount());
	  return cur;
	  
  }
  public Cursor getAllTea()
  {
	  SQLiteDatabase db = this.getWritableDatabase();
	  String[] columns = {"_id","name","type","price"};
	  String[] conditionArgs = {"TEA"};
	  Cursor cur = db.query(TABLE_PRODUCT, columns, "type = ?", conditionArgs, null, null, null);
	  Log.d(TABLE_PRODUCT,"count" + cur.getCount());
	  return cur;
	  
  }
  public Cursor getAllJuice()
  {
	  SQLiteDatabase db = this.getWritableDatabase();
	  String[] columns = {"_id","name","type","price"};
	  String[] conditionArgs = {"JUICE"};
	  Cursor cur = db.query(TABLE_PRODUCT, columns, "type = ?", conditionArgs, null, null, null);
	  Log.d(TABLE_PRODUCT,"count" + cur.getCount());
	  return cur;
	  
  }

}
