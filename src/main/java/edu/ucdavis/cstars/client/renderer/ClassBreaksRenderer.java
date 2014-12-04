package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * A class breaks renderer symbolizes each graphic based on the value of some numeric attribute.
 * 
 * @author Justin Merz
 */
public class ClassBreaksRenderer extends Renderer {
	
	protected ClassBreaksRenderer() {}
	
	/**
	 * Creates a new ClassBreaksRenderer object.
	 * 
	 * @param defaultSymbol - Default symbol for the renderer. This symbol is used for unmatched values.
	 * @param attributeField - Attribute field renderer uses to match values.
	 * @return ClassBreaksRenderer
	 */
	public static final native ClassBreaksRenderer create(Symbol defaultSymbol, String attributeField) /*-{
		return $wnd.esri.renderer.ClassBreaksRenderer(defaultSymbol, attributeField);
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
	 * A 2-D array representing defined breaks. The array consists of [minValue,maxValue] pairs.
	 * 
	 * @deprecated at v2.0, use getInfos() instead.
	 * 
	 * @return JsArray<Breaks>
	 */
	public final native JsArray<Break> getBreaks() /*-{
		return this.breaks;
	}-*/;
	
	/**
	 * Each element in the array is an object that provides information about the class breaks associated with the renderer.
	 * 
	 * @return JsArray<Info>
	 */
	public final native JsArray<Info> getInfos() /*-{
		return this.infos;
	}-*/;

	/**
	 * Adds a class break. You can provide the minimum, maximum and symbol values as individual arguments or using the info
	 * object. The range of the break is greater than or equal to the minimum value and less than the maximum value. After
	 * making changes, you must refresh the graphic.
	 * 
	 * @param minValue - Minimum value in the break.
	 * @param maxValue - Maximum value in the break.
	 * @param symbol - Symbol used for the break.
	 */
	public final native void addBreak(double minValue, double maxValue, Symbol symbol) /*-{
		this.addBreak(minValue, maxValue, symbol);
	}-*/;
	
	/**
	 * Adds a class break. You can provide the minimum, maximum and symbol values as individual arguments or using the info
	 * object. The range of the break is greater than or equal to the minimum value and less than the maximum value. After
	 * making changes, you must refresh the graphic.
	 * 
	 * @param minValue - Minimum value in the break.
	 * @param maxValue - Maximum value in the break.
	 * @param symbol - Symbol used for the break.
	 * @param label - Label for the symbol used to draw the value.
	 * @param description - Label for the symbol used to draw the value.
	 */
	public final native void addBreak(double minValue, double maxValue, Symbol symbol, String label, String description) /*-{
		this.addBreak({minValue: minValue, maxValue: maxValue, symbol: symbol, label: label, description: description});
	}-*/;
	
	/**
	 * Removes a break. After making changes, you must refresh the graphic.
	 * 
	 * @param minValue - Minimum value in the break to remove.
	 * @param maxValue - Maximum value in the break to remove.
	 */
	public final native void removeBreak(double minValue, double maxValue) /*-{
		this.removeBreak(minValue, maxValue);
	}-*/;

	public static class Info extends JavaScriptObject {
		
		protected Info() {}
	
		/**
		 * The minimum value.
		 * 
		 * @return double
		 */
		public final native double getMinValue() /*-{
			return this.minValue;
		}-*/;
		
		/**
		 * The maximum value.
		 * 
		 * @return double
		 */
		public final native double getMaxValue() /*-{
			return this.maxValue;
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
	
	/**
	 * @deprecated at v2.0.  Use Info instead
	 */
	public static class Break extends JavaScriptObject {
		
		protected Break() {}
		
		public final native float getMinValue() /*-{
			return this[0];
		}-*/;
		
		public final native float getMaxValue() /*-{
			return this[1];
		}-*/;
		
	}
	
}
