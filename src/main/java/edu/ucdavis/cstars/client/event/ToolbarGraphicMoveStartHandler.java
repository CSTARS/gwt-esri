package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fired when the mouse button is pressed down on the graphic, usually while moving a graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarGraphicMoveStartHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 */
	public void onGraphicMoveStart(Graphic graphic);
	
}
