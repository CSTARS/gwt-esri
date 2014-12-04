package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.CheckJobStatusHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GeoprocessorJobHandler;

/**
 * Callback handler for Geoprocessor submitJob
 * 
 * @author Justin Merz
 */
public interface SubmitJobCallback extends CheckJobStatusHandler, GeoprocessorJobHandler, ErrorHandler {}
