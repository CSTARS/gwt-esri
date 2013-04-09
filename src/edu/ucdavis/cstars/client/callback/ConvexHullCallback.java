package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ConvexHullHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when the convexHull operation is complete.
 * 
 * @author Justin Merz
 */
public interface ConvexHullCallback extends ConvexHullHandler, ErrorHandler {}
