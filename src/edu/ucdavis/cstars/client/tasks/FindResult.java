package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Represents a result of a find operation. 
 * 
 * @author Justin Merz
 */
public class FindResult extends JavaScriptObject {
	
	protected FindResult() {}
	
	/**
	 * The name of the layer's primary display field. The value of this property matches the name of one of the fields of the feature.
	 * 
	 * @return String
	 */
	public final native String getDisplayFieldName() /*-{
		return this.displayFieldName;
	}-*/;

	/**
	 * The found feature.
	 * 
	 * @return Graphic
	 */
	public final native Graphic getFeature() /*-{
		return this.feature;
	}-*/;

	/**
	 * The name of the field that contains the search text.
	 * 
	 * @return String
	 */
	public final native String getFoundFieldName() /*-{
		return this.foundFieldName;
	}-*/;

	/**
	 * Unique ID of the layer that contains the feature.
	 * 
	 * @return int
	 */
	public final native int getLayerId() /*-{
		return this.layerId;
	}-*/;

	/**
	 * The layer name that contains the feature.
	 * 
	 * @return String
	 */
	public final native String getLayerName() /*-{
		return this.layerName;
	}-*/;

}
