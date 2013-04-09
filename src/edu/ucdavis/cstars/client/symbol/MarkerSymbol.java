package edu.ucdavis.cstars.client.symbol;

/**
 * Marker symbols are used to draw points and multipoints on the graphics layer.
 * 
 * MarkerSymbol has no constructor. Use SimpleMarkerSymbol or PictureMarkerSymbol.
 * 
 * @author Justin Merz
 */
public class MarkerSymbol extends Symbol {
	
	protected MarkerSymbol() {}
	
	/**
	 * The angle of the image. 0 is pointing right and values progress clockwise.
	 * 
	 * @return int
	 */
	public final native int getAngle() /*-{
		return this.angle;
	}-*/;
	
	/**
	 * Size of the marker in pixels.
	 * 
	 * @return int
	 */
	public final native int getSize() /*-{
		return this.size;
	}-*/;
	
	/**
	 * The offset on the x-axis in pixels.
	 * 
	 * @return int
	 */
	public final native int getXOffset() /*-{
		return this.xoffset;
	}-*/;
	
	/**
	 * The offset on the y-axis in pixels.
	 * 
	 * @return int
	 */
	public final native int getYOffset() /*-{
		return this.yoffset;
	}-*/;
	
	/**
	 * Sets the angle of a marker.
	 * 
	 * @param angle - The angle value. 0 is pointing right and values progress clockwise.
	 * @return MarkerSymbol
	 */
	public final native MarkerSymbol setAngle(int angle) /*-{
		return this.setAngle(angle);
	}-*/;
	
	/**
	 * Sets the x and y offset of a marker in screen units.
	 * 
	 * @param x - The X offset value in pixels.
	 * @param y - The Y offset value in pixels.
	 * @return MarkerSymbol
	 */
	public final native MarkerSymbol setOffset(int x, int y) /*-{
		return this.setOffset(x, y);
	}-*/;
	
	/**
	 * Sets the size of a marker in pixels.
	 * 
	 * @param size - The width of the symbol in pixels.
	 * @return MarkerSymbol
	 */
	public final native MarkerSymbol setSize(int size) /*-{
		return this.setSize(size);
	}-*/;

}
