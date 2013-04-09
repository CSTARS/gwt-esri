package org.jrmerz.example.smartesri.client;

import com.esri.gwt.client.Error;
import com.esri.gwt.client.Graphic;
import com.esri.gwt.client.MapWidget;
import com.esri.gwt.client.Util;
import com.esri.gwt.client.Graphic.Attributes;
import com.esri.gwt.client.dojo.Color;
import com.esri.gwt.client.event.ClickHandler;
import com.esri.gwt.client.event.MapLoadHandler;
import com.esri.gwt.client.event.MouseEvent;
import com.esri.gwt.client.event.UpdateEndHandler;
import com.esri.gwt.client.event.UpdateStartHandler;
import com.esri.gwt.client.geometry.Point;
import com.esri.gwt.client.layers.ArcGISTiledMapServiceLayer;
import com.esri.gwt.client.layers.FeatureLayer;
import com.esri.gwt.client.symbol.SimpleFillSymbol;
import com.esri.gwt.client.symbol.SimpleLineSymbol;
import com.esri.gwt.client.symbol.SimpleLineSymbol.StyleType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

/**
 * This example shows how to use the gwt-esri library with another 3rd party
 * gwt library.  In this case SmartGwt.
 * 
 * To the point, this example shows CPAD (California Protected Areas Database)
 * as a ESRI ArcGIS feature service displayed using the gwt-esri library (FeatureLayer class).
 * The attributes of the returned graphics (Graphic: think geometry + style information + attributes)
 * are then displayed using the SmartGwt ListGrid.  Geometries can be selected
 * by clicking a row in the ListGrid or clicking on a Graphic on the map.
 * 
 * @author jrmerz
 */
public class SmartEsri implements EntryPoint {
	
	// main layout
	private VerticalPanel vp = new VerticalPanel();
	// the esri map
	private MapWidget mapWidget = null;
	// SmartGwt table
	private ListGrid table = new ListGrid();
	// CPAD feature layer
	private FeatureLayer fLayer = null;
	// loading panel
	private HTML loading = new HTML("Loading...");
	
	// currently selected record
	private CpadRecord selectedRecord = null;
	// line style for currently selected record
	private SimpleLineSymbol selectedOutline = SimpleLineSymbol.create(StyleType.STYLE_SOLID, Color.create("#2278DA"), 2);

	public void onModuleLoad() {
		
		vp.setStyleName("root");
		
		// add esri js packages to load
		Util.addRequiredPackage(Util.Package.ESRI_LAYERS_FEATURELAYER);
		// wait for esri js code to load before creating the map.
		Util.addEsriLoadHandler(new Runnable() {
			@Override
			public void run() {
				// create the map using esri's topo layer: http://www.arcgis.com/home/item.html?id=d5e02a0c1f2b4ec399823fdd3c2fdebd
				mapWidget = new MapWidget(
						ArcGISTiledMapServiceLayer.create("http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer"), 
						onMapLoad
				);
				
				// set the layout
				vp.add(mapWidget);
				vp.add(table);
				loading.setVisible(true);
				loading.setStyleName("loading");
				vp.add(loading);
				
				// add everything to DOM... this will trigger the loading of the MapWidget
				RootPanel.get().add(vp);
				RootPanel.getBodyElement().setClassName("tundra");
			}
		});
		
		initTable();
	}
	
	// this is basically the example from the SmartGWT Showcase: 
	//   http://www.smartclient.com/smartgwt/showcase/#grid_cell_widgets
	private void initTable() {
		table.setShowRecordComponents(true);
		table.setShowRecordComponentsByCell(true);
		table.setWidth("700px");
		table.setHeight("400px");
		table.setShowAllRecords(true);
		
		ListGridField nameField = new ListGridField("unitName", "Unit Name");
		ListGridField agencyIdField = new ListGridField("agencyId", "Agency Id");
		ListGridField agencyLevelField = new ListGridField("agencyLevel", "Agency Level");
		ListGridField accessField = new ListGridField("access", "Access");
		ListGridField countyField = new ListGridField("county", "County");
		ListGridField layerField = new ListGridField("layer", "Layer");

		
		table.addRecordClickHandler(new RecordClickHandler(){
			@Override
			public void onRecordClick(RecordClickEvent event) {
				selectRecord((CpadRecord) event.getRecord());
			}
		});
		
		table.setFields(nameField, agencyIdField, agencyLevelField, accessField, countyField, layerField);
		table.setCanResizeFields(true);
	}
	
	private MapLoadHandler onMapLoad = new MapLoadHandler(){
		@Override
		public void onLoad() {
			// set the map's size
			mapWidget.setSize("700px", "500px");
			
			// center map
			Point center = Point.create(-13523392.0,4660805.0, mapWidget.getSpatialReference());
			mapWidget.centerAndZoom(center, 13);

			
			// create a new feature layer
			FeatureLayer.Options options = FeatureLayer.Options.create();
			// fields to be return from arcgis server
			options.setOutFields(new String[] {"UNIT_NAME", "AGNCY_ID", "AGNCY_LEV", "ACCESS", "COUNTY", "LAYER"});
			// create the feature layer
			fLayer = FeatureLayer.create("http://myplan.casil.ucdavis.edu/ArcGIS/rest/services/Planning_Cadastre/CPAD/MapServer/0", options);
			// add layer to map
			mapWidget.addLayer(fLayer);
			// show the loading message whenever an update starts
			fLayer.addUpdateStartHandler(new UpdateStartHandler(){
				@Override
				public void onUpdateStart() {
					loading.setVisible(true);
				}
			});
			// add update handler for updating SmartGwt grid
			fLayer.addUpdateEndHandler(featureLayerUpdateHandler);
			// add click handler to select grid row when graphic is clicked
			fLayer.addClickHandler(graphicClickHandler);
		}
	};
	
