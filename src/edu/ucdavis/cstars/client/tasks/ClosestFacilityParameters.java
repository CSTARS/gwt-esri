package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;

/**
 * Input parameters for the ClosestFacilityTask.
 * 
 * Note: ClosestFacilityParameters and other closest facility related classes require ArcGIS Server 10.0 or greater and a closest
 * facility layer. A closest facility layer is a layer of type esriNAServerClosestFacilityLayer.
 * 
 * @author Justin Merz
 */
public class ClosestFacilityParameters extends JavaScriptObject {
	
	protected ClosestFacilityParameters() {}
	
	/**
	 * Creates a new ClosestFacilityParameters object
	 * 
	 * @return ClosestFacilityParameters
	 */
	public static native ClosestFacilityParameters create() /*-{ 
		return new $wnd.esri.tasks.ClosestFacilityParameters();
	}-*/;
	
	/**
	 * Set the accumulate attributes.
	 * 
	 * @param accumulateAttributes - The list of network attribute names to be accumulated with the analysis,
	 * i.e.,which attributes should be returned as part of the response.
	 */
	public final void setAccumulateAttributes(String[]  accumulateAttributes) {
		_setAccumulateAttributes(Util.stringArrayToJSO(accumulateAttributes));
	}
	
	private final native void _setAccumulateAttributes(JavaScriptObject accumulateAttributes) /*-{
		this.accumulateAttributes = accumulateAttributes;
	}-*/;
	
	/**
	 * The list of network attribute names to be accumulated with the analysis, i.e.,which attributes should be returned as part of the response.
	 * 
	 * @return String
	 */
	public final native JsArrayString getAccumulateAttributes() /*-{
		return this.accumulateAttributes;
	}-*/;

	/**
	 * Set the attribute parameter values.
	 * 
	 * @param attributeParameterValues - An array of attribute parameter values that determine which network elements can be used by a vehicle
	 */
	public final void setAttributeParameterValues(AttributeParameter[]  attributeParameterValues) {
		_setAttributeParameterValues(Util.objectArrayToJSO(attributeParameterValues));
	}
	
	private final native void _setAttributeParameterValues(JavaScriptObject attributeParameterValues) /*-{
		this.attributeParameterValues = attributeParameterValues;
	}-*/;
	
	/**
	 * An array of attribute parameter values that determine which network elements can be used by a vehicle
	 * 
	 * @return JsArray<AttributeParameter>
	 */
	public final native JsArray<AttributeParameter> getAttributeParameterValues() /*-{
		return this.attributeParameterValues;
	}-*/;
	
	/**
	 * Set the default cutoff value.
	 * 
	 * @param defaultCutoff - The cutoff value used to determine when to stop traversing.
	 */
	public final native void setDefaultCutoff(double defaultCutoff) /*-{
		this.defaultCutoff = defaultCutoff;
	}-*/;
	
	/**
	 * The cutoff value used to determine when to stop traversing.
	 * 
	 * @return double
	 */
	public final native double getDefaultCutoff() /*-{
		return this.defaultCutoff;
	}-*/;
	
	/**
	 * Set the default target facility count.
	 * 
	 * @param defaultTargetFacilityCount - The number of facilities to find.
	 */
	public final native void setDefaultTargetFacilityCount(int defaultTargetFacilityCount) /*-{
		this.defaultTargetFacilityCount = defaultTargetFacilityCount;
	}-*/;
	
	/**
	 * The number of facilities to find.
	 * 
	 * @return int
	 */
	public final native int getDefaultTargetFacilityCount() /*-{
		return this.defaultTargetFacilityCount;
	}-*/;
	
	/**
	 * Set the directions language
	 * 
	 * @param directionsLanguage - The language used when computing directions. If not specified the task will use the language
	 * defined in the network layer used by the RouteTask. The default language defined by the NAServer is en_US, the server
	 * administrator is responsible for adding additional languages.
	 */
	public final native void setDirectionsLanguage(String directionsLanguage) /*-{
		this.directionsLanguage = directionsLanguage;
	}-*/;
	
	/**
	 * The language used when computing directions. If not specified the task will use the language defined in the network layer
	 * used by the RouteTask. The default language defined by the NAServer is en_US, the server administrator is responsible for
	 * adding additional languages.
	 * 
	 * @return String
	 */
	public final native String getDirectionsLanguage() /*-{
		return this.directionsLanguage;
	}-*/;
	
