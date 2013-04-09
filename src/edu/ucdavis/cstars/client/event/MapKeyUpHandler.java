package edu.ucdavis.cstars.client.event;

/**
 * Fires when a keyboard key is released.
 * 
 * @author Justin Merz
 */
public interface MapKeyUpHandler {
	
	/**
	 * 
	 * @param event - The keyCode is the Unicode number representing the pressed key.
	 */
	public void onKeyUp(KeyEvent event);

}
