package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.Info;

/**
 * Fires when the mouse button is released from the scale handle to finish scaling the graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarScaleStopHandler {
	
	/**
	 * 
	 * @param graphic - The scaled graphic.
	 * @param info - info about the scaled graphic.
	 */
	public void onScaleStop(Graphic graphic, Info info);

}
