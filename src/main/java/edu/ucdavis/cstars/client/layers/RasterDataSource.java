package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.7
 * The RasterDataSource class defines and provides information about a file-based raster that resides 
 * in a registered raster workspace. Requires ArcGIS Server 10.1 or greater 
 * 
 * @author Justin Merz
 */
public class RasterDataSource extends JavaScriptObject {
	
	protected RasterDataSource() {}
	
	/**
	 * Creates a new RasterDataSource object.
	 * 
	 * @return RasterDataSource
	 */
	public static native RasterDataSource create() /*-{
		return new $wnd.esri.layers.RasterDataSource();
	}-*/;
	
	/**
	 * Creates a new RasterDataSource object.
	 * 
	 * @param jso - JSON object representing the RasterDataSource. 
	 * @return RasterDataSource
	 */
	public static native RasterDataSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.RasterDataSource(jso);
	}-*/;
	
	/**
	 * The name of a raster that resides in the registered workspace.
	 * 
	 * @return String
	 */
	public final native String getDataSourceName() /*-{
		return this.dataSourceName;
	}-*/;
	
	/**
	 * Set the data source name.
	 * 
	 * @param dataSourceName - The name of a raster that resides in the registered workspace.
	 */
	public final native void setDataSourceName(String dataSourceName) /*-{
		this.dataSourceName = dataSourceName;
	}-*/;
	
	/**
	 * The workspace id for the registered raster workspace.
	 * 
	 * @return String
	 */
	public final native String getWorkspaceId() /*-{
		return this.workspaceId;
	}-*/;
	
	/**
	 * Set the workspace id.
	 * 
	 * @param workspaceId - The workspace id for the registered raster workspace.
	 */
	public final native void setWorkspaceId(String workspaceId) /*-{
		this.workspaceId = workspaceId;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;

}
