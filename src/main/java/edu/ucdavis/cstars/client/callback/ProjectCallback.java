package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.ProjectHandler;

/**
 * Fires when the project operation is complete.
 * 
 * @author Justin Merz
 */
public interface ProjectCallback extends ProjectHandler, ErrorHandler {}
