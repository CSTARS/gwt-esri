package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.callback.QueryTaskCallback;
import edu.ucdavis.cstars.client.callback.QueryTaskCountCallback;
import edu.ucdavis.cstars.client.callback.QueryTaskIdsCallback;
import edu.ucdavis.cstars.client.callback.QueryTaskRelationshipCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.QueryTaskCompleteHandler;
import edu.ucdavis.cstars.client.event.QueryTaskCountHandler;
import edu.ucdavis.cstars.client.event.QueryTaskIdsHandler;
import edu.ucdavis.cstars.client.event.QueryTaskRelationshipHandler;
import edu.ucdavis.cstars.client.layers.LayerDataSource;
import edu.ucdavis.cstars.client.layers.LayerMapSource;

/**
 * Executes a query operation on a layer resource of a map service exposed by the ArcGIS Server REST API.
 * 
 * @author Justin Merz
 */
public class QueryTask extends JavaScriptObject {

	protected QueryTask() {}
	
	/**
	 * Creates a new QueryTask object used to execute a query on the layer resource identified by the url
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a layer in a service
	 * @return QueryTask
	 */
	public static native QueryTask create(String url) /*-{
		return new $wnd.esri.tasks.QueryTask(url);
	}-*/;
	
	/**
	 * Creates a new QueryTask object used to execute a query on the layer resource identified by the url
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a layer in a service
	 * @param options - Optional parameters.
	 * @return QueryTask
	 */
	public static native QueryTask create(String url, Options options) /*-{
		return new $wnd.esri.tasks.QueryTask(url, options);
	}-*/;
	
	/**
	 * URL to the ArcGIS Server REST resource that represents a map service layer. 
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. The result is returned as a FeatureSet. If the
	 * query is successful, the user-specified callback function is invoked with the result. A FeatureSet
	 * contains an array of Graphic features, which can be added to the map using Map.graphics.add().
	 * This array will not be populated if no results are found.
	 * 
	 * @param query - Specifies the attributes and spatial filter of the query.
	 * @param callback - handler to be fired upon server response.
	 * @return Deferred
	 */
	public final native Deferred execute(Query query, QueryTaskCallback callback) /*-{
		this.execute(query, 
			function(featureSet) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskCallback::onComplete(Ledu/ucdavis/cstars/client/tasks/FeatureSet;)(featureSet);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. The result is returned as a FeatureSet. If the
	 * query is successful, the user-specified callback function is invoked with the result. A FeatureSet
	 * contains an array of Graphic features, which can be added to the map using Map.graphics.add().
	 * This array will not be populated if no results are found.
	 * 
	 * @param query - Specifies the attributes and spatial filter of the query.
	 * @return Deferred
	 */
	public final native Deferred execute(Query query) /*-{		
		return this.execute(query);
	}-*/;
	
	/**
	 * Get a count of the number of features that satisfy the input query. Valid only for layers published
	 * using ArcGIS Server 10 SP1 or greater. Layers published with earlier versions of ArcGIS Server
	 * return an error to the error callback.
	 * 
	 * @param query - Specify the input query object.
	 * @param callback - handler to be fired upon server response.
	 * @return Deferred
	 */
	public final native Deferred executeForCount(Query query, QueryTaskCountCallback callback) /*-{		
		return this.executeForCount(query, 
			function(count) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskCountCallback::onExecuteForCountComplete(I)(count);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskCountCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Get a count of the number of features that satisfy the input query. Valid only for layers published
	 * using ArcGIS Server 10 SP1 or greater. Layers published with earlier versions of ArcGIS Server
	 * return an error to the error callback.
	 * 
	 * @param query - Specify the input query object.
	 * @return Deferred
	 */
	public final native Deferred executeForCount(Query query) /*-{		
		return this.executeForCount(query);
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. The result is returned as an array of ints.
	 * 
	 * @param parameters - Specifies the attributes and spatial filter of the query.
	 * @param callback -  handler to be fired upon server response.
	 * @return Deferred
	 */
	public final native Deferred executeForIds(Query parameters, QueryTaskIdsCallback callback) /*-{
		return this.executeForIds(parameters,
			function(ids) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskIdsCallback::onExecuteForIdsComplete(Lcom/google/gwt/core/client/JsArrayInteger;)(ids);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskIdsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. The result is returned as an array of ints.
	 * 
	 * @param parameters - Specifies the attributes and spatial filter of the query.
	 * @return Deferred
	 */
	public final native Deferred executeForIds(Query parameters) /*-{
		return this.executeForIds(parameters);
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. 
	 * 
	 * @param parameters - Specifies the attributes and spatial filter of the query.
	 * @param callback -  handler to be fired upon server response.
	 * @return Deferred
	 */
	public final native Deferred executeRelationshipQuery(Query parameters, QueryTaskRelationshipCallback callback) /*-{
		return this.executeRelationshipQuery(parameters,
			function(relatedFeatureSets) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskRelationshipCallback::onExecuteForIdsComplete(Ledu/ucdavis/cstars/client/event/QueryTaskRelationshipHandler$RelatedFeatureSets;)(relatedFeatureSets);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryTaskRelationshipCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Executes a Query against an ArcGIS Server map layer. 
	 * 
	 * @param parameters - Specifies the attributes and spatial filter of the query.
	 * @return Deferred
	 */
	public final native Deferred executeRelationshipQuery(Query parameters) /*-{
		return this.executeRelationshipQuery(parameters);
	}-*/;
	
