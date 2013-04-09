package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.6
 * The StatisticDefinition class defines the type of statistics, the field used to calculate the statistics and the resulting output 
 * field name. Used to specify an array of statistic definitions for a query's outStatistics property.
 * 
 * Requires ArcGIS Server service version 10.1 or greater
 * 
 * @author Justin Merz
 */
public class StatisticDefinition extends JavaScriptObject {
	
	public enum StatisticType {
		UNKNOWN(""),
		COUNT("count"),
		SUM("sum"),
		MIN("min"),
		MAX("max"),
		AVG("avg"),
		STDDEV("stddev");
		private String value = "";
		StatisticType(String val) {
			value = val;
		}
		public String getValue() {
			return value;
		}
		public static StatisticType get(String st) {
			for( int i = 0; i < StatisticType.values().length; i++ ) {
				if( StatisticType.values()[i].getValue().contentEquals(st)) {
					return StatisticType.values()[i];
				}
			}
			return StatisticType.UNKNOWN;
		}
	}
	
	protected StatisticDefinition() {}
	
	/**
	 * Creates a new StatisticDefinition object.
	 * 
	 * @return StatisticDefinition
	 */
	public static native StatisticDefinition create() /*-{
		return new $wnd.esri.tasks.StatisticDefinition();
	}-*/;

	/**
	 * Define the field on which statistics will be calculated.
	 * 
	 * @return String
	 */
	public final native String getOnStatisticField() /*-{
		return this.onStatisticField;
	}-*/;
	
	/**
	 * Set the onStatisticField parameter.
	 * 
	 * @param onStatisticField - Define the field on which statistics will be calculated.
	 */
	public final native void setOnStatisticField(String onStatisticField) /*-{
		this.onStatisticField = onStatisticField;
	}-*/;
	
	/**
	 * Specify the output field name. Output field names can only contain alpha-numeric 
	 * characters and an underscore. If no output field name is specified the map server 
	 * assigns a field name to the returned statistic field.
	 * 
	 * @return String
	 */
	public final native String getOutStatisticFieldName() /*-{
		return this.outStatisticFieldName;
	}-*/;
	
	/**
	 * Set the outStatisticFieldName parameter.
	 * 
	 * @param outStatisticFieldName - Specify the output field name. Output field names 
	 * can only contain alpha-numeric characters and an underscore. If no output field 
	 * name is specified the map server assigns a field name to the returned statistic field.
	 */
	public final native void setOutStatisticFieldName(String outStatisticFieldName) /*-{
		this.outStatisticFieldName = outStatisticFieldName;
	}-*/;
	
	/**
	 * Define the type of statistic.
	 * 
	 * @return StatisticType
	 */
	public final StatisticType getStatisticType()  {
		return StatisticType.get(_getStatisticType());
	}
	
	private final native String _getStatisticType() /*-{
		return this.statisticType;
	}-*/;
	
	/**
	 * Set the statisticType.
	 * 
	 * @param statisticType - Define the type of statistic.
	 */
	public final void setStatisticType(StatisticType statisticType) {
		_setStatisticType(statisticType.getValue());
	}
	
	private final native void _setStatisticType(String statisticType) /*-{
		this.statisticType = statisticType;
	}-*/;
	
}
