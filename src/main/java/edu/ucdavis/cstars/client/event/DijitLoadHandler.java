package edu.ucdavis.cstars.client.event;

/**
 * Since the dijit class are composites that do not initialize till the DOM is created 
 * (this is due to the fact that a attached DOM element is required by the constructor)
 * this event handler let's you know when everything is preped and ready to go.
 * 
 * @author Justin Merz
 */
public interface DijitLoadHandler {

	/**
	 * Fires when the dijit is attached to the DOM and created.
	 * 
	 * You can't use the dijit until this event fires!!!
	 */
	public void onLoad();
	
}
