package edu.ucdavis.cstars.client.symbol;

/**
 * Fill symbols are used to draw polygon features on the graphics layer. Fills can be specified as solid, hatched, or pictures.
 * In addition, the symbol can have an optional outline, which is defined by a line symbol. 

FillSymbol has no constructor. Use SimpleFillSymbol or PictureFillSymbol.
 * 
 * @author Justin Merz
 */
public class FillSymbol extends Symbol {
	
	protected FillSymbol() {}
	
	/**
	 * Outline of the polygon.
	 * 
	 * @return SimpleLineSymbol
	 */
	public native final SimpleLineSymbol getOutline() /*-{
		return this.outline;
	}-*/;
	
	/**
	 * Sets the outline of the fill symbol.
	 * 
	 * @param outline - Symbol used for outline.
	 * @return SimpleLineSymbol
	 */
	public native final SimpleLineSymbol setOutline(SimpleLineSymbol outline) /*-{
		return this.setOutline(outline);
	}-*/;

}
