package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Query for input to the QueryTask. Not all query properties are required to execute a QueryTask. The query definition
 * requires one of the following properties: queryGeometry, text, or where. Optional properties include outFields,
 * outSpatialReference, and returnGeometry.
 * 
 * @author Justin Merz
 */
public class Query extends JavaScriptObject {
	
	public enum SpatialRelationshipType {
		NOT_SET(""),
		SPATIAL_REL_CONTAINS("esriSpatialRelContains"),
		SPATIAL_REL_CROSSES("esriSpatialRelCrosses"),
		SPATIAL_REL_ENVELOPEINTERSECTS("esriSpatialRelEnvelopeIntersects"),
		SPATIAL_REL_INDEXINTERSECTS("esriSpatialRelIndexIntersects"),
		SPATIAL_REL_INTERSECTS("esriSpatialRelIntersects"),
		SPATIAL_REL_OVERLAPS("esriSpatialRelOverlaps"),
		SPATIAL_REL_RELATION("esriSpatialRelRelation"),
		SPATIAL_REL_TOUCHES("esriSpatialRelTouches"),
		SPATIAL_REL_SPATIAL_REL_WITHIN("esriSpatialRelWithin");
		
		private String val;
		private SpatialRelationshipType(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected Query() {}
	
	/**
	 * Creates a new Query object used to execute a query on the layer resource identified by the URL.
	 * 
	 * @return Query
	 */
	public static native Query create() /*-{
		return new $wnd.esri.tasks.Query();
	}-*/;
	
	/**
	 * The geometry to apply to the spatial filter. The spatial relationship as specified by spatialRelationship
	 * is applied to this geometry while performing the query. The valid geometry types are Extent, Point,
	 * Multipoint, Polyline, or Polygon. 
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry() /*-{ 
		return this.geometry;
	}-*/;
	
	/**
	 * Set the geometry to apply to the spatial filter.
	 * 
	 * @param geometry - the geometry to apply to the spatial filter. The spatial relationship as specified by spatialRelationship
	 * is applied to this geometry while performing the query. The valid geometry types are Extent, Point,
	 * Multipoint, Polyline, or Polygon. 
	 */
	public final native void setGeometry(Geometry geometry) /*-{ 
		this.geometry = geometry;
	}-*/;
	
	/**
	 * One or more field names that will be used to group the statistics. groupByFieldsForStatistics is only valid when outStatistics have been defined.
	 * 
	 * Requires ArcGIS Server service version 10.1 or greater (As of v2.6)
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getGroupByFieldsForStatistics() /*-{
		return this.groupByFieldsForStatistics;
	}-*/;
	
	/**
	 * Set the groupByFieldsForStatistics parameter.
	 * 
	 * @param groupByFieldsForStatistics - One or more field names that will be used to group the statistics. groupByFieldsForStatistics is only valid when 
	 * outStatistics have been defined. Requires ArcGIS Server service version 10.1 or greater (As of v2.6)
	 */
	public final void setGroupByFieldsForStatistics(String[] groupByFieldsForStatistics) {
		_setGroupByFieldsForStatistics(Util.stringArrayToJSO(groupByFieldsForStatistics));
	}
	
	private final native void _setGroupByFieldsForStatistics(JavaScriptObject groupByFieldsForStatistics) /*-{
		this.groupByFieldsForStatistics = groupByFieldsForStatistics; 
	}-*/;
	
	/**
	 * The maximum allowable offset used for generalizing geometries returned by the query operation. The
	 * offset is in the units of the spatialReference. If a spatialReference is not defined the spatial reference of the map is used.
	 * 
	 * @return double
	 */
	public final native double getMaxAllowableOffset() /*-{
		return this.maxAllowableOffset;
	}-*/;
	
	/**
	 * Set the maximum allowable offset.
	 * 
	 * @param maxAllowableOffset -  the maximum allowable offset used for generalizing geometries returned by the query operation. The
	 * offset is in the units of the spatialReference. If a spatialReference is not defined the spatial reference of the map is used.
	 */
	public final native void setMaxAllowableOffset(double maxAllowableOffset) /*-{
		this.maxAllowableOffset = maxAllowableOffset;
	}-*/;
	
	/**
	 * A comma delimited list of ObjectIds for the features in the layer/table that you want to query.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getObjectIds() /*-{
		return this.objectIds;
	}-*/;
	
	/**
	 * Set object ids.
	 * 
	 * @param ids - Array of ObjectIds for the features in the layer/table that you want to query.
	 */
	public final void setObjectIds(int[] ids) {
		_setObjectIds(Util.intArrayToJSO(ids));
	};
	
	private final native void _setObjectIds(JavaScriptObject ids) /*-{
		this.objectIds = ids;
	}-*/;
	
	/**
	 * One or more field names that will be used to order the query results. Specfiy ASC (ascending) or DESC (descending) after the field name to 
	 * control the order. The default order is ASC. orderByFields is only supported on dynamic layers and tables where supportsAdvancedQueries is 
	 * true.
	 * 
	 * Requires ArcGIS Server service version 10.1 or greater (As of v2.6)
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getOrderByFields() /*-{ 
		return this.orderByFields;
	}-*/;
	
	/**
	 * Set the orderByField parameter.
	 * 
	 * @param orderByFields - One or more field names that will be used to order the query results. Specfiy ASC (ascending) or DESC (descending) after the field name to 
	 * control the order. The default order is ASC. orderByFields is only supported on dynamic layers and tables where supportsAdvancedQueries is 
	 * true. Requires ArcGIS Server service version 10.1 or greater (As of v2.6)
	 */
	public final void setOrderByFields(String[] orderByFields) {
		_setOrderByFields(Util.stringArrayToJSO(orderByFields));
	}
	
	private final native void _setOrderByFields(JavaScriptObject orderByFields) /*-{ 
		this.orderByFields = orderByFields;
	}-*/;
		
	/**
	 * Attribute fields to include in the FeatureSet. Fields must exist in the map layer. You must list the actual field names rather
	 * than the alias names. Returned fields are also the actual field names. However, you are able to use the alias names when
	 * you display the results. You can set field alias names in the map document. 
	 * 
	 * When you specify the output fields, you should limit the fields to only those you expect to use in the query or the results.
	 * The fewer fields you include, the faster the response will be. 
	 * 
	 * Each query must have access to the Shape and Objectid fields for a layer, but your list of fields does not need to include
	 * these two fields.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getOutFields() /*-{ 
		return this.outFields;
	}-*/;
	
	/**
	 * Set outFields for query.
	 * 
	 * @param outFields - Attribute fields to include in the FeatureSet.
	 */
	public final void setOutFields(String[] outFields) {
		_setOutFields(Util.stringArrayToJSO(outFields));
	}
	
	private final native void _setOutFields(JavaScriptObject outFields) /*-{ 
		this.outFields = outFields;
	}-*/;
	
	/**
	 * The spatial reference for the returned geometry. If not specified, the geometry is returned in the spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialReference() /*-{ 
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * Set the spatial reference for the query.
	 * 
	 * @param outSpatialReference - The spatial reference for the returned geometry. If not specified, the geometry
	 * is returned in the spatial reference of the map.
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{ 
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * The definitions for one or more field-based statistic to be calculated. outStatistics is only supported on layers/tables where 
	 * supportsStatistics is true. If outStatistics is specified the only other query parameters that will be used are 
	 * groupByFieldsForStatistics, orderByFields, text, timeExtent and where.
	 * 
	 * Requires ArcGIS Server service version 10.1 or greater (As of v2.6)
	 * 
	 * @return JsArray<StatisticDefinition>
	 */
	public final native JsArray<StatisticDefinition> getOutStatistics() /*-{
		return this.outStatistics;
	}-*/;
	
	/**
	 * Set the outStatistics parameter.
	 * 
	 * @param outStatistics - The definitions for one or more field-based statistic to be calculated. outStatistics is only 
	 * supported on layers/tables where supportsStatistics is true. If outStatistics is specified the only other query parameters 
	 * that will be used are groupByFieldsForStatistics, orderByFields, text, timeExtent and where. Requires ArcGIS Server service 
	 * version 10.1 or greater (As of v2.6)
	 */
	public final void setOutStatistics(StatisticDefinition[] outStatistics) {
		_setOutStatistics(Util.objectArrayToJSO(outStatistics));
	};
	
	private final native void _setOutStatistics(JavaScriptObject outStatistics) /*-{
		this.outStatistics = outStatistics;
	}-*/;
	
	/**
	 * The 'Shape Comparison Language' string to evaluate. Examples of valid strings are:
	 * 
	 * RELATE(G1,G2,"FFFTTT***)
	 * dim (g1.boundary,g2.boundary) = linear
	 * dim (g1.exterior, g2.boundary)= linear
	 * 
	 * The string describes the spatial relationship to be tested when the spatial relationship is esriSpatialRelRelation
	 * The Shape Comparison Language EDN topic has additional details.
	 * 
	 * @return String
	 */
	public final native String getRelationParam() /*-{
		return this.relationParam;
	}-*/;
	
	/**
	 * Set the relation param for this query.
	 * 
	 * @param relationParam -The 'Shape Comparison Language' string to evaluate. 
	 */
	public final native void setRelationParam(String relationParam) /*-{
		this.relationParam = relationParam;
	}-*/;
	
	/**
	 * If "true", each feature in the FeatureSet includes the geometry. Set to "false" (default) if you do not plan to include
	 * highlighted features on a map since the geometry makes up a significant portion of the response.
	 * 
	 * @return boolean
	 */
	public final native boolean returnGeometry() /*-{ 
		return this.returnGeometry;
	}-*/;
	
	/**
	 * Set the returnGeometry parameter for this query.
	 * 
	 * @param returnGeometry - If "true", each feature in the FeatureSet includes the geometry. Set to "false" (default) if
	 * you do not plan to include highlighted features on a map since the geometry makes up a significant portion of the response.
	 */
	public final native void setReturnGeometry(boolean returnGeometry) /*-{ 
		this.returnGeometry = returnGeometry;
	}-*/;
	
	/**
	 * The spatial relationship to be applied on the input geometry while performing the
	 * query. Default value: SPATIAL_REL_INTERSECTS
	 * 
	 * @return SpatialRelationshipType
	 */
	public final SpatialRelationshipType getSpatialRelationship() {
		String sr =  _getSpatialRelationship();
		for( int i = 0; i < SpatialRelationshipType.values().length; i++ ){
			if( SpatialRelationshipType.values()[i].getValue().contentEquals(sr) ){
				return SpatialRelationshipType.values()[i];
			}
		}
		return SpatialRelationshipType.NOT_SET;
	}
	
	private final native String _getSpatialRelationship() /*-{ 
		return this.spatialRelationship;
	}-*/;
	
	/**
	 * Set the spatial relationship for this query.
	 * 
	 * @param spatialRelationship - The spatial relationship to be applied on the input geometry while performing the query.
	 */
	public final void setSpatialRelationship(SpatialRelationshipType spatialRelationship) {
		_setSpatialRelationship(spatialRelationship.getValue());
	}
	
	private final native void _setSpatialRelationship(String spatialRelationship) /*-{ 
		this.spatialRelationship = spatialRelationship;
	}-*/;
	
	/**
	 * Shorthand for a where clause using "like". The field used is the display field defined in the map document.
	 * You can determine what the display field is for a layer in Services Directory.
	 * 
	 * @return String
	 */
	public final native String getText() /*-{ 
		return this.text;
	}-*/;
	
	/**
	 * Set the text for this query.
	 * 
	 * @param text - Shorthand for a where clause using "like". The field used is the display field defined in the
	 * map document. You can determine what the display field is for a layer in Services Directory.
	 */
	public final native void setText(String text) /*-{ 
		this.text = text;
	}-*/;
	
	/**
	 * Time extent for the query. 
	 * 
	 * @return TimeExtent
	 */
	public final native TimeExtent getTimeExtent() /*-{
		return this.timeExtent;
	}-*/;
	
	/**
	 * Specify a time extent for the query.
	 * 
	 * @param timeExtent - time extent to be used in query.
	 */
	public final native void setTimeExtent(TimeExtent timeExtent) /*-{
		this.timeExtent = timeExtent;
	}-*/;
	
	/**
	 * A where clause for the query. Any legal SQL where clause operating on the fields in the layer is allowed.
	 * 
	 * @return String
	 */
	public final native String getWhere() /*-{ 
		return this.where;
	}-*/;
	
	/**
	 * Set where clause for this query.
	 * 
	 * @param where - A where clause for the query. Any legal SQL where clause operating on the fields in the
	 * layer is allowed.
	 */
	public final native void setWhere(String where) /*-{ 
		this.where = where;
	}-*/;

	
}
