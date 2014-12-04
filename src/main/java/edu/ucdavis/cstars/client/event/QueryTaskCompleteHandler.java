package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.FeatureSet;

/**
 * Fires when the query operation is complete.
 * 
 * @author Justin Merz
 */
public interface QueryTaskCompleteHandler {

	/**
	 * 
	 * @param featureSet - FeatureSet which satisfied the query.
	 */
	public void onComplete(FeatureSet featureSet);
	
}
