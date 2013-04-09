package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * A layer for OGC Web Map Services (WMS). If the first layer added to the map is a WMS layer, the map will use the spatial reference of this layer. 
 * The default behavior of a WMSLayer is to execute a WMS GetCapabilities request, which requires using a proxy page. See the Using the proxy
 * page help topic for more details. An alternate approach is to pass a resourceInfo object into the constructor which does not require a
 * GetCapabilities request. Note:The WMSLayer does not support using Styled Layer Descriptor (SLD) documents.
 * 
 * Requires Package: esri.layers.WMSLayer
 * 
 * @author Justin Merz
 */
public class WMSLayer extends DynamicMapServiceLayer {
	
	protected WMSLayer() {}
	
	/**
	 * Creates a new WMSLayer object.
	 * 
	 * @param url - URL to the OGC Web Map Service.
	 * @return WMSLayer
	 */
	public static native WMSLayer create(String url) /*-{
		if( !@edu.ucdavis.cstars.client.layers.WMSLayer::assertLoaded() ) return {};
		return new $wnd.esri.layers.WMSLayer(url);
	}-*/;
	
	/**
	 * Creates a new WMSLayer object.
	 * 
	 * @param url - URL to the OGC Web Map Service.
	 * @param options - Optional parameters. 
	 * @return WMSLayer
	 */
	public static native WMSLayer create(String url, Options options) /*-{
		if( !@edu.ucdavis.cstars.client.layers.WMSLayer::assertLoaded() ) return {};
		return new $wnd.esri.layers.WMSLayer(url, options);
	}-*/;
	
	/**
	 * Check that the esri.layers.WMSLayer package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.WMSLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_WMSLAYER package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Copyright of the WMS service. This is the value of the AccessConstraints capabilities property.
	 * 
	 * @return String
	 */
	public final native String getCopyright() /*-{
		return this.copyright;
	}-*/;
	
	/**
	 * Description of the WMS service. This is the value of the Abstract capabilities property.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * Extent of the WMS service.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.extent;
	}-*/;
	
	/**
	 * The URL for the WMS GetMap call.
	 * 
	 * @return String
	 */
	public final native String getGetMapUrl() /*-{
		return this.getMapUrl;
	}-*/;
	
	/**
	 * The map image format.
	 * 
	 * @return String
	 */
	public final native String getImageFormat() /*-{
		return this.imageFormat;
	}-*/;
	
	/**
	 * List of layers in the WMS service.
	 * 
	 * @return JsArray<WMSLayerInfo>
	 */
	public final native JsArray<WMSLayerInfo> getLayerInfos() /*-{
		return this.layerInfos;
	}-*/;
	
	/**
	 * Maximum height in pixels the WMS service supports.
	 * 
	 * @return int
	 */
	public final native int getMaxHeight() /*-{
		return this.maxHeight;
	}-*/;
	
	/**
	 * Maximum width in pixels the WMS service supports.
	 * 
	 * @return int
	 */
	public final native int getMaxWidth() /*-{
		return this.maxWidth;
	}-*/;
	
	// getSpatialReference implemented by DynamicMapServiceLayer
	
	/**
	 * Title of the WMS service.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;
	
	/**
	 * Version of the WMS service. Supported versions are: 1.1.0,1.1.1 and 1.3.0.
	 * 
	 * @return String
	 */
	public final native String getVersion() /*-{
		return this.version;
	}-*/;
	
	/**
	 * Set the map image format, valid values are "png","jpg","pdf","bmp","gif" and "svg".
	 * 
	 * @param format - The image format.
	 */
	public final native void setImageFormat(String format) /*-{
		this.setImageFormat(format);
	}-*/;
	
	/**
	 * Specify whether the background image is transparent. Only valid if the WMS service supports transparency.
	 * 
	 * @param transparency - When true the background image is transparent.
	 */
	public final native void setImageTransparency(boolean transparency) /*-{
		this.setImageTransparency(transparency);
	}-*/;
	
	/**
	 * Specify a list of layer names to updates the visible layers.
	 * 
	 * @param layers - An array of layer ids.
	 */
	public final void setVisibleLayer(String[] layers) {
		_setVisibleLayers(Util.stringArrayToJSO(layers));
	}
	
