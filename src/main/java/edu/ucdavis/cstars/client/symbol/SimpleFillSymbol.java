package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Fill symbols are used to draw polygon features on the graphics layer. SimpleFillSymbol can be solid, transparent,
 * or one of several cross hatch patterns. In addition, the symbol can have an optional outline, which is defined by
 * a line symbol. 
 * 
 * Known limitation: When using FireFox 2.x, only STYLE_SOLID and STYLE_NULL are valid. All fill styles work
 * correctly in Internet Explorer 6 and 7 and FireFox 3.x.
 * 
 * @author Justin Merz
 */
public class SimpleFillSymbol extends FillSymbol {
	
	public static enum StyleType {
		NOT_SET(""),
		STYLE_BACKWARD_DIAGONAL("backwarddiagonal"),
		STYLE_CROSS("cross"),
		STYLE_DIAGONAL_CROSS ("diagonalcross"),
		STYLE_FORWARD_DIAGONAL("forwarddiagonal"),
		STYLE_HORIZONTAL("horizontal"),
		STYLE_NULL("none"),
		STYLE_SOLID("solid"),
		STYLE_VERTICAL("vertical");
		private String val;
		private StyleType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected SimpleFillSymbol() {}
	
	/**
	 * Creates a new empty SimpleFillSymbol object.
	 * 
	 * @return SimpleFillSymbol
	 */
	public static native SimpleFillSymbol create() /*-{
		return $wnd.esri.symbol.SimpleFillSymbol();
	}-*/;

	/**
	 * Creates a new SimpleFillSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the SimpleFillSymbol.
	 * @return SimpleFillSymbol
	 */
	public static native SimpleFillSymbol create(JavaScriptObject json) /*-{
		return $wnd.esri.symbol.SimpleFillSymbol(json);
	}-*/;
	
	/**
	 * Creates a new SimpleFillSymbol object with parameters.
	 * 
	 * @param style - Fill symbols style
	 * @param outline - outline of symbol
	 * @param color - Symbol color.
	 * @return SimpleFillSymbol
	 */
	public static SimpleFillSymbol create(StyleType style, SimpleLineSymbol outline, Color color ){
		return _create(style.getValue(), outline, color);
	}
	
	private static native SimpleFillSymbol _create(String style, SimpleLineSymbol outline, Color color) /*-{
		return $wnd.esri.symbol.SimpleFillSymbol(style, outline, color);
	}-*/;
	
	/**
	 * The fill style. The default value is STYLE_SOLID. Color is valid only with STYLE_SOLID.
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
	 * Sets the fill symbol style.
	 * 
	 * @param style - Fill style. See the Constants table for valid values.
	 * @return SimpleFillSymbol
	 */
	public final SimpleFillSymbol setStyle(StyleType style) {
		return _setStyle(style.getValue());
	}
	
	private final native SimpleFillSymbol _setStyle(String style) /*-{
		return this.setStyle(style);
	}-*/;
	
}
