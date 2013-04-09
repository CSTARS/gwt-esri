package edu.ucdavis.cstars.client.tasks;


import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.callback.AreasAndLengthsCallback;
import edu.ucdavis.cstars.client.callback.AutoCompleteCallback;
import edu.ucdavis.cstars.client.callback.BufferCallback;
import edu.ucdavis.cstars.client.callback.ConvexHullCallback;
import edu.ucdavis.cstars.client.callback.CutCallback;
import edu.ucdavis.cstars.client.callback.DifferenceCallback;
import edu.ucdavis.cstars.client.callback.DistanceCallback;
import edu.ucdavis.cstars.client.callback.GeneralizeCallback;
import edu.ucdavis.cstars.client.callback.IntersectCallback;
import edu.ucdavis.cstars.client.callback.LabelPointsCallback;
import edu.ucdavis.cstars.client.callback.LengthsCallback;
import edu.ucdavis.cstars.client.callback.OffsetCallback;
import edu.ucdavis.cstars.client.callback.ProjectCallback;
import edu.ucdavis.cstars.client.callback.RelationCallback;
import edu.ucdavis.cstars.client.callback.ReshapeCallback;
import edu.ucdavis.cstars.client.callback.SimplifyCallback;
import edu.ucdavis.cstars.client.callback.TrimExtendCallback;
import edu.ucdavis.cstars.client.callback.UnionCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.AreasAndLengthsHandler;
import edu.ucdavis.cstars.client.event.AutoCompleteHandler;
import edu.ucdavis.cstars.client.event.BufferHandler;
import edu.ucdavis.cstars.client.event.ConvexHullHandler;
import edu.ucdavis.cstars.client.event.CutHandler;
import edu.ucdavis.cstars.client.event.DifferenceHandler;
import edu.ucdavis.cstars.client.event.DistanceHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.GeneralizeHandler;
import edu.ucdavis.cstars.client.event.IntersectHandler;
import edu.ucdavis.cstars.client.event.LabelPointsHandler;
import edu.ucdavis.cstars.client.event.LengthsHandler;
import edu.ucdavis.cstars.client.event.OffsetHandler;
import edu.ucdavis.cstars.client.event.ProjectHandler;
import edu.ucdavis.cstars.client.event.RelationHandler;
import edu.ucdavis.cstars.client.event.ReshapeHandler;
import edu.ucdavis.cstars.client.event.SimplifyHandler;
import edu.ucdavis.cstars.client.event.TrimExtendHandler;
import edu.ucdavis.cstars.client.event.UnionHandler;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.geometry.Polygon;
import edu.ucdavis.cstars.client.geometry.Polyline;

/**
 * Represents a geometry service resource exposed by the ArcGIS Server REST API. It is used to perform various operations 
 * on geometries such as project, simplify, buffer, and relationships.
 * 
 * It is recommended that you create a geometry service for use within your applications. View the Geometry Services help 
 * topic in the Server Resource Center for details on creating and publishing a geometry service. ESRI hosts a geometry 
 * service on sampleserver3 to support samples published in the Resource Center. You are welcome to use this service for 
 * development and testing purposes. ESRI also hosts a geometry service on tasks.arcgisonline.com; this service can be 
 * used for production applications however, we do not guarantee that the service will be available 24/7.
 * 
 * @author Justin Merz
 */
public class GeometryService extends JavaScriptObject {
	
