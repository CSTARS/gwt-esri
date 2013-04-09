package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Represents information pertaining to the execution of an asynchronous GP task on the server.
 * 
 * @author Justin Merz
 */
public class JobInfo extends JavaScriptObject {
	
	public static enum StatusType {
		STATUS_CANCELLED("esriJobCancelled"),
		STATUS_CANCELLING("esriJobCancelling"),
		STATUS_DELETED("esriJobDeleted"),
		STATUS_DELETING("esriJobDeleting"),
		STATUS_EXECUTING("esriJobExecuting"),
		STATUS_FAILED("esriJobFailed"),
		STATUS_NEW("esriJobNew"),
		STATUS_SUBMITTED("esriJobSubmitted"),
		STATUS_SUCCEEDED("esriJobSucceeded"),
		STATUS_TIMED_OUT("esriJobTimedOut"),
		STATUS_WAITING("esriJobWaiting");
		
		private String val = "";
		StatusType(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected JobInfo() {}
	
	/**
	 * The unique job ID assigned by ArcGIS Server.
	 * 
	 * @return String
	 */
	public final native String getJobId() /*-{
		return this.jobId;
	}-*/;
	
	/**
	 * The job status.
	 * 
	 * @return StatusType
	 */
	public final StatusType getJobStatus() {
		String js = _getJobStatus();
		for( int i = 0 ; i < StatusType.values().length; i++ ){
			if( StatusType.values()[i].getValue().contentEquals(js) )
				return StatusType.values()[i];
		}
		return null;
	}
	
	private final native String _getJobStatus() /*-{
		return this.jobStatus;
	}-*/;
	
	/**
	 * An array of messages that include the message type and a description.
	 * 
	 * @return JsArray<GPMessage>
	 */
	public final native JsArray<GPMessage> getMessages() /*-{
		return this.messages;
	}-*/;

}
