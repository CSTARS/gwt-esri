package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired when the mouse button is clicked on the vertex of a polyline or polygon or a point in a multipoint. 
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexClickHandler {

	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - info about the vertex.
	 */
	public void onVertexClick(Graphic graphic, VertexInfo vertexInfo);
	
}
