package edu.ucdavis.cstars.client.event;

/**
 * Fires when a layer has finished updating its content.
 * 
 * @author Justin Merz
 */
public interface UpdateEndHandler extends ErrorHandler {
	
	public void onUpdateEnd();

}
