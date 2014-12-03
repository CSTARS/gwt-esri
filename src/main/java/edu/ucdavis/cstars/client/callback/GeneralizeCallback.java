package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GeneralizeHandler;

/**
 * Fires when the generalize operation is complete.
 * 
 * @author Justin Merz
 */
public interface GeneralizeCallback extends GeneralizeHandler, ErrorHandler  {}
