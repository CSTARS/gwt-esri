package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Units;
import edu.ucdavis.cstars.client.Util;

/**
 * Input parameters for a ServiceAreaTask.
 * 
 * Note: ServiceAreaParameters, and other service area related classes, requires ArcGIS Server 10.0 or above and a service area layer.
 * A service area layer is a layer of type esriNAServerServiceAreaLayer.
 * 
 * @author Justin Merz
 */
public class ServiceAreaParameters extends JavaScriptObject {
	
	protected ServiceAreaParameters() {}
	
	/**
	 * Creates a new RouteParameters object.
	 * 
	 * @return RouteParameters
	 */
	public static native ServiceAreaParameters create() /*-{
		return new $wnd.esri.tasks.ServiceAreaParameters();
	}-*/;
	
	/**
	 * The list of network attribute names to be accumulated with the analysis, i.e., which attributes should be returned as part of the response.
	 * The default is as defined in the specific routing network layer used in your RouteTask. You can specify any attributes names listed in the
	 * Service Directory under Network Dataset > Network Attributes as Usage Type: esriNAUTCost.
	 * 
	 * @return JsArrayString
	 */
	public native final JsArrayString getAccumulateAttributes() /*-{
		return this.accumulateAttributes;
	}-*/;
	

	/**
	 * Set the accumulateAttributes parameter.
	 * 
	 * @param accumulateAttributes - The list of network attribute names to be accumulated with the analysis, i.e., which attributes should be
	 * returned as part of the response. The default is as defined in the specific routing network layer used in your RouteTask. You can specify
	 * any attributes names listed in the Service Directory under Network Dataset > Network Attributes as Usage Type: esriNAUTCost.
	 */
	public final void setAccumulateAttributes(String[] accumulateAttributes) {
		_setAccumulateAttributes(Util.stringArrayToJSO(accumulateAttributes));
	}
	
	private final native void _setAccumulateAttributes(JavaScriptObject accumulateAttributes) /*-{
		this.accumulateAttributes = accumulateAttributes;
	}-*/;
	
	/**
	 * A set of attribute parameter values that can be parameterized to determine which network elements can be used by a vehicle. The parameter
	 * holding a vehicle charactersitic is compared to a value coming from a descriptor attribute to determine whether or not a network element is
	 * traversible. For example, a parameterized restriction attribute can compare the height of your vehicle with a descriptor attribute that holds
	 * the clearance under overpasses through tunnels. If the vehicles height is greater than the clearance, the edge is restricted. Parameterized
	 * cost attributes that can reference other cost attributes and scale them, can also be used. This is useful when inclement weather like ice, fog
	 * or heavy rain, descends on the study area and hinders normal flow of traffic. By having a parameter already outfitted on a cost attribute,
	 * travel-time expectations and traversible network paths can be adjusted with respect to changes in traffic speeds.
	 * 
	 * @return JsArray<AttributeParameterValue>
	 */
	public final native JsArray<AttributeParameterValue> getAttributeParameterValues() /*-{
		return this.attributeParameterValues;
	}-*/;
	
	/**
	 * Set the attributeParameterValues parameter.
	 * 
	 * @param attributeParameterValues - A set of attribute parameter values that can be parameterized to determine which network elements can
	 * be used by a vehicle. The parameter holding a vehicle charactersitic is compared to a value coming from a descriptor attribute to determine
	 * whether or not a network element is traversible. For example, a parameterized restriction attribute can compare the height of your vehicle
	 * with a descriptor attribute that holds the clearance under overpasses through tunnels. If the vehicles height is greater than the clearance, the
	 * edge is restricted. Parameterized cost attributes that can reference other cost attributes and scale them, can also be used. This is useful when
	 * inclement weather like ice, fog or heavy rain, descends on the study area and hinders normal flow of traffic. By having a parameter already
	 * outfitted on a cost attribute, travel-time expectations and traversible network paths can be adjusted with respect to changes in traffic speeds.
	 */
	public final void setAttributeParameterValues(AttributeParameterValue[] attributeParameterValues) {
		_setAttributeParameterValues(Util.objectArrayToJSO(attributeParameterValues));
	}
	
	private final native void _setAttributeParameterValues(JavaScriptObject attributeParameterValues) /*-{
		this.attributeParameterValues = attributeParameterValues;
	}-*/;
	
