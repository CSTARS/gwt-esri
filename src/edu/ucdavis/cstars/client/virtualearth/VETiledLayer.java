package edu.ucdavis.cstars.client.virtualearth;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.layers.TiledMapServiceLayer;

/**
 * Bing Maps tiled layer. 
 * 
 * @author Justin Merz
 */
public class VETiledLayer extends TiledMapServiceLayer {
	
	public enum MapStyle {
		MAP_STYLE_AERIAL("aerial"),
		MAP_STYLE_AERIAL_WITH_LABELS("aerialWithLabels"),
		MAP_STYLE_ROAD("road");
		
		private String val = "";
		MapStyle(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
	}

	protected VETiledLayer() {}
	
	/**
	 * Creates a new VETiledLayer object.
	 * 
	 * @param options
	 * @return VETiledLayer
	 */
	public static VETiledLayer create(Options options) {
		// if not loaded return empty object
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		
		return _create(options);
	}
	
	private static native VETiledLayer _create(Options options) /*-{
		return new $wnd.esri.virtualearth.VETiledLayer(options);
	}-*/;
	
	/**
	 * Check that the esri.virtualearth.VETiledLayer package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.virtualearth.VETiledLayer ) return true;
		$wnd.alert("The ESRI_VIRTUALEARTH_VETILEDLAYER has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Specifies the culture in which to return results. The default value is "en-US". For a list of supported cultures,
	 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
	 * 
	 * @return String
	 */
	public final native String getCulture() /*-{
		return this.culture;
	}-*/;
	
	/**
	 * Bing Maps style. See Constants table for valid values.
	 * Default value: MAP_STYLE_ROAD
	 * 
	 * @return MapStyle
	 */
	public final MapStyle getMapStyle() {
		String ms = _getMapStyle();
		for( int i = 0 ; i < MapStyle.values().length; i++ ){
			if( MapStyle.values()[i].getValue().contentEquals(ms) )
				return MapStyle.values()[i];
		}
		return MapStyle.MAP_STYLE_ROAD;
	};
	
	private final native String _getMapStyle() /*-{
		return this.mapStyle;
	}-*/;
	
	/**
	 * Set the culture parameter.
	 * 
	 * @param culture -The culture value. The default value is "en-US". For a list of supported cultures,
	 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
	 */
	public final native void setCulture(String culture) /*-{
		this.setCulture(culture);
	}-*/;
	
	/**
	 * Set the mapStyle parameter.
	 * 
	 * @param mapStyle - Bing Maps style.
	 */
	public final void setMapStyle(MapStyle mapStyle) {
		_setMapStyle(mapStyle.getValue());
	};
	
	private final native void _setMapStyle(String mapStyle) /*-{
		this.setMapStyle(mapStyle);
	}-*/;
	
	/**
	 * Options object for VETiledLayer
	 */
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param bingMapsKey - Key used to access Bing Maps maps.
		 */
		public final native void setBingMapsKey(String bingMapsKey) /*-{
			this["bingMapsKey"] = bingMapsKey;
		}-*/;
		
		/**
		 * 
		 * @param culture - Specifies the culture in which to return results. The default value is "en-US". For a list of supported cultures,
		 * see http://msdn.microsoft.com/en-us/library/cc981048.aspx.
		 */
		public final native void setCulture(String culture) /*-{
			this["culture"] = culture;
		}-*/;
		
		/**
		 * 
		 * @param mapStyle - Bing Maps style.
		 */
		public final void setMapStyle(MapStyle mapStyle) {
			_setMapStyle(mapStyle.getValue());
		}
		
		private final native void _setMapStyle(String mapStyle) /*-{
			this["mapStyle"] = mapStyle;
		}-*/;
		
	}
	
}
