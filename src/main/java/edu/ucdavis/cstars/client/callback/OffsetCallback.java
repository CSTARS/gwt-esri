package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.OffsetHandler;

/**
 * Fires when the offset operation is complete.
 * 
 * @author Justin Merz
 */
public interface OffsetCallback extends OffsetHandler, ErrorHandler {}
