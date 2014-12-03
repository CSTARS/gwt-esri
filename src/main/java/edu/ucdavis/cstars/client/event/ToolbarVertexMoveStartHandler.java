package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired when the mouse button is pressed down on a vertex (polyline, polygon) or point (multipoint). Applicable only when the EDIT_VERTICES tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexMoveStartHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - info about the vertex.
	 */
	public void onVertexMoveStart(Graphic graphic, VertexInfo vertexInfo);
	
}