	// graphic layer clickhandlers are only fired when a graphic is clicked
	private ClickHandler graphicClickHandler = new ClickHandler(){
		@Override
		public void onClick(MouseEvent event) {
			// get the graphic that was clicked
			Graphic g = event.getGraphic();
			// find the record of the graphic based on the graphic itself
			ListGridRecord[] records = table.getRecords();
			for( int i = 0; i < records.length; i++ ) {
				CpadRecord cr = (CpadRecord) records[i]; 
				if( cr.getGraphic() == g ) {
					// highlight and set row
					selectRecord(cr);
					// scroll to row
					table.scrollToRow(table.getRecordIndex(cr));
					return;
				}
			}
		}
	};
	
	// update the data grid whenever the feature layer finishes updating
	private UpdateEndHandler featureLayerUpdateHandler = new UpdateEndHandler() {
		@Override
		public void onUpdateEnd() {
			// grab all of the layers graphics
			JsArray<Graphic> graphics = fLayer.getGraphics();
			// create the new record array
			CpadRecord[] records = new CpadRecord[graphics.length()];
			// need to know if the currently selected graphic was returned in the new result set
			boolean foundSelectedRecord = false;
			for( int i = 0; i < graphics.length(); i++ ) {
				// create new table record for graphic
				records[i] = createCpadRecord(graphics.get(i));
				if( selectedRecord != null ) {
					// if new record is the selected graphic update the selectedRecord
					if( records[i].getGraphic() == selectedRecord.getGraphic() ) {
						foundSelectedRecord = true;
						selectedRecord = records[i];
					}
				}
			}
			
			// set data a draw
			table.setData(records);
			table.draw();
			
			// if there is no selected graphic, make sure the selectedGraphic is null
			// and that the graphic no longer has an outline
			if( !foundSelectedRecord ) {
				if( selectedRecord != null ) {
					selectedRecord.getGraphic().setSymbol(null);
					updateGraphic(selectedRecord.getGraphic());
				}
				selectedRecord = null;
			// if the selected record was found, update and scroll to the new row in the table
			} else {
				selectRecord(selectedRecord);
				table.scrollToRow(table.getRecordIndex(selectedRecord));
			}
			
			// done loading
			loading.setVisible(false);
		}
		@Override
		public void onError(Error error) {
			// done loading but sadness happend :(
			loading.setVisible(false);
		}
	};
	
	// set the attributes for the record if they exist in the graphics attributes
	private CpadRecord createCpadRecord(Graphic g) {
		CpadRecord cr = new CpadRecord();
		Attributes attrs = g.getAttributes();
		
		if( attrs.hasKey("UNIT_NAME") ) cr.setUnitName(attrs.getString("UNIT_NAME"));
		if( attrs.hasKey("AGNCY_ID") ) cr.setAgencyId(getCodedDomainValue(fLayer, "AGNCY_ID", attrs.getInt("AGNCY_ID")));
		if( attrs.hasKey("AGNCY_LEV") ) cr.setAgencyLevel(getCodedDomainValue(fLayer, "AGNCY_LEV", attrs.getInt("AGNCY_LEV")));
		if( attrs.hasKey("ACCESS") ) cr.setAccess(attrs.getString("ACCESS"));
		if( attrs.hasKey("COUNTY") ) cr.setCounty(getCodedDomainValue(fLayer, "COUNTY", attrs.getInt("COUNTY")));
		if( attrs.hasKey("LAYER") ) cr.setLayer(attrs.getString("LAYER"));
		
		cr.setGraphic(g);
		
		return cr;
	}
	
	private void selectRecord(CpadRecord record) {
		// if a previous record is selected, deselect it on the map and in the table 
		if( selectedRecord != null ) {
			// this feature layer has default renderers for each graphic, so setting the 
			// graphics symbol to null will use the default symbol
			selectedRecord.getGraphic().setSymbol(null);
			updateGraphic(selectedRecord.getGraphic());
			table.deselectRecord(selectedRecord);
		}		

		// again, this layer has default renderers for the graphics
		// we are going to poach the style as well as color, then add the 'selected' outline.
		SimpleFillSymbol layerFill = (SimpleFillSymbol) fLayer.getRenderer().getSymbol(record.getGraphic());
		
		// set the new style
		record.getGraphic().setSymbol(
				SimpleFillSymbol.create(layerFill.getStyle(), selectedOutline, layerFill.getColor())
		);

		// update the graphic and select a row
		selectedRecord = record;
		updateGraphic(selectedRecord.getGraphic());
		table.selectRecord(record);
	}
	
	// there may be a better way to do this....
	private void updateGraphic(Graphic g) {
		fLayer.remove(g);
		fLayer.add(g);
	}
	
	// you can ignore this for the most part.  Basically some of the values in the feature 
	// layer are returned as codedValue domain's.  The js api does not have a very nice way
	// to interact w/ these that I can tell, therefore neither does the gwt library.  At 
	// which point it's just easier to right this in jsni.
	private native String getCodedDomainValue(FeatureLayer fLayer, String field, int code) /*-{
		if( !fLayer.fields ) return code+"";
		for( var i in fLayer.fields ) {
			if( fLayer.fields[i].name == field ) {
				var domain = fLayer.fields[i].domain;
				if( !domain ) return code+"";
				if( !domain.codedValues ) return code+"";
				for( var j in domain.codedValues ) {
					if( domain.codedValues[j].code == code ) 
						return domain.codedValues[j].name;
				}
			} 
		}
		return code+"";
	}-*/;
	
}
