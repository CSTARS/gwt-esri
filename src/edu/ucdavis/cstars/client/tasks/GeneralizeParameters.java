package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Sets the geomteries, maximum deviation and units for the generalize operation.
 * 
 * @author Justin Merz
 */
public class GeneralizeParameters extends JavaScriptObject {

	protected GeneralizeParameters() {}
	
	/**
	 * Creates a new GeneralizeParameters object. 
	 * 
	 * @return GeneralizedParameters
	 */
	public static native GeneralizeParameters create() /*-{
		return new $wnd.esri.tasks.GeneralizedParameters();
	}-*/;
	
	/**
	 * The maximum deviation unit. If the unit is not specified, units are derived from the spatial reference. 
	 * 
	 * @return UnitType
	 */
	public final UnitType getDeviationUnit() {
		String du = _getDeviationUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType.values()[i].getValue().contentEquals(du) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getDeviationUnit() /*-{
		return this.deviationUnit;
	}-*/;
	
	/**
	 * Set the deviation unit parameter.
	 * 
	 * @param deviationUnit - The maximum deviation unit. If the unit is not specified, units are derived from the spatial reference. 
	 */
	public final void setDeviationUnit(UnitType deviationUnit) {
		_setDeviationUnit( deviationUnit.getValue() );
	}
	
	private final native void _setDeviationUnit(String deviationUnit) /*-{
		this.deviationUnit = deviationUnit;
	}-*/;
	
	/**
	 * The array of input geometries to generalize.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getGeometries() /*-{
		return this.geometries;
	}-*/;
	
	/**
	 * set the geometries parameter.
	 * 
	 * @param geometries -  All geometries in this array must be of the same geometry type (esriGeometryPolyline or esriGeometryPolygon).
	 */
	public final void setGeometries(Geometry[] geometries) {
		_setGeometries(Util.objectArrayToJSO(geometries));
	}
	
	private final native void _setGeometries(JavaScriptObject geometries) /*-{
		this.geometries = geometries;
	}-*/;
	
	/**
	 * The maximum deviation for constructing a generalized geometry based on the input geomteries.
	 * 
	 * @return double
	 */
	public final native double getMaxDeviation() /*-{
		return this.maxDeviation;
	}-*/;
	
	/**
	 * set the max deviation parameter.
	 * 
	 * @param maxDeviation - The maximum deviation for constructing a generalized geometry based on the input geomteries.
	 */
	public final native void setMaxDeviation(double maxDeviation) /*-{
		this.maxDeviation = maxDeviation;
	}-*/;
	
}
