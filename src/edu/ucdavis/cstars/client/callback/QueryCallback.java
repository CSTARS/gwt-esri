package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.tasks.FeatureSet;

public interface QueryCallback {

	public void onSuccess(FeatureSet featureSet);
	public void onFailure(Throwable caught);
	
}
