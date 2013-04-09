package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.layers.ArcGISDynamicMapServiceLayer;

/**
 * Fires when getResultImageLayer() has completed.
 * 
 * @author Justin Merz
 */
public interface GetResultImageLayerHandler {

	/**
	 * 
	 * @param layer - The layer that can be added to the map.
	 */
	public void onGetResultImageLayerComplete(ArcGISDynamicMapServiceLayer layer);
	
}
