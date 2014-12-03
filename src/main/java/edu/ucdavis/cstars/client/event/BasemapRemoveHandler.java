package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.dijits.Basemap;

/**
 * 
 * @author Justin Merz
 */
public interface BasemapRemoveHandler {

	/**
	 * Fires when a basemap is removed from the BasemapGallery's list of basemaps.
	 * 
	 * @param basemap - A basemap to remove from the BasemapGallery's list of basemaps.
	 */
	public void onRemove(Basemap basemap);
	
}
