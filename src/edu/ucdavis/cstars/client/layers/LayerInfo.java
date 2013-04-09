package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.restful.LegendInfo;

/**
 * Contains information about each layer in a map service. LayerInfo has no constructor. 
 * 
 * @author Justin Merz
 */
public class LayerInfo extends JavaScriptObject {
	
	protected LayerInfo() {}
	
	/**
	 * Default visibility of the layers in the map service.
	 * 
	 * @return boolean
	 */
	public final native boolean hasDefaultVisibility() /*-{
		return this.defaultVisibility;
	}-*/;
	
	/**
	 * Set the defaultVisibility parameter.
	 * 
	 * @param defaultVisibility - Default visibility of the layers in the map service.
	 */
	public final native void setDefaultVisibility(boolean defaultVisibility) /*-{
		this.defaultVisibility = defaultVisibility;
	}-*/;
	
	/**
	 * Layer ID assigned by ArcGIS Server for a layer. The topmost layer is 0, and each layer follows
	 * sequentially. If a layer is added or removed from the source map document, the ID values will
	 * shift accordingly.
	 * 
	 * @return int
	 */
	public final native int getId() /*-{
		if( this.id != null ) return this.id;
		if( this.layerId != null ) return this.layerId;
		return -1;
	}-*/;
	
	/**
	 * Set the id
	 * 
	 * @param id -  Layer ID assigned by ArcGIS Server for a layer. The topmost layer is 0, and each layer follows
	 * sequentially. If a layer is added or removed from the source map document, the ID values will
	 * shift accordingly.
	 */
	public final native void setId(int id) /*-{
		this.id = id;
	}-*/;
	
	/**
	 * The maximum visible scale for each layer in the map service. If the map is zoomed in beyond
	 * this scale the layer will not be visible. A value of 0 means that the layer does not have a maximum
	 * scale. This property is only available for map services published using ArcGIS Server 10 SP1 or later.
	 * 
	 * @return float
	 */
	public final native double getMaxScale() /*-{
		if( this.maxScale != null ) return this.maxScale;
		return -1;
	}-*/;
	
	/**
	 * Set the maxScale parameter.
	 * 
	 * @param maxScale - The maximum visible scale for each layer in the map service. If the map is zoomed in beyond
	 * this scale the layer will not be visible. A value of 0 means that the layer does not have a maximum
	 * scale. This property is only available for map services published using ArcGIS Server 10 SP1 or later.
	 * 
	 */
	public final native void setMaxScale(double maxScale) /*-{
		this.maxScale = maxScale;
	}-*/;
	
	/**
	 * The maximum visible scale for each layer in the map service. If the map is zoomed in beyond this scale
	 * the layer will not be visible. A value of 0 means that the layer does not have a maximum scale. This
	 * property is only available for map services published using ArcGIS Server 10 SP1 or later.
	 * 
	 * @return float
	 */
	public final native double getMinScale() /*-{
		if( this.minScale != null ) return this.minScale;
		return -1;
	}-*/;
	
	/**
	 * Set the minScale parameter.
	 * 
	 * @param minScale - The maximum visible scale for each layer in the map service. If the map is zoomed in beyond this scale
	 * the layer will not be visible. A value of 0 means that the layer does not have a maximum scale. This
	 * property is only available for map services published using ArcGIS Server 10 SP1 or later.
	 */
	public final native void setMinScale(double minScale) /*-{
		this.minScale = minScale;
	}-*/;

	
	/**
	 * Layer name as defined in the map service.
	 * 
	 * @return String
	 */
	public native final String getName() /*-{
		if( this.name ) return this.name;
		if( this.layerName ) return this.layerName;
		return "";
	}-*/;
	
	/**
	 * Set the name parameter.
	 * 
	 * @param name - Layer name as defined in the map service.
	 */
	public native final void setName(String name) /*-{
		this.name = name;
	}-*/;
	
	/**
	 * If the layer is part of a group layer, it will include the parent ID of the group layer. Otherwise, the value
	 * is -1. If a layer is added or removed from the source map document, the ID values will shift accordingly.
	 * 
	 * @return int
	 */
	public native final int getParentLayerId() /*-{
		return this.parentLayerId;
	}-*/;
	
	/**
	 * Set the parent layer id.
	 * 
	 * @param parentLayerId - If the layer is part of a group layer, it will include the parent ID of the group layer. 
	 * Otherwise, the value is -1. If a layer is added or removed from the source map document, the ID values will shift 
	 * accordingly.
	 */
	public native final void setParentLayerId(int parentLayerId) /*-{
		this.parentLayerId = parentLayerId;
	}-*/;
	
	/**
	 * If the layer is a parent layer, it will have one or more sublayers included in an array. Otherwise, the value is null.
	 * If a layer is added or removed from the source map document, the ID values will shift accordingly.
	 * 
	 * @return JsArrayInteger
	 */
	public native final JsArrayInteger getSubLayerIds() /*-{
		return this.subLayerIds;
	}-*/;

	/**
	 * Set the sublayer ids.
	 * 
	 * @param subLayerIds - If the layer is a parent layer, it will have one or more sublayers included in an array. 
	 * Otherwise, the value is null. If a layer is added or removed from the source map document, the ID values will shift accordingly.
	 */
	public final void setSubLayerIds(int[] subLayerIds) {
		_setSubLayerIds(Util.intArrayToJSO(subLayerIds));
	};
	
	private final native void _setSubLayerIds(JavaScriptObject subLayerIds) /*-{
		this.subLayerIds = subLayerIds;
	}-*/;

	
	/**
	 * Check to see if this LayerInfo has legend information attached.
	 * 
	 * @return boolean
	 */
	public native final boolean hasLegendInfo() /*-{
		if( this.legend ) return true;
		return false;
	}-*/;
	
	/**
	 * Get the layers LegendInfo if it is attached to this LayerInfo object.
	 * 
	 * @return JsArray<LegendInfo>
	 */
	public native final JsArray<LegendInfo> getLegendInfo() /*-{
		if( this.legend ) return this.legend;
		return [];
	 }-*/;

	public native final String getLayerType() /*-{
		if( this.layerType ) return this.layerType;
		return "";
	}-*/;
	
}
