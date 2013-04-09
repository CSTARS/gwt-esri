package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.JSObject;
import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.callback.CheckJobStatusCallback;
import edu.ucdavis.cstars.client.callback.GeoprocessorExecuteCallback;
import edu.ucdavis.cstars.client.callback.GetResultDataCallback;
import edu.ucdavis.cstars.client.callback.GetResultImageCallback;
import edu.ucdavis.cstars.client.callback.GetResultImageLayerCallback;
import edu.ucdavis.cstars.client.callback.SubmitJobCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.CheckJobStatusHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GeoprocessorExecuteHandler;
import edu.ucdavis.cstars.client.event.GeoprocessorJobHandler;
import edu.ucdavis.cstars.client.event.GetResultDataHandler;
import edu.ucdavis.cstars.client.event.GetResultImageHandler;
import edu.ucdavis.cstars.client.event.GetResultImageLayerHandler;
import edu.ucdavis.cstars.client.layers.ImageParameters;

/**
 * Represents a GP Task resource exposed by the ArcGIS Server REST API. A GP Task resource represents a single task in a GP service published using the
 * ArcGIS Server and it supports one of the following operations:
 * 
 *    "execute" - performed on a GP Task resource when the execution type is synchronous.
 *    "submitJob" - performed on an asynchronous GP Task resource.
 * 
 * @author Justin Merz
 */
public class Geoprocessor extends JavaScriptObject {

	protected Geoprocessor() {}
	
	/**
	 * Creates a new Geoprocessor object that represents the GP Task identifed by a URL.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a geoprocessing service.
	 * @return Geoprocessor
	 */
	public static native Geoprocessor create(String url) /*-{
		return new $wnd.esri.tasks.Geoprocessor(url);
	}-*/;
	
	/**
	 * 
	 * @deprecated - Use outSpatialReference instead.
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutputSpatialReference() /*-{
		return this.outputSpatialReference;
	}-*/;
	
	/**
	 * The spatial reference of the output geometries. If not specified, the output geometries are in the spatial reference of the input
	 * geometries. If processSpatialReferencew is specified and outSpatialReference is not specified, the output geometries are in the
	 * spatial reference of the process spatial reference.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * The spatial reference that the model will use to perform geometry operations. If processSpatialReference is specified and outputSpatialReference is not
	 * specified, the output geometries are in the spatial reference of the process spatial reference. 
	 * 
	 * @return  SpatialReference
	 */
	public final native SpatialReference getProcessSpatialReference() /*-{
		return this.processSpatialReference;
	}-*/;
	
	/**
	 * The time interval in milliseconds between each job status request sent to an asynchronous GP task. Default value: 1000
	 * 
	 * @return int
	 */
	public final native int getUpdateDelay() /*-{
		return this.updateDelay;
	}-*/;
	
	/**
	 * ArcGIS Server Rest API endpoint to the resource that receives the geoprocessing request.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Cancels the periodic job status updates initiated automatically when submitJob() is invoked for the job identified by jobId. You can still obtain the status of
	 * this job by calling the checkStatus() method at your own discretion.
	 * 
	 * @param jobId - A string that uniquely identifies the job for which the job updates are cancelled.
	 */
	public final native void cancelJobStatusUpdates(String jobId) /*-{
		this.cancelJobStatusUpdates(jobId);
	}-*/;
	
	/**
	 * Sends a request to the GP Task for the current state of the job identified by jobId. Upon receiving the response, the onStatusUpdate event is
	 * fired and the optional callback function is invoked.
	 * 
	 * @param jobId - A string that uniquely identifies a job on the server. It is created when a job is submitted for execution and later used to check its status
	 * and retrieve the results.
	 * @param callback - The function to call when the method has completed. 
	 */
	public final native void checkJobStatus(String jobId, CheckJobStatusCallback callback) /*-{		
		this.checkJobStatus(jobId, 
			function(status) {
				callback.@edu.ucdavis.cstars.client.callback.CheckJobStatusCallback::onStatusUpdate(Ledu/ucdavis/cstars/client/tasks/JobInfo;)(status);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.CheckJobStatusCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the GP Task for the current state of the job identified by jobId. Upon receiving the response, the onStatusUpdate event is
	 * fired and the optional callback function is invoked.
	 * 
	 * @param jobId - A string that uniquely identifies a job on the server. It is created when a job is submitted for execution and later used to check its status
	 * and retrieve the results.
	 */
	public final native void checkJobStatus(String jobId) /*-{		
		this.checkJobStatus(jobId);
	}-*/;
	
