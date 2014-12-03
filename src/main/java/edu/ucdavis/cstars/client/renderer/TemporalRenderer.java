package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * Temporal renderers provide time-based rendering of features in a feature layer. It can be useful to visualize historic or
 * real-time data such as earthquake or hurricane occurances. You can use a temporal renderer to define how observations
 * (regular, historic, latest) and tracks are rendered. You can also show aging of features with respect to the map's time extent.
 * 
 * @author Justin Merz
 */
public class TemporalRenderer extends JavaScriptObject {
	
	protected TemporalRenderer() {}
	
	/**
	 * Creates a new TemporalRenderer object that can be used with a time-aware feature layer.
	 * 
	 * @param observationRenderer - Renderer for regular/historic observations.
	 * @return TemporalRenderer
	 */
	public static native TemporalRenderer create(Renderer observationRenderer) /*-{
		return new $wnd.esri.renderer.TemporalRenderer(observationRenderer, null, null, null);
	}-*/;
	
	/**
	 * Creates a new TemporalRenderer object that can be used with a time-aware feature layer.
	 * 
	 * @param observationRenderer - Renderer for regular/historic observations. Required.
	 * @param latestObservationRenderer - Renderer for the most current observations. Optional.
	 * @param trackRenderer - Renderer for the tracks. A track is a collection of events that share a common track ID. A track line is a
	 * graphic line that connects the observations. Applicable only for feature layers with a valid trackIdField. Optional.
	 * @param observationAger - Symbol ager for regular observations. Optional.
	 * @return TemporalRenderer
	 */
	public static native TemporalRenderer create(Renderer observationRenderer, Renderer latestObservationRenderer,
			Renderer trackRenderer, SymbolAger observationAger ) /*-{
		return new $wnd.esri.renderer.TemporalRenderer(observationRenderer, latestObservationRenderer,  trackRenderer, observationAger);
	}-*/;

	/**
	 * Returns the symbol used to render the graphic.
	 * 
	 * @param graphic - The input graphic.
	 * @return Symbol
	 */
	public final native Symbol getSymbol(Graphic graphic) /*-{
		return this.getSymbol(graphic);
	}-*/;
	
}
