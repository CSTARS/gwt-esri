package edu.ucdavis.cstars.client.toolbars;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.event.ToolbarActivateHandler;
import edu.ucdavis.cstars.client.event.ToolbarDeactivateHandler;
import edu.ucdavis.cstars.client.event.ToolbarGraphicClickHandler;
import edu.ucdavis.cstars.client.event.ToolbarGraphicFirstMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarGraphicMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarGraphicMoveStopHandler;
import edu.ucdavis.cstars.client.event.ToolbarRotateFirstMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarRotateHandler;
import edu.ucdavis.cstars.client.event.ToolbarRotateStartHandler;
import edu.ucdavis.cstars.client.event.ToolbarRotateStopHandler;
import edu.ucdavis.cstars.client.event.ToolbarScaleFirstMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarScaleHandler;
import edu.ucdavis.cstars.client.event.ToolbarScaleStartHandler;
import edu.ucdavis.cstars.client.event.ToolbarScaleStopHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexAddHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexClickHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexDeleteHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexFirstMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexMouseOutHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexMouseOverHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexMoveEndHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexMoveHandler;
import edu.ucdavis.cstars.client.event.ToolbarVertexMoveStartHandler;
import edu.ucdavis.cstars.client.symbol.LineSymbol;
import edu.ucdavis.cstars.client.symbol.MarkerSymbol;

/**
 * 
 * @author Justin Merz
 */
public class Edit extends JavaScriptObject {

	public enum ToolType {
		NOT_SET(-1),
		EDIT_VERTICES(2),
		MOVE(1),
		ROTATE(8),
		SCALE(4);
		private int val = 0;
		ToolType(int value){
			val = value;
		}
		public int getValue() {
			return val;
		}
	}
	
	protected Edit() {}
	
	/**
	 * Creates a new Edit object. A map is a required parameter.
	 * 
	 * @param map - Map the toolbar is associated with.
	 * @return Edit
	 */
	public static Edit create(MapWidget map) {
		if( assertLoaded() ) return _create(map.getMapObject());  
		return JavaScriptObject.createObject().cast();
	}
	
	private static native Edit _create(JavaScriptObject map) /*-{
		return new $wnd.esri.toolbars.Edit(map);
	}-*/;
	
	/**
	 * Creates a new Edit object. A map is a required parameter.
	 * 
	 * @param map - Map the toolbar is associated with.
	 * @param options - Optional parameters.
	 * @return Edit
	 */
	public static Edit create(MapWidget map, Options options) {
		if( assertLoaded() ) return _create(map.getMapObject(), options);  
		return JavaScriptObject.createObject().cast();
	}
	
	private static native Edit _create(JavaScriptObject map, Options options) /*-{
		return new $wnd.esri.toolbars.Edit(map, options);
	}-*/;
	
	/**
	 * Check that the esri.toolbars.edit has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.toolbars.Edit ) return true;
		$wnd.alert("The ESRI_TOOLBARS_EDIT package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Activates the toolbar to edit the supplied graphic. After activation the toolbar is ready for
	 * user interaction using the specified tool.
	 * 
	 * @param tool - type of tool to be used.
	 * @param graphic - The graphic to edit.
	 */
	public final void activate(ToolType tool, Graphic graphic) {
		_activate(tool.getValue(), graphic);
	}
	
	private final native void _activate(int tool, Graphic graphic) /*-{
		this.activate(tool, graphic);
	}-*/;
	
	/**
	 * Activates the toolbar to edit the supplied graphic. After activation the toolbar is ready for
	 * user interaction using the specified tool.
	 * 
	 * @param tool - type of tool to be used.
	 * @param graphic - The graphic to edit.
	 * @param options - set optional values.
	 */
	public final void activate(ToolType tool, Graphic graphic, Options options) {
		_activate(tool.getValue(), graphic, options);
	}
	
	private final native void _activate(int tool, Graphic graphic, Options options) /*-{
		this.activate(tool, graphic, options);
	}-*/;
	
	/**
	 * Deactivates the toolbar. Call this method to deactivate the toolbar after editing the graphic.
	 */
	public final native void deactivate() /*-{
		this.deactivate();
	}-*/;
	
	/**
	 * Get an edit state object.
	 * 
	 * @return EditState
	 */
	public final native EditState getCurrentState() /*-{
		return this.getCurrentState();
	}-*/;
	
