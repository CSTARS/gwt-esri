package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.geometry.Point;

/**
 * Specifies the mosaic rule when defining how individual images should be mosaicked. It specifies selection, mosaic method, 
 * sort order, overlapping pixel resolution, etc. Mosaic rules are for mosaicking rasters in the mosaic dataset. A mosaic rule 
 * is used to define:
 * 
 * -The selection of rasters that will participate in the mosaic (using where clause).
 * -The mosaic method, e.g. how the selected rasters are ordered.
 * -The mosaic operation, e.g. how overlapping pixels at the same location are resolved.
 * 
 * @author Justin Merz
 */
public class MosaicRule extends JavaScriptObject  {
	
	public static enum Methods {
		NOT_SET(""),
		METHOD_ATTRIBUTE("esriMosaicAttribute"),
		METHOD_CENTER("esriMosaicCenter"),
		METHOD_LOCKRASTER("esriMosaicLockRaster"),
		METHOD_NADIR("esriMosaicNadir"),
		METHOD_NONE("esriMosaicNone"),
		METHOD_NORTHWEST("esriMosaicNorthwest"),
		METHOD_SEAMLINE("esriMosaicSeamline"),
		METHOD_VIEWPOINT("esriMosaicViewpoint");
		private String val;
		private Methods(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum Operations {
		NOT_SET(""),
		OPERATION_BLEND("MT_BLEND"),
		OPERATION_FIRST("MT_FIRST"),
		OPERATION_LAST("MT_LAST"),
		OPERATION_MAX("MT_MAX"),
		OPERATION_MEAN("MT_MEAN"),
		OPERATION_MIN("MT_MIN");
		private String val;
		private Operations(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected MosaicRule() {}

	/**
	 * Creates a new MosaicRule object
	 * 
	 * @return MosaicRule
	 */
	public static native MosaicRule create() /*-{
		return new $wnd.esri.layers.MosaicRule();
	}-*/;
	
	/**
	 * Indicates whether the sort should be ascending or not.
	 * 
	 * @return boolean
	 */
	public final native boolean isAscending() /*-{
		return this.ascending;
	}-*/;
	
	/**
	 * Set sort type
	 * 
	 * @param ascending - Indicates whether the sort should be ascending or not.
	 */
	public final native void setAscending(boolean ascending) /*-{
		this.ascending = ascending;
	}-*/;
	
	/**
	 * An array of raster Ids. All the rasters with the given list of raster Ids are selected to participate in the mosaic.
	 * The rasters will be visible at all pixel sizes regardless of the minimum and maximum pixel size range of the locked rasters.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getLockRasterIds() /*-{
		return this.lockRasterIds;
	}-*/;

	/**
	 * Add raster id to participate in the mosaic
	 * 
	 * @param id - id of raster
	 */
	public final native void addLockRasterId(int id) /*-{
		this.lockRasterIds.push(id);
	}-*/;
	
	/**
	 * clear the list of locked raster ids.
	 */
	public final native void clearLockRasterIds() /*-{
		this.lockRasterIds = [];
	}-*/;
	
	/**
	 * The mosaic method determines how the selected rasters are ordered.
	 * 
	 * @return Methods
	 */
	public final Methods getMethod() {
		String m = _getMethod();
		for( int i = 0 ; i < Methods.values().length; i++ ){
			if( Methods.values()[i].getValue().contentEquals(m) )
				return Methods.values()[i];
		}
		return Methods.NOT_SET;
	};
	
	private final native String _getMethod() /*-{
		return this.method;
	}-*/;
	
	/**
	 * Set mosaic method
	 * 
	 * @param method - The mosaic method determines how the selected rasters are ordered.
	 */
	public final void setMethod(Methods method) {
		_setMethod(method.getValue());
	}
	
	private final native void _setMethod(String method) /*-{
		this.method = method;
	}-*/;

	/**
	 * Defines a selection using a set of ObjectIds. This property applies to all mosaic methods.
	 * 
	 * @return JsArrayInteger
	 */
	public final native JsArrayInteger getObjectIds() /*-{
		return this.objectIds;
	}-*/;
	
	/**
	 * Set the objectIds parameter.
	 * 
	 * @param objectIds -  Defines a selection using a set of ObjectIds. This property applies to 
	 * all mosaic methods.
	 */
	public final void setObjectIds(int[] objectIds) {
		_setObjectIds(Util.intArrayToJSO(objectIds));
	}
	
	private final native void _setObjectIds(JavaScriptObject objectIds) /*-{
		this.objectIds = objectIds;
	}-*/;
	
	/**
	 * Defines the mosaic operation used to resolve overlapping pixels. 
	 * 
	 * @return String
	 */
	public final Operations getOperation() {
		String o = _getOperation();
		for( int i = 0 ; i < Operations.values().length; i++ ){
			if( Operations.values()[i].getValue().contentEquals(o) )
				return Operations.values()[i];
		}
		return Operations.NOT_SET;
	};
	
	private final native String _getOperation() /*-{
		return this.operation;
	}-*/;
	
	/**
	 * Set the operation.
	 * 
	 * @param operation - Defines the mosaic operation used to resolve overlapping pixels. 
	 */
	public final void setOperation(Operations operation) {
		_setOperation(operation.getValue());
	}
	
	private final native void _setOperation(String operation) /*-{
		this.operation = operation;
	}-*/;
	
	/**
	 * The name of the attribute field that is used together with a constant sortValue to define
	 * the mosaicking order when the mosaic method is set to METHOD_ATTRIBUTE.
	 * 
	 * @return String
	 */
	public final native String getSortField() /*-{
		return this.sortField;
	}-*/;
	
	/**
	 * Set the sortField value.
	 * 
	 * @param sortField - The name of the attribute field that is used together with a constant sortValue
	 * to define the mosaicking order when the mosaic method is set to METHOD_ATTRIBUTE.
	 */
	public final native void setSortField(String sortField) /*-{
		this.sortField = sortField;
	}-*/;
	
	/**
	 * A constant value defining a reference or base value for the sort field when the mosaic method is set
	 * to METHOD_ATTRIBUTE.
	 * 
	 * @return String
	 */
	public final native String getSortValue() /*-{
		return this.sortValue;
	}-*/;
	
	/**
	 * Set the sortValue.
	 * 
	 * @param sortValue - A constant value defining a reference or base value for the sort field when the
	 * mosaic method is set to METHOD_ATTRIBUTE.
	 */
	public final native void setSortValue(String sortValue) /*-{
		this.sortValue = sortValue;
	}-*/;

	/**
	 * Defines the viewpoint location on which the ordering is defined based on the distance from the viewpoint
	 * and the nadir of rasters.
	 * 
	 * @return String
	 */
	public final native Point getViewPoint() /*-{
		return this.viewpoint;
	}-*/;
	
	/**
	 * Set the viewPoint value.
	 * 
	 * @param viewPoint - Defines the viewpoint location on which the ordering is defined based on the distance
	 * from the viewpoint and the nadir of rasters.
	 */
	public final native void setViewPoint(Point viewPoint) /*-{
		this.viewpoint = viewpoint;
	}-*/;
	
	/**
	 * The where clause determines which rasters will participate in the mosaic. This property applies to all mosaic methods.
	 * 
	 * @return String
	 */
	public final native String getWhere() /*-{
		return this.where;
	}-*/;
	
	/**
	 * Set the where value.
	 * 
	 * @param where - The where clause determines which rasters will participate in the mosaic. This property applies to all
	 * mosaic methods.
	 */
	public final native void setWhere(String where) /*-{
		this.where = where;
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of the mosaic rule. (As of v2.0)
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
}
