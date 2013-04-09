package edu.ucdavis.cstars.client.tasks;

/**
 * Contstants representing how U-Turns are handled. 
 * 
 * @author Justin Merz
 */
public enum NAUTurn {
	NOT_SET(""),
	ALLOW_BACKTRACK("esriNFSBAllowBacktrack"),
	AT_DEAD_ENDS_ONLY("esriNFSBAtDeadEndsOnly"),
	NO_BACKTRACK("esriNFSBNoBacktrack");
	
	private String val = "";
	NAUTurn(String value){
		val = value;
	}
	public String getValue() {
		return val;
	}
}
