package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.AddressCandidate;

/**
 * Fires when Locator.locationToAddress() has completed. The result is an AddressCandidate.
 *
 * @author Justin Merz
 */
public interface LocationToAddressHandler {

	/**
	 * 
	 * @param addressCandidate - Contains a candidate that best matches the input criteria as well as its score.
	 */
	public void onLocationToAddressComplete(AddressCandidate addressCandidate);
	
}
