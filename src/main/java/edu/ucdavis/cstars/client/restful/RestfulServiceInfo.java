package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class RestfulServiceInfo extends JavaScriptObject {
	
	protected RestfulServiceInfo() {};
	
	public final native float getCurrentVersion() /*-{
		if( this.currentVersion ) return this.currentVersion;
		return "";
	}-*/;
	
	public final native JsArrayString getFolders() /*-{
		return this.folders;
	}-*/;

	public final native JsArray<Service> getServices() /*-{
		return this.services;
	}-*/;
	
	
	public static class Service extends JavaScriptObject {
		
		protected Service() {}
		
		public final native String getName() /*-{
			return this.name;
		}-*/;
		
		public final native String getType() /*-{
			return this.type;
		}-*/;
		
	}
	
}
