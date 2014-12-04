package edu.ucdavis.cstars.client.layers;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.GdbVersionChangeHandler;
import edu.ucdavis.cstars.client.event.MapImageExportHandler;

/**
 * Allows you to work with a dynamic map service resource exposed by the 
 * ArcGIS Server REST API. A dynamic map service generates images on the
 * fly. For cached map services, @see edu.ucdavis.cstars.client.layers.ArcGISTiledMapServiceLayer.
 *
 * If the first layer added to the map is an ArcGISDynamicMapServiceLayer,
 * the map will take on the projection of this layer. 
 * 
 * @author Justin Merz
 */
public class ArcGISDynamicMapServiceLayer extends DynamicMapServiceLayer {
	
	public static enum ImageFormat {
		PNG("png"),
		PNG8("png8"),
		PNG24("png24"),
		PNG32("png32"),
		JPG("jpg"),
		PDF("pdf"),
		BMP("bmp"),
		GIF("gif"),
		SVG("svg"),
		NOT_SET("");
		private String val = "";
		ImageFormat(String value) {
			val = value;
		}
		public String getValue() {
			return val;
		}
		public static ImageFormat get(String f) {
			for( int i = 0; i < ImageFormat.values().length; i++ ) {
				if( ImageFormat.values()[i].getValue().contentEquals(f) ) {
					return ImageFormat.values()[i];
				}
			}
			return ImageFormat.NOT_SET;
		}
	}
	
	protected ArcGISDynamicMapServiceLayer() {}
	
	/**
	 * Creates a new ArcGISDynamicMapServiceLayer object. A URL is a required
	 * parameter. 
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource that represents a map service.
	 * @return ArcGISDynamicMapServiceLayer
	 */
	public native final static ArcGISDynamicMapServiceLayer create(String uri) /*-{
		return new $wnd.esri.layers.ArcGISDynamicMapServiceLayer(uri);
	}-*/;
	
	/**
	 * Creates a new ArcGISDynamicMapServiceLayer object. A URL is a required
	 * parameter. This layer also takes some optional parameters.
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource that represents a map service.
	 * @param options - Optional parameters.
	 * @return ArcGISDynamicMapServiceLayer
	 */
	public native final static ArcGISDynamicMapServiceLayer create(String uri, Options options) /*-{
		return new $wnd.esri.layers.ArcGISDynamicMapServiceLayer(uri, options);
	}-*/;
	
	/**
	 * Capabilities of the map service, possible values are Map, Query and Data. Only available if the map service
	 * is published using ArcGIS Server version 10 or greater.
	 * 
	 * @return String
	 */
	public native final String getCapabilities() /*-{
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
	 * When true, images are always requested from the server and the browser's cache is ignored. This should
	 *  be used when the data supporting the map service changes frequently.
	 * 
	 * @return boolean
	 */
	public native final boolean isDisabledClientCaching() /*-{
		return this.disableClientCaching;
	}-*/;
	
	/**
	 * The output dpi of the dynamic map service layer.
	 * 
	 * @return int
	 */
	public native final int getDpi() /*-{
		return this.dpi;
	}-*/;
	
	/**
	 * The output image type. As of ArcGIS Server 9.3.1, the list of supported image formats is included in the 
	 * description of Map Services in Services Directory under "Supported Image Format Types". In addition, 
	 * as of ArcGIS Server 9.3.1, optimized map services can produce true PNG32 images.
	 * 
	 * @return ImageFormat
	 */
	public native final ImageFormat getImageFormat() /*-{
		return @edu.ucdavis.cstars.client.layers.ArcGISDynamicMapServiceLayer.ImageFormat::get(Ljava/lang/String;)(this.imageFormat);
	}-*/;
	
	/**
	 * Whether or not background of dynamic image is transparent.
	 * 
	 * @return boolean
	 */
	public native final boolean imageTransparency() /*-{
		return this.imageTransparency;
	}-*/;
	
