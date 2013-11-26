package com.haveacup;

import android.app.Activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MyArrayAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] title;
	private final String[] price;
	
	public MyArrayAdapter(Activity context,String[] titles,String[] prices){
		super(context,R.layout.row_layout,titles);
		this.context = context;
		this.title= titles;
		this.price = prices;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		Log.d("myarrayadapter",String.valueOf(position));
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.row_layout,null,true);
		
		TextView tvTitle = (TextView) rowView.findViewById(R.id.txtTitle);
		TextView tvPrice = (TextView) rowView.findViewById(R.id.txtPrice);
		tvTitle.setText(title[position]);
		tvPrice.setText(price[position]);
		return rowView;
		
	}
}
