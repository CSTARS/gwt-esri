package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.SpatialReference;

/**
 *  An array of paths where each path is an array of points. 
 *  
 * @author Justin Merz
 */
public class Polyline extends Geometry {

	protected Polyline() {}
	
	/**
	 * Creates a new Polyline object.
	 * 
	 * @param sr - Spatial reference of the geometry. 
	 * @return Polyline
	 */
	public native static Polyline create(SpatialReference sr) /*-{
		return new $wnd.esri.geometry.Polyline(sr);
	}-*/;
	
	/**
	 * Creates a new Polyline object using a JSON object.
	 * 
	 * @param json - JSON object representing the geometry. 
	 * @return Polyline
	 */
	public native static Polyline create(JavaScriptObject json) /*-{
		return new $wnd.esri.geometry.Polyline(json);
	}-*/;
			
	/**
	 * An array of paths. Each path is made up of an array of two or more points.
	 * 
	 * @return RingGroup
	 */
	public final native RingGroup getPaths() /*-{ 
		return this.paths; 
	}-*/;

	/**
	 * Adds a path to the Polyline.
	 * 
	 * @param path - An array of x,y coordinate pairs to create a path.
	 * @return Polyline
	 */
	public final native Polyline addPath(Ring path) /*-{
		return this.addPath(path);
	}-*/;
	
	/**
	 * Returns the extent of the Polyline.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.getExtent();
	}-*/;
	
	/**
	 * Returns a point specified by a path and point in the path.
	 * 
	 * @param pathIndex - The index of a path in a polyline.
	 * @param pointIndex - The index of a point in a path.
	 * @return Point
	 */
	public final native Point getPoint(int pathIndex, int pointIndex) /*-{
		return this.getPoint(pathIndex, pointIndex);
	}-*/;
	
	/**
	 * Inserts a new point into a polyline.
	 * 
	 * @param pathIndex - Path index to insert point.
	 * @param pointIndex - The index of the inserted point in the path.
	 * @param point - Point to insert into the path.
	 * @return Polyline
	 */
	public final native Polyline insertPoint(int pathIndex, int pointIndex, Point point) /*-{
		return this.insertPoint(pathIndex, pointIndex, point);
	}-*/;
	
	/**
	 * Removes a path from the Polyline. The index specifies which path to remove.
	 * 
	 * @param pathIndex - The index of a path to remove.
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> removePath(int pathIndex) /*-{
		return this.removePath(pathIndex);
	}-*/;
	
	/**
	 * Remove a point from the polyline at the given pointIndex within the path identified by the given pathIndex.
	 * 
	 * @param pathIndex - The index of the path containing the point.
	 * @param pointIndex - The index of the point within the path.
	 * @return Point
	 */
	public final native Point removePoint(int pathIndex, int pointIndex) /*-{
		return this.removePoint(pathIndex, pointIndex);
	}-*/;
	
	/**
	 * Updates a point in a polyline. 
	 * 
	 * @param pathIndex - Path index for updated point.
	 * @param pointIndex - The index of the updated point in the path.
	 * @param point - Point to update in the path.
	 * @return Polyline
	 */
	public final native Polyline setPoint(int pathIndex, int pointIndex, Point point) /*-{
		return this.setPoint(pathIndex, pointIndex, point);
	}-*/;

}