	/**
	 * Set the directions length units.
	 * 
	 * @param directionsLengthUnits - The length units used when computing directions. If not specified the task will use the value defined by the routing network
	 * layer is used. Possible values are "esriFeet", "esriKilometers","esriMeters", "esriMiles","esriNauticalMiles" and "esriYards".
	 */
	public final native void setDirectionsLengthUnits(String directionsLengthUnits) /*-{
		this.directionsLengthUnits = directionsLengthUnits;
	}-*/;
	
	/**
	 * The length units used when computing directions. If not specified the task will use the value defined by the routing network
	 * layer is used. Possible values are "esriFeet", "esriKilometers","esriMeters", "esriMiles","esriNauticalMiles" and "esriYards".
	 * 
	 * @return String
	 */
	public final native String getDirectionsLengthUnits() /*-{
		return this.directionsLengthUnits;
	}-*/;
	
	/**
	 * Set the directions time attributes
	 * 
	 * @param directionsTimeAttribute - The name of the attribute field that contains the drive time values. If not specified the task
	 * will use the attribute field defined by the routing network layer.
	 */
	public final native void setDirectionsTimeAttribute(String directionsTimeAttribute) /*-{
		this.directionsTimeAttribute = directionsTimeAttribute;
	}-*/;
	
	/**
	 * The name of the attribute field that contains the drive time values. If not specified the task will use the attribute field defined by the routing network layer.
	 * 
	 * @return String
	 */
	public final native String getDirectionsTimeAttribute() /*-{
		return this.directionsTimeAttribute;
	}-*/;
	
	/**
	 * Set the facilities.
	 * 
	 * @param facilities - The set of facilities loaded as network locations during analysis. 
	 */
	public final native void setFacilities(DataLayer facilities) /*-{
		this.facilities = facilities;
	}-*/;
	
	/**
	 * Set the facilities.
	 * 
	 * @param facilities - The set of facilities loaded as network locations during analysis. 
	 */
	public final native void setFacilities(FeatureSet facilities) /*-{
		this.facilities = facilities;
	}-*/;
	
	/**
	 * The set of facilities loaded as network locations during analysis. These can be specified
	 * as either esri.tasks.DataLayer or esri.tasks.FeatureSet
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getFacilitiesAsDataLayer() /*-{
		return this.facilities;
	}-*/;
	
	/**
	 * The set of facilities loaded as network locations during analysis. These can be specified
	 * as either esri.tasks.DataLayer or esri.tasks.FeatureSet
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getFacilitiesAsFeatureSet() /*-{
		return this.facilities;
	}-*/;
	
	/**
	 * Set the impedence attibute.
	 * 
	 * @param impedenceAttribute - The network attribute field name used as the impedence attribute during
	 * analysis. If not specified the default value defined by the routing network layer. Valid values include any
	 * attribute name listed in the Service Directory under Network Dataset > Network Attributes with a Usage
	 * Type of esriNauTCost. Specify none to indicate that no network attributes should be used for impedence.
	 * If you specify an empty string the default value defined by the service will be used. 
	 */
	public final native void setImpedenceAttribute(String impedenceAttribute) /*-{
		this.impedenceAttribute = impedenceAttribute;
	}-*/;
	
	/**
	 * The network attribute field name used as the impedence attribute during
	 * analysis. If not specified the default value defined by the routing network layer. Valid values include any
	 * attribute name listed in the Service Directory under Network Dataset > Network Attributes with a Usage
	 * Type of esriNauTCost. Specify none to indicate that no network attributes should be used for impedence.
	 * If you specify an empty string the default value defined by the service will be used. 
	 * 
	 * @return String
	 */
	public final native String getImpedenceAttribute() /*-{
		return this.impedenceAttribute;
	}-*/;
	
	/**
	 * Set the incidents.
	 * 
	 * @param incidents - The set of incidents loaded as network locations during analysis.
	 */
	public final native void setIncidents(DataLayer incidents) /*-{
		this.incidents = incidents;
	}-*/;
	
	/**
	 * Set the incidents.
	 * 
	 * @param incidents - The set of incidents loaded as network locations during analysis.
	 */
	public final native void setIncidents(FeatureSet incidents) /*-{
		this.incidents = incidents;
	}-*/;
	
	/**
	 * The set of incidents loaded as network locations during analysis. Can be an instance of
	 * esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getIncidentsAsDataLayer() /*-{
		return this.incidents;
	}-*/;
	
	/**
	 * The set of incidents loaded as network locations during analysis. Can be an instance of
	 * esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getIncidentsAsFeatureSet() /*-{
		return this.incidents;
	}-*/;
	
