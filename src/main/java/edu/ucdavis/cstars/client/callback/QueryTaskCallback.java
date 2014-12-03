package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.QueryTaskCompleteHandler;

/**
 * Fires when the query operation is complete.
 * 
 * @author Justin Merz
 */
public interface QueryTaskCallback extends QueryTaskCompleteHandler, ErrorHandler {}
