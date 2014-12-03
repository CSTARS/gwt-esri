package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 * Input parameters for a RouteTask.
 * 
 * @author Justin Merz
 */
public class RouteParameters extends JavaScriptObject {
	
	protected RouteParameters() {}
	
	/**
	 * Creates a new RouteParameters object.
	 * 
	 * @return RouteParameters
	 */
	public static native RouteParameters create() /*-{
		return new $wnd.esri.tasks.RouteParameters();
	}-*/;
	
	/**
	 * The list of network attribute names to be accumulated with the analysis, i.e. which attributes should be returned as part of the
	 * response. The default is as defined in the specific routing network layer used in your RouteTask. You can specify any attributes
	 * names listed in the Service Directory under "Network Dataset -> Network Attributes" as "Usage Type: esriNAUTCost".
	 * 
	 * @return JsArrayString
	 */
	public native final JsArrayString getAccumulateAttributes() /*-{
		return this.accumulateAttributes;
	}-*/;
	
	/**
	 * Set the accumulateAttributes parameter.
	 * 
	 * @param accumulateAttributes - The list of network attribute names to be accumulated with the analysis, i.e. which attributes
	 * should be returned as part of the response. The default is as defined in the specific routing network layer used in your
	 * RouteTask. You can specify any attributes names listed in the Service Directory under "Network Dataset -> Network Attributes"
	 * as "Usage Type: esriNAUTCost".
	 */
	public final void setAccumulateAttributes(String[] accumulateAttributes) {
		_setAccumulateAttributes(Util.stringArrayToJSO(accumulateAttributes));
	}
	
	private final native void _setAccumulateAttributes(JavaScriptObject accumulateAttributes) /*-{
		this.accumulateAttributes = accumulateAttributes;
	}-*/;
	
	/**
	 * Each element in the array is an object that describes the parameter values. 
	 * 
	 * @return JsArray<AttributeParameterValue>
	 */
	public final native JsArray<AttributeParameterValue> getAttributeParameterValues() /*-{
		return this.attributeParameterValues;
	}-*/;
	
	/**
	 * Set the attributeParameterValues parameter.
	 * 
	 * @param attributeParameterValues -  Each element in the array is an object that describes the parameter values. 
	 */
	public final void setAttributeParameterValues(AttributeParameterValue[] attributeParameterValues) {
		_setAttributeParameterValues(Util.objectArrayToJSO(attributeParameterValues));
	}
	
	private final native void _setAttributeParameterValues(JavaScriptObject attributeParameterValues) /*-{
		this.attributeParameterValues = attributeParameterValues;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public native final DataLayer getBarriersAsDataLayer() /*-{
		return this.barriers;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public native final FeatureSet getBarriersAsFeatureSet() /*-{
		return this.barriers;
	}-*/;
	
	/**
	 * Set the barriers parameter.
	 * 
	 * @param barriers - The set of point barriers loaded as network locations during analysis.
	 */
	public final native void setBarriers(DataLayer barriers) /*-{
		this.barriers = barriers;
	}-*/;
	
	/**
	 * Set the barriers parameter.
	 * 
	 * @param barriers - The set of point barriers loaded as network locations during analysis.
	 */
	public final native void setBarriers(FeatureSet barriers) /*-{
		this.barriers = barriers;
	}-*/;
	
	/**
	 * The language used when computing directions. The default is as defined in the specific routing network layer used in your
	 * RouteTask. By default, NAServer gets installed with en_US only - it is up to the server administrator to add additional languages.
	 * 
	 * @return String
	 */
	public native final String getDirectionsLanguage() /*-{
		return this.directionsLanguage;
	}-*/;
	
	/**
	 * Set the directionsLanguage parameter.
	 * 
	 * @param directionsLanguage - The language used when computing directions. The default is as defined in the specific routing
	 * network layer used in your RouteTask. By default, NAServer gets installed with en_US only - it is up to the server administrator
	 * to add additional languages.
	 */
	public final native void setDirectionsLanguage(String directionsLanguage) /*-{
		this.directionsLanguage = directionsLanguage;
	}-*/;
	
	/**
	 * The length units to use when computing directions. The default is as defined in the specific routing network layer used in your
	 * RouteTask. Known values: esriFeet | esriKilometers | esriMeters | esriMiles | esriNauticalMiles | esriYards
	 * 
	 * @return String.
	 */
	public native final String getDirectionLengthUnits() /*-{
		return this.directionsLengthUnits;
	}-*/;
	
