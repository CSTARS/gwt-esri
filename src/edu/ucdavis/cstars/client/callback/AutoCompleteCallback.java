package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.AutoCompleteHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the autoComplete operation is complete.
 * 
 * @author Justin Merz
 */
public interface AutoCompleteCallback extends AutoCompleteHandler, ErrorHandler {}
