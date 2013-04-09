package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Represent the output parameters of a GP task and their properties and values.
 * 
 * @author Justin Merz
 */
public class ParameterValue extends JavaScriptObject {
	
	public enum DataType {
		NOT_SET(""),
		GP_STRING("GPString"),
		GP_DOUBLE("GPDouble"),
		GP_LONG("GPLong"),
		GP_BOOLEAN("GPBoolean"),
		GP_DATE("GPDate"),
		GP_LINEAR_UNIT("GPLinearUnit"),
		GP_DATA_FILE("GPDataFile"),
		GP_RASTER_DATA("GPRasterData"),
		GP_RECORD_SET("GPRecordSet"),
		GP_RASTER_DATA_LAYER("GPRasterDataLayer"),
		GP_FEATURE_RECORD_SET_LAYER("GPFeatureRecordSetLayer"),
		GP_MULTI_VALUE("GPMultiValue");
		
		private String value = "";
		DataType(String val) {
			value = val;
		}
		public String getValue() {
			return value;
		}
		public static DataType get(String dt) {
			for( int i = 0 ; i < DataType.values().length; i++ ){
				if( DataType.values()[i].getValue().contentEquals(dt) )
					return DataType.values()[i];
			}
			return DataType.NOT_SET;
		}
	}
	
	protected ParameterValue() {}
	
	/**
	 * Specifies the type of data for the parameter.
	 * 
	 * @return String
	 */
	public final DataType getDataType() {
		return DataType.get(_getDataType());
	}
	
	private final native String _getDataType() /*-{
		return this.dataType;
	}-*/;
	
	/**
	 * Unique name of the parameter.
	 * 
	 * @return String
	 */
	public final native String getParamName() /*-{
		return this.paramName;
	}-*/;

	/**
	 * The value of the parameter. The data structure of this value depends on the dataType. 
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getValue() /*-{
		return this.value;
	}-*/;
	
	public final native String getValueGPString() /*-{
		return this.value;
	}-*/;

	public final native double getValueGPDouble() /*-{
		return this.value;
	}-*/;
	
	// TODO: longs can't be returned from JSNI
	public final native float getValueGPLong() /*-{
		return this.value;
	}-*/;

	public final native boolean getValueGPBoolean() /*-{
		return this.value;
	}-*/;
	
	public final native Date getValueGPDate() /*-{
		return this.value;
	}-*/;
	
	public final native LinearUnit getValueGPLinearUnit() /*-{
		return this.value;
	}-*/;	
	
	public final native DataFile getValueGPDataFile() /*-{
		return this.value;
	}-*/;
	
	public final native RasterData getValueGPRasterData() /*-{
		return this.value;
	}-*/;
	
	public final native FeatureSet getValueGPFeatureSet() /*-{
		return this.value;
	}-*/;
	
	public final native RasterData getValueGPRasterDataLayer() /*-{
		return this.value;
	}-*/;
	
	public final native FeatureSet getValueGPFeatureRecordSetLayer() /*-{
		return this.value;
	}-*/;
	
	public final native JsArrayString getValueGPMultiValue() /*-{
		return this.value;
	}-*/;

}
