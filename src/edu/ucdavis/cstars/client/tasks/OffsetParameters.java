package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Sets the offset distance, type and other parameters for the
 * 
 * @author Justin Merz
 */
public class OffsetParameters extends JavaScriptObject {
	
	public enum OffsetType {
		NOT_SET(""),
		OFFSET_BEVELLED("esriGeometryOffsetBevelled"),
		OFFSET_MITERED("esriGeometryOffsetMitered"),
		OFFSET_ROUNDED("esriGeometryOffsetRounded");
		
		private String value = "";
		OffsetType(String val) {
			value = val;
		}
		public String getValue() {
			return value;
		}
	}

	protected OffsetParameters() {}
	
	/**
	 * Creates a new OffsetParameters object.
	 * 
	 * @return OffsetParameters
	 */
	public static native OffsetParameters create() /*-{
		return new $wnd.esri.tasks.OffsetParameters();
	}-*/;
	
	/**
	 * The bevelRatio is multiplied by the offset distance and the result determines how far a mitered offset intersection
	 * can be located before it is bevelled. When mitered is specified, the value set for bevelRatio is ignored and 10 is 
	 * sed internally. If bevelled is specified 1.1 will be used if no value is set for bevelRatio. The bevelRatio is ignored
	 * when rounded is specified.
	 * 
	 * @return double
	 */
	public final native double getBevelRatio() /*-{
		return this.bevelRatio;
	}-*/;
	
	/**
	 * set the bevel ratio parameter.
	 * 
	 * @param bevelRatio - The bevelRatio is multiplied by the offset distance and the result determines how far a mitered offset intersection
	 * can be located before it is bevelled. When mitered is specified, the value set for bevelRatio is ignored and 10 is 
	 * sed internally. If bevelled is specified 1.1 will be used if no value is set for bevelRatio. The bevelRatio is ignored
	 * when rounded is specified.
	 */
	public final native void setBevelRatio(double bevelRatio) /*-{
		this.bevelRatio = bevelRatio;
	}-*/;
	
	/**
	 * The array of geomtries to be offset.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getGeometries() /*-{
		return this.geometries;
	}-*/;

	/**
	 * Set the geometries parameter.
	 * 
	 * @param geometries - The array of geomtries to be offset.
	 */
	public final void setGeometries(Geometry[] geometries) {
		_setGeometries(Util.objectArrayToJSO(geometries));
	}
	
	private final native void _setGeometries(JavaScriptObject geometries) /*-{
		this.geometries = geometries;
	}-*/;
	
	/**
	 * Specifies the distance for constructing an offset based on the input geometries. If the offsetDistance parameter is
	 * positive the constructed offset will be on the right side of the curve. Left side offsets are constructed with
	 * negative values.
	 * 
	 * @return float
	 */
	public final native float getOffsetDistance() /*-{
		return this.offsetDistance;
	}-*/;
	
	/**
	 * Set the offset distance parameter.
	 * 
	 * @param offsetDistance - Specifies the distance for constructing an offset based on the input geometries. If the
	 * offsetDistance parameter is positive the constructed offset will be on the right side of the curve. Left side offsets
	 * are constructed with negative values.
	 */
	public final native void setOffsetDistance(float offsetDistance) /*-{
		this.offsetDistance = offsetDistance;
	}-*/;
	
	/**
	 * Get the offset how parameter.
	 * 
	 * @return OffsetType
	 */
	public final OffsetType getOffsetHow() {
		String oh = _getOffsetHow();
		for( int i = 0 ; i < OffsetType.values().length; i++ ){
			if( OffsetType.values()[i].getValue().contentEquals(oh) )
				return OffsetType.values()[i];
		}
		return OffsetType.NOT_SET;
	}
	
	private final native String _getOffsetHow() /*-{
		return this.offsetHow;
	}-*/;
	
	/**
	 * Set the offset how parameter.
	 * 
	 * @param offsetHow
	 */
	public final void setOffsetHow(OffsetType offsetHow) {
		_setOffsetHow( offsetHow.getValue() );
	}
	
	private final native void _setOffsetHow(String offsetHow) /*-{
		this.offseHow = offsetHow;
	}-*/;
	
	/**
	 * The offset distance unit.
	 * 
	 * @return UnitType
	 */
	public final UnitType getOffsetUnit() {
		String ou = _getOffsetUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType.values()[i].getValue().contentEquals(ou) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getOffsetUnit() /*-{
		return this.offsetUnit;
	}-*/;
	
	/**
	 * Set the offset unit.
	 * 
	 * @param offsetUnit - The offset distance unit.
	 */
	public final void setOffsetUnit(UnitType offsetUnit) {
		_setOffsetUnit( offsetUnit.getValue() );
	}
	
	private final native void _setOffsetUnit(String offsetUnit) /*-{
		this.offsetUnit = offsetUnit;
	}-*/;
	
}
