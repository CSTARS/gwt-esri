package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.SpatialReference;

/**
 * An array of rings where each ring is an array points. The first and last points of a ring must be the same. 
 * 
 * @author Justin Merz
 */
public class Polygon extends Geometry {

	protected Polygon () {}
	
	/**
	 * Creates a new Polygon object.
	 * 
	 * @param sr - Spatial reference of the geometry. 
	 * @return Polygon
	 */
	public native static Polygon create(SpatialReference sr) /*-{
		return new $wnd.esri.geometry.Polygon(sr);
	}-*/;
	
	/**
	 * Creates a new Polygon object using a JSON object.
	 * 
	 * @param json - JSON object representing the geometry. 
	 * @return Polygon
	 */
	public native static Polygon create(JavaScriptObject json) /*-{
		return new $wnd.esri.geometry.Polygon(json);
	}-*/;
	
	/**
	 * An array of rings. Each ring is made up of three or more points.
	 * 
	 * @return RingGroup
	 */
	public final native RingGroup getRings() /*-{ 
		return this.rings; 
	}-*/;
	
	/**
	 * Adds a ring to the Polygon.
	 * 
	 * @param ring
	 * @return Polygon
	 */
	public final native Polygon addRing(Ring ring) /*-{
		return this.addRing(ring);
	}-*/;
	
	/**
	 * Checks on the client if the specified point is inside the polygon. A point on the
	 * polygon line is considered in.
	 * 
	 * @param point - The location defined by an X- and Y- coordinate in map units. 
	 * @return boolean
	 */
	public final native boolean contains(Point point) /*-{
		return this.contains(point);
	}-*/;
	
	/**
	 * Returns the extent of the polygon.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.getExtent();
	}-*/;
	
	/**
	 * Returns a point specified by a ring and point in the path.
	 * 
	 * @param pathIndex - The index of a ring.
	 * @param pointIndex - The index of a point in a ring.
	 * @return Point
	 */
	public final native Point getPoint(int pathIndex, int pointIndex) /*-{
		return this.getPoint(pathIndex, pointIndex);
	}-*/;
	
	/**
	 * Inserts a new point into a polygon. 
	 * 
	 * @param pathIndex - Ring index to insert point.
	 * @param pointIndex - The index of the inserted point in the ring.
	 * @param point - Point to insert into the ring.
	 * @return Polygon
	 */
	public final native Polygon insertPoint(int pathIndex, int pointIndex, Point point) /*-{
		return this.insertPoint(pathIndex, pointIndex, point);
	}-*/;
	
	/**
	 * Remove a point from the polygon at the given pointIndex within the ring identified by ringIndex.
	 * 
	 * @param ringIndex - The index of the ring containing the point.
	 * @param pointIndex  - The index of the point within the ring.
	 * @return Point
	 */
	public final native Point removePoint(int ringIndex, int pointIndex) /*-{
		return this.insertPoint(pathIndex, pointIndex, point);
	}-*/;
	
	/**
	 * Removes a ring from the Polygon. The index specifies which ring to remove.
	 * 
	 * @param pathIndex - The index of the ring to remove.
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> removeRing(int pathIndex) /*-{
		return this.removeRing(pathIndex);
	}-*/;
	
	/**
	 * Updates a point in a polygon.
	 * 
	 * @param pathIndex - Ring index for updated point.
	 * @param pointIndex - The index of the updated point in the ring.
	 * @param point - Point to update in the ring.
	 * @return Polygon
	 */
	public final native Polygon setPoint(int pathIndex, int pointIndex, Point point) /*-{
		return this.setPoint(pathIndex, pointIndex, point);
	}-*/;

}
