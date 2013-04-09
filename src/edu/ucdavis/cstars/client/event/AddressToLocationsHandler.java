package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.tasks.AddressCandidate;

/**
 * Fires when Locator.addressToLocation() has completed. The result is an array of AddressCandidate.
 * 
 * @author Justin Merz
 */
public interface AddressToLocationsHandler {

	/**
	 * 
	 * @param addressCandidates - Contains an array of candidates that match the given address as well as their scores.
	 */
	public void onAddressToLocationsComplete(JsArray<AddressCandidate> addressCandidates);
	
}
