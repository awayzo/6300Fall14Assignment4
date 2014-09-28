package edu.gatech.seclass.unitconvertor;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
public class ActivityFactory {
	private static final double SQMETER_MULTIPLICAN = 10.7639104;
	private static final double SQFEET_MULTIPLICAN = 0.09290304;
	private static final double DEFAULT_INPUT_VALUE = 1.0;
	private static final double MILES_MULTIPLICAND = 1.61;
	private static final double KM_DENOMINATOR = 1.608;
	private static NumberFormat nf = new DecimalFormat("##.###");

	private static View selectedRadio;
	public static View getSelectedRadio() {
		return selectedRadio;
	}

	public static void setSelectedRadio(View selectedRadio) {
		ActivityFactory.selectedRadio = selectedRadio;
	}

	private static double inputValue;


	public static double getInputValue() {
		return inputValue;
	}

	public static void setInputValue(double _inputValue) {
	inputValue = _inputValue;
	}
//-----------------------Miles and Km Below-------------------------------------------
	//Set the radio button to current view to check if it is empty

	public static String milesToKm(double miles) {
		//Format the output to prevent long strings of numbers
		 String kmValue =null;
		// Get inputValue in Kilometers
		double km = miles * MILES_MULTIPLICAND;
		kmValue =nf.format(km);
		if (miles != 0) {

			return String.valueOf(kmValue);

		} else {
			miles = 0;
			return String.valueOf(kmValue);
		}

	}

	public static String kmToMiles(double km) {
		//Format the output to prevent long strings of numbers
		 String milesValue =null;
		// Get inputValue in Miles
		double miles = km / KM_DENOMINATOR;
		milesValue = nf.format(miles);
		if (km != 0) {
			return String.valueOf(milesValue);

		} else {
			km = 0;
			return String.valueOf(milesValue);
		}

	}

//-----------------sqFeet and sqMeters Below------------------------------
		//Set the radio button to current view to check if it is empty

		public static String sqFeetToSqMeters(double sqFeet) {
			//Format the output to prevent long strings of numbers
			 String sqMetersValue =null;
			// Get inputValue in Miles
			double sqMeters = sqFeet * SQFEET_MULTIPLICAN;
			sqMetersValue = nf.format(sqMeters);
			if (sqMeters != 0) {
				return String.valueOf(sqMetersValue);

			} else {
				sqFeet = 0;
				return String.valueOf(sqMetersValue);
			}

		}

		public static String sqMetersToSqFeet(double sqMeter) {
			//Format the output to prevent long strings of numbers
			 String sqFeetValue =null;
			// Get inputValue in Miles
			double sqFeet = sqMeter * SQMETER_MULTIPLICAN;
			sqFeetValue = nf.format(sqFeet);
			if (sqMeter != 0) {
				return String.valueOf(sqFeetValue);

			} else {
				sqMeter = 0;
				return String.valueOf(sqFeetValue);
			}

		}
		//-----------------Dollars to Euros Below------------------------------
				//Set the radio button to current view to check if it is empty

				public static String dollarsToEuros(double sqFeet) {
					//Format the output to prevent long strings of numbers
					 String sqMetersValue =null;
					// Get inputValue in Miles
					double sqMeters = sqFeet * SQFEET_MULTIPLICAN;
					sqMetersValue = nf.format(sqMeters);
					if (sqMeters != 0) {
						return String.valueOf(sqMetersValue);

					} else {
						sqFeet = 0;
						return String.valueOf(sqMetersValue);
					}

				}

				public static String eurosToDollars(double sqMeter) {
					//Format the output to prevent long strings of numbers
					 String sqFeetValue =null;
					// Get inputValue in Miles
					double sqFeet = sqMeter * SQMETER_MULTIPLICAN;
					sqFeetValue = nf.format(sqFeet);
					if (sqMeter != 0) {
						return String.valueOf(sqFeetValue);

					} else {
						sqMeter = 0;
						return String.valueOf(sqFeetValue);
					}

				}
			//---------------------------------------------------------------

	public static void setInputValue(EditText value, Context context) {
		if(isEmpty(value)){
			 inputValue =DEFAULT_INPUT_VALUE;
			 value.setText("1.0");
			 Toast.makeText(context, "No number was entered:Default to 1:1",
						Toast.LENGTH_SHORT).show();
			
		}else{
			
			inputValue = Double.parseDouble(value.getText().toString());
			
		}
	}	
	
		//check if EditText is Empty
	private static boolean isEmpty(EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    }

	
//====end
}
