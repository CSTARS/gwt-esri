package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Fires when a graphic is clicked. Applicable only when the MOVE tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarGraphicClickHandler {

	/**
	 * 
	 * @param graphic - The clicked graphic.
	 * @param screenPoint - Location of mouse click in screen coordinates (pixels).
	 * @param mapPoint - Location of mouse click in map coordinates.
	 */
	public void onGraphicClick(Graphic graphic, Point screenPoint, Point mapPoint);
	
}
