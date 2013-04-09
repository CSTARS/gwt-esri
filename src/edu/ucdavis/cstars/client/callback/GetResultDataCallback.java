package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GetResultDataHandler;

/**
 * Fires when the result of an asynchronous GP task execution is available.
 * 
 * @author Justin Merz
 */
public interface GetResultDataCallback extends GetResultDataHandler, ErrorHandler {}
