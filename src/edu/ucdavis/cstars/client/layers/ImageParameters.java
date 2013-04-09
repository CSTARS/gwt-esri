package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * Represents the image parameter options used when calling ArcGISDynamicMapServiceLayer.exportMapImage,
 * Geoprocessor.getResultImage, and Geoprocessor.getResultImageLayer. 
 * 
 * @author Justin Merz
 */
public class ImageParameters extends JavaScriptObject {
	
	public static enum LayerOption {
		NOT_SET(""),
		LAYER_OPTION_EXCLUDE("exclude"),
		LAYER_OPTION_HIDE("hide"),
		LAYER_OPTION_INCLUDE("include"),
		LAYER_OPTION_SHOW("show");
		private String val;
		private LayerOption(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected ImageParameters() {}
	
	/**
	 * Creates a new ImageParameters object. The constructor takes no parameters.
	 * 
	 * @return ImageParemeters
	 */
	public static native final ImageParameters create() /*-{
		return new $wnd.esri.layers.ImageParameters();
	}-*/;
	
	/**
	 * Extent of map to be exported.
	 * 
	 * @return Extent
	 */
	public final native Extent getBbox() /*-{
		return this.bbox;
	}-*/;
	
	/**
	 * 
	 * @param bbox -  Extent of map to be exported.
	 */
	public final native void setBbox(Extent bbox) /*-{
		this.bbox = bbox;
	}-*/;
	
	/**
	 * Dots per inch setting for an ArcGISDynamicMapServiceLayer.
	 * 
	 * @return int
	 */
	public final native int getDpi() /*-{
		return this.dpi;
	}-*/;
	
	/**
	 * 
	 * @param dpi - Dots per inch setting for an ArcGISDynamicMapServiceLayer.
	 */
	public final native void setDpi(int dpi) /*-{
		this.dpi = dpi;
	}-*/;
	
	/**
	 * Map image format.
	 * 
	 * Known values: png | png8 | png24 | jpg | pdf | bmp | gif | svg
	 * 
	 * Default value: png8 
	 * 
	 * @return String
	 */
	public final native String getFormat() /*-{
		return this.format;
	}-*/;
	
	/**
	 * 
	 * @param format - Map image format.
	 * 
	 * Known values: png | png8 | png24 | jpg | pdf | bmp | gif | svg
	 * 
	 * Default value: png8 
	 */
	public final native void setFormat(String format) /*-{
		this.format = format;
	}-*/;
	
	/**
	 * Requested image height in pixels.
	 * 
	 * @return - int
	 */
	public final native int getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * 
	 * @param height - Requested image height in pixels.
	 */
	public final native void setHeight(int height) /*-{
		this.height = height;
	}-*/;
	
	/**
	 * Spatial reference of exported map.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getImageSpatialReference() /*-{
		return this.imageSpatialReference;
	}-*/;
	
	/**
	 * 
	 * @param spatialReference - Spatial reference of exported map.
	 */
	public final native void setImageSpatialReference(SpatialReference spatialReference) /*-{
		this.imageSpatialReference = spatialReference;
	}-*/;
	
	/**
	 * Array of layer definition expressions that allows you to filter the features of individual layers in the
	 * exported map image. Layer definitions with semicolons or colons are supported if using a map service
	 * published using ArcGIS Server 10.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getLayerDefinitions() /*-{
		return this.layerDefinitions;
	}-*/;
	
	/**
	 * 
	 * @param index
	 * @param definition
	 */
	public final native void setLayerDefinition(int index, String definition) /*-{
			if( !this.layerDefinitions ) this.layerDefinitions = [];
			this.layerDefinitions[i] = definition; 
	}-*/;
	
	/**
	 * A list of layer ID's, that represent which layers to include in the exported map.
	 * Use in combination with layerOption to specify how layer visiblity is handled.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getLayerIds() /*-{
		return this.layerIds;
	}-*/;
	
	/**
	 * Set the layerIds parameter.
	 * 
	 * @param ids - A list of layer ID's, that represent which layers to include in the exported map.
	 * Use in combination with layerOption to specify how layer visiblity is handled.
	 */
	public final void setLayerIds(int[] ids) {
		_setLayerIds(Util.intArrayToJSO(ids));
	};
	
	private final native void _setLayerIds(JavaScriptObject ids) /*-{
		this.layerIds = ids;
	}-*/;
	
	/**
	 * 
	 * @param layerOption - The option for displaying or hiding the layer. 
	 */
	public final void setLayerOption(LayerOption layerOption) {
		_setLayerOption(layerOption.getValue());
	}
	
	private final native void _setLayerOption(String layerOption) /*-{
		this.layerOption = layerOption;
	}-*/; 
	
	/**
	 * The option for displaying or hiding the layer.
	 * 
	 * @return LayerOption
	 */
	public final LayerOption getLayerOption() {
		String lo = _getLayerOption();
		for( int i = 0 ; i < LayerOption.values().length; i++ ){
			if( LayerOption.values()[i].getValue().contentEquals(lo) )
				return LayerOption.values()[i];
		}
		return LayerOption.NOT_SET;
	}
	
	private final native String _getLayerOption() /*-{
		return this.layerOption;
	}-*/;
	
	/**
	 * Array of LayerTimeOptions objects that allow you to override how a layer is exported in reference to
	 * the map's time extent. There is one object per sub-layer.
	 * 
	 * @return JsArray<LayerTimeOptions>
	 */
	public final native JsArray<LayerTimeOptions> getLayerTimeOptions() /*-{
		return this.layerTimeOptions;
	}-*/;
	
	/**
	 * 
	 * @param index
	 * @param option - Array of LayerTimeOptions objects that allow you to override how a layer is exported in reference
	 * to the map's time extent. There is one object per sub-layer.
	 */
	public final native void addLayerTimeOptions(int index, LayerTimeOptions option) /*-{
		if( !this.layerTimeOptions ) this.layerTimeOptions = [];
		this.layerTimeOptions[index] = options;
	}-*/;
	
	/**
	 * Clear the layerTImeOptions array.
	 */
	public final native void clearLayerTimeOptions() /*-{
		this.layerTimeOptions = [];
	}-*/;
	
	/**
	 * The time extent for the map image.
	 * 
	 * @return TimeExtent
	 */
	public final native TimeExtent getTimeExtent() /*-{
		return this.timeExtent;
	}-*/;

	/**
	 * 
	 * @param timeExtent - The time extent for the map image.
	 */
	public final native void setTimeExtent(TimeExtent timeExtent) /*-{
		this.timeExtent = timeExtent;
	}-*/;
	
	/**
	 * Whether or not background of dynamic image is transparent.
	 * 
	 * @return boolean
	 */
	public final native boolean isTransparent() /*-{
		return this.transparent;
	}-*/;
	
	/**
	 * 
	 * @param transparent - Whether or not background of dynamic image is transparent.
	 */
	public final native void setTransparent(boolean transparent) /*-{
		this.transparent = transparent;
	}-*/;
	
	/**
	 * Requested image width in pixels.
	 * 
	 * @return int 
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;

	/**
	 * 
	 * @param width - Requested image width in pixels.
	 */
	public final native void setWidth(int width) /*-{
		this.width = width;
	}-*/;
	
}
