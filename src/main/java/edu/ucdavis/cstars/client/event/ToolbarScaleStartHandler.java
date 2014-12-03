package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fires when a user clicks on the handle to scale or resize a graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarScaleStartHandler {
	
	/**
	 * 
	 * @param graphic - The scaled graphic.
	 */
	public void onScaleStart(Graphic graphic);

}
