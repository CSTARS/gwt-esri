package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.InfoTemplate;
import edu.ucdavis.cstars.client.dojo.Shape;
import edu.ucdavis.cstars.client.geometry.Geometry;
import edu.ucdavis.cstars.client.layers.GraphicsLayer;
import edu.ucdavis.cstars.client.symbol.Symbol;


/**
 * A Graphic can contain geometry, a symbol, attributes, or an infoTemplate. 
 * A Graphic is displayed in the GraphicsLayer. The GraphicsLayer allows you 
 * to listen for events on Graphics. 
 * 
 * @author lsimone
 * @author Justin Merz
 */
public class Graphic extends JavaScriptObject {

	protected Graphic() {}
	
	
	/**
	 * Creates a new Graphic object. All parameters are required and must be specified 
	 * in the order given.
	 * 
	 * @param geometry - The geometry that defines the graphic. 
	 * @param symbol - Symbol used for drawing the graphic. 
	 * @return Graphic
	 */
	public static native Graphic create(Geometry geometry, Symbol symbol) /*-{
		return new $wnd.esri.Graphic(geometry, symbol);
	}-*/;
	
	/**
	 * Creates a new Graphic object. All parameters are required and must be specified 
	 * in the order given.
	 * 
	 * @param geometry - The geometry that defines the graphic. 
	 * @param symbol - Symbol used for drawing the graphic. 
	 * @param attrs - Name value pairs of fields and field values associated with the graphic. 
	 * @param infoTemplate - The content for display in an InfoWindow. 
	 * @return Graphic
	 */
	public static native Graphic create(Geometry geometry, Symbol symbol, Attributes attrs, InfoTemplate infoTemplate) /*-{
		return new $wnd.esri.Graphic(geometry, symbol, attrs, infoTemplate);
	}-*/;
	
	/**
	 * Creates a new Graphic object using a JSON object.
	 * 
	 * @param json - JSON object representing the graphic.
	 * @return Graphic
	 */
	public static native Graphic create(JavaScriptObject json) /*-{
		return new $wnd.esri.Graphic(json);
	}-*/;
	
	/**
	 * Name value pairs of fields and field values associated with the graphic.
	 * 
	 * @return Attributes
	 */
	public final native Attributes getAttributes() /*-{ 
		return this.attributes; 
	}-*/;
	
	/**
	 * The geometry that defines the graphic.
	 * 
	 * @return Geometry
	 */
	public final native Geometry getGeometry() /*-{ 
		return this.geometry;
	}-*/;
	
	/**
	 * The content for display in an InfoWindow.
	 * 
	 * @return InfoTemplate
	 */
	public final native InfoTemplate getInfoTemplate() /*-{
		return this.infoTemplate;
	}-*/;
	
	/**
	 * The symbol for the graphic.
	 * 
	 * @return Symbol
	 */
	public final native Symbol getSymbol() /*-{
		return this.symbol;
	}-*/;
	
	/**
	 * Indicate the visiblity of the graphic. The default value is true.
	 * 
	 * @return boolean
	 */
	public final native boolean isVisible() /*-{
		return this.visible;
	}-*/;
	
	/**
	 * Returns the content string based on attributes and infoTemplate values.
	 * 
	 * @return String
	 */
	public final native String getContent() /*-{
		return this.getContent();
	}-*/;
	
	/**
	 * Returns the Dojo gfx shape of the ESRI graphic.
	 * 
	 * @return Shape
	 */
	public final native Shape getDojoShape() /*-{
		return this.getDojoShape();
	}-*/;
	
	/**
	 * Returns the graphics layer that contains the graphic. Returns null if the graphic is not added to a layer.
	 * 
	 * @return GraphicsLayer
	 */
	public final native GraphicsLayer getLayer() /*-{
		return this.getLayer();
	}-*/;
	
	/**
	 * Returns the title string based on attributes and infoTemplate values.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.getTitle();
	}-*/;
	
	/**
	 * Hides the graphic.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;
	
	/**
	 * Defines the attributes of the graphic.
	 * 
	 * @param attrs
	 * @return Graphic
	 */
	public final native Graphic setAttributes(Attributes attrs) /*-{
		return this.setAttributes(attrs);
	}-*/;
	
	/**
	 * Defines the geometry of the graphic.
	 * 
	 * 
	 * @param geometry
	 * @return Graphic
	 */
	public final native Graphic setGeometry(Geometry geometry) /*-{
		return this.setGeometry(geometry);
	}-*/;
	
	/**
	 * Defines the InfoTemplate for the InfoWindow of the graphic. When a user 
	 * clicks a graphic, the InfoWindow opens with this template.
	 * 
	 * @param infoTemplate
	 * @return Graphic
	 */
	public final native Graphic setInfoTemplate(InfoTemplate infoTemplate) /*-{
		return this.setInfoTemplate(infoTemplate);
	}-*/;
	
	/**
	 * Sets the symbol of the graphic.
	 * 
	 * @param symbol
	 * @return Graphic
	 */
	public final native Graphic setSymbol(Symbol symbol) /*-{
		return this.setSymbol(symbol);
	}-*/;
	
	/**
	 * Shows the graphic.
	 */
	public final native void show() /*-{
		this.show();
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
	public static class Attributes extends JSObject {
		
		protected Attributes() {}
		
		public static Attributes create() {
			return JavaScriptObject.createObject().cast();
		};
		
	}
	
}
