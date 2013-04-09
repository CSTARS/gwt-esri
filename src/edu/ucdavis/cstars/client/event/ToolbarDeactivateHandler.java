package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.ToolType;

/**
 * Deactivates the toolbar and reactivates map navigation.
 * 
 * @author Justin Merz
 */
public interface ToolbarDeactivateHandler {
	
	/**
	 * 
	 * @param tool - The editing type.
	 * @param graphic - The graphic the toolbar was associated with.
	 * @param isModified
	 */
	public void onDeactivate(ToolType tool, Graphic graphic, boolean isModified);

}
