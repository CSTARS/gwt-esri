package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.IdentifyHandler;

/**
 * Fires when the identify operation is complete.
 * 
 * @author Justin Merz
 */
public interface IdentifyCallback extends IdentifyHandler, ErrorHandler {}
