package edu.ucdavis.cstars.client.event;

/**
 * Fires when the query for the count is complete. This event is only available
 * for layers published using ArcGIS Server 10 SP1 or later.
 * 
 * @author Justin Merz
 */
public interface QueryTaskCountHandler {

	/**
	 * 
	 * @param count - The number of features that satisfy the input query.
	 */
	public void onExecuteForCountComplete(int count);
	
}
