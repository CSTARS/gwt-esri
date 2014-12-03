package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired when the user begins to move the vertex of a polyline or polygon or a point of a multipoint. Applicable only when the EDIT_VERTICES tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexFirstMoveHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - info about the vertex.
	 */
	public void onVertexFirstMove(Graphic graphic, VertexInfo vertexInfo);
	
}
