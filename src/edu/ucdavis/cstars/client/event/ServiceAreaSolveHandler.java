package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.ServiceAreaSolveResult;

/**
 * Fired when the ServiceAreaTask solve is complete.
 * 
 * @author Justin Merz
 */
public interface ServiceAreaSolveHandler {
	
	/**
	 * 
	 * @param serviceAreaSolveResult - The results from the ServiceAreaTask solve operation.
	 */
	public void onSolveComplete(ServiceAreaSolveResult serviceAreaSolveResult);

}
