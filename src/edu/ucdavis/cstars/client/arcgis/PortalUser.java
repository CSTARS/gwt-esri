package edu.ucdavis.cstars.client.arcgis;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.callback.PortalFoldersCallback;
import edu.ucdavis.cstars.client.callback.PortalGroupInvitationsCallback;
import edu.ucdavis.cstars.client.callback.PortalGroupsCallback;
import edu.ucdavis.cstars.client.callback.PortalItemsCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;

public class PortalUser extends JavaScriptObject {
	
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
	
	public static enum Role {
		NOT_SET(""),
		ADMIN("org_admin"),
		PUBLISHER("org_publisher"),
		USER("org_user");
		private String val;
		private Role(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static Role get(String a) {
			for( int i = 0; i < Role.values().length; i++ ) {
				if( Role.values()[i].getValue().contentEquals(a) ) {
					return Role.values()[i];
				}
			}
			return Role.NOT_SET;
		}
	}
	
	protected PortalUser() {}

	/**
	 * The access level for the user: private, org or public. If private, the users descriptive information will not be available and the 
	 * user name will not be searchable. Available only if the user is signed-in.
	 * 
	 * @return Access
	 */
	public final native Access getAccess() /*-{
		return @edu.ucdavis.cstars.client.arcgis.PortalUser.Access::get(Ljava/lang/String;)(this.access);
	}-*/;
	
	/**
	 *The date the user was created.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getCreated() /*-{
		return this.created;
	}-*/;
	
	/**
	 * The default culture for the user.
	 * 
	 * @return String
	 */
	public final native String getCulture() /*-{
		return this.culture;
	}-*/;
	
	/**
	 * Description of the user.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The user's email address. Available only if the user is signed-in.
	 * 
	 * @return String
	 */
	public final native String getEmail() /*-{
		return this.email;
	}-*/;
	
	/**
	 * The user's full name.
	 * 
	 * @return String
	 */
	public final native String getFullname() /*-{
		return this.fullname;
	}-*/;
	
	/**
	 * The date the user was modified.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getModified() /*-{
		return this.modified;
	}-*/;
	
	/**
	 * The id of the organization the user belongs to.
	 * 
	 * @return String
	 */
	public final native String getOrgId() /*-{
		return this.orgId;
	}-*/;
	
	/**
	 * The portal.
	 * 
	 * @return Portal
	 */
	public final native Portal getPortal() /*-{
		return this.portal;
	}-*/;
	
	/**
	 * The user's preferred view for content, either Web or GIS. Available only if the user is signed-in.
	 * 
	 * @return String
	 */
	public final native String getPreferredView() /*-{
		return this.preferredView;
	}-*/;
	
	/**
	 * The user's preferred region, used to set the featured maps on the portal home page, content in the 
	 * gallery and the default extent for new maps in the Viewer.
	 * 
	 * @return String
	 */
	public final native String getRegion() /*-{
		return this.region;
	}-*/;
	
	/**
	 * The user's role in the organization.
	 * 
	 * @return Role
	 */
	public final native Role getRole() /*-{
		return @edu.ucdavis.cstars.client.arcgis.PortalUser.Role::get(Ljava/lang/String;)(this.role);
	}-*/;
	
	/**
	 * User-defined tags that describe the user.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getTags() /*-{
		return this.tags;
	}-*/;
	
	/**
	 * The url to the thumbnail image for the user.
	 * 
	 * @return String
	 */
	public final native String getThumbnailUrl() /*-{
		return this.thumbnailUrl;
	}-*/;

	/**
	 * The username for the user.
	 * 
	 * @return String
	 */
	public final native String getUsername() /*-{
		return this.username;
	}-*/;
	
	/**
	 * Find folders for the portal user. Returns a deferred that when resolved provides access to an array of PortalFolder objects.
	 * 
	 * @param callback - Function to be called when server responds.
	 * @return Deferred
	 */
	public final native Deferred getFolders(PortalFoldersCallback callback) /*-{
		var def = this.getGroups();
		def.then(function(folders) {
			callback.@edu.ucdavis.cstars.client.callback.PortalFoldersCallback::onResponse(Lcom/google/gwt/core/client/JsArray;)(folders);
		});
		return def;
	}-*/;
	
	/**
	 * Provides access to the group invitations for the portal user. Returns a deferred that when resolved provides access to the 
	 * results as json. View the REST API documentation for details on the result format.
	 * 
	 * @param callback - Function to be called when server responds.
	 * @return Deferred
	 */
	public final native Deferred getGroupInvitations(PortalGroupInvitationsCallback callback) /*-{
		var def = this.getGroupInvitations();
		def.then(function(invitations) {
			callback.@edu.ucdavis.cstars.client.callback.PortalGroupInvitationsCallback::onResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(invitations);
		});
		return def;
	}-*/;
	
	/**
	 * Find all the groups that the portal user has permissions to access. Returns a deferred that when resolved provides access 
	 * to an array of PortalGroup objects.
	 * 
	 * @param callback - Function to be called when server responds.
	 * @return Deferred
	 */
	public final native Deferred getGroups(PortalGroupsCallback callback) /*-{
		var def = this.getGroups();
		def.then(function(groups) {
			callback.@edu.ucdavis.cstars.client.callback.PortalGroupsCallback::onResponse(Lcom/google/gwt/core/client/JsArray;)(groups);
		});
		return def;
	}-*/;
	
	/**
	 * Retrieve all the items in the specified folder. Returns a deferred that when resolved provides access to an array of PortalItem objects.
	 * 
	 * @param folderId - The id of the folder that contains the items to retrieve.
	 * @param callback - Function to be called when server responds.
	 * @return Deferred
	 */
	public final native Deferred getItems(String folderId, PortalItemsCallback callback) /*-{
		var def = this.getItems(folderId);
		def.then(function(items) {
			callback.@edu.ucdavis.cstars.client.callback.PortalItemsCallback::onResponse(Lcom/google/gwt/core/client/JsArray;)(items);
		});
		return def;
	}-*/;
	
}
