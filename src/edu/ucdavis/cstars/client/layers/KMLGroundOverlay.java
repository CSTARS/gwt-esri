package edu.ucdavis.cstars.client.layers;

/**
 * The KMLGroundOverlay class provides details about a KML ground overlay. 
 * 
 * @author Justin Merz
 */
public class KMLGroundOverlay extends MapImage {
	
	protected KMLGroundOverlay() {}
	
	/**
	 * KML ground overlay description.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	// getExtent implemented by MapImage
	
	// getHeight implemented by MapImage
	
	// getHref implemented by MapImage
	
	/**
	 * The id of the KML ground overlay.
	 * 
	 * @return int
	 */
	public final native int getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * The name of the KML ground overlay.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * Short snippet describing the KML ground overlay.
	 * 
	 * @return String
	 */
	public final native String getSnippet() /*-{
		return this.Snippet;
	}-*/;
	
	/**
	 * The KML ground overlay visibility. A value of 0 means the layer is not visible.
	 * 
	 * @return int
	 */
	public final native int getVisibility() /*-{
		return this.visibility;
	}-*/;

	// getWidth implemented by MapImage
}
