package edu.ucdavis.cstars.client.event;

/**
 *  Fires when a layer begins to update its content. It is the responsibility of the subclass to determine when this event is fired.
 * 
 * @author Justin Merz
 */
public interface UpdateStartHandler {
	
	public void onUpdateStart();
}
