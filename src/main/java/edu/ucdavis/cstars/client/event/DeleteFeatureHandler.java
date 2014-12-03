package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * 
 * @author Justin Merz
 */
public interface DeleteFeatureHandler {
	
	/**
	 * 
	 * @param feature - feature to be deleted.
	 */
	public void onDelete(Graphic feature);
}
