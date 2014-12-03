package edu.ucdavis.cstars.client.toolbars;

import com.google.gwt.core.client.JavaScriptObject;

// this is not well documented.  just guessing for now.

/**
 * 
 * @author Justin Merz
 */
public class Transform extends JavaScriptObject {
	
	protected Transform() {}
	
	public final native int getDx()/*-{
		return this.dx;
	 }-*/;
	
	public final native int getDy() /*-{
		return this.dy;
	}-*/;
	
	public final native int getXx() /*-{
		return this.xx;
	}-*/;	
	
	public final native int getXy() /*-{
		return this.xy;
	}-*/;
	
	public final native int getYx() /*-{
		return this.Yx;
	}-*/;
	
	public final native int getYy() /*-{
		return this.yy;
	}-*/;

}
