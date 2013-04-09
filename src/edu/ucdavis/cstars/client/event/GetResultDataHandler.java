package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.ParameterValue;

/**
 * Fires when the result of an asynchronous GP task execution is available.
 * 
 * @author Justin Merz
 */
public interface GetResultDataHandler {

	/**
	 * 
	 * @param result - Contains the result parameters and the task execution messages.
	 */
	public void onGetResultDataComplete(ParameterValue result);
	
}
