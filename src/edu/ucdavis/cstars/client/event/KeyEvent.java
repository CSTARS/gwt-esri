package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * ESRI's key event object
 * 
 * @author Justin Merz
 */
public class KeyEvent extends JavaScriptObject {
	
	protected KeyEvent() {};
	
	public final native int getKeyCode() /*-{
		return this.keyCode;
	}-*/;

}
