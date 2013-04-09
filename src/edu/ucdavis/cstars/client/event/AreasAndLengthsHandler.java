package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Fires when the areasAndLengths operation is complete
 * 
 * @author Justin Merz
 */
public interface AreasAndLengthsHandler {
	
	/**
	 * 
	 * @param results - The object with the areas and lengths.
	 */
	public void onAreasAndLengthsComplete(AreasAndLengths results);
	
	
	public static class AreasAndLengths extends JavaScriptObject {
		
		protected AreasAndLengths() {}
		
		public final native JsArrayNumber getAreas() /*-{
			return this.areas;
		}-*/;
		
		public final native JsArrayNumber getLengths() /*-{
			return this.lengths;
		}-*/;
		
	}

}
