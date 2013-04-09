package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.QueryTaskCountHandler;

/**
 * Fires when the query for the count is complete. This event is only available for layers published using ArcGIS Server 10 SP1 or later.
 * 
 * @author Justin Merz
 */
public interface QueryTaskCountCallback extends QueryTaskCountHandler, ErrorHandler {}
