package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.BufferHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the buffer operation is complete.
 * 
 * @author Justin Merz
 */
public interface BufferCallback extends BufferHandler, ErrorHandler {}
