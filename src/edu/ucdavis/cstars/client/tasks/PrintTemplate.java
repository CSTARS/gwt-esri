package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ucdavis.cstars.client.Util;

/**
 * Class added v2.6
 * Define the layout template options used by the PrintTask and Print widget to generate the print page.
 * 
 * @author Justin Merz
 */
public class PrintTemplate extends JavaScriptObject {
	
	public static enum Format {
		PDF("pdf"),
		PNG_32("png32"),
		PNG_8("png8"),
		JPG("jpg"),
		GIF("gif"),
		EPS("eps"),
		SVG("svg"),
		SVGZ("svgz"),
		UNKNOWN("");
		private String val = "";
		Format(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
		public static Format get(String f) {
			for( int i = 0; i < Format.values().length; i++ ){
				if( Format.values()[i].getValue().contentEquals(f) )
					return Format.values()[i];
			}
			return Format.UNKNOWN;
		}
	}
	
	public static enum Layout {
		MAP_ONLY("MAP_ONLY"),
		A3_LANDSCAPE("A3 Landscape"),
		A3_PORTRAIT("A3 Portrait"),
		A4_LANDSCAPE("A4 Landscape"),
		A4_PORTRAIT("A4 Portrait"),
		LETTER_ANSI_A_LANDSCAPE("Letter ANSI A Landscape"),
		LETTER_ANSI_A_PORTRAIT("Letter ANSI A Portrait"),
		TABLOID_ANSI_B_LANSCAPE("Tabloid ANSI B Landscape"),
		TABLOID_ANSI_B_PORTRAIT("Tabloid ANSI B Portrait"),
		UNKNOWN("");
		private String val = "";
		Layout(String value){
			val = value;
		}
		public String getValue() {
			return val;
		}
		public static Layout get(String l) {
			for( int i = 0; i < Layout.values().length; i++ ){
				if( Layout.values()[i].getValue().contentEquals(l) )
					return Layout.values()[i];
			}
			return Layout.UNKNOWN;
		}
	}
	
	protected PrintTemplate() {}
	
	/**
	 * Creates a new PrintTemplate object.
	 * 
	 * @return
	 */
	public static native PrintTemplate create() /*-{
		return new $wnd.esri.tasks.PrintTemplate();
	}-*/;
	
	/**
	 * Define the map width, height and dpi. Required when the layoutTemplate is set to 'MAP_ONLY'.
	 * 
	 * @return ExportOptions
	 */
	public final native ExportOptions getExportOptions() /*-{
		return this.exportOptions;
	}-*/;
	
	/**
	 * Set the exportOptions parameter.
	 * 
	 * @param exportOptions - Define the map width, height and dpi. Required when the layoutTemplate 
	 * is set to 'MAP_ONLY'.
	 */
	public final native void setExportOptions(ExportOptions exportOptions) /*-{
		this.exportOptions = exportOptions;
	}-*/;
	
	/**
	 * The print output format.
	 * 
	 * @return Format
	 */
	public final Format getFormat() {
		return Format.get(_getFormat());
	};
	
	private final native String _getFormat() /*-{
		return this.format;
	}-*/;
	
	/**
	 * Set the format parameter.
	 * 
	 * @param format - The print output format.
	 */
	public final void setFormat(Format format) {
		_setFormat(format.getValue());
	}
	
	/**
     * Set the format parameter.
     * 
     * @param format - The print output format.
     */
    public final void setFormat(String format) {
        _setFormat(format);
    }
	
	private final native void _setFormat(String format) /*-{
		this.format = format;
	}-*/;
	
	/**
	 * The text that appears on the PrintWidget's print button.
	 * 
	 * @return String
	 */
	public final native String getLabel() /*-{
		return this.label;
	}-*/;
	
	/**
	 * Set the label parameter.
	 * 
	 * @param label - The text that appears on the PrintWidget's print button.
	 */
	public final native void setLabel(String label) /*-{
		this.label = label;
	}-*/;
	
	/**
	 * The layout used for the print output. 
	 * 
	 * @return Layout
	 */
	public final Layout getLayout() {
		return Layout.get(getLayoutAsString());
	};
	
	/**
	 * The layout used for the print output. 
	 * 
	 * @return String
	 */
	public final native String getLayoutAsString() /*-{
		return this.layout;
	}-*/;
	
	
	/**
	 * Set the layout parameter.
	 * 
	 * @param layout - The layout used for the print output. 
	 */
	public final void setLayout(Layout layout) {
		setLayout(layout.getValue());
	}
	
