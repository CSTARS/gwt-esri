package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.MapImageExportHandler;

/**
 * Allows you to work with an image map service resource exposed by the ArcGIS Server REST API.
 * 
 * @author Justin Merz
 */
public class ArcGISImageServiceLayer extends DynamicMapServiceLayer {
	
	protected ArcGISImageServiceLayer() {}
	
	/**
	 * Creates a new ArcGISImageServiceLayer object. A URL is a required parameter. This layer also takes some optional parameters.
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource that represents a map service.
	 * @param options - Optional parameters.
	 * @return ArcGISImageServiceLayer
	 */
	public native static ArcGISImageServiceLayer create(String uri, Options options) /*-{
		return new $wnd.esri.layers.ArcGISImageServiceLayer(uri, options);
	}-*/;

	/**
	 * Creates a new ArcGISImageServiceLayer object. A URL is a required parameter.
	 * 
	 * @param uri - URL to the ArcGIS Server REST resource that represents a map service.
	 * @return ArcGISImageServiceLayer
	 */
	public native static ArcGISImageServiceLayer create(String uri) /*-{
		return new $wnd.esri.layers.ArcGISImageServiceLayer(uri);
	}-*/;

	/**
	 * Number of bands in ArcGISImageServiceLayer.
	 * 
	 * @return int
	 */
	public native final double getBandCount() /*-{
		return this.bandCount;
	}-*/;
	
	/**
	 * Array of current band selections.
	 * 
	 * @return JsArrayNumber
	 */
	public native final JsArrayNumber getBandIds() /*-{
		return this.bandIds;
	}-*/;
	
	/**
	 * The raster bands that the raster dataset is composed of and their 
	 * statistics. The length of this array gives the number of bands and 
	 * the array index represents the band ID.
	 * 
	 * @return JsArray<Band>
	 */
	public native final JsArray<Band> getBands() /*-{
		return this.bands;
	}-*/;
	
	/**
	 * Current compression quality value. The compression quality controls how much 
	 * loss the image will be subjected to. Only valid with JPG image types.
	 * 
	 * @return float
	 */
	public native final double getCompressionQuality() /*-{
		return this.compressionQuality;
	}-*/;
	
	/**
	 * Copyright string as defined by the image service.
	 * 
	 * @return String
	 */
	public native final String getCopyrightText() /*-{
		return this.copyrightText;
	}-*/;
	
	/**
	 * Copyright string as defined by the image service.
	 * 
	 * @return String
	 */
	public native final String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * When true, images are always requested from the server and the browser's cache is 
	 * ignored. This should be used when the data supporting the map service changes frequently.
	 * 
	 * @return boolean
	 */
	public native final boolean isDisabledClientCaching() /*-{
		return this.disableClientCaching;
	}-*/;

	/**
	 * The output image type.
	 * 
	 * Known values: png8 | png24 | jpg | bmp | gif
	 * 
	 * Default value: png8 
	 * 
	 * @return String
	 */
	public native final String getFormat() /*-{
		return this.format;
	}-*/;

	/**
	 * Current interpolation method. The interpolation method affects how the raster dataset is 
	 * transformed when it undergoes warping or when it changes coordinate space.
	 * 
	 * @return String
	 */
	public native final String getInterpolation() /*-{
		return this.interpolation;
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
	 * Specifies the mosaic rule when defining how individual images should be mosaicked.
	 * 
	 * @return MosaicRule
	 */
	public native final MosaicRule getMosaicRule () /*-{
		return this.mosaicRule;
	}-*/;
	
	/**
	 * Size of pixel in X direction.
	 * 
	 * @return float
	 */
	public native final float getPixelSizeX() /*-{
		return this.pixelSizeX;
	}-*/;
	
	/**
	 * Size of pixel in Y direction.
	 * 
	 * @return float
	 */
	public native final float getPixelSizeY() /*-{
		return this.pixelSizeY;
	}-*/;
	
	// TODO: test this.  Docs says int's, but example return values seem to be strings
	/**
	 * The pixel type of the image service. Pertains to the type of values stored in the raster, such as signed integer, 
	 * unsigned integer, or floating point. Integers are whole numbers, whereas floating points have decimals.
	 * 
	 * Known values: C64 | C128 | F32 | F64 | S8 | S16 | S32 | U1 | U2 | U4 | U8 | U16 | U32 | UNKNOWN 
	 * 
	 * @return String
	 */
	public native final String getPixelType() /*-{
		return this.pixelType;
	}-*/;
	
