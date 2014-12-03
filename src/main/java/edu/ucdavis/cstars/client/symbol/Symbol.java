package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Symbols are used to display points, lines, and polygons on the graphics layer. 
 * 
 * Symbol is the base symbol class and has no constructor. Instead, use the following:
 *   Points:  SimpleMarkerSymbol, PictureMarkerSymbol
 *   Lines:  SimpleLineSymbol, CartographicLineSymbol
 *   Polygons:  SimpleFillSymbol, PictureFillSymbol
 *   Text:  TextSymbol, Font
 * 
 * @author Justin Merz
 */
public class Symbol extends JavaScriptObject {

	protected Symbol() {}
	
	/**
	 * Symbol color.
	 * 
	 * @return Color
	 */
	public final native Color getColor() /*-{
		return this.color;
	}-*/;
	
	/**
	 * The type of symbol.
	 * 
	 * Known values: simplemarkersymbol | picturemarkersymbol | simplelinesymbol | cartographiclinesymbol | simplefillsymbol | picturefillsymbol | textsymbol
	 * 
	 * @return String
	 */
	public final native String getType() /*-{
		return this.type;
	}-*/;

	/**
	 * Sets the symbol color.
	 * 
	 * @param color - color to be set.
	 * @return Symbol
	 */
	public final native Symbol setColor(Color color) /*-{
		this.setColor(color);
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
	/**
	 * Converts input json into a symbol, returns null if the input json represents an unknown or unsupported symbol type. 
	 * 
	 * @param json - input object.
	 * @return Symbol
	 */
	public static final native Symbol fromJson(JavaScriptObject json) /*-{
		return $wnd.esri.symbol.fromJson(json);
	}-*/;
	
}
