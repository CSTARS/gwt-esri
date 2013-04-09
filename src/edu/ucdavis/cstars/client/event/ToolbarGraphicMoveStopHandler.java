package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Transform;

/**
 * Fired when the mouse button is released, usually after moving the graphic.
 * 
 * @author Justin Merz
 */
public interface ToolbarGraphicMoveStopHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param transform  - Represents the linear transformation applied to the graphic.
	 */
	public void onGraphicMoveEnd(Graphic graphic, Transform transform);
	
}
