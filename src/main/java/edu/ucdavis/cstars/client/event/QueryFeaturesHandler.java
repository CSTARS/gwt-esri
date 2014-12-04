package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.tasks.FeatureSet;

/**
 * 
 * @author Justin Merz
 */
public interface QueryFeaturesHandler {
	
	/**
	 * Fires when queryFeatures() is complete.
	 * 
	 * @param featureSet - The FeatureSet returned from the query. 
	 */
	public void onQueryFeaturesComplete(FeatureSet featureSet);
	
}
