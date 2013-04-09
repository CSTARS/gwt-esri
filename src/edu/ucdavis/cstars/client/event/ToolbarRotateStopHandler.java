package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.Info;

/**
 * Fires when the mouse button is released from the rotate handle to finish rotating the graphic. 
 * 
 * @author Justin Merz
 */
public interface ToolbarRotateStopHandler {
	
	/**
	 * 
	 * @param graphic - The rotated graphic.
	 * @param info - info about the rotation of the graphic
	 */
	public void onRotateStop(Graphic graphic, Info info);

}
