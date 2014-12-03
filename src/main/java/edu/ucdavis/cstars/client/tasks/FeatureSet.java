package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.JSObject;
import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 * A collection of features returned from ArcGIS Server or used as input to tasks. Each feature in the FeatureSet may contain
 * geometry, attributes, symbolgy, and an InfoTemplate. If the FeatureSet does not contain geometry, and only contains
 * attributes, the FeatureSet can be treated as a table where each feature is a row object. Tasks that return FeatureSet
 * include QueryTask, Geoprocessor, and RouteTask. In addition, Geoprocessor and RouteTask may require FeatureSet as input.
 * 
 * @author Justin Merz
 */
public class FeatureSet extends JavaScriptObject {

	protected FeatureSet() {}

	/**
	 * Creates a new FeatureSet object.
	 * 
	 * @return FeatureSet
	 */
	public static native FeatureSet create() /*-{ 
		return new $wnd.esri.tasks.FeatureSet(); 
	}-*/;
	
	/**
	 * Creates a new FeatureSet object using a JSON object. 
	 * 
	 * @param json - A JSON object that contains feature set.
	 * @return FeatureSet
	 */
	public static native FeatureSet create(JavaScriptObject json) /*-{ 
		return new $wnd.esri.tasks.FeatureSet(json); 
	}-*/;
	
	/**
	 * The name of the layer's primary display field. The value of this property matches the name of one of the fields of the feature.
	 * Only applicable when the FeatureSet is returned from a task. It is ignored when the FeatureSet is used as input to a geoprocessing task.
	 * 
	 * @return String
	 */
	public final native String getDisplayFieldName() /*-{ 
		return this.displayFieldName; 
	}-*/;
	
	/**
	 * Set the display field name parameter
	 * 
	 * @param displayFieldName - The name of the layer's primary display field. The value of this property matches the name of one of the fields of
	 * the feature. Only applicable when the FeatureSet is returned from a task. It is ignored when the FeatureSet is used as input to a geoprocessing task.
	 */
	public final native void setDisplayFieldName(String displayFieldName) /*-{
		this.displayFieldName = displayFieldName;
	}-*/;
	
	/**
	 * The array of graphics returned.
	 * 
	 * @return JsArray<Graphic>
	 */
	public final native JsArray<Graphic> getFeatures() /*-{
			return this.features;
	}-*/;
	
	/**
	 * Set the features parameters.
	 * 
	 * @param features - The array of graphics returned.
	 */
	public final void setFeatures(Graphic[] features) {
		_setFeatures(Util.objectArrayToJSO(features));
	}
	
	private final native void _setFeatures(JavaScriptObject features) /*-{
		this.features = features;
	}-*/;
	
	/**
	 * Set of name-value pairs for the attribute's field and alias names.
	 * 
	 * @return JSObject
	 */
	public final native JSObject getFieldAliases() /*-{ 
		return this.fieldAliases;
	}-*/;
	
	/**
	 * Set the field aliases parameter.
	 * 
	 * @param fieldAliases - Set of name-value pairs for the attribute's field and alias names.
	 */	
	public final native void setFieldAliases(JSObject fieldAliases) /*-{
		this.fieldAliases = fieldAliases;
	}-*/;
	
	/**
	 * The geometry type of the FeatureSet.
	 * 
	 * @return String
	 */
	public final native String getGeometryType() /*-{ 
		return this.geometryType;
	}-*/;
	
	/**
	 * set the geometry type parameter.
	 * 
	 * @param geometryType - The geometry type of the FeatureSet.
	 */
	public final native void setGeometryType(String geometryType) /*-{
		this.geometryType = geometryType;
	}-*/;
	
	/**
	 * When a FeatureSet is used as input to Geoprocessor, the spatial reference is set to the map's spatial reference by default.
	 * This value can be changed. When a FeatureSet is returned from a task, the value is the result as returned from the server.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{ 
		return this.spatialReference;
	}-*/;
	
	/**
	 * set the spatial reference parameter.
	 * 
	 * @param spatialReference - When a FeatureSet is used as input to Geoprocessor, the spatial reference is set to the map's
	 * spatial reference by default. This value can be changed. When a FeatureSet is returned from a task, the value is the result
	 * as returned from the server.
	 */
	public final native void setSpatialReference(SpatialReference spatialReference) /*-{
		this.spatialReference = spatialReference;
	}-*/;

}
