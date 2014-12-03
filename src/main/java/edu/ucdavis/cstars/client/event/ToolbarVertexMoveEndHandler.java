package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Transform;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired when the mouse button is released from a vertex (polyline, polygon) or point(multipoint). 
 * Applicable only when the EDIT_VERTICES tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexMoveEndHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - info about the vertex.
	 * @param transform - Represents the linear transformation applied to the graphic.
	 */
	public void onVertexMoveEnd(Graphic graphic, VertexInfo vertexInfo, Transform transform);
	
}