	/**
	 * Add handler for when complete event fires.
	 * 
	 * @param handler - Fires when the query operation is complete.
	 */
	public final native void addCompleteHandler(QueryTaskCompleteHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this, "onComplete",
		 	function(featureSet) {
		 		handler.@edu.ucdavis.cstars.client.event.QueryTaskCompleteHandler::onComplete(Ledu/ucdavis/cstars/client/tasks/FeatureSet;)(featureSet);
			}
		);
	}-*/;
	
	/**
	 *  Add handler for when error event fires.
	 * 
	 * @param handler - Fires when an error occurs when executing the task.
	 */
	public final native void addErrorHandler(ErrorHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this, "onError",
		 	function(error) {
		 		handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;

	/**
	 * Add handler for when count complete event fires.
	 * 
	 * @param handler - Fires when the query for the count is complete. This event is only available
	 * for layers published using ArcGIS Server 10 SP1 or later. 
	 */
	public final native void addExecuteForCountCompleteHandler(QueryTaskCountHandler handler)/*-{
		$wnd.dojo.connect(
		 	this, "onExecuteForCountComplete",
		 	function(count) {
		 		handler.@edu.ucdavis.cstars.client.event.QueryTaskCountHandler::onExecuteForCountComplete(I)(count);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when execute for ids complete event fires.
	 * 
	 * @param handler - Fires when the query on IDs is complete.
	 */
	public final native void addExecuteForIdsCompleteHandler(QueryTaskIdsHandler handler)/*-{
		$wnd.dojo.connect(
		 	this, "onExecuteForIdsComplete",
		 	function(featrueIds) {
		 		handler.@edu.ucdavis.cstars.client.event.QueryTaskIdsHandler::onExecuteForIdsComplete(Lcom/google/gwt/core/client/JsArrayInteger;)(featureIds);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when execute relationship query complete event fires.
	 * 
	 * @param handler - Fires when the executeRelationshipQuery is complete
	 */
	public final native void addExecuteRelationshipQueryCompleteHandler(QueryTaskRelationshipHandler handler)/*-{
		$wnd.dojo.connect(
		 	this, "onExecuteRelationshipQueryComplete",
		 	function(relatedFeatureSets) {
		 		handler.@edu.ucdavis.cstars.client.event.QueryTaskRelationshipHandler::onExecuteForIdsComplete(Ledu/ucdavis/cstars/client/event/QueryTaskRelationshipHandler$RelatedFeatureSets;)(relatedFeatureSets);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * Set the gdbVersion.
		 * 
		 * @param gdbVersion - Specify the geodatabase version to display. (As of v2.7). Requires ArcGIS Server service 10.1 or greater
		 */
		public final native void setGbdVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
		/**
		 * Set the source parameter.
		 * 
		 * @param source - The dynamic layer. Required when the QueryTask url is set to 'http://<map service url>/dynamicLayer'.
		 */
		public final native void setSource(LayerMapSource source) /*-{
			this["source"] = source;
		}-*/;
		
		/**
		 * Set the source parameter.
		 * 
		 * @param source - The table source. Required when the QueryTask url is set to 'http://<map service url>/dynamicLayer'.
		 */
		public final native void setSource(LayerDataSource source) /*-{
			this["source"] = source;
		}-*/;                                                            
		
	}
	
}
