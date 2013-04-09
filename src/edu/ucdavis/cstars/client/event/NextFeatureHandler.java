package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * 
 * @author Justin Merz
 */
public interface NextFeatureHandler {

	/**
	 * 
	 * @param feature - Current feature displayed in the attribute inspector.
	 */
	public void onNext(Graphic feature);
	
}