	/**
	 * Set the directionsLengthUnits
	 * 
	 * @param directionsLengthUnits -  The length units to use when computing directions. The default is as defined in the specific routing network layer used in your
	 * RouteTask. Known values: esriFeet | esriKilometers | esriMeters | esriMiles | esriNauticalMiles | esriYards
	 */
	public native final void setDirectionLengthUnits(String directionsLengthUnits) /*-{
		this.directionsLengthUnits = directionsLengthUnits;
	}-*/;
	
	/**
	 * The name of network attribute to use for the drive time when computing directions. The default is as defined in the specific routing network
	 * layer used in your RouteTask.
	 * 
	 * @return String
	 */
	public native final String getDirectionsTimeAttribute() /*-{
		return this.directionsTimeAttribute;
	}-*/;
	
	/**
	 * Set the directionsTimeAttribute parameter.
	 * 
	 * @param directionsTimeAttribute - The name of network attribute to use for the drive time when computing directions. The default is as defined
	 * in the specific routing network layer used in your RouteTask.
	 */
	public native final void setDirectionsTimeAttribute(String directionsTimeAttribute) /*-{
		this.directionsTimeAttribute = directionsTimeAttribute;
	}-*/;
	
	/**
	 * If true, avoids network elements restricted by barriers or due to restrictions specified in restrictionAttributes.
	 * 
	 * @return boolean
	 */
	public native final boolean doNotLocateOnRestrictedElements() /*-{
		return this.doNotLocateOnRestrictedElements;
	}-*/;
	
	/**
	 * set the doNotLocateOnRestrictedElements parameter.
	 * 
	 * @param doNotLocateOnRestrictedElements - If true, avoids network elements restricted by barriers or due to
	 * restrictions specified in restrictionAttributes.
	 */
	public native final void setDoNotLocateOnRestrictedElements(boolean doNotLocateOnRestrictedElements) /*-{
		this.doNotLocateOnRestrictedElements = doNotLocateOnRestrictedElements;
	}-*/;
	
	/**
	 * If true, optimizes the order of the stops in the route while taking into account preserveFirstStop and preserveLastStop,
	 * if they are set to true. The default is as defined in the specific routing network layer used in your RouteTask.
	 * 
	 * @return boolean
	 */
	public native final boolean findBestSequence() /*-{
		return this.findBestSequence;
	}-*/;
	
	/**
	 * Set the findBestSequence parameter.
	 * 
	 * @param findBestSequence - If true, optimizes the order of the stops in the route while taking into account preserveFirstStop
	 * and preserveLastStop, if they are set to true. The default is as defined in the specific routing network layer used in your RouteTask.
	 */
	public native final void setFindBestSequence(boolean findBestSequence) /*-{
		this.findBestSequence = findBestSequence;
	}-*/;
	
	/**
	 * In routes where a stop is not located on a network or a stop could not be reached, the results will differ depending on the value of ignoreInvalidLocations. 
	 *     
	 *     When false, the solve operation will fail if at least one of the stops specified cannot be located or reached.
	 *     
	 *     When true, as long as there are at least two valid stops that have been connected by a route, a valid result
	 *     is returned. If multiple routes are processed in a single request, as long as least one route is built, a valid
	 *     result is returned. The list of routes that cannot be solved is included in the message parameter of
	 *     RouteTask.onSolveComplete.
	 * 
	 * @return boolean
	 */
	public native final boolean ignoreInvalidLocations() /*-{
		return this.ignoreInvalidLocations;
	}-*/;
	
	/**
	 * Set the ignoreInvalidLocations parameter.
	 * 
	 * @param ignoreInvalidLocations - In routes where a stop is not located on a network or a stop could not be reached, the results will
	 * differ depending on the value of ignoreInvalidLocations. 
	 *     
	 *     When false, the solve operation will fail if at least one of the stops specified cannot be located or reached.
	 *     
	 *     When true, as long as there are at least two valid stops that have been connected by a route, a valid result
	 *     is returned. If multiple routes are processed in a single request, as long as least one route is built, a valid
	 *     result is returned. The list of routes that cannot be solved is included in the message parameter of
	 *     RouteTask.onSolveComplete.
	 */
	public native final void setIgnoreInvalidLocations(boolean ignoreInvalidLocations) /*-{
		this.ignoreInvalidLocations = ignoreInvalidLocations;
	}-*/;
	
