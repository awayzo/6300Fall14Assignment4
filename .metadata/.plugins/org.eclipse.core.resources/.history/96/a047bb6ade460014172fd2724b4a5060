package edu.gatech.seclass.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class AreaActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area);
		// Convert Icon into ActionBar. Allows user to return to Main menu from
		// icon
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

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
