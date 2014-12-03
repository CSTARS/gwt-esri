package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Band information, used by ArcGISImageServiceLayer
 * 
 * @author Justin Merz
 */
public class Band extends JavaScriptObject {
	
	protected Band() {}
	
	/**
	 * 
	 * @return float
	 */
	public native final float getMin() /*-{
		return this.min;
	}-*/;
	
	/**
	 * 
	 * @return float
	 */
	public native final float getMax() /*-{
		return this.max;
	}-*/;

	/**
	 * 
	 * @return float
	 */
	public native final float getMean() /*-{
		return this.mean;
	}-*/;
	
	/**
	 * 
	 * @return float
	 */
	public native final float getStddev() /*-{
		return this.stddev;
	}-*/;
	
}
