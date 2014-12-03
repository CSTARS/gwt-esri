package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface UndoManagerChangeHandler {

	/**
	 * Fires when the undo/redo stack changes.
	 */
	public void onChange();
	
}
