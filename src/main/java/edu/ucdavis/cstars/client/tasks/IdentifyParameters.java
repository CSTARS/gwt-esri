package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.layers.DynamicLayerInfo;
import edu.ucdavis.cstars.client.layers.LayerTimeOptions;

/**
 * This data object is used as the identifyParameters argument to IdentifyTask.execute method. It specifies the 
 * criteria used to identify the features.
 * 
 * @author Justin Merz
 */
public class IdentifyParameters extends JavaScriptObject {
	
	public enum LayerOption {
		NOT_SET(""),
		LAYER_OPTION_ALL("all"),
		LAYER_OPTION_TOP("top"),
		LAYER_OPTION_VISIBLE("visible");
		
		private String val = "";
		LayerOption(String value) {
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected IdentifyParameters() {}

	/**
	 * Creates a new IdentifyParameters object.
	 * 
	 * @return  IdentifyParameters
	 */
	public final static native IdentifyParameters create() /*-{
		return new $wnd.esri.tasks.IdentifyParameters();
	}-*/;
	
	/**
	 * Resolution of the current map view in dots per inch. Default value: 96
	 * 
	 * @return int
	 */
	public final native int getDpi() /*-{
		return this.dpi;
	}-*/;
	
	/**
	 * Set the dpi parameter.
	 * 
	 * @param dpi - Resolution of the current map view in dots per inch. Default value: 96
	 */
	public final native void setDpi(int dpi) /*-{
		this.dpi = dpi;
	}-*/;
	
	/**
	 * An array of DynamicLayerInfos used to change the layer ordering or redefine the map. When 
	 * set the Identify operation will perform the identify against the dynamic layers. (As of v2.7)
	 * 
	 * @return JsArray<DynamicLayerInfo>
	 */
	public final native JsArray<DynamicLayerInfo> getDynamicLayerInfos() /*-{
		return this.dynamicLayerInfos;
	}-*/;
	
	/**
	 * Set the dynamicLayerInfos parameter.
	 * 
	 * @param dynamicLayerInfos - An array of DynamicLayerInfos used to change the layer ordering 
	 * or redefine the map. When set the Identify operation will perform the identify against the 
	 * dynamic layers. (As of v2.7)
	 */
	public final void setDynamicLayerInfos(DynamicLayerInfo[] dynamicLayerInfos) {
		_setDynamicLayerInfos(Util.objectArrayToJSO(dynamicLayerInfos));
	}
	
	private final native void _setDynamicLayerInfos(JavaScriptObject dynamicLayerInfos) /*-{
		this.dynamicLayerInfos = dynamicLayerInfos;
	}-*/;
	
	/**
	 * The geometry used to select features during Identify. The type of the geometry is specified by Geometry type.
	 * The most common geometry used with Identify is a Point.
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry() /*-{
		return this.geometry;
	}-*/;
	
	/**
	 * Set the geometry parameter.
	 * 
	 * @param geometry - The geometry used to select features during Identify. The type of the geometry is specified
	 * by Geometry type. The most common geometry used with Identify is a Point.
	 */
	public final native void setGeometry(Geometry geometry) /*-{
		this.geometry = geometry;
	}-*/;
	
	/**
	 * Height of the map currently being viewed in pixels.
	 * 
	 * @return int
	 */
	public final native int getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * Set the height parameter.
	 * 
	 * @param height - Height of the map currently being viewed in pixels.
	 */
	public final native void setHeight(int height) /*-{
		this.height = height;
	}-*/;
	
	/**
	 * Array of layer definition expressions that allows you to filter the features of individual layers. Layer definitions with
	 * semicolons or colons are supported at version 2.0 if using a map service published using ArcGIS Server 10.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getLayerDefinitions() /*-{
		return this.getLayerDefinitions();
	}-*/;
	
	/**
	 * Set the layer definitions parameter.
	 * 
	 * @param layerDefinitions - Array of layer definition expressions that allows you to filter the features of individual
	 *  layers. Layer definitions with semicolons or colons are supported at version 2.0 if using a map service published
	 *  using ArcGIS Server 10.
	 */
	public final void setLayerDefinitions(String[] layerDefinitions) {
		_setLayerDefinitions(Util.stringArrayToJSO(layerDefinitions));
	}
	
	private final native void _setLayerDefinitions(JavaScriptObject layerDefinitions) /*-{
		this.layerDefinitions = layerDefinitions;
	}-*/;
	
	/**
	 * The layers to perform the identify operation on. The layers are specified as a comma-separated list of layer ids. The
	 * list of ids is returned in ArcGISMapServiceLayer layerInfos.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getLayerIds() /*-{
		return this.layerIds;
	}-*/;
	
	/**
	 * set the layerIds parameter.
	 * 
	 * @param layerIds - The layers to perform the identify operation on. The layers are specified as a comma-separated
	 * list of layer ids. The list of ids is returned in ArcGISMapServiceLayer layerInfos.
	 */
	public final void setLayerIds(int[] layerIds) {
		_setLayerIds(Util.intArrayToJSO(layerIds));
	}
	
	private final native void _setLayerIds(JavaScriptObject layerIds) /*-{
		this.layerIds = layerIds;
	}-*/;
	
	/**
	 * Specifies which layers to use when using Identify. Default value: LAYER_OPTION_TOP
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
	 * 
	 * @param layerOption - Specifies which layers to use when using Identify. Default value: LAYER_OPTION_TOP
	 */
	public final void setLayerOption(LayerOption layerOption) {
		_setLayerOption( layerOption.getValue() );
	}
	
	private final native void _setLayerOption(String layerOption) /*-{
		this.layerOption = layerOption;
	}-*/;
	
	/**
	 * Array of LayerTimeOptions objects that allow you to define time options for the specified layers. There is one object per sub-layer.
	 * 
	 * @return JsArray<LayerTimeOptions>
	 */
	public final native JsArray<LayerTimeOptions> getLayerTimeOptions() /*-{
		return this.layerTimeOptions;
	}-*/;
	
	/**
	 * Set the layerTimeOptions parameter.
	 * 
	 * @param layerTimeOptions - Array of LayerTimeOptions objects that allow you to define time options for the specified layers.
	 * There is one object per sub-layer.
	 */
	public final void setLayerTimeOptions(LayerTimeOptions[] layerTimeOptions) {
		_setLayerTimeOptions(Util.objectArrayToJSO(layerTimeOptions));
	}
	
	private final native void _setLayerTimeOptions(JavaScriptObject layerTimeOptions) /*-{
		this.layerTimeOptions = layerTimeOptions;
	}-*/;
	
	/**
	 * The Extent or bounding box of the map currently being viewed. The mapExtent property is assumed to be in the
	 * spatial reference of the map unless sr has been specified. The values for mapExtent, height, width, and dpi are
	 * used to determine the layers visible in the current extent. They are also used to calculate the search distance
	 * on the map based on the tolerance in screen pixels.
	 * 
	 * @return Extent
	 */
	public final native Extent getMapExtent() /*-{
		return this.mapExtent;
	}-*/;
	
	/**
	 * Set the mapExtent parameter.
	 * 
	 * @param mapExtent - The Extent or bounding box of the map currently being viewed. The mapExtent property is assumed to be in the
	 * spatial reference of the map unless sr has been specified. The values for mapExtent, height, width, and dpi are
	 * used to determine the layers visible in the current extent. They are also used to calculate the search distance
	 * on the map based on the tolerance in screen pixels.
	 */
	public final native void setMapExtent(Extent mapExtent) /*-{
		this.mapExtent = mapExtent;
	}-*/;
	
	/**
	 * The maximum allowable offset used for generalizing geometries returned by the identify operation. The offset is in the units of
	 * the spatialReference. If a spatialReference is not defined the spatial reference of the map is used. 
	 * 
	 * @return float
	 */
	public final native float getMaxAllowableOffset() /*-{
		return this.maxAllowableOffset;
	}-*/;
	
	/**
	 * Set the maxAllowableOffset parameter
	 * 
	 * @param maxAllowableOffset - The maximum allowable offset used for generalizing geometries returned by the
	 * identify operation. The offset is in the units of the spatialReference. If a spatialReference is not defined the
	 * spatial reference of the map is used. 
	 */
	public final native void setMaxAllowableOffset(int maxAllowableOffset) /*-{
		this.maxAllowableOffset = maxAllowableOffset;
	}-*/;
	
	/**
	 * If "true", the result set includes the geometry associated with each result. The default is "false".
	 * 
	 * @return boolean
	 */
	public final native boolean returnGeometry() /*-{
		return this.returnGeometry;
	}-*/;
	
	/**
	 * set the returnGeometry parameter.
	 * 
	 * @param returnGeometry - If "true", the result set includes the geometry associated with each result. The default is "false".
	 */
	public final native void setReturnGeometry(boolean returnGeometry) /*-{
		this.returnGeometry = returnGeometry;
	}-*/;

	/**
	 * The spatial reference of the input and output geometries as well as of the mapExtent. If the spatial reference is not specified,
	 * the geometry and the extent are assumed to be in the spatial reference of the map, and the output geometries will also be
	 * in the spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	/**
	 * Set the spatialReference parameter.
	 * 
	 * @param spatialReference - The spatial reference of the input and output geometries as well as of the mapExtent. If the spatial
	 * reference is not specified, the geometry and the extent are assumed to be in the spatial reference of the map, and the output
	 * geometries will also be in the spatial reference of the map.
	 */
	public final native void setSpatialReference(SpatialReference spatialReference) /*-{
		this.spatialReference = spatialReference;
	}-*/;
	
	/**
	 * Specify the time extent used by the identify task.
	 * 
	 * @return TimeExtent
	 */
	public final native TimeExtent getTimeExtent() /*-{
		return this.timeExtent;
	}-*/;
	
	/**
	 * Set the timeExtent parameter.
	 * 
	 * @param timeExtent - Specify the time extent used by the identify task.
	 */
	public final native void setTimeExtent(TimeExtent timeExtent) /*-{
		this.timeExtent = timeExtent;
	}-*/;
	
	/**
	 * The distance in screen pixels from the specified geometry within which the identify should be performed.
	 * 
	 * @return double 
	 */
	public final native double getTolerance() /*-{
		return this.tolerance;
	}-*/;

	/**
	 * Set the tolerance parameter.
	 * 
	 * @param tolerance - The distance in screen pixels from the specified geometry within which the identify
	 * should be performed.
	 */
	public final native void setTolerance(double tolerance) /*-{
		this.tolerance = tolerance;
	}-*/;
	
	/**
	 * Width of the map currently being viewed in pixels.
	 * 
	 * @return int
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;
	
	/**
	 * Set the width parameter.
	 * 
	 * @param width - Width of the map currently being viewed in pixels.
	 */
	public final native void setWidth(int width) /*-{
		this.width = width;
	}-*/;
	
}
