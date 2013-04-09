package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.MapWidget;
import edu.ucdavis.cstars.client.layers.Layer;

/**
 * The legend dijit displays a label and symbol for some or all of the layers in the map. If specified,
 *  the legend will respect scale dependencies and only display layers and sub layers that are currently
 *  visible in the map. The legend automatically updates if the visibility of a layer or sublayer changes.
 *
 * The legend supports the following layer types: ArcGISDynamicMapServiceLayer,
 * ArcGISTiledMapServiceLayer, FeatureLayer. If the layer is an ArcGISDynamicMapServiceLayer or 
 * ArcGISTiledMapServiceLayer created using ArcGIS Server 10.0 SP1 or higher the legend is 
 * generated using the REST Map Service legend resource.
 * 
 * http://mapservice-url/legend
 * 
 * If the layers are version 10 or lower the legend is created using the ArcGIS.com legend service. 
 * In order to use the ArcGIS.com legend service your map service needs to be publicly accessible
 *  and your application must be able to access ArcGIS.com.
 * 
 * The legend for feature layers is created using the layer's drawing info, for example:
 * 
 * http://sampleserver3.arcgisonline.com/ArcGIS/rest/services/Earthquakes/EarthquakesFromLastSevenDays/MapServer/0
 * 
 * @author Justin Merz
 */
public class Legend extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	protected JavaScriptObject jso;
	
	public enum LegendAlignment {
		ALIGN_LEFT(0),
		ALIGN_RIGHT(1);
		private int value = 0;
		LegendAlignment(int val) {
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	
	/**
	 * Creates a new Legend dijit. Should be called after all the layers have been loaded in the map, 
	 * typically in the map's onLayerAddResult event.
	 * 
	 * @param params - Parameters used to configure the dijit. See the list below for details. 
	 */
	public  Legend(Parameters params) {
		
		if( !assertLoaded() ) return; 
		
		parameters = params;
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( jso == null ) jso = create(parameters);
			}
		});
		
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.Legend(params, this.@edu.ucdavis.cstars.client.dijits.Legend::getElement()());
	}-*/;
	
	/**
	 * Check that the esri.dijit.Legend package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.Legend ) return true;
		$wnd.alert("The ESRI_DIJIT_LEGEND has not been loaded");
		return false;
	}-*/;
	
	/**
	 * Destroys the legend. Call destroy() when the widget is no longer needed by the application.
	 */
	public void destroy() {
		_destroy();
		if( isAttached() ) removeFromParent();
	}
	
	private final native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.dijits.Legend::jso.destroy();
	}-*/;
	
	/**
	 * Refresh the legend. Calling refresh is only necessary when layerInfos is used in the Legend
	 *  constructor, otherwise the legend will refresh the layers automatically.
	 */
	public final native void refresh() /*-{
		this.@edu.ucdavis.cstars.client.dijits.Legend::jso.refresh();
	}-*/;
	
	/**
	 * Refresh the legend to replace the layers setup by the legend constructor. Calling refresh is
	 *  only necessary when layerInfos is used in the Legend constructor, otherwise the legend 
	 *  will refresh the layers automatically.
	 */
	public final native void refresh(LayerInfo layerInfos) /*-{
		this.@edu.ucdavis.cstars.client.dijits.Legend::jso.refresh(layerInfos);
	}-*/;
	
	/**
	 * Finalizes the creation of the legend . Call startup() after creating the widget when you are 
	 * ready for user interaction.
	 */
	public final native void startup() /*-{
		this.@edu.ucdavis.cstars.client.dijits.Legend::jso.startup();
	}-*/;
	
	
	

	/**
	 * Parameters used to configure the dijit.
	 */
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * Specify the alignment of the legend within the HTML element where the legend is 
		 * rendered. The default value of ALIGN_LEFT displays the symbol on the left side of the label
		 * 
		 * Optional
		 * 
		 * @param align
		 */
		public final void setArrangement(LegendAlignment align){
			setArrangement(align.getValue());
		}
		
		private final native void setArrangement(int align) /*-{
			this["arrangement"] = align;
		 }-*/;
		
		/**
		 * Specify a subset of the layers in the map to display in the legend. If not set all layers in 
		 * the map will display in the legend.
		 * 
		 * Optional
		 * 
		 * @param layerInfo
		 */
		public final native void setLayerInfos(LayerInfo layerInfo) /*-{
			this["layerInfos"] = layerInfo;
		}-*/;
		
		/**
		 * Reference to the map. The map parameter is required. 
		 * 
		 * Required
		 * 
		 * @param map
		 */
		public final void setMap(MapWidget map) {
			setMap(map.getMapObject());
		}
		
		private final native void setMap(JavaScriptObject map) /*-{
			this["map"] = map;
		}-*/;
		
		/**
		 * Optional. When true the legend will update with every scale change and displays only
		 *  the layers and sub layers that are visible in the current map scale. When false, the
		 *  legend does not update on every scale change and all layers and sub layers will be 
		 *  displayed. The default value is true. 
		 * 
		 * @param respectScale
		 */
		public final native void setRespectCurrentMapScale(boolean respectScale) /*-{
			this["respectCurrentMapScale"] = respectScale;
		}-*/;
		
	}
	
	public static class LayerInfo extends JavaScriptObject {
		
		protected LayerInfo() {}
		
		public static LayerInfo create() {
				return JavaScriptObject.createArray().cast();
		};
		
		/**
		 * Add layer with title
		 * 
		 * @param layer - A layer to add to the legend. Valid layer types are: ArcGISTiledMapServiceLayer,
		 * ArcGISDynamicMapServiceLayer or GraphicsLayer. 
		 * @param title - Specify a title for the layer.
		 */
		public final native void addLayer(Layer layer, String title) /*-{
			this.push( {layer: layer, title: title} );
		}-*/;
		
		/**
		 * Add layer, service name will be used for title
		 * 
		 * @param layer - A layer to add to the legend. Valid layer types are: ArcGISTiledMapServiceLayer,
		 * ArcGISDynamicMapServiceLayer or GraphicsLayer. 
		 */
		public final native void addLayer(Layer layer) /*-{
			this.push( {layer: layer} );
		}-*/;
		
	}

}
