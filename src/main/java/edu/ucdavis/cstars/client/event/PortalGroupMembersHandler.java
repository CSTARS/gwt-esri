package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.arcgis.PortalGroupMembers;

/**
 * 
 * @author Justin Merz
 */
public interface PortalGroupMembersHandler {

	public void onMembersReturn(PortalGroupMembers members);
	
}
