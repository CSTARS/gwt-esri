package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Units;

/**
 * A data object containing a linear distance.
 * 
 * @author Justin Merz
 */
public class LinearUnit extends JavaScriptObject {
	
	protected LinearUnit() {}
	
	/**
	 * Creates a new LinearUnit object
	 * 
	 * @return LinearUnit
	 */
	public static native LinearUnit create() /*-{
		return new $wnd.esri.tasks.LinearUnit();
	}-*/;
	
	/**
	 * Specifies the value of the linear distance.
	 * 
	 * @return double
	 */
	public final native double getDistance() /*-{
		return this.distance;
	}-*/;
	
	/**
	 * Set the distance parameter.
	 * 
	 * @param distance - Specifies the value of the linear distance.
	 */
	public final native void setDistance(double distance) /*-{
		this.distance = distance;
	}-*/;
	
	/**
	 * Specifies the unit type of the linear distance.
	 * 
	 * @return Units
	 */
	public final Units getUnits() {
		String u = _getUnits();
		for( int i = 0 ; i < Units.values().length; i++ ){
			if( Units.values()[i].getValue().contentEquals(u) )
				return Units.values()[i];
		}
		return Units.NOT_SET;
	}
	
	private final native String _getUnits() /*-{
		return this.units;
	}-*/;
	
	/**
	 * Set the units parameter.
	 * 
	 * @param units - Specifies the unit type of the linear distance.
	 */
	public final void setUnits(Units units) {
		_setUnits( units.getValue() );
	}
	
	private final native void _setUnits(String units) /*-{
		this.units = units;
	}-*/;

}
