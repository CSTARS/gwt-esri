package edu.ucdavis.cstars.client.event;

/**
 * Fires when the difference operation is complete.
 * 
 * @author Justin Merz
 */
public interface DistanceHandler {

	/**
	 * 
	 * @param distance - The geometry defining the difference of input features.
	 */
	public void onDistanceComplete(float distance);
	
}
