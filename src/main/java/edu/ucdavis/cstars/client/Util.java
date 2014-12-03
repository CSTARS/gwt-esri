package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Util {
	
	public enum Package {
		ESRI_ARCGIS_UTILS("esri.arcgis.utils"),
		ESRI_IDENTITYMANAGER("esri.IdentityManager"),
		ESRI_INFOWINDOWBASE("esri.InfoWindowBase"),
		ESRI_DIJIT_ATTACHMENTEDITOR("esri.dijit.AttachmentEditor"),
		ESRI_DIJIT_ATTRIBUTEINSPECTOR("esri.dijit.AttributeInspector-all"),
		ESRI_DIJIT_BASEMAPGALLERY("esri.dijit.BasemapGallery"),
		ESRI_DIJIT_EDITING_EDITOPERATION("esri.dijit.editing.editOperation"),
		ESRI_DIJIT_LEGEND("esri.dijit.Legend"),
		ESRI_DIJIT_OVERVIEWMAP("esri.dijit.OverviewMap"),
		ESRI_DIJIT_SCALEBAR("esri.dijit.Scalebar"),
		ESRI_DIJIT_TEMPLATEPICKER("esri.dijit.editing.TemplatePicker-all"),
		ESRI_DIJIT_TIMESLIDER("esri.dijit.TimeSlider"),
		ESRI_LAYERS_FEATURELAYER("esri.layers.FeatureLayer"),
		ESRI_LAYERS_KMLLAYER("esri.layers.KMLLayer"),
		ESRI_LAYERS_MAPIMAGELAYER("esri.layers.MapImageLayer"),
		ESRI_LAYERS_OSM("esri.layers.osm"),
		ESRI_LAYERS_WMSLAYER("esri.layers.wms"),
		ESRI_LAYERS_WMTSLAYER("esri.layers.wmts"),
		ESRI_TASKS_CLOSESTFACILITY("esri.tasks.closestfacility"),
		ESRI_TASKS_GENERATERENDERERTASK("esri.tasks.GenerateRendererTask"),
		ESRI_TASKS_IMAGESERVICEIDENTIFY("esri.tasks.imageserviceidentify"),
		ESRI_TASKS_PRINTTASK("esri.tasks.PrintTask"),
		ESRI_TASKS_SERVICEAREA("esri.tasks.servicearea"),
		ESRI_TOOLBARS_DRAW("esri.toolbars.draw"),
		ESRI_TOOLBARS_EDIT("esri.toolbars.edit"),
		ESRI_UNDOMANAGER("esri.undoManager"),
		ESRI_VIRTUALEARTH_VEGEOCODER("esri.virtualearth.VEGeocoder"),
		ESRI_VIRTUALEARTH_VETILEDLAYER("esri.virtualearth.VETiledLayer");
		
		private String name;
		Package(String n){
			name = n;
		}
		public String getName() {
			return name;
		}
	}
	
	public static native void addObjectToArray(JavaScriptObject object, JavaScriptObject array) /*-{
		array.push(object);
	}-*/;
	
	public static JavaScriptObject objectArrayToJSO(JavaScriptObject[] objects) {
		if( objects == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < objects.length; i++ ) addObjectToArray(objects[i], arr);
		return arr;
	}
	
	public static native void addIntToArray(int val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject intArrayToJSO(int[] ints) {
		if( ints == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < ints.length; i++ ) addIntToArray(ints[i], arr);
		return arr;
	}
	
	public static native void addDoubleToArray(double val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject doubleArrayToJSO(double[] doubles) {
		if( doubles == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < doubles.length; i++ ) addDoubleToArray(doubles[i], arr);
		return arr;
	}
	
	public static native void addStringToArray(String val, JavaScriptObject array) /*-{
		array.push(val);
	}-*/;
	
	public static JavaScriptObject stringArrayToJSO(String[] strings) {
		if( strings == null ) return null;
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < strings.length; i++ ) addStringToArray(strings[i], arr);
		return arr;
	}
	
	/**
	 * @deprecated use AddEsriLoadHandler
	 */
	@Deprecated
	public static void loadEsriApi(Runnable onLoadCallback) {
		addEsriLoadHandler(onLoadCallback);
	}
	
	public static void addEsriLoadHandler(Runnable handler) {
		_addEsriLoadHandler(handler);
	}
	
	private static native void _addEsriLoadHandler(Runnable handler) /*-{
		$wnd.dojo.require("esri.map");
		$wnd.dojo.addOnLoad(
			function() {
				handler.@java.lang.Runnable::run()();
			}
		);
	}-*/;
	
	public static void addRequiredPackage(Package p) {
		_addRequiredPackage(p.getName());
	};
	
	private static native void _addRequiredPackage(String name) /*-{
		$wnd.dojo.require(name);
	}-*/;

	public static native void debugObject(String name, JavaScriptObject jso) /*-{
		if( !$wnd["__gwt_esri_debug"] ) $wnd["__gwt_esri_debug"] = {};
		$wnd.__gwt_esri_debug[name] = jso;
	}-*/;
	
}
