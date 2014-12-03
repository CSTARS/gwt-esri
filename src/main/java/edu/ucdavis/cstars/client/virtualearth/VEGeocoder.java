package edu.ucdavis.cstars.client.virtualearth;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.VEAddressToLocationsCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.VEAddressToLocationsHandler;

/**
 * Bing Maps geocoder.
 * 
 * @author Justin Merz
 */
public class VEGeocoder extends JavaScriptObject {
	
	protected VEGeocoder() {}
	
	/**
	 * Creates a new VEGeocoder object.
	 * 
	 * @param options
	 * @return VEGeocoder
	 */
	public static VEGeocoder create(Options options) {
		// if not loaded return empty object
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		
		return _create(options);
	}
	
	private static native VEGeocoder _create(Options options) /*-{
		return new $wnd.esri.virtualearth.VEGeocoder(options);
	}-*/;
	
	/**
	 * Check that the esri.virtualearth.VEGeocoder package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.virtualearth.VEGeocoder ) return true;
		$wnd.alert("The ESRI_VIRTUALEARTH_VEGEOCODER has not been loaded");
		return false;
	}-*/;

	/**
	 * Specifies the culture in which to return results. The default value is "en-US". For a list of supported cultures,
	 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
	 * 
	 * @return String
	 */
	public final native String getCulture() /*-{
		return this.culture;
	}-*/;
	
	/**
	 * Sends a geocode request to Bing Maps to find candidates for a single address specified in the query argument.
	 * 
	 * @param query - The address to locate.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred addressToLocations(String query, VEAddressToLocationsCallback callback ) /*-{
		return this.addressToLocations( query,
			function(geocodeResults) {
				callback.@edu.ucdavis.cstars.client.callback.VEAddressToLocationsCallback::onAddressToLocationsComplete(Lcom/google/gwt/core/client/JsArray;)(geocodeResults);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.VEAddressToLocationsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a geocode request to Bing Maps to find candidates for a single address specified in the query argument.
	 * 
	 * @param query - The address to locate.
	 * @return Deferred
	 */
	public final native Deferred addressToLocations(String query) /*-{
		return this.addressToLocations( query);
	}-*/;
	
	/**
	 * Sets the culture in which to return results.
	 * 
	 * @param culture - The culture value. The default value is "en-US". For a list of supported cultures,
	 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
	 */
	public final native void setCulture(String culture) /*-{
		this.setCulture(culture);
	}-*/;
	
	/**
	 * Add event handler to listen to onAddressToLocationsComplete.
	 * 
	 * @param handler - Fires when VEGeocode.addressToLocation() has completed.
	 */
	public final native void addAddressToLocationsHandler(VEAddressToLocationsHandler handler ) /*-{
		$wnd.dojo.connect(this, "onAddressToLocationsComplete", 
			function(geocodeResults) {
				handler.@edu.ucdavis.cstars.client.event.VEAddressToLocationsHandler::onAddressToLocationsComplete(Lcom/google/gwt/core/client/JsArray;)(geocodeResults);
			}
		);
	}-*/;
	
	/**
	 * Add event handler to listen to onError.
	 * 
	 * @param handler - Fires when an error occurs when executing the task.
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	
	/**
	 * Options object for VEGeocoder
	 */
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Set the bingMapKey parameter.
		 * 
		 * @param bingMapKey - Key used to access Bing Maps maps. View the Getting start with Bing Maps help topic for more details.
		 * http://help.arcgis.com/en/webapi/javascript/arcgis/help/jshelp/ve_getting_started.htm
		 */
		public final native void setBingMapsKey(String bingMapKey) /*-{
			this["bingMapsKey"] = bingMapsKey; 
		}-*/;
		
		/**
		 * Set the culture parameter
		 * 
		 * @param culture - Specifies the culture in which to return results. The default value is "en-US". For a list of supported cultures,
		 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
		 */
		public final native void setCulture(String culture) /*-{
			this["culture"] = culture;
		}-*/;
		
	}
	
}
