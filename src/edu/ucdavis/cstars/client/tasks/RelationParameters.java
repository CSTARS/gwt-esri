package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Sets the relation and other parameters for Relation operation.
 * 
 * @author Justin Merz
 */
public class RelationParameters extends JavaScriptObject {
	
	public enum SpatialRelationType {
		NOT_SET(""),
		SPATIAL_REL_COINCIDENCE("esriGeometryRelationLineCoincidence"),
		SPATIAL_REL_CROSS("esriGeometryRelationCross"),
		SPATIAL_REL_DISJOINT("esriGeometryRelationDisjoint"),
		SPATIAL_REL_IN("esriGeometryRelationIn"),
		SPATIAL_REL_INTERIORINTERSECTION("esriGeometryRelationInteriorIntersection"),
		SPATIAL_REL_INTERSECTION("esriGeometryRelationIntersection"),
		SPATIAL_REL_LINETOUCH("esriGeometryRelationLineTouch"),
		SPATIAL_REL_OVERLAP("esriGeometryRelationOverlap"),
		SPATIAL_REL_POINTTOUCH("esriGeometryRelationPointTouch"),
		SPATIAL_REL_RELATION("esriGeometryRelationRelation"),
		SPATIAL_REL_TOUCH("esriGeometryRelationTouch"),
		SPATIAL_REL_WITHIN("esriGeometryRelationWithin");
		
		private String val = "";
		SpatialRelationType(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected RelationParameters() {}
	
	/**
	 * Creates a new RelationParameter object.
	 * 
	 * @return Creates a new RelationParameter object.
	 */
	public static native RelationParameters create() /*-{
		return new $wnd.esri.tasks.RelationParameters();
	}-*/;
	
	/**
	 * The first array of geometries to compute the relations. The structure of each geometry in the array is
	 * same as the structure of the json geometry objects returned by the ArcGIS REST API.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getGeometries1() /*-{
		return this.geometries1;
	}-*/;
	
	/**
	 * Set the geometries1 parameter.
	 * 
	 * @param geometries - The first array of geometries to compute the relations. The structure of each geometry
	 * in the array is same as the structure of the json geometry objects returned by the ArcGIS REST API.
	 */
	public final void setGeometries1(Geometry[] geometries) {
		_setGeometries1(Util.objectArrayToJSO(geometries));
	}
	
	private final native void _setGeometries1(JavaScriptObject geometries) /*-{
		this.geometries1 = geometries1;
	}-*/;
	
	/**
	 * The second array of geometries to compute the relations. The structure of each geometry in the array is same
	 * as the structure of the json geometry objects returned by the ArcGIS REST API.
	 * 
	 * @return JsArray<Geometry>
	 */
	public final native JsArray<Geometry> getGeometries2() /*-{
		return this.geometries2;
	}-*/;
	
	/**
	 * Set the geometries2 parameter.
	 * 
	 * @param geometries - The second array of geometries to compute the relations. The structure of each geometry
	 * in the array is same as the structure of the json geometry objects returned by the ArcGIS REST API.
	 */
	public final void setGeometries2(Geometry[] geometries) {
		_setGeometries2(Util.objectArrayToJSO(geometries));
	}
	
	private final native void _setGeometries2(JavaScriptObject geometries) /*-{
		this.geometries2 = geometries2;
	}-*/;
	
	/**
	 * The spatial relationship to be tested between the two input geometry arrays. If the relation is specified as
	 * SPATIAL_REL_RELATION, the relationParam parameter describes the spatial relationship and must be specified.
	 * 
	 * @return SpatialRelationType
	 */
	public final SpatialRelationType getRelation() {
		String r = _getRelation();
		for( int i = 0 ; i < SpatialRelationType.values().length; i++ ){
			if( SpatialRelationType.values()[i].getValue().contentEquals(r) )
				return SpatialRelationType.values()[i];
		}
		return SpatialRelationType.NOT_SET;
	}
	
	private final native String _getRelation() /*-{
		return this.relation;
	}-*/;
	
	/**
	 *  Set the relation parameter.
	 *  
	 * @param relation - The spatial relationship to be tested between the two input geometry arrays. If the
	 * relation is specified as SPATIAL_REL_RELATION, the relationParam parameter describes the spatial
	 * relationship and must be specified.
	 */
	public final void setRelation(SpatialRelationType relation) {
		_setRelation( relation.getValue() );
	}
	
	private final native void _setRelation(String relation) /*-{
		this.relation = relation;
	}-*/;
	
	/**
	 * The 'Shape Comparison Language' string to evaluate.
	 * 
	 * @return String
	 */
	public final native String getRelationParam() /*-{
		return this.relationParam;
	}-*/;
	
	/**
	 * Set the relation parameter.
	 * 
	 * @param relationParam - The 'Shape Comparison Language' string to evaluate.
	 */
	public final native void setRelationParam(String relationParam) /*-{
		this.relationParam = relationParam;
	}-*/;
	

}
