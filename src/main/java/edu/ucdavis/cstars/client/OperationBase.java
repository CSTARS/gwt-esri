package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.event.RedoHandler;
import edu.ucdavis.cstars.client.event.UndoHandler;

/**
 * The OperationBase class defines operations that can be added to the UndoManager. Extend this class to create custom operations.
 * 
 * @author Justin Merz
 */
public class OperationBase extends JavaScriptObject {

	protected OperationBase() {}
	
	/**
	 * Creates a new OperationBase object.
	 * 
	 * @return OperationBase
	 */
	public static OperationBase create() {
		OperationBase ob = _create();
		ob.init();
		return ob;
	}
	
	private static native OperationBase _create() /*-{
		return new $wnd.esri.OperationBase();
	}-*/;
	
	/**
	 * Creates a new OperationBase object.
	 * 
	 * @param label - Details about the operation
	 * @param type - The type of operation
	 * @return OperationBase
	 */
	public static OperationBase create(String label, String type) {
		OperationBase ob = _create(label, type);
		ob.init();
		return ob;
	}
	
	private static native OperationBase _create(String label, String type) /*-{
		return new $wnd.esri.OperationBase(label, type);
	}-*/;
	
	private native void init() /*-{
		this.preformRedo = function() {};
		this.preformUndo = function() {};
	}-*/;
	
	/**
	 * Details about the operation, for example: "Update" may be the label for an edit operation that updates features.
	 * 
	 * @param label - operation label
	 */
	public final native void setLabel(String label) /*-{
		this.label = label;
	}-*/;
	
	/**
	 * Get the label for this operation.
	 * 
	 * @return String
	 */
	public final native String getLabel() /*-{
		return this.label;
	}-*/;

	/**
	 * The type of operation, for example: "edit" or "navigation".
	 * 
	 * @param type - operation type.
	 */
	public final native void setType(String type) /*-{
		this.type = type;
	}-*/;
	
	/**
	 * Get the type of this operation
	 * 
	 * @return String
	 */
	public final native String getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Re-perform the last undo operation.
	 */
	public final native void performRedo() /*-{
		this.preformRedo();
	}-*/;
	
	public final native void setRedoAction(RedoHandler handler) /*-{
		this.performRedo = function() {
			handler.@edu.ucdavis.cstars.client.event.RedoHandler::onRedo();
		};
	}-*/;
	
	/**
	 * Reverse the operation.
	 */
	public final native void performUndo() /*-{
		this.performUndo();
	}-*/;
	
	public final native void setUndoAction(UndoHandler handler) /*-{
		this.performUndo = function() {
			handler.@edu.ucdavis.cstars.client.event.UndoHandler::onUndo();
		};
	}-*/;
	
}
