package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * The WMS layer information class defines and provides information about layers in a WMS service.
 * 
 * @author Justin Merz
 */
public class WMSLayerInfo extends JavaScriptObject {
	
	protected WMSLayerInfo() {}
	
	/**
	 * Creates a new WMSLayerInfo object.
	 * 
	 * @param name -  The layer name. The layer name must be included in the visibleLayers list.
	 * @param title - The layer title. Required.
	 * @param description - The layer description defines the value of the Abstract capabilities property.
	 * @param extent -  The layer extent.
	 * @return WMSLayerInfo
	 */
	public static native WMSLayerInfo create(String name, String title, String description, Extent extent) /*-{
		if( !@edu.ucdavis.cstars.client.layers.WMSLayerInfo::assertLoaded() ) return {};
		return new $wnd.esri.layers.WMSLayerInfo({"name":name,"title":title,"description":description,"extent":extent});
	}-*/;
	
	/**
	 * Check that the esri.layers.WMSLayer package has been loaded
	 * 
	 * @return boolean
	 */
	public static boolean assertLoaded() {
		return WMSLayer.assertLoaded();
	}
	
	/**
	 * The layer description defines the value of the Abstract capabilities property.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The layer extent.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.extent;
	}-*/;
	
	/**
	 * The layer name. The layer name must be included in the visibleLayers list.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The layer title.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;

}
