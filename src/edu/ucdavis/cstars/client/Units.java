package edu.ucdavis.cstars.client;

/**
 * ESRI unit constants.
 * 
 * @author Justin Merz
 */
public enum Units {
	NOT_SET(""),
	CENTIMETERS("esriCentimeters"),
	DECIMAL_DEGREES("esriDecimalDegrees"),	 
	DECIMETERS("esriDecimeters"),
	FEET("esriFeet"),
	INCHES("esriInches"),
	KILOMETERS("esriKilometers"),
	METERS("esriMeters"),
	MILES("esriMiles"),
	MILLIMETERS("esriMillimeters"),
	NAUTICAL_MILES("esriNauticalMiles"),
	POINTS("esriPoints"),
	UNKNOWN("esriUnknownUnits"),
	YARDS("esriYards");

	private String val;
	
	private Units(String value){
		val = value;
	}
	
	public String getValue(){
		return val;
	}
	
}
