package edu.ucdavis.cstars.client.callback;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.arcgis.PortalFolder;

/**
 * 
 * @author Justin Merz
 */
public interface PortalFoldersCallback {
	public void onResponse(JsArray<PortalFolder> folders);
}
