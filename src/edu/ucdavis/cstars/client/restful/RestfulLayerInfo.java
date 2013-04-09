package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.layers.Field;

public class RestfulLayerInfo extends JavaScriptObject {

	protected RestfulLayerInfo() {}
	
	public final native float getCurrentVersion() /*-{
		if( this.currentVersion ) return this.currentVersion;
		return -1;
	}-*/;
	
	public final native int getId() /*-{
		if( this.id ) return this.id;
		return -1;
	}-*/;
	
	public final native String getName() /*-{
		if( this.name ) return this.name;
		return "";
	}-*/;
	
	public final native String getType() /*-{
		if( this.type ) return this.type;
		return "";
	}-*/;
	
	public final native String getDescription() /*-{
		if( this.description ) return this.description;
		return "";
	}-*/;
	
	public final native String getDefinitionExpression() /*-{
		if( this.definitionExpression ) return this.definitionExpression;
		return "";
	}-*/;
	
	public final native String getGeometryType() /*-{
		if( this.geometryType ) return this.geometryType;
		return "";
	}-*/;
	
	public final native JsArray<JavaScriptObject> getSubLayers() /*-{
		if( this.subLayers ) return this.subLayers;
		return [];
	}-*/;
	
	public final native float getMinScale() /*-{
		if( this.minScale ) return this.minScale;
		return 0;
	}-*/;
	
	public final native float getMaxScale() /*-{
		if( this.maxScale ) return this.maxScale;
		return 0;
	}-*/;
	
	
	public final native boolean hasDefaultVisibility() /*-{
		if( this.defaultVisibility ) return true;
		return false;
	}-*/;
	
	public final native Extent getExtent() /*-{
		if( this.extent != null ) return new $wnd.esri.geometry.Extent(this.extent);
		return null;
	}-*/;
	
	public final native boolean hasAttachments() /*-{
		if( this.hasAttachments ) return true;
		return false;
	}-*/;
	
	public final native JavaScriptObject getDrawingInfo() /*-{
		if( this.drawingInfo ) return this.drawingInfo;
		return null;
	}-*/;
	
	public final native String getDisplayField() /*-{
		if( this.displayField ) return this.displayField;
		return "";
	}-*/;
	
	public final native JsArray<Field> getFields() /*-{
		if( this.fields ) return this.fields;
		return [];
	}-*/;
	
	public final native String getCapabilities() /*-{
		if( this.capabilities ) return this.capabilities;
		return "";
	}-*/;
	
}
