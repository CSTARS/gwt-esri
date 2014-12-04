package edu.ucdavis.cstars.client.toolbars;

import com.google.gwt.core.client.JavaScriptObject;

// object is poorly documented, this is my best guess.

/**
 * 
 * @author Justin Merz
 */
public class Around extends JavaScriptObject {
	
	protected Around() {}
	
	public final native int getX() /*-{
		return this.x;
	}-*/;
	
	public final native int getY() /*-{
		return this.y;
	}-*/;
	
	public final native int getScaleX() /*-{
		return this.scalex;
	}-*/;
	
	public final native int getScaleY() /*-{
		return this.scaley;
	}-*/;


}
