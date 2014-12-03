package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.geometry.Point;
import edu.ucdavis.cstars.client.geometry.Polygon;
import edu.ucdavis.cstars.client.geometry.Polyline;

/**
 * The result from a ServiceAreaTask operation.
 * 
 * @author Justin Merz
 */
public class ServiceAreaSolveResult extends JavaScriptObject {
	
	protected ServiceAreaSolveResult() {}
	
	/**
	 * Array of points, only returned if ServiceAreaParameters.returnFacilities is set to true.
	 * 
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> getFacilities() /*-{
		return this.facilities;
	}-*/;

	/**
	 * Message received when solve is completed. If a service area cannot be solved, the message returned
	 * by the server identifies the incident that could not be solved.
	 * 
	 * @return NAMessage
	 */
	public final native NAMessage getMessages() /*-{
		return this.messages;
	}-*/;
	
	/**
	 * The point barriers are an array of points. They are returned only if ServiceAreaParameters.returnPointBarriers
	 * was set to true (which is not the default). If you send in the point barriers as a featureSet (instead of using
	 * DataLayer), you already have the barrers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Point>
	 */
	public final native JsArray<Point> getPointBarriers() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * The polygon barriers are an array of polygons. They are returned only if ServiceAreaParameters.returnPolygonBarriers
	 * was set to true (which is not the default). If you send in the polygon barriers as a featureSet (instead of using DataLayer),
	 * you already have the barriers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Polygon>
	 */
	public final native JsArray<Polygon> getPolygonBarriers() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * The polyline barriers are an array of polylines. They are returned only if ServiceAreaParameters.returnPolylineBarriers was
	 * set to true (which is not the default). If you send in the polyline barriers as a featureSet (instead of using DataLayer), you
	 * already have the barriers and might not need to request them back from the server.
	 * 
	 * @return JsArray<Polyline>
	 */
	public final native JsArray<Polyline> getPolylineBarriers() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * Array of service area polygons.
	 * 
	 * @return JsArray<Polygon>
	 */
	public final native JsArray<Polygon> getServiceAreaPolygons() /*-{
		return this.serviceAreaPolygons;
	}-*/;
	
	/**
	 * Array of service area polylines.
	 * 
	 * @return JsArray<Polyline>
	 */
	public final native JsArray<Polyline> getServiceAreaPolylines() /*-{
		return this.serviceAreaPolylines;
	}-*/;
	
}
