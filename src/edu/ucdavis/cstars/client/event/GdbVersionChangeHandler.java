package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface GdbVersionChangeHandler {

	/**
	 * Fired when the geodatabase version is switched.
	 */
	public void onGDBVersionChange();
	
}
