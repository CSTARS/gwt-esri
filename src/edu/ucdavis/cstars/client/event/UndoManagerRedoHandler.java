package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface UndoManagerRedoHandler {

	/**
	 * Fires when the redo method is called.
	 */
	public void onRedo();
	
}
