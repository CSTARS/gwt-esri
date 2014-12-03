package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Fill symbols are used to draw polygon features on the graphics layer. PictureFillSymbol uses an image in a repeating pattern. In addition, the symbol can have an optional outline, which is defined by a line symbol. 
 * 
 * Known limitation: PictureFillSymbol does not work correctly in FireFox 2.x. It does work correctly in Internet Explorer 6 and 7 and FireFox 3.x.
 * 
 * @author Justin Merz
 */
public class PictureFillSymbol extends FillSymbol {
	
	protected PictureFillSymbol() {}
	
	/**
	 * Creates a new PictureFillSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the PictureFillSymbol.
	 * @return PictureFillSymbol
	 */
	public static native PictureFillSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.PictureFillSymbol(json);
	}-*/;
	
	/**
	 * Creates a new PictureFillSymbol object.
	 * 
	 * @param url - URL of the image.
	 * @param outline - Outline of the symbol.
	 * @param width - Width of the image in pixels.
	 * @param height - Height of the image in pixels.
	 * @return PictureFillSymbol
	 */
	public static native PictureFillSymbol create(String url, SimpleLineSymbol outline, int width, int height) /*-{
		return new $wnd.esri.symbol.PictureFillSymbol(url, outline, width, height);
	}-*/;
	
	/**
	 * Height of the image in pixels.
	 * 
	 * @return int
	 */
	public final native int getHeight() /*-{
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
	 * @return int
	 */
	public final native int getWidth() /*-{
		return this.width;
	}-*/;
	
	/**
	 * The offset on the x-axis in pixels. Default value: 0
	 * 
	 * @return int
	 */
	public final native int getXOffset() /*-{
		return this.xoffset;
	}-*/;
	
	/**
	 * Scale factor in x direction. Default value: 1
	 * 
	 * @return int
	 */
	public final native int getXScale() /*-{
		return this.xscale;
	}-*/;

	/**
	 * The offset on the y-axis in pixels. Default value: 0
	 * 
	 * @return int
	 */
	public final native int getYOffset() /*-{
		return this.yoffset;
	}-*/;
	
	/**
	 * Scale factor in y direction. Default value: 1
	 * 
	 * @return int
	 */
	public final native int getYScale() /*-{
		return this.yscale;
	}-*/;
	
	/**
	 * Sets the height of the symbol.
	 * 
	 * @param height - Height in pixels.
	 * @return int
	 */
	public final native PictureFillSymbol setHeight(int height) /*-{
		return this.setHeight(height);
	}-*/;

	/**
	 * Sets the symbol offset.
	 * 
	 * @param x - Offset in x direction in pixels.
	 * @param y - Offset in y direction in pixels.
	 * @return PictureFillSymbol
	 */
	public final native PictureFillSymbol setOffset(int x, int y) /*-{
		return this.setOffset(x, y);
	}-*/;
	
	/**
	 * Sets the URL to the location of the symbol.
	 * 
	 * @param url - URL string.
	 * @return PictureFillSymbol
	 */
	public final native PictureFillSymbol setUrl(String url) /*-{
		return this.setUrl(url);
	}-*/;
	
	/**
	 * Sets the width of the symbol.
	 * 
	 * @param width - Width in pixels.
	 * @return PictureFillSymbol
	 */
	public final native PictureFillSymbol setWidth(int width) /*-{
		return this.setWidth(width);
	}-*/;
	
	/**
	 * Sets the scale factor in x direction. of the symbol.
	 * 
	 * @param scale - Scale factor in x direction.
	 * @return PictureFillSymbol
	 */
	public final native PictureFillSymbol setXScale(int scale) /*-{
		return this.setXScale(scake);
	}-*/;
	
	/**
	 * Sets the scale factor in y direction.
	 * 
	 * @param scale - Scale factor in y direction.
	 * @return  PictureFillSymbol
	 */
	public final native PictureFillSymbol setYScale(int scale) /*-{
		return this.setYScale(scale);
	}-*/;
	
}