	/**
	 * An array of numbers defining the breaks. The default value is defined in the network analysis layer .
	 * 
	 * @return JsArrayInteger
	 */
	public native final JsArrayInteger getDefaultBreaks() /*-{
		return this.defaultBreaks;
	}-*/;

	/**
	 * Set the defaultBreaks parameter.
	 * 
	 * @param defaultBreaks - An array of numbers defining the breaks. The default value is defined in
	 * the network analysis layer .
	 */
	public final void setDefaultBreaks(int[] defaultBreaks){
		_setDefaultBreaks(Util.intArrayToJSO(defaultBreaks));
	}
	
	private final native void _setDefaultBreaks(JavaScriptObject defaultBreaks) /*-{
		this.defaultBreaks = defaultBreaks;
	}-*/;
	
	/**
	 * An array of network source names to NOT use when generating polygons. ExcludeSourcesFromPolygons specifies if
	 * certain network sources should be excluded from the service area polygon generation. A service area on a multi-modal
	 * network where only one mode is being used to compute the service area would get a more appropriate shape if other
	 * modes are excluded from the polygons.
	 * 
	 * @return JsArrayString
	 */
	public final native JsArrayString getExcludeSourcesFromPolygons() /*-{
		return this.excludeSourcesFromPolygons;
	}-*/;
	
	/**
	 * Set the excludeSourcesFromPolygons parameter.
	 * 
	 * @param excludeSourcesFromPolygons - An array of network source names to NOT use when generating polygons.
	 * ExcludeSourcesFromPolygons specifies if certain network sources should be excluded from the service area polygon
	 * generation. A service area on a multi-modal network where only one mode is being used to compute the service area
	 * would get a more appropriate shape if other modes are excluded from the polygons.
	 */
	public final void setExcludeSourcesFromPolygons(String[] excludeSourcesFromPolygons) {
		_setExcludeSourcesFromPolygons(Util.stringArrayToJSO(excludeSourcesFromPolygons));
	}
	
	private final native void _setExcludeSourcesFromPolygons(JavaScriptObject excludeSourcesFromPolygons) /*-{
		this.excludeSourcesFromPolygons = excludeSourcesFromPolygons;
	}-*/;
	
	/**
	 * The set of facilities loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getFacilitiesAsDataLayer() /*-{
		return this.facilities;
	}-*/;
	
	/**
	 * The set of facilities loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getFacilitiesAsFeatureSet() /*-{
		return this.facilities;
	}-*/;
	
	/**
	 * Set the facilities parameter.
	 * 
	 * @param facilities - The set of facilities loaded as network locations during analysis.
	 */
	public final native void setFacilities(DataLayer facilities) /*-{
		this.facilities = facilities;
	}-*/;
	
	/**
	 * Set the facilities parameter.
	 * 
	 * @param facilities - The set of facilities loaded as network locations during analysis.
	 */
	public final native void setFacilities(FeatureSet facilities) /*-{
		this.facilities = facilities;
	}-*/;
	
	/**
	 * The network attribute name used as the impedence attribute in analysis.The default is as defined in the specific
	 * routing network layer used in your RouteTask. You can specify any attributes names listed in the Service Directory
	 * under Network Dataset > Network Attributes as Usage Type: esriNAUTCost. You can also specify a value of none to
	 * indicate that no network attributes should be used for impedance. If you specify an empty string, it will use the
	 * default of the service.
	 * 
	 * For example, set impedanceAttribute=Time for quickest route and impedanceAttribute=Length for shortest drive.
	 * Assuming the service has those two esriNAUTCost attributes.
	 * 
	 * @return String
	 */
	public final native String getImpedanceAttribute() /*-{
		return this.impedanceAttribute;
	}-*/;
	
	/**
	 * Set the impedanceAttribute parameter.
	 * 
	 * @param impedanceAttribute - The network attribute name used as the impedence attribute in analysis.  The default
	 * is as defined in the specific routing network layer used in your RouteTask. You can specify any attributes names listed
	 * in the Service Directory under Network Dataset > Network Attributes as Usage Type: esriNAUTCost. You can also specify
	 * a value of none to indicate that no network attributes should be used for impedance. If you specify an empty string, it
	 * will use the default of the service.
	 * 
	 * For example, set impedanceAttribute=Time for quickest route and impedanceAttribute=Length for shortest drive. Assuming
	 * the service has those two esriNAUTCost attributes.
	 */
	public final native  void setImpedanceAttribute(String impedanceAttribute) /*-{
		this.impedanceAttribute = impedanceAttribute;
	}-*/;
	
