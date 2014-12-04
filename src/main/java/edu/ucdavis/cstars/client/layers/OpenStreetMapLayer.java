package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Util;

/**
 * Allows you to use basemaps from OpenStreetMap . Set the tileservers property to change which OpenStreetMap tiles you want to use.
 * 
 * Requires Package: esri.layers.osm
 * 
 * @author Justin Merz
 */
public class OpenStreetMapLayer extends TiledMapServiceLayer {

	protected OpenStreetMapLayer() {}
	
	/**
	 * Creates a new OpenStreetMapLayer object.
	 * 
	 * @return OpenStreetMapLayer
	 */
	public static OpenStreetMapLayer create() {
		if( assertLoaded() ) return _create();
		return JavaScriptObject.createObject().cast();
	};
	
	private static native OpenStreetMapLayer _create() /*-{
		return new $wnd.esri.layers.OpenStreetMapLayer();
	}-*/;
	
	/**
	 * Creates a new OpenStreetMapLayer object.
	 * 
	 * @param options - Optional parameters
	 * @return OpenStreetMapsObject
	 */
	public static OpenStreetMapLayer create(Options options) {
		if( assertLoaded() ) return _create(options);
		return JavaScriptObject.createObject().cast();
	};
	
	private static native OpenStreetMapLayer _create(Options options) /*-{
		return new $wnd.esri.layers.OpenStreetMapLayer(options);
	}-*/;
	
	/**
	 * Check that the esri.layers.osm package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.OpenStreetMapLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_OSM package has not been loaded");
		return false;
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param levels - An array of levels at which to draw.
		 */
		public final void setDisplayLevels(int[] levels){
			_setDisplayLevels(Util.intArrayToJSO(levels));
		}
		
		private final native void _setDisplayLevels(JavaScriptObject levels) /*-{
			this["displayLevels"] = levels;
		}-*/;
		
		/**
		 * 
		 * @param id - Id to assign to the layer. If not assigned, esri.Map assigns value.
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * 
		 * @param opacity - Initial opacity or transparency of layer. Values range from
		 * 0.0 to 1.0, where 0.0 is 100% transparent and 1.0 has no transparency. The default value is 1.0.
		 */
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * 
		 * @param tileServers - An array of tile servers
		 */
		public final void setTileServers(String[] tileServers){
			_setTileServers(Util.stringArrayToJSO(tileServers));
		}
		
		private final native void _setTileServers(JavaScriptObject servers) /*-{
			this["tileServers"] = servers;
		}-*/;
		
		/**
		 * 
		 * @param visible - Initial visibility of the layer. Default is true.
		 */
		public final native void setVisible(boolean visible) /*-{
			this["visible"] = visible;
		}-*/;
		
	}
	
}
