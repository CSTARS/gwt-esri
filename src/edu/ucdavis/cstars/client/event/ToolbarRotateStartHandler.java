package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fires when a user clicks on the handle to begin rotating a graphic
 * 
 * @author Justin Merz
 */
public interface ToolbarRotateStartHandler {

	/**
	 * 
	 * @param graphic - The rotated graphic.
	 */
	public void onRotateStart(Graphic graphic);
	
}
