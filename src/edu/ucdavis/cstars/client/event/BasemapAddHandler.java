package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.dijits.Basemap;

/**
 * 
 * @author Justin Merz
 */
public interface BasemapAddHandler {

	/**
	 * Fires when a basemap is added to the BasemapGallery's list of basemaps.
	 * 
	 * @param basemap - A basemap to add to the BasemapGallery's list of basemaps. 
	 */
	public void onAdd(Basemap basemap);
	
}