	/**
	 * Refreshes the internal state of the toolbar.
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
	
	private static ToolType getToolTypeFromInt(int t){
		for( int i = 0 ; i < ToolType.values().length; i++ ){
			if( ToolType.values()[i].getValue() == t )
				return ToolType.values()[i];
		}
		return ToolType.NOT_SET;
	}
	
	// TODO: does this little toolType-to-int trick work?
	/**
	 * Add activate handler.
	 * 
	 * @param handler - fires when toolbar activates
	 */
	public final native void addActivateHandler(ToolbarActivateHandler handler) /*-{
		$wnd.dojo.connect(ref, "onActivate",
			function(tool, graphic) {
				var tooltype = @edu.ucdavis.cstars.client.toolbars.Edit::getToolTypeFromInt(I)(tool);
				handler.@edu.ucdavis.cstars.client.event.ToolbarActivateHandler::onActivate(Ledu/ucdavis/cstars/client/toolbars/Edit$ToolType;Ledu/ucdavis/cstars/client/Graphic;)(tooltype, graphic);
			}
		);
	}-*/;
	
	/**
	 * Add deactivate handler
	 * 
	 * @param handler - fires when the toolbar deactivates and reactivates map navigation
	 */
	public final native void addDeactivateHandler(ToolbarDeactivateHandler handler) /*-{
		$wnd.dojo.connect(ref, "onDeactivate",
			function(tool, graphic, info) {
				var tooltype = @edu.ucdavis.cstars.client.toolbars.Edit::getToolTypeFromInt(I)(tool);
				handler.@edu.ucdavis.cstars.client.event.ToolbarDeactivateHandler::onDeactivate(Ledu/ucdavis/cstars/client/toolbars/Edit$ToolType;Ledu/ucdavis/cstars/client/Graphic;Z)(tooltype, graphic, info.isModified);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic is clicked
	 * 
	 * @param handler - Fires when a graphic is clicked. Applicable only when the MOVE tool is active.
	 */
	public final native void addGraphicClickHandler(ToolbarGraphicClickHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicClick",
			function(graphic, info) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarGraphicClickHandler::onGraphicClick(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/geometry/Point;Ledu/ucdavis/cstars/client/geometry/Point;)(graphic, info.screenPoint, info.mapPoint);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic first moves
	 * 
	 * @param handler - Fires when the user begins to move a graphic. Applicable only when the MOVE tool is active.
	 */
	public final native void addGraphicFirstMoveHandler(ToolbarGraphicFirstMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicFirstMove",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarGraphicFirstMoveHandler::onGraphicFirstMove(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic is moved
	 * 
	 * @param handler - Fired continuously as the graphic moves. Applicable only when the MOVE tool is active.
	 */
	public final native void addGraphicMoveHandler(ToolbarGraphicMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicMove",
			function(graphic, transform) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarGraphicMoveHandler::onGraphicMove(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Transform;)(graphic, transform);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when a graphic move starts
	 * 
	 * @param handler - Fired when the mouse button is pressed down on the graphic, usually while moving a graphic.
	 * Applicable only when the MOVE tool is active.
	 */
	public final native void addGraphicMoveStartHandler(ToolbarGraphicMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicMoveStart",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarGraphicMoveStartHandler::onGraphicMoveStart(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when a graphic move stops
	 * 
	 * @param handler - Fired when the mouse button is released, usually after moving the graphic. Applicable only when the MOVE tool is active.
	 */
	public final native void addGraphicMoveStopHandler(ToolbarGraphicMoveStopHandler handler) /*-{
		$wnd.dojo.connect(this, "onGraphicMoveStop",
			function(graphic, transform) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarGraphicMoveStopHandler::onGraphicMoveEnd(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Transform;)(graphic, transform);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when a graphic is rotated
	 * 
	 * @param handler - Fires continuously as a graphic is rotated. 
	 */
	public final native void addRotateHandler(ToolbarRotateHandler handler) /*-{
		$wnd.dojo.connect(this, "onRotate",
			function(graphic, info) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarRotateHandler::onRotate(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$Info;)(graphic, info);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic is first rotated
	 * 
	 * @param handler - Fires when the user begins to drag a handle to rotate the graphic. 
	 */
	public final native void addRotateFirstMoveHandler(ToolbarRotateFirstMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onRotateFirstMove",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarRotateFirstMoveHandler::onRotateFirstMove(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic rotation is started
	 * 
	 * @param handler - Fires when a user clicks on the handle to begin rotating a graphic.
	 */
	public final native void addRotateStartHandler(ToolbarRotateStartHandler handler) /*-{
		$wnd.dojo.connect(this, "onRotateStart",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarRotateStartHandler::onRotateStart(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic stops rotating
	 * 
	 * @param handler - Fires when the mouse button is released from the rotate handle to finish rotating the graphic.
	 */
	public final native void addRotateStopHandler(ToolbarRotateStopHandler handler) /*-{
		$wnd.dojo.connect(this, "onRotateStop",
			function(graphic, info) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarRotateStopHandler::onRotateStop(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$Info;)(graphic, info);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic is scaled
	 * 
	 * @param handler - Fires continuously as the graphic is being scaled.
	 */
	public final native void addScaleHandler(ToolbarScaleHandler handler) /*-{
		$wnd.dojo.connect(this, "onScale",
			function(graphic, info) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarScaleHandler::onScale(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$Info;)(graphic, info);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic is first moved
	 * 
	 * @param handler - Fires when the user begins to drag a handle to scale the graphic. 
	 */
	public final native void addScaleFirstMoveHandler(ToolbarScaleFirstMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onScaleFirstMove",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarScaleFirstMoveHandler::onScaleFirstMove(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic starts being scaled
	 * 
	 * @param handler - Fires when a user clicks on the handle to scale or resize a graphic. 
	 */
	public final native void addScaleStartHandler(ToolbarScaleStartHandler handler) /*-{
		$wnd.dojo.connect(this, "onScaleStart",
			function(graphic) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarScaleStartHandler::onScaleStart(Ledu/ucdavis/cstars/client/Graphic;)(graphic);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when graphic stops being scaled
	 * 
	 * @param handler - Fires when the mouse button is released from the scale handle to finish scaling the graphic. 
	 */
	public final native void addScaleStopHandler(ToolbarScaleStopHandler handler) /*-{
		$wnd.dojo.connect(this, "onScaleStop",
			function(graphic, info) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarScaleStopHandler::onScaleStop(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$Info;)(graphic, info);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex is added
	 * 
	 * @param handler - Fired after a new vertex is added to a polyline or polygon or a new point
	 * is added to a multipoint. Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexAddHandler(ToolbarVertexAddHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexAdd",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexAddHandler::onVertexAdd(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex is clicked
	 * 
	 * @param handler - Fired when the mouse button is clicked on the vertex of a polyline or polygon
	 * or a point in a multipoint. Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexClickHandler(ToolbarVertexClickHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexClick",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexClickHandler::onVertexClick(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	
	/**
	 * Add handler for when vertex is deleted
	 * 
	 * @param handler - Fired after a vertex(polyline, polygon) or point(multipoint) is deleted. Applicable only when the EDIT_VERTICES tool is active. 
	 */
	public final native void addVertexDeleteHandler(ToolbarVertexDeleteHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexDelete",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexDeleteHandler::onVertexDelete(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex is first moved.
	 * 
	 * @param handler - Fired when the user begins to move the vertex of a polyline or polygon or a point of a multipoint. 
	 * Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexFirstMoveHandler(ToolbarVertexFirstMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexFirstMove",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexFirstMoveHandler::onVertexFirstMove(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex is first moved.
	 * 
	 * @param handler - Fires as the mouse exits a vertex(polyline, polygon) or a point(multipoint). Applicable only 
	 * when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexMouseOutHandler(ToolbarVertexMouseOutHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexMouseOut",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexMouseOutHandler::onVertexMouseOut(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when mouse is over vertex.
	 * 
	 * @param handler - Fired when the mouse moves over a vertex (polyline, polygon) or point (multipoint). Applicable 
	 * only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexMouseOverHandler(ToolbarVertexMouseOverHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexMouseOver",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexMouseOverHandler::onVertexMouseOver(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex is moved
	 * 
	 * @param handler - Fired continuously as the user is moving a vertex (polyline, polygon) or point 
	 * (multipoint). Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexMoveHandler(ToolbarVertexMoveHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexMove",
			function(graphic, vertexInfo, transform) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexMoveHandler::onVertexMove(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;Ledu/ucdavis/cstars/client/toolbars/Transform;)(graphic, vertexInfo, transform);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex starts moving
	 * 
	 * @param handler - Fired when the mouse button is pressed down on a vertex (polyline, polygon) or 
	 * point (multipoint). Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexMoveStartHandler(ToolbarVertexMoveStartHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexMoveStart",
			function(graphic, vertexInfo) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexMoveStartHandler::onVertexMoveStart(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;)(graphic, vertexInfo);
			}
		);
	}-*/;
	
	/**
	 * Add handler for when vertex stops moving
	 * 
	 * @param handler - Fired when the mouse button is released from a vertex (polyline, polygon) or 
	 * point(multipoint). Applicable only when the EDIT_VERTICES tool is active.
	 */
	public final native void addVertexMoveEndHandler(ToolbarVertexMoveEndHandler handler) /*-{
		$wnd.dojo.connect(this, "onVertexMoveEnd",
			function(graphic, vertexInfo, transform) {
				handler.@edu.ucdavis.cstars.client.event.ToolbarVertexMoveEndHandler::onVertexMoveEnd(Ledu/ucdavis/cstars/client/Graphic;Ledu/ucdavis/cstars/client/toolbars/Edit$VertexInfo;Ledu/ucdavis/cstars/client/toolbars/Transform;)(graphic, vertexInfo, transform);
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
		 * @param allow - Specifies whether users can add new vertices. Valid for polyline and polygon geometries.
		 */
		public final native void allowAddVertices(boolean allow) /*-{
			this["allowAddVertices"] = allow;
		}-*/;
		
		/**
		 * 
		 * @param allow - Specifies whether users can delete vertices. Valid for polyline, polygon and multipoint geometries.
		 */
		public final native void allowDeleteVertices(boolean allow) /*-{
			this["allowDeleteVertices"] = allow;
		}-*/;
		
		/**
		 * 
		 * @param ghostLineSymbol - Line symbol used to draw the guild lines, displayed when moving vertices.
		 * Valid for polyline and polygon geometries.
		 */
		public final native void setGhostLineSymbol(LineSymbol ghostLineSymbol) /*-{
			this["ghostLineSymbol"] = ghostLineSymbol;
		}-*/;
		
		/**
		 * 
		 * @param ghostVertexSymbol - Marker symbol used to display the insertable vertices. Valid for polyline and polygon geometries.
		 */
		public final native void setGhostVertexSymbol(MarkerSymbol ghostVertexSymbol) /*-{
			this["ghostVertexSymbol"] = ghostVertexSymbol;
		}-*/;
		
		/**
		 * 
		 * @param vertexSymbol - Marker symbol used to draw the vertices. Valid for polyline and polygon geometries.
		 */
		public final native void setVertexSymbol(MarkerSymbol vertexSymbol) /*-{
			this["vertexSymbol"] = vertexSymbol;
		}-*/;
		
	}
	
	// poorly documented, this is what I got 
	/**
	 * angle, scaleX and scaleY are not always returned.  if the value doen't exist, a -1 is returned.  
	 * See docs for full information about the info object.
	 */
	public static class Info extends JavaScriptObject {
		
		protected Info() {}
		
		public final native Around getAround() /*-{
			return this.around;
		}-*/;

		public final native int getAngle() /*-{
			if( this.angle ) return this.angle;
			return -1;
		}-*/;

		public final native Transform getTransform() /*-{
			return this.transform;
		}-*/;
		
		public final native int getScaleX() /*-{
			if( this.scaleX ) return this.scaleX;
			return -1;
		}-*/;
		
		public final native int getScaleY() /*-{
			if( this.scaleY ) return this.scaleY; 
			return -1;
		}-*/;
		
	}
	
	public static class VertexInfo extends JavaScriptObject {
		
		protected VertexInfo() {}
		
		/**
		 * Index of the ring or path that contains the vertex. Always 0 for multipoints.
		 * 
		 * @return int
		 */
		public final native int getSegmentIndex() /*-{
			return this.segmentIndex;
		}-*/;
		
		/**
		 * Index of the vertex in the segment indicated by segmentIndex.
		 * 
		 * @return int
		 */
		public final native int getPointIndex() /*-{
			return this.pointIndex;
		}-*/;
		
		/**
		 * Specifies whether the event fired for an existing vertex or a ghost vertex. When
		 * true, pointIndex indicates the position the vertex will take when added to the graphic.
		 * 
		 * @return boolean
		 */
		public final native boolean isGhost() /*-{
			return this.isGhost;
		}-*/;
		
	}
	
	public static class EditState extends JavaScriptObject {
		
		protected EditState() {}
		
		/**
		 * Indicates if the tool is currently being used.
		 * 
		 * @return ToolType
		 */
		public final ToolType getTool() {
			int t = _getTool();
			for( int i = 0 ; i < ToolType.values().length; i++ ){
				if( ToolType.values()[i].getValue() == t )
					return ToolType.values()[i];
			}
			return ToolType.NOT_SET;
		}

		private final native int _getTool() /*-{
			return this.tool;
		}-*/;
		
		/**
		 * The graphic that is currently being edited.
		 * 
		 * @return Graphic
		 */
		public final native Graphic getGraphic() /*-{
			return this.graphic;
		}-*/;
		
		/**
		 * Indicates if the graphic has been modified.
		 * 
		 * @return boolean
		 */
		public final native boolean isModified() /*-{
			return this.isModified;
		}-*/;
		
	}
	
}