	public enum UnitType {
		NOT_SET(""),
		UNIT_150KILOMETER_LENGTH("109031"),
		UNIT_50KILOMETER_LENGTH("109030"),
		UNIT_ACRES	("esriAcres"),
		UNIT_ARCMINUTE("9103"),
		UNIT_ARCMINUTE_CENTESIMAL("9112"),
		UNIT_ARCSECOND("9104"),
		UNIT_ARCSECOND_CENTESIMAL("9113"),
		UNIT_ARES("esriAres"),
		UNIT_BENOIT_1895A_CHAIN("9052"),
		UNIT_BENOIT_1895A_FOOT("9051"),
		UNIT_BENOIT_1895A_LINK("9053"),
		UNIT_BENOIT_1895A_YARD("9050"),
		UNIT_BENOIT_1895B_CHAIN("9062"),
		UNIT_BENOIT_1895B_FOOT("9061"),
		UNIT_BENOIT_1895B_LINK("9063"),
		UNIT_BENOIT_1895B_YARD("9060"),
		UNIT_BRITISH_1936_FOOT("9095"),
		UNIT_CENTIMETER("109006"),
		UNIT_CLARKE_CHAIN("9038"),
		UNIT_CLARKE_FOOT("9005"),
		UNIT_CLARKE_LINK("9039"),
		UNIT_CLARKE_YARD("9037"),
		UNIT_DECIMETER("109005"),
		UNIT_DEGREE("9102"),
		UNIT_FATHOM("9014"),
		UNIT_FOOT("9002"),
		UNIT_FOOT_1865("9070"),
		UNIT_GERMAN_METER("9031"),
		UNIT_GOLDCOAST_FOOT("9094"),
		UNIT_GON("9106"),
		UNIT_GRAD("9105"),
		UNIT_HECTARES("esriHectares"),
		UNIT_INDIAN_1937_FOOT("9081"),
		UNIT_INDIAN_1937_YARD("9085"),
		UNIT_INDIAN_1962_FOOT("9082"),
		UNIT_INDIAN_1962_YARD("9086"),
		UNIT_INDIAN_1975_FOOT("9083"),
		UNIT_INDIAN_1975_YARD("9087"),
		UNIT_INDIAN_FOOT("9080"),
		UNIT_INDIAN_YARD("9084"),
		UNIT_INTERNATIONAL_CHAIN("109003"),
		UNIT_INTERNATIONAL_INCH("109008"),
		UNIT_INTERNATIONAL_LINK("109004"),
		UNIT_INTERNATIONAL_ROD("109010"),
		UNIT_INTERNATIONAL_YARD("109001"),
		UNIT_KILOMETER("9036"),
		UNIT_METER("9001"),
		UNIT_MICRORADIAN("9109"),
		UNIT_MIL6400("9114"),
		UNIT_MILLIMETER("109007"),
		UNIT_NAUTICAL_MILE("9030"),
		UNIT_RADIAN("9103"),
		UNIT_SEARS_CHAIN("9042"),
		UNIT_SEARS_FOOT("9041"),
		UNIT_SEARS_LINK("9043"),
		UNIT_SEARS_YARD("9040"),
		UNIT_SQUARE_CENTIMETERS("esriSquareCentimeters"),
		UNIT_SQUARE_DECIMETERS("esriSquareDecimeters"),
		UNIT_SQUARE_FEET("esriSquareFeet"),
		UNIT_SQUARE_INCHES("esriSquareInches"),
		UNIT_SQUARE_KILOMETERS("esriSquareKilometers"),
		UNIT_SQUARE_METERS("esriSquareMeters"),
		UNIT_SQUARE_MILES("esriSquareMiles"),
		UNIT_SQUARE_MILLIMETERS("esriSquareMillimeters"),
		UNIT_SQUARE_YARDS("esriSquareYards"),
		UNIT_STATUTE_MILE("9093"),
		UNIT_SURVEY_CHAIN("9033"),
		UNIT_SURVEY_FOOT("9003"),
		UNIT_SURVEY_LINK("9034"),
		UNIT_SURVEY_MILE("9035"),
		UNIT_SURVEY_YARD("109002"),
		UNIT_UK_NAUTICAL_MILE("109013"),
		UNIT_US_NAUTICAL_MILE("109012"),
		UNIT_US_SURVEY_INCH("109009"),
		UNIT_US_SURVEY_ROD("109011");
		
