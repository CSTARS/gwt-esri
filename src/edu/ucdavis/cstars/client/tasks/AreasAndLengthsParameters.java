package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Input parameters for the areasAndLengths() method on the Geometry Serivce. Sets the lengthunits,areaUnit and other parameters.
 * 
 * @author Justin Merz
 */
public class AreasAndLengthsParameters  extends JavaScriptObject {

	protected  AreasAndLengthsParameters() {}
	
	/**
	 * Creates a new AreasAndLengthsParameters object.
	 * 
	 * @return AreaAndLengthsParameters
	 */
	public static native AreasAndLengthsParameters create() /*-{
		return new $wnd.esri.tasks.AreaAndLengthsParameters();
	}-*/;
	
	/**
	 * The area unit in which areas of polygons will be calculated.
	 * 
	 * @return UnitType
	 */
	public final UnitType getAreaUnit() {
		String au = _getAreaUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType.values()[i].getValue().contentEquals(au) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getAreaUnit() /*-{
		return this.areaUnit;
	}-*/;
	
	/**
	 * Set the area unit parameter.
	 * 
	 * @param areaUnit - The area unit in which areas of polygons will be calculated.
	 */
	public final void setAreaUnit(UnitType areaUnit) {
		_setAreaUnit( areaUnit.getValue() );
	}
	
	private final native void _setAreaUnit(String areaUnit) /*-{
		this.areaUnit = areaUnit;
	}-*/;
	
	/**
	 * The length unit in which perimeters of polygons will be calculated.
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
	 * @param lengthUnit - The length unit in which perimeters of polygons will be calculated.
	 */
	public final void setLengthUnit(UnitType lengthUnit) {
		_setLengthUnit( lengthUnit.getValue() );
	}
	
	private final native void _setLengthUnit(String lengthUnit) /*-{
		this.lengthUnit = lengthUnit;
	}-*/;
	
	/**
	 * Polygon geometries for which to compute areas and lengths.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getPolygons() /*-{
		return this.polygons;
	}-*/;
	
	/**
	 * Set the polygons parameter.
	 * 
	 * @param polygons - Polygon geometries for which to compute areas and lengths
	 */
	public final void setPolygons(Geometry[] polygons) {
		_setPolygons(Util.objectArrayToJSO(polygons));
	}
	
	private final native void _setPolygons(JavaScriptObject polygons) /*-{
		this.polygons = polygons;
	}-*/;
	
}
