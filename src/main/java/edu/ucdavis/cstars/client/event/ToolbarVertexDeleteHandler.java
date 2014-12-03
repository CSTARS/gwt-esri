package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired after a vertex(polyline, polygon) or point(multipoint) is deleted. Applicable only when the EDIT_VERTICES tool is active.
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexDeleteHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - info about the vertex.
	 */
	public void onVertexDelete(Graphic graphic, VertexInfo vertexInfo);
	
}
