package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Sets the lengthunits other parameters for Lengths operation.
 * 
 * @author Justin Merz
 */
public class LengthsParameters extends JavaScriptObject {
	
	protected LengthsParameters() {}
	
	/**
	 * Creates a new LengthsParameter object.
	 * 
	 * @return LengthsParameters
	 */
	public native static LengthsParameters create() /*-{
		return new $wnd.esri.tasks.LengthsParameters();
	}-*/;
	
	/**
	 * If polylines are in geographic coordinate system, then geodesic needs to be set to true in order to
	 * calculate the ellipsoidal shortest path distance between each pair of the vertices in the polylines.
	 * The output if lengthUnit if not specified is returned in meters.
	 * 
	 * @return boolean
	 */
	public final native boolean isGeodesic() /*-{
		return this.geodesic;
	}-*/;
	
	/**
	 * Set the geodesic parameter
	 * 
	 * @param geodesic -  If polylines are in geographic coordinate system, then geodesic needs to be set to true in order to
	 * calculate the ellipsoidal shortest path distance between each pair of the vertices in the polylines.
	 * The output if lengthUnit if not specified is returned in meters.
	 */
	public final native void setGeodesic(boolean geodesic) /*-{
		this.geodesic = geodesic;
	}-*/;
	
	/**
	 * The length unit in which perimeters of polygons will be calculated. It can be any esriUnits constant. If unit is not
	 * specified, the units are derived from sr
	 * 
	 * @return UnitType
	 */
	public final UnitType getLengthUnit() {
		String lu = _getLengthUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType.values()[i].getValue().contentEquals(lu) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getLengthUnit() /*-{
		return this.lengthUnit;
	}-*/;
	
	/**
	 * Set the length unit parameter.
	 * 
	 * @param lengthUnit - The length unit in which perimeters of polygons will be calculated. It can be any esriUnits
	 * constant. If unit is not specified, the units are derived from sr
	 */
	public final void setLengthUnit(UnitType lengthUnit) {
		_setLengthUnit( lengthUnit.getValue() );
	}
	
	private final native void _setLengthUnit(String lengthUnit) /*-{
		this.lengthUnit = lengthUnit;
	}-*/;

	/**
	 * The array of polylines whose lengths are to be computed. The spatial reference of the polylines is specified by sr.
	 * The structure of each polyline in the array is same as the structure of the JSON polyline objects returned by the
	 * ArcGIS REST API.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getPolylines() /*-{
		return this.polylines;
	}-*/;
	
	/**
	 * Set the polylines parameter.
	 * 
	 * @param polylines - The array of polylines whose lengths are to be computed. The spatial reference of the polylines
	 * is specified by sr. The structure of each polyline in the array is same as the structure of the JSON polyline objects
	 * returned by the ArcGIS REST API.
	 */
	public final void setPolylines(Geometry[] polylines) {
		_setPolylines(Util.objectArrayToJSO(polylines));
	}
	
	private final native void _setPolylines(JavaScriptObject polylines) /*-{
		this.polylines = polylines;
	}-*/;
	
}
