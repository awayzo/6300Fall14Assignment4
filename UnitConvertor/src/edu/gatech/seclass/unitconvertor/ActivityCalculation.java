package edu.gatech.seclass.unitconvertor;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ActivityCalculation {
	private static NumberFormat nf = new DecimalFormat("##.###");
	
	//private NumberFormat nf = NumberFormat.getNumberInstance(loc);
	public static String milesToKm(double miles) {
		//Format the output to prevent long strings of numbers
		 String kmValue =null;
		// Get distance in Kilometers
		double km = miles * 1.61;
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
		// Get distance in Miles
		double miles = km / 1.608;
		milesValue = nf.format(miles);
		if (km != 0) {
			
			return String.valueOf(milesValue);

		} else {
			km = 0;
			
			return String.valueOf(milesValue);
		}

	}
//====end
}