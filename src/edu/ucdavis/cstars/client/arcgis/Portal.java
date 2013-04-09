package edu.ucdavis.cstars.client.arcgis;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.callback.PortalQueryGroupsCallback;
import edu.ucdavis.cstars.client.callback.PortalQueryItemsCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * Class added v2.8
 * The Portal class is part of the Portal API which provides a way to build applications that work with 
 * content from ArcGIS Online or an ArcGIS Portal. ArcGIS Portal is software technology from Esri that 
 * customers can deploy either on premise or in the cloud. ArcGIS Online is Esri's Software as a Service 
 * offering that represents GIS as a Service and is implemented using the same technology as ArcGIS Portal.
 * 
 * The Portal API allows application developers to work with users, groups and content hosted within ArcGIS 
 * Online or within an ArcGIS Portal. The API allows developers to build web, mobile, and desktop applications 
 * that support sharing and collaboration using web maps. Organizational developers can also use the API to 
 * build custom applications for their users.
 * 
 * The Portal class provides a view of the portal as seen by the current user, anonymous or logged in. Includes 
 * information such as the name, logo, featured items and supported protocols (http vs https) for this portal. 
 * If the user is not logged in this call will return the default view of the portal. If the user is logged in, 
 * the view of the portal returned will be specific to the organization that the user belongs to. The default 
 * view of the portal is dependent on the culture of the user which is obtained from the users profile.
 * 
 * @author Justin Merz
 */
public class Portal extends JavaScriptObject {
	
	public static enum Access {
		NOT_SET(""),
		PUBLIC("public"),
		PRIVATE("private");
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

	protected Portal() {}
	
	/**
	 * Creates a new Portal object.
	 * 
	 * @param url - The url to the ArcGIS.com site or in-house portal.
	 * @return Portal
	 */
	public static native Portal create(String url) /*-{
		if( !@edu.ucdavis.cstars.client.arcgis.Portal::assertLoaded() ) return {};
		return new $wnd.esri.dijit.editing.editOperation(url);
	}-*/;
	
	/**
	 * Check that the esri.arcgis.Portal has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.arcgis.Portal ) return true;
		$wnd.alert("The ESRI_ARCGIS_PORTAL package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * The access level of the organization. When public, anonymous users can access the organization. 
	 * When private access is restricted to only members of the organization.
	 * 
	 * @return Access
	 */
	public final native Access getAccess() /*-{
		return @edu.ucdavis.cstars.client.arcgis.Portal.Access::get(Ljava/lang/String;)(this.access);
	}-*/;
	
	/**
	 * When true, access to the Portal resources must occur over SSL.
	 * 
	 * @return boolean
	 */
	public final native boolean allSSL() /*-{
		return this.allSSL;
	}-*/;
	
	/**
	 * The query that defines the basemaps that are displayed in the Basemap Gallery.
	 * 
	 * @return String
	 */
	public final native String getBasemapGalleryGroupQuery() /*-{
		return this.basemapGalleryGroupQuery;
	}-*/;
	
	/**
	 * When true, public items, groups and users are included in search queries. When false, no public 
	 * items outside of the organization are included. However, public items which are part of the 
	 * organization are included.
	 * 
	 * @return boolean
	 */
	public final native boolean canSearchPublic() /*-{
		return this.canSearchPublic;
	}-*/;
	
	/**
	 * When true, members of the organization can share resources outside the organization.
	 * 
	 * @return boolean
	 */
	public final native boolean canSharePublic() /*-{
		return this.canSharePublic;
	}-*/;
	
	/**
	 * Date the organization was created.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getCreated() /*-{
		return this.created;
	}-*/;
	
	/**
	 * The default locale (language and country) information.
	 * 
	 * @return String
	 */
	public final native String getCulture() /*-{
		return this.culture;
	}-*/;
	
	/**
	 * The default basemap the portal displays in the map viewer. Returns an object that provides the 
	 * url and title to the default basemap service.
	 * 
	 * @return DefaultBasemap
	 */
	public final native DefaultBasemap getDefaultBasemap() /*-{
		return this.defaultBasemap;
	}-*/;
	
	/**
	 * The default extent for the map the portal displays in the map viewer. The extent will be in the 
	 * default basemap's spatial reference.
	 * 
	 * @return Extent
	 */
	public final native Extent getDefaultExtent() /*-{
		return new $wnd.esri.geometry.Extent(this.defaultExtent);
	}-*/;
	
