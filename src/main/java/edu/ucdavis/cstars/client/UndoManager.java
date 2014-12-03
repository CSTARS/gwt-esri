package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.event.UndoManagerAddHandler;
import edu.ucdavis.cstars.client.event.UndoManagerChangeHandler;
import edu.ucdavis.cstars.client.event.UndoManagerRedoHandler;
import edu.ucdavis.cstars.client.event.UndoManagerUndoHandler;

/**
 * The Undo Manager is a utility object that allows you to easily build applications with undo/redo functionality. Use the 
 * Undo Manager to add operations (edits, navigation changes, graphics drawing) to the stack. The API includes a set of 
 * edit operations (add,delete,update, cut and union), created by inherting from the OperationBase class. You can inherit 
 * from the OperationBase class to create custom operations that take advantage of undo/redo.
 * 
 * @author Justin Merz
 */
public class UndoManager extends JavaScriptObject {
	
	protected UndoManager() {}
	
	/**
	 * Creates a new UndoManager object.
	 * 
	 * @param options
	 * 
	 * @return UndoManager
	 */
	public static UndoManager create(Options options) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(options);
	}
	
	private static native UndoManager _create(Options options) /*-{
		return $wnd.esri.UndoManager(options);
	}-*/;
	
	/**
	 * Check that the esri.undoManager has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.undoManager ) return true;
		$wnd.alert("The ESRI_UNDOMANAGER package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * When true, there are redo operations available on the stack.
	 * 
	 * @return boolean
	 */
	public final native boolean canRedo() /*-{
		return this.canRedo;
	}-*/;
	
	/**
	 * When true, there are undo operations available on the stack
	 * 
	 * @return boolean
	 */
	public final native boolean canUndo() /*-{
		return this.canUndo;
	}-*/;
	
	/**
	 * The number of operations stored in the history stack.
	 * 
	 * @return int
	 */
	public final native int getLength() /*-{
		return this.length;
	}-*/;
	
	/**
	 * The current operation position. A position value of 0 means that no operations are available on the stack. 
	 * When an undo operation is performed the position decreases by 1. When a redo occurs the position is incremented by 1.
	 * 
	 * @return int
	 */
	public final native int position() /*-{
		return this.position;
	}-*/;
	
	/**
	 * Adds an undo operation to the stack and clears the redo stack.
	 * 
	 * @param operation - operation to add.
	 */
	public final native void add(OperationBase operation) /*-{
		this.add(operation);
	}-*/;
	
	/**
	 * clear the redo stack
	 */
	public final native void clearRedo() /*-{
		this.clearRedo();
	}-*/;
	
	/**
	 * clear the undo stack
	 */
	public final native void clearUndo() /*-{
		this.clearUndo();
	}-*/;
	
	/**
	 * Destroy the operation manager. Sets the history stack to null and cleans up all references.
	 */
	public final native void destroy() /*-{
		this.destroy();
	}-*/;
	
	/**
	 * Get the specified operation from the stack.
	 * 
	 * @param operationId - the operation id.
	 * @return OperationBase
	 */
	public final native OperationBase get(int operationId) /*-{
		return this.get(operationId);
	}-*/;
	
	/**
	 * Get the next redo operation from the stack
	 * 
	 * @return OperationBase
	 */
	public final native OperationBase peekRedo() /*-{
		return this.peekRedo();
	}-*/;
	
	/**
	 * Get the next undo operation from the stack.
	 * 
	 * @return OperationBase
	 */
	public final native OperationBase peekUndo() /*-{
		return this.peekUndo();
	}-*/;
	
	/**
	 * Moves the current position to the next redo operation and calls the operation's performRedo() method.
	 */
	public final native void redo() /*-{
		this.redo();
	}-*/;
	
	/**
	 * Remove the specified operation from the stack.
	 * 
	 * @param operationId - the operation id
	 * @return OperationBase
	 */
	public final native OperationBase remove(int operationId) /*-{
		return this.remove(operationId);
	}-*/;
	
	/**
	 * Moves the current position to the next undo operation and calls the operation's performUndo method.
	 */
	public final native void undo() /*-{
		return this.undo();
	}-*/;
	
	/**
	 * Add handler for when operation is added
	 * 
	 * @param handler - Fires when the add method is called to add an operation is added to the stack.
	 */
	public final native void addAddHandler(UndoManagerAddHandler handler) /*-{
		$wnd.dojo.connect(this, "onAdd",
			function() {
				handler.@edu.ucdavis.cstars.client.event.UndoManagerAddHandler::onAdd()();
			}
		);
	}-*/;
	
	/**
	 * Add handler for when stack changes.
	 * 
	 * @param handler - Fires when the undo/redo stack changes.
	 */
	public final native void addChangeHandler(UndoManagerChangeHandler handler) /*-{
		$wnd.dojo.connect(this, "onChange",
			function() {
				handler.@edu.ucdavis.cstars.client.event.UndoManagerChangeHandler::onChange()();
			}
		);
	}-*/;
	
	/**
	 * Add handler for redo operation
	 * 
	 * @param handler - Fires when the redo method is called.
	 */
	public final native void addRedoHandler(UndoManagerRedoHandler handler) /*-{
		$wnd.dojo.connect(this, "onRedo",
			function() {
				handler.@edu.ucdavis.cstars.client.event.UndoManagerRedoHandler::onRedo()();
			}
		);
	}-*/;
	
	/**
	 * Add handler for undo operation
	 * 
	 * @param handler - Fires when the undo method is called.
	 */
	public final native void addUndoHandler(UndoManagerUndoHandler handler) /*-{
		$wnd.dojo.connect(this, "onUndo",
			function() {
				handler.@edu.ucdavis.cstars.client.event.UndoManagerUndoHandler::onUndo()();
			}
		);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		};
		
		/**
		 * Create a new options object
		 * 
		 * @param maxOperations - The maximum number of operations the UndoManager can perform. If a number less than or equal to zero is 
		 * provided the number of operations is unlimited. The default value is 10.
		 * 
		 * @return Options
		 */
		public static native Options create(int maxOperations) /*-{
			return {"maxOperations": maxOperations};
		}-*/;;
		
		/**
		 * Set the maxOperations parameter.
		 * 
		 * @param maxOperations - The maximum number of operations the UndoManager can perform. If a number less than or equal to zero is 
		 * provided the number of operations is unlimited. The default value is 10.
		 */
		public final native void setMaxOperations(int maxOperations) /*-{
			this["maxOperations"] = maxOperations;
		}-*/;
		
	}

}
