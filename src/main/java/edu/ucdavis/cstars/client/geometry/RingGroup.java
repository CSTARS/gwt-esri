package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public class RingGroup extends JavaScriptObject {
	
	protected RingGroup() {}

	public static RingGroup create() {
		return JavaScriptObject.createArray().cast();
	}
	
	public final native void addRing(Ring ring) /*-{
		this.push(ring);
	}-*/;
	
	public final native int getNumRings() /*-{
		return this.length;
	}-*/;
	
	public final native Ring getRing(int index) /*-{
		return this[index];
	}-*/;
	
}
