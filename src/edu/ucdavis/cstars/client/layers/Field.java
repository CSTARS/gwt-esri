package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Information about each field in a layer. 
 * 
 * @author Justin Merz
 */
public class Field extends JavaScriptObject {
	
	public static enum Types {
		NOT_SET(""),
		TYPE_SMALL_INTEGER("esriFieldTypeSmallInteger"),
		TYPE_INTEGER("esriFieldTypeInteger"),
		TYPE_SINGLE("esriFieldTypeSingle"),
		TYPE_DOUBLE("esriFieldTypeDouble"),
		TYPE_STRING("esriFieldTypeString"),
		TYPE_DATE("esriFieldTypeDate"),
		TYPE_OID("esriFieldTypeOID"),
		TYPE_GEOMETRY("esriFieldTypeGeometry"),
		TYPE_BLOB("esriFieldTypeBlob"),
		TYPE_RASTER("esriFieldTypeRaster"),
		TYPE_GUID("esriFieldTypeGUID"),
		TYPE_GLOBALID("esriFieldTypeGlobalID"),
		TYPE_XML("esriFieldTypeXML");
		private String val;
		private Types(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected Field() {}
	
	/**
	 * The alias name for the field.
	 * 
	 * @return String
	 */
	public final native String getAlias() /*-{
		return this.alias;
	}-*/;
	
	/**
	 * Domain associated with the field.
	 * 
	 * @return Domain
	 */
	public final native Domain getDomain() /*-{
		return this.domain;
	}-*/;
	
	/**
	 * Indicates whether the field is editable.
	 * 
	 * @return boolean
	 */
	public final native boolean isEditable() /*-{
		return this.editable;
	}-*/;
	
	/**
	 * The field length
	 * 
	 * @return int
	 */
	public final native int getLength() /*-{
		return this.length;
	}-*/;
	
	/**
	 * The name of the field
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;

	/**
	 * Indicates if the field can accept null values. Requires ArcGIS Server version 10.1 or greater. (As of v2.6)
	 * 
	 * @return boolean
	 */
	public final native boolean isNullable() /*-{
		return this.nullable;
	}-*/;
	
	/**
	 * The data type of the field. 
	 * 
	 * @return Types
	 */
	public final Types getType() {
		String t = _getType();
		for( int i = 0 ; i < Types.values().length; i++ ){
			if( Types.values()[i].getValue().contentEquals(t) )
				return Types.values()[i];
		}
		return Types.NOT_SET;	
	};
	
	private final native String _getType() /*-{
		return this.type;
	}-*/;

}
