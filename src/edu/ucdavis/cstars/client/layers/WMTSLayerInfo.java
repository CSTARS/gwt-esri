package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * The WMTSLayerInfo class defines and provides information about layers in a WMTS service.
 * 
 * @author Justin Merz
 */
public class WMTSLayerInfo extends JavaScriptObject {

	protected WMTSLayerInfo() {}
	
	/**
	 * Creates a new WMTSLayerInfo object.
	 * 
	 * @param options - An object that defines the layer info options.
	 * @return WMTSLayerInfo
	 */
	public static WMTSLayerInfo create(Options options) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(options);
	}
	
	private static native WMTSLayerInfo _create(Options options) /*-{
		return new $wnd.esri.layers.WMTSLayerInfo(options);
	}-*/;
	
	/**
	 * Check that the esri.layers.WMSTLayer has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.WMTSLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_WMTSLAYER package has not been loaded");
		return false;
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 *  Set the description parameter.
		 *  
		 * @param description - The description of the layer defined by the abstract property of the capabilities file or resource info.
		 */
		public final native void setDescription(String description) /*-{
			this["description"] = description;
		}-*/;
		
		/**
		 * Set the format parameter.
		 * 
		 * @param format - Specify a format supported by the service.
		 */
		public final native void setFormat(String format) /*-{
			this["format"] = format;
		}-*/;
		
		/**
		 * Set the fullExtent parameter.
		 * 
		 * @param fullExtent - The full extent of the WMTS layer.
		 */
		public final native void setFullExtent(Extent fullExtent) /*-{
			this["fullExtent"] = fullExtent;
		}-*/;
		
		/**
		 * Set the identifier parameter.
		 * 
		 * @param identifier - The layer id.
		 */
		public final native void setIdentifier(String identifier) /*-{
			this["identifier"] = identifier;
		}-*/;
		
		/**
		 * Set the initialExtent parameter.
		 * 
		 * @param initialExtent - The initial extent of the WMTS layer.
		 */
		public final native void setInitialExtent(Extent initialExtent) /*-{
			this["initialExtent"] = initialExtent;
		}-*/;
		
		/**
		 * Set the style parameter.
		 * 
		 * @param style - Specify the layer style.
		 */
		public final native void setStyle(String style) /*-{
			this["style"] = style;
		}-*/;
		
		/**
		 * Set the tileInfo parameter.
		 * 
		 * @param tileInfo - A tile info object . Note that the level property of the lods is the 
		 * name of the tile matrix followed by the level number.
		 */
		public final native void setTileInfo(TileInfo tileInfo) /*-{
			this["tileInfo"] = tileInfo;
		}-*/;
		
		/**
		 * Set the tileMatrixSet parameter.
		 * 
		 * @param tileMatrixSet - Define the tileMatrixSet for the layer.
		 */
		public final native void setTileMatrixSet(String tileMatrixSet) /*-{
			this["tileMatrixSet"] = tileMatrixSet;
		}-*/;
		
		/**
		 * Set the title parameter.
		 * 
		 * @param title - The layer title.
		 */
		public final native void setTitle(String title) /*-{
			this["title"] = title;
		}-*/;
		
	}
	
}
