package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.IdentityManagerBase.RedirectionInfo;

/**
 * 
 * @author Justin Merz
 */
public interface RedirectionHandler {

	public void onRedirection(RedirectionInfo info);
	
}
