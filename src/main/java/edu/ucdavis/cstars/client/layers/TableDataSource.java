package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The TableDataSource class defines and provides information about a table, feature class, or raster that 
 * resides in a registered file geodatabase, SDE or Shapefile workspace. Requires ArcGIS Server 10.1 or greater. 
 * 
 * @author Justin Merz
 */
public class TableDataSource extends JavaScriptObject {
	
	protected TableDataSource() {}
	
	/**
	 * Creates a new TableDataSource object.
	 * 
	 * @return TableDataSource
	 */
	public static native TableDataSource create() /*-{
		return new $wnd.esri.layers.TableDataSource();
	}-*/;
	
	/**
	 * Creates a new TableDataSource object.
	 * 
	 * @param jso - JSON object representing the TableDataSource.
	 * @return TableDataSource
	 */
	public static native TableDataSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.TableDataSource(jso);
	}-*/;
	
	/**
	 * The name of a table, feature class or raster that resides in the registered workspace.
	 * 
	 * @return String
	 */
	public final native String getDataSourceName() /*-{
		return this.dataSourceName;
	}-*/;
	
	/**
	 * Set the data source name parameter.
	 * 
	 * @param dataSourceName - The name of a table, feature class or raster that resides in 
	 * the registered workspace.
	 */
	public final native void setDataSourceName(String dataSourceName) /*-{
		this.dataSourceName = dataSourceName;
	}-*/;
	
	/**
	 * When supported, specify the version in an SDE workspace that the layer will use.
	 * 
	 * @return String
	 */
	public final native String getGdbVersion() /*-{
		return this.gdbVersion;
	}-*/;
	
	/**
	 * Set the gdb version parameter.
	 * 
	 * @param gdbVersion - When supported, specify the version in an SDE workspace that the layer will use.
	 */
	public final native void setGdbVersion(String gdbVersion) /*-{
		this.gdbVersion = gdbVersion;
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
	 * Set the workspace id parameter.
	 * 
	 * @param workspaceId - The workspace id for the registered file geodatabase, SDE or Shapefile workspace.
	 */
	public final native void setWorkspaceId(String workspaceId) /*-{
		this.workspaceId = workspaceId;
	}-*/;

}