	/**
	 * A description of the organization / portal.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The featured groups for the portal. Returns an array of objects that provide access to the 
	 * owner and title for each featured group.
	 * 
	 * @return JsArray<FeaturedGroup>
	 */
	public final native JsArray<FeaturedGroup> getFeaturedGroups() /*-{
		return this.featuredGroups;
	}-*/;
	
	/**
	 * The query that defines the featured group. If null, then the most viewed items in the 
	 * organization will be the featured items.
	 * 
	 * @return String
	 */
	public final native String getFeaturedItemsGroupQuery() /*-{
		return this.featuredItemsGroupQuery;
	}-*/;
	
	/**
	 * The id of the organization that owns this portal. If null then this is the default portal 
	 * for anonymous and non organizational users.
	 * 
	 * @return String
	 */
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * Indicates if the portal is an organization.
	 * 
	 * @return boolean
	 */
	public final native boolean isOrganization() /*-{
		return this.isOrganization;
	}-*/;
	
	/**
	 * The query that defines the collection of editable layer templates.
	 * 
	 * @return String
	 */
	public final native String getLayerTemplatesGroupQuery() /*-{
		return this.layerTemplatesGroupQuery;
	}-*/;
	
	/**
	 * Date the organization was last modified.
	 * 
	 * @return JsDate
	 */
	public final native JsDate getModified() /*-{
		return this.modified;
	}-*/;
	
	/**
	 * The Name of the organization / portal.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * Denotes multitenant or singletenant.
	 * 
	 * @return String
	 */
	public final native String getPortalMode() /*-{
		return this.portalMode;
	}-*/;
	
	/**
	 * The name of the portal i.e. ArcGIS Online.
	 * 
	 * @return String
	 */
	public final native String getPortalName() /*-{
		return this.portalName;
	}-*/;
	
	/**
	 * The query that defines the symbols sets used by the map viewer.
	 * 
	 * @return String
	 */
	public final native String getSymbolSetsGroupQuery() /*-{
		return this.symbolSetsGroupQuery;
	}-*/;
	
	/**
	 * The query that defines the collection of templates that will appear in the template gallery.
	 * 
	 * @return String
	 */
	public final native String getTemplatesGroupQuery() /*-{
		return this.templatesGroupQuery;
	}-*/;
	
	/**
	 * The url to the thumbnail of the organization.
	 * 
	 * @return String
	 */
	public final native String getThumbnailUrl() /*-{
		return this.thumbnailUrl;
	}-*/;
	
	/**
	 * The portal url.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Execute a query against the Portal to return a deferred that when resolved returns PortalQueryResult that contain a 
	 * results array of PortalGroup objects for all the groups that match the input query.
	 * 
	 * @param queryParams - The input query parameters.
	 * @param callback - function to fire when query is complete
	 * @return Deferred
	 */
	public final native Deferred queryGroups(PortalQueryParams queryParams, PortalQueryGroupsCallback callback) /*-{
		var defer = this.queryGroups(queryParams);
		defer.then(function(groups) {
			callback.@edu.ucdavis.cstars.client.callback.PortalQueryGroupsCallback::onQueryComplete(Ledu/ucdavis/cstars/client/arcgis/PortalQueryResult;)(groups);
		});
		return defer;
	}-*/;
	
	/**
	 * Execute a query against the Portal to return a deferred that when resolved returns PortalQueryResult that contain a 
	 * results array of PortalItem objects that match the input query.
	 * 
	 * @param queryParams - The input query parameters.
	 * @param callback - fundtion to fire when the query is complete
	 * @return Deferred
	 */
	public final native Deferred queryItem(PortalQueryParams queryParams, PortalQueryItemsCallback callback) /*-{
		var defer = this.queryItems(queryParams);
		defer.then(function(items) {
			callback.@edu.ucdavis.cstars.client.callback.PortalQueryItemsCallback::onQueryComplete(Ledu/ucdavis/cstars/client/arcgis/PortalQueryResult;)(items);
		});
		return defer;
	}-*/;
	
	
	public static class DefaultBasemap extends JavaScriptObject {
	
		protected DefaultBasemap() {}
		
		public final native String getUrl() /*-{
			return this.url;
		}-*/;
		
		public final native String getTitle() /*-{
			return this.title;
		}-*/;
	}
	
	public static class FeaturedGroup extends JavaScriptObject {
		
		protected FeaturedGroup() {}
		
		public final native String getOwner() /*-{
			return this.owner;
		}-*/;
		
		public final native String getTitle() /*-{
			return this.title;
		}-*/;
	}
	
}
