package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ApplyEditsHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires after applyEdits() has been called.
 * 
 * @author Justin Merz
 */
public interface ApplyEditsCallback extends ErrorHandler, ApplyEditsHandler {}
