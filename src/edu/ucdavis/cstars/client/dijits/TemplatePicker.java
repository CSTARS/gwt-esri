package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.SelectionChangeHandler;
import edu.ucdavis.cstars.client.layers.FeatureLayer;
import edu.ucdavis.cstars.client.layers.FeatureTemplate;
import edu.ucdavis.cstars.client.layers.FeatureType;
import edu.ucdavis.cstars.client.symbol.Symbol;

/**
 * A template picker displays a gallery of templates from one or more feature layers.
 * For each template, a symbol and a label is displayed. Users can select or deselect
 * a symbol by clicking on the item.
 * 
 * @author Justin Merz
 */
public class TemplatePicker extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	protected JavaScriptObject jso;
	
	/**
	 * Creates a new TemplatePicker object that displays a gallery of templates
	 * from the input feature layers or items. A symbol and label is displayed
	 * for each template. The symbol is defined by the template's feature type.
	 * The label is the template's name.
	 * 
	 * @param params - FeatureLayers or items are required all other parameters
	 * are optional. See options list.
	 */
	public TemplatePicker(Parameters params) {
		
		if( !assertLoaded() ) return; 
		
		parameters = params;
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( jso == null ) jso = create(parameters);
			}
		});
		
	}
	
	private native JavaScriptObject create(Parameters params) /*-{
		return new $wnd.esri.dijit.TemplatePicker(params, this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::getElement()());
	}-*/;
	
	/**
	 * Check that the esri.dijit.TemplatePicker package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.TemplatePicker ) return true;
		$wnd.alert("The ESRI_DIJIT_TEMPLATEPICKER has not been loaded");
		return false;
	}-*/;

	// TODO: this is a dojo object
	/**
	 * Reference to the data grid used to display the templates.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getGrid() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.grid;
	}-*/;
	
	/**
	 * If tooltips are enabled the reference to the tooltip div.
	 * 
	 * @return Element
	 */
	public final native Element getTooltip() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.tooltip;
	}-*/;
	
	/**
	 * set the properties of the template picker. 
	 * 
	 * @param name - Name of the attribute of interest.
	 * @param value - Value for the specified attribute.
	 */
	public final native void setAttribute(String name, boolean value) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.attr(name, value);
	}-*/;

	/**
	 * set the properties of the template picker. 
	 * 
	 * @param name - Name of the attribute of interest.
	 * @param value - Value for the specified attribute.
	 */
	public final native void setAttribute(String name, int value) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.attr(name, value);
	}-*/;
	
	/**
	 * Clears the current selection.
	 */
	public final native void clearSelection() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.clearSelection();
	}-*/;
	
	/**
	 * Destroys the template picker. Call destroy() when the widget is no longer
	 * needed by the application.
	 */
	public void destroy() {
		_destroy();
		if( isAttached() ) removeFromParent();
	}

	private final native void _destroy() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.destroy();
	}-*/;
	
	/**
	 * Gets the selected item picked by the user.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject getSelected() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.getSelected();
	}-*/;

	/**
	 * Gets the selected item picked by the user.
	 * 
	 * @return JavaScriptObject
	 */
	public final native SelectedFeatureLayer getSelectedFeatureLayer() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.getSelected();
	}-*/;
	
	/**
	 * Gets the selected item picked by the user.
	 * 
	 * @return JavaScriptObject
	 */
	public final native SelectedItem getSelectedItem() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.getSelected();
	}-*/;
	
	/**
	 * Finalizes the creation of the template picker. Call startup() after creating the widget when
	 * you are ready for user interaction.
	 */
	public final native void startup() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.startup();
	}-*/;

	/**
	 * Updates the templatePicker after modifying the properties of the widget.
	 */
	public final native void update() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso.update();
	}-*/;
	
	/**
	 * 
	 * @param handler - Fires when an item is selected or unselected in the template picker. You can retrieve
	 * the selected item using the getSelected() method.
	 */
	public final native void addSelectionChangeHandler(SelectionChangeHandler handler ) /*-{
		$wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.TemplatePicker::jso,
		 	"onSelectionChange",
		 	function() {
		 		handler.@edu.ucdavis.cstars.client.event.SelectionChangeHandler::onSelectionChange()();
			}
		);
	}-*/;
	
	
	
	public static class Parameters extends JavaScriptObject {
		
		protected Parameters() {}
		
		public static Parameters create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 *  Specify "auto" to have the template picker automatically calculate
		 *  the number of columns based on the number of rows. Note: "auto" has
		 *  no effect when grouping is enabled.
		 */
		public final native void setAutoColumns() /*-{
			this["columns"] = "auto";
		}-*/;
		
		/**
		 * 
		 * @param columns - Number of visible columns. Default is three.
		 */
		public final native void setColumns(int columns) /*-{
			this["columns"] = columns;
		}-*/;
		
		/**
		 * 
		 * @param featureLayers - Array of input feature layers. The template picker displays
		 * the templates from each of the layer's in the array. Required to provide either
		 * featureLayers or items.
		 */
		public final void setFeatureLayers(FeatureLayer[] featureLayers) {
			JavaScriptObject arr = JavaScriptObject.createArray();
			for( int i = 0; i < featureLayers.length; i++ ) Util.addObjectToArray( featureLayers[i], arr);
			_setFeatureLayers( arr );
		}
		
		private final native void _setFeatureLayers(JavaScriptObject array) /*-{
			this["featureLayers"] = featureLayers;
		}-*/;
		
		/**
		 * Templates are grouped based on the containing feature layer.  Grouping is automatically disabled when
		 * items are specified instead of featureLayers. 
		 * 
		 * @param grouping - Default is true.
		 */
		public final native void setGrouping(boolean grouping) /*-{
			this["grouping"] = grouping;
		}-*/;
		
		/**
		 * Add to array of items. Use this option if you want to display a collection
		 * of symbols in the template picker.
		 * 
		 * @param label
		 * @param symbol
		 * @param description
		 */
		public final native void addItem(String label, Symbol symbol, String description ) /*-{
			if( !this.items ) this["items"] = [];
			this.items.push({ label: label, symbol: symbol, description: description });
		}-*/;
		
		/**
		 * 
		 * @param maxLabelLength - Length of label description. Default is to display the entire label.
		 * If the specified maxLabelLength is less than the number of characters in the label description
		 * the description is truncated.
		 */
		public final native void setMaxLabelLength(int maxLabelLength) /*-{
			this["maxLabelLength"] = maxLabelLength;
		}-*/;
		
		/**
		 * Specify "auto" to have the template picker automatically calculate the number of rows based
		 * on the number of columns. Note: "auto" has no effect when grouping is enabled.
		 */
		public final native void setAutoRows() /*-{
			this["rows"] = "auto";
		}-*/;
		
		/**
		 * 
		 * @param rows - Number of visible rows. Default is four.
		 */
		public final native void setRows(int rows) /*-{
			this["rows"] = rows;
		}-*/;
		
		/**
		 * 
		 * @param showTooltip - Tooltip content contains the template name and description. Default is false.
		 */
		public final native void showTooltip(boolean showTooltip) /*-{
			this["showTooltip"] = showTooltip;
		}-*/;
		
		/**
		 * 
		 * @param style - HTML style attributes for the widget. Specify as css text
		 */
		public final native void setStyle(String style) /*-{
			this["style"] = style;
		}-*/;
		
	}
	
	// TODO: this is a guess as to what is returned....
	public static class SelectedItem extends JavaScriptObject {
		
		protected SelectedItem() {}
		
		public final native String getLabel() /*-{
			return this.label;
		}-*/;
		
		public final native Symbol getSymbol() /*-{
			return this.symbol;
		}-*/;
		
		public final native String getDescription() /*-{
			return this.description;
		}-*/;
		
	}
	
	public static class SelectedFeatureLayer extends JavaScriptObject {
		
		protected SelectedFeatureLayer() {}
		
		public final native FeatureLayer getFeatureLayer() /*-{
			return this.featureLayer;
		}-*/;
		
		public final native FeatureType getType() /*-{
			return this.type;
		}-*/;
		
		public final native FeatureTemplate getTemplate() /*-{
			return this.template;
		}-*/;
	}
	
}
