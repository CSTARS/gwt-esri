package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * ESRI API's MouseEvent Object.
 * 
 * Documentation is not great on this.  But http://resources.esri.com/help/9.3/arcgisserver/apis/javascript/arcgis/help/jshelp_start.htm#jshelp/inside_events.htm
 * say that there is screenPoint, mapPoint and graphic information returned
 * 
 * @author Justin Merz
 */
public class MouseEvent extends JavaScriptObject {
	
	protected MouseEvent() {};
	
	public final native Point getScreenPoint() /*-{
		return this.screenPoint;
	}-*/;
	
	public final native Point getMapPoint() /*-{
		return this.mapPoint;
	}-*/;
	
	public final native Graphic getGraphic() /*-{
		return this.graphic;
	}-*/;
	
	public final native boolean hasScreenPoint() /*-{
		if( this.screenPoint ) return true;
		return false;
	}-*/;
	
	public final native boolean hasMapPoint() /*-{
		if( this.mapPoint ) return true;
		return false;
	}-*/;
	
	public final native boolean hasGraphic() /*-{
		if( this.graphic ) return true;
		return false;
	}-*/;

}
