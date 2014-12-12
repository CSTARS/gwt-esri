package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.symbol.SimpleFillSymbol;
import edu.ucdavis.cstars.client.tasks.GeometryService;

/**
 * Set esri.config.default variables and options
 * 
 * @author jrmerz
 */
public class ESRI {
	
	/**
	 * Whether or not to always use the proxy for communication to a REST endpoint.
	 * (esriConfig.defaults.io.alwaysUseProxy)
	 * 
	 * @param useProxy
	 */
	public static native void alwaysUseProxy(boolean useProxy) /*-{
		$wnd.esriConfig.defaults.io.alwaysUseProxy = useProxy;
	}-*/;

	/**
	 * Whether or not to detect support for cross-origin resource sharing (CORS). 
	 * Setting this to false will stop the API from sending requests that result in 
	 * "XMLHttpRequest cannot load http://some.url.com/ArcGIS/rest/info?f=json. 
	 * Origin http://yourapp.com is not allowed by Access-Control-Allow-Origin." 
	 * messages in browser developer tools but it will also prevent the API from 
	 * discovering that a resource supports CORS if it is not explicitly added to 
	 * esriConfig.defaults.io.corsEnabledServers.
	 */
	public static native void setCorsDetectionEnabled(boolean enabled) /*-{
    $wnd.esriConfig.defaults.io.corsDetection = enabled;
	}-*/;
	
	/**
	 * Specify an array of servers with cross-origin resource sharing enabled. Cross-Origin 
	 * Resource Sharing (CORS) allows web applications to bypass the browser's same origin 
	 * policy file and access resources or services on different servers/domains. When both 
	 * the web server and browser support CORS, esri.request will not use a proxy to perform 
	 * cross-domain requests.
	 * (esri.config.defaults.io.corsEnabledServers)
	 * 
	 * @param server - CORS enabled server
	 */
	public static native void addCorsEnabledServers(String server) /*-{
		$wnd.esri.config.defaults.io.corsEnabledServers.push(server);
	}-*/;
	
	/**
	 * Specify the default geometry service used by widgets and operations.
	 * (esri.config.defaults.geometryService)
	 * 
	 * @param service - default geometry service
	 */
	public static native void setGeometryService(GeometryService service) /*-{
		$wnd.esri.config.defaults.geometryService = service;
	}-*/;
	
	/**
	 * The location of the proxy url that should be used when posting large payloads to an 
	 * endpoint. This must reside on the same domain as the HTML application.
	 * (esriConfig.defaults.io.proxyUrl)
	 * 
	 * @param url - proxy url
	 */
	public static native void setProxyUrl(String url) /*-{
		$wnd.esriConfig.defaults.io.proxyUrl = url;
	}-*/;
	
	/**
	 * Each request through esri.request is allowed up to 60 seconds to respond. If no response is 
	 * returned or a server-side error is returned, the esri.Error and error back handlers are 
	 * called, in that order.  Default: 60 seconds.
	 * (esri.config.defaults.io.timeout)
	 * 
	 * @param timeout - request timeout (in milliseconds)
	 */
	public static native void setTimeout(int timeout) /*-{
		$wnd.esri.config.defaults.io.timeout = timeout;
	}-*/;
	
	
	/**
	 * The length of time in milliseconds that the map will take to pan from one extent to another.
	 * Default: 350.
	 * (esri.config.defaults.map.panDuration)
	 * 
	 * @param duration - pan duration
	 */
	public static native void setPanDuration(int duration) /*-{
		$wnd.esri.config.defaults.map.panDuration = duration;
	}-*/;
	
	/**
	 * The length of time in milliseconds that the map will refresh as it pans to the next extent.
	 * Default: 50.
	 * (esri.config.defaults.map.panRate)
	 * 
	 * @param rate - refresh rate
	 */
	public static native void setPanRate(int rate) /*-{
		$wnd.esri.config.defaults.map.panRate = rate;
	}-*/;
	
	/**
	 * The parameters that define the location, size, and orientation of the slider.
	 * Default: {left:"30px", top:"30px", width:null, height:"200px"}.
	 * (esri.config.defaults.map.slider)
	 * 
	 * @param left - left position of slider
	 * @param top - top position of slider
	 * @param width - slider width
	 * @param height - slider height
	 */
	public static native void setSlider(String left, String top, String width, String height) /*-{
		$wnd.esri.config.defaults.map.slider = {"left":left,"top":top,"width":width,"height":height};
	}-*/;
	
	/**
	 * The parameters that define the slider tick and accompanying tick label.
	 * Default: {tick:5,labels:null,style:"width:2em; font-family:Verdana; font-size:75%;"}
	 * (esri.config.defaults.map.sliderLabel)
	 * 
	 * @param tick - number of ticks
	 * @param labels - tick labels
	 * @param style - style attribute for slider
	 */
	public static void setSliderLabel(int tick, String[] labels, String style) {
		_setSliderLabel(tick, Util.stringArrayToJSO(labels), style);
	}
	
	private static native void _setSliderLabel(int tick, JavaScriptObject labels, String style) /*-{
		$wnd.esri.config.defaults.map.sliderLabel = {"tick":tick,"labels":labels,"style":style};
	}-*/;
	
	/**
	 * The slider will not show tick marks.
	 * (esri.config.defaults.map.sliderLabel)
	 */
	public static native void disableSliderLabel() /*-{
		$wnd.esri.config.defaults.map.sliderLabel = null;
	}-*/;
	
	/**
	 * The length of time in milliseconds that the map will take to zoom from one extent to another.
	 * Default: 500
	 * (esri.config.defaults.map.zoomDuration)
	 * 
	 * @param rate - zoom rate
	 */
	public static native void setZoomDuration(int duration) /*-{
		$wnd.esri.config.defaults.map.zoomDuration = duration;
	}-*/;
	
	/**
	 * The length of time in milliseconds that the map will refresh as it zooms to the next extent.
	 * Default: 50
	 * (esri.config.defaults.map.zoomRate)
	 * 
	 * @param rate - refresh rate
	 */
	public static native void setZoomRate(int rate) /*-{
		$wnd.esri.config.defaults.map.zoomRate = rate;
	}-*/;
	
	/**
	 * The SimpleFillSymbol to use to represent the color, fill, and outline properties of the RubberBand zoom.
	 * Default: {color:[0,0,0,64],outline:{color:[255,0,0,255],width:1.5,style:"esriSLSSolid"},style:"esriSFSSolid"}
	 * (esri.config.defaults.map.zoomSymbol)
	 * 
	 * @param zoomSymbol
	 */
	public static void setZoomSymbol(SimpleFillSymbol zoomSymbol) {
		_setZoomSymbol(zoomSymbol.toJson());
	}
	
	private static native void _setZoomSymbol(JavaScriptObject zoomSymbol) /*-{
		$wnd.esri.config.defaults.map.zoomSymbol = zoomSymbol;
	}-*/;
	
	/**
	 * Get details about the input ArcGIS.com item. An object with the following specification is passed to the callback:
	 * 
	 * The information included in the response object returned to the callback depends on the version. View the Working 
	 * with web maps help topic for details on the response object.
	 * 
	 * Return value: dojo.Deferred
	 * @param itemId
	 */
	public static native void getItem(String itemId) /*-{
		$wnd.esri.arcgis.utils.getItem(itemId);
	}-*/;
	
	
}
