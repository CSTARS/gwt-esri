package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Util;

/**
 * Defines a layer that will be added to a basemap and displayed in the BasemapGallery dijit.
 * 
 * @author Justin Merz
 */
public class BasemapLayer extends JavaScriptObject {

	protected BasemapLayer() {}
	
	/**
	 * Creates a new BasemapLayer object.
	 * 
	 * @return BasemapLayer
	 */
	public static native BasemapLayer create() /*-{
		if( !@edu.ucdavis.cstars.client.dijits.BasemapLayer::assertLoaded() ) return {};
		return new $wnd.esri.dijit.BasemapLayer();
	}-*/;
	
	/**
	 * Creates a new BasemapLayer object.
	 * 
	 * @param options - Set of parameters used to create a basemap layer.
	 * @return BasemapLayer
	 */
	public static native BasemapLayer create(Options options) /*-{
		if( !@edu.ucdavis.cstars.client.dijits.BasemapLayer::assertLoaded() ) return {};
		return new $wnd.esri.dijit.BasemapLayer(options);
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
	
	public final native String getUrl() /*-{
		if( this.url ) return this.url;
		return "";
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param bandIds - Optional. If the url points to an image service, you can specify which band ids will display. If
		 * not set, the first three available band ids will display.
		 */
		public final void setBandIds(int[] bandIds) {
			_setBandIds(Util.intArrayToJSO(bandIds));
		}
		
		private final native void _setBandIds(JavaScriptObject array) /*-{
			this["bandIds"] = array;
		}-*/;
		
		/**
		 * 
		 * @param displayLevels - Optional. If the url points to a cached map service you can specify the levels to draw. If
		 * not set, all display levels the service supports are drawn.
		 */
		public final void setDisplayLevels(int[] displayLevels) {
			_setDisplayLevels(Util.intArrayToJSO(displayLevels));
		}
		
		private final native void _setDisplayLevels(JavaScriptObject array) /*-{
			this["displayLevels"] = array;
		}-*/;
		
		/**
		 * 
		 * @param isReference - Optional. Set to true if the layer is a reference layer and should be drawn on top of
		 * all other layers in the map.
		 */
		public final native void isReference(boolean isReference) /*-{
			this["isReference"] = isReference;
		}-*/;
		
		/**
		 * Set the opacity
		 * 
		 * @param opacity - Initial opacity or transparency of the basemap layer. Values range from 0.0 to 1.0 where 0.0 is 100% 
		 * transparent and 1.0 has no transprency. The default value is 1.0.
		 */
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * 
		 * @param type - The type of layer, valid values are "BingMapsAerial", "BingMapsHybrid", "BingMapsRoad",
		 * "OpenStreetMap". Must specify either the url or type parameter.
		 */
		public final native void setType(String type) /*-{
			this["type"] = type;
		}-*/;
		
		/**
		 * 
		 * @param url - URL to the ArcGIS Server REST resource that represents a map or image service. Must specify
		 * either the url or type parameter.
		 */
		public final native void setUrl(String url) /*-{
			this["url"] = url;
		}-*/;
		
		/**
		 * 
		 * @param visibleLayers - Optional. If the url points to a dynamic map service you can specify a subset of layers
		 * to display. If not set, all visible layers are displayed.
		 */
		public final void setVisibleLayers(int[] visibleLayers) {
			_setVisibleLayers(Util.intArrayToJSO(visibleLayers));
		}
		
		private final native void _setVisibleLayers(JavaScriptObject array) /*-{
			this["visibleLayers"] = array;
		}-*/;
		
	}
	
}
