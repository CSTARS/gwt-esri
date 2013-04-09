package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;

/**
 * Allows you to work with a cached map service resource exposed by the ArcGIS Server REST API. A cached service accesses
 * tiles from a cache instead of dynamically rendering images. For dynamic map services, see DynamicMapServiceLayer. 
 * 
 * @author Justin Merz
 */
public class ArcGISTiledMapServiceLayer extends TiledMapServiceLayer {

	protected ArcGISTiledMapServiceLayer() {}
	
	/**
	 * Creates a new ArcGISTiledMapServiceLayer object. A URL is a required parameter.
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource at represents a map service.
	 * @return ArcGISTiledMapServiceLayer
	 */
	public native static ArcGISTiledMapServiceLayer create(String uri) /*-{
		return new $wnd.esri.layers.ArcGISTiledMapServiceLayer(uri);
	}-*/;

	/**
	 * Creates a new ArcGISTiledMapServiceLayer object. A URL is a required parameter. 
	 * This layer also takes some optional parameters.
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource at represents a map service.
	 * @param options - Optional parameters.
	 * @return - ArcGISTiledMapServiceLayer
	 */
	public native static ArcGISTiledMapServiceLayer create(String uri, Options options) /*-{
		return new $wnd.esri.layers.ArcGISTiledMapServiceLayer(uri, options);
	}-*/;
	
	/**
	 * Capabilities of the map service, possible values are Map, Query and Data. Only available
	 * if the map service is published using ArcGIS Server version 10 or greater.
	 * 
	 * @return String
	 */
	public native final String getCapabilites() /*-{
		return this.capabilities;
	}-*/;
	
	/**
	 * Copyright string as defined by the map service.
	 * 
	 * @return String
	 */
	public native final String getCopyright() /*-{
		return this.copyright;
	}-*/;

	/**
	 * Map description as defined by the map service.
	 * 
	 * @return String
	 */
	public native final String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * Returns the available layers in service and their default visibility.
	 * 
	 * @return JsArray<LayerInfo>
	 */
	public native final JsArray<LayerInfo> getLayerInfos() /*-{
		return this.layerInfos;
	}-*/;
	
	/**
	 * Temporal information for the layer, such as time extent. If this property 
	 * is null or not specified, then the layer does not support time-related operations.
	 * 
	 * @return JsArray<TimeInfo>
	 */
	public native final JsArray<TimeInfo> getTimeInfo() /*-{
		return this.timeInfo;
	}-*/;
	
	/**
	 * The maximum image height , in pixels, that the map service will export. Requires ArcGIS Server version 10.1 or greater. (As of v2.6)
	 * 
	 * @return int
	 */
	public native final int getMaxImageHeight() /*-{
		return this.maxImageHeight;
	}-*/;
	
	/**
	 * The maximum image width, in pixels, that the map service will export. Requires ArcGIS Server version 10.1 or greater. (As of v2.6)
	 * 
	 * @return int
	 */
	public native final int getMaxImageWidth() /*-{
		return this.maxImageWidth;
	}-*/;
	
	/**
	 * The maximum number of results that can be returned from query, identify and find operations. Requires ArcGIS Server version 
	 * 10.1 or greater. (As of v2.6)
	 * 
	 * @return int
	 */
	public native final int getMaxRecordCount() /*-{
		return this.maxRecordCount;
	}-*/;
	
	/**
	 * Default units of the layer as defined by the service. If the layer is the base map, the map is in these units.
	 * 
	 * @return String
	 */
	public native final String getUnits() /*-{
		return this.getUnits;
	}-*/;
	
	/**
	 * The version of ArcGIS Server where the map service is published.
	 * 
	 * @return String
	 */
	public native final double getVersion() /*-{
		return this.version;
	}-*/;
	
	/**
	 * Optional parameters for constructor
	 */
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Set a display level to draw.
		 * 
		 * @param displayLevels - levels to display
		 */
		public final void setDisplayLevels(int[] displayLevels) {
			_setDisplayLevels(Util.intArrayToJSO(displayLevels));
		}
		
		private final native void _setDisplayLevels(JavaScriptObject displayLevels) /*-{
			this["displayLevels"] = displayLevels;
		}-*/;
		
		/**
		 * Set Layer id
		 * 
		 * @param id - Id to assign to the layer. If not assigned, esri.Map assigns value. 
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * Set the initial opacity
		 * 
		 * @param opacity - Initial opacity or transparency of layer. Values range from 0.0 to 1.0,
		 * where 0.0 is 100% transparent and 1.0 has no transparency. The default value is 1.0. 
		 */
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * Add a tileServers parameter
		 * 
		 * @param tileServers - Array of REST endpoints that can be used to retrieve tile images. At 
		 * version 2.7, layers hosted on ArcGIS Online will automatically use server.arcgisonline and 
		 * services.arcgisonline.com as the tile servers.
		 */
		public final void setTileServers(String[] tileServers) {
			_setTileServers(Util.stringArrayToJSO(tileServers));
		};
		
		private final native void _setTileServers(JavaScriptObject tileServers) /*-{
			this["tileServers"] = tileServers;
		}-*/;
		
		/**
		 * Set initial visibility of layer.
		 * 
		 * @param isVisible - Initial visibility of the layer. The default value is true. 
		 */
		public final native void setVisible(boolean isVisible) /*-{
			this["visible"] = isVisible;
		}-*/; 
	
	}
	
}
