package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.QueryTaskIdsHandler;

/**
 * Fires when the query on IDs is complete.
 * 
 * @author Justin Merz
 */
public interface QueryTaskIdsCallback extends QueryTaskIdsHandler, ErrorHandler {}
