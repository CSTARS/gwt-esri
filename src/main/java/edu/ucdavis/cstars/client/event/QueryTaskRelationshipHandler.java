package edu.ucdavis.cstars.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

import edu.ucdavis.cstars.client.tasks.FeatureSet;

/**
 * Fires when the executeRelationshipQuery is complete
 * 
 * @author Justin Merz
 */
public interface QueryTaskRelationshipHandler {

	/**
	 * 
	 * @param relatedFeatureSets - Object containing a FeatureSet for each related feature. Each feature is accessible by its object id.
	 */
	public void onExecuteForIdsComplete(RelatedFeatureSets relatedFeatureSets);
	
	
	public static class RelatedFeatureSets extends JavaScriptObject {
		
		protected RelatedFeatureSets() {}
		
		public final native JsArrayString getIds() /*-{
			var keys = [];
			for( var key in this ) keys.push(key);
			return keys;
		}-*/;
		
		public final native FeatureSet getFeatureSetById(String id) /*-{
			if( this[id] ) return id;
			return {};
		}-*/;
		
		public final native boolean hasId(String id) /*-{
			if( this[id] ) return true;
			return false;
		}-*/;
	}
}
