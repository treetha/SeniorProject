package com.haveacup;

import android.app.ListFragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Listcoffee extends ListFragment {
	
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private MySQLiteHelper mydb;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mydb = new MySQLiteHelper(getActivity());
		//long result;
		//result = 
		//mydb.addProduct("Mocca", "COFFEE", 25);
		//mydb.addProduct("Americano", "COFFEE", 30);
		cursor = mydb.getAllProduct();
		adapter = new SimpleCursorAdapter(
						getActivity(),
						R.layout.row_layout,
						cursor,
						new String[] {"name","price"},
						new int[] {R.id.txtTitle,R.id.txtPrice},
						0);
		setListAdapter(adapter);
		
		//datasource = new ProductDataSource(getActivity());
	    //datasource.open();

	   // List<Product> values = datasource.getAllProduct();
	    
	    // use the SimpleCursorAdapter to show the
	    // elements in a ListView
	   // ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(getActivity(),
	   //     android.R.layout.simple_list_item_1, values);
	   // setListAdapter(adapter);
		
		/*titles = new String[] {
				"Capuchino","Mocca","Espresso","Americano"
		};
		prices = new String[] {
				"40B","40B","40B","35B"
		};
		
		MyArrayAdapter adapter = new MyArrayAdapter(getActivity(),titles,prices);
		setListAdapter(adapter);*/	
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		
		Intent intent = new Intent(getActivity(), SelectedMenu.class);
		Cursor cursor = (Cursor) adapter.getItem(position);
		intent.putExtra("recID", cursor.getInt(cursor.getColumnIndex("_id")));
		startActivity(intent);
	}
}
