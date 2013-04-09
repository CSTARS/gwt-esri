package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Geometry;

/**
 * Possible input for RouteParameters.stops or RouteParameters.barriers.
 * 
 * @author Justin Merz
 */
public class DataLayer extends JavaScriptObject {
	
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
		SPATIAL_REL_WITHIN("esriSpatialRelWithin");
		
		private String val = "";
		SpatialRelationshipType(String value) {
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected DataLayer() {}
	
	/**
	 * Creates a new DataLayer object.
	 * 
	 * @return DataLayer
	 */
	public static native DataLayer create() /*-{
		return new $wnd.esri.tasks.DataLayer();
	}-*/;
	
	/**
	 * The geometry to apply to the spatial filter. The spatial relationship as specified by spatialRelationship
	 * is applied to this geometry while performing the query.
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry() /*-{
		return this.Geometry;
	}-*/;
	
	/**
	 * Set the geometry parameter.
	 * 
	 * @param geometry - The geometry to apply to the spatial filter. The spatial relationship as specified by
	 * spatialRelationship is applied to this geometry while performing the query.
	 */
	public final native void setGeometry(Geometry geometry) /*-{
		this.geometry = geometry;
	}-*/;
	
	/**
	 * The name of the data layer in the map service that is being referenced.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * Set the name parameter.
	 * 
	 * @param name - The name of the data layer in the map service that is being referenced.
	 */
	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;
	
	/**
	 * The spatial relationship to be applied on the input geometry while performing the query.
	 * 
	 * @return SpatialRelationshipType
	 */
	public final SpatialRelationshipType getSpatialRelationship() {
		String sr = _getSpatialRelationship();
		for( int i = 0 ; i < SpatialRelationshipType.values().length; i++ ){
			if( SpatialRelationshipType.values()[i].getValue().contentEquals(sr) )
				return SpatialRelationshipType.values()[i];
		}
		return SpatialRelationshipType.NOT_SET;
	}
	
	private final native String _getSpatialRelationship() /*-{
		return this.spatialRelationship;
	}-*/;
	
	/**
	 * Set the spatial relationship
	 *  
	 * @param spatialRelationship - The spatial relationship to be applied on the input geometry while performing the query.
	 */
	public final void setSpatialRelationship(SpatialRelationshipType spatialRelationship){
		_setSpatialRelationship( spatialRelationship.getValue() );
	}
	
	private final native void  _setSpatialRelationship(String spatialRelationship) /*-{
		this.spatialRelationship = spatialRelationship;
	}-*/;
	 	
	/**
	 * A where clause for the query. Any legal SQL where clause operating on the fields in the layer is allowed,
	 * for example: query.setWhere("POP2000 > 350000").
	 * 
	 * @return String
	 */
	public final native String getWhere() /*-{
		return this.where;
	}-*/;
	
	/**
	 * Set the where parameter.
	 * 
	 * @param where - A where clause for the query. Any legal SQL where clause operating on the fields in the layer is allowed,
	 * for example: query.setWhere("POP2000 > 350000").
	 */
	public final native void setWhere(String where) /*-{
		this.where = where;
	}-*/;

}
