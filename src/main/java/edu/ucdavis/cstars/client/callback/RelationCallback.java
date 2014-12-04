package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.RelationHandler;

/**
 * Fires when the relation operation is complete.
 * 
 * @author Justin Merz
 */
public interface RelationCallback extends RelationHandler, ErrorHandler {}
