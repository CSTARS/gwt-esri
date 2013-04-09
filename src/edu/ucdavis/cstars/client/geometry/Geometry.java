package edu.ucdavis.cstars.client.geometry;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.SpatialReference;

/**
 * The base class for geometry objects. This class has no constructor.
 * 
 * @author Justin Merz
 */
public class Geometry extends JavaScriptObject {
	
	public static enum GeometryType {
		NOT_SET(""),
		POINT("point"),
		MULTIPOINT("multipoint"),
		POLYLINE("polyline"),
		POLYGON("polygon"),
		EXTENT("extent");
		private String val;
		private GeometryType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static GeometryType gwtValueOf(String value) {
			for( int i = 0; i < GeometryType.values().length; i++ ){
				if( GeometryType.values()[i].getValue().contentEquals(value) ){
					return GeometryType.values()[i];
				}
			}
			return GeometryType.NOT_SET;
		}
	}
	
	protected Geometry() {}
	
	/**
	 * Get the spatial reference of the geometry.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	/**
	 * Sets the spatial reference.
	 *
	 * @param ref - Spatial reference of the geometry.
	 */
	public final native void setSpatialReference(SpatialReference ref) /*-{
		return this.setSpatialReference(ref);
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
	/**
	 * The type of geometry.
	 * 
	 * @return GeometryType
	 */
	public final GeometryType getType() {
		return GeometryType.gwtValueOf(_getType());
	}
	
	/**
	 * The type of geometry.
	 * 
	 * Known values: point | multipoint | polyline | polygon | extent 
	 * 
	 * @return String
	 */
	private final native String _getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getJson() /*-{
		return this.toJson();
	}-*/;
	
	/*
	 * Static Namespace methods for esri.geometry
	 * see: http://help.arcgis.com/EN/webapi/javascript/arcgis/help/jsapi_start.htm#jsapi/legend.htm
	 */
	
	/**
	 * Converts the input JSON object to the appropriate esri.geometry.* object.
	 * 
	 * @param json - The JSON object.
	 * @return Geometry
	 */
	public static native final Geometry fromJson(JavaScriptObject json) /*-{
		return $wnd.esri.geometry.fromJson(json);
	}-*/;
	
	/**
	 * Converts geometry from geographic units to Web Mercator units.
	 * 
	 * @param geometry - The geometry to convert. 
	 * @return Geometry
	 */
	public static native final Geometry geographicToWebMercator(Geometry geometry) /*-{
		return $wnd.esri.geometry.geographicToWebMercator(geometry);
	}-*/;
	
	
	/**
	 * Get the extent for the specified scale.
	 * 
	 * @param map - The input map.
	 * @param scale - The input scale.
	 * @return Extent
	 */
	public static final Extent getExtentForScale(MapWidget map, int scale) {
		return getExtentForScale(map.getMapObject(), scale);
	}
	
	private static native final Extent getExtentForScale(JavaScriptObject map, int scale) /*-{
		return $wnd.esri.geometry.getExtentForScale(map, scale)
	}-*/;
	
	/**
	 * Requests the geometry type name as represented in the ArcGIS REST.
	 * 
	 * @param geometry - The ArcGIS JavaScript API geometry type to be converted.
	 * @return String
	 */
	public static native final String getJsonType(Geometry geometry) /*-{
		return $wnd.esri.geometry.getJsonType(geometry);
	}-*/;
	
	/**
	 * Calculates the length of a line based on the input of two points.
	 * 
	 * @param point1 - The beginning point.
	 * @param point2 - The ending point.
	 * @return float
	 */
	public static native final float getLength(Point point1, Point point2) /*-{
		return $wnd.esri.geometry.getLength(point1, point2);
	}-*/;
	
	/**
	 * Calculates the intersecting point of two lines. If the lines are parallel, a null value is returned.
	 * 
	 * @param line1start - The beginning point of the first line.
	 * @param line1end - The ending point of the first line.
	 * @param line2start - The beginning point of the second line.
	 * @param line2end - The ending point of the second line.
	 * @return Point
	 */
	public static native final Point getLineIntersection(Point line1start, Point line1end, Point line2start, Point line2end) /*-{
		return $wnd.esri.geometry.getLineIntersection(line1start, line1end, line2start, line2end);
	}-*/;
	
	/**
	 * Gets the current scale of the map.
	 * 
	 * @param map - The map whose scale should be calculated.
	 * @return float
	 */
	public static final double getScale(MapWidget map) {
		return getScale(map.getMapObject());
	};
	
	private static native final double getScale(JavaScriptObject map) /*-{
		return $wnd.esri.geometry.getScale(map);
	}-*/;
	
	/**
	 * Checks if a Polygon ring is clockwise. Returns true for clockwise and false for counterclockwise.
	 * 
	 * @param ring
	 * @return boolean
	 */
	public static native final boolean isClockwise(JsArray<Point> ring) /*-{
		return $wnd.esri.geometry.isClockwise(ring);
	}-*/;
	
	/**
	 * Converts the geometry argument to map coordinates based on the extent, width, and height of the Map.
	 * 
	 * @param extent - The current extent of the map in map coordinates.
	 * @param width - The current width of the map in map units.
	 * @param height - The current width of the map in map units.
	 * @param mapGeometry - The geometry to convert from screen to map units.
	 * @return Geometry
	 */
	public static native final Geometry toMapGeometry(Extent extent, float width, float height, Geometry mapGeometry) /*-{
		return $wnd.esri.geometry.toMapGeometry(extent, width, height, mapGeometry);
	}-*/;
	
    /**
     * @deprecated
     * Deprecated at v1.1. Use toMapGeometry instead
     */
	@Deprecated
	public static native final Point toMapPoint(Extent extent, float width, float height, Point screenPoint) /*-{
		return $wnd.esri.geometry.toMapPoint(extent, width, height, screenPoint);
	}-*/;
	
	/**
	 * Converts the geometry argument to screen coordinates based on the extent, width, and height of the Map.
	 * 
	 * @param extent - The current extent of the map in map coordinates.
	 * @param width - The current width of the map in screen units.
	 * @param height - The current width of the map in screen units.
	 * @param screenGeometry - The geometry to convert from map to screen units.
	 * @return Geometry
	 */
	public static native final Geometry toScreenGeometry(Extent extent, float width, float height, Geometry screenGeometry) /*-{
		return $wnd.esri.geometry.toScreenGeometry(extent, width, height, screenGeometry);
	}-*/;

    /**
     * @deprecated
     * Deprecated at v1.1. Use toScreenGeometry instead
     */
	@Deprecated
	public static native final Point toScreenPoint(Extent extent, float width, float height, Point mapPoint) /*-{
		return $wnd.esri.geometry.toScreenPoint(extent, width, height, mapPoint);
	}-*/;
	
	/**
	 * Converts geometry from Web Mercator units to geographic units.
	 * 
	 * @param geometry - The geometry to convert.
	 * @return Geometry
	 */
	public static final native Geometry webMercatorToGeographic(Geometry geometry) /*-{
		return $wnd.esri.geometry.webMercatorToGeographic(geometry);
	}-*/;
	
}
