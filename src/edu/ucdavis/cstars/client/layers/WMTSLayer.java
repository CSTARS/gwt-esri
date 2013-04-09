package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;

/**
 * The WMTSLayer class is used to create a layer based on an OGC Web Map Tile Service layer.
 * 
 * @author Justin Merz
 */
public class WMTSLayer extends TiledMapServiceLayer { 

	protected WMTSLayer() {}
	
	/**
	 * Creates a new WMTSLayer object.
	 * 
	 * @param url - The url for the WMTS endpoint.
	 * @return WMTSLayer
	 */
	public static WMTSLayer create(String url) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(url);
	}
	
	private static native WMTSLayer _create(String url) /*-{
		return new $wnd.esri.layers.WMTSLayer(url);
	}-*/;
	
	/**
	 * Creates a new WMTSLayer object.
	 * 
	 * @param url - The url for the WMTS endpoint.
	 * @param options - optional parameters.
	 * @return WMTSLayer
	 */
	public static WMTSLayer create(String url, Options options) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(url, options);
	}
	
	private static native WMTSLayer _create(String url, Options options) /*-{
		return new $wnd.esri.layers.WMTSLayer(url, options);
	}-*/;
	
	/**
	 * Check that the esri.layers.WMSTLayer has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.WMTSLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_WMTSLAYER package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Copyright information for the service. This information is only available if specified 
	 * in the capabilities file or the resource info object.
	 * 
	 * @return String
	 */
	public final native String getCopyright() /*-{
		return this.copyright;
	}-*/;
	
	/**
	 * The description of the active layer if specified in the capabilties file or the resource info.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The tile format.
	 * 
	 * @return String
	 */
	public final native String getFormat() /*-{
		return this.format;
	}-*/;
	
	/**
	 * An array of WMTSLayerInfo objects.
	 * 
	 * @return JsArray<WMTSLayerInfo>
	 */
	public final native JsArray<WMTSLayerInfo> getLayerInfos() /*-{
		return this.layerInfos;
	}-*/;
	
	/**
	 * The service mode for the WMTS layer.
	 * 
	 * Known values: KVP | RESTful
	 * 
	 * @return String
	 */
	public final native String getServiceMode() /*-{
		return this.serviceMode;
	}-*/;
	
	// getSpatialReference implemented by TiledMapServiceLayer
	
	/**
	 * Title of the WMTS service.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;
	
	/**
	 * Version of the WMTS service.
	 * 
	 * @return String
	 */
	public final native String getVersion() /*-{
		return this.version;
	}-*/;
	
	/**
	 * Set the active layer for the WMTS service. The layer must be in the same spatial reference as the current active layer.
	 * 
	 * @param layerInfo - The WMTSLayerInfo for the layer to make active.
	 */
	public final native void setActiveLayer(WMTSLayerInfo layerInfo) /*-{
		this.setActiveLayer(layerInfo);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * 
		 * @param layerInfo - A WMTSLayerInfo object that When ResourceInfo options are not specified the map will display 
		 * the first layer in the WMTS capabilities that matches the properties specified by WMTSLayerInfo. For example, 
		 * if the WMTSLayerInfo specifies an identifier but does not specify a tileMatrixSet the first layer in the service 
		 * that has the same id will be used.
		 */
		public final native void setLayerInfo(WMTSLayerInfo layerInfo) /*-{
			this["layerInfo"] = layerInfo;
		}-*/;
		
		/**
		 * 
		 * @param resourceInfo - An optional resource info object. The default behavior of a WMTSLayer is to execute a WMTS GetCapabilities 
		 * request, which requires using a proxy page. If resourceInfo is specified a GetCapabilities request is not 
		 * executed and no proxy page is required.
		 */
		public final native void setResoureInfo(ResourceInfo resourceInfo) /*-{
			this["resourceInfo"] = resourceInfo;
		}-*/;
		
		/**
		 * 
		 * @param serviceMode - Specify the service type. Valid values are "KVP" or "RESTful". 
		 * If the specified mode does not match the service the WMTS layer will not be created. 
		 * The default value is "RESTful".
		 */
		public final native void setServiceMode(String serviceMode) /*-{
			this["serviceMode"] = serviceMode;
		}-*/;
		
	}
	
	/**
	 * An optional resource info object. The default behavior of a WMTSLayer is to execute a WMTS GetCapabilities 
	 * request, which requires using a proxy page. If resourceInfo is specified a GetCapabilities request is not 
	 * executed and no proxy page is required.
	 */
	public static class ResourceInfo extends JavaScriptObject {
		
		protected ResourceInfo() {}
		
		public static ResourceInfo create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Set the version parameter.
		 * 
		 * @param version - Version of the WMTS service.
		 */
		public final native void setVersion(String version) /*-{
			this["version"] = version;
		}-*/;
		
		/**
		 * Set the tileUrl parameter.
		 * 
		 * @param tileUrl - The URL for the get tile request, required if it differs from the WMTS service endpoint.
		 */
		public final native void setTileUrl(String tileUrl) /*-{
			this["tileUrl"] = tileUrl;
		}-*/;
		
		/**
		 * Set the layerInfos parameter.
		 * 
		 * @param layerInfos - An array of WMTSLayerInfo objects. The tileInfo, fullExtent, InitialExtent, identifier, 
		 * tileMatrixSet, format and style properties must be defined all others are optional.
		 */
		public final void setLayerInfos(WMTSLayerInfo[] layerInfos) {
			_setLayerInfos(Util.objectArrayToJSO(layerInfos));
		};
		
		private final native void _setLayerInfos(JavaScriptObject layerInfos) /*-{
			this["layerInfos"] = layerInfos;
		}-*/;
		
		/**
		 * Set the copyright parameter.
		 * 
		 * @param copyright - The copyright of the WMTS service.
		 */
		public final native void setCopyright(String copyright) /*-{
			this["copyright"] = copyright;
		}-*/;
		
	}
	
}
