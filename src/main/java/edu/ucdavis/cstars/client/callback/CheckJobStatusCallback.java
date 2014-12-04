package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.CheckJobStatusHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when a job status update is available.
 * 
 * @author Justin Merz
 */
public interface CheckJobStatusCallback extends CheckJobStatusHandler, ErrorHandler {}
