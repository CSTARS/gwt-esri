package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.InfoTemplate;
import edu.ucdavis.cstars.client.event.ClickHandler;
import edu.ucdavis.cstars.client.event.DblClickHandler;
import edu.ucdavis.cstars.client.event.GraphicsLayerGaphicsClearHandler;
import edu.ucdavis.cstars.client.event.GraphicsLayerGraphicAddHandler;
import edu.ucdavis.cstars.client.event.GraphicsLayerGraphicRemoveHandler;
import edu.ucdavis.cstars.client.event.MouseDownHandler;
import edu.ucdavis.cstars.client.event.MouseDragHandler;
import edu.ucdavis.cstars.client.event.MouseMoveHandler;
import edu.ucdavis.cstars.client.event.MouseOutHandler;
import edu.ucdavis.cstars.client.event.MouseOverHandler;
import edu.ucdavis.cstars.client.event.MouseUpHandler;
import edu.ucdavis.cstars.client.renderer.Renderer;

/**
 *  A layer that contains one or more Graphic features. 
 *  Each map contains a GraphicsLayer by default, accessible using the Map.Graphics property. 
 *  Beginning with v1.4, you can create your own graphics layers and add them to the map. 
 *  Graphics layers can be reordered within the group of graphics layers. 
 *  However, the graphics layer in Map.Graphics is always on top. 
 *  Also, all graphics layers are always on top of TiledMapServiceLayers and DynamicMapServiceLayers. 
 *  
 * @author lsimone
 * @author Justin Merz
 */
public class GraphicsLayer extends Layer {
	
	protected GraphicsLayer() {}
	
	/**
	 * Creates a new graphics layer.
	 * 
	 * @return GraphicsLayer
	 */
	public native static GraphicsLayer create() /*-{
		return new $wnd.esri.layers.GraphicsLayer();
	}-*/;
	
	/**
	 * Creates a new GraphicsLayer object with parameters. 
	 * 
	 * @param options - see options class
	 * @return GaphicsLayer
	 */
	public native static GraphicsLayer create(Options options) /*-{
		return new $wnd.esri.layers.GraphicsLayer(options);
	}-*/;

	/**
	 * The array of graphics that make up the layer.
	 * 
	 * @return JsArray<Graphic>
	 */
	public native final JsArray<Graphic> getGraphics() /*-{
		return this.graphics;
	}-*/;
	
	/**
	 * Renderer assigned to the GraphicsLayer. 
	 * 
	 * @return Renderer
	 */
	public native final Renderer getRenderer() /*-{
		return this.renderer;
	}-*/;
	
	/**
	 * Adds a graphic.
	 * 
	 * @param graphic - The graphic to add.
	 */
	public native final void add(Graphic graphic) /*-{
		this.add(graphic);
	}-*/;
	
	/**
	 * Clears all graphics.
	 */
	public native final void clear() /*-{
		this.clear();
	}-*/;
	
	/**
	 * Disables all mouse events on the graphics layer.
	 */
	public native final void disableMouseEvents() /*-{
		this.disableMouseEvents();
	}-*/;
	
	/**
	 * Enables all mouse events on the graphics layer.
	 */
	public native final void enableMouseEvents() /*-{
		this.enableMouseEvents();
	}-*/;
	
	/**
	 * Removes a graphic.
	 * 
	 * @param graphic - Removes a graphic.
	 */
	public native final void remove(Graphic graphic) /*-{
		this.remove(graphic);
	}-*/;
	
	/**
	 * Specify or change the info template for a layer. 
	 * 
	 * @param infoTemplate - The new info template.
	 */
	public native final void setInfoTemplate(InfoTemplate infoTemplate) /*-{
		this.setInfoTemplate(infoTemplate);
	}-*/;
	
	/**
	 * Initial opacity or transparency of layer. Not supported in Internet Explorer.
	 * 
	 * @param opacity - Value from 0 to 1, where 0 is 100% transparent and 1 has no transparency.
	 * The default value is 1.
	 */
	public native final void setOpacity(float opacity) /*-{
		this.setOpacity(opacity);
	}-*/;
	
