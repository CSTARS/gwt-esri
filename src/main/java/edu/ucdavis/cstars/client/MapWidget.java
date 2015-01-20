package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ucdavis.cstars.client.SnappingManager.SnappingOptions;
import edu.ucdavis.cstars.client.control.Control;
import edu.ucdavis.cstars.client.control.ControlHandler;
import edu.ucdavis.cstars.client.dijits.InfoWindow;
import edu.ucdavis.cstars.client.dijits.TimeSlider;
import edu.ucdavis.cstars.client.event.ClickHandler;
import edu.ucdavis.cstars.client.event.DblClickHandler;
import edu.ucdavis.cstars.client.event.MapExtentChangeHandler;
import edu.ucdavis.cstars.client.event.MapKeyDownHandler;
import edu.ucdavis.cstars.client.event.MapKeyUpHandler;
import edu.ucdavis.cstars.client.event.MapLayerAddHandler;
import edu.ucdavis.cstars.client.event.MapLayerAddResultHandler;
import edu.ucdavis.cstars.client.event.MapLayerRemoveHandler;
import edu.ucdavis.cstars.client.event.MapLayerReorderHandler;
import edu.ucdavis.cstars.client.event.MapLayersAddResultHandler;
import edu.ucdavis.cstars.client.event.MapLayersRemovedHandler;
import edu.ucdavis.cstars.client.event.MapLayersReorderedHandler;
import edu.ucdavis.cstars.client.event.MapLoadHandler;
import edu.ucdavis.cstars.client.event.MapMouseDragEndHandler;
import edu.ucdavis.cstars.client.event.MapMouseDragHandler;
import edu.ucdavis.cstars.client.event.MapMouseDragStartHandler;
import edu.ucdavis.cstars.client.event.MapPanEndHandler;
import edu.ucdavis.cstars.client.event.MapPanHandler;
import edu.ucdavis.cstars.client.event.MapPanStartHandler;
import edu.ucdavis.cstars.client.event.MapRepositionHandler;
import edu.ucdavis.cstars.client.event.MapResizeHandler;
import edu.ucdavis.cstars.client.event.MapUnloadHandler;
import edu.ucdavis.cstars.client.event.MapZoomEndHandler;
import edu.ucdavis.cstars.client.event.MapZoomHandler;
import edu.ucdavis.cstars.client.event.MapZoomStartHandler;
import edu.ucdavis.cstars.client.event.MouseDownHandler;
import edu.ucdavis.cstars.client.event.MouseMoveHandler;
import edu.ucdavis.cstars.client.event.MouseOutHandler;
import edu.ucdavis.cstars.client.event.MouseOverHandler;
import edu.ucdavis.cstars.client.event.MouseUpHandler;
import edu.ucdavis.cstars.client.event.MouseWheelHandler;
import edu.ucdavis.cstars.client.event.TimeExtentChangeHandler;
import edu.ucdavis.cstars.client.event.UpdateEndHandler;
import edu.ucdavis.cstars.client.event.UpdateStartHandler;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;
import edu.ucdavis.cstars.client.layers.GraphicsLayer;
import edu.ucdavis.cstars.client.layers.LOD;
import edu.ucdavis.cstars.client.layers.Layer;


/**
 * Basic Map class with all the navigation functionalities.
 * 
 * The Map.onLoad event is fired after the first layer has been added to the map. 
 * At this point, the map is fully functional. A Map.onLoad handler function should 
 * be used to add content and change map behaviors. 
 * 
 * @author Justin Merz
 */
public class MapWidget {
  // counter used for creating unique map id's
  private static int nextMapId = 0;

	// esri.map object
	private JavaScriptObject map = null;
	
	// Gwt added Control Layer
	private AbsolutePanel controlLayer = new AbsolutePanel();
	private ControlHandler controlHandler;
	
	// Div that esri.map will be constructed with
	//private final FlowPanel mapContainer = new FlowPanel();
	//private FlowPanel mapRoot = null;
	private SimplePanel mapPanel = null;
	
	// Initial options supplied to contructor
	//private MapLoadHandler onLoadHandler = null;
	//private Layer initLayer = null;
	
	/**
	 * Creates a new map. 
	 * 
	 * @param initializationLayer - Layer map will be initialized to.  After the map is added to the dom, this will be
	 * the first layer added to the map.  Once the map is initialized the onLoad handler will be called.  Can be null.
	 * @param onLoad - This is the map load handler to be fired once the map as been added to the dom and the
	 * first layer has been initialized.  Can be null. 
	 */
	public MapWidget(SimplePanel mapPanel, MapLoadHandler onLoad) {
	  this(mapPanel, onLoad, null);
	}

	/**
	 * Creates a new Map.
	 * 
	 *  @param initializationLayer - Layer map will be initialized to.  After the map is added to the dom, this will be
	 *  the first layer added to the map.  Once the map is initialized the onLoad handler will be called.
	 *  @param onLoad - This is the map load handler to be fired once the map as been added to the dom and the
	 *  first layer has been initialized.  Can be null. 
	 * @param options - Optional parameters for the map.
	 */
	public MapWidget(SimplePanel mapPanel, MapLoadHandler onLoad, Options options) {
	  assertLoaded();
	    
	  this.mapPanel = mapPanel;
	  
	  // The ESRI api requires the wrapping div to have an id so automatically add one
	  // if there isn't one set already...
	  if (mapPanel.getElement() == null) {
	    mapPanel.getElement().setId("map-widget-" + (++nextMapId));
	  }

	  if (options == null) {
	    map = create(mapPanel.getElement().getId());
	  }
	  else {
	    map = create(mapPanel.getElement().getId(), options);
	  }
	  
	  if( onLoad != null ) addLoadHandler(onLoad);
	   
		// TODO: inject controls layer
		initControls();
	}
	
	private void initControls() {
		controlLayer.getElement().getStyle().setZIndex(1000);
		
		// TODO: inject the controls layer back into the map
		mapPanel.add(controlLayer);
		
		controlHandler = new ControlHandler(this, controlLayer);
	}
	