	/**
	 * Sets the layer definitions used to filter the features of individual layers in the map service. Layer 
	 * definitions with semicolons or colons are supported at version 2.0 if using a map service published 
	 * using ArcGIS Server 10.0
	 * 
	 * @return JsArrayString
	 */
	public native final JsArrayString getLayerDefinitions() /*-{
		return this.layerDefinitions;
	}-*/;
	
	/**
	 * Array of LayerDrawingOptions used to override the way layers are drawn.
	 * 
	 * @return JsArray<LayerDrawingOptions>
	 */
	public native final JsArray<LayerDrawingOptions> getLayerDrawingOptions() /*-{
		return this.layerDrawingOptions;
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
	 * Returns the current layer time options if applicable. Use the setLayerTimeOptions method
	 * to modify the time options. (As of v2.0)
	 * 
	 * @return JsArray<LayerTimeOptions>
	 */
	public native final JsArray<LayerTimeOptions> getTimeLayerOptions() /*-{
		return this.layerTimeOptions;
	}-*/;
	
	/**
	 * The maximum image height , in pixels, that the map service will export. Requires ArcGIS 
	 * Server version 10.1 or greater.
	 * 
	 * @return int
	 */
	public native final int getMaxImageHeight() /*-{
		return this.maxImageHeight;
	}-*/;
	
	/**
	 * The maximum image width, in pixels, that the map service will export. Requires ArcGIS 
	 * Server version 10.1 or greater.
	 * 
	 * @return int
	 */
	public native final int getMinImageHeight() /*-{
		return this.minImageHeight;
	}-*/;
	
	/**
	 * The maximum number of results that can be returned from query, identify and find operations. 
	 * Requires ArcGIS Server version 10.1 or greater.
	 * 
	 * @return int
	 */
	public native final int getMaxRecordCount() /*-{
		return this.maxRecordCount;
	}-*/;
	
	/**
	 * Temporal information for the layer, such as time extent. If this property is null or not
	 * specified, then the layer does not support time-related operations.
	 * 
	 * @return TimeInfo
	 */
	public final native TimeInfo getTimeInfo() /*-{
		return this.timeInfo;
	}-*/;
	
	/**
	 * Default units of the layer as defined by the service. If the layer is the base map, the map is in these units.
	 * 
	 * @return String
	 */
	public native final String getUnits() /*-{
		return this.units;
	}-*/;
	
	/**
	 * When true, the image is saved to the server, and a JSON formatted response is sent to the client with the URL 
	 * location of the image. A second call is automatically made to the server to retrieve the image. This value is set 
	 * in the constructor using useMapImage. Deprecated at v2.0. Prior to v2.0 this option was used when some 
	 * export map requests exceeded the limit of 2000 characters and it configured the map to use the proxy all the 
	 * time. This is not the optimal behavior so at v2.0 the switch to use the proxy will automatically happen for long 
	 * requests.
	 * 
	 * @deprecated
	 * @return boolean
	 */
	public native final boolean useMapImage() /*-{
		return this.useMapImage;
	}-*/;
	
	/**
	 * The version of ArcGIS Server where the map service is published.
	 * 
	 * @return float
	 */
	public native final float getVersion() /*-{
		return this.version;
	}-*/;	
	
	/**
	 * Gets the visible layers of the exported map.
	 * 
	 * @return JsArrayInteger
	 */
	public native final JsArrayInteger getVisibleLayers() /*-{
		return this.visibleLayers;
	}-*/;
	
	/**
	 * Create an array of DynamicLayerInfos based on the current set of LayerInfo. (As of v2.7)
	 * 
	 * @return JsArray<DynamicLayerInfo>
	 */
	public native final JsArray<DynamicLayerInfo> createDynamicLayerInfosFromLayerInfos() /*-{
		return this.createDynamicLayerInfosFromLayerInfos();
	}-*/;
	
