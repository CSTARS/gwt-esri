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
public class Add extends OperationBase {
	
	protected Add() {}
	
	/**
	 * Create a new Add operation.
	 * 
	 * @param addedGraphics - The features that were added to the feature layer.
	 * @param featureLayer - The feature layer where the new feature(s) are added.
	 * @return Add
	 */
	public static Add create(Graphic[]  addedGraphics, FeatureLayer featureLayer) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(addedGraphics, featureLayer);
	}
	
	private static native Add _create(Graphic[]  addedGraphics, FeatureLayer featureLayer) /*-{
		return $wnd.esri.dijit.editing.editOperation.Add({
			featureLayer: featureLayer,
			addedGraphics: addedGraphics
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
