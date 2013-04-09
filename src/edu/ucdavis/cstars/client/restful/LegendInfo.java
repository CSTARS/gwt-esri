package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author Justin Merz
 */
public class LegendInfo extends JavaScriptObject {
	
	protected LegendInfo() {}
	
	public final native String getLabel() /*-{
		if( this.label ) return this.label;
		return "";
	}-*/;

	public final native String getUrl() /*-{
		if( this.url ) return this.url;
		return "";
	}-*/;
	
	public final native String getImageData() /*-{
		if( this.imageData ) return this.imageData;
		return "";
	}-*/;
	
	public final native String getContentType() /*-{
		if( this.contentType ) return this.contentType;
		return "";
	}-*/;

}
