package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Extent;

/**
 * Represents the image service parameter options used when calling ArcGISImageServiceLayer.exportMapImage.
 * 
 * @author lsimone
 * @author Justin Merz
 */
public class ImageServiceParameters extends JavaScriptObject {
	
	public static enum Formats {
		NOT_SET(""),
		FORMAT_PNG8("png8"),
		FORMAT_PNG24("png24"),
		FORMAT_JPG("jpg"),
		FORMAT_BMP("bmp"),
		FORMAT_GIF("gif");
		private String val;
		private Formats(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum Interpolations {
		NOT_SET(""),
		INTERPOLATION_BILINEAR("RSP_BilinearInterpolation"),
		INTERPOLATION_CUBICCONVOLUTION("RSP_CubicConvolution"),
		INTERPOLATION_MAJORITY("RSP_Majority"),
		INTERPOLATION_NEARESTNEIGHBOR("RSP_NearestNeighbor");
		private String val;
		private Interpolations(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected ImageServiceParameters() {}
	
	/**
	 * Creates a new ImageServiceParameters object. The constructor takes no parameters.
	 * 
	 * @return ImageServiceParameters
	 */
	public static native final ImageServiceParameters create() /*-{
		return new $wnd.esri.layers.ImageServiceParameters();
	}-*/;
	

	/**
	 * Set the bandIds parameter.
	 * 
	 * @param bandIds - Array of current band selections.
	 */
	public final void setBandIds(int[] bandIds) {
		_setBandIds(Util.intArrayToJSO(bandIds));
	}
	
	private native final void _setBandIds(JavaScriptObject bandIds) /*-{
		this.bandIds = bandIds;
	}-*/;
	
	/**
	 * Array of current band selections.
	 * 
	 * @return JsArrayInteger
	 */
	public native final JsArrayInteger getBandIds() /*-{
		return this.bandIds;
	}-*/;
	
	/**
	 *
	 * @param quality - Current compression quality value. The compression quality controls how much loss
	 * the image will be subjected to. Only valid with JPG image types.
	 */
	public native final void setCompressionQuality(double quality) /*-{
		this.compressionQuality = quality;
	}-*/;
	
	/**
	 * Current compression quality value. The compression quality controls how much loss the image will be
	 * subjected to. Only valid with JPG image types.
	 * 
	 * @return float
	 */
	public native final double getCompressionQuality() /*-{
		return this.compressionQuality;
	}-*/;
	
	/**
	 * 
	 * @param extent - Extent of the exported image.
	 */
	public native final void setExtent(Extent extent) /*-{
		this.extent = extent;
	}-*/;
	
	/**
	 * Extent of the exported image.
	 * 
	 * @return Extent
	 */
	public final native Extent getExtent() /*-{
		return this.extent;
	}-*/;
	
	/**
	 * <p>Map image format.</p>
	 * Known values: png8 | png24 | jpg | bmp | gif
	 * <p><b>Default value</b>: png8</p> 
	 * 
	 * @param format
	 */
	public final void setFormat(Formats format) {
		_setFormat(format.getValue());
	}
	
	private native final void _setFormat(String format) /*-{
		this.format = format;
	}-*/;
	
	/**
	 * Map image format.
	 * 
	 * @return Formats
	 */
	public final Formats getFormat() {
		String f = _getFormat();
		for( int i = 0 ; i < Formats.values().length; i++ ){
			if( Formats.values()[i].getValue().contentEquals(f) )
				return Formats.values()[i];
		}
		return Formats.NOT_SET;
	};
	
	private native final String _getFormat() /*-{
		return this.format;
	}-*/;

	/**
	 * 
	 * @param height - Requested image height in pixels.
	 */
	public native final void setHeight(int height) /*-{
		this.height = height;
	}-*/;
	
	/**
	 * Requested image height in pixels.
	 * 
	 * @return int
	 */
	public native final int getHeight() /*-{
		return this.height;
	}-*/;
	
	/**
	 * Current interpolation method. 
	 * The interpolation method affects how the raster dataset is transformed when it undergoes warping or when it changes coordinate space.
	 * @param interpolation
	 */
	public final void setInterpolation(Interpolations interpolation) {
		_setInterpolation(interpolation.getValue());
	}
	
	private native final void _setInterpolation(String interpolation) /*-{
		this.interpolation = interpolation;
	}-*/;
	
	/**
	 * Current interpolation method. 
	 * The interpolation method affects how the raster dataset is transformed when it undergoes warping or when it changes coordinate space.
	 * 
	 * @return Interpolations
	 */
	public final Interpolations getInterpolation() {
		String f = _getInterpolation();
		for( int i = 0 ; i < Interpolations.values().length; i++ ){
			if( Interpolations.values()[i].getValue().contentEquals(f) )
				return Interpolations.values()[i];
		}
		return Interpolations.NOT_SET;
	};
	
	private native final String _getInterpolation() /*-{
		return this.interpolation;
	}-*/;
	
	/**
	 * Specifies the mosaic rule when defining how individual images should be mosaicked.
	 * 
	 * @return MosaicRule
	 */
	public native final MosaicRule getMosaicRule() /*-{
		return this.mosaicRule;
	}-*/;
	
	/**
	 * 
	 * @param mosaicRule - Specifies the mosaic rule when defining how individual images should be mosaicked.
	 */
	public native final void setMosaicRule(MosaicRule mosaicRule) /*-{
		this.mosaicRule = mosaicRule;
	}-*/;
	
	/**
	 * The pixel value that represents no information.
	 * 
	 * @return int
	 */
	public native final int getNoData() /*-{
		return this.nodata;
	}-*/;
	
	/**
	 * 
	 * @param pixel - The pixel value that represents no information.
	 */
	public native final void setNoData(int pixel) /*-{
		this.nodata = pixel;
	}-*/;
	
	/**
	 * Specifies the rendering rule for how the requested image should be rendered.
	 * View the Raster Functions help topic in the REST help for more details.
	 * 
	 * @return RasterFunction
	 */
	public native final RasterFunction getRenderingRule() /*-{
		return this.renderingRule;
	}-*/;
	
	/**
	 * 
	 * @param rule - Specifies the rendering rule for how the requested image should be
	 * rendered. View the Raster Functions help topic in the REST help for more details.
	 */
	public native final void setRenderingRule(RasterFunction rule) /*-{
		this.renderingRule = rule;
	}-*/;
	
	/**
	 * Define the time extent for the image.
	 * 
	 * @return TimeExtent
	 */
	public native final TimeExtent getTimeExtent() /*-{
		return this.timeExtent;
	}-*/;
	
	/**
	 * 
	 * @param timeExtent - Define the time extent for the image.
	 */
	public native final void setTimeExtent(TimeExtent timeExtent) /*-{
		this.timeExtent = timeExtent;
	}-*/;
	
	/**
	 * Requested image width in pixels.
	 * 
	 * @return int
	 */
	public native final int getWidth() /*-{
		return this.width;
	}-*/;
	
	/**
	 * 
	 * @param width - Requested image width in pixels.
	 */
	public native final void setWidth(int width) /*-{
			this.width = width;
	}-*/;
	
	
}
