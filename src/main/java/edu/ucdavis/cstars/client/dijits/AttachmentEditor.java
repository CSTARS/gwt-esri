package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.layers.FeatureLayer;

/**
 * Widget that supports viewing attachments for feature layers that have attachments enabled. If the feature
 * layers are from a feature service then the attachment editor will include the ability to create, view and delete
 * attachments.
 * 
 * @author Justin Merz
 */
public class AttachmentEditor extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	protected JavaScriptObject jso = null;

	/**
	 * Creates a new AttachmentEditor Widget.
	 */
	public  AttachmentEditor() {
		
		if( !assertLoaded() ) return; 
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( jso == null ) jso = create();
			}
		});
		
	}
	
	/**
	 * Check that the esri.dijit.AttachmentEditor has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.AttachmentEditor ) return true;
		$wnd.alert("The ESRI_DIJIT_ATTACHMENTEDITOR package has not been loaded");
		return false;
	}-*/;
	
	private native JavaScriptObject create() /*-{
		return new $wnd.esri.dijit.AttachmentEditor({}, this.@edu.ucdavis.cstars.client.dijits.AttachmentEditor::panel.getElement()());
	}-*/;
	
	/**
	 * Display the attachment editor.
	 * 
	 * @param graphic - Graphic, with attachments, to display in the attachment editor.
	 * @param featureLayer - The feature layer to display attachments for. The feature layer must have attachments enabled.
	 */
	public native void showAttachments(Graphic graphic, FeatureLayer featureLayer) /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttachmentEditor::jso.showAttachements(graphic, featureLayer);
	}-*/;
	
	/**
	 * Finalizes the creation of the attachment editor. Call startup() after creating the widget when you are ready for user interaction.
	 */
	public native void startup() /*-{
		this.@edu.ucdavis.cstars.client.dijits.AttachmentEditor::jso.startup();
	}-*/;
	
}