		private String val = "";
		UnitType(String value) {
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected GeometryService() {}
	
	/**
	 * Creates a new GeometryService object.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a geometry service.
	 * @return GeometryService
	 */
	public static native GeometryService create(String url) /*-{
		return new $wnd.esri.tasks.GeometryService(url);
	}-*/;

	/**
	 * URL to the ArcGIS Server REST resource that represents a locator service. 
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Computes the area and length for the input polygons.
	 * 
	 * @param param - Specify the input polygons and optionally the linear and areal units.
	 * @param callback - The function to call when the method has completed
	 * @return Deferred
	 */
	public final native Deferred areasAndLengths(AreasAndLengthsParameters param, AreasAndLengthsCallback callback) /*-{		
		return this.areasAndLengths(param, 
			function(results) {
				callback.@edu.ucdavis.cstars.client.callback.AreasAndLengthsCallback::onAreasAndLengthsComplete(Ledu/ucdavis/cstars/client/event/AreasAndLengthsHandler$AreasAndLengths;)(results);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.AreasAndLengthsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Computes the area and length for the input polygons.
	 * 
	 * @param param - Specify the input polygons and optionally the linear and areal units.
	 * @return Deferred
	 */
	public final native Deferred areasAndLengths(AreasAndLengthsParameters param) /*-{
		return this.areasAndLengths(param);
	}-*/;
	
	/**
	 * The Auto Complete operation is performed on a geometry service resource. The AutoComplete operation simplifies the process of constructing
	 * new polygons that are adjacent to other polygons. It constructs polygons that fill in the gaps between existing polygons and a set of polylines.
	 * 
	 * @param polygons - The array of polygons that will provide some boundaries for new polygons.
	 * @param polylines - An array of polylines that will provide the remaining boundaries for new polygons.
	 * @param callback - The function to call when the method has completed. 
	 * @return Deferred
	 */
	public final Deferred autoComplete(Polygon[] polygons, Polyline[] polylines, AutoCompleteCallback callback) {
		return _autoComplete(Util.objectArrayToJSO(polygons), Util.objectArrayToJSO(polylines), callback);
	}
	
	private final native Deferred _autoComplete(JavaScriptObject polygons, JavaScriptObject polylines, AutoCompleteCallback callback) /*-{		
		return this.autoComplete(polygons, polylines, 
			function(polygons) {
				callback.@edu.ucdavis.cstars.client.callback.AutoCompleteCallback::onAutoCompleteComplete(Lcom/google/gwt/core/client/JsArray;)(polygons);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.AutoCompleteCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The Auto Complete operation is performed on a geometry service resource. The AutoComplete operation simplifies the process of constructing
	 * new polygons that are adjacent to other polygons. It constructs polygons that fill in the gaps between existing polygons and a set of polylines.
	 * 
	 * @param polygons - The array of polygons that will provide some boundaries for new polygons.
	 * @param polylines - An array of polylines that will provide the remaining boundaries for new polygons.
	 * @return Deferred
	 */
	public final Deferred autoComplete(Polygon[] polygons, Polyline[] polylines) {
		return _autoComplete(Util.objectArrayToJSO(polygons), Util.objectArrayToJSO(polylines));
	}
	
	private final native Deferred _autoComplete(JavaScriptObject polygons, JavaScriptObject polylines) /*-{		
		return this.autoComplete(polygons, polylines);
	}-*/;
	
	/**
	 * Creates buffer polygons at a specified distance around the given geometries. On completion, the onBufferComplete event is fired and the optional
	 * callback function is invoked. Both the callback and event handlers receive an array of Geometry that contains the buffer polygons.
	 * 
	 * @param params - Specifies the input geometries, buffer distances, and other options.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred buffer(BufferParameters params, BufferCallback callback) /*-{	
		return this.buffer(params, 
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.BufferCallback::onBufferComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.BufferCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Creates buffer polygons at a specified distance around the given geometries. On completion, the onBufferComplete event is fired and the optional
	 * callback function is invoked. Both the callback and event handlers receive an array of Geometry that contains the buffer polygons.
	 * 
	 * @param params - Specifies the input geometries, buffer distances, and other options.
	 * @return Deferred
	 */
	public final native Deferred buffer(BufferParameters params) /*-{
		return this.buffer(params);
	}-*/;

	/**
	 * The convexHull operation is performed on a geometry service resource. It returns the convex hull of the input geometry. The input geometry can
	 * be a point, multipoint, polyline or polygon. The hull is typically a polygon but can also be a polyline or point in degenerate cases.
	 * 
	 * @param geometries - The geometries whose convex hull is to be created.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred convexHull(Geometry[] geometries, ConvexHullCallback callback) {
		return _convexHull(Util.objectArrayToJSO(geometries), callback);
	}
	
	private final native Deferred _convexHull(JavaScriptObject geometries, ConvexHullCallback callback) /*-{		
		return this.convexHull(geometries, 
			function(geometry) {
				callback.@edu.ucdavis.cstars.client.callback.ConvexHullCallback::onConvexHullComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ConvexHullCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The convexHull operation is performed on a geometry service resource. It returns the convex hull of the input geometry. The input geometry can
	 * be a point, multipoint, polyline or polygon. The hull is typically a polygon but can also be a polyline or point in degenerate cases.
	 * 
	 * @param geometries - The geometries whose convex hull is to be created.
	 * @return Deferred
	 */
	public final Deferred convexHull(Geometry[] geometries) {
		return _convexHull(Util.objectArrayToJSO(geometries));
	}
	
	private final native Deferred _convexHull(JavaScriptObject geometries) /*-{		
		return this.convexHull(geometries);
	}-*/;
	
	/**
	 * The cut operation is performed on a geometry service resource. This operation splits the input polyline or polygon where it crosses a cutting polyline. 
	 * 
	 * @param targetGeometry - The polyline or polygon to be cut.
	 * @param cutterGeometry - The polyline that will be used to divide the target into pieces where it crosses the target.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred cut(Geometry[] targetGeometry, Geometry cutterGeometry, CutCallback callback) {
		return _cut(Util.objectArrayToJSO(targetGeometry), cutterGeometry, callback);
	}
	
	private final native Deferred _cut(JavaScriptObject targetGeometry, Geometry cutterGeometry, CutCallback callback) /*-{		
		return this.cut(targetGeometry, cutterGeometry, 
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.CutCallback::onCutComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.CutCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;

	/**
	 * The cut operation is performed on a geometry service resource. This operation splits the input polyline or polygon where it crosses a cutting polyline. 
	 * 
	 * @param targetGeometry - The polyline or polygon to be cut.
	 * @param cutterGeometry - The polyline that will be used to divide the target into pieces where it crosses the target.
	 * @return Deferred
	 */
	public final Deferred cut(Geometry[] targetGeometry, Geometry cutterGeometry) {
		return _cut(Util.objectArrayToJSO(targetGeometry), cutterGeometry);
	}
	
	private final native Deferred _cut(JavaScriptObject targetGeometry, Geometry cutterGeometry) /*-{		
		return this.cut(targetGeometry, cutterGeometry);
	}-*/;
	
	/**
	 * The difference operation is performed on a geometry service resource. This operation constructs the set-theoretic difference
	 * between an array of geometries and another geometry.
	 * 
	 * @param geometries - An array of points, multipoints, polylines or polygons.
	 * @param geometry - A single geometry of any type, of dimension equal to or greater than the elements of geometries.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred difference(Geometry[] geometries, Geometry geometry, DifferenceCallback callback) {
		return _difference(Util.objectArrayToJSO(geometries), geometry, callback);
	}
	
	private final native Deferred _difference(JavaScriptObject geometries, Geometry geometry, DifferenceCallback callback) /*-{		
		return this.difference(geometries, geometry, 
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.DifferenceCallback::onDifferenceComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.DifferenceCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The difference operation is performed on a geometry service resource. This operation constructs the set-theoretic difference
	 * between an array of geometries and another geometry.
	 * 
	 * @param geometries - An array of points, multipoints, polylines or polygons.
	 * @param geometry - A single geometry of any type, of dimension equal to or greater than the elements of geometries.
	 * @return Deferred
	 */
	public final Deferred difference(Geometry[] geometries, Geometry geometry) {
		return _difference(Util.objectArrayToJSO(geometries), geometry);
	}
	
	private final native Deferred _difference(JavaScriptObject geometries, Geometry geometry) /*-{		
		return this.difference(geometries, geometry);
	}-*/;
	
	/**
	 * Measures the planar or geodesic distance between geometries. 
	 * 
	 * @param params - Sets the input geometries to measure, distance units and other parameters.
	 * @param callback - The function to call when the method has completed. 
	 * @return - Deferred
	 */
	public final native Deferred distance(DistanceParameters params, DistanceCallback callback) /*-{
		return this.distance(distance, 
			function(distance) {
				callback.@edu.ucdavis.cstars.client.callback.DistanceCallback::onDistanceComplete(F)(distance);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.DistanceCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Measures the planar or geodesic distance between geometries. 
	 * 
	 * @param params - Sets the input geometries to measure, distance units and other parameters.
	 * @return - Deferred
	 */
	public final native Deferred distance(DistanceParameters params) /*-{
		return this.distance(distance);
	}-*/;
	
	/**
	 * Generalizes the input geomtries using the Douglas-Peucker algorithim.
	 * 
	 * @param params - An array of geometries to generalize and a maximum deviation.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred generalize(GeneralizeParameters params, GeneralizeCallback callback) /*-{		
		return this.generalize(params, 
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.GeneralizeCallback::onGeneralizeComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.GeneralizeCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Generalizes the input geomtries using the Douglas-Peucker algorithim.
	 * 
	 * @param params - An array of geometries to generalize and a maximum deviation.
	 * @return Deferred
	 */
	public final native Deferred generalize(GeneralizeParameters params) /*-{		
		return this.generalize(params);
	}-*/;
	
	/**
	 * The intersect operation is performed on a geometry service resource. This operation constructs the set-theoretic intersection
	 * between an array of geometries and another geometry.
	 * 
	 * @param geometries - An array of points, multipoints, polylines or polygons.
	 * @param geometry -  single geometry of any type, of dimension equal to or greater than the elements of geometries.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred intersect(Geometry[] geometries, Geometry geometry, IntersectCallback callback) {
		return _intersect(Util.objectArrayToJSO(geometries), geometry, callback);
	}
	
	private final native Deferred _intersect(JavaScriptObject geometries, Geometry geometry, IntersectCallback callback) /*-{		
		return this.intersect(geometries, geometry, 
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.IntersectCallback::onIntersectComplete(Lcom/google/gwt/core/client/JsArray;)(intersect);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.IntersectCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The intersect operation is performed on a geometry service resource. This operation constructs the set-theoretic intersection
	 * between an array of geometries and another geometry.
	 * 
	 * @param geometries - An array of points, multipoints, polylines or polygons.
	 * @param geometry -  single geometry of any type, of dimension equal to or greater than the elements of geometries.
	 * @return Deferred
	 */
	public final Deferred intersect(Geometry[] geometries, Geometry geometry) {
		return _intersect(Util.objectArrayToJSO(geometries), geometry);
	}
	
	private final native Deferred _intersect(JavaScriptObject geometries, Geometry geometry) /*-{		
		return this.intersect(geometries, geometry);
	}-*/;
	
	/**
	 * Calculates an interior point for each polygon specified. These interior points can be used by clients for labeling the polygons.
	 * 
	 * @param polygons - The graphics to process.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred labelPoints(Geometry[] polygons, LabelPointsCallback callback) {
		return _labelPoints(Util.objectArrayToJSO(polygons), callback);
	}
	
	private final native Deferred _labelPoints(JavaScriptObject polygons, LabelPointsCallback callback) /*-{		
		return this.labelPoints(polygons, 
			function(labelPoints) {
				callback.@edu.ucdavis.cstars.client.callback.LabelPointsCallback::onLabelPointsComplete(Lcom/google/gwt/core/client/JsArray;)(labelPoints);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.LabelPointsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Calculates an interior point for each polygon specified. These interior points can be used by clients for labeling the polygons.
	 * 
	 * @param polygons - The graphics to process.
	 * @return Deferred
	 */
	public final Deferred labelPoints(Geometry[] polygons) {
		return _labelPoints(Util.objectArrayToJSO(polygons));
	}
	
	private final native Deferred _labelPoints(JavaScriptObject polygons) /*-{
		return this.labelPoints(polygons);
	}-*/;
	
	/**
	 * Gets the lengths for a Geometry[] when the geometry type is Polyline.
	 * 
	 * @param params - Specify the polylines and optionally the length unit and the geodesic length option.
	 * @param callback - The function to call when the method has completed. 
	 * @return Deferred
	 */
	public final native Deferred lengths(LengthsParameters params, LengthsCallback callback) /*-{		
		return this.lengths(params, 
			function(lengths) {
				callback.@edu.ucdavis.cstars.client.callback.LengthsCallback::onLengthsComplete(Ledu/ucdavis/cstars/client/event/LengthsHandler$Lengths;)(lengths);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.LengthsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Gets the lengths for a Geometry[] when the geometry type is Polyline.
	 * 
	 * @param params - Specify the polylines and optionally the length unit and the geodesic length option.
	 * @return Deferred
	 */
	public final native Deferred lengths(LengthsParameters params) /*-{
		return this.lengths(params);
	}-*/;

	/**
	 * Constructs the offset of the input geometries. If the offsetDistance is positive the constructed offset will be on the right side of the geometry. Left
	 * side offsets are constructed with negative values.
	 * 
	 * @param params - Set the geometries to offset, distance and units.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred offset(OffsetParameters params, OffsetCallback callback) /*-{
		return this.offset(params,
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.OffsetCallback::onOffsetComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.OffsetCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Constructs the offset of the input geometries. If the offsetDistance is positive the constructed offset will be on the right side of the geometry. Left
	 * side offsets are constructed with negative values.
	 * 
	 * @param params - Set the geometries to offset, distance and units.
	 * @return Deferred
	 */
	public final native Deferred offset(OffsetParameters params) /*-{
		return this.offset(params);
	}-*/;
	
	/**
	 * Projects a set of geometries into a new spatial reference. On completion, the onProjectComplete event is fired and the optional callback function is
	 * invoked. Both the callback and event handlers receive an array of Geometry[] that contains the projected geometries.
	 * 
	 * @param geometries - The geometries to project.
	 * @param outSspatialReference - The well-known ID of a spatial reference. 
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred project(Geometry[] geometries, SpatialReference outSspatialReference, ProjectCallback callback) {
		return _project(Util.objectArrayToJSO(geometries), outSspatialReference, callback);
	}
	
	private final native Deferred _project(JavaScriptObject geometries, SpatialReference outSspatialReference, ProjectCallback callback) /*-{		
		return this.project(geometries, outSspatialReference,
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.ProjectCallback::onProjectComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ProjectCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Projects a set of geometries into a new spatial reference. On completion, the onProjectComplete event is fired and the optional callback function is
	 * invoked. Both the callback and event handlers receive an array of Geometry[] that contains the projected geometries.
	 * 
	 * @param geometries - The geometries to project.
	 * @param outSspatialReference - The well-known ID of a spatial reference. 
	 * @return Deferred
	 */
	public final Deferred project(Geometry[] geometries, SpatialReference outSspatialReference) {
		return _project(Util.objectArrayToJSO(geometries), outSspatialReference);
	}
	
	private final native Deferred _project(JavaScriptObject geometries, SpatialReference outSspatialReference) /*-{		
		return this.project(geometries, outSspatialReference);
	}-*/;
	
	/**
	 * Computes the set of pairs of geometries from the input geometry arrays that belong to the specified relation. Both arrays
	 * are assumed to be in the same spatial reference. The relations are evaluated in 2D. Z coordinates are not used. Geometry
	 * types cannot be mixed within an array.
	 * 
	 * @param params - The set of parameters required to perform the comparison.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred relation(RelationParameters params, RelationCallback callback) /*-{		
		return this.relation(params,
			function(relationships) {
				callback.@edu.ucdavis.cstars.client.callback.RelationCallback::onRelationComplete(Lcom/google/gwt/core/client/JsArray;)(relationships);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.RelationCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Computes the set of pairs of geometries from the input geometry arrays that belong to the specified relation. Both arrays are
	 * assumed to be in the same spatial reference. The relations are evaluated in 2D. Z coordinates are not used. Geometry types
	 * cannot be mixed within an array.
	 * 
	 * @param params - The set of parameters required to perform the comparison.
	 * @return Deferred
	 */
	public final native Deferred relation(RelationParameters params) /*-{		
		return this.relation(params);
	}-*/;
	
	/**
	 * The reshape operation is performed on a geometry service resource. It reshapes a polyline or a part of a polygon using a reshaping line. 
	 * 
	 * @param targetGeometry - The polyline or polygon to be reshaped.
	 * @param reshaperGeometry - The single-part polyline that does the reshaping.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred reshape(Geometry targetGeometry, Geometry reshaperGeometry, ReshapeCallback callback) /*-{		
		return this.reshape(targetGeometry, reshaperGeometry, 
			function(geometry) {
				callback.@edu.ucdavis.cstars.client.callback.ReshapeCallback::onReshapeComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ReshapeCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The reshape operation is performed on a geometry service resource. It reshapes a polyline or a part of a polygon using a reshaping line. 
	 * 
	 * @param targetGeometry - The polyline or polygon to be reshaped.
	 * @param reshaperGeometry - The single-part polyline that does the reshaping.
	 * @return Deferred
	 */
	public final native Deferred reshape(Geometry targetGeometry, Geometry reshaperGeometry) /*-{		
		return this.reshape(targetGeometry, reshaperGeometry);
	}-*/;
	
	/**
	 * Alters the given geometries to make their definitions topologically legal with respect to their geometry type. On completion,
	 * the onSimplifyComplete event is fired and the optional callback function is invoked. Both the callback and event handlers
	 * receive an array of Geometry that contains the simplified geometries.
	 * 
	 * @param geometries - The geometries to simplify.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred simplify(Geometry[] geometries, SimplifyCallback callback) {
		return _simplify(Util.objectArrayToJSO(geometries), callback);
	}
	
	private final native Deferred _simplify(JavaScriptObject geometries, SimplifyCallback callback) /*-{		
		return this.simplify(geometries,
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.SimplifyCallback::onSimplifyComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.SimplifyCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Alters the given geometries to make their definitions topologically legal with respect to their geometry type. On completion,
	 * the onSimplifyComplete event is fired and the optional callback function is invoked. Both the callback and event handlers
	 * receive an array of Geometry that contains the simplified geometries.
	 * 
	 * @param geometries - The geometries to simplify.
	 * @return Deferred
	 */
	public final Deferred simplify(Geometry[] geometries) {
		return _simplify(Util.objectArrayToJSO(geometries));
	}
	
	private final native Deferred _simplify(JavaScriptObject geometries) /*-{		
		return this.simplify(geometries);
	}-*/;
	
	/**
	 * Trims or extends the input polylines using the user specified guide polyline. When trimming features, the portion to the left
	 * of the cutting line is preserved in the output and the rest is discarded. If the input polyline is not cut or extended then an empty
	 * polyline is added to the output array.
	 * 
	 * @param params - Input parameters for the trimExtend operation.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred trimExtend(TrimExtendParameters params, TrimExtendCallback callback) /*-{		
		return this.trimExtend(params,
			function(geometries) {
				callback.@edu.ucdavis.cstars.client.callback.TrimExtendCallback::onTrimExtendComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.TrimExtendCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Trims or extends the input polylines using the user specified guide polyline. When trimming features, the portion to the left
	 * of the cutting line is preserved in the output and the rest is discarded. If the input polyline is not cut or extended then an empty
	 * polyline is added to the output array.
	 * 
	 * @param params - Input parameters for the trimExtend operation.
	 * @return Deferred
	 */
	public final native Deferred trimExtend(TrimExtendParameters params) /*-{		
		return this.trimExtend(params);
	}-*/;
	
	/**
	 * The union operation is performed on a geometry service resource. This operation constructs the set-theoretic union of the
	 * geometries in the input array. All inputs must be of the same type. 
	 * 
	 * @param geometries - The array of geometries to be unioned.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final Deferred union(Geometry[] geometries, UnionCallback callback) {
		return _union(Util.objectArrayToJSO(geometries), callback);
	}
	
	private final native Deferred _union(JavaScriptObject geometries, UnionCallback callback) /*-{		
		return this.union(geometries,
			function(geometry) {
				callback.@edu.ucdavis.cstars.client.callback.UnionCallback::onUnionComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.UnionCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * The union operation is performed on a geometry service resource. This operation constructs the set-theoretic union of the
	 * geometries in the input array. All inputs must be of the same type. 
	 * 
	 * @param geometries - The array of geometries to be unioned.
	 * @return Deferred
	 */
	public final Deferred union(Geometry[] geometries) {
		return _union(Util.objectArrayToJSO(geometries));
	}
	
	private final native Deferred _union(JavaScriptObject geometries) /*-{		
		return this.union(geometries);
	}-*/;
	
	/**
	 * Add event handler for areasAndLengths
	 * 
	 * @param handler - Fires when the areasAndLengths operation is complete. 
	 */
	public final native void addAreasAndLengthsHandler(AreasAndLengthsHandler handler) /*-{
		$wnd.dojo.connect(this, "onAreasAndLengthsComplete",
			function(areasAndLengths) {
				handler.@edu.ucdavis.cstars.client.event.AreasAndLengthsHandler::onAreasAndLengthsComplete(Ledu/ucdavis/cstars/client/event/AreasAndLengthsHandler$AreasAndLengths;)(areasAndLengths);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for autoComplete
	 * 
	 * @param handler - Fires when the autoComplete operation is complete.
	 */
	public final native void addAutoCompleteHandler(AutoCompleteHandler handler) /*-{
			$wnd.dojo.connect(this, "onAutoCompleteComplete",
				function(polygons) {
					handler.@edu.ucdavis.cstars.client.event.AutoCompleteHandler::onAutoCompleteComplete(Lcom/google/gwt/core/client/JsArray;)(polygons);
				}
			);	
	}-*/;
	
	/**
	 * Add event handler for buffer.
	 * 
	 * @param handler - Fires when the buffer operation is complete.
	 */
	public final native void addBufferHandler(BufferHandler handler) /*-{
		$wnd.dojo.connect(this, "onBufferComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.BufferHandler::onBufferComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for convexHull
	 * 
	 * @param handler - Fires when the convexHull operation is complete.
	 */
	public final native void addConvexHullHandler(ConvexHullHandler handler) /*-{
		$wnd.dojo.connect(this, "onConvexHullComplete",
			function(geometry) {
				handler.@edu.ucdavis.cstars.client.event.ConvexHullHandler::onConvexHullComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for cut.
	 * 
	 * @param handler - Fires when the cut operation is complete.
	 */
	public final native void addCutHandler(CutHandler handler) /*-{
		$wnd.dojo.connect(this, "onCutComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.CutHandler::onCutComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for difference.
	 * 
	 * @param handler - Fires when the difference operation is complete. 
	 */
	public final native void addDifferenceHandler(DifferenceHandler handler) /*-{
		$wnd.dojo.connect(this, "onDifferenceComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.DifferenceHandler::onDifferenceComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for distance.
	 * 
	 * @param handler - Fires when the difference operation is complete.
	 */
	public final native void addDistanceHandler(DistanceHandler handler) /*-{
		$wnd.dojo.connect(this, "onDistanceComplete",
			function(distance) {
				handler.@edu.ucdavis.cstars.client.event.DistanceHandler::onDistanceComplete(F)(distance);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for errors.
	 * 
	 * @param handler - Fires when an error occurs when executing the task. 
	 */
	public final native void addErrorHandler(ErrorHandler handler) /*-{
		$wnd.dojo.connect(this, "onError",
			function(error) {
				handler.@edu.ucdavis.cstars.client.event.ErrorHandler::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for generalize.
	 * 
	 * @param handler - Fires when the generalize operation is complete.
	 */
	public final native void addGeneralizeHandler(GeneralizeHandler handler) /*-{
		$wnd.dojo.connect(this, "onGeneralizeComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.GeneralizeHandler::onGeneralizeComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for intersect.
	 * 
	 * @param handler - Fires when the intersect operation is complete.
	 */
	public final native void addIntersectHandler(IntersectHandler handler) /*-{
		$wnd.dojo.connect(this, "onIntersectComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.IntersectHandler::onIntersectComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for labelPoints.
	 * 
	 * @param handler - Fires when the labelPoints operation is complete.
	 */
	public final native void addLabelPointsHandler(LabelPointsHandler handler) /*-{
		$wnd.dojo.connect(this, "onLabelPointsComplete",
			function(labelPoints) {
				handler.@edu.ucdavis.cstars.client.event.LabelPointsHandler::onLabelPointsComplete(Lcom/google/gwt/core/client/JsArray;)(labelPoints);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for lengths.
	 * 
	 * @param handler - Fires when the lengths operation is complete. 
	 */
	public final native void addLengthsHandler(LengthsHandler handler) /*-{
		$wnd.dojo.connect(this, "onLengthsComplete",
			function(lengths) {
				handler.@edu.ucdavis.cstars.client.event.LengthsHandler::onLengthsComplete(Ledu/ucdavis/cstars/client/event/LengthsHandler$Lengths;)(lengths);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for offset.
	 * 
	 * @param handler - Fires when the offset operation is complete.
	 */
	public final native void addOffsetHandler(OffsetHandler handler) /*-{
		$wnd.dojo.connect(this, "onOffsetComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.OffsetHandler::onOffsetComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for project.
	 * 
	 * @param handler - Fires when the project operation is complete.
	 */
	public final native void addProjectHandler(ProjectHandler handler) /*-{
		$wnd.dojo.connect(this, "onProjectComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.ProjectHandler::onProjectComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for relation.
	 * 
	 * @param handler - Fires when the relation operation is complete. 
	 */
	public final native void addRelationHandler(RelationHandler handler) /*-{
		$wnd.dojo.connect(this, "onRelationComplete",
			function(relationships) {
				handler.@edu.ucdavis.cstars.client.event.RelationHandler::onRelationComplete(Lcom/google/gwt/core/client/JsArray;)(relationships);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for reshape.
	 * 
	 * @param handler - Fires when the reshape operation is complete.
	 */
	public final native void addReshapeHandler(ReshapeHandler handler) /*-{
		$wnd.dojo.connect(this, "onReshapeComplete",
			function(geometry) {
				handler.@edu.ucdavis.cstars.client.event.ReshapeHandler::onReshapeComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for simplify
	 * 
	 * @param handler - Fires when the trimExtend operation is complete.
	 */
	public final native void addSimplifyHandler(SimplifyHandler handler) /*-{
		$wnd.dojo.connect(this, "onSimplifyComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.SimplifyHandler::onSimplifyComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for trimExtend.
	 * 
	 * @param handler - Fires when the trimExtend operation is complete.
	 */
	public final native void addTrimExtendHandler(TrimExtendHandler handler) /*-{
		$wnd.dojo.connect(this, "onTrimExtendComplete",
			function(geometries) {
				handler.@edu.ucdavis.cstars.client.event.TrimExtendHandler::onTrimExtendComplete(Lcom/google/gwt/core/client/JsArray;)(geometries);
			}
		);	
	}-*/;
	
	/**
	 * Add event handler for union.
	 * 
	 * @param handler - Fires when the union operation is complete.
	 */
	public final native void addUnionHandler(UnionHandler handler) /*-{
		$wnd.dojo.connect(this, "onUnionComplete",
			function(geometry) {
				handler.@edu.ucdavis.cstars.client.event.UnionHandler::onUnionComplete(Ledu/ucdavis/cstars/client/geometry/Geometry;)(geometry);
			}
		);	
	}-*/;

	
}
