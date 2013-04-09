package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *	Fires when the page is refreshed.
 * 
 * @author Justin Merz
 */
public interface MapUnloadHandler {
	
	/**
	 * 
	 * @param map
	 */
	public void onUnload(JavaScriptObject map);
}
