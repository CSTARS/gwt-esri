package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.MapWidget;

/**
 * Input parameters for the PrintTask.
 * 
 * @author Justin Merz
 */
public class PrintParameters extends JavaScriptObject {
	
	protected PrintParameters() {}
	
	/**
	 * Creates a new PrintParameters object.
	 * 
	 * @return PrintParameters
	 */
	public static native PrintParameters create() /*-{
		return new $wnd.esri.tasks.PrintParameters();
	}-*/;

	/**
	 * The map to print.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getMap() /*-{
		return this.map;
	}-*/;
	
	/**
	 * Set the map parameter.
	 * 
	 * @param map - The map to print.
	 */
	public final void setMap(MapWidget map) {
		setMap(map.getMapObject());
	};
	
	/**
	 * Set the map parameter.
	 * 
	 * @param map - The map to print.
	 */
	public final native void setMap(JavaScriptObject map) /*-{
		this.map = map;
	}-*/;
	
	/**
	 * Defines the layout template used for the printed map.
	 * 
	 * @return PrintTemplate
	 */
	public final native PrintTemplate getPrintTemplate() /*-{
		return this.printTemplate;
	}-*/;
	
	/**
	 * Set the printTemplate parameter.
	 * 
	 * @param printTemplate - Defines the layout template used for the printed map.
	 */
	public final native void setPrintTemplate(PrintTemplate printTemplate) /*-{
		this.template = printTemplate;
	}-*/;

	
}
