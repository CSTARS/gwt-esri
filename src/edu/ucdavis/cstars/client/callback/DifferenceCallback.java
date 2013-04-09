package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.DifferenceHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the difference operation is complete.
 * 
 * @author Justin Merz
 */
public interface DifferenceCallback extends DifferenceHandler, ErrorHandler {}
