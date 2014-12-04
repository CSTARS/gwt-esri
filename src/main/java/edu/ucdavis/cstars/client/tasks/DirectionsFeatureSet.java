package edu.ucdavis.cstars.client.tasks;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Polyline;

/**
 * A FeatureSet that has properties specific to routing. The FeatureSet.features property contains the turn by turn directions text and geometry
 * of the route. The attributes for each feature provide information associated with the corresponding route segment. The following attributes
 * are returned: 
 *     text - The direction text.
 *     length - The length of the route segment.
 *     time - The time to travel along the route segment.
 *     ETA - The estimated time of arrival at the route segment in the local time.
 *     maneuverType - The type of maneuver that the direction represents.
 *     
 *  DirectionsFeatureSet has no constructor. For more information, see Getting driving directions.
 * 
 * @author Justin Merz
 */
public class DirectionsFeatureSet extends FeatureSet {
	
	protected DirectionsFeatureSet() {}

	/**
	 * The extent of the route.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.extent;
	}-*/;

	/**
	 * A single polyline representing the route.
	 * 
	 * @return Polyline
	 */
	public final native Polyline getMergedGeometry() /*-{
		return this.mergedGeometry;
	}-*/;
	
	/**
	 * The ID of the route returned from the server.
	 * 
	 * @return String
	 */
	public final native String getRouteId() /*-{
		return this.routeId;
	}-*/;

	/**
	 * Name specified in RouteParameters.stops.
	 * 
	 * @return String
	 */
	public final native String getRouteName() /*-{
		return this.routeName;
	}-*/;
	
	/**
	 * Actual drive time calculated for the route.
	 * 
	 * @return double
	 */
	public final native double getTotalDriveTime() /*-{
		return this.totalDriveTime;
	}-*/;

	/**
	 * The length of the route as specified in RouteParameters.directionsLengthUnits.
	 * 
	 * @return double
	 */
	public final native double getTotalLength() /*-{
		return this.totalLength;
	}-*/;
	
	/**
	 * The total time calculated for the route as specified in RouteParameters.directionsTimeAttribute.
	 * 
	 * @return double
	 */
	public final native double getTotalTime() /*-{
		return this.totalTime;
	}-*/;
	
}
