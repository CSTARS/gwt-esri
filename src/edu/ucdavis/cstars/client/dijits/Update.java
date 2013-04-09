package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.OperationBase;
import edu.ucdavis.cstars.client.layers.FeatureLayer;

/**
 * The esri.dijit.editing namespace contains editing related opertions that inherit from OperationBase. 
 * These operations are used with the UndoManager to provide undo/redo functionality.
 * 
 * @author Justin Merz
 */
public class Update extends OperationBase {	
	
	protected Update() {}

	/**
	 * Create a new Update operation.
	 * 
	 * @param featureLayer - The feature layer that contains the updated feature(s).
	 * @param postUpdatedGraphics - The feature layer that contains the updated feature(s).
	 * @param preUpdatedGraphics - The feature(s) prior to the update.
	 * @return Update
	 */
	public static Update create(FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(featureLayer, postUpdatedGraphics, preUpdatedGraphics);
	}
	
	private static native Update _create(FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) /*-{
		return $wnd.esri.dijit.editing.editOperation.Update({
			featureLayer: featureLayer,
			preUpdatedGraphics: preUpdatedGraphics,
			postUpdatedGraphics: postUpdatedGraphics
		});
	}-*/;
	
	/**
	 * Check that the esri.dijit.editing.editOperation has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.editing.editOperation ) return true;
		$wnd.alert("The ESRI_DIJIT_EDITING_EDITOPERATION package has not been loaded");
		return false;
	}-*/;

}