	/**
	 * Exports a map using values as specified by ImageParameters. On completion, MapImage is returned.
	 */
	public native final void exportMapImage() /*-{
		this.exportMapImage();
	}-*/;
	
	/**
	 * Exports a map using values as specified by ImageParameters. On completion, MapImage is returned.
	 * 
	 * @param params - Input parameters assigned before exporting the map image.
	 */
	public native final void exportMapImage(ImageParameters params) /*-{
		this.exportMapImage(params);
	}-*/;
	
	/**
	 * Exports a map using values as specified by ImageParameters. On completion, MapImage is returned.
	 * 
	 * @param params - Input parameters assigned before exporting the map image.
	 * @param handler - The function to call when the method has completed. The arguments in the function
	 * are the same as the onMapImageExport event.
	 */
	public native final void exportMapImage(ImageParameters params, MapImageExportHandler handler) /*-{
		var gwtCallback = function(mapImage) {
			handler.@edu.ucdavis.cstars.client.event.MapImageExportHandler::onMapImageExport(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
		}
		this.exportMapImage(params, gwtCallback);
	}-*/;
	
	/**
	 * Resets all layer definitions to those defined in the service.
	 */
	public native final void setDefaultLayerDefinitions() /*-{
		this.setDefaultLayerDefinitions();
	}-*/;
	
	/**
	 *  Resets all layer definitions to those defined in the service.
	 * 
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setDefaultLayerDefinitions(boolean doNotRefresh) /*-{
		this.setDefaultLayerDefinitions(doNotRefresh);
	}-*/;
	
	/**
	 * Clears the visible layers as defined in setVisibleLayers, and resets to the default layers of the map service.
	 */
	public native final void setDefaultVisibleLayers() /*-{
		this.setDefaultVisibleLayers();
	}-*/;
	
	/**
	 * Clears the visible layers as defined in setVisibleLayers, and resets to the default layers of the map service.
	 * 
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setDefaultVisibleLayers(boolean doNotRefresh) /*-{
		this.setDefaultVisibleLayers(doNotRefresh);
	}-*/;
	
	/**
	 * Sets whether images are always requested from the server and the browser's cache is ignored. This should
	 * be used when the data supporting the map service changes frequently.
	 * 
	 * @param disable - When true, client side caching is disabled.
	 */
	public native final void setDisableClientCaching(boolean disable) /*-{
		this.setDisableClientCaching(disable);
	}-*/;
	
	/**
	 * Sets the dpi of the exported map. The default value is 96.
	 * 
	 * @param dpi - DPI value.
	 */
	public native final void setDPI(int dpi) /*-{
		this.setDPI(dpi);
	}-*/;
	
	/**
	 * Sets the dpi of the exported map. The default value is 96.
	 * 
	 * @param dpi - DPI value.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setDPI(int dpi, boolean doNotRefresh) /*-{
		this.setDPI(dpi, doNotRefresh);
	}-*/;
	
	/**
	 * Specify an array of DynamicLayerInfos used to change the layer ordering or to redefine the map. (As of v2.7)
	 * 
	 * @param dynamicLayerInfos - An array of dynamic layer infos.
	 */
	public final void setDynamicLayerInfos(DynamicLayerInfo[] dynamicLayerInfos) {
		_setDynamicLayerInfos(Util.objectArrayToJSO(dynamicLayerInfos));
	}
	
	private final native void _setDynamicLayerInfos(JavaScriptObject dynamicLayerInfos) /*-{
		this.setDynamicLayerInfos(dynamicLayerInfos);
	}-*/;
	
	/**
	 * Specify an array of DynamicLayerInfos used to change the layer ordering or to redefine the map. (As of v2.7)
	 * 
	 * @param dynamicLayerInfos - An array of dynamic layer infos.
	 * @param doNotRefresh - When true the layer will not refresh the map image. The default value is false.
	 */
	public final void setDynamicLayerInfos(DynamicLayerInfo[] dynamicLayerInfos, boolean doNotRefresh) {
		_setDynamicLayerInfos(Util.objectArrayToJSO(dynamicLayerInfos), doNotRefresh);
	}
	
