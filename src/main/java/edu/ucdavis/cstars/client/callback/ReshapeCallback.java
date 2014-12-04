package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.ReshapeHandler;

/**
 * Fires when the reshape operation is complete.
 * 
 * @author Justin Merz
 */
public interface ReshapeCallback extends ReshapeHandler, ErrorHandler {}
