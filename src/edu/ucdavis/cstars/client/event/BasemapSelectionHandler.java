package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface BasemapSelectionHandler {

	/**
	 * Fires after the map is updated with a new basemap.
	 */
	public void onSelectionChange();
	
}
