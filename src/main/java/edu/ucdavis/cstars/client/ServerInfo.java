package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class contains information about an ArcGIS Server and its token endpoint.
 * 
 * @author Justin Merz
 */
public class ServerInfo extends JavaScriptObject {

	protected ServerInfo() {}
	
	/**
	 * Server URL in the following format: 
	 *   scheme://host[:port]
	 * 
	 * @return String
	 */
	public final native String getServer() /*-{
		return this.server;
	}-*/;

	/**
	 * The token service URL used to generate tokens for the secured resources on the server.
	 * 
	 * @return String
	 */
	public final native String getTokenServiceUrl() /*-{
		return this.tokenServiceUrl;
	}-*/;
	
}
