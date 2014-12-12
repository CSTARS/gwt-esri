package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.layers.Layer;

/**
 * The OverviewMap widget displays the current extent of the map within
 * the context of a larger area. The OverviewMap updates whenever the map
 * map extent changes. The extent of the main map is represented in the
 * overview map area as a rectangle. The extent rectangle can be dragged
 * to modify the extent of the main map. The OverviewMap can be displayed
 * several ways:
 *  - Attach the overview map to a corner of the main map and hide when not in use.
 *  - Render the overview map in a div element outside the main map window.
 *  - Temporarily maximize the overview map for quick access to far away areas of interest.
 * 
 * @author Justin Merz
 */
public class OverviewMap extends Composite {

	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	private JavaScriptObject jso;
	
	/**
	 * Creates a new OverviewMap object.
	 * 
	 * @param params - Parameters that define the functionality of the OverviewMap widget.
	 */
	public OverviewMap(Parameters params) {
		
		if( !assertLoaded() ) return; 
		
		parameters = params;
		
		initWidget(panel);
		jso = create(parameters);
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.OverviewMap(params);
	}-*/;
	
	/**
	 * Check that the esri.dijit.OverviewMap package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.OverviewMap ) return true;
		$wnd.alert("The ESRI_DIJIT_OVERVIEWMAP has not been loaded");
		return false;
	}-*/;

	/**
	 * Releases the resources used by the dijit. Call this method when an instance
	 * of this dijit is no longer needed.
	 */
	public void destroy() {
		_destroy();
		if( isAttached() ) removeFromParent();
	}

	private final native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.dijits.OverviewMap::jso.destroy();
	}-*/;
	
	/**
	 * Finalizes the creation of the OverviewMap dijit. Call this method after the
	 * constructor for the dijit is called and before users interact with the dijit.
	 */
	public final native void startup() /*-{
		this.@edu.ucdavis.cstars.client.dijits.OverviewMap::jso.startup();
	}-*/;
		
	public static class Parameters extends JavaScriptObject {
	
		protected Parameters() {}
		
		/**
		 * 
		 * @return Parameters
		 */
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param attachTo - Specifies which corner of the map to attach the
		 * OverviewMap dijit. Valid values are: "top-right","bottom-right",
		 * "bottom-left" and "top-left". The default value is "top-right".
		 */
		public final native void setAttachTo(String attachTo) /*-{
			this["attachTo"] = attachTo;
		}-*/;
		
		/**
		 * 
		 * @param baseLayer - Specify the base layer for the overview map. Note
		 * that the specified layer must be loaded, verify this using the
		 * layer's loaded property. If a base layer is not specified the dijit
		 * will use a copy of the main map's base layer. Valid layers are
		 * ArcGISDynamicMapServiceLayer,ArcGISTiledMapServiceLayer,
		 * OpenStreetMapLayer and VETiledLayer.
		 */
		public final native void setBaseLayer(Layer baseLayer) /*-{
			this["baseLayer"] = baseLayer;
		}-*/;
		
		/**
		 * 
		 * @param color - Fill color for the extent rectangle. The default value is #000000.
		 */
		public final native void setColor(String color) /*-{
			this["color"] = color;
		}-*/;
		
		/**
		 * 
		 * @param expandFactor - The ratio between the size of the overview map
		 * and the extent rectangle displayed on the overview map. The default
		 * value is 2, meaning the overview map will be at least twice the size
		 * of the extent rectangle.
		 */
		public final native void setExpandFactor(int expandFactor) /*-{
			this["expandFactor"] = expandFactor;
		}-*/;
		
		/**
		 * 
		 * @param height - Height of the overview map dijit in screen pixels. The
		 * default value is 1/4th the height of the map.
		 */
		public final native void setHeight(int height) /*-{
			this["height"] = height;
		}-*/;
		
		/**
		 * 
		 * @param id - Unique identifier for the dijit. If specified this can be
		 * used with dijit.byId to get a reference to the dijit, or with
		 * dojo.byId to get a reference to the DOM node associated with the
		 * dijit.
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * 
		 * @param map - Reference to the map. The map parameter is required.
		 */
		public final void setMap(MapWidget map) {
			_setMap(map.getMapObject());
		}
		
		private final native void _setMap(JavaScriptObject map) /*-{
			this["map"] = map;
		}-*/;
		
		/**
		 * 
		 * @param showButton - Defines the visibility of the maximize/restore button
		 * When true, the button is visible. The default value is false.
		 */
		public final native void showMaximizeButton(boolean showButton) /*-{
			this["maximizeButton"] = showButton;
		}-*/;
		
		/**
		 * 
		 * @param opacity - Opacity of the extent rectangle, defined as a number
		 * between 0 (invisible) and 1 (opaque). The default value is 0.5.
		 */
		public final native void setOpacity(float opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * 
		 * @param visible - Specifies the initial visibility of the overview map.
		 * The default value is false.
		 */
		public final native void setVisible(boolean visible) /*-{
			this["visible"] = visible;
		}-*/;
		
		/**
		 * 
		 * @param width - Width of the overview map dijit in screen pixels. The
		 * default value is 1/4th the width of the map.
		 */
		public final native void setWidth(int width) /*-{
			this["width"] = width;
		}-*/;
		
	}
	
}
