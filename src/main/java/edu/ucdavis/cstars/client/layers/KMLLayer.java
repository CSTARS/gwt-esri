package edu.ucdavis.cstars.client.layers;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.event.RefreshHandler;

/**
 * The KMLLayer class is used to create a layer based on a KML file (.kml,.kmz). KML is an XML-based file format used to represent geographic features.
 * Features from the KML file are accessible via the api so you can query features and use them as input to geometry or geoprocessing services.
 * 
 * @author Justin Merz
 */
public class KMLLayer extends Layer {
	
	protected KMLLayer() {}

	/**
	 * Creates a new KMLLayer object.
	 * 
	 * @param url - The url for a .kml or .kmz file.
	 * @return KMLLayer
	 */
	public static KMLLayer create(String url) { 
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(url);
	}
	
	private native static KMLLayer _create(String url) /*-{
		return new $wnd.esri.layers.KMLLayer(url);
	}-*/;
	
	/**
	 * Creates a new KMLLayer object.
	 * 
	 * @param url - The url for a .kml or .kmz file.
	 * @param options - Optional parameters.
	 * @return KMLLayer
	 */
	public static KMLLayer create(String url, Options options) { 
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(url, options);
	}
	
	private native static KMLLayer _create(String url, Options options) /*-{
		return new $wnd.esri.layers.KMLLayer(url, options);
	}-*/;
	
	/**
	 * Check that the esri.layers.KMLLayer has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.KMLLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_KMLLAYER package has not been loaded");
		return false;
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
	 * An array of KMLFolder objects that describe the folders and nested folders defined
	 * in the KML file. Use the parentFolderId and subFolderIds to identify the hierarchical
	 * relationship between folders.
	 * 
	 * @return JsArray<KMLFolder>
	 */
	public final native JsArray<KMLFolder> getFolders() /*-{
		return this.folders;
	}-*/;
	
	/**
	 * A link info object with properties that describe the network link.
	 * 
	 * @return LinkInfo
	 */
	public final native LinkInfo getLinkInfo() /*-{
		return this.linkInfo;
	}-*/;
	
	/**
	 * The name of the layer if specified in the KML file.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The initial visibility of the layer. If the visibility is 0 the layer is not visible.
	 * 
	 * @return int
	 */
	public final native int getVisibility() /*-{
		return this.visibility;
	}-*/;
	
	/**
	 * Get the KML feature identified by the input feature info. The table below lists the type of objects returned for the KML feature types.
	 * 
	 * KML <Feature> Class name of returned object
	 * Placemark	Graphic
	 * GroundOverlay	KMLGroundOverlay
	 * ScreenOverlay	KMLScreenOverlay
	 * NetworkLink	KMLLayer
	 * Folder	KMLFolder
	 * 
	 * @param featureInfo - Feature info for the kml feature.
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getFeature(FeatureInfo featureInfo) /*-{
		return this.getFeature(featureInfo);
	}-*/;
	
	/**
	 * Get the KML feature identified by the input feature info. 
	 * 
	 * @param featureInfo - Feature info for the kml feature.
	 * @return Graphic
	 */
	public final native Graphic getFeatureAsPlacemark(FeatureInfo featureInfo) /*-{
		return this.getFeature(featureInfo);
	}-*/;
	
	/**
	 * Get the KML feature identified by the input feature info. 
	 * 
	 * @param featureInfo - Feature info for the kml feature.
	 * @return KMLGroundOverlay
	 */
	public final native KMLGroundOverlay getFeatureAsGroundOverlay(FeatureInfo featureInfo) /*-{
		return this.getFeature(featureInfo);
	}-*/;
	
	/**
	 * Get the KML feature identified by the input feature info. 
	 * 
	 * @param featureInfo - Feature info for the kml feature.
	 * @return KMLLayer
	 */
	public final native KMLLayer getFeatureAsNetworkLink(FeatureInfo featureInfo) /*-{
		return this.getFeature(featureInfo);
	}-*/;
	
