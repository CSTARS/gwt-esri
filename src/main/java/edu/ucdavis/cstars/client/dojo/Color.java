package edu.ucdavis.cstars.client.dojo;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * 
 * @author Justin Merz
 */
public class Color extends JavaScriptObject {
	
	protected Color() {}

	public static native Color create() /*-{
		return new $wnd.dojo.Color();
	}-*/;

	public static native Color create(JavaScriptObject color) /*-{
       return new $wnd.dojo.Color(color);
    }-*/;
	
	public static native Color create(String color) /*-{
		return new $wnd.dojo.Color(color);
	}-*/;
	
	public static native Color create(Color color) /*-{
		return new $wnd.dojo.Color(color);
	}-*/;
	
	public static native Color create(int red, int green, int blue, double alpha) /*-{
		return new $wnd.dojo.Color({"r": red,"g": green,"b": blue,"a": alpha});
	}-*/;
	
	public static native Color create(int red, int green, int blue) /*-{
		return new $wnd.dojo.Color({"r": red,"g": green,"b": blue,"a": 1});
	}-*/;
	
	public final native int getRed() /*-{
		return this.r;
	}-*/;
	
	public final native int getGreen() /*-{
		return this.g;
	}-*/;
	
	public final native int getBlue() /*-{
		return this.b;
	}-*/;
	
	public final native double getAlpha() /*-{
		return this.a;
	}-*/;
	
	public final native void setColor(String color) /*-{
		this.setColor(color);
	}-*/;
	
	public final native void setColor(int red, int green, int blue, double alpha) /*-{
		this.setColor({"r": red, "g": green, "b": blue, "a": alpha});
	}-*/;
	
	public final native void setColor(int red, int green, int blue) /*-{
		this.setColor({"r": red, "g": green, "b": blue, "a": 1});
	}-*/;
	
	public final native String toCss(boolean includeAlpha) /*-{
		return this.toCss(includeAlpha);
	}-*/;

	public final native String toHex() /*-{
		return this.toHex();
	}-*/;
	
	public final native JsArrayInteger toRgb() /*-{
		return this.toRgb();
	}-*/;
	
	public final native JsArrayInteger toRgba() /*-{
		return this.toRgba();
	}-*/;
	
	// TODO: how should we do this one?
	//public final native String toString() /*-{
	//	return this.toString();
	//}-*/;
	
}