	/**
	 * Sets the renderer for the graphics layer.
	 * 
	 * @param renderer - The renderer used for the graphic.
	 */
	public native final void setRenderer(Renderer renderer) /*-{
		this.setRenderer(renderer);
	}-*/;
	
	/**
	 * Fires when a graphic has been clicked.
	 * 
	 * @param handler 
	 */
	public native final void addClickHandler(ClickHandler handler) /*-{
		$wnd.dojo.connect(this, "onClick",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.ClickHandler::onClick(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires when a graphic has been double clicked. 
	 * 
	 * @param handler
	 */
	public native final void addDblClickHandler(DblClickHandler handler) /*-{
		$wnd.dojo.connect(this, "onDblClick",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.DblClickHandler::onDblClick(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires when a graphic is added to the GraphicsLayer.
	 * 
	 * @param handler
	 */
	public native final void addGraphicAddHandler(GraphicsLayerGraphicAddHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicAdd",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.GraphicsLayerGraphicAddHandler::onGraphicAdd(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Fires when a graphic is removed from the GraphicsLayer.
	 * 
	 * @param handler
	 */
	public native final void addGraphicRemoveHandler(GraphicsLayerGraphicRemoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicRemove",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.GraphicsLayerGraphicRemoveHandler::onGraphicRemove(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Fires when all graphics in the GraphicsLayer are cleared.
	 * 
	 * @param handler
	 */
	public native final void addGraphicsClearHandler(GraphicsLayerGaphicsClearHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicsClear",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.GraphicsLayerGaphicsClearHandler::onGraphicsClear()();
			}
		);
	}-*/;
	
	/**
	 * Fires when a mouse button is pressed down and the mouse cursor is on a graphic.
	 * 
	 * @param handler
	 */
	public native final void addMouseDownHandler(MouseDownHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseDown",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseDownHandler::onMouseDown(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires while the mouse is being dragged until the mouse button is released.
	 * 
	 * @param handler
	 */
	public native final void addMouseDragHandler(MouseDragHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseDrag",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseDragHandler::onMouseDrag(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires as the mouse moves through a graphic on the GraphicsLayer.
	 * 
	 * @param handler
	 */
	public native final void addMouseMoveHandler(MouseMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseMove",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseMoveHandler::onMouseMove(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires as the mouse exits a graphic on the GraphicsLayer.
	 * 
	 * @param handler
	 */
	public native final void addMouseOutHandler(MouseOutHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseOut",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseOutHandler::onMouseOut(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires when the mouse first enters into a graphic on the GraphicsLayer.
	 * 
	 * @param handler
	 */
	public native final void addMouseOverHandler(MouseOverHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseOver",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseOverHandler::onMouseOver(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	/**
	 * Fires when a mouse button is released and the mouse cursor is on a graphic.
	 * 
	 * @param handler
	 */
	public native final void addMouseUpHandler(MouseUpHandler handler) /*-{
		$wnd.dojo.connect(this, "onMouseUp",
			function(event) {
				handler.@edu.ucdavis.cstars.client.event.MouseUpHandler::onMouseUp(Ledu/ucdavis/cstars/client/event/MouseEvent;)(event);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static final Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * 
		 * @param displayOnPan - When true, graphics are displayed during panning. When false, the graphics are turned off 
		 * during pan movement. Setting to false may improve performance in Internet Explorer. The default is true. 
		 */
		public native final void setDisplayOnPan(boolean displayOnPan) /*-{
			this["displayOnPan"] = displayOnPan;
		}-*/;
		
		/**
		 * 
		 * @param id - Id to assign to the layer. If not assigned, esri.Map assigns value. 
		 */
		public native final void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * 
		 * @param opacity - Initial opacity or transparency of layer. Values range from 0.0 to 1.0, where 0.0 is 100% transparent
		 * and 1.0 has no transparency. The default value is 1.0. Not supported in Internet Explorer. 
		 */
		public native final void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * 
		 * @param visible - Initial visibility of the layer. Default is true. 
		 */
		public native final void setVisible(boolean visible) /*-{
			this["visible"] = visible;
		}-*/;
	}
	
}
