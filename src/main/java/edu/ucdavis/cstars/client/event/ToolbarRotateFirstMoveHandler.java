package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Fires when the user begins to drag a handle to rotate the graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarRotateFirstMoveHandler {
	
	/**
	 * 
	 * @param graphic - The rotated graphic.
	 */
	public void onRotateFirstMove(Graphic graphic);

}
