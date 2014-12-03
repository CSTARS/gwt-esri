package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.toolbars.Edit.VertexInfo;

/**
 * Fired after a new vertex is added to a polyline or polygon or a new point is added to a multipoint.
 * 
 * @author Justin Merz
 */
public interface ToolbarVertexAddHandler {
 
	/**
	 * 
	 * @param graphic - The graphic associated with the toolbar.
	 * @param vertexInfo - information about vertices
	 */
	public void onVertexAdd(Graphic graphic, VertexInfo vertexInfo);
	
}
