package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.tasks.GeometryService.UnitType;

/**
 * Represents a geometry service resource exposed by the ArcGIS Server REST API. It is used to perform various
 * operations on geometries such as project, simplify, buffer, and relationships.
 * 
 * @author Justin Merz
 */
public class BufferParameters extends JavaScriptObject {
	
	protected BufferParameters() {}
	
	/**
	 * Creates a new BufferParameters object. The constructor takes no parameters.
	 * 
	 * @return BufferParameters
	 */
	public static native BufferParameters create() /*-{
		return new $wnd.esri.tasks.BufferParameters()
	}-*/;
	
	/**
	 * The spatial reference in which the geometries are buffered. If bufferSpatialReference is not specified,
	 * the geometries are buffered in the spatial reference specified by outSpatialReference. If
	 * outSpatialReference is also not specified, they are buffered in the spatial reference of the features.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getBufferSpatialRefernce() /*-{
		return this.bufferSpatialReference;
	}-*/;
	
	/**
	 * Set the bufferSpatialReference parameter.
	 * 
	 * @param bufferSpatialReference - The spatial reference in which the geometries are buffered. If
	 * bufferSpatialReference is not specified, the geometries are buffered in the spatial reference
	 * specified by outSpatialReference. If outSpatialReference is also not specified, they are buffered
	 * in the spatial reference of the features.
	 */
	public final native void setBufferSpatialRefernce(SpatialReference bufferSpatialReference) /*-{
		this.bufferSpatialReference = bufferSpatialReference;
	}-*/;
	 
	/**
	 * The distances the input features are buffered. The distance units are specified by unit.
	 * 
	 * @return JsArrayNumber
	 */
	public final native JsArrayNumber getDistances() /*-{
		return this.distances;
	}-*/;

	/**
	 * Set the distances parameter.
	 * 
	 * @param distances - The distances the input features are buffered. The distance units are specified by unit.
	 */
	public final void setDistances(int[] distances) {
		_setDistances(Util.intArrayToJSO(distances));
	}
	
	private final native void _setDistances(JavaScriptObject distances) /*-{
		this.distances = distances;
	}-*/;
	
	/**
	 * If the input geometries are in geographic coordinate system set geodesic to true in order 
	 * to generate a buffer polygon using a geodesic distance. The bufferSpatialReference property 
	 * is ignored when geodesic is set to true. Requires ArcGIS Server 10.1 or greater geometry 
	 * service. (As of v2.7)
	 * 
	 * @return boolean
	 */
	public final native boolean isGeodesic() /*-{
		return this.geodesic;
	}-*/;
	
	/**
	 * Set the geodesic parameter.
	 * 
	 * @param geodesic - If the input geometries are in geographic coordinate system set geodesic 
	 * to true in order to generate a buffer polygon using a geodesic distance. The bufferSpatialReference 
	 * property is ignored when geodesic is set to true. Requires ArcGIS Server 10.1 or greater geometry 
	 * service. (As of v2.7)
	 */
	public final native void setGeodesic(boolean geodesic) /*-{
		this.geodesic = geodesic;
	}-*/;
	
	/**
	 * The input geometries to buffer.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getGeometries() /*-{
		return this.geometries;
	}-*/;
	
	/**
	 * Set the geometries parameter.
	 * 
	 * @param geometries - The input geometries to buffer.
	 */
	public final void setGeometries(Geometry[] geometries) {
		_setGeometries(Util.objectArrayToJSO(geometries));
	}
	
	private final native void _setGeometries(JavaScriptObject geometries) /*-{
		this.geometries = geometries;
	}-*/;
	
	/**
	 * The spatial reference for the returned geometries.  If outSpatialReference is not specified,
	 * the output geometries are in the spatial reference specified by bufferSR. If
	 * bufferSpatialReference is also not specified, they are in the spatial reference of the features.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialRefernce() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * Set the outSpatialReference parameter.
	 * 
	 * @param outSpatialReference - The spatial reference for the returned geometries.  If
	 * outSpatialReference is not specified, the output geometries are in the spatial reference
	 * specified by bufferSR. If bufferSpatialReference is also not specified, they are in the
	 * spatial reference of the features.
	 */
	public final native void setOutSpatialRefernce(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * If true, all geometries buffered at a given distance are unioned into a single (possibly multipart)
	 * polygon, and the unioned geometry is placed in the output array.
	 * 
	 * @return boolean
	 */
	public final native boolean unionResults() /*-{
		return this.unionResults;
	}-*/;
	
	/**
	 * Set the unionResults parameter.
	 * 
	 * @param unionResults - If true, all geometries buffered at a given distance are unioned into a
	 * single (possibly multipart) polygon, and the unioned geometry is placed in the output array.
	 */
	public final native void setUnionResults(boolean unionResults) /*-{
		this.unionResults = unionResults;
	}-*/;

	/**
	 * The units for calculating each buffer distance. If unit is not specified, the units are derived from
	 * bufferSpatialReference. If bufferSpatialReference is not specified, the units are derived from the
	 * features. See the Geometry service constants table for values.
	 * 
	 * @return UnitType
	 */
	public final UnitType getUnit() {
		String u = _getUnit();
		for( int i = 0 ; i < UnitType.values().length; i++ ){
			if( UnitType.values()[i].getValue().contentEquals(u) )
				return UnitType.values()[i];
		}
		return UnitType.NOT_SET;
	}
	
	private final native String _getUnit() /*-{
		return this.unit;
	}-*/;
	
	/**
	 * Set the unit parameter.
	 * 
	 * @param unit - The units for calculating each buffer distance. If unit is not specified, the units are derived from
	 * bufferSpatialReference. If bufferSpatialReference is not specified, the units are derived from the
	 * features. See the Geometry service constants table for values.
	 */
	public final void setUnit(UnitType unit){
		_setUnit(unit.getValue());
	}
	
	private final native void _setUnit(String unit) /*-{
		this.unit = unit;
	}-*/;

}
