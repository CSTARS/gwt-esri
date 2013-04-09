package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.7
 * The JoinDataSource class defines and provides information about the result of a join operation. 
 * Nested joins are supported and are created by specifying either the leftTableSource or 
 * rightTableSource to be the joined table.
 * 
 * The output type is determined by the leftTableSource. If the leftTableSource is a table then 
 * the resulting join table is a table. If the leftTableSource is a layer then the join result 
 * will be a layer. For the best performance, the left and right table sources should point to 
 * the same workspace and the table keys should be indexed.
 * 
 * @author Justin Merz
 */
public class JoinDataSource extends JavaScriptObject {
	
	protected JoinDataSource() {}
	
	/**
	 * Creates a new JoinDataSource object.
	 * 
	 * @return JoinDataSource
	 */
	public static native JoinDataSource create() /*-{
		return new $wnd.esri.layers.JoinDataSource();
	}-*/;
	
	/**
	 * Creates a new JoinDataSource object.
	 * 
	 * @param jso - JSON object representing the JoinDataSource. 
	 * @return JoinDataSource
	 */
	public static native JoinDataSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.JoinDataSource(jso);
	}-*/;
	
	/**
	 * The type of join that will be performed.
	 * 
	 * Known values: left-outer | left-inner 
	 * TODO: return enum
	 * 
	 * @return String
	 */
	public final native String getJoinType() /*-{
		return this.joinType;
	}-*/; 
	
	/**
	 * Set the join type parameter.
	 * 
	 * @param joinType - The type of join that will be performed.
	 */
	public final native void setJoinType(String joinType) /*-{
		this.joinType = joinType;
	}-*/;
	
	/**
	 * The key field used for the left table source for the join.
	 * 
	 * @return String
	 */
	public final native String getLeftTableKey() /*-{
		return this.leftTableKey;
	}-*/;
	
	/**
	 * Set the left table key.
	 * 
	 * @param leftTableKey - The key field used for the left table source for the join.
	 */
	public final native void setLeftTableKey(String leftTableKey) /*-{
		this.leftTableKey = leftTableKey;
	}-*/;
	
	/**
	 * The data source to be used as the left table for the join operation. Determines 
	 * the output join table type. If the leftTableSource is a table then the output 
	 * is a table. If the leftDataSource is a layer then the resulting join table is a layer.
	 * 
	 * @return LayerMapSource
	 */
	public final native LayerMapSource getLeftTableSourceAsLayerMapSource() /*-{
		return this.leftTableSource;
	}-*/;
	
	/**
	 * The data source to be used as the left table for the join operation. Determines 
	 * the output join table type. If the leftTableSource is a table then the output 
	 * is a table. If the leftDataSource is a layer then the resulting join table is a layer.
	 * 
	 * @return LayerDataSource
	 */
	public final native LayerDataSource getLeftTableSourceAsLayerDataSource() /*-{
		return this.leftTableSource;
	}-*/;
	
	/**
	 * Set the left table source.
	 * 
	 * @param leftTableSource - The data source to be used as the left table for the join 
	 * operation. Determines the output join table type. If the leftTableSource is a table 
	 * then the output is a table. If the leftDataSource is a layer then the resulting join 
	 * table is a layer.
	 */
	public final native void setLeftTableSource(LayerMapSource leftTableSource) /*-{
		this.leftTableSource = leftTableSource;
	}-*/;
	
	/**
	 * Set the left table source.
	 * 
	 * @param leftTableSource - The data source to be used as the left table for the join 
	 * operation. Determines the output join table type. If the leftTableSource is a table 
	 * then the output is a table. If the leftDataSource is a layer then the resulting join 
	 * table is a layer.
	 */
	public final native void setLeftTableSource(LayerDataSource leftTableSource) /*-{
		this.leftTableSource = leftTableSource;
	}-*/;
	
	/**
	 * The key field used for the right table source for the join.
	 * 
	 * @return String
	 */
	public final native String getRightTableKey() /*-{
		return this.rightTableKey;
	}-*/;
	
	/**
	 * Set the right table key.
	 * 
	 * @param rightTableKey - The key field used for the right table source for the join.
	 */
	public final native void setRightTableKey(String rightTableKey) /*-{
		this.rightTableKey = rightTableKey;
	}-*/;
	
	/**
	 * The data source to be used as the right table for the join operation.
	 * 
	 * @return LayerMapSource
	 */
	public final native LayerMapSource getRightTableSourceAsLayerMapSource() /*-{
		return this.rightTableSource;
	}-*/;
	
	/**
	 * The data source to be used as the right table for the join operation.
	 * 
	 * @return LayerDataSource
	 */
	public final native LayerDataSource getRightTableSourceAsLayerDataSource() /*-{
		return this.rightTableSource;
	}-*/;
	
	/**
	 * Set the right table data source.
	 * 
	 * @param rightTableSource - The data source to be used as the right table for the join operation.
	 */
	public final native void setRightTableSource(LayerMapSource rightTableSource) /*-{
		this.rightTableSource = rightTableSource;
	}-*/;
	
	/**
	 * Set the right table data source.
	 * 
	 * @param rightTableSource - The data source to be used as the right table for the join operation.
	 */
	public final native void setRightTableSource(LayerDataSource rightTableSource) /*-{
		this.rightTableSource = rightTableSource;
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
