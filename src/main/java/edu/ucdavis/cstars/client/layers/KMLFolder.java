package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

import edu.ucdavis.cstars.client.layers.KMLLayer.FeatureInfo;

/**
 * Defines information about a KML folder. The KML folder is a hierarchical structure used to arrange features
 * (Folders, Placemarks, Overlays or Network Links).KMLFolder has no constructor. 
 * 
 * @author Justin Merz
 */
public class KMLFolder extends JavaScriptObject {

	protected KMLFolder() {}
	
	/**
	 * The KML folder description.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * An array of objects that describe top-level KML features ids and their types.
	 * 
	 * @return JsArray<FeatureInfo>
	 */
	public final native JsArray<FeatureInfo> getFeatureInfos() /*-{
		return this.featureInfos;
	 }-*/;
	
	/**
	 * The KML folder id.
	 * 
	 * @return int
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * The KML folder name.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The id of the parent folder.
	 * 
	 * @return int
	 */
	public final native int getParentFolderId() /*-{
		return this.parentFolderId;
	}-*/;
	
	/**
	 * The KML folder snippet.
	 * 
	 * @return String
	 */
	public final native String getSnippet() /*-{
		return this.snippet;
	}-*/;
	
	/**
	 * An array of ids for the KML folder's subfolders.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getSubFolderIds() /*-{
		return this.subFolderIds;
	}-*/;
	
	/**
	 * The visibility of the KML folder. When 0 the folder is not visible.
	 * 
	 * @return int
	 */
	public final native int getVisibility() /*-{
		return this.visibility;
	}-*/;
	
}
