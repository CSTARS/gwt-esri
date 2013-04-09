package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.UnionHandler;

/**
 * Fires when the union operation is complete.
 * 
 * @author Justin Merz
 */
public interface UnionCallback extends UnionHandler, ErrorHandler {}
