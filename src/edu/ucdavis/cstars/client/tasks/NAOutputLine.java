package edu.ucdavis.cstars.client.tasks;

/**
 * Contstants representing how the geometry is returned.
 * 
 * @author Justin Merz
 */
public enum NAOutputLine {
	NOT_SET(""),
	NONE("esriNAOutputLineNone"),
	STRIAGHT("esriNAOutputLineStraight"),
	TRUE_SHAPE("esriNAOutputLineTrueShape"),
	TRUE_SHAPE_WITH_MEASURE("esriNAOutputLineTrueShapeWithMeasure");
	
	private String val = "";
	NAOutputLine(String value){
		val = value;
	}
	public String getValue() {
		return val;
	}
}
