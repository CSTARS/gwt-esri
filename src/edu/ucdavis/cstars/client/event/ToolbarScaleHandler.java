package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.Info;

/**
 * Fires as the graphic is being scaled.
 * 
 * @author Justin Merz
 */
public interface ToolbarScaleHandler {

	/**
	 * 
	 * @param graphic - The scaled graphic.
	 * @param info - size info
	 */
	public void onScale(Graphic graphic, Info info);
	
}
