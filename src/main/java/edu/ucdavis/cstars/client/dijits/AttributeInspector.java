package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.AttributeChangeHandler;
import edu.ucdavis.cstars.client.event.DeleteFeatureHandler;
import edu.ucdavis.cstars.client.event.NextFeatureHandler;
import edu.ucdavis.cstars.client.layers.FeatureLayer;

/**
 * The attribute inspector displays the attributes of selected features from one or more feature layers. If the layer is editable,
 * the feature attributes will be editable. The AttributeInspector widget honors the domains and subtypes as defined by the
 * Feature Service. The widget is used by the Editor widget, but can also be used directly in both editing and "show attributes"
 * scenarios. While commonly put into an InfoWindow, you can also put it into other containers, for example outside of the
 * map or without using a map.
 * 
 * If the feature layer supports attachments, attachments will be visible in the attribute inspector. If the feature layers are from
 * a feature service then attribute inspector will include the ability to create, view and delete attachments.
 * 
 * @author Justin Merz
 */
public class AttributeInspector extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	protected JavaScriptObject jso = null;;
	
	/**
	 * Creates a new Attribute Inspector object.
	 * 
	 * @param params - input parameters
	 */
	public  AttributeInspector(Parameters params) {
		
		if( !assertLoaded() ) return; 
		
		parameters = params;
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if(jso == null ) jso = create(parameters);
			}
		});
		
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.AttributeEditor(params, this.@edu.ucdavis.cstars.client.dijits.AttachmentEditor::panel.getElement()());
	}-*/;
	
	/**
	 * Check that the esri.dijits.AttributeInspector package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.AttributeInspector ) return true;
		$wnd.alert("The ESRI_DIJIT_ATTRIBUTEINSPECTOR has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Destroys the widget, used for page clean up.
	 */
	public void destroy() {
		_destroy();
		if( isAttached() ) removeFromParent();
	}
	
	private final native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.destroy();
	}-*/;
	
	/**
	 * Moves to the first feature.
	 */
	public final native void first() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.first();
	}-*/;
	
	/**
	 * Moves to the last feature.
	 */
	public final native void last() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.last();
	}-*/;
	
	/**
	 * Move to the next feature.
	 */
	public final native void next() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.next();
	}-*/;
	
	/**
	 * Move to the previous feature.
	 */
	public final native void previous() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.previous();
	}-*/;
	
	/**
	 * Updates the contents of the AttributeInspector.
	 */
	public final native void refresh() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso.refresh();
	}-*/;
	
	// NOTE: because this interacts with other components I am leaving dojo as the primary event handler on this.
	/**
	 * Fires when a fields value changes. When used outside of the Editor widget it is up to the developer to update the feature's attributes.
	 * 
	 * @param handler - handler to fire when attribute changes
	 */
	public final native void addAttributeChangeHandler( AttributeChangeHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso,
		 	"onAttributeChange",
		 	function(feature, fieldName, newFieldValue) {
		 		handler.@edu.ucdavis.cstars.client.event.AttributeChangeHandler::onAttributeChange(Ledu/ucdavis/cstars/client/Graphic;Ljava/lang/String;Ljava/lang/String;)(feature, fieldName, newFieldValue);
			}
		);
	}-*/;
	
	/**
	 * Fires when the AttributeInspector's delete button is pressed. When used outside of the Editor widget it is up to the developer
	 * to delete the feature from the feature service.
	 * 
	 * @param handler
	 */
	public final native void addDeleteHandler( DeleteFeatureHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso,
		 	"onDelete",
		 	function(feature) {
		 		handler.@edu.ucdavis.cstars.client.event.DeleteFeatureHandler::onDelete(Ledu/ucdavis/cstars/client/Graphic;)(feature);
			}
		);
	}-*/;
	
	/**
	 * Fires when the AttributeInspector's next or back button is pressed. Corresponds to the feature currently displayed in the AttributeInspector
	 * 
	 * @param handler
	 */
	public final native void addNextHandler( NextFeatureHandler handler ) /*-{
		 $wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.AttributeInspector::jso,
		 	"onNext",
		 	function(feature) {
		 		handler.@edu.ucdavis.cstars.client.event.NextFeatureHandler::onNext(Ledu/ucdavis/cstars/client/Graphic;)(feature);
			}
		);
	}-*/;
	
	/**
	 * Input parameters for AttributeInspector
	 */
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		public static native Parameters create() /*-{
			return { layerInfos: [] };
		}-*/;
		
		/**
		 * 
		 * @param layerInfo - layer info to add to parameters
		 */
		public final native void addLayerInfo(LayerInfo layerInfo) /*-{
			this.layerInfos.push( layerInfo );
		}-*/;
		
	}
	
	public static class LayerInfo extends JavaScriptObject {
		
		protected LayerInfo() {};
		
		public static LayerInfo create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * 
		 * @param featureLayer - Feature layer. Required.
		 */
		public final native void setFeatureLayer(FeatureLayer featureLayer) /*-{
			this["featureLayer"] = featureLayer;
		}-*/;
		
		/**
		 * 
		 * @param showId - Show the ObjectID field.Optional.
		 */
		public final native void showObjectID(boolean showId) /*-{
			this["showObjectID"] = showId;
		}-*/;
		
		/**
		 * 
		 * @param showId - Show the GlobalID field. Optional
		 */
		public final native void showGlobalID(boolean showId) /*-{
			this["showGlobalID"] = showId;
		}-*/;
		
		/**
		 * 
		 * @param showButton - Display the delete button on the attribute inspector dialog. Optional
		 */
		public final native void showDeleteButton( boolean showButton) /*-{
			this["showDeleteButton"] = showButton;
		}-*/;
		
		/**
		 * 
		 * @param htmlFields - Display a rich text editor for the specified fields.
		 */
		public final void setHtmlFields(String[] htmlFields) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < htmlFields.length; i++ ) Util.addStringToArray(htmlFields[i], arr);
			_setHtmlFields(arr);
		}
		
		private final native void _setHtmlFields(JavaScriptObject array) /*-{
			this["htmlFields"] = array;
		}-*/;
	}

}
