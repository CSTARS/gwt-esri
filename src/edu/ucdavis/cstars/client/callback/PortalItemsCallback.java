package edu.ucdavis.cstars.client.callback;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.arcgis.PortalItem;

/**
 * 
 * 
 * @author Justin Merz
 */
public interface PortalItemsCallback {
	public void onResponse(JsArray<PortalItem> items);
}
