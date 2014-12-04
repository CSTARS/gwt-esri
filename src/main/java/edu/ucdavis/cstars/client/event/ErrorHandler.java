package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Error;

/**
 * 
 * @author Justin Merz
 */
public interface ErrorHandler {

	/**
	 * 
	 * @param error
	 */
	public void onError(Error error);
	
}
