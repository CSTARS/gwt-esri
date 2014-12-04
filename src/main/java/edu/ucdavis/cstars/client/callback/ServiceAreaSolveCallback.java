package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.ServiceAreaSolveHandler;

/**
 * Fired when the ServiceAreaTask solve is complete.
 * 
 * @author Justin Merz
 */
public interface ServiceAreaSolveCallback extends ServiceAreaSolveHandler, ErrorHandler {}
