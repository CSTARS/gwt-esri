package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.LengthsHandler;

/**
 * Fires when the lengths operation is complete.
 * 
 * @author Justin Merz
 */
public interface LengthsCallback extends LengthsHandler, ErrorHandler {}
