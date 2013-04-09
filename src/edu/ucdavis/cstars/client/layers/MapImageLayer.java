package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * The MapImageLayer class is used to add georeferenced images to the map. The map will place the georeferenced 
 * images at the specified geographic extent. The extent of the image should be within the map's extent. The image 
 * should also be in the same coordinate system as the map.
 * 
 * @author Justin Merz
 */
public class MapImageLayer extends Layer {
	
	protected MapImageLayer() {}
	
	/**
	 * Creates a new MapImageLayer object
	 * 
	 * @return MapImageLayer
	 */
	public static MapImageLayer create() {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create();
	}
	
	private static native MapImageLayer _create() /*-{
		return $wnd.esri.layers.MapImageLayer();
	}-*/;
	
	/**
	 * Creates a new MapImageLayer object
	 * 
	 * @param options - Optional parameters. 
	 * @return MapImageLayer
	 */
	public static MapImageLayer create(Options options) {
		if( !assertLoaded() ) return JavaScriptObject.createObject().cast();
		return _create(options);
	}
	
	private static native MapImageLayer _create(Options options) /*-{
		return $wnd.esri.layers.MapImageLayer(options);
	}-*/;
	
	/**
	 * Check that the esri.layers.MapImageLayer has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.MapImageLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_MAPIMAGELAYER package has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Add an image to the map. The Map Image extent should have the same coordinate system as the map and be within the map's extent.
	 * 
	 * @param mapImage - A MapImage object that defines the image to add to the map.
	 */
	public final native void addMapImage(MapImage mapImage) /*-{
		this.addMapImage(mapImage);
	}-*/;
	
	/**
	 * Get an array of MapImage objects that define the images in the MapImageLayer.
	 * 
	 * @return JsArray<MapImage>
	 */
	public final native JsArray<MapImage> getImages() /*-{
		return this.getImages();
	}-*/;
	
	/**
	 * Get the current visibility of the input MapImage.
	 * 
	 * @param mapImage - The MapImage object.
	 * @return boolean
	 */
	public final native boolean getImageVisibility(MapImage mapImage) /*-{
		return this.getImageVisibility(mapImage);
	}-*/;
	
	/**
	 * Remove all images from the layer.
	 */
	public final native void removeAllImages() /*-{
		this.removeAllImages();
	}-*/;
	
	/**
	 * Remove the specified image from the layer.
	 * 
	 * @param mapImage - The MapImage object that defines the image to remove.
	 */
	public final native void removeImage(MapImage mapImage) /*-{
		this.removeImage(mapImage);
	}-*/;
	
	/**
	 * Set the visibility for the image.
	 * 
	 * @param mapImage - The mapImage object.
	 * @param isVisible - Set the visibility of the MapImage.
	 */
	public final native void setImageVisibility(MapImage mapImage, boolean isVisible) /*-{
		this.setImageVisibility(mapImage, isVisible);
	}-*/;
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		public final native void setOpacity(double opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		public final native void setUrl() /*-{
			this["url"] = url;
		}-*/;
		
	}

}
