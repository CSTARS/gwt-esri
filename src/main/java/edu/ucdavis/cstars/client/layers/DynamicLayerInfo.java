package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Class added v2.7
 * 
 * Information about each layer in a map service. This class extends the esri.layers.LayerInfo class with a 
 * new property source which can be either a esri.layers.LayerMapSource or a esri.layers.LayerDataSource.
 * 
 * @author Justin Merz
 */
public class DynamicLayerInfo extends LayerInfo {

	protected DynamicLayerInfo() {}
	
	/**
	 * Creates a new DynamicLayerInfo object.
	 * 
	 * @return DynamicLayerInfo
	 */
	public static native DynamicLayerInfo create() /*-{
		return new $wnd.esri.layers.DynamicLayerInfo();
	}-*/;
	
	/**
	 * Creates a new DynamicLayerInfo object.
	 * 
	 * @param jso - JSON object representing the DynamicLayerInfo.
	 * @return DynamicLayerInfo
	 */
	public static native DynamicLayerInfo create(JavaScriptObject jso) /*-{
		return new $wnd.esri.layers.DynamicLayerInfo(jso);
	}-*/;
	
	/**
	 * The source for the dyamic layer can be either a LayerMapSource or LayerDataSource. Requires ArcGIS Server 10.1 service.
	 * 
	 * @return LayerMapSource
	 */
	public final native LayerMapSource getSourceAsLayerMapSource() /*-{
		return this.source;
	}-*/;
	
	/**
	 * The source for the dyamic layer can be either a LayerMapSource or LayerDataSource. Requires ArcGIS Server 10.1 service.
	 * 
	 * @return LayerDataSource
	 */
	public final native LayerDataSource getSourceLayerDataSource() /*-{
		return this.LayerDataSource;
	}-*/;

	/**
	 * Set the data source.
	 * 
	 * @param source - The source for the dyamic layer. Requires ArcGIS Server 10.1 service.
	 */
	public final native void setSource(LayerMapSource source) /*-{
		this.source = source;
	}-*/;
	
	/**
	 * Set the data source.
	 * 
	 * @param source - The source for the dyamic layer. Requires ArcGIS Server 10.1 service.
	 */		
	public final native void setSource(LayerDataSource source) /*-{
		this.source = source;
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
