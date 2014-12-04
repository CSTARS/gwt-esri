package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 * An ordered collection of points. 
 * 
 * @author Justin Merz
 */
public class Multipoint extends Geometry {

	protected Multipoint () {  }
	
	/**
	 * Creates a new Multipoint object.
	 * 
	 * @param sr - Spatial reference of the geometry. 
	 * @return Multipoint
	 */
	public native static Multipoint create(SpatialReference sr) /*-{
		return new $wnd.esri.geometry.Polyline(sr);
	}-*/;
	
	/**
	 * Creates a new Multipoint object using a JSON object.
	 * 
	 * @param json - JSON object representing the geometry. 
	 * @return Multipoint
	 */
	public native static Multipoint create(JavaScriptObject json) /*-{
		return new $wnd.esri.geometry.Polyline(json);
	}-*/;
			
	/**
	 * An array of one or more points.
	 * 
	 * @return JsArray<JsArrayNumber>
	 */
	public final native JsArray<JsArrayNumber> getPoints() /*-{ 
		return this.points; 
	}-*/;
	
	/**
	 * Adds a point to the Multipoint.
	 * 
	 * @param point - The point to add.
	 * @return Multipoint
	 */
	public final native Multipoint addPoint(Point point) /*-{
		return this.addPoint(point);
	}-*/;
	
	/**
	 * Adds a point to the Multipoint.
	 * 
	 * @param x - X-Coordinate of the point
	 * @param y - Y-Coordinate of the point
	 * @return Multipoint
	 */
	public final native Multipoint addPoint(double x, double y) /*-{
		return this.addPoint({"x": x, "y": y});
	}-*/;
	
	/**
	 * Adds an array of points to the Multipoint
	 * 
	 * @param json - A JSON object representing a point.
	 * @return Multipoint
	 */
	public final Multipoint addPoint(double[] points) {
		return _addPoint(Util.doubleArrayToJSO(points));
	};
	
	private final native Multipoint _addPoint(JavaScriptObject json) /*-{
		return this.addPoint(json);
	}-*/;
	
	/**
	 * Gets the extent of all the points. If only one point is present, the extent 
	 * has a width and height of 0.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.getExtent();
	}-*/;
	
	/**
	 * Returns the point at the specified index.
	 * 
	 * @param index - Positional index of the point in the points property.
	 * @return Point
	 */
	public final native Point getPoint(int index) /*-{
		return this.getPoint(index);
	}-*/;
	
	/**
	 * Removes a point from the Multipoint. The index specifies which path to remove.
	 * 
	 * @param index - The index of the point to remove.
	 * @return Point
	 */
	public final native Point removePoint(int index) /*-{
		return this.removePoint(index);
	}-*/;
	
	/**
	 * Updates the point at the specified index.
	 * 
	 * @param index - Positional index of the point in the points property.
	 * @param point - Point that specifies the new location.
	 * @return Multipoint
	 */
	public final native Multipoint setPoint(int index, Point point) /*-{
		return this.setPoint(index, point);
	}-*/;

}
