package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.JobInfo;

/**
 * Fires when a job status update is available.
 * 
 * @author Justin Merz
 */
public interface CheckJobStatusHandler {
	
	/**
	 * 
	 * @param status - The returned JobInfo message that includes the status along with the GPMessage.
	 */
	public void onStatusUpdate(JobInfo status);

}