	/**
	 * Specifies the rendering rule for how the requested image should be rendered. View the Raster Functions help topic 
	 * in the REST help for more details.
	 * 
	 * @return int
	 */
	public native final RasterFunction getRenderingRule() /*-{
		return this.renderingRule;
	}-*/;
	
	/**
	 * Temporal information for the layer, such as time extent. If this property is null or not specified, then the layer 
	 * does not support time-related operations.
	 * 
	 * @return TimeInfo
	 */
	public native final TimeInfo getTimeInfo() /*-{
		return this.timeInfo;
	}-*/;
	
	/**
	 * The version of ArcGIS Server the image service is published to, e.g. 9.3, 9.31, 10.
	 * 
	 * @return double
	 */
	public native final double getVersion() /*-{
		return this.version;
	}-*/;
	
	/**
	 *  Exports a map using values as specified by ImageServiceParameters. On completion, MapImage is returned.
	 */
	public native final void exportMapImage() /*-{
			this.exportMapImage();
	}-*/;

	/**
	 * Exports a map using values as specified by ImageServiceParameters. On completion, MapImage is returned.
	 * 
	 * @param handler - The function to call when the method has completed. The arguments in the function are 
	 * the same as the onMapImageExport event.
	 */
	public native final void exportMapImage(MapImageExportHandler handler) /*-{
		this.exportMapImage(function(mapImage) {
			handler.@edu.ucdavis.cstars.client.event.MapImageExportHandler::onMapImageExport(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
		});
	}-*/;
	
	/**
	 * Exports a map using values as specified by ImageServiceParameters. On completion, MapImage is returned.
	 * 
	 * @param params - Input parameters assigned before exporting the map image.
	 */
	public native final void exportMapImage(ImageServiceParameters params) /*-{
		this.exportMapImage(params);
	}-*/;
	
	/**
	 * Exports a map using values as specified by ImageServiceParameters. On completion, MapImage is returned.
	 * 
	 * @param params - Input parameters assigned before exporting the map image.
	 * @param handler - The function to call when the method has completed. The arguments in the function are 
	 * the same as the onMapImageExport event.
	 */
	public native final void exportMapImage(ImageServiceParameters params, MapImageExportHandler handler) /*-{
		this.exportMapImage(params, function(mapImage) {
			handler.@edu.ucdavis.cstars.client.event.MapImageExportHandler::onMapImageExport(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
		});
	}-*/;
	
	/**
	 * Sets the R,G,B of the exported image to the appropriate ImageService Band ID. BandIds are zero based.
	 * 
	 * @param bandIds - Array of band IDs to use in the exported image.
	 */
	public final void setBandIs(int[] bandIds) {
		_setBandIds(Util.intArrayToJSO(bandIds));
	}
	
	private native final void _setBandIds(JavaScriptObject bandIds) /*-{
		this.setBandIds(bandIds);
	}-*/;
	
	/**
	 * Sets the R,G,B of the exported image to the appropriate ImageService Band ID. BandIds are zero based.
	 * 
	 * @param bandIds - Array of band IDs to use in the exported image.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public final void setBandIs(int[] bandIds, boolean doNotRefresh) {
		_setBandIds(Util.intArrayToJSO(bandIds), doNotRefresh);
	}
	
	private native final void _setBandIds(JavaScriptObject bandIds, boolean doNotRefresh) /*-{
		this.setBandIds(bandIds, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the compression quality of the exported image. Only valid with JPG image format.
	 * 
	 * @param quality - Sets the compression quality of the exported image. Only valid with JPG image format.
	 */
	public native final void setCompressionQuality(float quality) /*-{
		this.setCompressionQuality(quality);
	}-*/;
	
	/**
	 * Sets the compression quality of the exported image. Only valid with JPG image format.
	 * 
	 * @param quality - Sets the compression quality of the exported image. Only valid with JPG image format.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setCompressionQuality(float quality, boolean doNotRefresh) /*-{
		this.setCompressionQuality(quality);
	}-*/;
	
	/**
	 * Sets whether images are always requested from the server and the browser's cache is ignored. This should
	 *  be used when the data supporting the map service changes frequently.
	 * 
	 * @param disable - When true, browser client side caching is disabled.
	 */
	public native final void setDisableClientCaching(boolean disable) /*-{
		this.setDisableClientCaching(disable);
	}-*/;
	
	/**
	 * Set the image format.
	 * 
	 * @param imageFormat - Valid values are png | png8 | png24 | jpg | pdf | bmp | gif | svg.
	 */
	public native final void setImageFormat(String imageFormat) /*-{
		this.setImageFormat(imageFormat);
	}-*/;
	
