package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.6
 * Define a class breaks classification scheme used by the GenerateDataTask to generate classes. 
 * Class breaks renderers symbolize data based on the value of a numeric attribute. Data with 
 * similar values for the attribute use the same symbol.
 * 
 * @author Justin Merz
 */
public class ClassBreaksDefinition extends ClassificationDefinition {
	
	public static enum ClassificationMethod {
		NOT_SET(""),
		NATURAL_BREAKS("natural-breaks"),
		EQUAL_INTERVAL("equal-interval"),
		QUANTILE("quantile"),
		STANDARD_DEVIATION("standard-deviation"),
		GEOMETRICAL_INTERVAL("geometrical-interval");
		private String val;
		private ClassificationMethod(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static ClassificationMethod get(String cm) {
			for( int i = 0; i < ClassificationMethod.values().length; i++ ){
				if( ClassificationMethod.values()[i].getValue().contentEquals(cm) ){
					return ClassificationMethod.values()[i];
				}
			}
			return ClassificationMethod.NOT_SET;
		}
	}
	
	public static enum NormalizationType {
		NOT_SET(""),
		FIELD("field"),
		LOG("log"),
		PERCENT_OF_TOTAL("percent-of-total");
		private String val;
		private NormalizationType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static NormalizationType get(String nf) {
			for( int i = 0; i < NormalizationType.values().length; i++ ){
				if( NormalizationType.values()[i].getValue().contentEquals(nf) ){
					return NormalizationType.values()[i];
				}
			}
			return NormalizationType.NOT_SET;
		}
	}
	
	public static enum StandardDeviationInterval {
		NOT_SET(0),
		SDI_1(1),
		SDI_0_5(.5),
		SDI_0_33(.33),
		SDI_0_25(.25);
		private double val;
		private StandardDeviationInterval(double value){
			val = value;
		}
		public double getValue(){
			return val;
		}
		public static StandardDeviationInterval get(double sdi) {
			for( int i = 0; i < StandardDeviationInterval.values().length; i++ ){
				if( StandardDeviationInterval.values()[i].getValue() == sdi ){
					return StandardDeviationInterval.values()[i];
				}
			}
			return StandardDeviationInterval.NOT_SET;
		}
	}
	
	protected ClassBreaksDefinition() {}
	
	/**
	 * Creates a new ClassBreaksDefinition object
	 * 
	 * @return ClassBreaksDefinition
	 */
	public static native ClassBreaksDefinition create() /*-{
		return new $wnd.esri.tasks.ClassBreaksDefinition();
	}-*/;
	
	// getBaseSymbol / setBaseSymbol implemented by ClassBreaksDefinition
	
	/**
	 * The number of class breaks.
	 * 
	 * @return int
	 */
	public final native int getBreakCount() /*-{
		return this.breakCount;
	}-*/;
	
	/**
	 * Set the breakCount parameter.
	 * 
	 * @param breakCount - The number of class breaks.
	 */
	public final native void setBreakCount(int breakCount) /*-{
		this.breakCount = breakCount;
	}-*/;
	
	/**
	 * The name of the field used to match values.
	 * 
	 * @return String
	 */
	public final native String getClassificationField() /*-{
		return this.classificationField;
	}-*/;
	
	/**
	 * Set the classificationField parameter.
	 * 
	 * @param classificationField - The name of the field used to match values.
	 */
	public final native void setClassificationField(String classificationField) /*-{
		this.classificationField = classificationField;
	}-*/;
	
	/**
	 * The name of the classification method.
	 * 
	 * @return ClassificationMethod
	 */
	public final ClassificationMethod getClassificationMethod() {
		return ClassificationMethod.get(_getClassificationMethod());
	}
	
	private final native String _getClassificationMethod() /*-{
		return this.classificationMethod;
	}-*/;

	/**
	 * set the classificationMethod parameter.
	 * 
	 * @param classificationMethod - The name of the classification method.
	 */
	public final void setClassificationMethod(ClassificationMethod classificationMethod) {
		_setClassificationMethod(classificationMethod.getValue());
	}
	
	private final native void _setClassificationMethod(String classificationMethod) /*-{
		this.classificationMethod = classificationMethod;
	}-*/;
	
	// getColorRamp / setColorRamp implemented by classificationMethod
	
	/**
	 * The name of the field that contains the values used to normalize class breaks when normalizationType is set to 'field'.
	 * 
	 * @return String
	 */
	public final native String getNormalizationField() /*-{
		return this.normalizationField;
	}-*/;
	
	/**
	 * Set the normalizationField parameter.
	 * 
	 * @param normalizationField - The name of the field that contains the values used to normalize class breaks when 
	 * normalizationType is set to 'field'.
	 */
	public final native void setNormalizationField(String normalizationField) /*-{
		this.normalizationField = normalizationField;
	}-*/;
	
	/**
	 * The type of normalization used to normalize class breaks.
	 * 
	 * @return NormalizationType
	 */
	public final NormalizationType getNormalizationType() {
		return NormalizationType.get(_getNormalizationType());
	}
	
	private final native String _getNormalizationType() /*-{
		return this.normalizationType;
	}-*/;

	/**
	 * Set the normalizationType parameter
	 * 
	 * @param normalizationType - The type of normalization used to normalize class breaks.
	 */
	public final void setNormalizationType(NormalizationType normalizationType) {
		_setNormalizationType(normalizationType.getValue());
	}
	
	private final native void _setNormalizationType(String normalizationType) /*-{
		this.normalizationType = normalizationType;
	}-*/;
	
	/**
	 * The standard deviation interval. When standardDeviationInterval is specified breakCount is ignored. 
	 * Only valid when the classificationMethod is set to 'standard-deviation'.
	 * 
	 * @return StandardDeviationInterval
	 */
	public final StandardDeviationInterval getStandardDeviationInterval() {
		return StandardDeviationInterval.get(_getStandardDeviationInterval());
	}
	
	private final native double _getStandardDeviationInterval() /*-{
		return this.standardDeviationInterval;
	}-*/;

	/**
	 * Set the standardDeviationInterval parameter.
	 * 
	 * @param standardDeviationInterval - The standard deviation interval. When standardDeviationInterval is specified 
	 * breakCount is ignored. Only valid when the classificationMethod is set to 'standard-deviation'.
	 */
	public final void setStandardDeviationInterval(StandardDeviationInterval standardDeviationInterval) {
		_setStandardDeviationInterval(standardDeviationInterval.getValue());
	}
	
	private final native void _setStandardDeviationInterval(double standardDeviationInterval) /*-{
		this.standardDeviationInterval = standardDeviationInterval;
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of the class breaks definition.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	

}
