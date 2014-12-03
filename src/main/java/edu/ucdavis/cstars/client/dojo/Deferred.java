package edu.ucdavis.cstars.client.dojo;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Encapsulates a sequence of callbacks in response to a value that may not yet be available.
 * This is modeled after the Deferred class from Twisted <http://twistedmatrix.com>.
 * 
 * @author Justin Merz
 */
public class Deferred extends JavaScriptObject {

	protected Deferred() {};
	
	/**
	 * Cancels a Deferred that has not yet received a value, or is waiting on another Deferred as its value.
	 */
	public final native void cancel() /*-{
		this.cancel();
	}-*/;
	
}
