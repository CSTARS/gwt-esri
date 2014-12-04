package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface SelectionChangeHandler {

	/**
	 * Fires when an item is selected or unselected in the template picker.
	 * You can retrieve the selected item using the getSelected() method.
	 */
	public void onSelectionChange();
	
}
