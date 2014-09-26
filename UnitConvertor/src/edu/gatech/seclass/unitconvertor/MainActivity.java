package edu.gatech.seclass.unitconvertor;

import edu.gatech.seclass.unitconvertor.R;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.*;


public class MainActivity extends ActionBarActivity {
	private static final String LOGTAG = "MainActivity";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// allow Up navigation with the app icon in the action bar, call
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Log.d(LOGTAG, "onCreate");
	//=====================================	
		Button btnArea = (Button)findViewById(R.id.btnArea);
		btnArea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, AreaActivity.class);
				startActivity(intent);
				
			}
		});
	//===================================	
		Button btnDistance = (Button)findViewById(R.id.btnDistance);
		btnDistance.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			Intent intent = new Intent(MainActivity.this, DisActivity.class);
			startActivity(intent);
				
			}
		});
	//=========================================	
		Button btnCurrency = (Button)findViewById(R.id.btnCurrency);
		btnCurrency.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, CurrencyActivity.class);
				startActivity(intent);
				
			}
		});
		//=========================
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onResume(){
		
		super.onResume();
		Log.d(LOGTAG, "onResume");
		
	}
	@Override
	protected void onStart(){
		
		super.onStart();
		Log.d(LOGTAG, "onStart");
		
	}
	public String milesToKm(double miles) {
		double km = miles * 1.608;
		if (miles != 0) {

			return String.valueOf(km);

		} else {
			miles = 0;
			return String.valueOf(km);
		}

	}

	public String kmToMiles(double km) {
		double miles = km / 1.608;
		if (km != 0) {
			return String.valueOf(miles);

		} else {
			km = 0;
			return String.valueOf(miles);
		}

	}

	public void handleClick(View view) {
		// dynamically changing header with getWindow
		Window w = getWindow();
		// See which Radio Button is clicked
		boolean checked = ((RadioButton) view).isChecked();
		EditText txt = (EditText) findViewById(R.id.txt1);

		double distance = Double.parseDouble(txt.getText().toString());

		switch (view.getId()) {
		case R.id.radio0:
			if (checked)
				w.setTitle("Converter: Kilometer to Miles");
			txt.setText(kmToMiles(distance));
			break;
		case R.id.radio1:
			if (checked)
				w.setTitle("Converter: Miles to Kilometer");
			txt.setText(milesToKm(distance));
			break;
		}
	}

//	public void goToCurrency(View v) {
//		// onBtnClick defined in manifest
//		Intent intent = new Intent(this, AreaActivity.class);
//		
//		startActivity(intent);
//
//	}
//	public void goToDistance(View v){
//		
//		Intent intent = new Intent(this, DistanceActivity.class);
//		startActivity(intent);
//	}
}
