package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Error;
import edu.ucdavis.cstars.client.layers.Layer;

/**
 * Fires after specified layer has been added to the map. 
 * 
 * @author Justin Merz
 */
public interface MapLayerAddResultHandler {

	/**
	 * 
	 * @param layer - The layer added to the map.
	 * @param error - available when an error occurs during the update.
	 */
	public void onLayerAddResult(Layer layer, Error error);
	
}
