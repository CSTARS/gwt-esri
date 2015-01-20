package edu.ucdavis.cstars.client.arcgis;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * List the users, owner and administrator of a group. Only available to members or administrators of the group.
 * Class added v2.8 
 * 
 * @author Justin Merz
 */
public class PortalGroupMembers extends JavaScriptObject {
	
	protected PortalGroupMembers() {}
	
	/**
	 * An array containing the user names for each administrator of the group.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getAdmins() /*-{
		return this.admins;
	}-*/;
	
	/**
	 * The user name of the owner of the group.
	 * 
	 * @return String
	 */
	public final native String getOwner() /*-{
		return this.owner;
	}-*/;

	/**
	 * An array containing the user names for each user in the group.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getUsers() /*-{
		return this.users;
	}-*/;
	
}
