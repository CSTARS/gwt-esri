package edu.ucdavis.cstars.client.renderer;

import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * A renderer that uses one symbol only.
 * 
 * @author Justin Merz
 */
public class SimpleRenderer extends Renderer {

	protected SimpleRenderer() {}
	
	/**
	 * Creates a new SimpleRenderer object with a Symbol parameter.
	 * 
	 * @param defaultSymbol - Symbol to use for the renderer.
	 * @return SimpleRenderer
	 */
	public static native final SimpleRenderer create(Symbol defaultSymbol) /*-{
		return $wnd.esri.renderer.SimpleRenderer(defaultSymbol);
	}-*/;
	
	/**
	 * Description for the renderer.
	 * 
	 * @return String
	 */
	public native final String getDescription() /*-{
		return this.description; 
	}-*/;
	
	/**
	 * Label for the renderer.
	 * 
	 * @return String
	 */
	public native final String getLabel() /*-{
		return this.label; 
	}-*/;
	
	/**
	 * The symbol for the renderer.
	 * 
	 * @return Symbol
	 */
	public native final Symbol getSymbol() /*-{
		return this.symbol; 
	}-*/;
	
}