	/**
	 * If true, similar ranges will be merged in the result polygons.
	 * 
	 * @return boolean
	 */
	public final native boolean mergeSimilarPolygonRanges() /*-{
		return this.mergeSimilarPolygonRanges;
	}-*/;
	
	/**
	 * Set the mergeSimilarPolygonRanges parameter.
	 * 
	 * @param mergeSimilarPolygonRanges - If true, similar ranges will be merged in the result polygons.
	 */
	public final native void setMergeSimilarPolygonRanges(boolean mergeSimilarPolygonRanges) /*-{
		this.mergeSimilarPolygonRanges = mergeSimilarPolygonRanges;
	}-*/;
	
	/**
	 * The precision of the output geometry after generalization. If 0, no generalization of output geometry
	 * is performed. If present and positive, it represents the MaximumAllowableOffset parameter - generalization
	 * is performed according to IPolycurve.Generalize.
	 * 
	 * @return int
	 */
	public native final int getOutputGeometryPrecision() /*-{
		return this.outputGeometryPrecision;
	}-*/;
	
	/**
	 * Set the outputGeometryPrecision parameter.
	 * 
	 * @param outputGeometryPrecision - The precision of the output geometry after generalization. If 0, no
	 * generalization of output geometry is performed. If present and positive, it represents the
	 * MaximumAllowableOffset parameter - generalization is performed according to IPolycurve.Generalize.
	 */
	public native final void setOutputGeometryPrecision(int outputGeometryPrecision) /*-{
		this.outputGeometryPrecision = outputGeometryPrecision;
	}-*/;
	
	/**
	 * The units of the output geometry precision. The default value is esriUnknownUnits.
	 * 
	 * Known values: esriUnknownUnits | esriCentimeters | esriDecimalDegrees | esriDecimeters | esriFeet | esriInches
	 * | esriKilometers | esriMeters | esriMiles | esriMillimeters | esriNauticalMiles | esriPoints | esriYards
	 * 
	 * @return String
	 */
	public native final String getOutputGeometryPrecisionUnits() /*-{
		return this.outputGeometryPrecisionUnits;
	}-*/;
	
	/**
	 * Set the outputGeometryPrecisionUnits parameter
	 * 
	 * @param outputGeometryPrecisionUnits - The units of the output geometry precision. The default value is esriUnknownUnits.
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
	 * The well-known ID of the spatial reference for the geometries returned with the analysis results. If outSpatialReference is not specified,
	 * the geometries are returned in the spatial reference of the map.
	 * 
	 * @return SpatialReference
	 */
	public native final SpatialReference getOutSpatialReference() /*-{
		return this.outSpatialReference;
	}-*/;
	
	/**
	 * Set the outSpatialReference parameter.
	 * 
	 * @param outSpatialReference - The well-known ID of the spatial reference for the geometries returned with the analysis results. If
	 * outSpatialReference is not specified, the geometries are returned in the spatial reference of the map.
	 */
	public native final void setOutSpatialReference(SpatialReference outSpatialReference) /*-{
		this.outSpatialReference = outSpatialReference;
	}-*/;
	
	/**
	 * Indicates if the lines should overlap from multiple facilities. The default is defined by the network analysis layer in your ServiceAreaTask.
	 * 
	 * @return boolean
	 */
	public native final boolean overlapLines() /*-{
		return this.overlapLines;
	}-*/;
	
	/**
	 * Set the overlapLines parameter.
	 * 
	 * @param overlapLines - Indicates if the lines should overlap from multiple facilities. The default is defined by the network analysis layer
	 * in your ServiceAreaTask.
	 */
	public native final void setOverlapLines(boolean overlapLines) /*-{
		this.overlapLines = overlapLines;
	}-*/;
	
	/**
	 * Indicates if the polygons should overlap from multiple facilities. The default is defined by the network analysis layer in your ServiceAreaTask.
	 * 
	 * @return boolean
	 */
	public native final boolean overlapPolygons() /*-{
		return this.overlapPolygons;
	}-*/;
	
