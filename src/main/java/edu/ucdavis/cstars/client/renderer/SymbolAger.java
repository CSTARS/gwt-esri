package edu.ucdavis.cstars.client.renderer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * Base class for agers. Determine the symbology used to represent the aging of features in a feature layer.
 * 
 * @author Justin Merz
 */
public class SymbolAger extends JavaScriptObject {
	
	protected SymbolAger() {}

	/**
	 * All subclasses override this method to provide their own implementation to calculate aging and return the appropriate symbol
	 * 
	 * @param symbol - The symbol to age.
	 * @param graphic - Feature being rendered.
	 * @return Symbol
	 */
	public final native Symbol getAgedSymbol(Symbol symbol, Graphic graphic) /*-{
		return this.getAgedSymbol(symbol, graphic);
	}-*/;
	
}