	private final native void _setVisibleLayers(JavaScriptObject layers) /*-{
		this.setVisibleLayers(layers);
	}-*/;
	
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param format - Specify the map image format, valid options are png,jpg,bmp,gif,svg.
		 */
		public final native void setFormat(String format) /*-{
			this["format"] = format;
		}-*/;
		
		/**
		 * 
		 * @param resourceInfo - An optional resource info object. The default behavior of a WMSLayer is to execute a WMS GetCapabilities
		 * request, which requires using a proxy page. If resourceInfo is specified a GetCapabilities request is not executed and no proxy
		 * page is required. 
		 */
		public final native void setResourceInfo(ResourceInfo resourceInfo) /*-{
			this["resourceInfo"] = resourceInfo;
		}-*/;
		
		/**
		 * 
		 * @param transparent - If the WMS service supports transparency, specify whether the image background is transparent.
		 */
		public final native void setTransparent(boolean transparent) /*-{
			this["transparent"] = transparent;
		}-*/;
		
		/**
		 * 
		 * @param visibleLayers - A list of layer names that represent the layers to include in the exported map. By default no layers
		 * are visible. The order of layers in the list defines the order the layers will display in the map.
		 */
		public final void setVisibleLayers(String[] visibleLayers) {
			_setVisibleLayers(Util.stringArrayToJSO(visibleLayers));
		};
		
		private final native void _setVisibleLayers(JavaScriptObject array) /*-{
			this["visibleLayers"] = array;
		}-*/;
	}
	
	/**
	 * An optional resource info object. The default behavior of a WMSLayer is to execute a WMS GetCapabilities request, which requires
	 * using a proxy page. If resourceInfo is specified a GetCapabilities request is not executed and no proxy page is required.
	 */
	public static class ResourceInfo extends JavaScriptObject {
		
		protected ResourceInfo() {}
		
		public static ResourceInfo create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param extent - Extent of the WMS service. The extent must be specified in the spatial reference of the WMS service. Required.
		 */
		public final native void setExtent(Extent extent) /*-{
			this["extent"] = extent;
		}-*/;
		
		/**
		 * 
		 * @param layerInfos - An array of WMSLayerInfo, each WMSLayerInfo object must have the name property set. Required.
		 */
		public final void setLayerInfos(WMSLayerInfo[] layerInfos) {
			_setLayerInfos(Util.objectArrayToJSO(layerInfos));
		}
		
		private final native void _setLayerInfos(JavaScriptObject array) /*-{
			this["layerInfos"] = array;
		}-*/;
		
		/**
		 * 
		 * @param version - Version of the WMS service. The default value is "1.3.0". Supported versions are: "1.1.0","1.1.1" and "1.3.0". Optional.
		 */
		public final native void setVersion(String version) /*-{
			this["version"] = version;
		}-*/;
		
		/**
		 * 
		 * @param maxWidth - The maximum width, in pixels, of the WMS service. Optional.
		 */
		public final native void setMaxWidth(int maxWidth) /*-{
			this["maxWidth"] = maxWidth;
		}-*/;
		
		/**
		 * 
		 * @param maxHeight - The maximum width, in pixels, of the WMS service. Optional.
		 */
		public final native void setMaxHeight(int maxHeight) /*-{
			this["maxHeigth"] = maxHeight;
		}-*/;
		
		/**
		 * 
		 * @param getMapUrl - The URL for the GetMap request, required if the URL for GetCapabilities is different than the URL for GetMap.
		 */
		public final void setGetMapUrl(String[] getMapUrl) {
			_setGetMapUrl(Util.stringArrayToJSO(getMapUrl));
		}
		
		private final native void _setGetMapUrl(JavaScriptObject getMapUrl) /*-{
			this["getMapUrl"] = getMapUrl;
		}-*/;
		
		/**
		 * 
		 * @param title - The title of the WMS service. Optional.
		 */
		public final native void setTitle(String title) /*-{
			this["title"] = title;
		}-*/;
		
		/**
		 * 
		 * @param description - The description of the WMS service. Optional.
		 */
		public final native void setDescription(String description) /*-{
			this["description"] = description;
		}-*/;
		
		/**
		 * 
		 * @param copyright - The copyright of the WMS service. Optional.
		 */
		public final native void setCopyRight(String copyright) /*-{
			this["copyright"] = copyright;
		}-*/;
	}

}
