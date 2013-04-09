package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A geoprocessing data object containing a data source.
 * 
 * @author Justin Merz
 */
public class DataFile extends JavaScriptObject {
	
	protected DataFile() {}
	
	/**
	 * Creates a new DataFile object. The constructor takes no parameters.
	 * 
	 * @return DataFile
	 */
	public static native DataFile create() /*-{
		return new $wnd.esri.tasks.DataFile();
	}-*/;
	
	/**
	 * URL to the location of the data file.
	 * 
	 * @return String
	 */
	public final native String getUrl() /*-{
		return this.url;
	}-*/;

}
