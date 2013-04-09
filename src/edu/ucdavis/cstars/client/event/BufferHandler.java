package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Fires when the buffer operation is complete.
 * 
 * @author Justin Merz
 */
public interface BufferHandler {

	/**
	 * 
	 * @param geometries - The geometry representing the buffer.
	 */
	public void onBufferComplete(JsArray<Geometry> geometries);
	
}
