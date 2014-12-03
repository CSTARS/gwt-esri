package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.event.MapPanEndHandler;
import edu.ucdavis.cstars.client.event.MapPanStartHandler;
import edu.ucdavis.cstars.client.event.MapZoomEndHandler;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * The base class for the out-of-the-box InfoWindow. To create a custom info window, extend this class and adhere to the following requirements:
 *  - Provide implementation for the listed methods
 *  - Expose listed properties
 *  - Fire listed events
 *  
 *  It is necessary to provide a base implementation so that the custom info window provides a minimum level of functionality and works as expected.
 *   Custom info windows can define additional properties, methods and events to enhance the info window and provide a richer user experience.
 * 
 * GWT NOTES: 
 *   - currently ignoring dijit startup/destory... use gwt not dijit ;)
 *   - The root element is a SimplePanel (div) called 'panel'.  In the extended class you need to define your title widget and content window, as well
 *     as attach them the panel in the init() method.  Call getPanel() to access this root panel.
 * 
 * @author Justin Merz
 */
public abstract class InfoWindowBase {

	protected SimplePanel panel = new SimplePanel();
	private Point currentPoint = null;
	private JavaScriptObject jso = null;
	protected MapWidget map = null;
	
	/**
	 * Call this method in the constructor of your inheriting child class.
	 */
	public void load() {
		if( !assertLoaded() ) return;
		panel.getElement().getStyle().setPosition(Position.ABSOLUTE);
		panel.getElement().getStyle().setZIndex(500);
		init();
		initJso();
	}
	
	public abstract void init();
	
	/**
	 * Access to root panel of new info window.  Use this your init() method.
	 * 
	 * @return SimplePanel
	 */
	protected SimplePanel getPanel() {
		return panel;
	}
	
	protected Element getPanelElement() {
		return panel.getElement();
	}
	
	protected native InfoWindowBase initJso() /*-{
		var w = new $wnd.esri.InfoWindowBase();
		var ref = this;
		
		this.@edu.ucdavis.cstars.client.InfoWindowBase::jso = w;

		w["domNode"] = this.@edu.ucdavis.cstars.client.InfoWindowBase::getPanelElement()();
		w["isShowing"] = false;

		w["resize"] = function(width, height) {
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::resize(II)(width, height);
		}
		
		// save original function
		w["__esri_setMap"] = w.setMap;
		// set new setMap function 
		
		w["setMap"] = function(map) {
			w.__esri_setMap(map);
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::_setMap(Ledu/ucdavis/cstars/client/MapWidget;)(map.__gwt_MapWidget);
		}
		
		w["unsetMap"] = function(map) {
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::hide()();
		}
		
		w["setTitle"] = function(title) {
			if( typeof title == "string" ) {
				ref.@edu.ucdavis.cstars.client.InfoWindowBase::setTitle(Ljava/lang/String;)(title);
			}
			//w.place(title, ref.@edu.ucdavis.cstars.client.InfoWindowBase::getTitleWidgetElement()());
		}
		
		w["setContent"] = function(content) {
			if( typeof content == "string" ) {
				ref.@edu.ucdavis.cstars.client.InfoWindowBase::setContent(Ljava/lang/String;)(content);
			}
			//w.place(content, ref.@edu.ucdavis.cstars.client.InfoWindowBase::getContentWidgetElement()());
		}
		
		w["show"] = function(location) {
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::show(Ledu/ucdavis/cstars/client/geometry/Point;)(location);
			w.isShowing = true;
			w.onShow();
		}
		
		w["hide"] = function() {
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::hide()();
			w.isShowing = false;
		}
		
		w["destroy"] = function() {
			ref.@edu.ucdavis.cstars.client.InfoWindowBase::hide()();
		}
	}-*/;

	public abstract void setContent(String content);
	
	public abstract void setTitle(String title);
	
	/**
	 * Check that the esri.InfoWindowBase has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.InfoWindowBase ) return true;
		$wnd.alert("The ESRI_INFOWINDOWBASE package has not been loaded");
		return false;
	}-*/;

	public JavaScriptObject getInfoWindowBaseObject() {
		return jso;
	}
	
	/**
	 * The reference to a DOM node where the info window is constructed.
	 * 
	 * @return Element
	 */
	public final Element getDomNode() {
		return panel.getElement();
	};
	
	/**
	 *  Indicates if the info window is visible. When true the window is visible.
	 *  Sub-classes should define this property.
	 * 
	 * @return boolean
	 */
	public native boolean isShowing() /*-{
		return this.@edu.ucdavis.cstars.client.InfoWindowBase::jso.isShowing;
	}-*/;
	
	/**
	 * Hide the info window. Fire the onHide event at the end of your implementation of this method to hide the info window.
	 */
	public final void hide() {
		panel.setVisible(false);
		_hide();
		onHide();
	}
	
	private native void  _hide() /*-{
		this.@edu.ucdavis.cstars.client.InfoWindowBase::jso.isShowing = false;
	}-*/;
	
	/**
	 * Resize the info window to the specified width and height (in pixels).
	 * 
	 * @param width - width of window.
	 * @param height - height of window.
	 */
	public final void resize(int width, int height) {
		panel.setSize(width+"px", height+"px");
	}
	
	/**
	 *This method is called by the map when the object is set as its info window. 
	 * 
	 * @param map - MapWidget
	 */
	public void setMap(MapWidget map) {}

	private void _setMap(MapWidget map) {
		this.map = map;
		map.addInfoWindow(panel);
		map.addPanStartHandler(new MapPanStartHandler(){
			@Override
			public void onMapPanStart(Extent extent, Point delta) {
				if( isShowing() ) panel.setVisible(false);
			}
		});
		map.addPanEndHandler(new MapPanEndHandler(){
			@Override
			public void onMapPanEnd(Extent extent, Point delta) {
				if( isShowing() ) {
					panel.setVisible(true);
					update();
				}
			}
		});
		map.addZoomEndHandler(new MapZoomEndHandler(){
			@Override
			public void onZoomEnd(Extent extent, float zoomFactor,
					Point anchor, int level) {
				if( isShowing() ) {
					update();
				}
			}
		});
		setMap(map);
	}
	
	/**
	 * Display the info window at the specified location. 
	 * 
	 * @param location - location window will be shown at
	 */
	public void show(Point loc) {
		currentPoint = loc;
		update();
		onShow();
	}
	
	public void update() {
		if( currentPoint != null ) {
			Point loc = map.toScreen(currentPoint);
			panel.getElement().getStyle().setLeft(loc.getX()+10, Unit.PX);
			panel.getElement().getStyle().setTop(loc.getY()+10, Unit.PX);
			panel.setVisible(true);	
		}
	}
	
	public Point getCurrentPoint() {
		return currentPoint;
	}
	
	/**
	 * Fires after the info window is hidden.
	 */
	public abstract void onHide();
	
	/**
	 * Fires after the info window becomes visible. 
	 */
	public abstract void onShow();

}
