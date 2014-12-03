package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Transform;

/**
 * Fired as the graphic moves.
 * 
 * @author Justin Merz
 */
public interface ToolbarGraphicMoveHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param transform - Represents the linear transformation applied to the graphic.
	 */
	public void onGraphicMove(Graphic graphic, Transform transform);
	
}
