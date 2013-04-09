package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

import edu.ucdavis.cstars.client.event.HideHandler;
import edu.ucdavis.cstars.client.event.ShowHandler;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * An InfoWindow is an HTML popup. It often contains the attributes of a 
 * Graphic. The default behavior on a Graphic is to show the InfoWindow 
 * after a click on the Graphic. An InfoTemplate is required for this 
 * default behavior. In addition, the InfoWindow can be used to display 
 * custom content on the map.
 * 
 * @author Justin Merz
 */
public class InfoWindow extends JavaScriptObject {
	
	public static enum FixedAnchor {
		NOT_SET(""),
		ANCHOR_LOWERLEFT("lowerleft"),
		ANCHOR_LOWERRIGHT("lowerright"),
		ANCHOR_UPPERLEFT("upperleft"),
		ANCHOR_UPPERRIGHT("upperright");
		private String val;
		private FixedAnchor(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected InfoWindow() {}

	/**
	 * Placement of the InfoWindow with respect to 
	 * the graphic. See the Constants table for values.
	 * 
	 * @return FixedAnchor
	 */
	public final FixedAnchor getAnchor() {
		String f = _getAnchor();
		for( int i = 0 ; i < FixedAnchor.values().length; i++ ){
			if( FixedAnchor.values()[i].getValue().contentEquals(f) )
				return FixedAnchor.values()[i];
		}
		return FixedAnchor.NOT_SET;
	}
	
	private final native String _getAnchor() /*-{
		return this.anchor;
	}-*/;
	
	/**
	 * The anchor point of the InfoWindow in screen coordinates.
	 * 
	 * @return Point
	 */
	public final native Point getCoords() /*-{
		return this.coords;
	}-*/;
	
	/**
	 * InfoWindow always show with the specified anchor. 
	 * See the Constants table for values.
	 * 
	 * @return FixedAnchor
	 */
	public final FixedAnchor getFixedAnchor() {
		String f = _getFixedAnchor();
		for( int i = 0 ; i < FixedAnchor.values().length; i++ ){
			if( FixedAnchor.values()[i].getValue().contentEquals(f) )
				return FixedAnchor.values()[i];
		}
		return FixedAnchor.NOT_SET;
	}
	
	private final native String _getFixedAnchor() /*-{
		return this.fixedAnchor;
	}-*/;
	
	/**
	 * Determines whether the InfoWindow is currently shown on the map.
	 * 
	 * @return boolean
	 */
	public final native boolean isShowing() /*-{
		return this.isShowing;
	}-*/;
	
	/**
	 * Hides the InfoWindow.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;
	
	/**
	 * Moves the InfoWindow to the specified screen point.
	 * 
	 * @param point - The new anchor point when moving the InfoWindow.
	 */
	public final native void move(Point point) /*-{
		this.move(point);
	}-*/;
	
	/**
	 * Resizes the InfoWindow to the specified height and width in pixels.
	 * 
	 * @param width
	 * @param height
	 */
	public final native void resize(int width, int height) /*-{
		this.resize(width, height);
	}-*/;
	
	/**
	 * Sets the content in the InfoWindow.
	 * 
	 * @param content - The content for the InfoWindow. Can be any valid HTML.
	 */
	public final native void setContent(String content) /*-{
		this.setContent(content);
	}-*/;
	
	/**
	 * Sets the content in the InfoWindow.
	 * 
	 * @param element - The content for the InfoWindow. Valid DOM element.
	 */
	public final native void setContent(Element element) /*-{
		this.setContent(element);
	}-*/;
	
	/**
	 * Sets the content in the InfoWindow.
	 * 
	 * @param widget - The content for the InfoWindow
	 */
	public final void setContent(Widget widget) {
		setContent(widget.getElement());
	};
	
	/**
	 * Sets the fixed location of the InfoWindow anchor. Valid 
	 * values are listed in FixedAnchor.
	 * 
	 * @param fixedAnchor
	 */
	public final void setFixedAnchor(FixedAnchor fixedAnchor) {
		_setFixedAnchor(fixedAnchor.getValue());
	}
	
	private final native void _setFixedAnchor(String anchor) /*-{
		return this.setFixedAnchor(anchor);
	}-*/;
	
	/**
	 * Sets the title for the InfoWindow.
	 * 
	 * @param title - The title for the InfoWindow. Can be any valid HTML.
	 * @return InfoWindow
	 */
	public final native InfoWindow setTitle(String title) /*-{
		this.setTitle(title);
	}-*/;
	
	
	/**
	 * Shows the InfoWindow to the specified screen point and anchor.
	 * 
	 * @param point - The new anchor point when moving the InfoWindow.
	 * @param anchor - Placement of the InfoWindow with respect to the graphic
	 */
	public final native void show(Point point, String anchor) /*-{
	    this.show(point, anchor);
	}-*/;
	
	/**
	 * Fires when an infoWindow is hidden.
	 * 
	 * @param handler
	 */
	public native final void addHideHandler(HideHandler handler) /*-{
		$wnd.dojo.connect(this, "onHide",
			function() {
				handler.@edu.ucdavis.cstars.client.event.HideHandler::onHide();
			}
		);
	}-*/;
	
	/**
	 * Fires when an InfoWindow is visible.
	 * 
	 * @param handler
	 */
	public native final void addShowHandler(ShowHandler handler) /*-{
		$wnd.dojo.connect(this, "onShow",
			function() {
				handler.@edu.ucdavis.cstars.client.event.ShowHandler::onShow();
			}
		);
	}-*/;
	
}
