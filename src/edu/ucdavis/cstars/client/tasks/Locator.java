package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.callback.AddressToLocationsCallback;
import edu.ucdavis.cstars.client.callback.LocationToAddressCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.AddressToLocationsHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.LocationToAddressHandler;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Represents a geocode service resource exposed by the ArcGIS Server REST API. It is used to generate candidates 
 * for an address. It also used to find an address for a given location. 
 * 
 * @author Justin Merz
 */
public class Locator extends JavaScriptObject {
	
	protected Locator() {}
	
	/**
	 * Creates a new Locator object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a locator service. An example is 
	 * http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Locators/ESRI_Geocode_USA/GeocodeServer.
	 * @return Locator
	 */
	public static native Locator create(String url) /*-{
		return new $wnd.esri.tasks.Locator(url);
	}-*/;
	
	/**
	 * The spatial reference of the output geometries. If not specified, the output geometries are in the spatial 
	 * reference of the input geometries. If processSpatialReferencew is specified and outSpatialReference is not 
	 * specified, the output geometries are in the spatial reference of the process spatial reference. See Projected 
	 * Coordinate Systems and Geographic Coordinate Systems for the list of supported spatial references.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * URL to the ArcGIS Server REST resource that represents a locator service
	 * 
	 * @return String
	 */
	public native final String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST geocode resource to find candidates for a single address specified in the address 
	 * argument. On completion, the onAddressToLocationsComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - Specify the address and optionally specify the outFields and searchExtent. The searchExtent parameter requires 
	 * a locator published with ArcGIS Server 10.1 or greater.
	 * @param callback - The function to call when the method has completed or if an error object is returned if an error occurs 
	 * on the Server during task execution
	 * @return Deferred
	 */
	public native final Deferred addressToLocations(Parameters params, AddressToLocationsCallback callback) /*-{
		this.addressToLocations(params,
			function(candidates) {
				callback.@edu.ucdavis.cstars.client.callback.AddressToLocationsCallback::onAddressToLocationsComplete(Lcom/google/gwt/core/client/JsArray;)(candidates);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.AddressToLocationsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the ArcGIS REST geocode resource to find candidates for a single address specified in the address 
	 * argument. On completion, the onAddressToLocationsComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - Specify the address and optionally specify the outFields and searchExtent. The searchExtent parameter 
	 * requires a locator published with ArcGIS Server 10.1 or greater.
	 * @return Deferred
	 */
	public native final Deferred addressToLocations(Parameters params) /*-{
		this.addressToLocations(params);
	}-*/;
	
	/**
	 * Locates an address based on a given point.
	 * 
	 * @param location - The point at which to search for the closest address. The location should be in the same spatial 
	 * reference as that of the geocode service.
	 * @param distance - The distance in meters from the given location within which a matching address should be 
	 * searched. If this parameter is not provided or an invalid value is provided, a default value of 0 meters is used.
	 * @param callback - The function to call when the method has completed or if an error object is returned if an error 
	 * occurs on the Server during task execution.
	 * @return Deferred
	 */
	public native final Deferred locationToAddress(Point location, double distance, LocationToAddressCallback callback) /*-{
		this.locationToAddress(location, distance,
			function(candidate) {
				callback.@edu.ucdavis.cstars.client.callback.LocationToAddressCallback::onLocationToAddressComplete(Ledu/ucdavis/cstars/client/tasks/AddressCandidate;)(candidate);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.LocationToAddressCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Locates an address based on a given point.
	 * 
	 * @param location - The point at which to search for the closest address. The location should be in the same spatial 
	 * reference as that of the geocode service.
	 * @param distance - The distance in meters from the given location within which a matching address should be 
	 * searched. If this parameter is not provided or an invalid value is provided, a default value of 0 meters is used.
	 * @return Deferred
	 */
	public native final Deferred locationToAddress(Point location, double distance) /*-{
		this.addressToLocations(location, distance);
	}-*/;
	
	/**
	 * Sets the well-known ID of the spatial reference of the output geometries.
	 * 
	 * @param outSpatialReference - The well-known ID of a spatial reference. 
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.setOutSpatialReference(outSpatialReference);
	}-*/;
	
	/**
	 * Add event handler for addressToLocations
	 * 
	 * @param handler - Fires when Locator.addressToLocation() has completed. 
	 */
	public final native void addAddressToLocationsHandler(AddressToLocationsHandler handler) /*-{
		$wnd.dojo.connect(this, "onAddressToLocationsComplete",
			function(addressCandidates) {
				handler.@edu.ucdavis.cstars.client.event.AddressToLocationsHandler::onAddressToLocationsComplete(Lcom/google/gwt/core/client/JsArray;)(addressCandidates);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for errors
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
	 * Add event handler for locationToAddress
	 * 
	 * @param handler - Fires when Locator.locationToAddress() has completed.
	 */
	public final native void addLocationToAddressHandler(LocationToAddressHandler handler) /*-{
		$wnd.dojo.connect(this, "onLocationToAddressComplete",
			function(addressCandidate) {
				handler.@edu.ucdavis.cstars.client.event.LocationToAddressHandler::onLocationToAddressComplete(Ledu/ucdavis/cstars/client/tasks/AddressCandidate;)(addressCandidate);
			}
		);
	}-*/;
	
	/**
	 * Class for adding sending outFields in addressToLocations()
	 */
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		/**
		 * Creates new Parameters object
		 * 
		 * @return OutFields
		 */
		public static Parameters create() {
			return JavaScriptObject.createArray().cast();
		}
		
		public final native void setAddress(Address address) /*-{
			this["address"] = address;
		}-*/;
		
		/**
		 * 
		 * @param outFields - The list of fields included in the returned result set. This list is a comma delimited 
		 * list of field names. If you specify the shape field in the list of return fields, it is ignored. For 
		 * non-intersection addresses you can specify the candidate fields as defined in the geocode service. For 
		 * intersection addresses you can specify the intersection candidate fields.
		 */
		public final void setOutFields(String[] outFields) {
			_setOutFields(Util.stringArrayToJSO(outFields));
		};
		
		private final native void _setOutFields(JavaScriptObject outFields) /*-{
			this["outFields"] = outFields;
		}-*/;
		
		/**
		 * 
		 * @param searchExtent - Defines the extent within which the geocode server will search. Requires ArcGIS 
		 * Server version 10.1 or greater.
		 */
		public final native void setSearchExtent(Extent searchExtent) /*-{
			this["searchExtent"] = searchExtent;
		}-*/;
		
	}

}
