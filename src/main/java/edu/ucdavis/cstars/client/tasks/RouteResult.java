package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;

/**
 * The result from the Route Task. The RouteResult properties are dependent on the RouteParameter inputs.
 * For example, directions are only returned if RouteParameters.returnDirections is set to "true".
 * 
 * @author Justin Merz
 */
public class RouteResult extends JavaScriptObject {
	
	protected RouteResult() {}
	
	/**
	 * Route directions are returned if RouteParameters.returnDirections is set to true.
	 * 
	 * @return DirectionsFeatureSet
	 */
	public final native DirectionsFeatureSet getDirections() /*-{
		return this.directions;
	}-*/;
	
	/**
	 * The Route graphic that is returned if RouteParameters.returnRoutes is true. 
	 * 
	 * @return Graphic
	 */
	public final native Graphic getRoute() /*-{
		return this.route;
	}-*/;
	
	/**
	 * The name of the route.
	 * 
	 * @return String
	 */
	public final native String getRouteName() /*-{
		return this.routeName;
	}-*/;
	
	/**
	 * Array of stops. Returned only if RouteParameters.returnStops is true.
	 * 
	 * @return JsArray<Graphic>
	 */
	public final native JsArray<Graphic> getStops() /*-{
		return this.stops;
	}-*/;

}
