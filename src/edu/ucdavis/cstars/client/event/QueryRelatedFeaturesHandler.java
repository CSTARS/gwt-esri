package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.layers.FeatureLayer.RelatedFeatures;

/**
 * 
 * @author Justin Merz
 */
public interface QueryRelatedFeaturesHandler {

	/**
	 * Fires when queryRelatedFeatures() is complete.
	 * 
	 * @param relatedFeatures - An object that contains feature sets. Each feature set
	 * contains features, from the target layer/table, related to the source feature. 
	 */
	public void onQueryRelatedFeaturesComplete(RelatedFeatures relatedFeatures);
	
}
