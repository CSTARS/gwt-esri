package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.AddressToLocationsHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when Locator.addressToLocation() has completed. The result is an array of AddressCandidate.
 * 
 * @author Justin Merz
 */
public interface AddressToLocationsCallback extends AddressToLocationsHandler, ErrorHandler {}
