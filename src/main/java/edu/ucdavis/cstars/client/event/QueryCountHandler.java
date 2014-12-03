package edu.ucdavis.cstars.client.event;

/**
 * 
 * @author Justin Merz
 */
public interface QueryCountHandler {

	/**
	 * Called when query returns from the server
	 * 
	 * @param count - number of features that satisfied the input query
	 */
	public void onQueryCountComplete(int count);
	
}
