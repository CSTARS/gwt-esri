package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.SimplifyHandler;

/**
 * Fires when the simplify operation is complete.
 * 
 * @author Justin Merz
 */
public interface SimplifyCallback extends SimplifyHandler, ErrorHandler {}