	/**
	 * Sends a request to the server to execute a synchronous GP task. On completion, the onExecuteComplete event is fired and the optional callback function is invoked.
	 * 
	 * @param params - The inputParameters argument specifies the input parameters accepted by the task and their corresponding values.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred execute(JSObject params, GeoprocessorExecuteCallback callback) /*-{
		return this.execute(params, 
			function(params, message) {
				callback.@edu.ucdavis.cstars.client.callback.GeoprocessorExecuteCallback::onExecuteComplete(Lcom/google/gwt/core/client/JsArray;Ledu/ucdavis/cstars/client/tasks/GPMessage;)(params, message);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GeoprocessorExecuteCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;

	/**
	 * Sends a request to the server to execute a synchronous GP task.
	 * 
	 * @param params - The inputParameters argument specifies the input parameters accepted by the task and their corresponding values.
	 * @return Deferred
	 */
	public final native Deferred execute(JSObject params) /*-{		
		return this.execute(params);
	}-*/;
	
	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred getResultData(String jobId, String parameterName, GetResultDataCallback callback) /*-{		
		return this.getResultData(jobId, parameterName, 
			function(result) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultDataCallback::onGetResultDataComplete(Ledu/ucdavis/cstars/client/tasks/ParameterValue;)(result);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultDataCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @return Deferred
	 */
	public final native Deferred getResultData(String jobId, String parameterName) /*-{		
		return this.getResultData(jobId, parameterName);
	}-*/;
	
	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName as an image.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @param parameters - Specifies the properties of the result image.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred getResultImage(String jobId, String parameterName, ImageParameters parameters, GetResultImageCallback callback) /*-{		
		return this.getResultImage(jobId, parameterName, parameters,
			function(mapImage) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultImageCallback::onGetResultImageComplete(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultImageCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName as an image.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @param parameters - Specifies the properties of the result image.
	 * @return Deferred
	 */
	public final native Deferred getResultImage(String jobId, String parameterName, ImageParameters parameters) /*-{		
		return this.getResultImage(jobId, parameterName, parameters);
	}-*/;

	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName as an ArcGISDynamicMapServiceLayer.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @param parameters - Contains various options that can be specified when generating a dynamic map image.
	 * @param callback - The function to call when the method has completed.
	 */
	public final native void getResultImageLayer(String jobId, String parameterName, ImageParameters parameters, GetResultImageLayerCallback callback) /*-{		
		this.getResultImageLayer(jobId, parameterName, parameters,
			function(layer) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultImageLayerCallback::onGetResultImageLayerComplete(Ledu/ucdavis/cstars/client/layers/ArcGISDynamicMapServiceLayer;)(layer);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GetResultImageLayerCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Sends a request to the GP Task to get the task result identified by jobId and resultParameterName as an ArcGISDynamicMapServiceLayer.
	 * 
	 * @param jobId - The jobId returned from JobInfo.
	 * @param parameterName - The name of the result parameter as defined in Services Directory.
	 * @param parameters - Contains various options that can be specified when generating a dynamic map image.
	 */
	public final native void getResultImageLayer(String jobId, String parameterName, ImageParameters parameters) /*-{		
		this.getResultImageLayer(jobId, parameterName, parameters);
	}-*/;
	
	/**
	 * 
	 * @deprecated - Use outSpatialReference instead.
	 * @param spatialReference
	 */
	public final native void setOutputSpatialReference(SpatialReference spatialReference) /*-{
		this.setOutputSpatialReference(spatialReference);
	}-*/;
	
