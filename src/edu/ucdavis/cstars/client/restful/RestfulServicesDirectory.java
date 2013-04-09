package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.layers.LayerInfo;

/**
 * This is the base object returned for all services.  Note, many fields will be empty if you request the legend for example.
 * 
 * @author Justin Merz
 */
public class RestfulServicesDirectory extends JavaScriptObject {

	protected RestfulServicesDirectory() {}
	
	public final native String getServiceDescription() /*-{
		if( this.serviceDescription ) return this.serviceDescription;
		return "";
	}-*/;
	
	public final native String getMapName() /*-{
		if( this.mapName ) return this.mapName;
		return "";
	}-*/;
	
	public final native String getName() /*-{
		if( this.name ) return this.name;
		return "";
	}-*/;
	
	public final native String getDescription() /*-{
		if( this.description ) return this.description;
		return "";
	}-*/;
	
	public final native String getCopyrightText() /*-{
		if( this.copyrightText ) return this.copyrightText;
		return "";
	}-*/;
	
	public final native JsArray<LayerInfo> getLayers() /*-{
		if( this.layers ) return this.layers;
		return [];
	}-*/;
	
	public final SpatialReference getSpatialReference() {
		JavaScriptObject jso = _getSpatialReference();
		if( jso == null ) return null;
		return SpatialReference.create(jso);
	}
	
	public final native JavaScriptObject _getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	public final native boolean isSingleFusedMapCache() /*-{
		return this.singleFusedMapCache;
	}-*/;
	
	public final Extent getInitialExtent() {
		JavaScriptObject jso = _getInitialExtent();
		if( jso == null ) return null;
		return Extent.create(jso);
	}
	
	private final native JavaScriptObject _getInitialExtent() /*-{
		return this.initialExtent;
	}-*/;
	
	public final Extent getFullExtent() {
		JavaScriptObject jso = _getFullExtent();
		if( jso == null ) return null;
		return Extent.create(jso);
	}
	
	private final native JavaScriptObject _getFullExtent() /*-{
		return this.fullExtent;
	}-*/;
	
	public final native String getUnits() /*-{
		return this.units;
	}-*/;
	
	public final native String getSupportedImageFormatTypes() /*-{
		return this.supportedImageFormatTypes;
	}-*/;
	
	public final native RestfulDocumentInfo getDocumentInfo() /*-{
		return this.documentInfo;
	}-*/;

	public final native boolean hasTileInfo() /*-{
		if( this.tileInfo ) return true;
		return false;
	}-*/;
	
	
}
