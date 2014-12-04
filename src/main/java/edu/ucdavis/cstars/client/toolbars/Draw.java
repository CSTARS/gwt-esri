package edu.ucdavis.cstars.client.toolbars;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.event.DrawEndHandler;
import edu.ucdavis.cstars.client.symbol.SimpleFillSymbol;
import edu.ucdavis.cstars.client.symbol.SimpleLineSymbol;
import edu.ucdavis.cstars.client.symbol.SimpleMarkerSymbol;

/**
 * Toolbar that supports functionality to create new geometries by drawing them: points (POINT or MULTI_POINT),
 * lines (LINE, POLYLINE, or FREEHAND_POLYLINE), polygons (FREEHAND_POLYGON or POLYGON),
 * or rectangles (EXTENT). To edit geometries of existing graphics, use the Edit Toolbar.
 * 
 * @author Justin Merz
 */
public class Draw extends JavaScriptObject {
	
	public static enum GeometryType {
		ARROW("arrow"),
		CIRCLE("circle"),
		DOWN_ARROW("downarrow"),
		ELLIPSE("ellipse"),
		EXTENT("extent"),
		FREEHAND_POLYGON("freehandpolygon"),
		FREEHAND_POLYLINE("freehandpolyline"),
		LEFT_ARROW("leftarrow"),
		LINE("line"),
		MULTI_POINT("multipoint"),
		POINT("point"),
		POLYGON("polygon"),
		POLYLINE("polyline"),
		RECTANGLE("rectangle"),
		RIGHT_ARROW("rightarrow"),
		TRIANGLE("triangle"),
		UP_ARROW("uparrow");
		private String val = "";
		GeometryType(String value) {
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected Draw() {}
	
	/**
	 * Creates a new Draw object. A map is a required parameter.
	 * 
	 * @param map - Map the toolbar is associated with.
	 * @param options - Parameters that define the functionality of the draw toolbar.
	 * @return Draw
	 */
	public static native Draw create(MapWidget map, Options options) /*-{
		return new $wnd.esri.toolbars.Draw(map.@edu.ucdavis.cstars.client.MapWidget::getMapObject()(), options);
	}-*/;
	
	/**
	 * Symbol to be used when drawing a Polygon or Extent.
	 * 
	 * @return SimpleFillSymbol
	 */
	public final native SimpleFillSymbol getFillSymbol() /*-{
		return this.fillSymbol;
	}-*/;
	
	/**
	 * Symbol to be used when drawing a Polyline.
	 * 
	 * @return SimpleLineSymbol
	 */
	public final native SimpleLineSymbol getLineSymbol() /*-{
		return this.lineSymbol;
	}-*/;
	
	/**
	 * Symbol to be used when drawing a Point or Multipoint.
	 * 
	 * @return SimpleMarkerSymbol
	 */
	public final native SimpleMarkerSymbol getMarkerSymbol() /*-{
		return this.markerSymbol;
	}-*/;
	
	/**
	 * When set to false, the geometry is modified to be topologically correct. When set to true,
	 * the input geometry is not modified. Default value: true
	 * 
	 * @return boolean
	 */
	public final native boolean respectDrawingVertexOrder() /*-{
		return this.respectDrawingVertexOrder;
	}-*/;

	/**
	 * Activates the toolbar for drawing geometries. Activating the toolbar disables map navigation.
	 * 
	 * @param geometryType -The type of geometry drawn. 
	 */
	public final void activate(GeometryType geometryType ){
		_activate(geometryType.getValue());
	}
	
	private final native void _activate(String geometryType) /*-{
		this.activate(geometryType);
	}-*/;
	
	/**
	 * Activates the toolbar for drawing geometries. Activating the toolbar disables map navigation.
	 * 
	 * @param geometryType - The type of geometry drawn. 
	 * @param options - Options that define the functionality of the draw toolbar.
	 */
	public final void activate(GeometryType geometryType, Options options){
		_activate(geometryType.getValue(), options);
	}
	
	private final native void _activate(String geometryType, Options options) /*-{
		this.activate(geometryType, options);
	}-*/;
	
	/**
	 * Deactivates the toolbar and reactivates map navigation.
	 */
	public final native void deactivate() /*-{
		this.deactivate();
	}-*/;
	
	/**
	 * Finishes drawing the geometry and fires the onDrawEnd event. Use this method to finish drawing a
	 * polyline, polygon or multipoint when working with the copmact build on a touch supported device like the iPhone.
	 */
	public final native void finishDrawing() /*-{
		this.finishDrawing();
	}-*/;
	
	/**
	 * Sets the fill symbol.
	 * 
	 * @param fillSymbol - The fill symbol.
	 */
	public final native void setFillSymbol(SimpleFillSymbol fillSymbol) /*-{
		this.setFillSymbol(fillSymbol);
	}-*/;
	
	/**
	 * Sets the line symbol.
	 * 
	 * @param lineSymbol - The line symbol.
	 */
	public final native void setLineSymbol(SimpleLineSymbol lineSymbol) /*-{
		this.setLineSymbol(lineSymbol);
	}-*/;

	/**
	 * Sets the marker symbol.
	 * 
	 * @param markerSymbol - The marker symbol.
	 */
	public final native void setMarkerSymbol(SimpleMarkerSymbol markerSymbol) /*-{
		this.setMarkerSymbol(markerSymbol);
	}-*/;
	
	/**
	 * Sets whether the polygon geometry should be modified to be topologically correct.
	 * 
	 * @param set -When set to false, the geometry is modified to be topologically correct. When set to true,
	 * the input geometry is not modified.
	 */
	public final native void setRespectDrawingVertexOrder(boolean set) /*-{
		return this.setRespectDrawingVertexOrder(set);
	}-*/;
	
	/**
	 * Add handler to draw end event;
	 * 
	 * @param handler - Geometry drawn on the client.
	 */
	public final native void addDrawEndHandler(DrawEndHandler handler) /*-{
		$wnd.dojo.connect(this, "onDrawEnd",
			function(geometry) {
				handler.@edu.ucdavis.cstars.client.event.DrawEndHandler::onDrawEnd(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param drawTime - Determines how much time to wait before adding a new point when using a freehand tool. The default value is 75.
		 */
		public final native void setDrawTime(int drawTime) /*-{
			this["drawTime"] =  drawTime;
		}-*/;
		
		/**
		 * 
		 * @param showToolTips - If true, tooltips are displayed when creating new graphics with the draw toolbar. The default value is true.
		 */
		public final native void showTooltips(boolean showToolTips) /*-{
			this["showToolTips"] = showToolTips;
		}-*/;
		
		/**
		 * 
		 * @param tolerance - Determines how far the mouse moves before adding a new point when using one of the freehand tools. The default value is 8.
		 */
		public final native void setTolerance(int tolerance) /*-{
			this["tolerance"] = tolerance;
		}-*/;
		
		/**
		 * 
		 * @param tooltipOffset - Determines how farm to offset the tool tip from the mouse pointer. The default value is 15.
		 */
		public final native void setTooltipOffset(int tooltipOffset) /*-{
			this["tooltipOffset"] = tooltipOffset;
		}-*/;
		
	}
	
}
