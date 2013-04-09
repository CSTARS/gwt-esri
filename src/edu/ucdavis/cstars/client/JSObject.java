package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Used for generic getting and setting of a JavaScriptObject's fields
 * 
 * @author Justin Merz
 */
public class JSObject extends JavaScriptObject {

	protected JSObject() {}
	
	public final native boolean hasKey(String key) /*-{
			if( this[key] ) return true;
			return false;
	}-*/;
	
	public final native JsArrayString getKeys() /*-{
		var keys = [];
		for( var i in this ) keys.push(i);
		return keys;
	}-*/;
	
	public final native void setInt(String key, int value) /*-{
		this[key] = value;
	}-*/;
	
	public final native int getInt(String key) /*-{
		return this[key];
	}-*/;
	
	public final native void setString(String key, String value) /*-{
		this[key] = value;
	}-*/;
	
	public final native String getString(String key) /*-{
		return this[key];
	}-*/;
	
	public final native void setObject(String key, JavaScriptObject jso) /*-{
		this[key] = jso;
	}-*/;
	
	public final native JSObject getObject(String key) /*-{
		return this[key];
	}-*/;
	
	/**
	 * Cast to string
	 * 
	 * @param key
	 * @return
	 */
	public final native String getStringForced(String key) /*-{
		return new String(this[key]);
	}-*/;
	
	public final native void setBoolean(String key, boolean value) /*-{
		this[key] = value;
	}-*/;
	
	public final native int getBoolean(String key) /*-{
		return this[key];
	}-*/;
	
	public final native void setFloat(String key, float value) /*-{
		this[key] = value;
	}-*/;
	
	public final native float getFloat(String key) /*-{
		return this[key];
	}-*/;
	
	public final native void setDouble(String key, double value) /*-{
		this[key] = value;
	}-*/;
	
	public final native double getDouble(String key) /*-{
		return this[key];
	}-*/;
	
}