	/**
	 * Set the layout parameter.
	 * 
	 * @param layout - The layout used for the print output. 
	 */
	public final native void setLayout(String layout) /*-{
		this.layout = layout;
	}-*/;
	
	/**
	 * Define the layout elements.
	 * 
	 * @return LayoutOptions
	 */
	public final native LayoutOptions getLayoutOptions() /*-{
		return this.layoutOptions;
	}-*/;
	
	/**
	 * Set the layoutOptions parameter.
	 * 
	 * @param layoutOptions - Define the layout elements.
	 */
	public final native void setLayoutOptions(LayoutOptions layoutOptions) /*-{
		this.layoutOptions = layoutOptions;
	}-*/;
	
	/**
	 * Define whether the printed map will preserve the map scale or the map extent. Only one of these properties 
	 * can be preserved to produce a high-resolution map for printing. If preserveScale is set to true, the map 
	 * displayed in the print window will match the current scale of the map in the application. If preserveScale 
	 * is false, the current extent of the map in the application displays in the printed map but the scale may 
	 * change. The default value is true.
	 * 
	 * @return boolean
	 */
	public final native boolean preserveScale() /*-{
		return this.preserveScale;
	}-*/;
	
	/**
	 * Set the preserveScale parameter.
	 * 
	 * @param preserveScale - Define whether the printed map will preserve the map scale or the map extent. Only one 
	 * of these properties can be preserved to produce a high-resolution map for printing. If preserveScale is set to 
	 * true, the map displayed in the print window will match the current scale of the map in the application. If 
	 * preserveScale is false, the current extent of the map in the application displays in the printed map but 
	 * the scale may change. The default value is true.
	 */
	public final native void setPreserveScale(boolean preserveScale) /*-{
		this.preserveScale = preserveScale;
	}-*/;
	
	
	public static class LayoutOptions extends JavaScriptObject {
		
		protected LayoutOptions() {}
		
		public static LayoutOptions create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * Set the titleText parameter.
		 * 
		 * @param titleText - The text used for the map title if the specified layout contains a title text element.
		 */
		public final native void setTitleText(String titleText) /*-{
			this["titleText"] = titleText;
		}-*/;
		
		/**
		 * Set the authorText parameter.
		 * 
		 * @param authorText - The text used for the author if the specified layout contains an author text element.
		 */
		public final native void setAuthorText(String authorText) /*-{
			this["authorText"] = authorText;
		}-*/;
		
		/**
		 * Set the copyrightText parameter.
		 * 
		 * @param copyrightText - The text used for the copyright if the specified layout contains an copyright text element.
		 */
		public final native void setCopyrightText(String copyrightText) /*-{
			this["copyrightText"] = copyrightText;
		}-*/;
		
		/**
		 * Set the scalebarUnit parameter.
		 * 
		 * @param scalebarUnit - The units used for the scalebar. Valid values are 'Miles' | 'Kilometers' | 'Meters' | 'Feet'
		 */
		public final native void setScalebarUnit(String scalebarUnit) /*-{
			this["scalebarUnit"] = scalebarUnit;
		}-*/;
		
		public final native void setCustomTextElement(String parameter, String value) /*-{
		    if( !this.customTextElements ) this.customTextElements = [];
		    var obj ={};
		    obj[parameter] = value;
		    this.customTextElements.push(obj);
		}-*/;
		
		/**
		 * Set the legendLayers parameter.
		 * 
		 * @param legendLayers - An array of strings containing the id's of the layers that will be included in the legend. If 
		 * legendLayers is not specified, all operational layers will be present in the legend. To specify that no layers will 
		 * be included in the legend set legendLayers to an empty array.
		 */
		public final void setLegendLayers(String[] legendLayers) {
			_setLegendLayers(Util.stringArrayToJSO(legendLayers));
		};
		
		private final native void _setLegendLayers(JavaScriptObject legendLayers) /*-{
			this["legendLayers"] = legendLayers;
		}-*/;
		
	}
	
	
	public static class ExportOptions extends JavaScriptObject {
		
		protected ExportOptions() {}
		
		/**
		 * 
		 * @param width - print map width
		 * @param height - print map height
		 * @param dpi
		 * @return
		 */
		public static native ExportOptions create(int width, int height, int dpi) /*-{
			return {"width":width,"height":height,"dpi":dpi};
		 }-*/;
		
		public final native int getWidth() /*-{
			return this.width;
		}-*/;
		
		public final native int getHeight() /*-{
			return this.height;
		}-*/;
		
		public final native int getDpi() /*-{
			return this.dpi;
		}-*/;
		
	}
	
}
