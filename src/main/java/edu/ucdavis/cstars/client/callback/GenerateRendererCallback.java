package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GenerateRendererHandler;

/**
 * This function will be called when the operation is complete.
 * 
 * @author Justin Merz
 */
public interface GenerateRendererCallback extends GenerateRendererHandler, ErrorHandler {}