	/**
	 * Set the output geometry precision
	 * 
	 * @param outputGeometryPrecision - The output geometry precision. When 0, no generalization of
	 * the output geometry is performed. Positive values represent the MaximumAllowableOffset parameter used by generalize.
	 */
	public final native void setOutputGeometryPrecision(int outputGeometryPrecision) /*-{
		this.outputGeometryPrecision = outputGeometryPrecision;
	}-*/;
	
	/**
	 * The output geometry precision. When 0, no generalization of the output geometry is performed. Positive
	 * values represent the MaximumAllowableOffset parameter used by generalize.
	 * 
	 * @return int
	 */
	public final native int getOutputGeometryPrecision() /*-{
		return this.outputGeometryPrecision;
	}-*/;
	
	/**
	 * Set the output geometry precision units
	 * 
	 * @param outputGeometryPrecisionUnits - The units of the output geometry precision. The default value is esriUnknownUnits.
	 */
	public final native void setOutputGeometryPrecisionUnits(String outputGeometryPrecisionUnits) /*-{
		this.outputGeometryPrecisionUnits = outputGeometryPrecisionUnits;
	}-*/;
	
	/**
	 * The units of the output geometry precision. The default value is esriUnknownUnits
	 * 
	 * @return String
	 */
	public final native String getOutputGeometryPrecisionUnits() /*-{
		return this.outputGeometryPrecisionUnits;
	}-*/;
	
	/**
	 * Set the output lines.
	 * 
	 * @param outputLines - The type of output lines to be generated in the result. The default is as defined in the
	 * specific routing network layer used in your RouteTask. See NAOutputLine for a list of valid values.
	 */
	public final native void setOutputLines(String outputLines) /*-{
		this.outputLines = outputLines;
	}-*/;
	
	/**
	 * The type of output lines to be generated in the result. The default is as defined in the specific routing network
	 * layer used in your RouteTask. See NAOutputLine for a list of valid values.
	 * 
	 * @return String
	 */
	public final native String getOutputLines() /*-{
		return this.outputLines;
	}-*/;
	
	/**
	 * Set the out spatial reference.
	 * 
	 * @param outSpatialReference - he well-known id of the spatial reference for the geometries returned with the analysis
	 * results. If the outSpatialReference is not specified, the geometries are returned in the spatial reference of the map.
	 */
	public final native void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * The well-known id of the spatial reference for the geometries returned with the analysis results. If the outSpatialReference
	 * is not specified, the geometries are returned in the spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * Set the point Barriers
	 * 
	 * @param pointBarriers - The set of point barriers loaded as network locations during analysis.
	 */
	public final native void setPointBarriers(DataLayer pointBarriers) /*-{
		this.pointBarriers = pointBarriers;
	}-*/;
	