	private final native void _setDynamicLayerInfos(JavaScriptObject dynamicLayerInfos, boolean doNotRefresh) /*-{
		this.setDynamicLayerInfos(dynamicLayerInfos, doNotRefresh);
	}-*/;
	
	/**
	 * Set the version for the ArcGIS DynamicMapServiceLayer. Requires an ArcGIS Server service 10.1 or greater (As of v2.7)
	 * 
	 * @param gdbVersion - The name of the version to display.
	 */
	public final native void setGDBVersion(String gdbVersion) /*-{
		this.setGDBVersion(gdbVersion);
	}-*/;
	
	/**
	 * Set the version for the ArcGIS DynamicMapServiceLayer. Requires an ArcGIS Server service 10.1 or greater (As of v2.7)
	 * 
	 * @param gdbVersion - The name of the version to display.
	 * @param doNotRefresh - When true the layer will not refresh the map image. The default value is false.
	 */
	public final native void setGDBVersion(String gdbVersion, boolean doNotRefresh) /*-{
		this.setGDBVersion(gdbVersion, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the image format of the exported map.
	 * 
	 * @param imageFormat
	 */
	public native final void setImageFormat(ImageFormat imageFormat) /*-{
		this.setImageFormat(imageFormat.@edu.ucdavis.cstars.client.layers.ArcGISDynamicMapServiceLayer.ImageFormat::getValue()());
	}-*/;
	
	/**
	 * Sets the image format of the exported map.
	 * 
	 * @param imageFormat 
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setImageFormat(ImageFormat imageFormat, boolean doNotRefresh) /*-{
		this.setImageFormat(imageFormat.@edu.ucdavis.cstars.client.layers.ArcGISDynamicMapServiceLayer.ImageFormat::getValue()(), doNotRefresh);
	}-*/;
	
	/**
	 * Sets the background of a dynamic image to transparent.
	 * 
	 * @param transparent - The default is "true".
	 */
	public native final void setImageTransparency(boolean transparent) /*-{
		this.setImageTransparency(transparent);
	}-*/;
	
	/**
	 * Sets the background of a dynamic image to transparent.
	 * 
	 * @param transparent - The default is "true".
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setImageTransparency(boolean transparent, boolean doNotRefresh) /*-{
		this.setImageTransparency(transparent, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the layer definitions used to filter the features of individual layers in the map service. If the layer 
	 * definition expression is longer than approximately 2000 characters you will need to set up a proxy page. 
	 * Prior to v2.0, you also need to set useMapImage to true.
	 * 
	 * Layer definitions with semicolons or colons are supported if using a map service published using ArcGIS Server 10.
	 * 
	 * @param layerDefinitions - An array containing each layer's definition.
	 */
	public native final void setLayerDefinitions(LayerDefinitions layerDefinitions) /*-{
		this.setLayerDefinitions(layerDefinitions);
	}-*/;
	
	/**
	 * Sets the layer definitions used to filter the features of individual layers in the map service. If the layer 
	 * definition expression is longer than approximately 2000 characters you will need to set up a proxy page. 
	 * Prior to v2.0, you also need to set useMapImage to true.
	 * 
	 * Layer definitions with semicolons or colons are supported if using a map service published using ArcGIS Server 10.
	 * 
	 * @param layerDefinitions - An array containing each layer's definition.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setLayerDefinitions(LayerDefinitions layerDefinitions, boolean doNotRefresh) /*-{
		this.setLayerDefinitions(layerDefinitions, doNotRefresh);
	}-*/;
	
	/**
	 * Specify an array of LayerDrawingOptions that override the way the layers are drawn. 
	 * 
	 * @param layerDrawingOptions - An array of layer drawing options.
	 */
	public final void setLayerDrawingOptions(LayerDrawingOptions[] layerDrawingOptions) {
		_setLayerDrawingOptions(Util.objectArrayToJSO(layerDrawingOptions));
	}
	