	/**
	 * The network attribute name to be used as the impedance attribute in analysis. The default is as defined in the specific routing network
	 * layer used in your RouteTask. You can specify any attributes names listed in the Service Directory under "Network Dataset -> Network Attributes"
	 * as "Usage Type: esriNAUTCost". You can also specify a value of "none" to indicate that no network attributes should be used for impedance.
	 * If you specify an empty array, it will default to the default of the service. 
	 * 
	 * @return String
	 */
	public native final String getImpedanceAttribute() /*-{
		return this.impedanceAttribute;
	}-*/;
	
	/**
	 * Set the impedanceAttribute parameter.
	 * 
	 * @param impedanceAttribute - The network attribute name to be used as the impedance attribute in analysis. The default is as defined in the specific routing network
	 * layer used in your RouteTask. You can specify any attributes names listed in the Service Directory under "Network Dataset -> Network Attributes"
	 * as "Usage Type: esriNAUTCost". You can also specify a value of "none" to indicate that no network attributes should be used for impedance.
	 * If you specify an empty array, it will default to the default of the service. 
	 */
	public native final void setImpedanceAttribute(String impedanceAttribute) /*-{
		this.impedanceAttribute = impedanceAttribute;
	}-*/;
	
	/**
	 * The precision of the output geometry after generalization. If 0, no generalization of output geometry is performed. If present and positive, it represents the
	 * MaximumAllowableOffset parameter - generalization is performed according to IPolycurve.Generalize.
	 * 
	 * @return int
	 */
	public native final int getOutputGeometryPrecision() /*-{
		return this.outputGeometryPrecision;
	}-*/;
	
	/**
	 * Set the outputGeometryPrecision parameter.
	 * 
	 * @param outputGeometryPrecision - The precision of the output geometry after generalization. If 0, no generalization of output geometry is performed. If
	 * present and positive, it represents the MaximumAllowableOffset parameter - generalization is performed according to IPolycurve.Generalize.
	 */
	public native final void setOutputGeometryPrecision(int outputGeometryPrecision) /*-{
		this.outputGeometryPrecision = outputGeometryPrecision;
	}-*/;
	
	/**
	 * The units of the output geometry precision. The default value is "esriUnknownUnits". Known values: esriUnknownUnits | esriCentimeters
	 * | esriDecimalDegrees | esriDecimeters | esriFeet | esriInches | esriKilometers | esriMeters | esriMiles | esriMillimeters | esriNauticalMiles | esriPoints | esriYards
	 * 
	 * @return String
	 */
	public native final String getOutputGeometryPrecisionUnits() /*-{
		return this.outputGeometryPrecisionUnits;
	}-*/;
	
	/**
	 * Set the outputGeometryPrecisionUnits parameter.
	 * 
	 * @param outputGeometryPrecisionUnits - The units of the output geometry precision. The default value is "esriUnknownUnits". 
	 * Known values: esriUnknownUnits | esriCentimeters | esriDecimalDegrees | esriDecimeters | esriFeet | esriInches | esriKilometers
	 * | esriMeters | esriMiles | esriMillimeters | esriNauticalMiles | esriPoints | esriYards
	 */
	public native final void setOutputGeometryPrecisionUnits(String outputGeometryPrecisionUnits) /*-{
		this.outputGeometryPrecisionUnits = outputGeometryPrecisionUnits;
	}-*/;
	
	/**
	 * The type of output lines to be generated in the result. The default is as defined in the specific routing network layer used in your RouteTask.
	 * 
	 * @return NAOutputLine
	 */
	public final NAOutputLine getOutputLines() {
		String ol = _getOutputLines();
		for( int i = 0 ; i < NAOutputLine.values().length; i++ ){
			if( NAOutputLine.values()[i].getValue().contentEquals(ol) )
				return NAOutputLine.values()[i];
		}
		return NAOutputLine.NOT_SET;
	}
	
	private native final String _getOutputLines() /*-{
		return this.outputLines;
	}-*/;
	
	/**
	 * Set the outputLines parameter
	 * 
	 * @param outputLines - The type of output lines to be generated in the result. The default is as defined in the specific routing network
	 * layer used in your RouteTask.
	 */
	public final void setOutputLines(NAOutputLine outputLines) {
		_setOutputLines(outputLines.getValue());
	}
	
	private native final void _setOutputLines(String outputLines) /*-{
		this.outputLines = outputLines;
	}-*/;
	
