package edu.ucdavis.cstars.client.callback;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.arcgis.PortalGroup;

/**
 * 
 * @author Justin Merz
 */
public interface PortalGroupsCallback {
	public void onResponse(JsArray<PortalGroup> groups);
}
