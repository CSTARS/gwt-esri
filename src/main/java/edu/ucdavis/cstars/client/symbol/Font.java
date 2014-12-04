package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Font used for text symbols added to the graphics layer.
 * 
 * @author Justin Merz
 */
public class Font extends Symbol {
	
	public static enum StyleType {
		NOT_SET(""),
		STYLE_ITALIC("italic"),
		STYLE_NORMAL("normal"),
		STYLE_OBLIQUE("oblique");
		private String val;
		private StyleType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum VariantType {
		NOT_SET(""),
		VARIANT_NORMAL("normal"),
		VARIANT_SMALLCAPS("small-caps");
		private String val;
		private VariantType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum WeightType {
		NOT_SET(""),
		WEIGHT_BOLD("bold"),
		WEIGHT_BOLDER("bolder"),
		WEIGHT_LIGHTER("lighter"),
		WEIGHT_NORMAL("normal");
		private String val;
		private WeightType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected Font() {}
	
	/**
	 * Creates a new Font object. 
	 * 
	 * @return Font
	 */
	public static native Font create() /*-{
		return new $wnd.esri.symbol.Font();
	}-*/;
	
	/**
	 * Creates a new Font object.
	 * 
	 * @param size - Font size.
	 * @param style - Font Style.
	 * @param variant - Font variant.
	 * @param weight - Font weight.
	 * @param family - Font family.
	 * @return Font
	 */
	public static Font create(int size, StyleType style, VariantType variant, WeightType weight, String family) {
		return _create(size, style.getValue(), variant.getValue(), weight.getValue(), family);
	};
	
	private static native Font _create(int size, String style, String variant, String weight, String family) /*-{
		return new $wnd.esri.symbol.Font(size, style, variant, weight, family);
	}-*/;

	/**
	 * Creates a new Font object using a JSON object.
	 * 
	 * @param json - JSON object representing the font.
	 * @return Font
	 */
	public static native Font create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.Font(json);
	}-*/;
	
	/**
	 * Font family. Default value: Serif.
	 * 
	 * @return String
	 */
	public final native String getFamily() /*-{
		return this.family;
	}-*/;
	
	/**
	 * Font size. Values can be in "pt", "px", "em", and "%". For example: "12pt", "12px", ".8em", "80%"
	 * 
	 * @return String
	 */
	public final native String getSize() /*-{
		return this.size;
	}-*/;
	
	/**
	 * Text style. See the Constants table for valid values. Default value: STYLE_NORMAL
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
	 * Text variant. Default value: VARIANT_NORMAL
	 * 
	 * @return VariantType
	 */
	public final VariantType getVariant() {
		String v = _getVariant();
		for( int i = 0; i < VariantType.values().length; i++ ){
			if( VariantType.values()[i].getValue().contentEquals(v) ){
				return VariantType.values()[i];
			}
		}
		return VariantType.NOT_SET;
	}
	
	private final native String _getVariant() /*-{
		return this.variant;
	}-*/;
	
	/**
	 * Text weight. Default value: WEIGHT_NORMAL
	 * 
	 * @return WeightType
	 */
	public final WeightType getWeights() {
		String w = _getWeight();
		for( int i = 0; i < WeightType.values().length; i++ ){
			if( WeightType.values()[i].getValue().contentEquals(w) ){
				return WeightType.values()[i];
			}
		}
		return WeightType.NOT_SET;
	}
	
	private final native String _getWeight() /*-{
		return this.weight;
	}-*/;
	
	/**
	 * Sets the font family.The font family property does not work in Internet Explorer 7; Arial is always used.
	 * 
	 * @param family - Font family.
	 * @return Font
	 */
	public final native String setFamily(String family) /*-{
		return this.setFamily(family);
	}-*/;
	
	/**
	 * Sets the font size. Values can be in "pt", "px", "em", and "%". For example: "12pt", "12px", ".8em", "80%"
	 * 
	 * @param size - Font size in points.
	 * @return String
	 */
	public final native String setSize(String size) /*-{
		return this.setSize(size);
	}-*/;
	
	/**
	 * Sets the font style.
	 * 
	 * @param style - Font Style
	 * @return Font
	 */
	public final Font setStyle(StyleType style){
		return _setStyle(style.getValue());
	}
	
	private final native Font _setStyle(String style) /*-{
		return this.setStyle(style);
	}-*/;
	
	/**
	 * Sets the font variant.
	 * 
	 * @param variant - Font variant. 
	 * @return Font
	 */
	public final Font setVariant(VariantType variant){
		return _setVariant(variant.getValue());
	}
	
	private final native Font _setVariant(String variant) /*-{
		return this.setVariant(variant);
	}-*/;
	
	/**
	 * Sets the font weight.
	 * 
	 * @param weight - Font weight. 
	 * @return Font
	 */
	public final Font setWeight(WeightType weight){
		return _setWeight(weight.getValue());
	}
	
	private final native Font _setWeight(String weight) /*-{
		return this.setWeight(weight);
	}-*/;
	
}
