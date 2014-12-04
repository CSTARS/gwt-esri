package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Fires when the relation operation is complete
 * 
 * @author Justin Merz
 */
public interface RelationHandler {
	
	/**
	 * 
	 * @param Relationships - Indices of the two input geometries that met the specified relationship. 
	 */
	public void onRelationComplete(JsArray<Relationship> Relationships);
	
	
	public static class Relationship extends JavaScriptObject {
		
		protected Relationship() {}
		
		public final native int getGeometry1Index() /*-{
			return this.geometry1Index;
		}-*/;
		
		public final native int getGeometry2Index() /*-{
			return this.geometry2Index
		}-*/;
		
	}

}
