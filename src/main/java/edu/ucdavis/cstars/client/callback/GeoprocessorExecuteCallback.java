package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GeoprocessorExecuteHandler;

/**
 * Fires when a synchronous GP task is completed.
 * 
 * @author Justin Merz
 */
public interface GeoprocessorExecuteCallback extends GeoprocessorExecuteHandler, ErrorHandler {}
