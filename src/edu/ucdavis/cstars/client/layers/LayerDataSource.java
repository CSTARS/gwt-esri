package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.7
 * The LayerDataSource class defines and provides information about a layer created on the fly from a 
 * data source. Requires ArcGIS Server 10.1 or greater. 
 * 
 * @author Justin Merz
 */
public class LayerDataSource extends JavaScriptObject {

	protected LayerDataSource() {}
	
	/**
	 * Creates a new LayerDataSource object.
	 * 
	 * @return LayerDataSource
	 */
	public static native LayerDataSource create() /*-{
		return new $wnd.esri.layers.LayerDataSource();
	}-*/;
	
	/**
	 * Creates a new LayerDataSource object.
	 * 
	 * @param jso - JSON object representing the LayerDataSource. 
	 * @return LayerDataSource
	 */
	public static native LayerDataSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.LayerDataSource(jso);
	}-*/;
	
	/**
	 * The data source used to create the a dynamic data layer on the fly. 
	 * 
	 * @return TableDataSource
	 */
	public final native TableDataSource getDataSourceAsTableDataSource() /*-{
		return this.dataSource;
	}-*/;
	
	/**
	 * The data source used to create the a dynamic data layer on the fly. 
	 * 
	 * @return QueryDataSource
	 */
	public final native QueryDataSource getDataSourceAsQueryDataSource() /*-{
		return this.dataSource;
	}-*/;
	
	/**
	 * The data source used to create the a dynamic data layer on the fly. 
	 * 
	 * @return JoinDataSource
	 */
	public final native JoinDataSource getDataSourceAsJoinDataSource() /*-{
		return this.dataSource;
	}-*/;
	
	/**
	 * The data source used to create the a dynamic data layer on the fly. 
	 * 
	 * @return RasterDataSource
	 */
	public final native RasterDataSource getDataSourceAsRasterDataSource() /*-{
		return this.dataSource;
	}-*/;
	
	/**
	 * Set the data source.
	 * 
	 * @param tableDataSource - The data source used to create the a dynamic data layer on the fly. 
	 */
	public final native void setDataSource(TableDataSource tableDataSource) /*-{
		this.dataSource = tableDataSource;
	}-*/;
	
	/**
	 * Set the data source.
	 * 
	 * @param queryDataSource - The data source used to create the a dynamic data layer on the fly. 
	 */
	public final native void setDataSource(QueryDataSource queryDataSource) /*-{
		this.dataSource = queryDataSource;
	}-*/;
	
	/**
	 * Set the data source.
	 * 
	 * @param joinDataSource - The data source used to create the a dynamic data layer on the fly. 
	 */
	public final native void setDataSource(JoinDataSource joinDataSource) /*-{
		this.dataSource = joinDataSource;
	}-*/;
	
	/**
	 * Set the data source.
	 * 
	 * @param rasterDataSource - The data source used to create the a dynamic data layer on the fly. 
	 */
	public final native void setDataSource(RasterDataSource rasterDataSource) /*-{
		this.dataSource = rasterDataSource;
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
