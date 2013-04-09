package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Time class breaks ager displays aging by classifying features based on an age range.
 * 
 * @author Justin Merz
 */
public class TimeClassBreaksAger extends SymbolAger {
	
	protected TimeClassBreaksAger() {}
	
	public enum TimeUnits {
		UNIT_DAYS("day"),
		UNIT_HOURS("hour"),
		UNIT_MILLISECONDS("millisecond"),
		UNIT_MINUTES("minute"),
		UNIT_MONTHS("month"),
		UNIT_SECONDS("second"),
		UNIT_WEEKS("week"),
		UNIT_YEARS("year");
		private String value = "";
		TimeUnits(String val) {
			value = val;
		}
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * Creates a new TimeClassBreaksAgerObject with the specified time breaks inforamtion.
	 * 
	 * @param infos - Each element in the array is an object that describes the class breaks information.
	 * @return TimeClassBreaksAger
	 */
	public static TimeClassBreaksAger create(Info[] infos) {
		return _create(Util.objectArrayToJSO(infos));
	}
	
	private static native TimeClassBreaksAger _create(JavaScriptObject infos) /*-{
		return new $wnd.esri.renderer.TimeClassBreaksAger(infos);
	}-*/;

	/**
	 * Creates a new TimeClassBreaksAgerObject with the specified time breaks inforamtion.
	 * 
	 * @param infos - Each element in the array is an object that describes the class breaks information.
	 * @param timeUnits - The unit in which the minimum and maximum break values are measured.  Default is days.
	 * @return TimeClassBreaksAger
	 */
	public static TimeClassBreaksAger create(Info[] infos, TimeUnits timeUnits) {
		return _create(Util.objectArrayToJSO(infos), timeUnits.getValue());
	}
	
	private static native TimeClassBreaksAger _create(JavaScriptObject infos, String timeUnits) /*-{
		return new $wnd.esri.renderer.TimeClassBreaksAger(infos, timeUnits);
	}-*/;
	
	// getAgedSymbol implemented by SymbolAger
	
	public static class Info extends JavaScriptObject {
		
		protected Info() {}
		
		/**
		 * object that describes the class breaks information.
		 * 
		 * @param minAge - The minimum age for the break info.
		 * @param maxAge - The maximum age for the break info.
		 * @param color - The color for the break.
		 * @param size - The size for the break.
		 * @return Info
		 */
		public static native Info create(int minAge, int maxAge, Color color, int size) /*-{
			return {"minAge":minAge,"maxAge":maxAge,"color":color,"size":size};
		}-*/;
		
		public static Info create(int minAge, int maxAge, Color color, int size, TimeUnits timeUnits) {
			return _create(minAge, maxAge, color, size, timeUnits.getValue());
		};
		
		private static native Info _create(int minAge, int maxAge, Color color, int size, String timeUnits) /*-{
			return {"minAge":minAge,"maxAge":maxAge,"color":color,"size":size,"timeUnits":timeUnits};
		}-*/;
		
		public final native void setMaxAgeInfinity() /*-{
			this.maxAge = "Infinity";
		}-*/;
		
	}
}
