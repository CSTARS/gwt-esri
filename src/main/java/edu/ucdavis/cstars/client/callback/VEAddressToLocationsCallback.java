package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.VEAddressToLocationsHandler;

/**
 * Fires when VEGeocode.addressToLocation() has completed.
 * 
 * @author Justin Merz
 */
public interface VEAddressToLocationsCallback extends VEAddressToLocationsHandler, ErrorHandler {}
