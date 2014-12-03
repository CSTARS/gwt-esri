package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;

/**
 * Class added v2.6
 * Create a multipart color ramp to concatenate multiple color ramps for use in the renderer 
 * generated by the GenerateRendererTask. After creating a new MultipartColorRamp object you 
 * can add algorithmic color ramps using the addRamp method. The MultipartColorRamp will try 
 * to use an equal number of colors from each member ramp to create its colors.
 * 
 * @author Justin Merz
 */
public class MultiPartColorRamp extends JavaScriptObject {

	protected MultiPartColorRamp() {}
	
	/**
	 * Creates a new MultipartColorRamp object.
	 * 
	 * @return MultiPartColorRamp
	 */
	public static native MultiPartColorRamp create() /*-{
		return new $wnd.esri.tasks.MultipartColorRamp();
	}-*/;
	
	/**
	 * Define an array of algorithmic color ramps used to generate the multi part ramp.
	 * 
	 * @return JsArray<AlgorithmicColorRamp>
	 */
	public final native JsArray<AlgorithmicColorRamp> getColorRamps() /*-{
		return this.colorRamps;
	}-*/;
	
	/**
	 * Set the colorRamps parameter.
	 * 
	 * @param colorRamps - Define an array of algorithmic color ramps used to generate 
	 * the multi part ramp.
	 */
	public final void setColorRamps(AlgorithmicColorRamp[] colorRamps) {
		_setColorRamps(Util.objectArrayToJSO(colorRamps));
	}
	
	private final native void _setColorRamps(JavaScriptObject colorRamps) /*-{
		this.colorRamps = colorRamps;
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of a multipart color ramp.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.tojson();
	}-*/;
	
}