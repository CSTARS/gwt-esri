package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Geometry.GeometryType;

/**
 * Class added v2.7 
 * The QueryDataSource class defines and provides information about a layer or table that is defined by a SQL 
 * query. The geometry storage format determines the capabilities of the QueryDataSource. If the data source 
 * stores the geometry in the database native format the return value is a layer that supports all operations 
 * supported by a dynamic layer. If the data source stores geometry in a non-native format the result is a table 
 * that can be used to perform query operations. 
 * 
 * @author Justin Merz
 */
public class QueryDataSource extends JavaScriptObject {
	
	protected QueryDataSource() {}
	
	/**
	 * Creates a new QueryDataSource object.
	 * 
	 * @return QueryDataSource
	 */
	public static native QueryDataSource create() /*-{
		return new $wnd.esri.layers.QueryDataSource();
	}-*/;
	
	/**
	 * Creates a new QueryDataSource object.
	 * 
	 * @param jso - JSON object representing the QueryDataSource. 
	 * @return QueryDataSource
	 */
	public static native QueryDataSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.QueryDataSource(jso);
	}-*/;

	/**
	 * The geometry type of the data source. Required if the specified data source has a geometry column.
	 * 
	 * @return GeometryType
	 */
	public final GeometryType getGeometryType() {
		return GeometryType.gwtValueOf(_getGeometryType());
	}
	
	private final native String _getGeometryType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Set the geometry type.
	 * 
	 * @param geometryType - The geometry type of the data source. Required if the specified data source 
	 * has a geometry column.
	 */
	public final void setGeometryType(GeometryType geometryType) {
		_setGeometryType(geometryType.getValue());
	}
	
	private final native void _setGeometryType(String geometryType) /*-{
		this.geometryType = geometryType;
	}-*/;
	
	/**
	 * An array of field names that define a unique identifier for the feature. The combiniation of one 
	 * or more fields will be used to generate a unique identifier for the feature.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getOidFields() /*-{
		return this.oidFields;
	}-*/;
	
	/**
	 * Set the oid fields.
	 * 
	 * @param oidFields - An array of field names that define a unique identifier for the feature. The 
	 * combiniation of one or more fields will be used to generate a unique identifier for the feature.
	 */
	public final void setOidFields(String[] oidFields) {
		_setOidFields(Util.stringArrayToJSO(oidFields));
	}
	
	private final native void _setOidFields(JavaScriptObject oidFields) /*-{
		this.oidFields = oidFields;
	}-*/;
	
	/**
	 * The SQL query string that defines the data source output.
	 * 
	 * @return String
	 */
	public final native String getQuery() /*-{
		return this.query;
	}-*/;
	
	/**
	 * Set the sql query.
	 * 
	 * @param query - The SQL query string that defines the data source output.
	 */
	public final native void setQuery(String query) /*-{
		this.query = query;
	}-*/;
	
	/**
	 * The spatial reference for the data source. Required if the specified data source has a geometry column.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	/**
	 * Set the spatial reference.
	 * 
	 * @param spatialReference - The spatial reference for the data source. Required if the specified data 
	 * source has a geometry column.
	 */
	public final native void setSpatialReference(SpatialReference spatialReference) /*-{
		this.spatialReference = spatialReference;
	}-*/;
	
	/**
	 * The workspace id for the registered file geodatabase, SDE or Shapefile workspace.
	 * 
	 * @return String
	 */
	public final native String getWorkspaceId() /*-{
		return this.workspaceId;
	}-*/;
	
	/**
	 * Set the workspace id.
	 * 
	 * @param workspaceId - The workspace id for the registered file geodatabase, SDE or Shapefile workspace.
	 */
	public final native void setWorkspaceId(String workspaceId) /*-{
		this.workspaceId = workspaceId;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getJson() /*-{
		return this.toJson();
	}-*/;
	
}
