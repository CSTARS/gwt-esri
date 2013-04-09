package edu.ucdavis.cstars.client.control;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.Composite;

import edu.ucdavis.cstars.client.MapWidget;

/**
 * Base class for custom maps controls. 
 * All custom controls should extent this class
 *
 * @author Justin Merz
 */
public abstract class Control extends Composite {

	protected ControlHandler handler = null;
	protected Position position = Position.TOP_LEFT;
	protected int top = 0;
	protected int left = 0;
	
	public Control(){}
	
	public void setControlHandler(ControlHandler handler){
		this.handler = handler;
	}
	
	/**
	 * Called when widget is added to the map.
	 * 
	 * @param mapWidget - Reference to the MapWidget
	 */
	public abstract void init(MapWidget mapWidget);
	
	/**
	 * Sets the controls top offset
	 * 
	 * @param top
	 */
	public void setTop(int top){
		this.top = top;
	}
	
	/**
	 * Get the controls top offset
	 * 
	 * @return int
	 */
	public int getTop(){
		return top;
	}
	
	/**
	 * Sets the controls left offset
	 * 
	 * @param left
	 */
	public void setLeft(int left){
		this.left = left;
	}
	
	/**
	 * Gets the controls left offset
	 * 
	 * @return int
	 */
	public int getLeft() {
		return left;
	}
	
	/**
	 * Set the controls location offset
	 * 
	 * @param top
	 * @param left
	 */
	public void setPosition(int top, int left){
		getElement().getStyle().setOverflow(Overflow.VISIBLE);
		setTop(top);
		setLeft(left);
		updatePosition();
	}
	
	/**
	 * Set the controls location and anchor point
	 * 
	 * @param top - diff y
	 * @param left - diff x
	 * @param pos - Anchor point from which top/left are calculated
	 */
	public void setPosition(int top, int left, Position pos){
		getElement().getStyle().setOverflow(Overflow.VISIBLE);
		setTop(top);
		setLeft(left);
		position = pos;
		updatePosition();
	}
	
	/**
	 * Anchor point from which top/left are calculated
	 * 
	 * @param pos
	 */
	public void setPosition(Position pos){
		getElement().getStyle().setOverflow(Overflow.VISIBLE);
		position = pos;
		updatePosition();
	}
	
	/**
	 * Get the anchor position for the control
	 * 
	 * @return Position
	 */
	public Position getPosition() {
		return position;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if( isVisible() ) updatePosition();
	}
	
	protected void updatePosition() {
		if( handler != null ) handler.updateControlPosition(this);
	}
}
