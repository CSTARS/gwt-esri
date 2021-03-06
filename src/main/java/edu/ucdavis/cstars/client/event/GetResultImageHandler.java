package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.layers.MapImage;

/**
 * Fires when a map image is generated by invoking the getResultImage() method.
 * 
 * @author Justin Merz
 */
public interface GetResultImageHandler {

	/**
	 * 
	 * @param mapImage - Contains the properties of a dynamically generated map image.
	 */
	public void onGetResultImageComplete(MapImage mapImage);
	
}
