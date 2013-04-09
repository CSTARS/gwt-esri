package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fires when the user begins to move a graphic. Applicable only when the MOVE tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarGraphicFirstMoveHandler {
	
	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 */
	public void onGraphicFirstMove(Graphic graphic);

}
