package edu.ucdavis.cstars.client.dijits;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.MapWidget;

/**
 * The scalebar widget displays a scalebar on the map or in a specified HTML node. The widget respects
 * various coordinate systems and displays units in english or metric values. When working with Web
 * Mercator or geographic coordinate systems the scalebar takes into account projection distortion
 * and dynamically adjusts the scalebar. The Scalebar sample,which uses a map using the Web Mercator
 * projection, shows this behavior. Open the sample and note that as you pan the map south towards
 * the equator the scalebar gets shorter and as you pan north it gets longer.
 * 
 * The location of the scalebar is used to calculate the scale, when the scalebar is positioned outside the map div the following values are used:
 *  - If the scalebar is above the map,the upper border of the map is used.
 *  - If the scalebar is below the map,the lower border of the map is used.
 *  - If the scalebar is positioned next to the map its vertical location is used.
 * 
 * @author Justin Merz
 */
public class Scalebar {

	public static enum AttachTo {
		TOP_RIGHT("top-right"),
		BOTTOM_RIGHT("bottom-right"),
		TOP_CENTER("top-center"),
		BOTTOM_CENTER("bottom-center"),
		BOTTOM_LEFT("bottom-left"),
		TOP_LEFT("top-left");
		private String val;
		private AttachTo(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum ScalebarUnit {
		ENGLISH("english"),
		METRIC("metric"),
		/** @since 3.4 */
		DUAL("dual");
		private String val;
		private ScalebarUnit(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected JavaScriptObject jso;
	
	/**
	 * Creates a new Scalebar dijit. The Scalebar constructor should be called after the map is loaded,
	 * e.g., in the map's onLoad event.
	 * 
	 * @param params - Parameters used to configure the widgit.
	 */
	public Scalebar(Parameters params) {	
		if( !assertLoaded() ) return; 	
		jso = create(params);
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.Scalebar(params);
	}-*/;
	
	/**
	 * Check that the esri.dijit.Scalebar package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.Scalebar ) return true;
		$wnd.alert("The ESRI_DIJIT_SCALEBAR has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Hide the scalebar dijit.
	 */
	public native void hide() /*-{
		this.@edu.ucdavis.cstars.client.dijits.Scalebar::jso.hide();
	}-*/;
	
	/**
	 * Set the scalebar's visibility to true. This method only applies if the scalebar has been hidden using scalebar.hide.
	 */
	public native void show() /*-{
		this.@edu.ucdavis.cstars.client.dijits.Scalebar::jso.show();
	}-*/;
	
	public static class Parameters extends JavaScriptObject {
	
		protected Parameters() {}
		
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param attachTo - Specify the scalebar position on the map. Valid options are "top-right",
		 * "bottom-right","top-center","bottom-center","bottom-left","top-left". The default value
		 * is "bottom-left".
		 */
		public final void setAttachTo(AttachTo attachTo) {
			_setAttachTo(attachTo.getValue());
		}
		
		private final native void _setAttachTo(String attachTo) /*-{
			this["attachTo"] = attachTo;
		}-*/;
		
		/**
		 * 
		 * @param map - Reference to the map. The map parameter is required.
		 */
		public final void setMap(MapWidget map) {
			_setMap(map.getMapObject());
		}
		
		public final native void _setMap(JavaScriptObject map) /*-{
			this["map"] = map;
		}-*/;
		
		/**
		 * 
		 * @param unit - Specify the scalebar units. Valid values are "english" or "metric".
		 * The default value is "english".
		 */
		public final void setScalebarUnit(ScalebarUnit unit) {
			_setScalebarUnit(unit.getValue());
		}
		
		private final native void _setScalebarUnit(String scalebarUnit) /*-{
			this["scalebarUnit"] = scalebarUnit;
		}-*/;
	}
	
}
