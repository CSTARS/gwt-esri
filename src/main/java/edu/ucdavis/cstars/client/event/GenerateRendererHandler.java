package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.renderer.Renderer;

/**
 * Fired when the classification operation is complete.
 * 
 * @author Justin Merz
 */
public interface GenerateRendererHandler {

	/**
	 * 
	 * @param renderer - A renderer object that can be applied to a feature layer, graphics layer or dynamic layer.
	 */
	public void onComplete(Renderer renderer);
	
}
