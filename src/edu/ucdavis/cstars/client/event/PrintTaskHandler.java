package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.PrintTask.PrintResult;

/**
 * 
 * @author Justin Merz
 */
public interface PrintTaskHandler {

	/**
	 * Fired when the print job has completed.
	 * 
	 * @param result - A json object that contains the url of the printed image.
	 */
	public void onComplete(PrintResult result);
	
}
