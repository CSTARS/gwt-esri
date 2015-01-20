package edu.ucdavis.cstars.client.arcgis;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Define parameters to use when querying
 * 
 * @author Justin Merz
 */
public class PortalQueryParams extends JavaScriptObject {
	
	public static enum SortField {
		NOT_SET(""),
		TITLE("title"),
		CREATED("created"),
		TYPE("type"),
		OWNER("owner"),
		AVG_RATING("avgRating"),
		NUM_RATINGS("numRatings"),
		NUM_COMMENTS("numComments"),
		NUM_VIEWS("numViews");
		private String val;
		private SortField(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
		public static SortField get(String sf) {
			sf = sf.replaceAll("\\s", ""); // clean
			for( int i = 0; i < SortField.values().length; i++ ) {
				if(  SortField.values()[i].getValue().contentEquals(sf) ) {
					return  SortField.values()[i];
				}
			}
			return  SortField.NOT_SET;
		}
	}

	protected PortalQueryParams() {}
	
	/**
	 * The maximum number of results to be included. The default value is 10 and the maximum allowed value is 100.
	 * 
	 * @return int
	 */
	public final native int getNum() /*-{
		return this.num;
	}-*/;
	
	/**
	 * Set the num parameter.
	 * 
	 * @param num - The maximum number of results to be included. The default value is 10 and the maximum allowed value is 100.
	 */
	public final native void setNum(int num) /*-{
		this.num = num;
	}-*/;

	/**
	 * The query string to search with.
	 * 
	 * @return String
	 */
	public final native String getQ() /*-{
		return this.q;
	}-*/;

	/**
	 * Set the q parameter.
	 * 
	 * @param q - The query string to search with.
	 */
	public final native void setQ(String q) /*-{
		this.q = q;
	}-*/;
	
	/**
	 * A list of field(s) to sort by.
	 * 
	 * @return SortField[]
	 */
	public final SortField[] getSortField() {
		String[] fields = _getSortField().split(",");
		SortField[] arr = new SortField[fields.length];
		for( int i = 0; i < fields.length; i++ ) {
			arr[i] = SortField.get(fields[i]);
		}
		return arr;
	}
	
	private final native String _getSortField() /*-{
		return this.sortField;
	}-*/;
	
	/**
	 * Set the sort field parameter.
	 * 
	 * @param sortField - A list of field(s) to sort by.
	 */
	public final void setSortField(SortField[] sortField) {
		String sortFields = "";
		for( int i = 0; i < sortField.length; i++ ) {
			sortFields += sortField[i].getValue();
			if( i - 1 < sortField.length ) sortFields += ",";
		}
		_setSortField(sortFields);
	}
	
	private final native void _setSortField(String sortField) /*-{
		this.sortField = sortField;
	}-*/;
	
	/**
	 * The number of the first entry in the result set response. The index number is 1-based. The start parameter, 
	 * along with the num parameter can be used to paginate the search results.
	 * 
	 * @return int
	 */
	public final native int getStart() /*-{
		return this.start;
	}-*/;
	
	/**
	 * Set the start parameter.
	 * 
	 * @param start - The number of the first entry in the result set response. The index number is 1-based. The 
	 * start parameter, along with the num parameter can be used to paginate the search results.
	 */
	public final native void setStart(int start) /*-{
		this.start = start;
	}-*/;
	
}
