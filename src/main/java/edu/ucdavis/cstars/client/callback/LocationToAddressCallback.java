package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.LocationToAddressHandler;

/**
 * Fires when Locator.locationToAddress() has completed. The result is an AddressCandidate.
 * 
 * @author Justin Merz
 */
public interface LocationToAddressCallback extends LocationToAddressHandler, ErrorHandler {}
