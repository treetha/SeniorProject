package com.haveacup;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SelectedMenu extends Activity {
	
	private static final String TAG = "mydb";
	public double totals;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_menu);
		setupActionBar();
		////////////////////////////////////////////////
		
		int recID = getIntent().getIntExtra("recID", 0);
		Log.i(TAG,"recid" + recID);
		
		MySQLiteHelper mydb = new MySQLiteHelper(this);
		String[] strData = mydb.getMenu(recID);
		
		TextView tv = (TextView) findViewById(R.id.txtMenu);
		tv.setText(strData[0]);
		tv.setTextSize(22);

		final String price = strData[2];
		totals = Double.valueOf(price).doubleValue();
		TextView tvSize = (TextView) findViewById(R.id.textView4);
		tvSize.setText(String.valueOf(totals));
		
		RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		//final int selectedSize = radioGroup1.getCheckedRadioButtonId();
		
		radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
		
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total;
				RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
				int selectedType = radioGroup2.getCheckedRadioButtonId();
				totals = Double.valueOf(price).doubleValue();
				if (checkedId == R.id.radio0 && selectedType == R.id.radio0)
				{
					
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					
					total = String.valueOf(totals);
					tv.setText(total);
					
					
				}
				else if (checkedId == R.id.radio0 && selectedType == R.id.radio1)
				{ 
					totals = totals + 10;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio0 && selectedType == R.id.radio2)
				{ 
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio1 && selectedType == R.id.radio0)
				{
					totals = totals + 10;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
					
					/*radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
						
						@Override
						public void onCheckedChanged(RadioGroup group, int checkedId) {
							TextView tv = (TextView) findViewById(R.id.textView4);
							//String total = tv.getText().toString();
							double p = Double.valueOf(total).doubleValue();
							if (checkedId == R.id.radio0 && selectedSize == R.id.radio1)
							{
								tv.setText(String.valueOf(p));
							}
							else if (checkedId == R.id.radio1 && selectedSize == R.id.radio1)
							{
								p = p + 10;
								//total = String.valueOf(p);
								tv.setText(String.valueOf(p));
								//item.setItemSize("ICE");
							}
							else if (checkedId == R.id.radio2  && selectedSize == R.id.radio1)
							{
								p = p + 20;
								//total = String.valueOf(p);
								tv.setText(String.valueOf(p));
								//item.setItemSize("BLENDED");
							}
						}
					});*/
				}
				
				else if (checkedId == R.id.radio1 && selectedType == R.id.radio1)
				{ 
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio1 && selectedType == R.id.radio2)
				{ 
					totals = totals + 30;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				
				
				else if (checkedId == R.id.radio2 && selectedType == R.id.radio0)
				{
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
					
					/*radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					
						@Override
						public void onCheckedChanged(RadioGroup group, int checkedId) {
							TextView tv = (TextView) findViewById(R.id.textView4);
							//String total = tv.getText().toString();
							double p = Double.valueOf(total).doubleValue();
							if (checkedId == R.id.radio0  && selectedSize == R.id.radio2)
							{
								tv.setText(String.valueOf(p));
							}
							else if (checkedId == R.id.radio1  && selectedSize == R.id.radio2)
							{
								p = p + 10;
								//total = String.valueOf(p);
								tv.setText(String.valueOf(p));
								//item.setItemSize("ICE");
							}
							else if (checkedId == R.id.radio2 && selectedSize == R.id.radio2)
							{
								p = p + 20;
								//total = String.valueOf(p);
								tv.setText(String.valueOf(p));
								//item.setItemSize("BLENDED");
							}
						}
					});*/
				}
				/////////////////////else
				else if (checkedId == R.id.radio2 && selectedType == R.id.radio1)
				{
					totals = totals + 30;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio2 && selectedType == R.id.radio2)
				{
					totals = totals + 40;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
			}
		});	
		
		RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
		final int selectedType = radioGroup2.getCheckedRadioButtonId();
		radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
		
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				TextView tv = (TextView) findViewById(R.id.textView4);
				totals = Double.valueOf(price).doubleValue();
				String total;
				RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
				int selectedSize = radioGroup1.getCheckedRadioButtonId();

				if (checkedId == R.id.radio0 && selectedSize == R.id.radio0)
				{
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio0 && selectedSize == R.id.radio1)
				{ 
					totals = totals + 10;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio0 && selectedSize == R.id.radio2)
				{ 
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio1 && selectedSize == R.id.radio0)
				{
					totals = totals + 10;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
}
				
				else if (checkedId == R.id.radio1 && selectedSize == R.id.radio1)
				{ 
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio1 && selectedSize == R.id.radio2)
				{ 
					totals = totals + 30;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				
				
				else if (checkedId == R.id.radio2 && selectedSize == R.id.radio0)
				{
					totals = totals + 20;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				/////////////////////else
				else if (checkedId == R.id.radio2 && selectedSize == R.id.radio1)
				{
					totals = totals + 30;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
				else if (checkedId == R.id.radio2 && selectedSize == R.id.radio2)
				{
					totals = totals + 40;
					CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
					if (cb1.isChecked()){
						totals += 10;	
					}
					CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
					if (cb2.isChecked()){
						totals += 10;	
					}
					CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
					if (cb3.isChecked()){
						totals += 10;	
					}
					CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
					if (cb4.isChecked()){
						totals += 10;	
					}
					total = String.valueOf(totals);
					tv.setText(total);
				}
			}
		});	
				/*
		RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
		radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total = tv.getText().toString();
				double p = Double.valueOf(total).doubleValue();
				switch(checkedId)
				{
				case R.id.radio0:
					total = String.valueOf(p);
					tv.setText(total);
					//item.setItemSize("HOT");
					break;
				case R.id.radio1:
					p = p + 10;
					total = String.valueOf(p);
					tv.setText(total);
					//item.setItemSize("ICE");
					//p = p + 10;
					break;
				case R.id.radio2:
					p = p + 20;
					total = String.valueOf(p);
					tv.setText(total);
					//item.setItemSize("BLENDED");
					break;
				
				}
				
			}
		});*/
		
		SeekBar sugarLv = (SeekBar) findViewById(R.id.seekBar1);
		sugarLv.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progressChanged = 0;
			String change;
			TextView tv = (TextView) findViewById(R.id.textView7);
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
				progressChanged = progress;
				change = String.valueOf(progressChanged);
				tv.setText(change);}
			public void onStartTrackingTouch(SeekBar seekBar) {}
			public void onStopTrackingTouch(SeekBar seekBar) {
				change = String.valueOf(progressChanged);
				tv.setText(change);}
			});
	
		CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//double check;
				if (((CheckBox) v).isChecked()) {
					totals += 10;
					
				}
				else{
					totals -= 10;
				}
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total = String.valueOf(totals);
				tv.setText(total);
			}
			
		});
		
		CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		cb2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//double check;
				if (((CheckBox) v).isChecked()) {
					//check = 10;
					totals += 10;
					
				}
				else{
					totals -= 10;
				}
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total = String.valueOf(totals);
				tv.setText(total);
			}
			
		});
		CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		cb3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//double check;
				if (((CheckBox) v).isChecked()) {
					totals += 10;
					
				}
				else{
					totals -= 10;
				}
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total = String.valueOf(totals);
				tv.setText(total);
			}
			
		});
		CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		cb4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//double check;
				if (((CheckBox) v).isChecked()) {
					totals += 10;
					
				}
				else{
					totals -= 10;
				}
				TextView tv = (TextView) findViewById(R.id.textView4);
				String total = String.valueOf(totals);
				tv.setText(total);
			}
			
		});
		
	}
	
	public void addSaleItem(View view)
	{

		int recID = getIntent().getIntExtra("recID", 0);
		MySQLiteHelper mydb = new MySQLiteHelper(this);
		//String[] strData = mydb.getMenu(recID);
		//String price = strData[2];
		//double p = Double.valueOf(price).doubleValue();
		//Sale_Item item = new Sale_Item();
		//item.setTotalPrice(p);
		long result;
		String size=null;
		String type=null;
		int sugar,milk,cream,shot,syrub;
		//double total;
		RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		int selectedSize = radioGroup1.getCheckedRadioButtonId();
		switch(selectedSize)
		{
		case R.id.radio0: 
			size = "SMALL";
			break;
		case R.id.radio1:
			size = "MEDIUM";
			break;
		case R.id.radio2:
			size = "LARGE";
			break;
		}
		RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
		int selectedType = radioGroup2.getCheckedRadioButtonId();
		switch(selectedType)
		{
		case R.id.radio0: 
			type = "HOT";
			break;
		case R.id.radio1:
			type = "ICE";
			break;
		case R.id.radio2:
			type = "BLENDED";
			break;
		}
		
		TextView sugarLv = (TextView) findViewById(R.id.textView7);
		sugar = Integer.parseInt(sugarLv.getText().toString());
		
		CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
		if (cb1.isChecked()){
			cream = 1;	
		}
		else cream = 0;
		CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
		if (cb2.isChecked()){
			syrub = 1;	
		}
		else syrub = 0;
		CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
		if (cb3.isChecked()){
			milk = 1;	
		}
		else milk = 0;
		CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
		if (cb4.isChecked()){
			shot = 1;	
		}
		else shot = 0;
		result = mydb.addSaleItem(size,type,sugar,milk,cream,shot,syrub,totals,1,recID);
		
		
		Intent itn = new Intent (this,Sale_Order.class);
		itn.putExtra("itemID",result);
		startActivity(itn);
		
		/*
		RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
		int selectedType = radioGroup2.getCheckedRadioButtonId();
		switch(selectedType)
		{
		case R.id.radio0: 
			item.setItemType("HOT");
			break;
		case R.id.radio1:
			item.setItemType("ICE");
			p = p + 5;
			break;
		case R.id.radio2:
			item.setItemType("BLENDED");
			p = p + 20;
			break;
		
		}*/
		//String totalprice = String.valueOf(p);
		//TextView tv = (TextView) findViewById(R.id.textView4);
		//tv.setText(totalprice);
		
		
	}
	

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_menu, menu);
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

}
