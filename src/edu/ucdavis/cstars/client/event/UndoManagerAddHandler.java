package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface UndoManagerAddHandler {

	/**
	 * Fires when the add method is called to add an operation is added to the stack.
	 */
	public void onAdd();
	
}
