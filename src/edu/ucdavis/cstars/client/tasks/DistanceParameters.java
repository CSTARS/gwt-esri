package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Input parameters for the distance method on the GeometryService. Geometry1 and geometry2 are required.
 * 
 * @author Justin Merz
 */
public class DistanceParameters extends JavaScriptObject {
	
	protected DistanceParameters() {};
	
	/**
	 * Creates a new DistanceParameters object. 
	 * 
	 * @return DistanceParameters
	 */
	public static native DistanceParameters create() /*-{
		return new $wnd.esri.tasks.DistanceParameters();
	}-*/;

	/**
	 * Specifies the units for measuring distance between geometry1 and geometry2. If the unit is not specified the
	 * units are derived from the spatial reference.
	 * 
	 * @return UnitType
	 */
	public final UnitType getDistanceUnit() {
		String ut = _getDistanceUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType .values()[i].getValue().contentEquals(ut) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getDistanceUnit() /*-{
		return this.distanceUnit;
	}-*/;
	
	/**
	 * Set the disance unit parameter.
	 * 
	 * @param distanceUnit - Specifies the units for measuring distance between geometry1 and geometry2. If the unit
	 * is not specified the units are derived from the spatial reference.
	 */
	public final void setDistanceUnit(UnitType distanceUnit) {
		_setDistanceUnit( distanceUnit.getValue() );
	};
	
	private final native void _setDistanceUnit(String distanceUnit ) /*-{
		this.distanceUnit = distanceUnit;
	}-*/;
	
	/**
	 * Default value is false. When true the geodesic distance between geometry1 and geometry2 is measured.
	 * 
	 * @return boolean
	 */
	public final native boolean isGeodesic() /*-{
		return this.geodesic;
	}-*/;
	
	/**
	 * Set the geodesic parameter
	 * 
	 * @param geodesic - Default value is false. When true the geodesic distance between geometry1 and geometry2 is measured.
	 */
	public final native void setGeodesic(boolean geodesic) /*-{
		this.geodesic = geodesic;
	}-*/;
	
	/**
	 * The geometry from which the distance is to measured. The geometry can be one of the following geometry types:
	 * esriGeometryPoint, esriGeometryPolyline, esriGeometryPolygon or esriGeometryMultipoint.
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry1() /*-{
		return this.geometry1;
	}-*/;
	
	/**
	 * Set the geometry1 parameter.
	 * 
	 * @param geometry1 - The geometry from which the distance is to measured. The geometry can be one of the following
	 * geometry types: esriGeometryPoint, esriGeometryPolyline, esriGeometryPolygon or esriGeometryMultipoint.
	 */
	public final native void setGeometry1(Geometry geometry1) /*-{
		this.geometry1 = geometry1
	}-*/;
	
	/**
	 * The geometry to which the distance is measured. The geometry can be one of the following geomtry types: esriGeometryPoint,
	 * esriGeometryPolyline, esriGeometryPolygon or esriGeometryMultipoint.
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry2() /*-{
		return this.geometry2;
	}-*/;
	
	/**
	 * set the geometry2 parameter.
	 * 
	 * @param geometry2 - The geometry to which the distance is measured. The geometry can be one of the following geomtry
	 * types: esriGeometryPoint, esriGeometryPolyline, esriGeometryPolygon or esriGeometryMultipoint.
	 */
	public final native void setGeometry2(Geometry geometry2) /*-{
		this.geometry2 = geometry2
	}-*/;
	
	
}
