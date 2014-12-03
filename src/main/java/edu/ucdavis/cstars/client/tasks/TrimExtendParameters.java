package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Polyline;

/**
 * Sets the polylines and other parameters for the trimExtend operation.
 * 
 * @author Justin Merz
 */
public class TrimExtendParameters extends JavaScriptObject {
	
	public enum ExtendType {
		NOT_SET(-1),
		DEFAULT_CURVE_EXTENSION(0),
		RELOCATE_ENDS(1),
		KEEP_END_ATTRIBUTES(2),
		NO_END_ATTRIBUTES(4),
		NO_EXTEND_AT_FROM(8),
		NO_EXTEND_AT_TO(16);
		
		private int value = -1;
		ExtendType(int val){
			value = val;
		}
		public int getValue() {
			return value;
		}
	}
	
	protected TrimExtendParameters() {}
	
	/**
	 * Creates a new TrimExtendParameters object. 
	 * 
	 * @return Creates a new TrimExtendParameters object.
	 */
	public static native TrimExtendParameters create() /*-{
		return new $wnd.esri.tasks.TrimExtendParameters();
	}-*/;
	
	/**
	 * A flag used along with the trimExtend operation.
	 * 
	 * @return ExtendType
	 */
	public final ExtendType getExtendHow() {
		int eh = _getExtendHow();
		for( int i = 0 ; i < ExtendType.values().length; i++ ){
			if( ExtendType.values()[i].getValue() == eh )
				return ExtendType.values()[i];
		}
		return ExtendType.NOT_SET;
	}
	
	private final native int _getExtendHow() /*-{
		return this.extendHow;
	}-*/;
	
	/**
	 * Set the extend how parameter.
	 * 
	 * @param extendHow - A flag used along with the trimExtend operation.
	 */
	public final void setExtendHow(ExtendType extendHow) {
		_setExtendHow( extendHow.getValue() );
	}
	
	private final native void _setExtendHow(int extendHow) /*-{
		this.extendHow = extendHow;
	}-*/;
	
	/**
	 * The array of polylines to trim or extend. The structure of each geometry in the array is the same as the
	 * structure of the JSON polyline objects returned by the ArcGIS REST API.
	 * 
	 * @return JsArray<Polyline>
	 */
	public final native JsArray<Polyline> getPolylines() /*-{
		return this.polylines;
	}-*/;
	
	/**
	 * Set the polylines parameter.
	 * 
	 * @param polylines - The array of polylines to trim or extend. The structure of each geometry in the array
	 * is the same as the structure of the JSON polyline objects returned by the ArcGIS REST API.
	 */
	public final void setPolylines(Polyline[] polylines) {
		_setPolylines(Util.objectArrayToJSO(polylines));
	}
	
	private final native void _setPolylines(JavaScriptObject polylines) /*-{
		this.polylines = polylines;
	}-*/;
	
	/**
	 * A polyline used as a guide for trimming or extending input polylines. The structure of the polyline is the same as
	 * the structure of the JSON polyline object returned by the ArcGIS REST API.
	 * 
	 * @return Polyline
	 */
	public final native Polyline getTrimExtendTo() /*-{
		return this.trimExtendTo;
	}-*/;
	
	/**
	 * Set the trim extend to parameter.
	 * 
	 * @param trimExtendTo - A polyline used as a guide for trimming or extending input polylines. The structure of the
	 * polyline is the same as the structure of the JSON polyline object returned by the ArcGIS REST API.
	 */
	public final native void setTrimExtendTo(Polyline trimExtendTo) /*-{
		this.trimExtendTo = trimExtendTo;
	}-*/;

}
