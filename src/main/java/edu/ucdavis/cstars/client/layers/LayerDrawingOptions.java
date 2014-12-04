package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.renderer.Renderer;

/**
 * The LayerDrawingOptions class prvoides options for setting ArcGISDynamicMapServiceLayer rendering options. 
 * Requires ArcGIS Server 10.1 or greater.
 * 
 * @author Justin Merz
 */
public class LayerDrawingOptions extends JavaScriptObject {
	
	protected LayerDrawingOptions() {}
	
	/**
	 * Creates a new LayerDrawingOptions object.
	 * 
	 * @return LayerDrawingOptions
	 */
	public static native LayerDrawingOptions create() /*-{
		return new $wnd.esri.layers.LayerDrawingOptions();
	}-*/;
	
	/**
	 * Creates a new LayerDrawingOptions object.
	 * 
	 * @param jso - JSON object representing the LayerDrawingOptions.
	 * @return LayerDrawingOptions
	 */
	public static native LayerDrawingOptions create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.LayerDrawingOptions(jso);
	}-*/;
	
	/**
	 * The renderer to use for the dynamic layer.
	 * 
	 * @return Renderer
	 */
	public final native Renderer getRenderer() /*-{
		return this.renderer;
	}-*/;
	
	/**
	 * Set the renderer to use for the dynamic layer.
	 * 
	 * @param renderer - The renderer to use for the dynamic layer.
	 */
	public final native void setRenderer(Renderer renderer) /*-{
		this.renderer = renderer;
	}-*/;
	
	/**
	 * Determines if the layer renders the symbols based on scale. When 
	 * false the layer does not render the symbols based on scale.
	 * 
	 * @return boolean
	 */
	public final native boolean scaleSymbols() /*-{
		return this.scaleSymbols;
	}-*/;
	
	/**
	 * Set scaleSymbols parameter.
	 * 
	 * @param scaleSymbols - Determines if the layer renders the symbols based on 
	 * scale. When false the layer does not render the symbols based on scale.
	 */
	public final native void setScaleSymbols(boolean scaleSymbols) /*-{
		this.scaleSymbols = scaleSymbols;
	}-*/;
	
	/**
	 * Determines if labels are displayed. When false, labels for the layer are not displayed.
	 * 
	 * @return boolean
	 */
	public final native boolean showLabels() /*-{
		return this.showLabels;
	}-*/;
	
	/**
	 * Set the showLabels parameter.
	 * 
	 * @param showLabels - Determines if labels are displayed. When false, labels for the 
	 * layer are not displayed.
	 */
	public final native void showLabels(boolean showLabels) /*-{
		this.showLabels = showLabels;
	}-*/;
	
	/**
	 * The transparency of the layer. Values range from 0 to 1.0 where 0 is 
	 * 100% transparent and 1 has no transparency.
	 * 
	 * @return boolean
	 */
	public final native double getTransparency() /*-{
		return this.transparency;
	}-*/;
	
	/**
	 * Set the transparency of the layer.
	 * 
	 * @param transparency - The transparency of the layer. Values range from 0 to 1.0 where 0 is 
	 * 100% transparent and 1 has no transparency.
	 */
	public final native void setTransparency(double transparency) /*-{
		this.transparency = transparency;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;

}
