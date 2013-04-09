package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.layers.MosaicRule;

/**
 * Input parameters for the ImageServiceIdentifyTask.
 * 
 * @author Justin Merz
 */
public class ImageServiceIdentifyParameters extends JavaScriptObject {
	
	protected ImageServiceIdentifyParameters() {}
	
	/**
	 * Creates a new ImageServiceIdentifyParameters object.
	 * 
	 * @return
	 */
	public static native ImageServiceIdentifyParameters create() /*-{
		return new $wnd.esri.tasks.ImageServiceIdentifyParameters();
	}-*/;
	
	/**
	 * Set the geometry parameter.
	 * 
	 * @param geometry - Input geometry that defines the location to be identified. The location can be a point or a polygon.
	 */
	public final native void setGeometry(Geometry geometry) /*-{
		this.geometry = geometry;
	}-*/;
	
	/**
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry() /*-{
		return this.geometry;
	}-*/;
	
	/**
	 * Set the mosaicRule parameter.
	 * 
	 * @param mosaicRule - Specifies the mosaic rules defining the image sorting order. When a mosaic rule is not specified, 
	 * METHOD_CENTER is used.
	 */
	public final native void setMosaicRule(MosaicRule mosaicRule) /*-{
		this.mosaicRule = mosaicRule;
	}-*/;
	
	/**
	 * 
	 * @return MosaicRule
	 */
	public final native MosaicRule getMosaicRule() /*-{
		return this.mosaicRule;
	}-*/;
	
	/**
	 * Set the pixelSizeX parameter.
	 * 
	 * @param pixelSizeX - The pixel level being identified (or the resolution being looked at) on the x-axis. If not specified, 
	 * it will default to the base resolution of the dataset.
	 */
	public final native void setPixelSizeX(int pixelSizeX) /*-{
		this.pixelSizeX = pixelSizeX;
	}-*/;
	
	/**
	 * 
	 * @return int
	 */
	public final native int getPixelSizeX() /*-{
		return this.pixelSizeX;
	}-*/;

	/**
	 * Set the pixelSizeY parameter.
	 * 
	 * @param pixelSizeY - The pixel level being identified (or the resolution being looked at) on the y-axis. If not specified,
	 * it will default to the base resolution of the dataset.
	 */
	public final native void setPixelSizeY(int pixelSizeY) /*-{
		this.pixelSizeY = pixelSizeY;
	}-*/;
	
	/**
	 * 
	 * @return int
	 */
	public final native int getPixelSizeY() /*-{
		return this.pixelSizeY;
	}-*/;

}
