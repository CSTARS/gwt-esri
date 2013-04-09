package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.RedirectionHandler;

/**
 * This class provides the framework and helper methods required to implement a solution for managing user credentials for the following resources:
 *   ArcGIS Server resources secured using token-based authentication. Note that only ArcGIS Server versions 10 SP 1 and greater are supported.
 *   Secured ArcGIS.com resources (i.e. web maps).
 *   
 *   This class is not typically used by itself and does not include a user interface to obtain user input. The esri.IdentityManager class provides a complete 
 *   out-of-the-box implementation.
 * 
 * @author Justin Merz
 */
public class IdentityManagerBase extends JavaScriptObject {
	
	protected IdentityManagerBase() {}
	
	/**
	 * The suggested lifetime of the token in minutes. Default is 60 minutes.
	 * 
	 * @return int
	 */
	public final native int getTokenValidity() /*-{
		return this.tokenValidity;
	}-*/;

	/**
	 * Returns the credential for the resource identified by the specified url. Optionally you can provide a userId to find credentials for a specific user.
	 * 
	 * @param url - The url to a server.
	 * @param userId - The userId for which you want to obtain credentials.
	 * @return Credential
	 */
	public final native Credential findCredential(String url, String userId) /*-{
		return this.findCredential(url, userId);
	}-*/;
	
	/**
	 * Returns the credential for the resource identified by the specified url. Optionally you can provide a userId to find credentials for a specific user.
	 * 
	 * @param url - The url to a server.
	 * @return Credential
	 */
	public final native Credential findCredential(String url) /*-{
		return this.findCredential(url);
	}-*/;
	
	/**
	 * Returns information about the server that is hosting the specified url.
	 * 
	 * @param url - The url to a server.
	 * @return ServerInfo
	 */
	public final native ServerInfo findServerInfo(String url) /*-{
		return this.findServerInfo(url);
	}-*/;
	
	/**
	 * Returns an object containing a token and its expiration time. You need to provide the ServerInfo object that contains token service URL and a 
	 * user info object containing username and password. This is a helper method typically called by sub-classes to generate tokens.
	 * 
	 * @param serverInfo - A ServerInfo object that contains a token service URL.
	 * @param userInfo - A user info object containing a user name and password.
	 * @return Deferred
	 */
	public final native Deferred generateToken(ServerInfo serverInfo, JavaScriptObject userInfo) /*-{
		return this.generateToken(serverInfo, userInfo);
	}-*/;
	
	/**
	 * Returns a Credential object that can be used to access the secured resource identified by the input url. If required the user will be challenged 
	 * for a username and password which is used to generate a token. Note: The IdentityManager sets up a timer to update the Credential object with 
	 * a new token prior to the expiration time. This method is typically called by esri.request when a request fails due to an "invalid credentials" error.
	 * 
	 * @param url - The url for the secure resource.
	 * @param retry - Determines if the method should make additional attempts to get the credentials after a failure.
	 * @return Deferred
	 */
	public final native Deferred getCredential(String url, boolean retry) /*-{
		return this.getCredential(url, retry);
	}-*/;
	
	/**
	 * Returns a Credential object that can be used to access the secured resource identified by the input url. If required the user will be challenged 
	 * for a username and password which is used to generate a token. Note: The IdentityManager sets up a timer to update the Credential object with 
	 * a new token prior to the expiration time. This method is typically called by esri.request when a request fails due to an "invalid credentials" error.
	 * 
	 * @param url - The url for the secure resource.
	 * @return Deferred
	 */
	public final native Deferred getCredential(String url) /*-{
		return this.getCredential(url);
	}-*/;
	
	/**
	 * Returns true if the identity manager is busy accepting user input, i.e. the user has invoked signIn and is waiting for a response.
	 * 
	 * @return boolean
	 */
	public final native boolean isBusy() /*-{
		return this.isBursy();
	}-*/;
	
	/**
	 * Register secure servers and the token endpoints.
	 * 
	 * @param serverInfos - A ServerInfos object that defines the secure service and token endpoint. The 
	 * Identity Manager makes its best guess to determine the locatation of the secure server and token 
	 * endpoint so in most cases calling registerServers is not necessary. However if the location of 
	 * your server or token endpoint is non-standard use this method to register the location.
	 */
	public final native void registerServers(ServerInfo serverInfos) /*-{
		this.registerServers(serverInfos);
	}-*/;

	/**
	 * When accessing secure resources from ArcGIS.com or one of its sub-domains the IdentityManager redirects 
	 * the user to the ArcGIS.com sign-in page. Once the user successfully logs-in they are redirected back to 
	 * the application. Use this method if the application needs to execute custom logic before the page is 
	 * redirected by creating a custom redirection handler. The IdentityManager calls the custom handler function 
	 * with an object containing the redirection properties. (As of v2.6)
	 * 
	 * @param handler - handler to fire on redirection
	 */
	public final native void setRedirectionHandler(RedirectionHandler handler) /*-{
		this.setRedirectionHandler(function(info) {
			handler.@edu.ucdavis.cstars.client.event.RedirectionHandler::onRedirection(Ledu/ucdavis/cstars/client/IdentityManagerBase$RedirectionInfo;)();
		});
	}-*/;
	
	/**
	 * Sub-classes must implement this method to create and manager the user interface that is used to obtain a username and password 
	 * from the end-user. It should perform the following tasks:
	 *     Challenge the user for a username and password.
	 *     Generate a token and return it to the caller via Deferred object.
	 * 
	 * @param url - Url for the secure resource.
	 * @param serverInfo - A ServerInfo object that contains the token service url.
	 * @return Deferred
	 */
	public final native Deferred signIn(String url, ServerInfo serverInfo)/*-{
		return this.signIn(url, serverInfo);
	}-*/;
	
	public static class RedirectionInfo extends JavaScriptObject {
		
		protected RedirectionInfo() {}
		
		/**
		 * The URL of the secure resource that triggers the redirection to the ArcGIS.com sign-in page.
		 * 
		 * @return String
		 */
		public final native String getResourceUrl() /*-{
			return this.resourceUrl;
		}-*/;
		
		/**
		 * ServerInfo object describing the server where the secure resource is hosted.
		 * 
		 * @return ServerInfo
		 */
		public final native ServerInfo getServerInfo() /*-{
			return this.serverInfo;
		}-*/;
		
		/**
		 * URL of the sign-in page where users will be redirected.
		 * 
		 * @return String
		 */
		public final native String getSignInPage() /*-{
			return this.signInPage;
		}-*/;
		
		/**
		 * The application URL where the sign-in page redirects after a successful log-in. To create the return 
		 * URL append the application's URL to signInPage as a parameter. returnUrlParamName contains the name 
		 * of the parameter. 
		 * 
		 * @return String
		 */
		public final native String getReturnUrlParamName() /*-{
			return this.returnUrlParamName;
		}-*/;
		
	}
	
}
