package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.layers.FeatureLayer;

/**
 * The Editor widget provides out-of-the-box editing capabilities using an editable layer in a Feature Service. It
 * combines the out-of-the-box TemplatePicker, AttachmentEditor, AttributeInspector and GeometryService to
 * provide feature and attribute editing. When building editing applications, try to take advantage of the
 * customizable out-of-the-box Editor widget when possible.
 * 
 * @author Justin Merz
 */
public class Editor extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	protected JavaScriptObject jso;
	
	public enum CreateTools {
		CREATE_TOOL_ARROW("arrow"),
		CREATE_TOOL_AUTOCOMPLETE("autocomplete"),
		CREATE_TOOL_CIRCLE("circle"),
		CREATE_TOOL_ELLIPSE("ellipse"),
		CREATE_TOOL_FREEHAND_POLYGON("freehandpolygon"),
		CREATE_TOOL_FREEHAND_POLYLINE("freehandpolyline"),
		CREATE_TOOL_POLYGON("polygon"),
		CREATE_TOOL_POLYLINE("polyline"),
		CREATE_TOOL_RECTANGLE("rectangle"),
		CREATE_TOOL_TRIANGLE("triangle");
		
		private String val = "";
		private CreateTools(String value) {
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	
	/**
	 * Creates a new Editor object.
	 * 
	 * @param params - Parameters that define the functionality of the editor widget. Create a
	 * new settings object to pass to the widget
	 */
	public Editor(Parameters params) {
		
		if( !assertLoaded() ) return; 
		
		parameters = params;
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( jso == null ) jso = create(parameters);
			}
		});
		
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.Editor(params, this.@edu.ucdavis.cstars.client.dijits.Editor::getElement()());
	}-*/;
	
	/**
	 * Check that the esri.dijit.Editor package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.Editor ) return true;
		$wnd.alert("The ESRI_DIJIT_EDITOR has not been loaded");
		return false;
	}-*/;
	
	
	/**
	 * 
	 */
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		/**
		 * Create a new settings object that defines the cababilites of the widget.
		 * 
		 * @return Parameters
		 */
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * Reference to the map.
		 * 
		 * @param map
		 */
		public final void setMap(MapWidget map) {
			_setMap(map.getMapObject());
		}
		
		private final native void _setMap(JavaScriptObject map) /*-{
			this["map"] = map;
		}-*/;
		
		/**
		 * Use this option if you want to modify the appearance of the template picker, for example
		 * set the number of rows and columns.
		 * 
		 * @param templatePicker - Reference to the TemplatePicker.
		 */
		public final native void setTemplatePicker(TemplatePicker templatePicker) /*-{
			this["templatePicker"] = templatePicker;
		}-*/;
		
		/**
		 * Reference to the geometry service.
		 * 
		 * @param geometryService
		 */
		public final native void setGeometryService(String geometryService) /*-{
			this["geometryService"] = geometryService;
		}-*/;
		
		/**
		 * If true display the editing toolbar.
		 * 
		 * @param isVisible
		 */
		public final native void setToolbarVisible(boolean isVisible) /*-{
			this["toolbarVisible"] = isVisible;
		}-*/;
		
		/**
		 * 
		 * @param polylineDrawTool - Specify the polyline draw tools to include on the toolbar.
		 * Only applicable when toolbarVisible is true.
		 */
		public final void addPolylineDrawTool(CreateTools polylineDrawTool){ 
			_addPolylineDrawTool(polylineDrawTool.getValue());
		}
		
		private final native void _addPolylineDrawTool(String polylineDrawTool) /*-{
			if( !this.polylineDrawTools ) this["polylineDrawTools"] = [];
			this.polylineDrawTools.push( polylineDrawTool );
		}-*/;
		
		/**
		 * 
		 * @param polygonDrawTool - Specify the polygon draw tools to include on the toolbar.
		 * Only applicable when toolbarVisible is true.
		 */
		public final void addPolygonDrawTool(CreateTools polygonDrawTool) {
			_addPolygonDrawTool(polygonDrawTool.getValue());
		};
		
		private final native void _addPolygonDrawTool(String polygonDrawTool) /*-{
			if( !this.polygonDrawTools ) this["polygonDrawTools"] = [];
			this.polygonDrawTools.push( polygonDrawTool );
		}-*/;
	
		/**
		 * Specify the tools to include on the toolbar. Only applicable when toolbarVisible is true.
		 * 
		 * @param mergeVisible - If true show the merge tool.
		 * @param cutVisible - If true show the cut tool.
		 * @param reshapeVisible - If true show the reshape tool.
		 */
		public final native void setToolbarOptions(boolean mergeVisible, boolean cutVisible, boolean reshapeVisible) /*-{
			this["toolbarOptions"] = {}
			this.toolbarOptions["mergeVisible"] = mergeVisible;
			this.toolbarOptions["cutVisible"] = cutVisible;
			this.toolbarOptions["reshapeVisible"] = reshapeVisible;
		}-*/;
		
		/**
		 * Feature layer information
		 * 
		 * @param featureLayer - Reference to the feature layer.
		 * @param showObjectID - Default is false. When true display the ObjectID field in the attribute inspector.
		 * @param showGlobalID - Default is false. When true display the GlobalID field in the attribute inspector.
		 * @param htmlFields - Specify which fields to display as a rich text editor.
		 */
		public final void setLayerInfos(FeatureLayer featureLayer, boolean showObjectID, 
				boolean showGlobalID, String[] htmlFields ) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < htmlFields.length; i++ ) Util.addStringToArray(htmlFields[i], arr);
			_setLayerInfos(featureLayer, showObjectID, showGlobalID, arr);
		};
		
		private final native void _setLayerInfos(FeatureLayer featureLayer, boolean showObjectID,
				boolean showGlobalID, JavaScriptObject htmlFields ) /*-{
			this["layerInfos"] = {};
			this.layerInfos["featureLayer"] = featureLayer;
			this.layerInfos["showObjectID"] = showObjectID;
			this.layerInfos["showGlobalID"] = showGlobalID;
			this.layerInfos["htmlFields"] = htmlFields;	
		}-*/;
		
	}
	
}