	/**
	 * Add new control to the Control Layer.  
	 * 
	 * The control layer is not apart of the ESRI library, rather an
	 * added component in the GWT library. 
	 * 
	 * @param control - Control to be added to the map
	 */
	public void addControl(Control control) {
		controlHandler.addControl(control);
	}
	
	/**
	 * Remove control from the Control Layer.
	 * 
	 * The control layer is not apart of the ESRI library, rather an
	 * added component in the GWT library. 
	 * 
	 * @param control - Control to be removed
	 */
	public void removeControl(Control control){
		controlHandler.removeControl(control);
	}
	
	/**
	 * Make sure the $wnd.esri library has been loaded.  Alert error
	 * message and return false if it has not been loaded.  Othewise
	 * return true.
	 * 
	 * @return boolean
	 */
	public static final native boolean assertLoaded() /*-{
		if( !$wnd.esri ) {
			$wnd.alert("ESRI API is not loaded!");
			return false;
		}
		if( $wnd.esri.Map ) return true;
		$wnd.alert("ESRI API is not loaded!");
		return false;
	}-*/;
	
	/**
	 * Return the actual ersi.map object that has been created
	 * 
	 * @return JavaScriptObject
	 */
	public JavaScriptObject getMapObject() {
		return this.map;
	}
	
	public SimplePanel getMapPanel() {
		return mapPanel;
	}
	
	/**
	 * Updates the MapWidget's size.  If the map has been loaded, resize() will be called automatically.  If the map hasn't loaded (attached
	 * to the DOM with at least one layer loaded) you need to call resize() once the map is loaded or bad things will happen.
	 * You can add an event listener to onMapLoad to know when the map is loaded.
	 * 
	 * @param width - width MapWidget should be set to
	 * @param height - height MapWidget should be set to
	 */
	public void setSize(String width, String height){
		setWidth(width);
		setHeight(height);
		if( isLoaded() ) resize();
	}
	
	/**
	 * Updates the MapWidget's width.  If the map has been loaded, resize() will be called automatically.  If the map hasn't loaded (attached
	 * to the DOM with at least one layer loaded) you need to call resize() once the map is loaded or bad things will happen.
	 * You can add an event listener to onMapLoad to know when the map is loaded.
	 * 
	 * @param width - width MapWidget should be set to
	 */
	public void setWidth(String width){
		mapPanel.setWidth(width);
		if( isLoaded() ) resize();
	}
	
	/**
	 * Updates the MapWidget's height.  If the map has been loaded, resize() will be called automatically.  If the map hasn't loaded (attached
	 * to the DOM with at least one layer loaded) you need to call resize() once the map is loaded or bad things will happen.
	 * You can add an event listener to onMapLoad to know when the map is loaded.
	 * 
	 * @param height - height MapWidget should be set to
	 */
	public void setHeight(String height){
		mapPanel.setHeight(height);
		if( isLoaded() ) resize();
	}
	
	/* 
	 * JSNI Map Constructors 
	 * /
	
	/*
	 * Create esri.map object using DOM element
	 */
	private native JavaScriptObject create(String id) /*-{
		var map = new $wnd.esri.Map(id);
		map["__gwt_MapWidget"] = this;
		return map;
	}-*/;
	
	/*
	 * Create esri.map object for IE using id of Div element and options
	 */
	private native JavaScriptObject create(String id, Options options) /*-{
		var map = new $wnd.esri.Map(id, options);
		map["__gwt_MapWidget"] = this;
		return map;
	}-*/;
	
	public void addInfoWindow(Widget panel) {
		// TODO: figure this out in new strategy
		//mapContainer.add(panel);
	}
	