	/**
	 * Set the overlapPolygons parameter.
	 * 
	 * @param overlapPolygons - Indicates if the polygons should overlap from multiple facilities. The default is defined by the network analysis
	 * layer in your ServiceAreaTask.
	 */
	public final native void setOverlapPolygons(boolean overlapPolygons) /*-{
		this.overlapPolygons = overlapPolygons;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPointBarriersAsDataLayer() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * The set of point barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPointBarriersAsFeatureSet() /*-{
		return this.pointBarriers;
	}-*/;
	
	/**
	 * Set the pointBarriers parameter.
	 * 
	 * @param pointBarriers - The set of point barriers loaded as network locations during analysis. 
	 * or esri.tasks.FeatureSet.
	 */
	public final native void setPointBarriers(DataLayer pointBarriers) /*-{
		this.pointBarriers = pointBarriers;
	}-*/;
	
	/**
	 * Set the pointBarriers parameter.
	 * 
	 * @param pointBarriers - The set of point barriers loaded as network locations during analysis. 
	 * or esri.tasks.FeatureSet.
	 */
	public final native void setPointBarriers(FeatureSet pointBarriers) /*-{
		this.pointBarriers = pointBarriers;
	}-*/;

	/**
	 * The set of polygons barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolygonBarriersAsDataLayer() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * The set of polygons barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPolygonBarriersAsFeaturSet() /*-{
		return this.polygonBarriers;
	}-*/;
	
