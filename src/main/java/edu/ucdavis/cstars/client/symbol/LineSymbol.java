package edu.ucdavis.cstars.client.symbol;

/**
 * Line symbols are used to draw linear features on the graphics layer. 
 * 
 * LineSymbol has no constructor. Use SimpleLineSymbol or CartographicLineSymbol.
 * 
 * @author Justin Merz
 */
public class LineSymbol extends Symbol {
	
	protected LineSymbol() {}
	
	/**
	 * Width of line symbol in pixels.
	 * 
	 * @return int
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;
	
	/**
	 * Sets the LineSymbol width.
	 * 
	 * @param width - Width of line symbol in pixels.
	 * @return int
	 */
	public final native LineSymbol setWidth(int width) /*-{
		return this.setWidth(width);
	}-*/;

}
