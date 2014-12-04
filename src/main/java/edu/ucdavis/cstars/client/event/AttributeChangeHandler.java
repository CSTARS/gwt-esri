package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Handler for field value changes.
 * 
 * @author Justin Merz
 */
public interface AttributeChangeHandler {
	
	/**
	 * Fires when a fields value changes.
	 * 
	 * @param feature - The feature to be updated.
	 * @param fieldName - The name of the field that was modified.
	 * @param fieldValue - Value for the field that was modified.
	 */
	public void onAttributeChange(Graphic feature, String fieldName, String fieldValue);
}
