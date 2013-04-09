package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Marker symbols are used to draw points and multipoints on the graphics layer. PictureMarkerSymbol uses an image as a marker.
 * 
 * @author Justin Merz
 */
public class PictureMarkerSymbol extends MarkerSymbol {
	
	protected PictureMarkerSymbol() {}
	
	/**
	 * Creates a new PictureMarkerSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the PictureMarkerSymbol.
	 * @return PictureMarkerSymbol
	 */
	public static native PictureMarkerSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.PictureMarkerSymbol(json);
	}-*/;
	
	/**
	 * Creates a new PictureMarkerSymbol object.
	 * 
	 * @param url - URL of the image.
	 * @param width - Width of the image in pixels. The default value is the actual width of the image.
	 * @param height - Height of the image in pixels. The default value is the actual height of the image.
	 * @return PictureMarkerSymbol
	 */
	public static native PictureMarkerSymbol create(String url, int width, int height) /*-{
		return new $wnd.esri.symbol.PictureMarkerSymbol(url, width, height);
	}-*/;
	
	/**
	 * Height of the image in pixels.
	 * 
	 * *Note: this seems to have a double value for some symbols
	 * 
	 * @return double
	 */
	public final native double getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * URL of the image.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;
	
	/**
	 * Width of the image in pixels.
	 * 
	 * *Note: this seems to have a double value for some symbols
	 * 
	 * @return double
	 */
	public final native double getWidth() /*-{
		return this.width;
	}-*/;
	
	/**
	 * Sets the height of the image for display. The height can be larger or smaller than the actual width of the image.
	 * As the image gets larger, it will become more pixellated.
	 * 
	 * @param height - Height of marker in pixels.
	 * @return PictureMarkerSymbol
	 */
	public final native PictureMarkerSymbol setHeight(int height) /*-{
		return this.setHeight(height);
	}-*/;
	
	/**
	 * Sets the URL where the image is located.
	 * 
	 * @param url - URL location of marker image.
	 * @return PictureMarkerSymbol
	 */
	public final native PictureMarkerSymbol setUrl(String url) /*-{
		return this.setUrl(url);
	}-*/;
	
	/**
	 * Sets the width of the image for display. The width can be larger or smaller than the actual width of the image.
	 * As the image gets larger, it will become more pixellated.
	 * 
	 * @param width - Width of marker in pixels.
	 * @return PictureMarkerSymbol
	 */
	public final native PictureMarkerSymbol setWidth(int width) /*-{
		return this.setWidth(width);
	}-*/;
	

}
