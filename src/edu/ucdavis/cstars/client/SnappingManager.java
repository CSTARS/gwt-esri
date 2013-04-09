package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.geometry.Point;
import edu.ucdavis.cstars.client.layers.Layer;
import edu.ucdavis.cstars.client.symbol.SimpleMarkerSymbol;

/**
 * The SnappingManager is used to add snapping capability to the Editor, Measurement Widget, Draw toolbar and Edit toolbar.
 * 
 * @author Justin Merz
 */
public class SnappingManager extends JavaScriptObject {
	
	protected SnappingManager() {}
	
	/**
	 * Create a new SnappingManager object. It is not required to create a SnappingManager 
	 * object to enable snapping for the Editor, Measurement or Draw and Edit Toolbars. To 
	 * enable snapping, call the map's enableSnapping method. Create a new snapping manager 
	 * object if the default options need to be modified.
	 * 
	 * @return SnappingManager
	 */
	public static SnappingManager create() {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create();
	}
	
	private static native SnappingManager _create() /*-{
		return $wnd.esri.SnappingManager();
	 }-*/;
	
	/**
	 * Create a new SnappingManager object. It is not required to create a SnappingManager 
	 * object to enable snapping for the Editor, Measurement or Draw and Edit Toolbars. To 
	 * enable snapping, call the map's enableSnapping method. Create a new snapping manager 
	 * object if the default options need to be modified.
	 * 
	 * @param Options - Optional parameters.
	 * @return SnappingManager
	 */
	public static SnappingManager create(SnappingOptions options) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(options);
	}
	
	private static native SnappingManager _create(SnappingOptions options) /*-{
		return $wnd.esri.SnappingManager(options);
	 }-*/;
	
	/**
	 * Check that the esri.SnappingManager has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.SnappingManager ) return true;
		$wnd.alert("The ESRI_SNAPPINGMANAGER package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Destroy the SnappingManager object. All related objects will be set to null.
	 */
	public final native void destroy() /*-{
		this.destroy();
	}-*/;
	
	/**
	 * Returns a deferred object, which can be added to a callback to find the snap point.
	 * 
	 * @param screenPoint - The input screen point for which to find the snapping location.
	 * @return Deferred
	 */
	public final native Deferred getSnappingPoint(Point screenPoint) /*-{
		return this.getSnappingPoint(screenPoint);
	 }-*/;
	
	/**
	 * An array of layerInfo objects used to specify the target snapping layers.
	 * 
	 * @param layerInfos - An array of layerInfo objects that define the snapping target layers.
	 * All values are optional. If no snapping options are set the default values will be used.
	 */
	public final void setLayerInfos(LayerInfos[] layerInfos) {
		_setLayerInfos(Util.objectArrayToJSO(layerInfos));
	};
	
	private final native void _setLayerInfos(JavaScriptObject layerInfos) /*-{
		this.setLayerInfos(layerInfos);
	}-*/;
	
	public static class SnappingOptions extends JavaScriptObject  {
		
		protected SnappingOptions() {}
		
		public static SnappingOptions create() {
			return JavaScriptObject.createObject().cast();
		};

		/**
		 * Set the alwaysSnap parameter.
		 * 
		 * @param alwaysSnap - When true, snapping is always enabled. When false users press the snapKey 
		 * to enable snapping. Default value is false.
		 */
		public final native void setAlwaysSnap(boolean alwaysSnap) /*-{
			this["alwaysSnap"] = alwaysSnap;
		}-*/;
		
		/**
		 * Set the layerInfos parameter.
		 * 
		 * @param layerInfos - An array of layerInfo objects that define the snapping target layers. All values
		 * are optional. If no snapping options are set the default values will be used.
		 */
		public final void setLayerInfos(LayerInfos[] layerInfos) {
			_setLayerInfos(Util.objectArrayToJSO(layerInfos));
		};
		
		private final native void _setLayerInfos(JavaScriptObject layerInfos) /*-{
			this["layerInfos"] = layerInfos;
		}-*/;
		
		/**
		 * Set the map parameter.
		 * 
		 * @param map - Reference to the map. Required parameter.
		 */
		public final void setMap(MapWidget map) {
			_setMap(map.getMapObject());
		}

		private final native void _setMap(JavaScriptObject map) /*-{
			this["map"] = map;
		}-*/;
		
		// TODO: create dojo.keys
		/**
		 * Set the snapKey parameter.
		 * 
		 * @param - When alwaysSnap is set to false use this option to define the key users press
		 * to enable snapping. The default values is the CTRL key.
		 */
		public final native void setSnapKey(int key) /*-{
			this["snapKey"] = key;
		}-*/;
		
		/**
		 * Set the snapPointSymbol parameter.
		 * 
		 * @param snapPointSymbol - Define a symbol for the snapping location. The default symbol
		 * is a simple marker symbol with the following properties: size:15px,color:cyan, style:STYLE_CROSS.
		 */
		public final native void setSnapPointSymbol(SimpleMarkerSymbol snapPointSymbol) /*-{
			this["snapPointSymbol"] = snapPointSymbol;
		}-*/;
		
		/**
		 * Set the tolerance parameter.
		 * 
		 * @param tolerance - Specify the radius of the snapping circle in pixels. The default value is 15 pixels.
		 */
		public final native void setTolerance(int tolerance) /*-{
			this["tolerance"] = tolerance;
		}-*/;
		
	}
	
	public static class LayerInfos extends JavaScriptObject {
		
		protected LayerInfos() {}
		
		/**
		 * Create new LayerInfos object.
		 * 
		 * @return LayerInfos
		 */
		public static LayerInfos create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 *  Create new LayerInfos object.
		 * 
		 * @param layer - Reference to a feature or graphics layer that will be a target snapping layer. 
		 * The default option is to set all feature and graphics layers in the map to be target snapping layers.
		 * @param snapToPoint - Default is true. When true snapping to points will be enabled for layers with point geometry.
		 * @param snapToVertex - Default is true. When true snapping to vertices will be enabled for layers with polyline or polygon geometry.
		 * @param snapToEdge - Default is true. When true snapping to edges will be enabled for layers with polyline or polygon geometry.
		 * @return LayerInfos
		 */
		public static native LayerInfos create(Layer layer, boolean snapToPoint, boolean snapToVertex, boolean snapToEdge) /*-{
			return {layer:layer, snapToPoint: snapToPoint, snapToVertex: snapToVertex, snapToEdge:snapToEdge};
		}-*/;
		
		/**
		 * Set the layer parameter.
		 * 
		 * @param layer - Reference to a feature or graphics layer that will be a target snapping layer. 
		 * The default option is to set all feature and graphics layers in the map to be target snapping layers.
		 */
		public final native void setLayer(Layer layer) /*-{
			this["layer"] = layer;
		}-*/;
		
		/**
		 * Set the snapToPoint parameter.
		 * 
		 * @param snapToPoint - Default is true. When true snapping to points will be enabled for layers with point geometry.
		 */
		public final native void setSnapToPoint(boolean snapToPoint) /*-{
			this["snapToPoint"] = snapToPoint;
		}-*/;
		
		/**
		 * Set the snapToVertex parameter.
		 * 
		 * @param snapToVertex - Default is true. When true snapping to points will be enabled for layers with point geometry.
		 */
		public final native void setSnapToVertex(boolean snapToVertex) /*-{
			this["snapToVertex"] = snapToVertex;
		}-*/;
		
		/**
		 * Set the snapToEdge parameter.
		 * 
		 * @param snapToEdge - Default is true. When true snapping to points will be enabled for layers with point geometry.
		 */
		public final native void setSnapToEdge(boolean snapToEdge) /*-{
			this["snapToEdge"] = snapToEdge;
		}-*/;
		
	}

}
