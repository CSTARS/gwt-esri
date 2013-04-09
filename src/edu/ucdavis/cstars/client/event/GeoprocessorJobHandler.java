package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.JobInfo;

/**
 * Fires when an asynchronous GP task using submitJob is complete.
 * 
 * @author Justin Merz
 */
public interface GeoprocessorJobHandler {

	/**
	 * 
	 * @param status - The returned JobInfo message that includes the status along with the GPMessage.
	 */
	public void onJobComplete(JobInfo status);
	
}
