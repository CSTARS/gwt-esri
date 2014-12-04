package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The LayerMapSource class defines and provides information about an 
 * existing map service layer. Requires ArcGIS Server 10.1 or greater.
 * 
 * @author Justin Merz
 */
public class LayerMapSource extends JavaScriptObject {

	protected LayerMapSource() {}
	
	/**
	 * Creates a new LayerMapSource object.
	 * 
	 * @return LayerMapSource
	 */
	public static native LayerMapSource create() /*-{
		return new $wnd.esri.layers.LayerMapSource();
	}-*/;
	
	/**
	 * Creates a new LayerMapSource object.
	 * 
	 * @param jso - JSON object representing the LayerMapSource.
	 * @return LayerMapSource
	 */
	public static native LayerMapSource create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.LayerMapSource(jso);
	}-*/;
	
	/**
	 * When supported, specify the version in an SDE workspace that the layer will use.
	 * 
	 * @return String
	 */
	public final native String getGdbVersion() /*-{
		return this.gdbVersion;
	}-*/;
	
	/**
	 * Set the gdb version parameter.
	 * 
	 * @param gdbVersion - When supported, specify the version in an SDE workspace that the layer will use.
	 */
	public final native void setGdbVersion(String gdbVersion) /*-{
		this.gdbVersion = gdbVersion;
	}-*/;
	
	/**
	 * The layer id for a sub-layer in the current map service.
	 * 
	 * @return int
	 */
	public final native int getMapLayerId() /*-{
		return this.mapLayerId;
	}-*/;
	
	/**
	 * Set the layer id parameter.
	 * 
	 * @param mapLayerId - The layer id for a sub-layer in the current map service.
	 * @return int
	 */
	public final native int getMapLayerId(int mapLayerId) /*-{
		this.mapLayerId = mapLayerId;
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
