package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.LabelPointsHandler;

/**
 * Fires when the labelPoints operation is complete.
 * 
 * @author Justin Merz
 */
public interface LabelPointsCallback extends LabelPointsHandler, ErrorHandler {}
