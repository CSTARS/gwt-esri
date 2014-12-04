package edu.ucdavis.cstars.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Graphic;

/**
 * Feature templates define the information required to create a new feature. 
 * 
 * @author Justin Merz
 */
public class FeatureTemplate extends JavaScriptObject {
	
	public static enum Tools {
		NOT_SET(""),
		TOOL_ARROW("esriFeatureEditToolArrow"),
		TOOL_AUTO_COMPLETE_POLYGON("esriFeatureEditToolAutoCompletePolygon"),
		TOOL_CIRCLE("esriFeatureEditToolCircle"),
		TOOL_ELLIPSE("esriFeatureEditToolEllipse"),
		TOOL_FREEHAND("esriFeatureEditToolFreehand"),
		TOOL_LINE("esriFeatureEditToolLine"),
		TOOL_NONE("esriFeatureEditToolNone"),
		TOOL_POINT("esriFeatureEditToolPoint"),
		TOOL_POLYGON("esriFeatureEditToolPolygon"),
		TOOL_RECTANGLE("esriFeatureEditToolRectangle"),
		TOOL_TRIANGLE("esriFeatureEditToolTriangle");
		private String val;
		private Tools(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	protected FeatureTemplate() {}
	
	/**
	 * The description of the template.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The default drawing tool defined for the template. 
	 * 
	 * @return Tools
	 */
	public final Tools getDrawingTool() {
		String dt = _getDrawingTool();
		for( int i = 0 ; i < Tools.values().length; i++ ){
			if( Tools.values()[i].getValue().contentEquals(dt) )
				return Tools.values()[i];
		}
		return Tools.NOT_SET;
	};
	
	private final native String _getDrawingTool() /*-{
		return this.drawingTool;
	}-*/;
	
	/**
	 * The templates name.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * An instance of the prototypical feature described by the template. It specifies 
	 * default values for the attribute fields and does not contain geometry.
	 * 
	 * @return Graphic
	 */
	public final native Graphic getPrototype() /*-{
		return this.prototype;
	}-*/;
	
	/**
	 * Converts object to its ArcGIS Server JSON representation.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
}