	private final native void _setLayerDrawingOptions(JavaScriptObject layerDrawingOptions) /*-{
		this.setLayerDrawingOptions(layerDrawingOptions);
	}-*/;
	
	/**
	 * Specify an array of LayerDrawingOptions that override the way the layers are drawn. 
	 * 
	 * @param layerDrawingOptions - An array of layer drawing options.
	 * @param doNotRefresh - When true the layer will not refresh the map image. The default value is false.
	 */
	public final void setLayerDrawingOptions(LayerDrawingOptions[] layerDrawingOptions, boolean doNotRefresh) {
		_setLayerDrawingOptions(Util.objectArrayToJSO(layerDrawingOptions), doNotRefresh);
	}
	
	private final native void _setLayerDrawingOptions(JavaScriptObject layerDrawingOptions, boolean doNotRefresh) /*-{
		this.setLayerDrawingOptions(layerDrawingOptions, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the time-related options for the layer. (As of v2.0)
	 * 
	 * @param options - Array of LayerTimeOptions objects that allow you to override how a layer is exported in reference to the 
	 * map's time extent. There is one object per sub-layer.
	 */
	public final void setLayerTimeOptions(LayerTimeOptions[] options) {
		_setLayerTimeOptions(Util.objectArrayToJSO(options));
	}
	
	private native final void _setLayerTimeOptions(JavaScriptObject options) /*-{
		this.setLayerTimeOptions(options);
	}-*/;
	
	/**
	 * Sets the time-related options for the layer. (As of v2.0)
	 * 
	 * @param options - Array of LayerTimeOptions objects that allow you to override how a layer is exported in reference to the 
	 * map's time extent. There is one object per sub-layer.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public final void setLayerTimeOptions(LayerTimeOptions[] options, boolean doNotRefresh) {
		_setLayerTimeOptions(Util.objectArrayToJSO(options), doNotRefresh);
	}
	
	private native final void _setLayerTimeOptions(JavaScriptObject options, boolean doNotRefresh) /*-{
		this.setLayerTimeOptions(options);
	}-*/;
	
	/**
	 * Determine if the layer will update its content based on the map's current time extent. Default value is true. (As of v2.2)
	 * 
	 * @param update - When false the layer will not update its content based on the map's time extent. Default value is true.
	 */
	public final native void setUseMapTime(boolean update) /*-{
		this.setUseMapTime(update);
	}-*/;
	
	/**
	 * Sets the visible layers of the exported map. By default, the visible layers are as defined by the default visibility in LayerInfo.
	 * 
	 * @param ids - Array of layer IDs.
	 */
	public final void setVisibleLayers(int[] ids) {
		_setVisibleLayers(Util.intArrayToJSO(ids));
	}
	
	private native final void _setVisibleLayers(JavaScriptObject ids) /*-{
		this.setVisibleLayers(ids);
	}-*/;
	
	/**
	 * Sets the visible layers of the exported map. By default, the visible layers are as defined by the default visibility in LayerInfo.
	 * 
	 * @param ids - Array of layer IDs.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public final void setVisibleLayers(int[] ids, boolean doNotRefresh) {
		_setVisibleLayers(Util.intArrayToJSO(ids), doNotRefresh);
	}
	
	private native final void _setVisibleLayers(JavaScriptObject ids, boolean doNotRefresh) /*-{
		this.setVisibleLayers(ids, doNotRefresh);
	}-*/;
	
	/**
	 * Set gdb version change handler.
	 * 
	 * @param handler - Fired when the geodatabase version is switched. 
	 */
	public native final void addGDBChangeHandler(GdbVersionChangeHandler handler) /*-{
		$wnd.dojo.connect(this, "onGDBChange",
			function() {
				handler.@edu.ucdavis.cstars.client.event.GdbVersionChangeHandler::onGDBVersionChange()();
			}
		);
	}-*/;
	
