package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.TrimExtendHandler;

/**
 * Fires when the trimExtend operation is complete.
 * 
 * @author Justin Merz
 */
public interface TrimExtendCallback extends TrimExtendHandler, ErrorHandler {}
