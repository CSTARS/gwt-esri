package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.ToolType;

/**
 * Activates the toolbar for editing geomtries. Activating the toolbar disables map navigation.
 * 
 * @author Justin Merz
 */
public interface ToolbarActivateHandler {
	
	/**
	 * 
	 * @param tool - The editing type.
	 * @param graphic - The graphic to edit whose vertices will be edited or moved.
	 */
	public void onActivate(ToolType tool, Graphic graphic);
	
}
