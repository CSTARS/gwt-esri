package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Text symbols are used to add text on the graphics layer.
 * 
 * @author Justin Merz
 */
public class TextSymbol extends Symbol {

	public static enum AlignType {
		NOT_SET(""),
		ALIGN_END("end"),
		ALIGN_MIDDLE("middle"),
		ALIGN_START("start");
		private String val;
		private AlignType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum DecorationType {
		NOT_SET(""),
		DECORATION_LINETHROUGH("line-through"),
		DECORATION_NONE("none"),
		DECORATION_OVERLINE("overline"),
		DECORATION_UNDERLINE("underline");
		private String val;
		private DecorationType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected TextSymbol() {}
	
	/**
	 * Creates a new TextSymbol object that includes only the text.
	 * 
	 * @param text - Text string for display in the graphics layer.
	 * @return TextSymbol
	 */
	public static native TextSymbol create(String text) /*-{
		return new $wnd.esri.symbol.TextSymbol(text);
	}-*/;
	
	/**
	 * Creates a new TextSymbol object.
	 * 
	 * @param text - Text string for display in the graphics layer.
	 * @param font - Font for displaying text.
	 * @param color - Symbol color.
	 * @return TextSymbol
	 */
	public static native TextSymbol create(String text, Font font, Color color) /*-{
		return new $wnd.esri.symbol.TextSymbol(text, font, color);
	}-*/;
	
	/**
	 * Creates a new TextSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the text symbol.
	 * @return TextSymbol
	 */
	public static native TextSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.TextSymbol(json);
	}-*/;
	
	/**
	 * The text alignment in relation to the point. Default value: ALIGN_MIDDLE
	 * 
	 * @return AlignType
	 */
	public final AlignType getAlign() {
		String a = _getAlign();
		for( int i = 0; i < AlignType.values().length; i++ ){
			if( AlignType.values()[i].getValue().contentEquals(a) ){
				return AlignType.values()[i];
			}
		}
		return AlignType.NOT_SET;
	}
	
	private final native String _getAlign() /*-{
		return this.align;
	}-*/;
	
	/**
	 * Text angle. 0 is horizontal and the angle moves clockwise.
	 * 
	 * @return int
	 */
	public final native int getAngle() /*-{
		return this.angle;
	}-*/;
	
	/**
	 * The decoration on the text. Default value: DECORATION_NONE
	 * 
	 * @return DecorationType
	 */
	public final DecorationType getDecoration() {
		String d = _getDecoration();
		for( int i = 0; i < DecorationType.values().length; i++ ){
			if( DecorationType.values()[i].getValue().contentEquals(d) ){
				return DecorationType.values()[i];
			}
		}
		return DecorationType.NOT_SET;
	}
	
	private final native String _getDecoration() /*-{
		return this.decoration;
	}-*/;
	
	/**
	 * Font for displaying text.
	 * 
	 * @return Font
	 */
	public final native Font getFont() /*-{
		return this.font;
	}-*/;
	
	/**
	 * Determines whether to adjust the spacing between characters in the text string. Default value: true
	 * 
	 * @return boolean
	 */
	public final native boolean hasKerning() /*-{
		return this.kerning;
	}-*/;
	
	/**
	 * Determines whether every character in the text string is rotated.
	 * 
	 * @return boolean
	 */
	public final native boolean isRotated() /*-{
		return this.rotated;
	}-*/;
	
	/**
	 * Text string for display in the graphics layer.
	 * 
	 * @return String
	 */
	public final native String getText() /*-{
		return this.text;
	}-*/;
	
	/**
	 * The offset on the x-axis in pixels from the point. Default value: 0
	 * 
	 * @return int
	 */
	public final native int getXOffset() /*-{
		return this.xoffset;
	}-*/;
	
	/**
	 * The offset on the y-axis in pixels from the point. Default value: 0
	 * 
	 * @return int
	 */
	public final native int getYOffset() /*-{
		return this.yoffset;
	}-*/;
	
	/**
	 * Sets the alignment of the text.
	 * 
	 * @param align - The text alignment. 
	 * @return TextSymbol
	 */
	public final TextSymbol setAlign(AlignType align) {
		return _setAlign(align.getValue());
	};
	
	private final native TextSymbol _setAlign(String align) /*-{
		return this.setAlign(align);
	}-*/;
	
	/**
	 * Sets the angle of the text.
	 * 
	 * @param angle - Angle value between 0 and 359.
	 * @return TextSymbol
	 */
	public final native TextSymbol setAngle(int angle) /*-{
		return this.setAngle(angle);
	}-*/;
	
	/**
	 * Sets the decoration for the text.Many browsers including Internet Explorer 7, Firefox and Opera 9
	 * do not support the decoration properties for text symbols.
	 * 
	 * @param decoration - The decoration on the text.
	 * @return TextSymbol
	 */
	public final TextSymbol setDecoration(DecorationType decoration) {
		return _setDecoration(decoration.getValue());
	}
	
	private final native TextSymbol _setDecoration(String decoration) /*-{
		return this.setDecoration(decoration);
	}-*/;
	
	/**
	 * Sets the text font.
	 * 
	 * @param font - Text font.
	 * @return TextSymbol
	 */
	public final native TextSymbol setFont(Font font) /*-{
		return this.setFont(font);
	}-*/;
	
	/**
	 * Sets whether to adjust the spacing between characters in the text string.
	 * 
	 * @param kerning - Set to true for kerning.
	 * @return TextSymbol
	 */
	public final native TextSymbol setKerning(boolean kerning) /*-{
		return this.setKerning(kerning);
	}-*/;
	
	/**
	 * Sets the x and y offset of the text.
	 * 
	 * @param x - X offset value in pixels.
	 * @param y - Y offset value in pixels.
	 * @return TextSymbol
	 */
	public final native TextSymbol setOffset(int x, int y) /*-{
		return this.setOffset(x, y);
	}-*/;
	
	/**
	 * Sets whether every character in the text string is rotated. Many browsers including Internet
	 * Explorer 7, Firefox and Opera 9 do not support rotated for text symbols.
	 * 
	 * @param rotated - Set to true to rotate all characters in the string.
	 * @return TextSymbol
	 */
	public final native TextSymbol setRotated(boolean rotated) /*-{
		return this.setRotated(rotated);
	}-*/;
	
	/**
	 * Sets the text string.
	 * 
	 * @param text - The text string.
	 * @return TextSymbol
	 */
	public final native TextSymbol setText(String text) /*-{
		return this.setText(text);
	}-*/;
}