	/**
	 * Set the polygonBarriers parameter.
	 * 
	 * @param polygonBarriers - The set of polygons barriers loaded as network locations during analysis.
	 * or esri.tasks.FeatureSet.
	 */
	public final native void setPolygonBarriers(DataLayer polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;
	
	/**
	 * Set the polygonBarriers parameter.
	 * 
	 * @param polygonBarriers - The set of polygons barriers loaded as network locations during analysis.
	 * or esri.tasks.FeatureSet.
	 */
	public final native void setPolygonBarriers(FeatureSet polygonBarriers) /*-{
		this.polygonBarriers = polygonBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return DataLayer
	 */
	public final native DataLayer getPolylineBarriersAsDataLayer() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * The set of polyline barriers loaded as network locations during analysis. Can be either an instance of esri.tasks.DataLayer or esri.tasks.FeatureSet.
	 * 
	 * @return FeatureSet
	 */
	public final native FeatureSet getPolylineBarriersAsFeatureSet() /*-{
		return this.polylineBarriers;
	}-*/;
	
	/**
	 * Set the polylineBarriers parameter.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis.
	 */
	public final native void setPolylineBarriers(DataLayer polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * Set the polylineBarriers parameter.
	 * 
	 * @param polylineBarriers - The set of polyline barriers loaded as network locations during analysis.
	 */
	public final native void setPolylineBarriers(FeatureSet polylineBarriers) /*-{
		this.polylineBarriers = polylineBarriers;
	}-*/;
	
	/**
	 * The list of network attribute names to be used as restrictions with the analysis. The default is as defined in the
	 * specific routing network layer used in your RouteTask. Possible values are listed in the Service Directory under
	 * Network Dataset > Network Attributes. You can also specify a value of none to indicate that no network
	 * attributes should be used as restrictions. If you specify an empty array, it will default to the default of the service.
	 * 
	 * @return JsArrayString
	 */
	public native final JsArrayString getRestrictionAttributes() /*-{
		return this.restrictionAttributes;
	}-*/;
	
	/**
	 * Set the restrictionAttributes parameters.
	 * 
	 * @param restrictionAttributes - The list of network attribute names to be used as restrictions with the analysis.
	 * The default is as defined in the specific routing network layer used in your RouteTask. Possible values are listed
	 * in the Service Directory under Network Dataset > Network Attributes. You can also specify a value of none to
	 * indicate that no network attributes should be used as restrictions. If you specify an empty array, it will default
	 * to the default of the service.
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
	 * Set the restrictUTurns parameter.
	 * 
	 * @param restrictUTurns - Specifies how U-Turns should be handled. The default is as defined in the specific routing network
	 * layer used in your RouteTask.
	 */
	public final void setRestrictUTurns(NAUTurn restrictUTurns) {
		_setRestrictUTurns( restrictUTurns.getValue() );
	}
	
	private final native void _setRestrictUTurns(String restrictUTurns) /*-{
		this.restrictUTurns = restrictUTurns;
	}-*/;
	
	/**
	 * If true, facilities will be returned with the analysis results. Default value is false.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnFacilities() /*-{
		return this.returnFacilities;
	}-*/;
	
	/**
	 * Set the returnFacilities parameter.
	 * 
	 * @param returnFacilities - If true, facilities will be returned with the analysis results. Default value is false.
	 */
	public native final void setReturnFacilities(boolean returnFacilities) /*-{
		this.returnFacilities = returnFacilities;
	}-*/;
	
	/**
	 * If true, barriers will be returned in the barriers property of ClosestFacilitySolveResult. The default value is false.
	 * 
	 * @return boolean
	 */
	public native final boolean getReturnPointBarriers() /*-{
		return this.returnPointBarriers;
	}-*/;
	
	/**
	 * Set the returnPointBarriers parameter.
	 * 
	 * @param returnPointBarriers - If true, barriers will be returned in the barriers property of ClosestFacilitySolveResult. The default value is false.
	 */
	public native final void setReturnPointBarriers(boolean returnPointBarriers) /*-{
		this.returnPointBarriers = returnPointBarriers;
	}-*/;
	
	/**
	 * If true, polygon barriers will be returned in the polygonBarriers property of ClosestFacilitySolveResult. The default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean returnPolygonBarriers() /*-{
		return this.returnPolygonBarriers;
	}-*/;
	
	/**
	 * Set the returnPolygonBarriers parameter.
	 * 
	 * @param returnPolygonBarriers - If true, polygon barriers will be returned in the polygonBarriers property of ClosestFacilitySolveResult. The default value is false.
	 */
	public final native void setReturnPolygonBarriers(boolean returnPolygonBarriers) /*-{
		this.returnPolygonBarriers = returnPolygonBarriers;
	}-*/;
	
	/**
	 * If true, polyline barriers will be returned in the polylineBarriers property of ClosestFacilitySolveResult. The default value is false.
	 * 
	 * @return boolean
	 */
	public final native boolean getReturnPolylineBarriers() /*-{
		return this.returnPolylineBarriers;
	}-*/;
	
	/**
	 * Set the returnPolylineBarriers parameter.
	 * 
	 * @param returnPolylineBarriers - If true, polyline barriers will be returned in the polylineBarriers property of ClosestFacilitySolveResult. The default value is false.
	 */
	public final native void setReturnPolylineBarriers(boolean returnPolylineBarriers) /*-{
		this.returnPolylineBarriers = returnPolylineBarriers;
	}-*/;
	
	/**
	 * If true, lines will be split at breaks.
	 * 
	 * @return boolean
	 */
	public final native boolean splitLinesAtBreaks() /*-{
		return this.splitLinesAtBreaks;
	}-*/;
	
	/**
	 * Set the splitLinesAtBreaks parameter.
	 * 
	 * @param splitLinesAtBreaks - If true, lines will be split at breaks.
	 */
	public final native void setSplitLinesAtBreaks(boolean splitLinesAtBreaks) /*-{
		this.splitLinesAtBreaks = splitLinesAtBreaks;
	}-*/;

	/**
	 * If true, polygons will be split at breaks.
	 * 
	 * @return boolean
	 */
	public final native boolean splitPolygonsAtBreaks() /*-{
		return this.splitPolygonsAtBreaks;
	}-*/;
	
	/**
	 * Set the splitPolygonsAtBreaks parameter.
	 * 
	 * @param splitPolygonsAtBreaks - If true, polygons will be split at breaks.
	 */
	public final native void setSplitPolygonsAtBreaks(boolean splitPolygonsAtBreaks) /*-{
		this.splitPolygonsAtBreaks = splitPolygonsAtBreaks;
	}-*/;
	
	/**
	 * Local date and time at the facility. if travelDirection set to TO_FACILITY, timeOfDay value specifies 
	 * arrival time at the facility. if travelDirection set to FROM_FACILITY, timeOfDay specifies departure 
	 * time from the facility. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 * 
	 * @return JsDate
	 */
	public final native JsDate getTimeOfDay() /*-{
		return this.timeOfDay;
	}-*/;
	
	/**
	 * Set the timeOfDay parameter.
	 * 
	 * @param timeOfDay - Local date and time at the facility. if travelDirection set to TO_FACILITY, timeOfDay 
	 * value specifies arrival time at the facility. if travelDirection set to FROM_FACILITY, timeOfDay specifies 
	 * departure time from the facility. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 */
	public final native void setTimeOfDay(JsDate timeOfDay) /*-{
		this.timeOfDay = timeOfDay;
	}-*/;
	
	/**
	 * Options for traveling to or from the facility. Default values are defined by the newtork layer.
	 * 
	 * @return NATravelDirection
	 */
	public final NATravelDirection getTravelDirection() {
		String td = _getTravelDirection();
		for( int i = 0 ; i < NATravelDirection.values().length; i++ ){
			if( NATravelDirection.values()[i].getValue().contentEquals(td) )
				return NATravelDirection.values()[i];
		}
		return NATravelDirection.NOT_SET;
	}
	
	private final native String _getTravelDirection() /*-{
		return this.travelDirection;
	}-*/;
	
	/**
	 * Set the travelDirection parameter.
	 * 
	 * @param travelDirection - Options for traveling to or from the facility. Default values are defined by the newtork layer.
	 */
	public final void setTravelDirection(NATravelDirection travelDirection) {
		_setTravelDirection( travelDirection.getValue() );
	}
	
	private final native void _setTravelDirection(String travelDirection) /*-{
		this.travelDirection = travelDirection;
	}-*/;
	
	/**
	 * If true, the outermost polygon (at the maximum break value) will be trimmed. The default is defined in the network analysis layer in your ServiceAreaTask.
	 * 
	 * @return boolean
	 */
	public final native boolean trimOuterPolygon() /*-{
		return this.trimOuterPolygon;
	}-*/;
	
	/**
	 * Set the trimOuterPolygon parameter.
	 * 
	 * @param trimOuterPolygon - If true, the outermost polygon (at the maximum break value) will be trimmed. The default is defined in the network analysis
	 * layer in your ServiceAreaTask.
	 */
	public final native void setTrimOuterPolygon(boolean trimOuterPolygon) /*-{
		this.trimOuterPolygon = trimOuterPolygon;
	}-*/;
	
	/**
	 * If polygons are being trimmed, provides the distance to trim. The default is defined in the network analysis layer.
	 * 
	 * @return boolean
	 */
	public final native boolean trimPolygonDistance() /*-{
		return this.trimPolygonDistance;
	}-*/;

	
	public final native void setTrimPolygonDistance(boolean trimPolygonDistance) /*-{
		this.trimPolygonDistance = PolygonDistance;
	}-*/;
	
	/**
	 * If polygons are being trimmed, specifies the units of the trimPolygonDistance. The default is defined in the network analysis layer.
	 * 
	 * @return Units
	 */
	public final Units getTrimPolygonDistanceUnits() {
		String tpdu = _getTrimPolygonDistanceUnits();
		for( int i = 0 ; i < Units.values().length; i++ ){
			if( Units.values()[i].getValue().contentEquals(tpdu) )
				return Units.values()[i];
		}
		return Units.NOT_SET;
	}
	
	private final native String _getTrimPolygonDistanceUnits() /*-{
		return this.trimPolygonDistanceUnits;
	}-*/;
	
	/**
	 * Set the trimPolygonDistanceUnits parameter.
	 * 
	 * @param trimPolygonDistanceUnits - If polygons are being trimmed, specifies the units of the trimPolygonDistance. The default is defined
	 * in the network analysis layer.
	 */
	public final void setTrimPolygonDistanceUnits(Units trimPolygonDistanceUnits) {
		_setTrimPolygonDistanceUnits( trimPolygonDistanceUnits.getValue() );
	}
	
	private final native void _setTrimPolygonDistanceUnits(String trimPolygonDistanceUnits) /*-{
		this.trimPolygonDistanceUnits = trimPolygonDistanceUnits;
	}-*/;
	
	/**
	 * When true, the hierarchy attributes for the network will be used in analysis. The default value is defined in the network layer. useHierarchy 
	 * cannot be used in conjunction with outputLines. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 * 
	 * @return boolean
	 */
	public final native boolean getUseHierarchy() /*-{
		return this.userHierarchy;
	}-*/;
	
	/**
	 * Set the userHierarchy parameter.
	 * 
	 * @param userHierarchy -When true, the hierarchy attributes for the network will be used in analysis. The default value is defined in the network 
	 * layer. useHierarchy cannot be used in conjunction with outputLines. Requires ArcGIS Server service version 10.1 or greater. (As of v2.6)
	 */
	public final native void setUseHierarchy(boolean userHierarchy) /*-{
		this.userHierarchy = userHierarchy;
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
