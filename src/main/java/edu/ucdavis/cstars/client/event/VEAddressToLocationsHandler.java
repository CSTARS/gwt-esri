package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.virtualearth.VEGeocodeResult;

/**
 * Fires when VEGeocode.addressToLocation() has completed.
 * 
 * @author Justin Merz
 */
public interface VEAddressToLocationsHandler {
	
	/**
	 * 
	 * @param geocodeResults - Contains an array of candidates that match the given address as well as their scores.
	 */
	public void onAddressToLocationsComplete(JsArray<VEGeocodeResult> geocodeResults);

}
