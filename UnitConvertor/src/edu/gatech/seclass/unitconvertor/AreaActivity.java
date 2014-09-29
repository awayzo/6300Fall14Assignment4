package edu.gatech.seclass.unitconvertor;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AreaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area);
		// Convert Icon into ActionBar. Allows user to return to Main menu from
		// icon
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// -------------------------------------------------------
		Button btnConvert = (Button) findViewById(R.id.btnConvert);
		btnConvert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Get the text value from the text field
				EditText value = (EditText) findViewById(R.id.txtValue);
				EditText answer = (EditText) findViewById(R.id.txtAnswer);
				// Throw in the RadioButton View need for use
				
				// Convert the string to a double
				// -Check for empty value...
				// -If Empty or Null: Default value to
				// 1.0 
				ActivityFactory.setInputValue(value, AreaActivity.this);
				// -Check if user pressed Radio button
				// -If not, it will default to Miles to Kilometers

				// If it is null, it is Miles to Kilometers selected.
				// This means the user pressed Convert without
				// selecting a radio button

				if (ActivityFactory.getSelectedRadio() == null) {

					// get the input from the EditText and use it for the
					// calculations
					answer.setText(ActivityFactory.sqFeetToSqMeters(ActivityFactory
							.getInputValue()) + " sqMeters");

				} else {
					switch (ActivityFactory.getSelectedRadio().getId()) {
					case R.id.radio0:
						// If radio button 1 is active: execute Miles to
						// Kilometers
						answer.setText(ActivityFactory
								.sqFeetToSqMeters(ActivityFactory.getInputValue())
								+ " sqMeters");
						break;
					case R.id.radio1:
						// If radio button 1 is active: execute Kilometers to
						// Miles
						answer.setText(ActivityFactory
								.sqMetersToSqFeet(ActivityFactory.getInputValue())
								+ " sqFeet");
						break;
					default:

						break;
					}

				}

			}

		});

	}
	//The declaration of this function is controlled by
	// the onClick in the Activity_dis.xml
	public void onRadioButtonClicked(View view) {
		ActivityFactory.setSelectedRadio(view);
	}
	
	//---------------------------------------

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.area, menu);
		 Window w = getWindow();
		 w.setTitle("Convert Area");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		Intent intent =null;
		//Handle action bar selection	
		//This allows me to replace three event handlers for one, reducing the code.
		switch (item.getItemId()) {
		case R.id.action_convert_area:
			 intent = new Intent(AreaActivity.this, AreaActivity.class);
			startActivity(intent);
			break;
		case R.id.action_convert_distance:
			intent = new Intent(AreaActivity.this, DisActivity.class);
			startActivity(intent);
		break;
		case R.id.action_convert_currency:
			 intent = new Intent(AreaActivity.this, CurrencyActivity.class);
			startActivity(intent);
		break;
		case R.id.action_settings:
			Toast.makeText(this,  item.getTitle() + ": is not currently active", Toast.LENGTH_LONG).show();
			
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
