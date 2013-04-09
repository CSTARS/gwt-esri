package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.ClosestFacilitySolveResult;

/**
 * The function to call when the method has completed.
 * 
 * @author Justin Merz
 */
public interface ClosestFacilitySolveCompleteHandler {

	/**
	 * 
	 * @param result - The results from the ClosestFaciltyTask solve operation.
	 */
	public void onSolveComplete(ClosestFacilitySolveResult result);
	
}
