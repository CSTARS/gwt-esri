package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 * Define query parameters for the feature layer's queryRelateFeatures method. 
 * 
 * @author Justin Merz
 */
public class RelationshipQuery extends JavaScriptObject {
	
	protected RelationshipQuery() {}
	
	/**
	 * Create a new RelationshipQuery object
	 * 
	 * @return RelationshipQuery
	 */
	public static native RelationshipQuery create() /*-{
		return new $wnd.esri.tasks.RelationshipQuery();
	}-*/;
	
	/**
	 * Set the definition expression for this query
	 * 
	 * @param expression -  The definition expression to be applied to the related table
	 * or layer. Only records that fit the definition expression and are in the list of ObjectIds
	 * will be returned.
	 */
	public final native void setDefinitionExpression(String expression) /*-{
		this.definitionExpression = expression;
	}-*/;
	
	/**
	 * Set the max allowable offset for this query
	 * 
	 * @param maxOffset - The maximum allowable offset used for generalizing geometries
	 * returned by the query operation. The offset is in the units of the spatialReference. If
	 * a spatialReference is not defined the spatial reference of the map is used.
	 */
	public final native void setMaxAllowableOffset(int maxOffset) /*-{
		this.maxAllowableOffset = maxOffset;
	}-*/;
	
	/**
	 * Set the object ids for this query
	 * 
	 * @param ids - Int array of objectIds for the features in the layer/table that you want to query.
	 */
	public final void setObjectIds(int[] ids) {
		_setObjectIds(Util.intArrayToJSO(ids));
	}
	
	private final native void _setObjectIds(JavaScriptObject ids) /*-{
		this.objectIds = ids;
	}-*/;
	
	/**
	 * Set the outfields for this query
	 * 
	 * @param outfields - fields to include in the FeatureSet. Fields must exist in the map layer.
	 * You must list the actual field names rather than the alias names. Returned fields are also the actual
	 * field names. However, you are able to use the alias names when you display the results. You can set
	 * field alias names in the map document.
	 * When you specify the output fields, you should limit the fields to only those you expect to use in
	 * the query or the results. The fewer fields you include, the faster the response will be.
	 * Each query must have access to the Shape and Objectid fields for a layer, but your list of fields does
	 * not need to include these two fields.
	 */
	public final void setOutfields(String[] outfields) {
		_setOutfields(Util.stringArrayToJSO(outfields));
	}
	
	private final native void _setOutfields(JavaScriptObject outfields) /*-{
		this.outfields = outfields
	}-*/;
	
	/**
	 * Set the spatial reference for the returned geometry
	 * 
	 * @param outSpatialReference - The spatial reference for the returned geometry. If not specified, the geometry is returned in the
	 * spatial reference of the map.
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * Set the relationship id for this query
	 * 
	 * @param relationshipId - The ID of the relationship to test. The ids for the relationships the table or layer particpates in are
	 * listed in the the ArcGIS Services directory.
	 * 
	 */
	public final native void setRelationshipId(int relationshipId) /*-{
		this.relationshipId = relationshipId;
	}-*/;
	
	/**
	 * Should the returned FeatureSet include geometry.
	 * 
	 * @param returnGeometry - If "true", each feature in the FeatureSet includes the geometry. Set to "false" (default) if you do
	 * not plan to include highlighted features on a map since the geometry makes up a significant portion of the response.
	 */
	public final native void returnGeometry(boolean returnGeometry) /*-{
		this.returnGeometry = returnGeometry;
	}-*/;
	
}
