package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.arcgis.PortalItem;
import edu.ucdavis.cstars.client.arcgis.PortalQueryResult;

/**
 * 
 * @author Justin Merz
 */
public interface PortalQueryItemsHandler {

	public void onQueryComplete(PortalQueryResult<PortalItem> result);
	
}
