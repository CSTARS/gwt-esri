package edu.ucdavis.cstars.client.tasks;

/**
 * Contstants representing how the geometry is returned. 
 * 
 * @author Justin Merz
 */
public enum NATravelDirection {
	NOT_SET(""),
	FROM_FACILITY("esriNATravelDirectionFromFacility"),
	TO_FACILITY("esriNATravelDirectionToFacility");
	
	private String val = "";
	NATravelDirection(String value){
		val = value;
	}
	public String getValue() {
		return val;
	}
}
