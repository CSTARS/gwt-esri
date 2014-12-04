package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.geometry.Point;
import edu.ucdavis.cstars.client.geometry.Polygon;
import edu.ucdavis.cstars.client.geometry.Polyline;

/**
 * The result from a ClosestFacilityTask operation.
 * 
 * Note: ClosestFacilitySolveResult, and other closest facility related classes, requires ArcGIS Server 10.0 or above and a closest
 * facility layer. A closest facility layer is a layer of type esriNAServerClosestFacilityLayer.
 * 
 * @author Justin Merz
 */
public class ClosestFacilitySolveResult extends JavaScriptObject {

	protected ClosestFacilitySolveResult() {}
	
	/**
	 * An array of directions. A direction is an instance of esri.tasks.DirectionFeatureSest.
	 * Route directions are returned if returnDirections was set to true, the default is false.
	 * 
	 * @return JsArray<DirectionsFeatureSet>
	 */
	public final native JsArray<DirectionsFeatureSet> getDirections() /*-{
		return this.directions;
	}-*/;
	
	/**
	 * An array of points, only returned when ClosestFacilityParameters.returnFacilities is true.
	 * 
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> getFacilities() /*-{
		return this.facilities;
	}-*/;
	
	/**
	 * An array of points, only returned when ClosestFacilityParameters.returnIncidents is true.
	 * 
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> getIncidents() /*-{
		return this.incidents;
	}-*/;
	
	/**
	 * Message received when the solve is complete. If a closest facility cannot be solved, the message
	 * returned by the server identifies the incident that could not be solved.
	 * 
	 * @return JsArray<NAMessage>
	 */
	public final native JsArray<NAMessage> getMessages() /*-{
		return this.message;
	}-*/;
	
	/**
	 * The point barriers are an array of points. They are returned only if ClosestFacilityParameters.returnPointBarriers was set to true
	 * (which is not the default). If you send in the point barriers as a featureSet (instead of using DataLayer), you already have the
	 * barrers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> getPointBarriers() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * he polygon barriers are an array of polygons. They are returned only if ClosestFacilityParameters.returnPolygonBarriers was set to
	 * true (which is not the default). If you send in the polygon barriers as a featureSet (instead of using DataLayer), you already have
	 * the barriers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Polygon>
	 */
	public final native JsArray<Polygon> getPolygonBarriers() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * The polyline barriers are an array of polylines. They are returned only if ClosestFacilityParameters.returnPolylineBarriers was set to
	 * true (which is not the default). If you send in the polyline barriers as a featureSet (instead of using DataLayer), you already have the
	 * barriers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Polyline>
	 */
	public final native JsArray<Polyline> getPolylineBarriers() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * The array of routes. Route features are returned if returnRoutes is true and outputLines does not equal esriNAOutputLineNone.
	 * From version 2.0 to 2.5 the type is an array of Polylines. At version 2.6 the type is an array of Graphics.
	 * 
	 * @deprecated
	 * @return JsArray<Polyline>
	 */
	public final native JsArray<Polyline> getRoutesAsPolyline() /*-{
		return this.routes;
	}-*/;
	
	/**
	 * The array of routes. Route features are returned if returnRoutes is true and outputLines does not equal esriNAOutputLineNone.
	 * From version 2.0 to 2.5 the type is an array of Polylines. At version 2.6 the type is an array of Graphics.
	 * 
	 * @return JsArray<Graphic>
	 */
	public final native JsArray<Graphic> getRoutes() /*-{
		return this.routes;
	}-*/;
	
}
