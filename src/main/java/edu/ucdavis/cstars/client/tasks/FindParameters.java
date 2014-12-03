package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.layers.DynamicLayerInfo;

/**
 * This data object is used as the findParameters argument to FindTask.execute method. It specifies the search criteria for a find operation.
 * 
 * @author Justin Merz
 */
public class FindParameters extends JavaScriptObject {
	
	protected FindParameters() {}
	
	/**
	 * Creates a new FindParameters object.
	 * 
	 * @return FindParameters
	 */
	public static native FindParameters create() /*-{
		return new $wnd.esri.tasks.FindParameters();
	}-*/;
	
	/**
	 * The contains parameter determines whether to look for an exact match of the search text or not. If true, searches for a value that
	 * contains the searchText provided. This is a case-insensitive search. If false, searches for an exact match of the searchText string.
	 * The exact match is case-sensitive.
	 * 
	 * @return boolean
	 */
	public final native boolean contains() /*-{
		return this.contains;
	}-*/;
	
	/**
	 * Set the contains parameter.
	 * 
	 * @param contains - The contains parameter determines whether to look for an exact match of the search text or not. If true,
	 * searches for a value that contains the searchText provided. This is a case-insensitive search. If false, searches for an exact
	 * match of the searchText string. The exact match is case-sensitive.
	 */
	public final native void setContains(boolean contains) /*-{
		this.contains = contains;
	}-*/;
	
	/**
	 * An array of DynamicLayerInfos used to change the layer ordering or redefine the map. When set the find operation will perform 
	 * the find against the dynamic layers. (As of v2.7)
	 * 
	 * @return JsArray<DynamicLayerInfo>
	 */
	public final native JsArray<DynamicLayerInfo> getDynamicLayerInfos() /*-{
		return this.dynamicLayerInfos;
	}-*/;
	
	/**
	 * Set the dynamicLayerInfos parameter.
	 * 
	 * @param dynamicLayerInfos - An array of DynamicLayerInfos used to change the layer ordering or redefine the map. When set the 
	 * find operation will perform the find against the dynamic layers. (As of v2.7)
	 */
	public final void setDynamicLayerInfos(DynamicLayerInfo[] dynamicLayerInfos) {
		_setDynamicLayerInfos(Util.objectArrayToJSO(dynamicLayerInfos));
	}
	
	private final native void _setDynamicLayerInfos(JavaScriptObject dynamicLayerInfos) /*-{
		this.dynamicLayerInfos = dynamicLayerInfos;
	}-*/;
	
	/**
	 * Array of layer definition expressions that allows you to filter the features of individual layers. Layer definitions with semicolons
	 * or colons are supported at version 2.0 if using a map service published using ArcGIS Server 10.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getLayerDefinitions() /*-{
		return this.layerDefinitions;
	}-*/;
	
	/**
	 * Set the layer definitions parameter.
	 * 
	 * @param layerDefinitions - Array of layer definition expressions that allows you to filter the features of individual layers. Layer
	 * definitions with semicolons or colons are supported at version 2.0 if using a map service published using ArcGIS Server 10.
	 */
	public final void setLayerDefinitions(String[] layerDefinitions) {
		_setLayerDefinitions(Util.stringArrayToJSO(layerDefinitions));
	};
	
	private final native void _setLayerDefinitions(JavaScriptObject layerDefinitions) /*-{
		this.layerDefinitions = layerDefinitions;
	}-*/;
	
	/**
	 * The layers to perform the find operation on. The layers are specified as a comma-separated list of layer ids. The list of ids is
	 * returned in ArcGISMapServiceLayer layerInfos.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getLayerIds() /*-{
		return this.layerIds;
	}-*/;
	
	/**
	 * set the layer ids.
	 * 
	 * @param layerIds - The layers to perform the find operation on. The layers are specified as a comma-separated list of layer ids.
	 * The list of ids is returned in ArcGISMapServiceLayer layerInfos.
	 */
	public final void setLayerIds(int[] layerIds) {
		_setLayerIds(Util.intArrayToJSO(layerIds));
	}
	
	private final native void _setLayerIds(JavaScriptObject layerIds) /*-{
		this.layerIds = layerIds;
	}-*/;

	/**
	 * The maximum allowable offset used for generalizing geometries returned by the find operation. The offset is in the units of
	 * the spatialReference. If a spatialReference is not defined the spatial reference of the map is used. 
	 * 
	 * @return double
	 */
	public final native double getMaxAllowableOffset() /*-{
		return this.maxAllowableOffset;
	}-*/;
	
	/**
	 * set the max allowable offset parameter.
	 * 
	 * @param offset - The maximum allowable offset used for generalizing geometries returned by the find operation. The offset is
	 * in the units of the spatialReference. If a spatialReference is not defined the spatial reference of the map is used. 
	 */
	public final native void setMaxAllowableOffset(double offset) /*-{
		this.maxAllowableOffset = maxAllowableOffset;
	}-*/;
	
	/**
	 * The spatial reference of the output geometries. If outSR is not specified, the output geometries are returned in the spatial
	 * reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * set the out spatial reference parameter.
	 * 
	 * @param outSpatialReference - The spatial reference of the output geometries. If outSR is not specified, the output
	 * geometries are returned in the spatial reference of the map.
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;

	/**
	 * If "true", the result set include the geometry associated with each result. The default is "false".
	 * 
	 * @return boolean
	 */
	public final native boolean returnGeometry() /*-{
		return this.returnGeometry;
	}-*/;
	
	/**
	 * set the return geometry parameter
	 * 
	 * @param returnGeometry - If "true", the result set include the geometry associated with each result. The default is "false".
	 */
	public final native void setReturnGeometry(boolean returnGeometry) /*-{
		this.returnGeometry = returnGeometry;
	}-*/;

	/**
	 * The names of the fields of a layer to search. The fields are specified as a comma-separated list of field names. If this parameter
	 * is not specified, all fields are searched.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getSearchFields() /*-{
		return this.searchFields;
	}-*/;
	
	/**
	 * The names of the fields of a layer to search. The fields are specified as a comma-separated list of field names. If this parameter
	 * is not specified, all fields are searched.
	 * 
	 * @param searchFields
	 */
	public final void setSearchFields(String[] searchFields) {
		_setSearchFields(Util.stringArrayToJSO(searchFields));
	}
	
	private final native void _setSearchFields(JavaScriptObject searchFields) /*-{
		this.searchFields = searchFields;
	}-*/;
	
	/**
	 * The search string text that is searched across the layers and the fields as specified in the layers and searchFields parameters.
	 * 
	 * @return String
	 */
	public final native String getSearchText() /*-{
		return this.searchText;
	}-*/;
	
	/**
	 * Set the search text parameter.
	 * 
	 * @param searchText - The search string text that is searched across the layers and the fields as specified in the layers and searchFields parameters.
	 */
	public final native void setSearchText(String searchText) /*-{
		this.searchText = searchText;
	}-*/;

}
