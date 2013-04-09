package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class RestfulLayersInfo extends JavaScriptObject {

	protected RestfulLayersInfo() {}
	
	public final native JsArray<RestfulLayerInfo> getLayers() /*-{
		if( this.layers ) return this.layers;
		return [];
	}-*/;
	
	public final native JsArray<JavaScriptObject> getTables() /*-{
		if( this.tables ) return this.tables;
		return [];
	}-*/;
	
}
