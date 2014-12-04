package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.Info;

/**
 * Fires as a graphic is rotated. 
 * 
 * @author Justin Merz
 */
public interface ToolbarRotateHandler {

	/**
	 * 
	 * @param graphic - Fires continuously as a graphic is rotated.
	 * @param info - contains around, angle and transform information
	 */
	public void onRotate(Graphic graphic, Info info);
	
}
