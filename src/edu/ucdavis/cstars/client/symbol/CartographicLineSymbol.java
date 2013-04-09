package edu.ucdavis.cstars.client.symbol;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.dojo.Color;

/**
 * Line symbols are used to draw linear features on the graphics layer. CartographicLineSymbol, like SimpleLineSymbol,
 * is either a solid line or a predefined pattern of dashes and dots. Line joins and line caps can be added to further
 * define the line symbol.
 * 
 * @author Justin Merz
 */
public class CartographicLineSymbol extends SimpleLineSymbol {
	
	public static enum CapType {
		NOT_SET(""),
		CAP_BUTT("butt"),
		CAP_SQUARE("round"),
		CAP_ROUND("square");
		private String val;
		private CapType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum JoinType {
		NOT_SET(""),
		JOIN_BUTT("bevel"),
		JOIN_SQUARE("miter"),
		JOIN_ROUND("round");
		private String val;
		private JoinType(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected CartographicLineSymbol() {}
	
	/**
	 * Creates a new empty CartographicLineSymbol object.
	 * 
	 * @return CartographicLineSymbol
	 */
	public static native CartographicLineSymbol create() /*-{
		return new $wnd.esri.symbol.CartographicLineSymbol();
	}-*/;
	
	/**
	 * Creates a new CartographicLineSymbol object using a JSON object.
	 * 
	 * @param json - JSON object representing the CartographicLineSymbol.
	 * @return CartographicLineSymbol
	 */
	public static native CartographicLineSymbol create(JavaScriptObject json) /*-{
		return new $wnd.esri.symbol.CartographicLineSymbol(json);
	}-*/;

	/**
	 * Creates a new CartographicLineSymbol object with parameters.
	 * 
	 * @param style - symbol style
	 * @param color - symbol color
	 * @param width - Width of line in pixels.
	 * @param cap - Line cap.
	 * @param join - Line join. 
	 * @param miterLimit - Size threshold for showing mitered line joins.
	 * @return CartographicLineSymbol
	 */
	public static CartographicLineSymbol create(StyleType style, Color color, int width, CapType cap, JoinType join,int miterLimit ) {
		return _create(style.getValue(), color, width, cap.getValue(), join.getValue(), miterLimit);
	}
		
	private static native CartographicLineSymbol _create(String style, Color color, int width, String cap, String join, int miterLimit) /*-{
		return new $wnd.esri.symbol.CartographicLineSymbol(style, color, width, cap, join, miterLimit);
	}-*/;
	
	/**
	 * The cap style. The default value is CAP_BUTT.
	 * 
	 * @return CapType
	 */
	public final CapType getCap() {
		String c = _getCap();
		for( int i = 0 ; i < CapType.values().length; i++ ){
			if( CapType.values()[i].getValue().contentEquals(c) )
				return CapType.values()[i];
		}
		return CapType.NOT_SET;
	};
	
	private final native String _getCap() /*-{
		return this.cap;
	}-*/;
	
	/**
	 * The join style. The default value is JOIN_MITER.
	 * 
	 * @return JoinType
	 */
	public final JoinType getJoin() {
		String j = _getJoin();
		for( int i = 0 ; i < JoinType.values().length; i++ ){
			if( JoinType.values()[i].getValue().contentEquals(j) )
				return JoinType.values()[i];
		}
		return JoinType.NOT_SET;
	};
	
	private final native String _getJoin() /*-{
		return this.join;
	}-*/;
	
	/**
	 * Size threshold for showing mitered line joins.
	 * 
	 * @return int
	 */
	public final native int getMiterLimit() /*-{
		return this.miterLimit;
	}-*/;
	
	/**
	 * Sets the cap style.
	 * 
	 * @param cap - Cap style.
	 * @return CartographicLineSymbol
	 */
	public final CartographicLineSymbol setCap(CapType cap) {
		return _setCap(cap.getValue());
	};
	
	private final native CartographicLineSymbol _setCap(String cap) /*-{
		return this.setCap(cap);
	}-*/;
	
	/**
	 * Sets the join style.
	 * 
	 * @param join - Join style.
	 * @return CartographicLineSymbol
	 */
	public final CartographicLineSymbol setJoin(JoinType join) {
		return _setJoin(join.getValue());
	};
	
	private final native CartographicLineSymbol _setJoin(String join) /*-{
		return this.setCap(cap);
	}-*/;
	
	/**
	 * Sets the size threshold for showing mitered line joins.
	 * 
	 * @param miterLimit - Miter limit.
	 * @return CartographicLineSymbol
	 */
	public final native CartographicLineSymbol setMiterLimit(int miterLimit) /*-{
		return this.setMiterLimit(cap);
	}-*/;
	
}
