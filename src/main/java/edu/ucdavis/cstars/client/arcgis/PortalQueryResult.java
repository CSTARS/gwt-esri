package edu.ucdavis.cstars.client.arcgis;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Details about the result of a query.
 * Class added v2.8
 * 
 * @author Justin Merz
 */
public class PortalQueryResult<T extends JavaScriptObject> extends JavaScriptObject {
	
	protected PortalQueryResult() {}
	
	/**
	 * The query parameters for the next set of results.
	 * 
	 * @return PortalQueryParams
	 */
	public final native PortalQueryParams getNextQueryParams() /*-{
		return this.nextQueryParams;
	}-*/;
	
	/**
	 * The query parameters for the first set of results.
	 * 
	 * @return PortalQueryParams
	 */
	public final native PortalQueryParams getQueryParams() /*-{
		return this.queryParams;
	}-*/;
	
	/**
	 * An array of result item objects.
	 * 
	 * @return JsArray<T>
	 */
	public final native JsArray<T> getResults() /*-{
		return this.results;
	}-*/;

	/**
	 * The total number of results. The maximum number of results is limited to 1000.
	 * 
	 * @return int
	 */
	public final native int getTotal() /*-{
		return this.total;
	}-*/;
	
}
