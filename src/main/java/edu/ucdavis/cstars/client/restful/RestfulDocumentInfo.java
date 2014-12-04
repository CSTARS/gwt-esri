package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;

public class RestfulDocumentInfo extends JavaScriptObject {
	
	protected RestfulDocumentInfo() {}
	
	public final native String getTitle() /*-{
		return this.Title;
	}-*/;
	
	public final native String getAuthor() /*-{
		return ( this["Author"] ) ? this.Author : "";
	}-*/;
	
	public final native String getComments() /*-{
		return this.Comments;
	}-*/;
	
	public final native String getSubject() /*-{
		return this.Subject;
	}-*/;
	
	public final native String getCategory() /*-{
		return this.Category;
	}-*/;
	
	public final native String getKeywords() /*-{
		return this.Keywords;
	}-*/;

}
