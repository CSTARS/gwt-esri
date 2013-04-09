package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.AreasAndLengthsHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the areasAndLengths operation is complete.
 * 
 * @author Justin Merz
 */
public interface AreasAndLengthsCallback extends AreasAndLengthsHandler, ErrorHandler {}