	/**
	 * Set the image format.
	 * 
	 * @param imageFormat - Valid values are png | png8 | png24 | jpg | pdf | bmp | gif | svg.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setImageFormat(String imageFormat, boolean doNotRefresh) /*-{
		this.setImageFormat(imageFormat, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the interpolation method. The interpolation method affects how the raster dataset is transformed
	 *  when it undergoes warping or when it changes coordinate space.
	 *  
	 *  @param interpolation - Interpolation value defined in ImageServiceParameters Constants Table.
	 */
	public native final void setInterpolation(String interpolation) /*-{
		this.setInterpolation(interpolation);
	}-*/;
	
	/**
	 * Sets the interpolation method. The interpolation method affects how the raster dataset is transformed
	 *  when it undergoes warping or when it changes coordinate space.
	 *  
	 *  @param interpolation - Interpolation value defined in ImageServiceParameters Constants Table.
	 *  @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setInterpolation(String interpolation, boolean doNotRefresh) /*-{
		this.setInterpolation(interpolation, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the mosaic rule of the layer to the specified value. The mosaic rule defines how individual images 
	 * should be mosaicked. Refreshes the layer to reflect the mosaic rule.
	 * 
	 * @param mosaicRule - The mosaic rule.
	 */
	public native final void setMosaicRule(MosaicRule mosaicRule) /*-{
		this.setMosaicRule(mosaicRule);
	}-*/;
	
	/**
	 * Sets the mosaic rule of the layer to the specified value. The mosaic rule defines how individual images 
	 * should be mosaicked. Refreshes the layer to reflect the mosaic rule.
	 * 
	 * @param mosaicRule - The mosaic rule.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setMosaicRule(MosaicRule mosaicRule, boolean doNotRefresh) /*-{
		this.setMosaicRule(mosaicRule, doNotRefresh);
	}-*/;
	
	/**
	 * Sets the rendering rule of the layer to the given value. Refreshes the laeyr to reflect the rendering rule.
	 * 
	 * @param renderingRule - The new rendering rule.
	 */
	public native final void setRenderingRule(RasterFunction renderingRule) /*-{
		this.setRenderingRule(renderingRule);
	}-*/;
	
	/**
	 * Sets the rendering rule of the layer to the given value. Refreshes the laeyr to reflect the rendering rule.
	 * 
	 * @param renderingRule - The new rendering rule.
	 * @param doNotRefresh - Added at version 2.2 When true the layer will not refresh the map image. The default value is false.
	 */
	public native final void setRenderingRule(RasterFunction renderingRule, boolean doNotRefresh) /*-{
		this.setRenderingRule(renderingRule, doNotRefresh);
	}-*/;
	
	/**
	 * Determine if the layer will update its content based on the map's current time extent. Default value is true. (As of v2.2)
	 * 
	 * @param update - When false the layer will not update its content based on the map's time extent. Default value is true.
	 */
	public native final void setUseMapTime(boolean update) /*-{
		this.setUseMapTime(update);
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
	 * Constructor options for the ArcGISImageServiceLayer
	 */
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		/**
		 * Create new Options class for ArcGISImageServiceLayer
		 * 
		 * @return Options
		 */
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Set id for layer
		 * 
		 * @param id - Id to assign to the layer. If not assigned, esri.Map assigns value. 
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * Set ImageServiceParameters for layer 
		 * 
		 * @param imageServiceParameters - The image service parameter options used when exporting an Image Service layer. 
		 */
		public final native void setImageServiceParameters(ImageServiceParameters imageServiceParameters) /*-{
			this["imageServiceParameters"] = imageServiceParameters;
		}-*/;
		
		/**
		 * Set opacity for layer
		 * 
		 * @param opacity - Initial opacity or transparency of layer. Values range from 0.0 to 1.0, where 0.0 is 100% transparent and
		 * 1.0 has no transparency. The default value is 1.0. 
		 */
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * Set the useMapTime parameter.
		 * 
		 * @param useMapTime - When true, the layer will update its content based on the map's time extent. The default values is true.
		 */
		public final native void useMapTime(boolean useMapTime) /*-{
			this["useMapTime"] = useMapTime;
		}-*/;
		
		/**
		 * Set visible
		 * 
		 * @param isVisible - Initial visibility of the layer. Default is true.
		 */
		public final native void setVisible(boolean isVisible) /*-{
			this["visible"] = isVisible;
		}-*/; 
	
	}
	
}
