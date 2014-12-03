package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GetResultImageLayerHandler;

/**
 * Fires when getResultImageLayer() has completed.
 * 
 * @author Justin Merz
 */
public interface GetResultImageLayerCallback extends GetResultImageLayerHandler, ErrorHandler {}
