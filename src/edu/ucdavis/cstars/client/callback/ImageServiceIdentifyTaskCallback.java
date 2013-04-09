package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.ImageServiceIdentifyTaskCompleteHandler;

/**
 * Fires when execute() is complete.
 * 
 * @author Justin Merz
 */
public interface ImageServiceIdentifyTaskCallback extends ErrorHandler,  ImageServiceIdentifyTaskCompleteHandler {}
