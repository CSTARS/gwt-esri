package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Error;
import edu.ucdavis.cstars.client.layers.Layer;

/**
 * Fires after all layers are added to the map. 
 * 
 * @author Justin Merz
 */
public interface MapLayersAddResultHandler {

	public void onLayersAddResult(JsArray<Result> results);
	
	
	
	public static class Result extends JavaScriptObject {
		
		protected Result() {}
		
		/**
		 * Layer added to the map.
		 * 
		 * @return int 
		 */
		public final native Layer getLayer() /*-{
			return this.layer;
		}-*/;
		
		/**
		 * True if the layer was successfully added.
		 * 
		 * @return boolean
		 */
		public final native boolean isSuccess() /*-{
			return this.success;
		}-*/;
		
		/**
		 * Error message if the map was unable to add the layer.
		 * 
		 * @return Error
		 */
		public final native Error getError() /*-{
			return this.error;
		}-*/;
		
	}
}