	/**
	 * Get the KML feature identified by the input feature info. 
	 * 
	 * @param featureInfo - Feature info for the kml feature.
	 * @return KMLFolder
	 */
	public final native KMLFolder getFeatureAsFolder(FeatureInfo featureInfo) /*-{
		return this.getFeature(featureInfo);
	}-*/;
	
	/**
	 * Get an array of map layers that were created to draw placemarks, ground and screen overlays. The returned array can
	 * have instances of the following layer types: FeatureLayer or MapImageLayer. This method can be used to override the
	 * renderer for feature layers.
	 * 
	 * @return JsArray<Layer>
	 */
	public final native JsArray<Layer> getLayers() /*-{
		return this.getLayers();
	}-*/;
	
	/**
	 * Set the visibility for the specified folder.
	 * 
	 * @param folder - A KML folder.
	 * @param isVisible - The visibility of the folder and all kml features within the folder.
	 */
	public final native void setFolderVisibility(KMLFolder folder, boolean isVisible) /*-{
		this.setFolderVisibility(folder, isVisible);
	}-*/;
	
	/**
	 * Set the refresh event handler.
	 * 
	 * @param handler - Fired after the layer is refreshed. If the layer represents a network link it is automatically refreshed 
	 * based on the network link parameters defined in the linkInfo property. Layers can be explicitly refreshed by calling the 
	 * refresh method.
	 */
	public native final void addRefreshHandler(RefreshHandler handler) /*-{
		$wnd.dojo.connect(this, "onRefresh",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.RefreshHandler::onRefresh()();
			}
		);
	}-*/;
	
	public static class FeatureInfo extends JavaScriptObject {
		
		protected FeatureInfo() {}
		
		/**
		 * The type can be one of the following:Folder, GroundOverlay, Line, NetworkLink,Point, Polygon, ScreenOverlay.
		 * 
		 * @return String 
		 */
		public final native String getType() /*-{
			return this.type;
		}-*/;
		
		public final native int getId() /*-{
			return this.id;
		}-*/;
		
	}
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}

		/**
		 * Set the outSR parameter.
		 * 
		 * @param outSR - The output spatial reference for the KMLLayer. 
		 */
		public final native void setOutSR(SpatialReference outSR) /*-{
			this["outSR"] = outSR;
		}-*/;
		
		/**
		 * Set if layer should be initially visible.
		 * 
		 * @param isVisible - Initial visibility of the layer. Default is true. 
		 */
		public final native void setVisible(boolean isVisible) /*-{
			this["visible"] = isVisible;
		}-*/; 
		
	}
	
	public static class LinkInfo extends JavaScriptObject {
		
		protected LinkInfo() {}
		
		public final native int getId() /*-{
			return this.id;
		}-*/;
		
		public final native String getName() /*-{
			return this.name;
		}-*/;
		
		public final native String getDescription() /*-{
			return this.description;
		}-*/;
		
		public final native String getSnippet() /*-{
			return this.snippet;
		}-*/;
		
		public final native double getVisibility() /*-{
			return this.visibility;
		}-*/;
		
		public final native String getRefreshMode() /*-{
			return this.refreshMode;
		}-*/;
		
		public final native int getRefreshInterval() /*-{
			return this.refreshIntervale;
		}-*/;

		public final native String getViewRefreshMode() /*-{
			return this.viewRefreshInterval;
		}-*/;
		
		public final native int getViewRefreshTime() /*-{
			return this.viewRefreshTime;
		}-*/;
		
		public final native int getViewBoundScale() /*-{
			return this.viewBoundScale;
		}-*/;
		
		public final native String getViewFormat() /*-{
			return this.viewFormat;
		}-*/;

		public final native String getHttpQuery() /*-{
			return this.httpQuery;
		}-*/;
		
	}
	
}
