package edu.ucdavis.cstars.client.control;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.event.MapResizeHandler;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * Handles all control events and Objects.  Used by the MapWidget
 *
 * @author Justin Merz
 */
public class ControlHandler {
	
	private List<Control> controls = new LinkedList<Control>();
	
	private MapWidget map;
	private AbsolutePanel controlLayer;
	
	/**
	 * Pass references to the control layer and map
	 * 
	 * @param m - map
	 * @param cl - control layer
	 */
	public ControlHandler(MapWidget m, AbsolutePanel cl){
		this.map = m;
		this.controlLayer = cl;
		
		controlLayer.getElement().getStyle().setPosition(com.google.gwt.dom.client.Style.Position.ABSOLUTE);
		controlLayer.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		controlLayer.getElement().getStyle().setTop(0, Unit.PX);
		controlLayer.getElement().getStyle().setLeft(0, Unit.PX);
		controlLayer.setStyleName("controlLayer");
		
		map.addResizeHandler(new MapResizeHandler(){
			@Override
			public void onMapResize(Extent extent, int width, int height) {
				moveControls();
			}
		});
	}
	
	/**
	 * Remove control to handler
	 * 
	 * @param c - control to remove
	 */
	public void removeControl(Control c){
		if( !controls.contains(c) ) return;
		controls.remove(c);
		controlLayer.remove(c);
	}
	
	/**
	 * Add control to handler
	 * 
	 * @param c
	 */
	public void addControl(Control c) {
		c.getElement().getStyle().setPosition(com.google.gwt.dom.client.Style.Position.RELATIVE);
		controls.add(c);
		controlLayer.add(c);
		setPosition(c);
		c.init(map);
		c.setControlHandler(this);
	}
	
	public void updateControlPosition(Control c){
		if( controls.contains(c) ) setPosition(c);
	}
	
	/**
	 * reposition all controls
	 */
	private void moveControls() {
		for( Control c: controls ){
			setPosition(c);
		}
	}
	
	/**
	 * reposition control based on its anchor
	 * 
	 * @param c - control to add
	 */
	private void setPosition(Control c) {
		if( !c.isVisible() ) return;
		
		if( c.getPosition() == Position.TOP_LEFT ){
			controlLayer.setWidgetPosition(c, c.getLeft(), c.getTop());
		} else if ( c.getPosition() == Position.TOP_CENTER ) {
			setTopCenter(c);
		} else if ( c.getPosition() == Position.TOP_RIGHT ) {
			setUpperRight(c);
		} else if( c.getPosition() == Position.BOTTOM_LEFT ){
			setLowerLeft(c);
		} else if ( c.getPosition() == Position.BOTTOM_RIGHT ){
			setLowerRight(c);
		}
	}
	
	private void setTopCenter(Control c){
		int left = (map.getMapPanel().getOffsetWidth()/2) - (c.getOffsetWidth()/2);
		controlLayer.setWidgetPosition(c, left, c.getTop());
	}
	
	private void setUpperRight(Control c){
		int left = map.getMapPanel().getOffsetWidth() - c.getLeft() - c.getOffsetWidth();
		controlLayer.setWidgetPosition(c, left, c.getTop());
	}
	
	private void setLowerLeft(Control c){
		int top = map.getMapPanel().getOffsetHeight() - c.getOffsetHeight() - c.getTop();
		controlLayer.setWidgetPosition(c, c.getLeft(), top);
	}
	
	private void setLowerRight(Control c){
		int top = map.getMapPanel().getOffsetHeight() - c.getOffsetHeight() - c.getTop();
		int left = map.getMapPanel().getOffsetWidth() - c.getOffsetWidth() - c.getLeft();
		controlLayer.setWidgetPosition(c, left, top);
	}

}
