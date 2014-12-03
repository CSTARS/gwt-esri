package edu.ucdavis.cstars.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An InfoTemplate contains a title and content template string
 * used to transform Graphic.attributes into an HTML representation. 
 * The Dojo syntax ${<key>} performs the parameter substitution. 
 * In addition, a wildcard ${*} can be used as the template string. 
 * The wildcard prints out all of the attribute's name value pairs. 
 * The default behavior on a Graphic is to show the Map's InfoWindow 
 * after a click on the Graphic. An InfoTemplate is required for 
 * this default behavior.
 * 
 * @author Justin Merz
 */
public class InfoTemplate extends JavaScriptObject {

	protected InfoTemplate() {}
	
	/**
	 * Creates a new empty InfoTemplate object.
	 * 
	 * @return InfoTemplate
	 */
	public static native InfoTemplate create() /*-{
		return new $wnd.esri.InfoTemplate();
	}-*/;
	
	/**
	 * Creates a new InfoTemplate object. All parameters are 
	 * required and must be specified in the order given.
	 * 
	 * @param title - The template for defining how to format the title used in an InfoWindow.
	 * @param content - The template for defining how to format the content used in an InfoWindow.
	 * @return InfoTemplate
	 */
	public static native InfoTemplate create(String title, String content) /*-{
		return new $wnd.esri.InfoTemplate(title, content);
	}-*/;
	
	/**
	 * JSON object representing the InfoTemplate.
	 * 
	 * @param json - Creates a new InfoTemplate object using a JSON object.
	 * @return InfoTemplate
	 */
	public static native InfoTemplate create(JavaScriptObject json) /*-{
		return new $wnd.esri.InfoTemplate(json);
	}-*/;
	
	/**
	 * The template for defining how to format the title used in an InfoWindow.
	 * 
	 * @return String
	 */
	public final native String getTitle() /*-{
		return this.title;
	}-*/;
	
	public final native JavaScriptObject getTitleAsFunction() /*-{
		return this.title;
	}-*/;

	/**
	 * The template for defining how to format the content used in an InfoWindow.
	 * 
	 * @return String
	 */
	public final native String getContent() /*-{
		return this.content;
	}-*/;
	
	/**
	 * The template for defining how to format the content used in an InfoWindow.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getContentAsFunction() /*-{
		return this.title;
	}-*/;

	/**
	 * Sets the content template.
	 * 
	 * @param content - The template for the content.
	 */
	public final native void setContent(String content) /*-{
		this.setContent(content);
	}-*/;
	
	/**
	 * Sets the content template.
	 * 
	 * @param content - The template for the content.
	 */
	public final native void setContent(JavaScriptObject contentFunction) /*-{
		this.setContent(contentFunction);
	}-*/;
	
	/**
	 * Sets the title template.
	 * 
	 * @param title - The template for the title.
	 */
	public final native void setTitle(String title) /*-{
		this.setTitle(title);
	}-*/;
	
	/**
	 * Sets the title template.
	 * 
	 * @param title - The template for the title.
	 */
	public final native void setTitle(JavaScriptObject titleFunction) /*-{
		this.setTitle(titleFunction);
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
