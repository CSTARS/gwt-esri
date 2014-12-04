package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Represents a result of an identify operation.
 * 
 * @author Justin Merz
 */
public class IdentifyResult extends JavaScriptObject {
	
	protected IdentifyResult() {}
	
	/**
	 * The name of the layer's primary display field. The value of this property matches the name of one of the fields of the feature.
	 * 
	 * @return String
	 */
	public final native String getDisplayFieldName() /*-{ 
		return this.displayFieldName;
	}-*/;

	/**
	 * The layer name that contains the feature.
	 * 
	 * @return Graphic
	 */
	public final native Graphic getFeature() /*-{
		return this.feature
	}-*/;
	
	/**
	 * An identified feature.
	 * 
	 * @return int
	 */
	public final native int getLayerId() /*-{
		return this.layerId
	}-*/;
	
	/**
	 * Unique ID of the layer that contains the feature.
	 * 
	 * @return String
	 */
	public final native String getLayerName() /*-{
		return this.layerName
	}-*/;
	

	
}