	/**
	 * Set the outSpatialReference parameter.
	 * 
	 * @param outSpatialReference - The spatial reference of the output geometries. If not specified, the output geometries are in the spatial reference of the input
	 * geometries. If processSpatialReferencew is specified and outSpatialReference is not specified, the output geometries are in the
	 * spatial reference of the process spatial reference.
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * Set the processSpatialReference parameter.
	 * 
	 * @param processSpatialReference - The spatial reference that the model will use to perform geometry operations. If processSpatialReference is specified and outputSpatialReference is not
	 * specified, the output geometries are in the spatial reference of the process spatial reference. 
	 */
	public final native void setProcessSpatialReference(SpatialReference processSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * Sets the time interval in milliseconds between each job status request sent to an asynchronous GP task.
	 * 
	 * @param delay - The value in milliseconds. One second equals 1000 milliseconds.
	 */
	public final native void setUpdateDelay(int delay) /*-{
		this.setUpdateDelay(delay);
	}-*/;

	/**
	 * Submits a job to the server for asynchronous processing by the GP task. Once the job is submitted and until it is completed, the
	 * onStatusUpdate event is fired and the optional statusCallback() function is invoked at regular intervals, the duration of which is
	 * specified by the updateDelay property. Upon completion of the job, the onJobComplete event is fired and the callback
	 * function is invoked. 
	 * 
	 * The task execution results can be retrieved using getResultData(), getResultImage() or getResultImageLayer() methods.
	 * 
	 * @param inputParameters - The inputParameters argument specifies the input parameters accepted by the task and their
	 * corresponding values. These input parameters are listed in the parameters field of the associated GP Task resource. 
	 * @param callback - The function to call when the method has completed and on update of status.
	 */
	public final native void submitJob(JSObject inputParameters, SubmitJobCallback callback) /*-{
		this.submitJob(inputParameters,
			function(jobInfo) {
				callback.@edu.ucdavis.cstars.client.callback.SubmitJobCallback::onJobComplete(Ledu/ucdavis/cstars/client/tasks/JobInfo;)(jobInfo);
			},
			function(jobInfo) {
				callback.@edu.ucdavis.cstars.client.callback.SubmitJobCallback::onStatusUpdate(Ledu/ucdavis/cstars/client/tasks/JobInfo;)(jobInfo);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.SubmitJobCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Submits a job to the server for asynchronous processing by the GP task. Once the job is submitted and until it is completed, the
	 * onStatusUpdate event is fired and the optional statusCallback() function is invoked at regular intervals, the duration of which is
	 * specified by the updateDelay property. Upon completion of the job, the onJobComplete event is fired and the callback
	 * function is invoked. 
	 * 
	 * The task execution results can be retrieved using getResultData(), getResultImage() or getResultImageLayer() methods.
	 * 
	 * @param inputParameters - The inputParameters argument specifies the input parameters accepted by the task and their
	 * corresponding values. These input parameters are listed in the parameters field of the associated GP Task resource. 
	 */
	public final native void submitJob(JSObject inputParameters) /*-{		
		this.submitJob(inputParameters);
	}-*/;
	
	/**
	 * Add event handler for errors.
	 * 
	 * @param handler - Fires when an error occurs when executing the task.
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for execute.
	 * 
	 * @param handler - Fires when a synchronous GP task is completed.
	 */
	public final native void addExecuteHandler(GeoprocessorExecuteHandler handler) /*-{
		$wnd.dojo.connect(this, "onExecuteComplete",
			function(results, messages) {
				handler.@edu.ucdavis.cstars.client.event.GeoprocessorExecuteHandler::onExecuteComplete(Lcom/google/gwt/core/client/JsArray;Ledu/ucdavis/cstars/client/tasks/GPMessage;)(results, messages);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for getResultDataHandler.
	 * 
	 * @param handler - Fires when the result of an asynchronous GP task execution is available.
	 */
	public final native void addGetResultDataHandler(GetResultDataHandler handler) /*-{
		$wnd.dojo.connect(this, "onGetResultDataComplete",
			function(result) {
				handler.@edu.ucdavis.cstars.client.event.GetResultDataHandler::onGetResultDataComplete(Ledu/ucdavis/cstars/client/tasks/ParameterValue;)(result);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for getResultImage 
	 * 
	 * @param handler - Fires when a map image is generated by invoking the getResultImage() method.
	 */
	public final native void addGetResultImageHandler(GetResultImageHandler handler) /*-{
		$wnd.dojo.connect(this, "onGetResultImageComplete",
			function(mapImage) {
				handler.@edu.ucdavis.cstars.client.event.GetResultImageHandler::onGetResultImageComplete(Ledu/ucdavis/cstars/client/layers/MapImage;)(mapImage);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for getResultImageLayer
	 * 
	 * @param handler - Fires when getResultImageLayer() has completed.
	 */
	public final native void addGetResultImageLayerHandler(GetResultImageLayerHandler handler) /*-{
		$wnd.dojo.connect(this, "onGetResultImageLayerComplete",
			function(layer) {
				handler.@edu.ucdavis.cstars.client.event.GetResultImageLayerHandler::onGetResultImageLayerComplete(Ledu/ucdavis/cstars/client/layers/ArcGISDynamicMapServiceLayer;)(layer);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for when job is complete.
	 * 
	 * @param handler - Fires when an asynchronous GP task using submitJob is complete.
	 */
	public final native void addJobHandler(GeoprocessorJobHandler handler) /*-{
		$wnd.dojo.connect(this, "onJobComplete",
			function(status) {
				handler.@edu.ucdavis.cstars.client.event.GeoprocessorJobHandler::onJobComplete(Ledu/ucdavis/cstars/client/tasks/JobInfo;)(status);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for checkJobStatus.
	 * 
	 * @param handler - Fires when a job status update is available.
	 */
	public final native void addCheckJobStatusHandler(CheckJobStatusHandler handler) /*-{
		$wnd.dojo.connect(this, "onStatusUpdate",
			function(status) {
				handler.@edu.ucdavis.cstars.client.event.CheckJobStatusHandler::onStatusUpdate(Ledu/ucdavis/cstars/client/tasks/JobInfo;)(status);
			}
		);
	}-*/;
	
}
