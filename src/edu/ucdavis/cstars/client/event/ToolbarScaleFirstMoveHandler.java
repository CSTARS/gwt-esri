package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fires when the user begins to drag a handle to scale the graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarScaleFirstMoveHandler {

	/**
	 * 
	 * @param graphic - The scaled graphic.
	 */
	public void onScaleFirstMove(Graphic graphic);
	
}
