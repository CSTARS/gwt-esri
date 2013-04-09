package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.tasks.GPMessage;
import edu.ucdavis.cstars.client.tasks.ParameterValue;

/**
 * Fires when a synchronous GP task is completed.
 * 
 * @author Justin Merz
 */
public interface GeoprocessorExecuteHandler {

	/**
	 * 
	 * @param results - An array of ParameterValue objects that gives access to the result parameters and the task execution messages.
	 * @param message - An array of GPMessage that has the type and description.
	 */
	public void onExecuteComplete(JsArray<ParameterValue> results, GPMessage message);
	
}
