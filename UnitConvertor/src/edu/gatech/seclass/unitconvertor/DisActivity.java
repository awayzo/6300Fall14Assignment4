package edu.gatech.seclass.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.view.Window;

public class DisActivity extends ActionBarActivity {

	private View selectedRadio;
	//private RadioGroup g;
	private boolean checked;
	//private int selected;
	//private RadioButton b;
	private double distance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dis);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		// -------------------------------------------------------

		// -------------------------------------------------------
		//g = (RadioGroup) findViewById(R.id.radioGroupDistance);

		// Returns an integer which represents the selected radio button's ID
		//selected = g.getCheckedRadioButtonId();

		// Gets a reference to our "selected" radio button
		//b = (RadioButton) findViewById(selected);

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
				
					answer.setText(ActivityCalculation.milesToKm(distance) + " km" );


				} else {
					switch (selectedRadio.getId()) {
					case R.id.radio0:
						//If radio button 1 is active: execute Miles to Kilometers
						answer.setText(ActivityCalculation.milesToKm(distance) + " km");
						break;
					case R.id.radio1:
						//If radio button 1 is active: execute Kilometers to Miles
						answer.setText(ActivityCalculation.kmToMiles(distance) + " miles");
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


}
