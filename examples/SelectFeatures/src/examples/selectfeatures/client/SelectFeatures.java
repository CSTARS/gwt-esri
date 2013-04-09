package examples.selectfeatures.client;

import com.esri.gwt.client.Error;
import com.esri.gwt.client.Graphic;
import com.esri.gwt.client.InfoTemplate;
import com.esri.gwt.client.MapWidget;
import com.esri.gwt.client.SpatialReference;
import com.esri.gwt.client.Util;
import com.esri.gwt.client.callback.SelectFeaturesCallback;
import com.esri.gwt.client.dojo.Color;
import com.esri.gwt.client.event.DrawEndHandler;
import com.esri.gwt.client.event.LayerLoadHandler;
import com.esri.gwt.client.event.MapLoadHandler;
import com.esri.gwt.client.geometry.Extent;
import com.esri.gwt.client.geometry.Geometry;
import com.esri.gwt.client.layers.ArcGISTiledMapServiceLayer;
import com.esri.gwt.client.layers.FeatureLayer;
import com.esri.gwt.client.layers.FeatureLayer.Modes;
import com.esri.gwt.client.layers.FeatureLayer.Selections;
import com.esri.gwt.client.layers.Layer;
import com.esri.gwt.client.symbol.SimpleFillSymbol;
import com.esri.gwt.client.symbol.SimpleLineSymbol;
import com.esri.gwt.client.symbol.SimpleLineSymbol.StyleType;
import com.esri.gwt.client.tasks.Query;
import com.esri.gwt.client.toolbars.Draw;
import com.esri.gwt.client.toolbars.Draw.Options;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SelectFeatures implements EntryPoint {

	private MapWidget mapWidget = null;
	private FeatureLayer aFeatureLayer;
	private Query queryTask;
	Draw selectionToolbar;
	private RootPanel root;

	public void onModuleLoad() {
		   // this enables the GWT Designer.
		   root = RootPanel.get();
		   
	       // many of the 2.0 packages must be told to load
	       Util.addRequiredPackage(Util.Package.ESRI_DIJIT_LEGEND);
	       Util.addRequiredPackage(Util.Package.ESRI_TOOLBARS_DRAW);
	       Util.addRequiredPackage(Util.Package.ESRI_LAYERS_FEATURELAYER);
	       Util.addEsriLoadHandler(onEsriLoad);
	}

	
	// Once the api is loaded you can create a map object and add it to a widget.
	// now add a final load handler for when the map is actually ready to go. This 
	// fires once your first layer has been created and setup by the api.  If you call
	// zoom/pan or many other map functions before this time, the code will error
	private Runnable onEsriLoad = new Runnable() {
		@Override
		public void run() {

			ArcGISTiledMapServiceLayer.Options mslOptions = ArcGISTiledMapServiceLayer.Options.create();
			mslOptions.setVisible(true);
			mslOptions.setOpacity(70);

			Layer layer = ArcGISTiledMapServiceLayer.create("http://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer", mslOptions);

			// As of v0.6 you can pass the first layer and the load handler
			// directly to the constructor.
			com.esri.gwt.client.MapWidget.Options mapOptions = com.esri.gwt.client.MapWidget.Options.create();
			Extent initialExtent = Extent.create(-97.5328, 37.4344, -97.2582, 37.64041, SpatialReference.create(4326));
			Extent initialWebMercator = (Extent) Geometry.geographicToWebMercator(initialExtent);
			mapOptions.setExtent(initialWebMercator);
			mapOptions.setNav(true);
			mapOptions.showSlider(true);
			mapWidget = new MapWidget(layer, onMapLoad, mapOptions);

			// this layout needs to be attached to the DOM, otherwise
			// map.addLoadHandler() and map.addLayer() will not work correctly
			root.add(mapWidget);	
		}
	};

	// now the map has loaded and you are ready to go
	private MapLoadHandler onMapLoad = new MapLoadHandler(){
	   @Override
	   public void onLoad() {
		   messages = new InlineLabel();
		   root.add(messages, 0, 445);
		   
		   mapWidget.getElement().addClassName("selectFeaturesMap");
		   initSelectToolbar();
	       onClientReady();
	   }
	};
	private InlineLabel messages;

    private void initSelectToolbar() {
		queryTask = Query.create();
		Options drawOptions = Options.create();
		drawOptions.setDrawTime(75);
		drawOptions.showTooltips(true);
		drawOptions.setTolerance(8);
		selectionToolbar = Draw.create(mapWidget, drawOptions);
		
		selectionToolbar.addDrawEndHandler(new DrawEndHandler() {
			
			@Override
			public void onDrawEnd(Geometry geometry) {
		          selectionToolbar.deactivate();
		          queryTask.setGeometry(geometry);
		          aFeatureLayer.selectFeatures(queryTask, FeatureLayer.Selections.SELECTION_NEW, new SelectFeaturesCallback() {
					
					@Override
					public void onSelectionComplete(JsArray<Graphic> features, Selections selectionMethod) {
						sumGasProduction(features, selectionMethod);
					}
					
					@Override
					public void onError(Error error) {
						String errorMsg = error.getMessage();
						throw new RuntimeException(errorMsg);
					}
				});					
			}
		});
		
		Button selectFeaturesButton = new Button("Select Features");
		selectFeaturesButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				_selectFeaturesClick(SelectFeatures.this.selectionToolbar);
			}
		});
		root.add(selectFeaturesButton);
		
		Button clearSelectionButton = new Button("Clear Selection");
		clearSelectionButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				aFeatureLayer.clearSelection();
				
			}
		});
		root.add(clearSelectionButton);		
        
      }
    private void sumGasProduction(JsArray<Graphic> features, Selections selectionMethod) {
        int productionSum = 0;
        //summarize the cumulative gas production to display 
        for(int i = 0; i < features.length(); i++) {
        	Graphic feature = features.get(i); 
        	productionSum += feature.getAttributes().getInt("CUMM_GAS");
        }
        messages.getElement().setInnerHTML("<b>Selected Fields Production: " + productionSum + " mcf. </b>");
      }

    private native final void _selectFeaturesClick(Draw theSelectionToolbar) /*-{
    	try {
    		theSelectionToolbar.activate($wnd.esri.toolbars.Draw.EXTENT);
    	} catch(e) {
    		$wnd.alert("Exception hit: "+e);   
    		throw e; 		
    	}
    }-*/;
		        
		public void onClientReady() {
		  // this fires when the mapClient is done loading (when the loading
		  // screen goes away).  You can now access the map using
		  // mapClient.getMapWidget() and add your own events and controls.

			InfoTemplate infoTemplate = InfoTemplate.create();
			infoTemplate.setTitle("${FIELD_NAME}");
			String content = "<b>Status</b>: ${STATUS}" +
            "<br><b>Cummulative Gas</b>: ${CUMM_GAS} MCF" +
            "<br><b>Total Acres</b>: ${APPROXACRE}" +
            "<br><b>Avg. Field Depth</b>: ${AVG_DEPTH} meters";
			infoTemplate.setContent(content);
			
			FeatureLayer.Options flo = FeatureLayer.Options.create();
			flo.setMode(Modes.MODE_ONDEMAND);
			flo.setInfoTemplate(infoTemplate);
			flo.setOutFields(new String[]{"*"});
			flo.setOpacity(100);
			aFeatureLayer = FeatureLayer.create("http://sampleserver3.arcgisonline.com/ArcGIS/rest/services/Petroleum/KSPetro/MapServer/1", flo);
			
			aFeatureLayer.setDefinitionExpression("PROD_GAS='Yes'");
			
			SimpleFillSymbol fieldsSelectionSymbol = SimpleFillSymbol.create();
			Color selectionFillColor = Color.create(255,255,0,0.5);
			fieldsSelectionSymbol.setColor(selectionFillColor);
			
			SimpleLineSymbol selectionOutlineSymbol = SimpleLineSymbol.create(StyleType.STYLE_DASHDOT, Color.create(255,0,0), 2);
	        fieldsSelectionSymbol.setOutline(selectionOutlineSymbol);			
			aFeatureLayer.setSelectionSymbol(fieldsSelectionSymbol);
			
			aFeatureLayer.addLoadHandler(new LayerLoadHandler() {
				
				@Override
				public void onLoad(Layer layer) {
					mapWidget.addLayer(aFeatureLayer);	
				}
			});		
		} 

}
