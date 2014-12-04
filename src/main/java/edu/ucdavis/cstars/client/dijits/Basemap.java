package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.dojo.Deferred;

/**
 * Define a basemap to display in the BasemapGallery dijit.
 * 
 * @author Justin Merz
 */
public class Basemap extends JavaScriptObject  {

	protected Basemap() {}
	
	/**
	 * Creates a new Basemap Object.
	 * 
	 * @return Basemap
	 */
	public static native Basemap create() /*-{
		if( !@edu.ucdavis.cstars.client.dijits.Basemap::assertLoaded() ) return {};
		return new $wnd.esri.dijit.Basemap();
	}-*/;
	
	/**
	 * Creates a new Basemap Object.
	 * 
	 * @param options - Set of parameters used to create a basemap.
	 * @return Basemap
	 */
	public static native Basemap create(Options options) /*-{
		if( !@edu.ucdavis.cstars.client.dijits.Basemap::assertLoaded() ) return {};
		return new $wnd.esri.dijit.Basemap(options);
	}-*/;
	
	/**
	 * Check that the esri.dijit.BasemapGallery has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.BasemapGallery ) return true;
		$wnd.alert("The ESRI_DIJIT_BASEMAPGALLERY package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * The basemap's id.
	 * 
	 * @return String
	 */
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * The URL to the thumbnail image for the basemap.
	 * 
	 * @return String
	 */
	public final native String getThumbnailUrl() /*-{
		return this.thumbnailUrl;
	}-*/;
	
	/**
	 * The title for the basemap.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;
	
	/**
	 * The list of layers contained in the basemap or a dojo.Deferred if a call to ArcGIS.com needs to be made to 
	 * retrieve the list of ArcGIS.com basemaps.
	 * 
	 * @return JsArray<BasemapLayer>
	 */
	public final native JsArray<BasemapLayer> getLayers() /*-{
		return this.getLayers();
	}-*/;
	
	/**
	 * The list of layers contained in the basemap or a dojo.Deferred if a call to ArcGIS.com needs to be made to 
	 * retrieve the list of ArcGIS.com basemaps.
	 * 
	 * @return Deferred
	 */
	public final native Deferred getLayersDeferred() /*-{
		return this.getLayers();
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param basemapLayers - An array of layers to add to the basemap.
		 */
		public final void setBasemapLayers(BasemapLayer[] basemapLayers) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < basemapLayers.length; i++ ) Util.addObjectToArray(basemapLayers[i], arr);
			_setBasemapLayers(arr);
		}
		
		private final native void _setBasemapLayers(JavaScriptObject array) /*-{
			this["layers"] = array;
		}-*/;
		
		/**
		 * 
		 * @param thumbnailUrl - Optional. A URL to a thumbnail image for the basemap that will be displayed in the
		 * BasemapGallery. If no thumbnail is is provided the gallery will display a blank. The default size for the image
		 * is 100 x 67 pixels.
		 */
		public final native void setThumbnailUrl(String thumbnailUrl) /*-{
			this["thumbnailUrl"] = thumbnailUrl;
		}-*/;
		
		/**
		 * 
		 * @param title - Optional. Title for the basemap. This value is displayed in the BasemapGallery below the thumbnail image.
		 */
		public final native void setTitle(String title) /*-{
			this["title"] = title;
		}-*/;
		
	}
	
}
