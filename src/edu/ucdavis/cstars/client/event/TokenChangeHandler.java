package edu.ucdavis.cstars.client.event;

/**
 *
 * @author Justin Merz
 */
public interface TokenChangeHandler {

	/**
	 * Fired when the token associated with the credential is updated or changed.
	 */
	public void onTokenChange();
	
}
