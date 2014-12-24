package edu.ucdavis.cstars.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

import edu.ucdavis.cstars.client.Util;

public class Ring extends JavaScriptObject {
	
	protected Ring () {}
	
	public static Ring create() {
		return JavaScriptObject.createArray().cast();
	}
	
	public static Ring create(double[][] points) {
		JavaScriptObject array = JavaScriptObject.createArray().cast();
		for( int i = 0; i < points.length; i++ ) {
			_push(array, Util.doubleArrayToJSO(points[i]));
		}
		return (Ring) array;
	}
	
	private static native void _push(JavaScriptObject arr, JavaScriptObject points) /*-{
		arr.push(points);
	}-*/; 
	
	public final native void addPoint(Point point) /*-{
		this.push(point);
	}-*/;

	public final void addPoints(Point[] points) {
		for( Point p: points ) addPoint(p);
	}

	public final native int getNumPoints() /*-{
		return this.length;
	 }-*/;
	
	public final native JsArrayNumber getPoint(int index) /*-{
		return this[index];
	}-*/;
	
	 public final native boolean isClockwise() /*-{
     return $wnd.esri.geometry.isClockwise(this);
   }-*/;
}
