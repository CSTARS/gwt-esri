package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.FindTaskCompleteHandler;

/**
 * Fires when the find operation is complete.
 * 
 * @author Justin Merz
 */
public interface FindTaskCallback extends ErrorHandler, FindTaskCompleteHandler {}
