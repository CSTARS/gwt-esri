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
public class Union extends OperationBase {	
	
	protected Union() {}

	/**
	 * Create a new Union operation. Union is a combination of the Delete and Update operations.
	 * 
	 * @param deletedGraphics - The feature(s) removed from the feature layer by the union operation.
	 * @param featureLayer - The feature layer that contains the unioned feature(s).
	 * @param postUpdatedGraphics - The updated feature(s).
	 * @param preUpdatedGraphics - The feature(s) before the union operation is performed.
	 * @return Union
	 */
	public static Union create(Graphic[] deletedGraphics, FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(deletedGraphics, featureLayer, postUpdatedGraphics, preUpdatedGraphics);
	}
	
	private static native Union _create(Graphic[] deletedGraphics, FeatureLayer featureLayer, Graphic[] postUpdatedGraphics, Graphic[] preUpdatedGraphics) /*-{
		return $wnd.esri.dijit.editing.editOperation.Union({
			deletedGraphics: deletedGraphics,
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
