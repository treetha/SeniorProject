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

public class ListJuice extends ListFragment {
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private MySQLiteHelper mydb;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mydb = new MySQLiteHelper(getActivity());
		cursor = mydb.getAllJuice();
		adapter = new SimpleCursorAdapter(
						getActivity(),
						R.layout.row_layout,
						cursor,
						new String[] {"name","price"},
						new int[] {R.id.txtTitle,R.id.txtPrice},
						0);
		setListAdapter(adapter);
		/*super.onCreate(savedInstanceState);
		titles = new String[] {
				"���","�й��","�ͻ����","ʵ���������","�����"
		};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_activated_1, titles);
		setListAdapter(adapter);*/	
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		//Toast.makeText(getActivity(), "selected" + titles[position], Toast.LENGTH_LONG).show();
		Intent intent = new Intent(getActivity(), SelectedMenu.class);
		Cursor cursor = (Cursor) adapter.getItem(position);
		intent.putExtra("recID", cursor.getInt(cursor.getColumnIndex("_id")));
		startActivity(intent);
	}
	

}