	/**
	 * The well-known ID of the spatial reference for the geometries returned with the analysis results. If not specified, the geometries are
	 * returned in the spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public native final SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * Set the outSpatialReference parameter.
	 *
	 * @param outSpatialReference - The well-known ID of the spatial reference for the geometries returned with the analysis results.
	 * If not specified, the geometries are returned in the spatial reference of the map
	 */
	public native final void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * The set of polygon barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolygonBarriersAsDataLayer() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * The set of polygon barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native DataLayer getPolygonBarriersAsFeatureSet() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * Set the polygonBarriers parameter.
	 * 
	 * @param polygonBarriers - The set of polygon barriers loaded as network locations during analysis.
	 */
	public final native void setPolygonBarriers(DataLayer polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;
	
	/**
	 * Set the polygonBarriers parameter.
	 * 
	 * @param polygonBarriers - The set of polygon barriers loaded as network locations during analysis.
	 */
	public final native void setPolygonBarriers(FeatureSet polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolylineBarriersAsDataSet() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPolylineBarriersAsFeatureSet() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * Set the polylineBarriers parameter.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 */
	public final native void setPolylineBarriers(DataLayer polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * Set the polylineBarriers parameter.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 */
	public final native void setPolylineBarriers(FeatureSet polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * If true, keeps the first stop fixed in the sequence even when findBestSequence is true. Only applicable if findBestSequence is true. The default is as
	 * defined in the specific routing network layer used in your RouteTask.
	 * 
	 * @return boolean
	 */
	public native final boolean preserveFirstStop() /*-{
		return this.preserveFirstStop;
	}-*/;
	
	/**
	 * Set the preserveFirstStop parameter.
	 * 
	 * @param preserveFirstStop - If true, keeps the first stop fixed in the sequence even when findBestSequence is true. Only applicable if findBestSequence
	 * is true. The default is as defined in the specific routing network layer used in your RouteTask.
	 */
	public native final void setPreserveFirstStop(boolean preserveFirstStop) /*-{
		this.preserveFirstStop = preserveFirstStop;
	}-*/;
	
	/**
	 * If true, keeps the last stop fixed in the sequence even when findBestSequence is true. Only applicable if findBestSequence is true. The default is as
	 * defined in the specific routing network layer used in your RouteTask.
	 * 
	 * @return boolean
	 */
	public native final boolean preserveLastStop() /*-{
		return this.preserveLastStop;
	}-*/;
	
	/**
	 * Set the preserveLastStop parameter.
	 * 
	 * @param preserveLastStop - If true, keeps the last stop fixed in the sequence even when findBestSequence is true. Only applicable if findBestSequence
	 * is true. The default is as defined in the specific routing network layer used in your RouteTask.
	 */
	public native final void setPreserveLastStop(boolean preserveLastStop) /*-{
		this.preserveLastStop = preserveLastStop;
	}-*/;
	
	/**
	 * The list of network attribute names to be used as restrictions with the analysis. The default is as defined in the specific routing network layer used in your
	 * RouteTask. Possible values are listed in the Service Directory under "Network Dataset -> Network Attributes". You can also specify a value of "none" to
	 * indicate that no network attributes should be used as restrictions. If you specify an empty array, it will default to the default of the service.
	 * 
	 * @return JsStringArray;
	 */
	public native final JsArrayString getRestrictionAttributes() /*-{
		return this.restrictionAttributes;
	}-*/;
	
	/**
	 * Set the restrictionAttributes parameter.
	 * 
	 * @param restrictionAttributes - The list of network attribute names to be used as restrictions with the analysis. The default is as defined in the specific
	 * routing network layer used in your RouteTask. Possible values are listed in the Service Directory under "Network Dataset -> Network Attributes". You
	 * can also specify a value of "none" to indicate that no network attributes should be used as restrictions. If you specify an empty array, it will default to
	 * the default of the service.
	 */
	public final void setRestrictionAttributes(String[] restrictionAttributes) {
		_setRestrictionAttributes(Util.stringArrayToJSO(restrictionAttributes));
	}
	
	private native final void _setRestrictionAttributes(JavaScriptObject restrictionAttributes) /*-{
		this.restrictionAttributes = restrictionAttributes;
	}-*/;
	
	/**
	 * Specifies how U-Turns should be handled. The default is as defined in the specific routing network layer used in your RouteTask. 
	 * 
	 * @return NAUTurn
	 */
	public final NAUTurn getRestrictUTurns() {
		String rut = _getRestrictUTurns();
		for( int i = 0 ; i < NAUTurn.values().length; i++ ){
			if( NAUTurn.values()[i].getValue().contentEquals(rut) )
				return NAUTurn.values()[i];
		}
		return NAUTurn.NOT_SET;
	}
	
	private final native String _getRestrictUTurns() /*-{
		return this.restrictUTurns;
	}-*/;
	
	/**
	 * set the restrictUTurns parameter.
	 * 
	 * @param restrictUTurns - Specifies how U-Turns should be handled. The default is as defined in the specific routing network layer used in your RouteTask
	 */
	public final void setRestrictUTurns(NAUTurn restrictUTurns) {
		_setRestrictUTurns( restrictUTurns.getValue() );
	}
	
	private final native void _setRestrictUTurns(String restrictUTurns) /*-{
		this.restrictUTurns = restrictUTurns;
	}-*/;
	
	/**
	 * If true, barriers are returned as the second parameter of RouteTask.onSolveComplete.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnBarriers() /*-{
		return this.returnBarriers;
	}-*/;
	
	/**
	 * set the returnBarriers parameter.
	 * 
	 * @param returnBarriers - If true, barriers are returned as the second parameter of RouteTask.onSolveComplete.
	 */
	public native final void setReturnBarriers(boolean returnBarriers) /*-{
		this.returnBarriers = returnBarriers;
	}-*/;
	
	/**
	 * If true, directions are generated and returned in the directions property of each RouteResult.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnDirections() /*-{
		return this.returnDirections;
	}-*/;
	
	/**
	 * Set the returnDirections parameter.
	 * 
	 * @param returnDirections - If true, directions are generated and returned in the directions property of each RouteResult.
	 */
	public native final void setReturnDirections(boolean returnDirections) /*-{
		this.returnDirections = returnDirections;
	}-*/;
	
	/**
	 * If true, polygon barriers are returned as the third parameter of RouteTask.onSolveComplete.
	 * 
	 * @return boolean
	 */
	public final native boolean returnPolygonBarriers() /*-{
		return this.returnPolygonBarriers;
	}-*/;
	
	/**
	 * Set the returnPolygonBarriers parameter.
	 * 
	 * @param returnPolygonBarriers - If true, polygon barriers are returned as the third parameter of RouteTask.onSolveComplete.
	 */
	public final native void setReturnPolygonBarriers(boolean returnPolygonBarriers) /*-{
		this.returnPolygonBarriers = returnPolygonBarriers;
	}-*/;
	
	/**
	 * If true, polyline barriers are returned as the fourth parameter of RouteTask.onSolveComplete.
	 * 
	 * @return boolean
	 */
	public final native boolean getReturnPolylineBarriers() /*-{
		return this.returnPolylineBarriers;
	}-*/;
	
	/**
	 * Set the returnPolylineBarriers parameter.
	 * 
	 * @param returnPolylineBarriers - If true, polyline barriers are returned as the fourth parameter of RouteTask.onSolveComplete.
	 */
	public final native void setReturnPolylineBarriers(boolean returnPolylineBarriers) /*-{
		this.returnPolylineBarriers = returnPolylineBarriers;
	}-*/;
	
	/**
	 * If true, routes are generated and returned in the route property of each RouteResult.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnRoutes() /*-{
		return this.returnRoutes;
	}-*/;
	
	/**
	 * Set the returnRoutes parameter.
	 * 
	 * @param returnRoutes - If true, routes are generated and returned in the route property of each RouteResult.
	 */
	public native final void setReturnRoutes(boolean returnRoutes) /*-{
		this.returnRoutes = returnRoutes;
	}-*/;
	
	/**
	 * If true, stops are returned in the stops property of each RouteResult.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnStops() /*-{
		return this.returnStops;
	}-*/;
	
	/**
	 * Set the returnStops parameter.
	 * 
	 * @param returnStops - If true, stops are returned in the stops property of each RouteResult.
	 */
	public native final void setReturnStops(boolean returnStops) /*-{
		this.returnStops = returnStops;
	}-*/;
	
	/**
	 * The time the route begins. If not specified, the default is the time specified in the route service.
	 * 
	 * @return JsDate
	 */
	public native final JsDate getStartTime() /*-{
		return this.startTime;
	}-*/;
	
	/**
	 * Set the startTime parameter.
	 * 
	 * @param startTime - The time the route begins. If not specified, the default is the time specified in the route service.
	 */
	public native final void setStartTime(JsDate startTime) /*-{
		this.startTime = statTime;
	}-*/;
	
	/**
	 * The set of stops loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * When RouteParameters.stops takes a FeatureSet, each feature in the FeatureSet must have a defined spatial reference.
	 * If the feature contains x and y attributes, those values are used for the stop, even if the feature includes geometry. For
	 * the list of attributes that can be set on a stop, see the "Stop properties" section in Finding the best route.
	 * 
	 * @return DataLayer
	 */
	public native final DataLayer getStopsAsDataLayer() /*-{
		return this.stops;
	}-*/;
	
	/**
	 * The set of stops loaded as network locations during analysis. Can be either an instance of DataLayer or FeatureSet.
	 * When RouteParameters.stops takes a FeatureSet, each feature in the FeatureSet must have a defined spatial reference.
	 * If the feature contains x and y attributes, those values are used for the stop, even if the feature includes geometry. For
	 * the list of attributes that can be set on a stop, see the "Stop properties" section in Finding the best route.
	 * 
	 * @return FeatureSet
	 */
	public native final FeatureSet getStopsAsFeatureSet() /*-{
		return this.stops;
	}-*/;
	
	/**
	 * Set the stops parameter.
	 * 
	 * @param stops - The set of stops loaded as network locations during analysis. Can be either an instance of DataLayer or
	 * FeatureSet. When RouteParameters.stops takes a FeatureSet, each feature in the FeatureSet must have a defined
	 * spatial reference. If the feature contains x and y attributes, those values are used for the stop, even if the feature
	 * includes geometry. For the list of attributes that can be set on a stop, see the "Stop properties" section in Finding
	 * the best route.
	 */
	public native final void setStops(DataLayer stops) /*-{
		this.stops = stops;
	}-*/;
	
	/**
	 * Set the stops parameter.
	 * 
	 * @param stops - The set of stops loaded as network locations during analysis. Can be either an instance of DataLayer
	 * or FeatureSet. When RouteParameters.stops takes a FeatureSet, each feature in the FeatureSet must have a defined
	 * spatial reference. If the feature contains x and y attributes, those values are used for the stop, even if the feature
	 * includes geometry. For the list of attributes that can be set on a stop, see the "Stop properties" section in Finding
	 * the best route.
	 */
	public native final void setStops(FeatureSet stops) /*-{
		this.stops = stops;
	}-*/;
	
	/**
	 * If true, the hierarchy attribute for the network should be used in analysis. The default is as defined in the specific
	 * routing network layer used in your RouteTask.
	 * 
	 * @return boolean
	 */
	public native final boolean useHierarchy() /*-{
		return this.useHierarchy;
	}-*/;
	
	/**
	 * Set the useHierarchy parameter.
	 * 
	 * @param useHierarchy - If true, the hierarchy attribute for the network should be used in analysis. The default is as defined in
	 * the specific routing network layer used in your RouteTask.
	 */
	public native final void setUseHierarchy(boolean useHierarchy) /*-{
		this.useHierarchy = useHierarchy;
	}-*/;
	
	/**
	 * If true, time windows should be used in the analysis. The default is as defined in the specific routing network layer used in your RouteTask.
	 * 
	 * @return boolean
	 */
	public native final boolean useTimeWindows() /*-{
		return this.useTimeWindows;
	}-*/;
	
	/**
	 * Set the useTimeWindow parameter.
	 * 
	 * @param useTimeWindows - If true, time windows should be used in the analysis. The default is as defined in the specific routing network
	 * layer used in your RouteTask.
	 */
	public native final void setUseTimeWindows(boolean useTimeWindows) /*-{
		this.useTimeWindows = useTimeWindows;
	}-*/;
	
	
	
	public static class AttributeParameterValue extends JavaScriptObject {
		
		protected AttributeParameterValue() {}
		
		public static AttributeParameterValue create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param attributeName - Name of the attribute
		 */
		public final native void setAttributeName(String attributeName) /*-{
			this.attributeName = attributeName;
		}-*/;
		
		/**
		 * 
		 * @param parameterName - Name of the parameter.
		 */
		public final native void setParameterName(String parameterName) /*-{
			this.parameterName = parameterName;
		}-*/;
		
		/**
		 * 
		 * @param value -Parameter value.
		 */
		public final native void setValue(float value) /*-{
			this.value = value;
		}-*/;
		
	}
	
}
