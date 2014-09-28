package edu.gatech.seclass.unitconvertor;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.view.Window;

public class DisActivity extends ActionBarActivity {

	View selectedRadio;
	RadioGroup g;
	boolean checked;
	int selected;
	RadioButton b;
	double distance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dis);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		// -------------------------------------------------------

		// -------------------------------------------------------
		g = (RadioGroup) findViewById(R.id.radioGroupDistance);

		// Returns an integer which represents the selected radio button's ID
		selected = g.getCheckedRadioButtonId();

		// Gets a reference to our "selected" radio button
		b = (RadioButton) findViewById(selected);

		// Now I can get the text or whatever I want from the "selected" radio
		// button
		// b.getText();
		// Toast.makeText(DisActivity.this, b.getText(),
		// Toast.LENGTH_SHORT).show();

		// -------------------------------------------------------
		Button btnConvert = (Button) findViewById(R.id.btnConvert);
		btnConvert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Get the text value from the text field
				EditText value = (EditText) findViewById(R.id.txtValue);
				EditText answer = (EditText) findViewById(R.id.txtAnswer);
			
				// Convert the string to a double
	//---------------------Check for empty EditText...	
	//---------------------If Empty or Null: Default EditText to 1.0 and Set distance to 1.0
				
				
				if(isEmpty(value)){
					 distance =1.0;
					 value.setText("1.0");
					 Toast.makeText(DisActivity.this, "No number was entered: Defaulting to 1 Mile to Kilometers",
								Toast.LENGTH_SHORT).show();
					
				}else{
					
					distance = Double.parseDouble(value.getText().toString());
				
					
				}
//---------------------------Check if user pressed Radio button
//---------------------------If not, it will default to Miles to Kilometers
				
				
				if (selectedRadio == null) {
					// If it is null, it is Miles to Kilometers selected.
					// This means the user just pushed the Button without
					// selecting a radio button
				
					answer.setText(milesToKm(distance) + " km" );


				} else {
					switch (selectedRadio.getId()) {
					case R.id.radio0:
						//If radio button 1 is active: execute Miles to Kilometers
						answer.setText(milesToKm(distance)+ " km");
						break;
					case R.id.radio1:
						//If radio button 1 is active: execute Kilometers to Miles
						answer.setText(kmToMiles(distance) + " miles");
						break;
					default:

						break;
					}

				}

			}
		});

		// ===============================================================

	}
	//check if EditText is Empty
	private boolean isEmpty(EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    }
	
	//Set the radio button to current view to check if it is empty
	public void onRadioButtonClicked(View view) {
		selectedRadio = view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dis, menu);
		// MenuItem item = menu.add(R.string.convert_currency);

		// Create an event listener to add functionality to
		// item.setOnMenuItemClickListener(new
		// MenuItem.OnMenuItemClickListener() {
		//
		// @Override
		// public boolean onMenuItemClick(MenuItem item) {
		// Intent intent = new Intent(DisActivity.this, CurrencyActivity.class);
		// startActivity(intent);
		// return false;
		// }
		// });
		
		// w will dynamically change the title on the action bar using setTitle
		Window w = getWindow();
		w.setTitle("Convert Distance");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		Intent intent = null;
		// Handle action bar selection
		// This allows me to replace three event handlers for one, reducing the
		// code.
		//Intents to change activity
		switch (item.getItemId()) {
		case R.id.action_convert_area:
			intent = new Intent(DisActivity.this, AreaActivity.class);
			startActivity(intent);
			break;
		case R.id.action_convert_distance:
			intent = new Intent(DisActivity.this, DisActivity.class);
			startActivity(intent);
			break;
		case R.id.action_convert_currency:
			intent = new Intent(DisActivity.this, CurrencyActivity.class);
			startActivity(intent);
			break;
		case R.id.action_settings:
			Toast.makeText(this, item.getTitle() + ": is not currently active",
					Toast.LENGTH_LONG).show();

			break;
		case android.R.id.home:
			finish();

			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void handleClick(View view) {
		// dynamically changing header with getWindow

		// See which Radio Button is clicked

		// Get the text value from the text field
		EditText value = (EditText) findViewById(R.id.txtValue);
		// Convert the string to a double
		double distance = Double.parseDouble(value.getText().toString());

		switch (view.getId()) {
		case R.id.radioGroupArea:
			if (checked)
				// on btn click

				value.setText(kmToMiles(distance));
			break;
		case R.id.radioGroupCurrency:
			if (checked)

				value.setText(milesToKm(distance));
			break;
		}
	}

	public String milesToKm(double miles) {
		//Format the output to prevent long strings of numbers
		 DecimalFormat df = new DecimalFormat("#.###");
		// Get distance in Kilometers
		double km = miles * 1.61;
		df.format(km);
		if (miles != 0) {

			return String.valueOf(km);

		} else {
			miles = 0;
			return String.valueOf(km);
		}

	}

	public String kmToMiles(double km) {
		//Format the output to prevent long strings of numbers
		 DecimalFormat df = new DecimalFormat("#.###");
		// Get distance in Miles
		double miles = km / 1.608;
		df.format(miles);
		if (km != 0) {
			return String.valueOf(miles);

		} else {
			km = 0;
			return String.valueOf(miles);
		}

	}
}
