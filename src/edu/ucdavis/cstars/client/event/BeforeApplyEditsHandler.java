package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.layers.FeatureEditResult;

/**
 * 
 * @author Justin Merz
 */
public interface BeforeApplyEditsHandler {

	/**
	 * Fires after applyEdits() has been called.
	 * 
	 * @param addResults - An array of result objects, one for each feature, indicating if it was successfully added. 
	 * If the feature was added the result object will contain the unique object ID assigned to the feature. 
	 * @param updateResults - An array of result objects, one for each feature, indicating if it was successfully updated. 
	 * @param deleteResults - An array of result objects, one for each feature, indicating if the it was successfully deleted. 
	 */
	public void onBeforeEditsComplete(
			JsArray<FeatureEditResult> addResults, 
			JsArray<FeatureEditResult> updateResults, 
			JsArray<FeatureEditResult> deleteResults);
	
}
