package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Marker symbols are used to draw points and multipoints on the graphics layer. SimpleMarkerSymbol is used to display
 * points as a simple shape, for example, a circle. In addition, the symbol can have an optional outline, which is defined by a line symbol.
 * 
 * @author Justin Merz
 */
public class SimpleMarkerSymbol extends MarkerSymbol {
	
	public static enum StyleType {
		NOT_SET(""),
		STYLE_CIRCLE("circle"),
		STYLE_CROSS("cross"),
		STYLE_DIAMOND("diamond"),
		STYLE_SQUARE("square"),
		STYLE_X("x");
		private String val;
		private StyleType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected SimpleMarkerSymbol() {}
	
	/**
	 * Creates a new SimpleMarkerSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the SimpleMarkerSymbol.
	 * @return SimpleMarkerSymbol
	 */
	public static native SimpleMarkerSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.SimpleMarkerSymbol(json);
	}-*/;
	
	/**
	 * Creates a new empty SimpleMarkerSymbol object.
	 * 
	 * @return SimpleMarkerSymbol
	 */
	public static native SimpleMarkerSymbol create() /*-{
		return new $wnd.esri.symbol.SimpleMarkerSymbol();
	}-*/;
	
	/**
	 * Creates a new SimpleMarkerSymbol object with parameters.
	 * 
	 * @param style - Marker style.
	 * @param size - Size of marker in pixels.
	 * @param outline - Outline of marker
	 * @param color - Symbol color.
	 * @return SimpleMarkerSymbol
	 */
	public static SimpleMarkerSymbol create(StyleType style, int size, SimpleLineSymbol outline, Color color ) {
		return _create(style.getValue(), size, outline, color);
	}
	
	private static native SimpleMarkerSymbol _create(String style, int size, SimpleLineSymbol outline, Color color) /*-{
		return new $wnd.esri.symbol.SimpleMarkerSymbol(style, size, outline, color);
	}-*/;
	
	/**
	 * Outline of the marker.
	 * 
	 * @return SimpleLineSymbol
	 */
	public final native SimpleLineSymbol getOutline() /*-{
		return this.outline;
	}-*/;
	
	/**
	 * The marker style. The default value is STYLE_CIRCLE.
	 * 
	 * @return StyleType
	 */
	public final StyleType getStyle() {
		String s = _getStyle();
		for( int i = 0; i < StyleType.values().length; i++ ){
			if( StyleType.values()[i].getValue().contentEquals(s) ){
				return StyleType.values()[i];
			}
		}
		return StyleType.NOT_SET;
	}
	
	private final native String _getStyle() /*-{
		return this.style;
	}-*/;
	
	/**
	 * Sets the outline of the marker symbol.
	 * 
	 * @param outline - Symbol used for outline.
	 * @return SimpleMarkerSymbol
	 */
	public final native SimpleMarkerSymbol setOutline(SimpleLineSymbol outline) /*-{
		return this.setOutline(outline);
	}-*/;
	
	/**
	 * Sets the marker symbol style.
	 * 
	 * @param style - Marker style. See the Constants table for valid values.
	 * @return SimpleMarkerSymbol
	 */
	public final SimpleMarkerSymbol setStyle(StyleType style) {
		return _setStyle(style.getValue());
	}
	
	private final native SimpleMarkerSymbol _setStyle(String style) /*-{
		return this.setStyle(style);
	}-*/;

}
