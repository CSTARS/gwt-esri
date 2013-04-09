package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * A unique value renderer symbolizes groups of graphics that have matching attributes. 
 * 
 * @author Justin Merz
 */
public class UniqueValueRenderer extends Renderer {
	
	protected UniqueValueRenderer() {}
	
	/**
	 * Creates a new UniqueValueRenderer object. Typically features are rendered based on the unique values of one attribute field.
	 * However up to three fields can be combined to generate a unique value. For example, if two fields are used which store the values
	 * A and B; and X, Y, and Z respectively, then the unique values for the renderer can be A:X, A:Y, A:Z, B:X, B:Y and B:Z, assuming ":"
	 * is the field delimiter.
	 * 
	 * @param defaultSymbol - Default symbol for the renderer. This symbol is used for unmatched values.
	 * @param attributeField - Attribute field renderer uses to match values.
	 * @return UniqueValueRenderer
	 */
	public static final native UniqueValueRenderer create(Symbol defaultSymbol, String attributeField) /*-{
		return $wnd.esri.renderer.UniqueValueRenderer(defaultSymbol, attributeField);
	}-*/;
	
	/**
	 * Creates a new UniqueValueRenderer object. Typically features are rendered based on the unique values of one attribute field.
	 * However up to three fields can be combined to generate a unique value. For example, if two fields are used which store the values
	 * A and B; and X, Y, and Z respectively, then the unique values for the renderer can be A:X, A:Y, A:Z, B:X, B:Y and B:Z, assuming ":"
	 * is the field delimiter.
	 * 
	 * @param defaultSymbol - Default symbol for the renderer. This symbol is used for unmatched values.
	 * @param attributeField - Attribute field renderer uses to match values.
	 * @param attributeField2 - If needed, specify an additional attribute field the renderer uses to match values.
	 * @param attributeField3 - If needed, specify an additional attribute field the renderer uses to match values.
	 * @param fieldDelimeter - String inserted between the values of different fields. Applicable only when more than one attribute field is
	 * specifed for the renderer.
	 * @return UniqueValueRenderer
	 */
	public static final native UniqueValueRenderer create(Symbol defaultSymbol, String attributeField, 
			String attributeField2, String attributeField3, String fieldDelimeter) /*-{
		return $wnd.esri.renderer.UniqueValueRenderer(defaultSymbol, attributeField, attributeField2, attributeField3, fieldDelimeter);
	}-*/;
	
	/**
	 * The name of the attribute field the renderer uses to match values against.
	 * 
	 * @return String
	 */
	public final native String getAttributeField() /*-{
		return this.attributeField;
	}-*/;
	
	/**
	 * If needed, specify an additional attribute field the renderer uses to match values.
	 * 
	 * @return String
	 */
	public final native String getAttributeField2() /*-{
		if( this.attributeField2 ) return this.attributeField2;
		return "";
	}-*/;
	
	/**
	 * If needed, specify an additional attribute field the renderer uses to match values.
	 * 
	 * @return String
	 */
	public final native String getAttributeField3() /*-{
		if( this.attributeField3 ) return this.attributeField3;
		return "";
	}-*/;
	
	/**
	 * Label for the default symbol used to draw unspecified values. 
	 * 
	 * @return  String
	 */
	public final native String getDefaultLabel() /*-{
		return this.defaultLabel;
	}-*/;
	
	/**
	 * String inserted between the values if multiple attribute fields are specified.
	 * 
	 * @return String
	 */
	public final native String getFieldDelimiter() /*-{
		return this.fieldDelimiter;
	}-*/;
	
	/**
	 * Each element in the array is an object that provides information about the unique values associated with the renderer.
	 * 
	 * @return JsArray<Info>
	 */
	public final native JsArray<Info> getInfos() /*-{
			return this.infos;
	}-*/;
	
	/**
	 * An array of values defined for the renderer.
	 * 
	 * @deprecated at v2.0, use infos instead.
	 *  
	 * @return JsArrayString
	 */
	@Deprecated
	public final native JsArrayString getValues() /*-{
		return this.values;
	}-*/;

	/**
	 * Adds a unique value and symbol. You can provide the value and its associated symbol as individual arguments.
	 * 
	 * @param value - Value to match with.
	 * @param symbol - Symbol used for the value.
	 */
	public final native void addValue(String value, Symbol symbol) /*-{
		this.addValue(value, symbol);
	}-*/;
	
	/**
	 * Adds a unique value and symbol.You can provide the value and its associated symbol as an info object.
	 * 
	 * @param info - object to be added.
	 */
	public final native void addValue(Info info) /*-{
		this.addValue(info);
	}-*/;
	
	/**
	 * Removes a unique value. After making changes, you must refresh the graphic.
	 * 
	 * @param value - Value to remove.
	 */
	public final native void removeValue(String value) /*-{
		this.removeValue(value);
	}-*/;
	
	public static class Info extends JavaScriptObject {
		
		protected Info() {}
		
		/**
		 * Create a new info object
		 * 
		 * @param value - The unique value.
		 * @param symbol - The symbol used to display the value.
		 * @param label - Label for the symbol used to draw the value.
		 * @param description - Label for the symbol used to draw the value.
		 * @return Info
		 */
		public static native Info create(String value, Symbol symbol, String label, String description) /*-{
			return {"value":value,"symbol":symbol,"label":label,"description":description}; 
		}-*/;
		
		/**
		 * The unique value.
		 * 
		 * @return String
		 */
		public final native String getValue() /*-{
			return this.value;
		}-*/;

		/**
		 * The symbol used to display the value.
		 * 
		 * @return Symbol
		 */
		public final native Symbol getSymbol() /*-{
			return this.symbol;
		}-*/;
		
		/**
		 * Label for the symbol used to draw the value.
		 * 
		 * @return String
		 */
		public final native String getLabel() /*-{
			return this.label;
		}-*/;
		
		/**
		 * Label for the symbol used to draw the value.
		 * 
		 * @return String
		 */
		public final native String getDescription() /*-{
			return this.description;
		}-*/;
		
	}
	
}
