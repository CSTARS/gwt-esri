package edu.ucdavis.cstars.client.tasks;

/**
 * 
 * 
 * @author Justin Merz
 */
public enum NAOutputPolygon {
	NOT_SET(""),
	NONE("esriNAOutputPolygonNone"),
	DETAILED("esriNAOutputPolygonDetailed"),
	SIMPLIFIED("esriNAOutputPolygonSimplified");
	
	private String val = "";
	NAOutputPolygon(String value){
		val = value;
	}
	public String getValue() {
		return val;
	}
}
