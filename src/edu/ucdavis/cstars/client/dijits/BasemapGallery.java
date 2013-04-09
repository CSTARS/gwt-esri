package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.BasemapAddHandler;
import edu.ucdavis.cstars.client.event.BasemapLoadHandler;
import edu.ucdavis.cstars.client.event.BasemapRemoveHandler;
import edu.ucdavis.cstars.client.event.BasemapSelectionHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * The BasemapGallery dijit displays a collection basemaps from ArcGIS.com or a user-defined set of map or image services.
 * When a new basemap is selected from the BasemapGallery the basemap layers are removed from the map and the new
 * layers are added.
 * 
 * All basemaps added to the gallery need to have the same spatial reference. If the default ArcGIS.com basemaps are used
 * then all additional items added to the gallery need to be in Web Mercator (wkids: 102100, 102113 and 3857). If the
 * default basemaps are not used you can add basemaps in any spatial reference as long as all the items added to the
 * gallery share that spatial reference. To achieve the best performance, it is recommended that all basemaps added to the
 * gallery are cached (tiled) layers.
 * 
 * @author Justin Merz
 */
public class BasemapGallery extends Composite {

	private SimplePanel panel = new SimplePanel();
	protected JavaScriptObject jso = null;
	private Parameters parameters;
	
	/**
	 * Creates a new BasemapGallery dijit.
	 * 
	 * @param params - Parameters used to configure the widgit. See the list below for details.
	 */
	public BasemapGallery(Parameters params) {

		if( !assertLoaded() ) return; 

		initWidget(panel);
		
		parameters = params;
	
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( jso == null ) jso = create(parameters);
			}
		});
		
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.BasemapGallery(params, this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::getElement()() );
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
	 * List of basemaps displayed in the BasemapGallery. The list contains basemaps added using the basemaps constructor
	 * option and if showArcGISBasemaps is true ArcGIS.com basemaps are also included.
	 * 
	 * @return JsArray<Basemap>
	 */
	public native JsArray<Basemap> getBasemaps() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.basemaps;
	}-*/;
	
	/**
	 * This value is true after the BasemapGallery retrieves the ArcGIS.com basemaps. If showArcGISBasemaps is false the 
	 * loaded property is set to true immediately.
	 * 
	 * @return boolean
	 */
	public native boolean isLoaded() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.loaded;
	}-*/;
	
	/**
	 * Add a new basemap to the BasemapGallery's list of basemaps. Returns true if the basemap is successfully added and 
	 * false if the item was not added, e.g. if the id is already in the list of basemaps.
	 * 
	 * @param basemap - The basemap to add to the map.
	 * @return boolean
	 */
	public native boolean add(Basemap basemap) /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.add(basemap);
	}-*/;
	
	/**
	 * Destroys the basemap gallery. Call destroy() when the widget is no longer needed by the application.
	 */
	public void destroy() {
		_destroy();
		if( isAttached() ) removeFromParent();
	}

	private final native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.destroy();
	}-*/;
	
	/**
	 * Return the basemap with the specified id. Returns null if a basemap with the specified id is not found.
	 * 
	 * @param id - The basemap id.
	 * @return Basemap
	 */
	public final native Basemap get(String id) /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.get(id);
	}-*/;
	
	/**
	 * Gets the currently selected basemap. Returns null if the map is displaying a basemap that is not from the BasemapGallery.
	 * 
	 * @return Basemap
	 */
	public final native Basemap getSelected() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.getSelected();
	}-*/;
	
	/**
	 * Remove a basemap from the BasemapGallery's list of basemaps. Returns null if a basemap with the specified id is not found.
	 * 
	 * @param id - The basemap id.
	 * @return Basemap
	 */
	public final native Basemap remove(String id) /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.remove(id);
	}-*/;
	
	/**
	 * Select a new basemap for the map. The map refreshes to display the new basemap. Returns null if a basemap with the 
	 * specified id is not found.
	 * 
	 * @param id - The basemap id.
	 * @return Basemap
	 */
	public final native Basemap select(String id) /*-{
		return this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.select(id);
	}-*/;
	
	/**
	 * Finalizes the creation of the basemap gallery. Call startup() after creating the widget when you are ready for user interaction.
	 */
	public final native void startup() /*-{
		this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso.startup();
	}-*/;

	/**
	 * Fires when a basemap is added to the BasemapGallery's list of basemaps.
	 * 
	 * @param handler - handler to fire when basemap is added
	 */
	public final native void addAddHandler(BasemapAddHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso,
		 	"onAdd",
		 	function(basemap) {
		 		handler.@edu.ucdavis.cstars.client.event.BasemapAddHandler::onAdd(Ledu/ucdavis/cstars/client/dijits/Basemap;)(basemap);
			}
		);
	}-*/;
	
	/**
	 * Fires when an error occurs while switching basemaps.
	 * 
	 * @param handler - error handler to fire
	 */
	public final native void addErrorHandler(ErrorHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso,
		 	"onError",
		 	function(error) {
		 		handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;

	/**
	 * Fires when the BasemapGallery retrieves the ArcGIS.com basemaps. If showArcGISBasemaps is set to false this event is not fired.
	 * 
	 * @param handler - handler to be fired
	 */
	public final native void addLoadHandler(BasemapLoadHandler handler) /*-{
		$wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso,
		 	"onLoad",
		 	function() {
		 		handler.@edu.ucdavis.cstars.client.event.BasemapLoadHandler::onLoad()();
			}
		);
	}-*/;
	
	/**
	 * Fires when a basemap is removed from the BasemapGallery's list of basemaps.
	 * 
	 * @param handler - handler to be fired.
	 */
	public final native void addRemoveHandler(BasemapRemoveHandler handler) /*-{
		$wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso,
		 	"onRemove",
		 	function(basemap) {
		 		handler.@edu.ucdavis.cstars.client.event.BasemapRemoveHandler::onRemove(Ledu/ucdavis/cstars/client/dijits/Basemap;)(basemap);
			}
		);
	}-*/;
	
	/**
	 * Fires after the map is updated with a new basemap.
	 * 
	 * @param handler - handler to be fired.
	 */
	public final native void addSelectionHandler(BasemapSelectionHandler handler) /*-{
		$wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.BasemapGallery::jso,
		 	"onSelectionChange",
		 	function(basemap) {
		 		handler.@edu.ucdavis.cstars.client.event.BasemapSelectionHandler::onSelectionChange()();
			}
		);
	}-*/;
	
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		/**
		 * create new options object;
		 * 
		 * @return JavaScriptObject
		 */
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param basemapIds - Optional. List of basemap layer ids in the current map. These layers will be removed when
		 * switching to a new basemap.
		 */
		public final void setBasemapIds(String[] basemapIds) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < basemapIds.length; i++ ) Util.addStringToArray(basemapIds[i], arr);
			_setBasemapIds(arr);
		}
	
		private final native void _setBasemapIds(JavaScriptObject array) /*-{
			this["basemapIds"] = array;
		}-*/;
		
		/**
		 * 
		 * @param basemaps - Optional. An array of user-defined basemaps to display in the BasemapGallery.
		 */
		public final void setBasemaps(Basemap[] basemaps) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < basemaps.length; i++ ) Util.addObjectToArray(basemaps[i], arr);
			_setBasemaps(arr);
		}
	
		private final native void _setBasemaps(JavaScriptObject array) /*-{
			this["basemaps"] = array;
		}-*/;
		
		/**
		 * 
		 * @param bingMapsKey - Optional. Specify your Bing Maps key. If no Bing Maps key is provided Bing Map
		 * types will not be displayed in the BasemapGallery. 
		 */
		public final native void setBingMapsKey(String bingMapsKey) /*-{
			this["bingMapsKey"] = bingMapsKey;
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
		 * @param referenceIds - optional. List of reference layer ids in the current map. Reference layers are displayed
		 * on top of the map and usually contain information like place boundaries or labels. All layers specified by the
		 * referenceIds will be removed when switching to a new basemap.
		 */
		public final void setReferenceIds(String[] referenceIds) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < referenceIds.length; i++ ) Util.addStringToArray(referenceIds[i], arr);
			_setReferenceIds(arr);
		}
	
		private final native void _setReferenceIds(JavaScriptObject array) /*-{
			this["referenceIds"] = array;
		}-*/;
		
		/**
		 * 
		 * @param showBasemaps -Optional. When true, queries ArcGIS.com to retrieve available basemaps. When false,
		 * only user-defined basemaps specified using the basemaps property are displayed. Note: The collection of
		 * ArcGIS.com basemaps may occasionally change, this means that the order or a particular set of maps being
		 * returned may not always be the same.
		 */
		public final native void showArcGISBasemaps(boolean showBasemaps) /*-{
			this["showArcGISBasemaps"] = showBasemaps;
		}-*/;
		
	}
	
}
