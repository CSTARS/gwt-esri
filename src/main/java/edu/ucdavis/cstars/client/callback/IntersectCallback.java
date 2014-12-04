package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.IntersectHandler;

/**
 * Fires when the intersect operation is complete.
 * 
 * @author Justin Merz
 */
public interface IntersectCallback extends IntersectHandler, ErrorHandler {}

