package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.DistanceHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the distance operation is complete.
 * 
 * @author Justin Merz
 */
public interface DistanceCallback extends DistanceHandler, ErrorHandler {}
