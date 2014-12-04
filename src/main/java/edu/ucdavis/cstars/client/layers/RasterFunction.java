package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.JSObject;

/**
 * Specifies the processing to be done to the image service. 
 * 
 * @author Justin Merz
 */
public class RasterFunction extends JavaScriptObject {
	
	protected RasterFunction() {}

	/**
	 * Creates a new RasterFunction object.
	 * 
	 * @return RasterFunction
	 */
	public static native RasterFunction create() /*-{
		return new $wnd.esri.layers.RasterFunction();
	}-*/;
	
	/**
	 * Get the function arguments
	 * 
	 * @return JSObject
	 */
	public native final JSObject getArguments() /*-{
		if( this.arguments ) return this.arguments;
		return {};
	}-*/;
	
	/**
	 * Set the arguments
	 * 
	 * @param arguments - The argumens for the raster function. The structure depends
	 * on the function specified.
	 */
	public native final void setArguments(JSObject arguments) /*-{
		this.arguments = arguments;
	}-*/;
	
	/**
	 * The raster function name. View the Raster Functions documentation in the REST help for more details.
	 * 
	 * @return String
	 */
	public native final String getFunctionName() /*-{
		if( this.functionName ) return this.functionName;
		return "";
	}-*/;
	
	/**
	 * Set function name
	 * 
	 * @param functionName - The raster function name. View the Raster Functions documentation in the
	 * REST help for more details.
	 */
	public native final void setFunctionName(String functionName) /*-{
		this.functionName = functionName;
	}-*/;

	/**
	 * Variable name for the raster function.
	 * 
	 * @return String
	 */
	public native final String getVariableName() /*-{
		if( this.variableName ) return this.variableName;
		return "";
	}-*/;
	
	/**
	 * Set the variable name
	 * 
	 * @param variableName - Variable name for the raster function.
	 */
	public native final void setVariableName(String variableName) /*-{
		this.variableName = variableName;
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of the raster function. (As of v2.0)
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
}
