package edu.ucdavis.cstars.client.arcgis;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.callback.PortalGroupMembersCallback;
import edu.ucdavis.cstars.client.callback.PortalQueryItemsCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;

/**
 * Execute a query against the Portal to return a deferred that when resolved returns PortalQueryResult that 
 * contain a results array of PortalGroup ojbects for all the groups that match the input query.
 * 
 * @author Justin Merz
 */
public class PortalGroup extends JavaScriptObject {
	
	public static enum Access {
		NOT_SET(""),
		PUBLIC("public"),
		PRIVATE("private"),
		ORG("org");
		private String val;
		private Access(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static Access get(String a) {
			for( int i = 0; i < Access.values().length; i++ ) {
				if( Access.values()[i].getValue().contentEquals(a) ) {
					return Access.values()[i];
				}
			}
			return Access.NOT_SET;
		}
	}

	protected PortalGroup() {}
	
	/**
	 * The access privileges on the group which determines who can see and access the group. Can be: private, org, or public.
	 * 
	 * @return Access
	 */
	public final native Access getAccess() /*-{
		return @edu.ucdavis.cstars.client.arcgis.Portal.Access::get(Ljava/lang/String;)(this.access);
	}-*/;
	
	/**
	 *The date the group was created.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getCreated() /*-{
		return this.created;
	}-*/;
	
	/**
	 * A detailed description of the group.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The id for the group.
	 * 
	 * @return String
	 */
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * If this is set to true, then users will not be able to apply to join the group.
	 * 
	 * @return boolean
	 */
	public final native boolean isInvitationOnly() /*-{
		return this.isInvitationOnly;
	}-*/;
	
	/**
	 * The date the group was last modified.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getModified() /*-{
		return this.modified;
	}-*/;
	
	/**
	 * The username of the group's owner.
	 * 
	 * @return String
	 */
	public final native String getOwner() /*-{
		return this.owner;
	}-*/;
	
	/**
	 * The portal for the group.
	 * 
	 * @return Portal
	 */
	public final native Portal getPortal() /*-{
		return this.portal;
	}-*/;
	
	/**
	 * A short summary that describes the group.
	 * 
	 * @return String
	 */
	public final native String getSnippet() /*-{
		return this.snippet;
	}-*/;
	
	/**
	 * User defined tags that describe the group.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getTags() /*-{
		return this.tags;
	}-*/;
	
	/**
	 * The url to the thumbnail used for the group.
	 * 
	 * @return String
	 */
	public final native String getThumbnailUrl() /*-{
		return this.thumbnailUrl;
	}-*/;
	
	/**
	 * The title for the group. This is the name that is displayed to users and by which they 
	 * refer to the group. Every group must have a title and it must be unique for a user.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;
	
	/**
	 * The url to the group.
	 * 
	 * @return 
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Get the current members for the group. Returns a deferred that when resolved provides access to a PortalGroupMembers object.
	 * 
	 * @param callback - handler to fire when members are returned
	 * @return Deferred
	 */
	public final native Deferred getMembers(PortalGroupMembersCallback callback) /*-{
		var defer = this.getMembers();
		defer.then(function(members) {
			callback.@edu.ucdavis.cstars.client.callback.PortalGroupMembersCallback::onMembersReturn(Ledu/ucdavis/cstars/client/arcgis/PortalGroupMembers;)(members);
		});
		return defer;
	}-*/;
	
	/**
	 * Execute a query against the group to return a deferred that when resolved returns PortalQueryResults that 
	 * contain a results array of PortalItem objects that match the input query.
	 * 
	 * @param queryParams - The input query parameters.
	 * @param callback - function to fire when query completes
	 * @return Deferred
	 */
	public final native Deferred queryItem(PortalQueryParams queryParams, PortalQueryItemsCallback callback) /*-{
		var defer = this.queryItems(queryParams);
		defer.then(function(items) {
			callback.@edu.ucdavis.cstars.client.callback.PortalQueryItemsCallback::onQueryComplete(Ledu/ucdavis/cstars/client/arcgis/PortalQueryResult;)(items);
		});
		return defer;
	}-*/;
}
