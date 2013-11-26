package com.haveacup;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;



public class ListMenu extends Activity implements TabListener {
	
	private static final String TAG = "haveacup";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_menu);
		
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.addTab(actionBar.newTab()
				.setText("Coffee")
				.setTabListener(this));
		
		actionBar.addTab(actionBar.newTab()
				.setText("Tea")
				.setTabListener(this));
		
		actionBar.addTab(actionBar.newTab()
				.setText("Juice")
				.setTabListener(this));
	}
	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragTran){	
	}
	
	
	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragTran) {
		// TODO Auto-generated method stub
		Log.d(TAG,"tab pos" + tab.getPosition());
		switch (tab.getPosition()){
		case 0:
			Listcoffee listCoffee = new Listcoffee();
			
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, listCoffee).commit();
			break;
			
		case 1:
			ListTea listTea = new ListTea();
			
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, listTea).commit();
			break;  
			
		case 2:
			ListJuice listJuice = new ListJuice();
			
			getFragmentManager().beginTransaction().replace(R.id.fragment_container, listJuice).commit();
			break; 
		}
		
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragTran) {
		// TODO Auto-generated method stub
		
	}
	
}
