package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Fires when the lengths operation is complete.
 * 
 * @author Justin Merz
 */
public interface LengthsHandler {

	/**
	 * 
	 * @param lengths - The object with the areas and lengths.
	 */
	public void onLengthsComplete(Lengths lengths);
	
	
	public static class Lengths extends JavaScriptObject {
		
		protected Lengths() {}
	
		public final native JsArrayNumber getLengths() /*-{
			return this.lengths;
		}-*/;
		
	}
	
}
