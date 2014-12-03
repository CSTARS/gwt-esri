package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface BasemapLoadHandler {

	/**
	 * Fires when the BasemapGallery retrieves the ArcGIS.com basemaps. If showArcGISBasemaps is set to false this event is not fired.
	 */
	public void onLoad();
	
}
