package edu.ucdavis.cstars.client.layers;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.callback.GetImageUrlCallback;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * The base class for ArcGIS Server dynamic map services.
 * 
 * DynamicMapServiceLayer has no constructor. Use 
 * ArcGISDynamicMapServicLayer and ArcGISImageServiceLayer instead.
 * 
 * @author Justin Merz
 */
public class DynamicMapServiceLayer extends Layer {

	protected DynamicMapServiceLayer() {}
	
	/**
	 * Full extent as defined by the map service.
	 * 
	 * @return Extent
	 */
	public final native Extent getFullExtent() /*-{
		return this.fullExtent;
	}-*/;
	
	/**
	 * Initial extent as defined by the map service.
	 * 
	 * @return Extent
	 */
	public final native Extent getInitialExtent() /*-{
		return this.initialExtent;
	}-*/;
	
	/**
	 * The spatial reference of the map service.
	 * 
	 * @return SpatialReference
	 */
	public final native SpatialReference getSpatialReference() /*-{
		return this.spatialReference;
	}-*/;
	
	/**
	 * Method to implement when extending DynamicMapServiceLayer.
	 * 
	 * @param extent - Current extent of the map.
	 * @param width - Current width of the map in pixels.
	 * @param height - Current height of the map in pixels.
	 * @param callback - The function to call when the method has completed.
	 * @return String
	 */
	public final native String getImageUrl(Extent extent, float width, float height, GetImageUrlCallback callback) /*-{
		return this.getImageUrl(extent, width, height, function() {
			callback.@edu.ucdavis.cstars.client.callback.GetImageUrlCallback::onComplete()();
		});
	}-*/;
	
	/**
	 * Refreshes the map by making a new request to the server. In order to refresh the layer in this manner,
	 * setDisableClientCaching must be true. This ensures that map images are not cached on the client.
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
	

	
}
