package org.jrmerz.example.smartesri.client;

import com.esri.gwt.client.Graphic;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CpadRecord extends ListGridRecord {

	public CpadRecord() {}
	
	public void setCounty(String county) {
		setAttribute("county", county);
	}
	
	public String getCounty() {
		return getAttributeAsString("county");
	}
	
	public void setUnitName(String unitName) {
		setAttribute("unitName", unitName);
	}
	
	public String getUnitName() {
		return getAttributeAsString("unitName");
	}
	
	public void setAgencyId(String agencyId) {
		setAttribute("agencyId", agencyId);
	}
	
	public String getAgencyId() {
		return getAttributeAsString("agencyId");
	}
	
	public void setAgencyLevel(String agencyLevel) {
		setAttribute("agencyLevel", agencyLevel);
	}
	
	public String getAgencyLevel() {
		return getAttributeAsString("agencyLevel");
	}
	
	public void setAccess(String access) {
		setAttribute("access", access);
	}
	
	public String getAccess() {
		return getAttributeAsString("access");
	}
	
	public void setLayer(String layer) {
		setAttribute("layer", layer);
	}
	
	public String getLayer() {
		return getAttributeAsString("layer");
	}
	
	public void setGraphic(Graphic graphic) {
		setAttribute("graphic", graphic);
	}
	
	public Graphic getGraphic() {
		return (Graphic) getAttributeAsObject("graphic");
	}
	
}
