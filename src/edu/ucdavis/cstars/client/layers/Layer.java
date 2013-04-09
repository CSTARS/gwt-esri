package edu.ucdavis.cstars.client.layers;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Credential;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.LayerLoadHandler;
import edu.ucdavis.cstars.client.event.OpacityChangeHandler;
import edu.ucdavis.cstars.client.event.UpdateEndHandler;
import edu.ucdavis.cstars.client.event.UpdateHandler;
import edu.ucdavis.cstars.client.event.UpdateStartHandler;
import edu.ucdavis.cstars.client.event.VisibilityChangeHandler;

/**
 * The base class for all layers that can be added to a map.
 * 
 * @author Justin Merz
 */
public class Layer extends JavaScriptObject {
	
	protected Layer() {}
	
	/**
	 * Provides credential information for the layer such as userid and token if the layer represents a 
	 * resource that is secured with token-based authentication. This value is available after the layer 
	 * has been loaded i.e. layer.loaded is true. 
	 * 
	 * @return Credential
	 */
	public final native Credential getCredential() /*-{
		return this.credential;
	}-*/;
	
	/**
	 * ID assigned to the layer. If not assigned, esri.Map assigns value. By default, the ID of the layer 
	 * is "layer" followed by a number. The ID can be user defined only in the layer constructor.
	 * 
	 * @return String
	 */
	public final native String getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * When the layer is loaded, the value becomes "true", and layer properties can be accessed.
	 * The onLoad event is also fired.
	 * 
	 * @return boolean
	 */
	public final native boolean isloaded() /*-{
		return this.loaded;
	}-*/;
	
	/**
	 * Opacity or transparency of layer. Values range from 0.0 to 1.0, where 0.0 is 100%
	 * transparent and 1.0 has no transparency.
	 * 
	 * @return double
	 */
	public final native double getOpacity() /*-{
		return this.opacity;
	}-*/;
	
	/**
	 * URL to the ArcGIS Server REST resource that represents a map service.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Visibility of the layer.
	 * 
	 * @return boolean
	 */
	public final native boolean isVisible() /*-{
		return this.visible;
	}-*/;
	
	/**
	 * Sets the visibility of the layer to "false". The layer is not removed, but it is hidden from view.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;	
	
	/**
	 * Sets the opacity of the layer. Values range from 0.0 to 1.0, where 0.0 is 100% transparent and 1.0 has no transparency.
	 * 
	 * @param o - opacity value
	 */
	public final native void setOpacity(double o) /*-{
		this.setOpacity(o);
	}-*/;
	
	/**
	 * Sets the visibility of the layer. When true, the layer is visible.
	 * 
	 * @param isVisible
	 */
	public final native void setVisibility( boolean isVisible ) /*-{
		this.setVisibility(isVisible);
	}-*/;
	
	/**
	 * Sets the visibility of the layer to "true".
	 */
	public final native void show() /*-{
		this.show();
	}-*/;
	
	/**
	 * Add error handler to layer.
	 * 
	 * @param handler - Fires when there is a problem retrieving a layer
	 */
	public native final void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Add load handler to layer.
	 * 
	 * @param handler - Fires after layer properties for the layer are successfully populated. This event must be successful
	 * before the layer can be added to the map.
	 */
	public native final void addLoadHandler(LayerLoadHandler handler) /*-{
		$wnd.dojo.connect(this, "onLoad",
			function(layer) {
				handler.@edu.ucdavis.cstars.client.event.LayerLoadHandler::onLoad(Ledu/ucdavis/cstars/client/layers/Layer;)(layer);
			}
		);
	}-*/;
	
	/**
	 * Add opacity change handler to layer
	 * 
	 * @param handler - Fires when the layer opacity has been changed, and returns the opacity value.
	 */
	public native final void addOpacityChangeHandler(OpacityChangeHandler handler) /*-{		
		$wnd.dojo.connect(this, "onOpacityChange",
			function(opacity) {
				handler.@edu.ucdavis.cstars.client.event.OpacityChangeHandler::onOpacityChange(F)(opacity);
			}
		);
	}-*/;
	
	/**
	 * Add update handler to layer
	 * 
	 * @param handler - Fires any time a layer has finished loading or updating itself. For an ArcGISTiledMapServiceLayer,
	 * the event fires when all required tiles have been retrieved and displayed. For an ArcGISDynamicMapServiceLayer
	 * or ArcGISImageServiceLayer, the event fires when the map image has been retrieved and displayed. For a GraphicsLayer,
	 * the event fires when all graphics have been redrawn after a pan or zoom.
	 * 
	 * @deprecated at v2.0. Use addUpdateStartHandler and addUpdateEndHandler instead.
	 */
	public native final void addUpdateHandler(UpdateHandler handler) /*-{	
		$wnd.dojo.connect(this, "onUpdate",
			function(opacity) {
				handler.@edu.ucdavis.cstars.client.event.UpdateHandler::onUpdate()();
			}
		);
	}-*/;
	
	/**
	 * Add update end handler to layer
	 * 
	 * @param handler - Fires when a layer has finished updating its content. It is the responsibility of the (Layer)
	 * subclass to determine when this event is fired.
	 */
	public native final void addUpdateEndHandler(UpdateEndHandler handler) /*-{
		$wnd.dojo.connect(this, "onUpdateEnd",
			function(error) {
				if( error ) {
					handler.@edu.ucdavis.cstars.client.event.UpdateEndHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
				} else {
					handler.@edu.ucdavis.cstars.client.event.UpdateEndHandler::onUpdateEnd()();
				}
			}
		);
	}-*/;
	
	/**
	 * Add update start handler to layer.
	 * 
	 * @param handler - Fires when a layer begins to update its content. It is the responsibility of the subclass to
	 * determine when this event is fired.
	 */
	public native final void addUpdateStartHandler(UpdateStartHandler handler) /*-{
		$wnd.dojo.connect(this, "onUpdateStart",
			function() {
				handler.@edu.ucdavis.cstars.client.event.UpdateStartHandler::onUpdateStart()();
			}
		);
	}-*/;
	
	/**
	 * Add visibility change handler to layer.
	 * 
	 * @param handler - Fires when the layer visibilty has been changed, and returns the new visibility.
	 */
	public native final void addVisibilityChangeHandler(VisibilityChangeHandler handler) /*-{
		$wnd.dojo.connect(this, "onVisibilityChange",
			function(visibility) {
				handler.@edu.ucdavis.cstars.client.event.VisibilityChangeHandler::onVisibilityChange(Z)(visibility);
			}
		);
	}-*/;
	
}
