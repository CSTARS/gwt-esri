package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.SpatialReference;

/**
 * The minimum and maximum X- and Y- coordinates of a bounding box.
 * 
 * @author Justin Merz
 */
public class Extent extends Geometry {
	
	protected Extent() {}
	
	/**
	 * Creates a new Extent object. The coordinates represent the lower left and upper right corners of the bounding box. 
	 * A spatial reference is also required.
	 * 
	 * @param xmin - Bottom-left X-coordinate of an extent envelope. 
	 * @param ymin - Bottom-left Y-coordinate of an extent envelope. 
	 * @param xmax - Top-right X-coordinate of an extent envelope. 
	 * @param ymax  - Top-right Y-coordinate of an extent envelope. 
	 * @param ref - Spatial reference of the geometry.
	 * @return Extent 
	 */
	public static native Extent create(double xmin, double ymin, double xmax, double ymax, SpatialReference ref) /*-{
		return new $wnd.esri.geometry.Extent(xmin, ymin, xmax, ymax, ref);
	}-*/;
	
	/**
	 * Creates a new Extent object using a JSON object.
	 * 
	 * @param json - JSON object representing the geometry. 
	 * @return Extent
	 */
	public static native Extent create(JavaScriptObject json) /*-{
		return new $wnd.esri.geometry.Extent(json);
	}-*/;
	
	/**
	 * Returns extent as a formated String
	 * 
	 * @return String
	 */
	public final String toNiceString() {
		return "[" + getXMin() + "," + getYMin() + ";" + getXMax() + "," + getYMax() + "]";
	}
	
	/**
	 * Top-right X-coordinate of an extent envelope.
	 * 
	 * @return float
	 */
	public final native float getXMax() /*-{
		return this.xmax;
	}-*/;

	/**
	 * Bottom-left X-coordinate of an extent envelope.
	 * 
	 * @return float
	 */
	public final native float getXMin() /*-{
		return this.xmin;
	}-*/;

	/**
	 * Top-right Y-coordinate of an extent envelope.
	 * 
	 * @return float
	 */
	public final native float getYMax() /*-{
		return this.ymax;
	}-*/;

	/**
	 * Bottom-left Y-coordinate of an extent envelope.
	 * 
	 * @return float
	 */
	public final native float getYMin() /*-{
		return this.ymin;
	}-*/;
	
	/**
	 * A new extent is returned with the same width and height centered at the argument point.
	 * 
	 * @param point - Centers the extent on the specified x,y location.
	 * @return - Extent
	 */
	public final native Extent centerAt(Point point) /*-{
		return this.centerAt(point);
	}-*/;
	
	/**
	 * When "true", the geometry in the argument is contained in this extent.
	 * 
	 * @param point
	 * @return boolean
	 */
	public final native boolean contains(Point point) /*-{
		return this.contains(point);
	}-*/;
	
	/**
	 * When "true", the geometry in the argument is contained in this extent.
	 * 
	 * @param extent
	 * @return boolean
	 */
	public final native boolean contains(Extent extent) /*-{
		return this.contains(extent);
	}-*/;
	
	/**
	 * Expands the extent by the factor given. For example, a value of 1.5 will be 50% bigger.
	 * 
	 * @param factor - The mulitplier value.
	 * @return Extent
	 */
	public final native Extent expand(float factor) /*-{
		return this.expand(factor);
	}-*/;
	
	/**
	 * Returns the center point of the extent in map units.
	 * 
	 * @return Point
	 */
	public final native Point getCenter() /*-{
		return this.getCenter();
	}-*/;
	
	/**
	 * Distance between ymin and ymax.
	 * 
	 * @return float
	 */
	public final native float getHeight() /*-{
		return this.getHeight();
	}-*/;
	
	/**
	 * Distance between xmin and xmax.
	 * 
	 * @return float
	 */
	public final native float getWidth() /*-{
		return this.getWidth();
	}-*/;
	
	/**
	 * Returns true if the input geometry intersects this extent.
	 * 
	 * @param extent
	 * @return boolean
	 */
	public final native boolean intersects(Extent extent) /*-{
		return this.intersects(extent);
	}-*/;
	
	/**
	 * Returns true if the input geometry intersects this extent.
	 * 
	 * @param point
	 * @return boolean
	 */
	public final native boolean intersects(Point point) /*-{
		return this.intersects(point);
	}-*/;
	
	/**
	 * Returns true if the input geometry intersects this extent.
	 * 
	 * @param multipoint
	 * @return boolean
	 */
	public final native boolean intersects(Multipoint multipoint) /*-{
		return this.intersects(multipoint);
	}-*/;
	
	/**
	 * Returns true if the input geometry intersects this extent.
	 * 
	 * @param polygon
	 * @return boolean
	 */
	public final native boolean intersects(Polygon polygon) /*-{
		return this.intersects(polygon);
	}-*/;
	
	/**
	 * Returns true if the input geometry intersects this extent.
	 * 
	 * @param polyline
	 * @return boolean
	 */
	public final native boolean intersects(Polyline polyline) /*-{
		return this.intersects(polyline);
	}-*/;
	
	/**
	 * Offsets the current extent. Units are map units.
	 * 
	 * @param dx - The offset distance in map units for the x-coordinate.
	 * @param dy - The offset distance in map units for the y-coordinate.
	 * @return Extent
	 */
	public final native Extent offset(double dx, double dy) /*-{
		return this.offset(dx, dy);
	}-*/;
	
	/**
	 * Expands this extent to include the extent of the argument.
	 * 
	 * @param extent - Expands this extent to include the extent of the argument.
	 * @return Extent
	 */
	public final native Extent union(Extent extent) /*-{
		return this.union(extent);
	}-*/;
	
	/**
	 * Updates this extent with the specified parameters.
	 * 
	 * @param xmin - Bottom-left X-coordinate of an extent envelope.
	 * @param ymin - Bottom-left Y-coordinate of an extent envelope.
	 * @param xmax - Top-right X-coordinate of an extent envelope.
	 * @param ymax - Top-right Y-coordinate of an extent envelope.
	 * @param ref - Spatial reference of the geometry.
	 * @return Extent
	 */
	public final native Extent update(double xmin, double ymin, double xmax, double ymax, SpatialReference ref) /*-{
		return this.update(xmin, xmin, xmax, ymax, ref);
	}-*/;
	
}
