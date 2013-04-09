package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A geoprocessing data object containing a raster data source.
 * 
 * @author Justin Merz
 */
public class RasterData extends JavaScriptObject {
	
	protected RasterData() {}
	
	/**
	 * Creates a new RasterData object.
	 * 
	 * @return RasterData
	 */
	public static native RasterData create() /*-{
		return new $wnd.esri.tasks.RasterData();
	}-*/;
	
	/**
	 * Specifies the format of the raster data such as "jpg", "tif" etc.
	 * 
	 * @return String
	 */
	public final native String getFormat() /*-{
		return this.format;
	}-*/;
	
	/**
	 * Set the format parameter.
	 * 
	 * @param format - Specifies the format of the raster data such as "jpg", "tif" etc.
	 */
	public final native void setFormat(String format) /*-{
		this.format = format;
	}-*/;
	
	/**
	 * URL to the location of the raster data file.
	 * 
	 * @return String 
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Set the url parameter.
	 * 
	 * @param url - URL to the location of the raster data file.
	 */
	public final native void setUrl(String url) /*-{
		this.url = url;
	}-*/;

}
