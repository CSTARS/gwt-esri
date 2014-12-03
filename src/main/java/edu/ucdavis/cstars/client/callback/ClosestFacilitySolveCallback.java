package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.tasks.ClosestFacilitySolveResult;

/**
 * 
 * @author Justin Merz
 */
public interface ClosestFacilitySolveCallback extends ErrorHandler {

	/**
	 * The function to call when the method has completed.
	 * 
	 * @param result - The results from the ClosestFaciltyTask solve operation.
	 */
	public void onSolveComplete(ClosestFacilitySolveResult result);
	
}
