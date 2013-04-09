package edu.ucdavis.cstars.client.geometry;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 *  A location defined by an X- and Y- coordinate. It can be map units or screen units.
 *  
 * @author lsimone
 * @author Justin Merz
 */
public class Point extends Geometry {

	protected Point () {}
	
	/**
	 * Creates a new Point object using x, y, and a spatial reference.
	 * 
	 * @param x - X-coordinate of a point in map units. 
	 * @param y - Y-coordinate of a point in map units. 
	 * @param sr - Spatial reference of the geometry.
	 * @return Point
	 */
	public native static Point create(double x, double y, SpatialReference sr) /*-{
		return new $wnd.esri.geometry.Point(x, y, sr);
	}-*/;
	
	/**
	 * Creates a new Point object using an array containing an x,y coordinate value and a spatial reference.
	 * 
	 * @param xy - An array that includes an x,y coordinate.
	 * @param sr - Spatial reference of the geometry. 
	 * @return Point
	 */
	public static Point create(double[] xy, SpatialReference sr) {
		return _create(Util.doubleArrayToJSO(xy), sr); 
	};
	
	private native static Point _create(JavaScriptObject xy, SpatialReference sr) /*-{
		return new $wnd.esri.geometry.Point(xy, sr);
	}-*/;
	
	/**
	 * Creates a new Point object using a JSON object.
	 * 
	 * @param json - A JSON object that contains an x,y coordinate. 
	 * @return Point
	 */
	public native static Point create(JavaScriptObject json) /*-{
		return new $wnd.esri.geometry.Point(json);
	}-*/;
	
	/**
	 * X-coordinate of a point in map units.
	 * 
	 * @return double
	 */
	public final native double getX() /*-{ 
		return this.x; 
	}-*/;
	
	/**
	 * Y-coordinate of a point in map units.
	 * 
	 * @return double
	 */
	public final native double getY() /*-{ 
		return this.y; 
	}-*/;
	
	/**
	 * Offsets the point in an x and y direction. Units are map units.
	 * 
	 * @param dx - Value for x-coordinate of point.
	 * @param dy - Value for y-coordinate of point.
	 * @return Point
	 */
	public final native Point getOffset(double dx, double dy) /*-{ 
		return this.offset(dx, dy) 
	}-*/;
	
	/**
	 * Sets x-coordinate of point. 
	 * 
	 * @param x - Value for x-coordinate of point.
	 * @return Point
	 */
	public final native Point setX(double x) /*-{ 
		this.setX(x); 
	}-*/;
	
	/**
	 * Sets y-coordinate of point. 
	 * 
	 * @param y - Value for y-coordinate of point.
	 * @return Point
	 */
	public final native Point setY(double y) /*-{ 
		return this.setY(y); 
	}-*/;
	
	/**
	 * Updates a point.
	 * 
	 * @param dx - X-coordinate of the updated point.
	 * @param dy - Y-coordinate of the updated point.
	 * @return Point
	 */
	public final native Point update(double dx, double dy) /*-{ 
		return this.update(dx, dy) 
	}-*/;

	/**
	 * Return the point as a formated string
	 * 
	 * @return String
	 */
	public final String toNiceString() {
		return "[" + getX() + "," + getY() + "]";
	}
	
}
