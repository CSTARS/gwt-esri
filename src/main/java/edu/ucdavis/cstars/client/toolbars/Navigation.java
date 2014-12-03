package edu.ucdavis.cstars.client.toolbars;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.event.ExtentHistoryChangeHandler;
import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * Toolbar that supports basic navigation such as pan and zoom.
 * 
 * @author Justin Merz
 */
public class Navigation extends JavaScriptObject {
	
	public static enum NavigationType {
		PAN("pan"),
		ZOOM_IN("zoomin"),
		ZOOM_OUT("zoomout");
		private String val = "";
		NavigationType(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
	}
	
	protected Navigation() {}
	
	/**
	 * Creates a new Navigation object. A Map is a required parameter.
	 * 
	 * @param map - Map the toolbar is associated with.
	 * @return  Navigation
	 */
	public static native Navigation create(MapWidget map) /*-{
		return new $wnd.esri.toolbars.Navigation(map.@edu.ucdavis.cstars.client.MapWidget::getMapObject());
	}-*/;
	
	/**
	 * Activates the toolbar for map navigation. Activating the toolbar overrides default map navigation.
	 * 
	 * @param navigationType - The navigation type.
	 */
	public final void activate(NavigationType navigationType) {
		_activate( navigationType.getValue() );
	}
	
	private final native void _activate(String navigationType) /*-{
		this.activate(navigationType);
	}-*/;
	
	/**
	 * Deactivates the toolbar and reactivates map navigation.
	 */
	public final native void deactivate() /*-{
		this.deactivate();
	}-*/;
	
	/**
	 * When "true", map is at the first extent.
	 */
	public final native void isFirstExtent() /*-{
		return this.isFirstExtent();
	}-*/;
	
	/**
	 * When "true", map is at the last extent.
	 */
	public final native void isLastExtent() /*-{
		return this.isLastExtent();
	}-*/;
	
	/**
	 * Set the SimpleFillSymbol used for the rubber band zoom.
	 * 
	 * @param symbol - The SimpleFillSymbol used for the rubber band zoom.
	 */
	public final native void setZoomSymbol(Symbol symbol) /*-{
		this.setZoomSymbol(symbol);
	}-*/;
	
	/**
	 * Zoom to full extent of base layer.
	 */
	public final native void zoomToFullExtent() /*-{
		this.zoomToFullExtent();
	}-*/;
	
	/**
	 * Zoom to next extent in extent history.
	 */
	public final native void zoomToNextExtent() /*-{
		this.zoomToNextExtent();
	}-*/;
	
	/**
	 * Zoom to previous extent in extent history.
	 */
	public final native void zoomToPrevExtent() /*-{
		this.zoomToPrevExtent();
	}-*/;

	/**
	 * Add extent history change handler
	 * 
	 * @param handler - Fires when the extent history changes.
	 */
	public final native void addExtentHistoryChangeHandler(ExtentHistoryChangeHandler handler) /*-{
		$wnd.dojo.connect(this,"onExtentHistoryChange",
			function() {
				handler.@edu.ucdavis.cstars.client.event.ExtentHistoryChangeHandler::onExtentHistoryChange()();
			}
		);
	}-*/;
	
}
