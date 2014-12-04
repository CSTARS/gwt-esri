package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.arcgis.PortalGroup;
import edu.ucdavis.cstars.client.arcgis.PortalQueryResult;

/**
 * 
 * @author Justin Merz
 */
public interface PortalQueryGroupsHandler {
	
	public void onQueryComplete(PortalQueryResult<PortalGroup> result);
	
}