	/**
	 * Set the point Barriers
	 * 
	 * @param pointBarriers - The set of point barriers loaded as network locations during analysis.
	 */
	public final native void setPointBarriers(FeatureSet pointBarriers) /*-{
		this.pointBarriers = pointBarriers;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPointBarriersAsDataLayer() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPointBarriersAsFeatureSet() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * Set the polygon barriers
	 * 
	 * @param polygonBarriers - The set of polygon barriers loaded as network locations during analysis.
	 */
	public final native void setPolygonBarriers(DataLayer polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;

	/**
	 * Set the polygon barriers
	 * 
	 * @param polygonBarriers - The set of polygon barriers loaded as network locations during analysis.
	 */
	public final native void setPolygonBarriers(FeatureSet polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;
	
	/**
	 * The set of polygon barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolygonBarriersAsDataLayer() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * The set of polygon barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPolygonBarriersAsFeatureSet() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * Set the polyline barriers.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis. 
	 */
	public final native void setPolylineBarriers(DataLayer polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * Set the polyline barriers.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis. 
	 */
	public final native void setPolylineBarriers(FeatureSet polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolylineBarriersAsDataLayer() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPolylineBarriersAsFeatureSet() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * Set the restricition attributes
	 * 
	 * @param restrictionAttributes - The list of network attribute names to be used as restrictions with the analysis. The default is as
	 * defined in the specific routing network layer used in your RouteTask. Possible values are listed in the Service Directory under
	 * Network Dataset > Network Attributes. You can also specify a value of none to indicate that no network attributes should be
	 * used as restrictions. If you specify an empty array, it will default to the default of the service.
	 */
	public final void setRestrictionAttributes(String[] restrictionAttributes) {
		_setRestrictionAttributes(Util.stringArrayToJSO(restrictionAttributes));
	}

	private final native void _setRestrictionAttributes(JavaScriptObject restrictionAttributes) /*-{
		this.restrictionAttributes = restrictionAttributes;
	}-*/;
	
	/**
	 * The list of network attribute names to be used as restrictions with the analysis. The default is as defined in the specific routing
	 * network layer used in your RouteTask. Possible values are listed in the Service Directory under Network Dataset > Network
	 * Attributes. You can also specify a value of none to indicate that no network attributes should be used as restrictions. If you
	 * specify an empty array, it will default to the default of the service.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getRestrictionAttributes() /*-{
		return this.restrictionAttributes;
	}-*/;
	
	/**
	 * Set restrict turns.
	 * 
	 * @param restrictUTurns - Specifies how U-Turns should be handled. The default is as defined in the specific routing network
	 * layer used in your RouteTask. See NAUTurn for a list of valid values.
	 */
	public final native void setRestrictUTurns(String restrictUTurns) /*-{
		this.restrictUTurns = restrictUTurns;
	}-*/;
	
	/**
	 * Specifies how U-Turns should be handled. The default is as defined in the specific routing network layer used in your
	 * RouteTask. See NAUTurn for a list of valid values.
	 * 
	 * @return String
	 */
	public final native String getRestrictUTurns() /*-{
		return this.restrictUTurns;
	}-*/;
	
	/**
	 * Set return directions value.
	 * 
	 * @param returnDirections - If true, directions will be generated and returned in the directions property
	 * of each RouteResult and RouteSolveResult. Default value is false.
	 */
	public final native void setReturnDirections(boolean returnDirections) /*-{
		this.returnDirections = returnDirections;
	}-*/;
	
	/**
	 * If true, directions will be generated and returned in the directions property of each RouteResult and RouteSolveResult.
	 * 
	 * @return boolean
	 */
	public final native boolean returnDirections() /*-{
		return this.returnDirections;
	}-*/;
	
	/**
	 * Set return facilities value.
	 * 
	 * @param returnFacilities - If true, facilities will be returned with the analysis results. Default values is false.
	 */
	public final native void setReturnFacilities(boolean returnFacilities) /*-{
		this.returnFacilities = returnFacilities;
	}-*/;
	
	/**
	 * If true, facilities will be returned with the analysis results. Default values is false.
	 * 
	 * @return boolean
	 */
	public final native boolean returnFacilities() /*-{
		return this.returnFacilities;
	}-*/;
	
	/**
	 * Set return incidents value.
	 * 
	 * @param returnIncidents - If true, incidents will be returned with the analysis results. Default value is false.
	 */
	public final native void setReturnIncidents(boolean returnIncidents) /*-{
		this.returnIncidents = returnIncidents;
	}-*/;
	
	/**
	 * If true, incidents will be returned with the analysis results. Default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean returnIncidents() /*-{
		return this.returnIncidents;
	}-*/;
	
	/**
	 * Set the return point barriers value.
	 * 
	 * @param returnPointBarriers - If true, barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 */
	public final native void setReturnPointBarriers(boolean returnPointBarriers) /*-{
		this.returnPointBarriers = returnPointBarriers;
	}-*/;
	
	/**
	 * If true, barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean returnPointBarriers() /*-{
		return this.returnPointBarriers;
	}-*/;
	
	/**
	 * Set the return polygon barriers value.
	 * 
	 * @param returnPolygonBarriers - If true, polygon barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 */
	public final native void setReturnPolygonBarriers(boolean returnPolygonBarriers) /*-{
		this.returnPolygonBarriers = returnPolygonBarriers;
	}-*/;
	
	/**
	 * If true, polygon barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean returnPolygonBarriers() /*-{
		return this.returnPolygonBarriers;
	}-*/;
	
	/**
	 * Set the return polyline barriers value.
	 * 
	 * @param returnPolylineBarriers - If true, polyline barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 */
	public final native void setReturnPolylineBarriers(boolean returnPolylineBarriers) /*-{
		this.returnPolylineBarriers = returnPolylineBarriers;
	}-*/;
	
	/**
	 * If true, polyline barriers will be returned in the barriers property of the ClosestFacilitySolveResult. Default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean getReturnPolylineBarriers() /*-{
		return this.returnPolylineBarriers;
	}-*/;
	
	/**
	 * Set the return routes values.
	 * 
	 * @param returnRoutes - When true, closest facility routes will be generated and returned in the route property of each
	 * ClosestFacilityResult and ClosestFacilitySolveResult. Default value is true.
	 */
	public final native void setReturnRoutes(boolean returnRoutes) /*-{
		this.returnRoutes = returnRoutes;
	}-*/;
	
	/**
	 * When true, closest facility routes will be generated and returned in the route property of each ClosestFacilityResult and
	 * ClosestFacilitySolveResult. Default value is true.
	 * 
	 * @return boolean
	 */
	public final native boolean returnRoutes() /*-{
		return this.returnRoutes;
	}-*/;
	
	/**
	 * The arrival or departure date and time. For example, if the travelDirection is set to TO_FACILITY and timeOfDayUsage is set 
	 * to "end" and timeOfDay is set to 8:00 a.m., the returned route(s) will be setup to arrive at the facility at 8:00 a.m. local 
	 * time. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 * 
	 * @return JsDate
	 */
	public final native JsDate getTimeOfDay() /*-{
		return this.timeOfDay;
	}-*/;
	
	/**
	 * Set timeOfDay parameter.
	 * 
	 * @param timeOfDay - The arrival or departure date and time. For example, if the travelDirection is set to TO_FACILITY and 
	 * timeOfDayUsage is set to "end" and timeOfDay is set to 8:00 a.m., the returned route(s) will be setup to arrive at the 
	 * facility at 8:00 a.m. local time. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 */
	public final native void setTimeOfDay(JsDate timeOfDay) /*-{
		this.timeOfDay = timeOfDay;
	}-*/;
	
	/**
	 * Defines the way the timeOfDay value is used. The default value is defined in the network layer. Requires ArcGIS Server 
	 * service version 10.1 or greater. (As of v2.6)
	 * 
	 * Known values: start | end
	 * 
	 * @return String
	 */
	public final native String getTimeOfDayUsage() /*-{
		return this.timeOfDayUsage;
	}-*/;
	
	/**
	 * Set timeOfDayUsage parameter.
	 * 
	 * @param timeOfDayUsage - Defines the way the timeOfDay value is used. The default value is defined in the network layer. 
	 * Requires ArcGIS Server service version 10.1 or greater. (As of v2.6) Known values: start | end
	 */
	public final native void setTimeOfDayUsage(String timeOfDayUsage) /*-{
		return this.timeOfDayUsage = timeOfDayUsage;
	}-*/;
	
	/**
	 * Set the travel direction.
	 * 
	 * @param travelDirection - Options for traveling to or from the facility. Default values are defined by the newtork layer.
	 * See NATravelDirection for a list of valid values.
	 */
	public final native void setTravelDirection(String travelDirection) /*-{
		this.travelDirection = travelDirection;
	}-*/;
	
	/**
	 * Options for traveling to or from the facility. Default values are defined by the newtork layer.
	 * See NATravelDirection for a list of valid values.
	 * 
	 * @return String
	 */
	public final native String getTravelDirection() /*-{
		return this.travelDirection;
	}-*/;
	
	/**
	 * Set if the hierarchy attribute should be used.
	 * 
	 * @param useHierarchy - If true, the hierarchy attribute for the network will be used in analysis. The default
	 * is defined in the routing network layer used by the ClosestFacilityTask.
	 */
	public final native void setUseHierarchy(boolean useHierarchy) /*-{
		this.useHierarchy = useHierarchy;
	}-*/;
	
	/**
	 * If true, the hierarchy attribute for the network will be used in analysis. The default is defined in the routing network layer used by the ClosestFacilityTask.
	 * 
	 * @return boolean
	 */
	public final native boolean useHierarchy() /*-{
		return this.useHierarchy;
	}-*/;
	
	
	
	
	
	
	public static class AttributeParameter extends JavaScriptObject {
	
		protected AttributeParameter() {}
		
		public static AttributeParameter create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param name - The name of the attribute.
		 */
		public final native void setAttributeName(String name) /*-{
			this["attributeName"] = name;
		}-*/;
		
		/**
		 * 
		 * @param name - The parameter name
		 */
		public final native void setParameterName(String name) /*-{
			this["parameterName"] = name;
		}-*/;
		
		/**
		 * 
		 * @param value - The parameter value.
		 */
		public final native void setParameterValue(String value) /*-{
			this["parameterValue"] = value;
		}-*/;
		
	}
	
}
