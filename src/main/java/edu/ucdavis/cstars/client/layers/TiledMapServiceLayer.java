package edu.ucdavis.cstars.client.layers;

import edu.ucdavis.cstars.client.SpatialReference;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * The base class for all tiled map service layers.
 * 
 * TiledMapServiceLayer has no constructor. Use ArcGISTiledMapServiceLayer instead.
 * 
 * @author Justin Merz
 */
public class TiledMapServiceLayer extends Layer {

	protected TiledMapServiceLayer() {}
	
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
	 * Returns TileInfo, which has information on the tiling schema.
	 * 
	 * @return TileInfo
	 */
	public final native TileInfo getTileInfo() /*-{
		return this.tileInfo;
	}-*/;
	
	/**
	 * Method to implement when extending TiledMapServiceLayer.
	 * 
	 * @param level - Requested tile's level.
	 * @param row - Requested tile's row.
	 * @param column - Requested tile's column.
	 * @return String
	 */
	public final native String getTileUrl(double level, int row, int column) /*-{
		return this.getTileUrl(level, row, column);
	}-*/;
	
	/**
	 * Reloads all the tiles in the current view.
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
	
}