	/**
	 * Fires when the map export is completed.
	 * 
	 * @param handler - Contains the properties of a dynamically generated map image. 
	 */
	public native final void addMapImageExportHandler(MapImageExportHandler handler) /*-{
		$wnd.dojo.connect(this, "onMapImageExport",
			function(mapImage) {
				handler.@edu.ucdavis.cstars.client.event.MapImageExportHandler::onMapImageExport(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
			}
		);
	}-*/;
	
	/**
	 * Layer Options
	 */
	public static class Options extends JavaScriptObject {
	
		protected Options() {}
		
		/**
		 * Create a new options object for ArcGISDynamicMapServiceLayer
		 * 
		 * @return Options
		 */
		public static final Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Set the gdb version.
		 * 
		 * @param gdbVersion - Specify the geodatabase version to display.
		 */
		public final native void setGdbVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
		/**
		 * Set the layer id.
		 * 
		 * @param id - Id to assign to the layer. If not assigned, esri.Map assigns value. 
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * Set the layers image parameters
		 * 
		 * @param imageParameters - Represents the image parameter options. 
		 */
		public final native void setImageParameters(ImageParameters imageParameters) /*-{
			this["imageParameters"] = imageParameters;
		}-*/;
		
		/**
		 * Set the initial opacity
		 * 
		 * @param opacity - Initial opacity or transparency of layer. Values range from 0.0 to 1.0,
		 *  where 0.0 is 100% transparent and 1.0 has no transparency. The default value is 1.0. 
		 */
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * Set if should use map image.
		 * 
		 * @deprecated
		 * @param use - By default, images are exported in MIME format, and the image is streamed
		 *  to the client. When useMapImage is set to true, the image is saved to the server, and a JSON
		 *  formatted response is sent to the client with the URL location of the image. A second call is 
		 *  automatically made to the server to retrieve the image. This methodology is required for secure 
		 *  services that go through a proxy server. In this situation, a map image cannot be streamed. 
		 *  Deprecated at v2.0. Prior to v2.0 this option was used to configure the map to use the proxy all 
		 *  the time. This is not the optimal behavior so at v2.0 the switch to use the proxy will automatically 
		 *  happen if needed.
		 */
		public final native void useMapImage(boolean use) /*-{
			this["useMapImage"] = use;
		}-*/;
		
		/**
		 * When true, the layer will update its content based on the map's time extent. The default values is true.
		 * 
		 * @param useMapTime
		 */
		public final native void useMapTime(boolean useMapTime) /*-{
			this["useMapTime"] = useMapTime;
		}-*/;
		
		/**
		 * Set if layer should be initially visible.
		 * 
		 * @param isVisible - Initial visibility of the layer. Default is true. 
		 */
		public final native void setVisible(boolean isVisible) /*-{
			this["visible"] = isVisible;
		}-*/; 
	
	}
	
	// TODO: don't think you can assign arrays like this, but just following the docs
	/**
	 * Example:
	 *  <code>
	 *  layerDefinitions.setLayerDefinition(0, "POPULATION > 5000000");
     *  layerDefinitions.setLayerDefinition(0, "AREA > 100000");
     *  dynamicMapServiceLayer.setLayerDefinitions(layerDefinitions);
     *  </code>
     * 
     * Note that the array indices 0 and 5 are valid layer IDs, and POPULATION and AREA are valid attribute fields 
     * associated with the respective layers. Definition expressions for layers that are currently not visible will be 
     * ignored by the server.
	 */
	public static class LayerDefinitions extends JavaScriptObject {
		
		protected LayerDefinitions() {}
		
		public static LayerDefinitions create() {
			return JavaScriptObject.createArray().cast();
		}
		
		/**
		 * Add layer definition for specified index
		 * 
		 * @param index - index of layer
		 * @param definition - String containing the definition
		 */
		public final native void setLayerDefinition(int index, String definition) /*-{
			this[index] = definition
		}-*/;
	};
	
}
