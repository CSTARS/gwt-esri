package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * Class added v2.6
 * The super class for the classification definition objects used by the GenerateRendererTask class 
 * to generate data classes. This class has no constructor. Use ClassBreaksDefinition or 
 * UniqueValueDefinition instead.
 * 
 * @author Justin Merz
 */
public class ClassificationDefinition extends JavaScriptObject {
	
	public static enum Type {
		NOT_SET(""),
		UNIQUE_VALUE_DEF("uniqueValueDef"),
		CLASS_BREAKS_DEF("classBreaksDef");
		private String val;
		private Type(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static Type get(String t) {
			for( int i = 0; i < Type.values().length; i++ ){
				if( Type.values()[i].getValue().contentEquals(t) ){
					return Type.values()[i];
				}
			}
			return Type.NOT_SET;
		}
	}
	
	protected ClassificationDefinition() {}
	
	/**
	 * Define a default symbol for the classification. If a baseSymbol is not defined then a default symbol is 
	 * created based on the geometryType of the layer.
	 * 
	 * @return Symbol
	 */
	public final native Symbol getBaseSymbol() /*-{
		return this.baseSymbol;
	}-*/;
	
	/**
	 * Set the baseSymbol parameter.
	 * 
	 * @param baseSymbol - Define a default symbol for the classification. If a baseSymbol is not defined then a default 
	 * symbol is created based on the geometryType of the layer.
	 */
	public final native void setBaseSymbol(Symbol baseSymbol) /*-{
		this.baseSymbol = baseSymbol;
	}-*/;
	
	/**
	 * Define a color ramp for the classification. If a colorRamp is not defined then a default color ramp will be used 
	 * to assign a color to each class.
	 * 
	 * @return AlgorithmicColorRamp
	 */
	public final native AlgorithmicColorRamp getColorRampAsAlgorithmicColorRamp() /*-{
		return this.colorRamp;
	}-*/;
	
	/**
	 * Define a color ramp for the classification. If a colorRamp is not defined then a default color ramp will be used 
	 * to assign a color to each class.
	 * 
	 * @return  MultiPartColorRamp
	 */
	public final native MultiPartColorRamp getColorRampAsMultiPartColorRamp() /*-{
		return this.colorRamp;
	}-*/;

	/**
	 * Set the colorRamp parameter.
	 * 
	 * @param colorRamp - Define a color ramp for the classification. If a colorRamp is not defined then a default color ramp 
	 * will be used to assign a color to each class.
	 */
	public final native void setColorRamp(AlgorithmicColorRamp colorRamp) /*-{
		this.colorRamp = colorRamp;
	}-*/;
	
	/**
	 * Set the colorRamp parameter.
	 * 
	 * @param colorRamp - Define a color ramp for the classification. If a colorRamp is not defined then a default color ramp 
	 * will be used to assign a color to each class.
	 */
	public final native void setColorRamp(MultiPartColorRamp colorRamp) /*-{
		this.colorRamp = colorRamp;
	}-*/;
	
	/**
	 * The type of classification definition.
	 * 
	 * @return Type
	 */
	public final Type getType() {
		return Type.get(_getType());
	}
	
	private final native String _getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Set the type parameter.
	 * 
	 * @param type - The type of classification definition.
	 */
	public final void setType(Type type) {
		_setType(type.getValue());
	}
	
	private final native void _setType(String type) /*-{
		this.type = type;
	}-*/;
	
}
