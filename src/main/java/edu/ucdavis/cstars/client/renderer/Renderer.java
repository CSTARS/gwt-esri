package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * Base class for the renderers - SimpleRenderer, ClassBreaksRenderer, UniqueValueRenderer. The base class for
 * all renderers used with a GraphicsLayer. Renderer has no constructor. Use SimpleRenderer, ClassBreaksRenderer,
 * or UniqueValueRenderer.
 * 
 * @author Justin Merz
 */
public class Renderer extends JavaScriptObject {
	
	protected Renderer() {}
	
	/**
	 * Default symbol used when a value or break cannot be matched.
	 * 
	 * @return Symbol
	 */
	public final native Symbol getDefaultSymbol() /*-{
		return this.defaultSymbol;
	}-*/;
	
	/**
	 * Gets the symbol for the Graphic.
	 * 
	 * @param graphic - Graphic to symbolize. Used when creating a custom renderer.
	 * @return Symbol
	 */
	public final native Symbol getSymbol(Graphic graphic) /*-{
		return this.getSymbol(graphic);
	}-*/;

	/**
	 * Converts object to its ArcGIS Server JSON representation. Not supported for the TemporalRenderer.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
	/**
	 * Create a renderer from it's ArcGIS Server JSON representation.
	 * 
	 * @param json - object representation
	 * @return Renderer
	 */
	public static final native Renderer fromJson(JavaScriptObject json) /*-{
		return $wnd.esri.renderer.fromJson(json);
	}-*/;
	
}