	/*
	 * Map Properties
	 */
	/**
	 * The current extent of the map in map units. 
	 * 
	 * @return boolean
	 */
	public native Extent getExtent() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.extent;
	}-*/;
	
	/**
	 * Indicates if the fade effect is enabled while zooming. Only applicable when navigationMode is set to 'css-transforms'.
	 * 
	 * @return boolean
	 */
	public native boolean isFadeOnZoom() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.fadeOnZoom;
	}-*/;
	
	/**
	 * When the mapNavigation mode is set to 'css-transforms', CSS3 transforms will be used for map navigation when supported 
	 * by the browser. It is recommended that you let the map determine when to enable transformations to avoid running into 
	 * a known issue with scrollbar rendering on Chrome on Windows XP.
	 * 
	 * @return boolean
	 */
	public native boolean isForce3DTransforms() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.force3DTransforms;
	}-*/;
	
	/**
	 * Add and remove graphics from the GraphicsLayer.
	 * 
	 * @return GraphicsLayer
	 */
	public native GraphicsLayer getGraphics() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.graphics;
	}-*/;

	/**
	 * An array of the current GraphicsLayers in the map.
	 * 
	 * @return JsArrayString
	 */
	public native JsArrayString getGraphicsLayerIds() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.graphicsLayerIds;
	}-*/;
	
	/**
	 * Current height of the map in screen pixels.
	 * 
	 * @return int
	 */
	public native int getHeight() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.height;
	}-*/;
	
	/**
	 * Reference to HTML DIV or other element where the map is placed 
	 * on the page. This property is set in the Map constructor.
	 * 
	 * @return String
	 */
	public native String getId() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.id;
	}-*/;
	
	/**
	 * Displays the InfoWindow on a map.
	 * 
	 * @return InfoWindow
	 */
	public native InfoWindow getInfoWindow() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.infoWindow;
	}-*/;
	
	/**
	 * When true, the key sequence of shift then click to recenter the map is enabled.
	 * 
	 * @return boolean
	 */
	public native boolean isClickRecenter() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isClickRecenter;
	}-*/;
	
	/**
	 * When true, double click zoom is enabled. This allows a user to zoom and recenter
	 * the map by double clicking the mouse.
	 * 
	 * @return boolean
	 */
	public native boolean isDoubleClickZoom() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isDoubleClickZoom;
	}-*/;
	
	/**
	 * When true, double click zoom is enabled. This allows a user to zoom and recenter
	 * the map by double clicking the mouse.
	 * 
	 * @return boolean
	 */
	public native boolean isKeyboardNavigation() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isKeyboardNavigation;
	}-*/;
	
	/**
	 * When true, map panning is enabled using the mouse.
	 * 
	 * @return boolean
	 */
	public native boolean isPan() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isPan;
	}-*/;
	
	/**
	 * When true, pan arrows are displayed around the edge of the map.
	 * 
	 * @return boolean
	 */
	public native boolean isPanArrows() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isPanArrows;
	}-*/;
	
	/**
	 * When true, rubberband zoom is enabled. This allows users to draw
	 * a bounding box zoom area using the mouse.
	 * 
	 * @return boolean
	 */
	public native boolean isRubberBandZoom() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isRubberBandZoom;
	}-*/;
	
	/**
	 * When true, the mouse scroll wheel zoom is enabled.
	 * 
	 * @return boolean
	 */
	public native boolean isScrollWheelZoom() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isScrollWheelZoom;
	}-*/;
	
	/**
	 * When true, shift double click zoom is enabled. This allows a user to 
	 * zoom and recenter the map by shift + double clicking the mouse.
	 * 
	 * @return boolean
	 */
	public native boolean isShiftDoubleClickZoom() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isShiftDoubleClickZoom;
	}-*/;
	
	/**
	 * When true, the zoom slider is displayed on the map.
	 * 
	 * @return boolean
	 */
	public native boolean isZoomSlider() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.isZoomSlider;
	}-*/;
	
	/**
	 * Array of current TiledMapServiceLayers and DynamicMapServiceLayers 
	 * added to the map.
	 * 
	 * @return JsArrayString
	 */
	public native JsArrayString getLayerIds() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.layerIds;
	}-*/;
	
	/**
	 * After the first layer is loaded, the value is set to true.
	 * 
	 * @return boolean
	 */
	public native boolean isLoaded() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.loaded;
	}-*/;
	
	/**
	 * Indicates whether the map uses CSS3 transformations when panning and zooming. In 
	 * 'css-transform' mode the map will use CSS3 transformations, if supported by the 
	 * browser, to provide a smoother experience while panning and zooming the map.
	 * 
	 * @return String
	 */
	public native String getNavigationMode() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.navigationMode;
	}-*/;
	
	/**
	 * This point geometry in screen coordinates represent the top-left corner
	 * of the map container. This coordinate also acts as the origin for all
	 * screen coordinates returned by Map and GraphicsLayer events.
	 * 
	 * @return Point
	 */
	public native Point getPosition() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.position;
	}-*/;
	
	/**
	 * The DOM node that contains the container of layers, build-in info window, logo and slider. (As of v2.2)
	 * 
	 * @return Element
	 */
	public native Element getRoot() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.root;
	}-*/;
	
	/**
	 * If snapping is enabled on the map using map.enableSnapping() this property provides access to the 
	 * SnappingManager. The snapping manager's setLayerInfo method can be used to modify the target 
	 * snapping layers.
	 * 
	 * @return SnappingManager
	 */
	public native SnappingManager getSnappingManager() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.snappingManager;
	}-*/;
	
	/**
	 * The spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public native SpatialReference getSpatialReference() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.spatialReference;
	}-*/;
	
	/**
	 * The current TimeExtent for the map. Use the setTimeExtent method to modify the time extent.
	 * 
	 * @return TimeExtent
	 */
	public native TimeExtent getTimeExtent() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.timeExtent;
	}-*/;
	
	/**
	 * Current width of the map in screen pixels.
	 * 
	 * @return int
	 */
	public native int getWidth() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.width;
	}-*/;
	
	
	
	/*
	 * Map Methods
	 */
	
	/**
	 * Adds an ESRI Layer to the map.
	 * 
	 * @param layer - Layer to be added to the map.
	 * @param index - A layer can be added at a specific index in the map.
	 */
	public native Layer addLayer(Layer layer, int index) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.addLayer(layer, index);
	}-*/;
	
	/**
	 * Adds an ESRI Layer to the map.
	 * 
	 * @param layer - Layer to be added to the map.
	 */
	public native Layer addLayer(Layer layer) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.addLayer(layer);
	}-*/;
	
	/**
	 * Adds multiple layers to a map. The array order corresponds to the layer order in the client side map. The onLayerAddResult
	 * event fires for each layer that is added. Once all the layers are added to the map the onLayersAddResult fires.
	 * 
	 * @param layers - Layers to be added to the map.
	 */
	public void addLayers(Layer[] layers) {
		_addLayers(Util.objectArrayToJSO(layers));
	};
	
	private native void _addLayers(JavaScriptObject layers) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.addLayers(layers);
	}-*/;
	
	/**
	 * Centers and zooms the map.
	 * 
	 * @param center - Centers the map on the specified x,y location.
	 * @param levelOrFactor - When using an ArcGISTiledMapServiceLayer, the map is zoomed 
	 * to the level specified. When using a DynamicMapServiceLayer, the map is zoomed in or 
	 * out by the specified factor. For example, use 0.5 to zoom in twice as far and 2.0 to zoom 
	 * out twice as far.
	 */
	public native void centerAndZoom(Point center, double levelOrFactor) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.centerAndZoom(center, levelOrFactor);
	}-*/;
	
	/**
	 * Recenters the map based on map coordinates as the center point.
	 * 
	 * @param center - Centers the map on the specified x,y location.
	 */
	public native void centerAt(Point center) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.centerAt(center);
	}-*/;
	
	/**
	 * Destroys the map instance.
	 */
	public void destroy() {
		_destroy();
	} 
	
	private native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.destroy();
	}-*/;
	
	/**
	 * Disallows clicking on a map to recenter it.
	 */
	public native void disableClickRecenter() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableClickRecenter();
	}-*/;
	
	/**
	 * Disallows double clicking on a map to zoom in a level and recenter the map.
	 */
	public native void disableDoubleClickZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableDoubleClickZoom();
	}-*/;
	
	/**
	 * Disallows panning and zooming using the keyboard.
	 */
	public native void disableKeyboardNavigation() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableKeyboardNavigation();
	}-*/;
	
	/**
	 * Disallows all map navigation except the slider and pan arrows.
	 */
	public native void disableMapNavigation() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableMapNavigation();
	}-*/;
	
	/**
	 * Disallows panning a map using the mouse.
	 */
	public native void disablePan() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disablePan();
	}-*/;
	
	/**
	 * Disallows zooming in or out on a map using a bounding box.
	 */
	public native void disableRubberBandZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableRubberBandZoom();
	}-*/;
	
	/**
	 * Disallows zooming in or out on a map using the mouse scroll wheel.
	 */
	public native void disableScrollWheelZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableScrollWheelZoom();
	}-*/;
	
	/**
	 * Disallows shift double clicking on a map to zoom in a level and recenter the map.
	 */
	public native void disableShiftDoubleClickZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableShiftDoubleClickZoom();
	}-*/;
	
	/**
	 * Disables snapping on the map.
	 */
	public native void disableSnapping() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.disableSnapping();
	}-*/;
	
	/**
	 * Permits users to click on a map to recenter it.
	 */
	public native void enableClickRecenter() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableClickRecenter();
	}-*/;
	
	/**
	 * Permits users to double click on a map to zoom in a level and recenter the map
	 */
	public native void enableDoubleClickZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableDoubleClickZoom();
	}-*/;
	
	/**
	 * Permits users to pan and zoom using the keyboard.
	 */
	public native void enableKeyboardNavigation() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableKeyboardNavigation();
	}-*/;
	
	/**
	 * Allows all map navigation.
	 */
	public native void enableMapNavigation() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableMapNavigation();
	}-*/;
	
	/**
	 * Permits users to pan a map using the mouse.
	 */
	public native void enablePan() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enablePan();
	}-*/;
	
	/**
	 * Permits users to zoom in or out on a map using a bounding box.
	 */
	public native void enableRubberBandZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableRubberBandZoom();
	}-*/;
	
	/**
	 * Permits users to zoom in or out on a map using the mouse scroll wheel. 
	 */
	public native void enableScrollWheelZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableScrollWheelZoom();
	}-*/;
	
	/**
	 * Permits users to shift double click on a map to zoom in a level and recenter the map.
	 */
	public native void enableShiftDoubleClickZoom() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.enableShiftDoubleClickZoom();
	}-*/;
	
	/**
	 * Enable snapping on the map when working with the Editor, Measurement widget or the Draw and 
	 * Edit toolbars. All graphics layers, including feature layers, will be set as snap targets.
	 * Call this method after the layers are loaded. 
	 * 
	 * @return SnappingManager
	 */
	public native SnappingManager enableSnapping() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.enableSnapping();
	}-*/;
	
	/**
	 * Enable snapping on the map when working with the Editor, Measurement widget or the Draw and Edit 
	 * toolbars. Call this method after the layers are loaded. 
	 * 
	 * @param options - optional parameters
	 * @return SnappingManager
	 */
	public native SnappingManager enableSnapping(SnappingOptions options) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.enableSnapping(options);
	}-*/;
	
	/**
	 * Sets an InfoWindow's anchor when calling InfoWindow.show
	 * 
	 * @param screenCoords - The anchor point in screen units.
	 * @return String
	 */
	public native String getInfoWindowAnchor(Point screenCoords) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.getInfoWindowAnchor(screenCoords);
	}-*/;
	
	/**
	 * Returns an individual layer of a map.
	 * 
	 * @param id - ID assigned to the layer.
	 * @return boolean
	 */
	public native Layer getLayer(String id) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.getLayer(id);
	}-*/;

	/**
	 * Gets the current level of detail ID for the map. Valid only with 
	 * an ArcGISTiledMapService layer.
	 * 
	 * @return float
	 */
	public native float getLevel() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.getLevel();
	}-*/;

	/**
	 * Hides the pan arrows from the map.
	 */
	public native void hidePanArrows() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.hidePanArrows();
	}-*/;
	
	/**
	 * Hides the zoom slider from the map.
	 */
	public native void hideZoomSlider() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.hideZoomSlider();
	}-*/;
	
	/**
	 * Pans the map south.
	 */
	public native void panDown() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panDown();
	}-*/;
	
	/**
	 * Pans the map west.
	 */
	public native void panLeft() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panLeft();
	}-*/;
	
	/**
	 * Pans the map southwest.
	 */
	public native void panLowerLeft() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panLowerLeft();
	}-*/;
	
	/**
	 * Pans the map southeast.
	 */
	public native void panLowerRight() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panLowerRight();
	}-*/;
	
	/**
	 * Pans the map east.
	 */
	public native void panRight() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panRight();
	}-*/;
	
	/**
	 * Pans the map north.
	 */
	public native void panUp() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panUp();
	}-*/;
	
	/**
	 * Pans the map northwest.
	 */
	public native void panUpperLeft() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panUpperLeft();
	}-*/;
	
	/**
	 * Pans the map northeast.
	 */
	public native void panUpperRight() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.panUpperRight();
	}-*/;

	/**
	 * Removes all layers from the map.
	 * 
	 * The map's extent, spatial reference, and tiling scheme if defined 
	 * do not change when the layers are removed. When the next layer is 
	 * added to the map, this layer is displayed at the same extent and 
	 * spatial reference.
	 */
	public native void removeAllLayers() /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.removeAllLayers();
	}-*/;

	/**
	 * Removes the specified layer from the map.
	 * 
	 * @param layer - Layer to be removed from the map.
	 */
	public native void removeLayer(Layer layer) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.removeLayer(layer);
	}-*/;

	/**
	 * Changes the layer order in the map.
	 * 
	 * @param layer - The layer to be moved.
	 * @param index - Refers to the location for placing the layer. The bottom 
	 * most layer has an index of 0.
	 */
	public native void reorderLayer(Layer layer, int index) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.reorderLayer(layer, index);
	}-*/;	
	
	/**
	 * Repositions the map DIV on the page. This method should be used after
	 * the map DIV has been repostioned.
	 */
	public native void reposition() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.reposition();
	}-*/;

	/**
	 * Resizes the map DIV. This method should be used after the map DIV has been resized.
	 */
	public native void resize() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.resize();
	}-*/;		
	
	/**
	 * Sets the extent of the map. The extent must be in the same spatial reference as the map.
	 * 
	 * @param extent - Sets the minx, miny, maxx, and maxy for a map.
	 * @param fit - When true, for maps that contain tiled map service layers, you are guaranteed 
	 * to have the input extent shown completely on the map.
	 */
	public native void setExtent(Extent extent, boolean fit) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setExtent(extent, fit);
	}-*/;
	
	/**
	 * Sets the extent of the map. The extent must be in the same spatial reference as the map.
	 * 
	 * @param extent - Sets the minx, miny, maxx, and maxy for a map.
	 */
	public native void setExtent(Extent extent) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setExtent(extent);
	}-*/;	
	
	/**
	 * Sets the map to the specified level ID. Zooms to the new level based on 
	 * the current map center point. Valid only with an ArcGISTiledMapService layer.
	 * 
	 * @param level - The level ID.
	 */
	public native void setLevel(int level) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setLevel(level);
	}-*/;

	/**
	 * Sets the default cursor for the map. This cursor is shown whenever the mouse
	 * is pointed over the map, except when panning by dragging the map or using
	 * SHIFT+Drag to zoom. If not set, the map uses the platform-dependent default
	 * cursor, usually an arrow.
	 * 
	 * @param cursor - A standard CSS cursor value. Some common values include "default",
	 * "pointer", "crosshair", "text", "help", and "wait".
	 */
	public native void setMapCursor(String cursor) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setMapCursor(cursor);
	}-*/;

	/**
	 * Sets the TimeExtent for the map. When the time extent is changed the onTimeExtentChange
	 * event fires. Time aware layers listen for this event and update to only display content for the
	 * current time extent.
	 * 
	 * @param timeExtent - Set the time extent for which data is displayed on the map.
	 */
	public native void setTimeExtent(TimeExtent timeExtent) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setTimeExtent(timeExtent);
	}-*/;
	
	/**
	 * Set the time slider associated with the map.
	 * 
	 * @param timeSlider - The time slider dijit to associate with the map.
	 */
	public void setTimeSlider(TimeSlider timeSlider) {
		_setTimeSlider(timeSlider.getTimeSliderObject());
	};
	
	private native void _setTimeSlider(JavaScriptObject timeSlider) /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.setTimeSlider(timeSlider);
	}-*/;
	
	/**
	 * Shows the pan arrows on the map.
	 */
	public native void showPanArrows() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.showPanArrows();
	}-*/;
	
	/**
	 * Shows the zoom slider on the map.
	 */
	public native void showZoomSlider() /*-{
		this.@edu.ucdavis.cstars.client.MapWidget::map.showZoomSlider();
	}-*/;
	
	/**
	 * Converts a single screen point or an array of screen points to map coordinates.
	 * 
	 * @param screenPoint - Converts screen coordinates to map coordinates.
	 * @return Point
	 */
	public final native Point toMap(Point screenPoint) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.toMap(screenPoint);
	}-*/;

	/**
	 * Converts a single map point or an array of map points to screen coordinates.
	 * 
	 * @param mapPoint - Converts map coordinates to screen coordinates.
	 * @return Point
	 */
	public final native Point toScreen(Point mapPoint) /*-{
		return this.@edu.ucdavis.cstars.client.MapWidget::map.toScreen(mapPoint);
	}-*/;
	
	/*
	 * EVENTS
	 */
	
	/**
	 * Add handler for when map is clicked.
	 * 
	 * @param handler - Fires when a user single clicks on the map using the mouse and the mouse pointer\
	 * is within the map region of the HTML page.
	 */
	public native void addClickHandler(ClickHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onClick",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.ClickHandler::onClick(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when maps is double clicked
	 * 
	 * @param handler - Fires when a user double clicks on the map using the mouse and the mouse pointer is
	 * within the map region of the HTML page.
	 */
	public native void addDblClickHandler(DblClickHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onDblClick",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.DblClickHandler::onDblClick(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Add Handler to listen to maps onResize Event
	 * 
	 * Fires when the extent of the map has changed.
	 * 
	 * @param handler
	 */
	public native void addExtentChangeHandler(MapExtentChangeHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onExtentChange",
			function(extent, delta, levelChange, lod) {
				handler.@edu.ucdavis.cstars.client.event.MapExtentChangeHandler::onMapExtentChange(Ledu/ucdavis/cstars/client/geometry/Extent;Ledu/ucdavis/cstars/client/geometry/Point;ZLedu/ucdavis/cstars/client/layers/LOD;)(extent, delta, levelChange, lod);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a keyboard key is pressed.
	 */
	public native void addKeyDownHandler(MapKeyDownHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onKeyDown",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MapKeyDownHandler::onKeyDown(Ledu/ucdavis/cstars/client/event/KeyEvent;)(event);
			}
		);
	 }-*/;
	
	/**
	 * 
	 * @param handler - Fires when a keyboard key is released.
	 */
	public native void addKeyUpHandler(MapKeyUpHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onKeyUp",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MapKeyUpHandler::onKeyUp(Ledu/ucdavis/cstars/client/event/KeyEvent;)(event);
			}
		);
	 }-*/;
	
	/**
	 * 
	 * @param handler - Fires any time a layer is added to the map.
	 */
	public native void addLayerAddHandler(MapLayerAddHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayerAdd",
			function(layer) {
				handler.@edu.ucdavis.cstars.client.event.MapLayerAddHandler::onLayerAdd(Ledu/ucdavis/cstars/client/layers/Layer;)(layer);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires after specified layer has been added to the map.
	 */
	public native void addLayerAddResultHandler(MapLayerAddResultHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayerAddResult",
			function(layer, error) {
				handler.@edu.ucdavis.cstars.client.event.MapLayerAddResultHandler::onLayerAddResult(Ledu/ucdavis/cstars/client/layers/Layer;Ledu/ucdavis/cstars/client/Error;)(layer, error);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires after the layer has been removed.
	 */
	public native void addLayerRemoveHandler(MapLayerRemoveHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayerRemove",
			function(layer) {
				handler.@edu.ucdavis.cstars.client.event.MapLayerRemoveHandler::onLayerRemove(Ledu/ucdavis/cstars/client/layers/Layer;)(layer);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the map layer order has been changed.
	 */
	public native void addLayerReorderHandler(MapLayerReorderHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayerReordered",
			function(layer, index) {
				handler.@edu.ucdavis.cstars.client.event.MapLayerReorderHandler::onLayerReorder(Ledu/ucdavis/cstars/client/layers/Layer;I)(layer, index);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires after all layers are added to the map.
	 */
	public native void addLayersAddResultHandler(MapLayersAddResultHandler handler)/*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayersAddResult",
			function(results) {
				handler.@edu.ucdavis.cstars.client.event.MapLayersAddResultHandler::onLayersAddResult(Lcom/google/gwt/core/client/JsArray;)(results);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires after all the layers have been removed.
	 */
	public native void addLayersRemovedHandler(MapLayersRemovedHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayersRemoved",
			function() {
				handler.@edu.ucdavis.cstars.client.event.MapLayersRemovedHandler::onLayersRemoved()();
			}
		);
	}-*/;
	
	/**
	 * Fires when all the layers have been reordered.
	 * 
	 * @param handler
	 */
	public native void addLayersReorderedHandler(MapLayersReorderedHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLayersReordered",
			function(ids) {
				handler.@edu.ucdavis.cstars.client.event.MapLayersReorderedHandler::onLayersReordered(Lcom/google/gwt/core/client/JsArrayString;)(ids);
			}
		);
	}-*/;
	
	
	/**
	 * Add Handler to listen to maps onLoad Event
	 * 
	 * @param handler - Fires when the first or base layer has been successfully added to the map.
	 */
	public native void addLoadHandler(MapLoadHandler handler) /*-{
		var mapWidget = this;
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onLoad",
			function(map) {
				handler.@edu.ucdavis.cstars.client.event.MapLoadHandler::onLoad(Ledu/ucdavis/cstars/client/MapWidget;)(mapWidget);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a mouse button is pressed down and the mouse cursor is in the map region of the HTML page.
	 */
	public native void addMouseDownHandler(MouseDownHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseDown",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseDownHandler::onMouseDown(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires while the mouse is being dragged until the mouse button is released.
	 */
	public native void addMouseDragHandler(MapMouseDragHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseDrag",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MapMouseDragHandler::onMouseDrag(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a mouse button is released and the user stops dragging the mouse.
	 */
	public native void addMouseDragEndHandler(MapMouseDragEndHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseDragEnd",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MapMouseDragEndHandler::onMouseDragEnd(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a mouse button is pressed down and the user starts to drag the mouse.
	 */
	public native void addMouseDragStartHandler(MapMouseDragStartHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseDragStart",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MapMouseDragStartHandler::onMouseDragStart(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires any time the mouse pointer moves over the map region. A common use for this event is to show the current x,y
	 * coordinate of the map as the user moves the mouse pointer.
	 */
	public native void addMouseMoveHandler(MouseMoveHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseMove",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseMoveHandler::onMouseMove(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the mouse moves out of the map region of the HTML page.
	 */
	public native void addMouseOutHandler(MouseOutHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseOut",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseOutHandler::onMouseOut(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the mouse moves into the map region of the HTML page.
	 */
	public native void addMouseOverHandler(MouseOverHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseOver",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseOverHandler::onMouseOver(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the mouse button is released and the mouse pointer is within the map region of the HTML page.
	 */
	public native void addMouseUpHandler(MouseUpHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseUp",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseUpHandler::onMouseUp(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the mouse wheel is scrolled.
	 */
	public native void addMouseWheelHandler(MouseWheelHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onMouseWheel",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseWheelHandler::onMouseWheel(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Add Handler to listen to maps onPan Event
	 *  
	 * @param handler -  Fires during the pan process.
	 */
	public native void addPanHandler(MapPanHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onPan",
			function(extent, delta) {
				handler.@edu.ucdavis.cstars.client.event.MapPanHandler::onMapPan(Ledu/ucdavis/cstars/client/geometry/Extent;Ledu/ucdavis/cstars/client/geometry/Point;)(extent, delta);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the pan is complete.
	 */
	public native void addPanEndHandler(MapPanEndHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onPanEnd",
			function(extent, endPoint) {
				handler.@edu.ucdavis.cstars.client.event.MapPanEndHandler::onMapPanEnd(Ledu/ucdavis/cstars/client/geometry/Extent;Ledu/ucdavis/cstars/client/geometry/Point;)(extent, endPoint);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a user commences panning.
	 */
	public native void addPanStartHandler(MapPanStartHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onPanStart",
			function(extent, startPoint) {
				handler.@edu.ucdavis.cstars.client.event.MapPanStartHandler::onMapPanStart(Ledu/ucdavis/cstars/client/geometry/Extent;Ledu/ucdavis/cstars/client/geometry/Point;)(extent, startPoint);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the map DIV is repositioned.
	 */
	public native void addRepositionHandler(MapRepositionHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onReposition",
			function(x, y) {
				handler.@edu.ucdavis.cstars.client.event.MapRepositionHandler::onMapReposition(FF)(x, y);
			}
		);
	}-*/;
	
	/**
	 * Add Handler to listen to maps onResize Event
	 * 
	 * @param handler - Fires when the Div containing the map has been resized.
	 */
	public native void addResizeHandler(MapResizeHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onResize",
			function(extent, height, width) {
				handler.@edu.ucdavis.cstars.client.event.MapResizeHandler::onMapResize(Ledu/ucdavis/cstars/client/geometry/Extent;II)(extent, height, width);
			}
		);
	}-*/;

	/**
	 * 
	 * @param handler - Fires when the map's timeExtent property is set.
	 */
	public native void addTimeExtentChange(TimeExtentChangeHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onTimeExtentChange",
			function(timeExtent) {
				handler.@edu.ucdavis.cstars.client.event.TimeExtentChangeHandler::onTimeExtentChange(Ledu/ucdavis/cstars/client/TimeExtent;)(timeExtent);
			}
		);
	}-*/;
	
	/**
	 * Add Handler to listen to maps onUnload Event
	 * 
	 * @param handler - Fires when the page is refreshed.
	 */
	public native void addUnloadHandler(MapUnloadHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onUnload",
			function(map) {
				handler.@edu.ucdavis.cstars.client.event.MapUnloadHandler::onUnload(Lcom/google/gwt/core/client/JavaScriptObject;)(map);
			}
		);
	}-*/;

	/**
	 * 
	 * @param handler - Fires during the zoom process.
	 */
	public native void addZoomHandler(MapZoomHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onZoom",
			function(extent, zoomFactor, anchor) {
				handler.@edu.ucdavis.cstars.client.event.MapZoomHandler::onZoom(Ledu/ucdavis/cstars/client/geometry/Extent;FLedu/ucdavis/cstars/client/geometry/Point;)(extent, zoomFactor, anchor);
			}
		);
	}-*/;

	/**
	 * 
	 * @param handler - Fires after layers that are updating their content have completed. This event is often used in combination 
	 * with onUpdateStart to display a "Map is busy" or "Loading? " message as visual feedback to the end-user. (As of v2.2)
	 */
	public native void addUpdateEndHandler(UpdateEndHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onUpdateEnd",
			function()  {
				handler.@edu.ucdavis.cstars.client.event.UpdateEndHandler::onUpdateEnd()();
			}
		);
	}-*/;

	/**
	 * 
	 * @param handler - Fires when one or more layers being updating their content. This event is often used in combination with onUpdateEnd 
	 * to display a "Map is busy" or "Loading? " message as visual feedback to the end-user. (As of v2.2)
	 */
	public native void addUpdateStartHandler(UpdateStartHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onUpdateStart",
			function()  {
				handler.@edu.ucdavis.cstars.client.event.UpdateStartHandler::onUpdateStart()();
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when the zoom is complete.
	 */
	public native void addZoomEndHandler(MapZoomEndHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onZoomEnd",
			function(extent, zoomFactor, anchor, level)  {
				handler.@edu.ucdavis.cstars.client.event.MapZoomEndHandler::onZoomEnd(Ledu/ucdavis/cstars/client/geometry/Extent;FLedu/ucdavis/cstars/client/geometry/Point;I)(extent, zoomFactor, anchor, level);
			}
		);
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when a user commences zooming.
	 */
	public native void addZoomStartHandler(MapZoomStartHandler handler) /*-{
		$wnd.dojo.connect(
			this.@edu.ucdavis.cstars.client.MapWidget::map,
			"onZoomStart",
			function(extent, zoomFactor, anchor, level) {
				handler.@edu.ucdavis.cstars.client.event.MapZoomStartHandler::onZoomStart(Ledu/ucdavis/cstars/client/geometry/Extent;FLedu/ucdavis/cstars/client/geometry/Point;I)(extent, zoomFactor, anchor, level);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
	  public enum SliderPosition {
	    TOP_LEFT("top-left"), 
	    TOP_RIGHT("top-right"),
	    BOTTOM_LEFT("bottom-left"),
	    BOTTOM_RIGHT("bottom-right");
	    
	    private final String value;
	    
	    private SliderPosition(String value) { 
	      this.value = value; 
	    }
	    
	    public String getValue() {
	      return value;
	    }
	  }
	  
	  public enum SliderStyle {
	    SMALL("small"), LARGE("large");
	    
	    private final String value;
	    
	    private SliderStyle(String value) {
	      this.value = value;
	    }
	    
	    public String getValue() {
	      return value;
	    }
	  }
	  
		protected Options() {}
		
    public static Options create() {
      Options options = JavaScriptObject.createObject().cast();
      return options;
    };
    
		public static Options create(BaseMap basmap) {
			Options options = JavaScriptObject.createObject().cast();
			options.setBaseMap(basmap);
			return options;
		};
		
		/**
		 * 
		 * @param basemap
		 */
		public final void setBaseMap(BaseMap basemap) {
			_setBaseMap(basemap.getValue());
		}
		
		private final native void _setBaseMap(String basemap) /*-{
			this["basemap"] = basemap;
		}-*/;
		
		/**
		 * When true, graphics are displayed during panning. When false, the graphics 
		 * are turned off during pan movement. Setting to false may improve performance 
		 * in Internet Explorer. The default is true. 
		 * 
		 * @param displayGraphics
		 */
		public final native void setDisplayGraphicsOnPan(boolean displayGraphics) /*-{
			this["displayGraphicsOnPan"] = displayGraphics;
		}-*/;
		
		/**
		 * If provided, the extent and projection of the map is set to the properties of 
		 * Extent. Once the projection is set, all layers must be able to be drawn in the 
		 * defined projection. The tiling scheme of an ArcGISTiledMapServiceLayer must 
		 * match the projection of the map. The projection of the extent is honored as 
		 * of v1.2 when used in the map constructor.
		 * 
		 * @param extent
		 */
		public final native void setExtent(Extent extent) /*-{
			this["extent"] = extent;
		}-*/;
		
		/**
		 * When true a fade effect is enabled for supported layers. Currently only tiled layers are supported. 
		 * This option is not applicable if navigationMode is set to classic.
		 * 
		 * @param fadeOnZoom - fade parameter
		 */
		public final native void setFadeOnZoom(boolean fadeOnZoom) /*-{
			this["fadeOnZoom"] = fadeOnZoom;
		}-*/;
		
		/**
		 * When the mapNavigation mode is set to 'css-transforms', CSS3 transforms will be used for map navigation
		 * when supported by the browser. It is recommended that you let the map determine when to enable 
		 * transformations to avoid running into a known issue with scrollbar rendering on Chrome on Windows XP
		 * 
		 * @param force3DTransforms
		 */
		public final native void setForce3DTransforms(boolean force3DTransforms) /*-{
			this["force3DTransforms"] = force3DTransforms;
		}-*/;
		
		/**
		 * When true, for maps that contain tiled map service layers, you are guaranteed
		 * to have the initial extent defined using the extent constructor option shown
		 * completely on the map. As of v2.0 
		 * 
		 * @param fitExtent
		 */
		public final native void fitExtent(boolean fitExtent) /*-{
			this["fitExtent"] = fitExtent;
		}-*/;
		
		/**
		 * By default the map creates and uses an out-of-the-box InfoWindow. If you create
		 * a custom implementation using InfoWindowBase specify it using this option.
		 * 
		 * @param infoWindow
		 */
		public final void setInfoWindow(InfoWindowBase infoWindow) {
			_setInfoWindow(infoWindow.getInfoWindowBaseObject());
		}
		
		private final native void _setInfoWindow(JavaScriptObject infoWindow) /*-{
			this["infoWindow"] = infoWindow;
		}-*/;
		
		// TODO: setLayer... this looks nice, how can we use it? docs suck.
		
		/**
		 * If provided, the map is initialized with the specified levels of detail. 
		 * All ArcGISTiledMapServiceLayers added to the map must have matching 
		 * resolutions in order to be displayed. (As of v1.2) 
		 * 
		 * @param lods
		 */
		public final void setLods(LOD[] lods) {
			_setLods(Util.objectArrayToJSO(lods));
		}
		
		private final native void _setLods(JavaScriptObject lods) /*-{
			this["lods"] = lods;
		}-*/;
		
		/**
		 * Display the esri logo on the map. The default value is true.
		 * 
		 * @param logo
		 */
		public final native void setLogo(boolean logo) /*-{
			this["logo"] = logo;
		}-*/;

    /**
     * Maximum visible scale of the map.
     * 
     * @since 3.3
     */
    public final native void setMaxScale(double maxScale) /*-{
      this["maxScale"] = maxScale;
    }-*/;
  
		/**
		 * Minimum visible scale of the map.
		 * 
		 * @since 3.3
		 */
		public final native void setMinScale(double minScale) /*-{
		  this["minScale"] = minScale;
		}-*/;
		
		/**
		 * Displays pan buttons on map. When false, the pan arrows never
		 * display. The default is false. 
		 * 
		 * @param nav
		 */
		public final native void setNav(boolean nav) /*-{
			this["nav"] = nav;
		}-*/;
		
		/**
		 * Specify whether or not to use CSS3 transformations when panning and zooming. Valid values 
		 * are "css-transforms" or "classic". If not specified, CSS3 transforms will be used when 
		 * supported by the browser. Advantages of using CSS3 transforms are a smoother, less jarring 
		 * experience during map navigation and hardware acceleration in browsers that support it. 
		 * 
		 * @param navigationMode - values "css-transforms" or "classic"
		 */
		public final native void setNavigationMode(String navigationMode) /*-{
			this["nagivationMode"] = navigationMode;
		}-*/;
		
		/**
		 * Specify a time period in milliseconds to ignore repeated calls to the resize method. 
		 * Default value is 300.
		 * 
		 * @param resizeDelay
		 */
		public final native void setResizeDelay(int resizeDelay) /*-{
			this["resizeDelay"] = resizeDelay;
		}-*/;
		
		/**
		 * Enable or disable map attribution display. 
		 * 
		 * @param attribution
		 */
		public final native void setShowAttribution(boolean attribution) /*-{
		  this["showAttribution"] = attribution;
		}-*/;
		
		/**
		 * The default behavior is to show an InfoWindow if the Graphic 
		 * has a defined InfoTemplate when the user clicks on the graphic. 
		 * When true, this default behavior is honored. The default value 
		 * is true. 
		 * 
		 * @param show
		 */
		public final native void showInfoWindowOnClick(boolean show) /*-{
			this["showInfoWindowOnClick"] = show;
		}-*/;
		
		/**
		 * Displays a slider on the map. When false, the slider never displays. 
		 * Default is true.
		 * 
		 * @param show
		 */
		public final native void showSlider(boolean show) /*-{
			this["slider"] = show;
		}-*/;
		
    /**
     * Position of the slider within the map control.
     * 
     * @since 3.3
     */
		public final void setSliderPosition(SliderPosition position) {
		  _setSliderPosition(position.getValue());
		}
		
		private final native void _setSliderPosition(String position) /*-{
		  this["sliderPosition"] = position;
		}-*/;
		
		/**
		 * Defines the slider style.
		 * 
		 * @since 3.3
		 */
		public final void setSliderStyle(SliderStyle style) {
		  _setSliderStyle(style.getValue());
		}
		
		private final native void _setSliderStyle(String style) /*-{
		  this["sliderStyle"] = style;
		}-*/;

		/**
		 * When true, supports continuous pan across the dateline.
		 * Wraparound is supported in the following cases:
		 * 
		 * - Map spatial reference is WGS84 or Web Mercator
		 * - The tiling scheme is either the pre-9.3 ArcGIS Online (4326)
		 * tiling scheme or ArcGIS/Google Maps/ Bing tiling scheme.
		 * - Dynamic services must be version 10 or greater.
		 * 
		 * The default value is false.
		 * 
		 * @param wrap
		 */
		public final native void wrapAround180(boolean wrap) /*-{
			this["wrapAround180"] = wrap;
		}-*/;
	}
	
	public static enum BaseMap {
		NOT_SET(""),
		SATELLITE("satellite"),
		HYBRID("hybrid"),
		TOPO("topo"),
		GRAY("gray"),
		OCEAN("ocean"),
		OSM("osm"),
		NATIONAL_GEOGRAPHIC("national_geographic");
		private String val;
		private BaseMap(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}

} 
