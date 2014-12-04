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
public class Cut extends OperationBase {	
	
	protected Cut() {}

	/**
	 * Create a new Cut operation. Cut is a combination of the Add and Update operations.
	 * 
	 * @param addedGraphics - The feature(s) added to the feature layer by the cut operation.
	 * @param featureLayer - The feature layer that contains the cut feature(s).
	 * @param postUpdatedGraphics - The updated feature(s).
	 * @param preUpdatedGraphics - The feature(s) before the cut operation is performed.
	 * @return Cut
	 */
	public static Cut create(Graphic[] addedGraphics, FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(addedGraphics, featureLayer, postUpdatedGraphics, preUpdatedGraphics);
	}
	
	private static native Cut _create(Graphic[] addedGraphics, FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) /*-{
		return $wnd.esri.dijit.editing.editOperation.Cut({
			addedGraphics: addedGraphics,
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
