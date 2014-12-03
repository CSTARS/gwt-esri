package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Line symbols are used to draw linear features on the graphics layer. SimpleLineSymbol is either
 * a solid line or a predefined pattern of dashes and dots.
 * 
 * @author Justin Merz
 */
public class SimpleLineSymbol extends LineSymbol {
	
	public static enum StyleType {
		NOT_SET(""),
		STYLE_DASH("dash"),
		STYLE_DASHDOT("dashdot"),
		STYLE_DASHDOTDOT("longdashdotdot"),
		STYLE_DOT("dot"),
		STYLE_NULL("none"),
		STYLE_SOLID("solid");
		private String val;
		private StyleType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected SimpleLineSymbol() {}
	
	/**
	 * Creates a new SimpleLineSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the SimpleLineSymbol.
	 * @return SimpleLineSymbol
	 */
	public static native SimpleLineSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.SimpleLineSymbol(json);
	}-*/;
	
	/**
	 * Creates a new empty SimpleLineSymbol object.
	 * 
	 * @return SimpleLineSymbol
	 */
	public static native SimpleLineSymbol create() /*-{
		return new $wnd.esri.symbol.SimpleLineSymbol();
	}-*/;
	
	/**
	 * Creates a new SimpleLineSymbol object with parameters.
	 * 
	 * @param style - line style.
	 * @param color - line color.
	 * @param width - Width of the line in pixels.
	 * @return SimpleLineSymbol
	 */
	public static SimpleLineSymbol create(StyleType style, Color color, int width ){
		return _create(style.getValue(), color, width);
	}
	
	private static native SimpleLineSymbol _create(String style, Color color, int width) /*-{
		return new $wnd.esri.symbol.SimpleLineSymbol(style, color, width);
	}-*/;
	
	/**
	 * The line style. The default value is STYLE_SOLID.
	 * 
	 * @return StyleLine
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
	 * Sets the line symbol style.
	 * 
	 * @param style - Line style.
	 * @return SimpleFillSymbol
	 */
	public final SimpleFillSymbol setStyle(StyleType style) {
		return _setStyle(style.getValue());
	}
	
	private final native SimpleFillSymbol _setStyle(String style) /*-{
		return this.setStyle(style);
	}-*/;

}
