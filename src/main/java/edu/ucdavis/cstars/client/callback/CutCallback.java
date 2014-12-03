package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.CutHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the cut operation is complete.
 * 
 * @author Justin Merz
 */
public interface CutCallback extends CutHandler, ErrorHandler {}
