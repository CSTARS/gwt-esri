package edu.ucdavis.cstars.client.layers;


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.FormPanel;

import edu.ucdavis.cstars.client.Graphic;
import edu.ucdavis.cstars.client.InfoTemplate;
import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.callback.AddAttachmentCallback;
import edu.ucdavis.cstars.client.callback.ApplyEditsCallback;
import edu.ucdavis.cstars.client.callback.DeleteAttachmentsCallback;
import edu.ucdavis.cstars.client.callback.QueryAttachmentInfosCallback;
import edu.ucdavis.cstars.client.callback.QueryCountCallback;
import edu.ucdavis.cstars.client.callback.QueryFeaturesCallback;
import edu.ucdavis.cstars.client.callback.QueryIdsCallback;
import edu.ucdavis.cstars.client.callback.QueryRelatedFeaturesCallback;
import edu.ucdavis.cstars.client.callback.SelectFeaturesCallback;
import edu.ucdavis.cstars.client.dojo.Deferred;
import edu.ucdavis.cstars.client.event.AddAttachmentHandler;
import edu.ucdavis.cstars.client.event.ApplyEditsHandler;
import edu.ucdavis.cstars.client.event.BeforeApplyEditsHandler;
import edu.ucdavis.cstars.client.event.CapabilitiesChangeHandler;
import edu.ucdavis.cstars.client.event.ClearSelectionHandler;
import edu.ucdavis.cstars.client.event.DeleteAttachmentsHandler;
import edu.ucdavis.cstars.client.event.QueryAttachmentInfosHandler;
import edu.ucdavis.cstars.client.event.QueryCountHandler;
import edu.ucdavis.cstars.client.event.QueryFeaturesHandler;
import edu.ucdavis.cstars.client.event.QueryIdsHandler;
import edu.ucdavis.cstars.client.event.QueryRelatedFeaturesHandler;
import edu.ucdavis.cstars.client.event.SelectFeaturesHandler;
import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.layers.TimeInfo.TimeUnits;
import edu.ucdavis.cstars.client.symbol.Symbol;
import edu.ucdavis.cstars.client.tasks.FeatureSet;
import edu.ucdavis.cstars.client.tasks.Query;
import edu.ucdavis.cstars.client.tasks.RelationshipQuery;

/**
 * The feature layer inherits from the graphics layer and can be used to display features 
 * from a single layer in either a Map Service or Feature Service. The layer can be either 
 * a (spatial) layer or (non-spatial) table. If the underlying layer (or table) is from a 
 * Feature Service, its features can be edited. 
 * 
 * @author Justin Merz
 */
public class FeatureLayer extends GraphicsLayer {
	
	public static enum Modes {
		NOT_SET(-1),
		MODE_ONDEMAND(1),
		MODE_SELECTION(2),
		MODE_SNAPSHOT(0);
		private int val;
		private Modes(int value){
			val = value;
		}
		public int getValue(){
			return val;
		}
	}
	
	public static enum Popups {
		NOT_SET(""),
		POPUP_HTML_TEXT("esriServerHTMLPopupTypeAsHTMLText"),
		POPUP_NONE("esriServerHTMLPopupTypeNone"),
		POPUP_URL("esriServerHTMLPopupTypeAsURL");
		private String val;
		private Popups(String value){
			val = value;
		}
		public String getValue(){
			return val;
		}
	}
	
	public static enum Selections {
		NOT_SET(-1),
		SELECTION_ADD(4),
		SELECTION_NEW(3),
		SELECTION_SUBTRACTION(5);
		private int val;
		private Selections(int value){
			val = value;
		}
		public int getValue(){
			return val;
		}
	}
	
	
	protected FeatureLayer() {}
	
	/**
	 * Creates a new instance of a feature layer object from the ArcGIS Server REST resource 
	 * identified by the input URL. Once created you can optionally set a definition expression 
	 * or time definition.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a feature service.
	 * @return FeatureLayer
	 */
	public static FeatureLayer create(String url) {
		if( assertLoaded() ) return _create(url);
		return JavaScriptObject.createObject().cast();
	};
	
	private static native FeatureLayer _create(String url) /*-{
		return new $wnd.esri.layers.FeatureLayer(url);
	}-*/;
	
	/**
	 * Creates a new instance of a feature layer object from the ArcGIS Server REST resource 
	 * identified by the input URL. Once created you can optionally set a definition expression 
	 * or time definition.
	 * 
	 * @param url - URL to the ArcGIS Server REST resource that represents a feature service.
	 * @param options - Optional parameters
	 * @return FeatureLayer
	 */
	public static FeatureLayer create(String url, Options options) {
		if( assertLoaded() ) return _create(url, options);
		return JavaScriptObject.createObject().cast();
	};
	
	private static native FeatureLayer _create(String url, Options options) /*-{
		return new $wnd.esri.layers.FeatureLayer(url, options);
	}-*/;
	
	/**
	 * Creates a new instance of a feature layer object from the ArcGIS Server REST resource 
	 * identified by the input URL. Once created you can optionally set a definition expression 
	 * or time definition.
	 * 
	 * @param featureCollectionObject - layer information
	 * @return FeatureLayer
	 */
	public static FeatureLayer create(FeatureCollectionObject featureCollectionObject) {
		if( assertLoaded() ) return _create(featureCollectionObject);
		return JavaScriptObject.createObject().cast();
	};
	
	private static native FeatureLayer _create(FeatureCollectionObject featureCollectionObject) /*-{
		return new $wnd.esri.layers.FeatureLayer(featureCollectionObject);
	}-*/;
	
	/**
	 * Creates a new instance of a feature layer object from the ArcGIS Server REST resource 
	 * identified by the input URL. Once created you can optionally set a definition expression 
	 * or time definition.
	 * 
	 * @param featureCollectionObject - layer information
	 * @param options - Optional parameters
	 * @return FeatureLayer
	 */
	public static FeatureLayer create(FeatureCollectionObject featureCollectionObject, Options options) {
		if( assertLoaded() ) return _create(featureCollectionObject, options);
		return JavaScriptObject.createObject().cast();
	};
	
	private static native FeatureLayer _create(FeatureCollectionObject featureCollectionObject, Options options) /*-{
		return new $wnd.esri.layers.FeatureLayer(featureCollectionObject, options);
	}-*/;
	
	
	/**
	 * Check that the esri.layers.featurelayer package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.layers.FeatureLayer ) return true;
		$wnd.alert("The ESRI_LAYERS_FEATURELAYER package has not been loaded");
		return false;
	}-*/;
	
	// TODO: implement feature collection constructor as it is not well defined by the docs
	
	/**
	 * Information about the capabilities enabled for this layer.
	 * 
	 * @return String
	 */
	public final native String getCapabilities() /*-{
		return this.capabilities;
	}-*/;
	
	/**
	 * Copyright information for the layer.
	 * 
	 * @return String
	 */
	public final native String getCopyright() /*-{
		return this.copyright;
	}-*/;
	
	/**
	 * Metadata describing the default definition expression for the layer as defined by the service.
	 * The default definition expression limits the features available for display and query. You cannot
	 * override this value but you define additional filters on the default expression using the 
	 * setDefinitionExpression method. For example, if the default definition expression is set to display
	 * data where "STATE_NAME = 'California'" you could use setDefinitionExpression to only display a 
	 * subset of the features in California e.g., "COUNTY='San Diego'".
	 * 
	 * @return String
	 */
	public final native String getDefaultDefinitionExpression() /*-{
		return this.defaultDefinitionExpression;
	}-*/;
	
	/**
	 * The description of the layer as defined in the map service.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The name of the layer's primary display field. The value of this property matches the name of one
	 * of the fields of the layer.
	 * 
	 * @return String
	 */
	public final native String getDisplayField() /*-{
		return this.displayField;
	}-*/;
	
	/**
	 * Indicates the field names for the editor fields. If ownership based access control is not enabled for 
	 * the feature service the value will be null.  Requires ArcGIS Server feature service version 10.1 or 
	 * greater. (As of v2.6)
	 * 
	 * @return EditFieldsInfo
	 */
	public final native EditFieldsInfo getEditFieldsInfo() /*-{
		return this.editFieldsInfo;
	 }-*/;
	
	/**
	 * The array of fields in the layer.
	 * 
	 * @return JsArray<Field>
	 */
	public final native JsArray<Field> getFields() /*-{
		return this.fields;
	}-*/;
	
	/**
	 * The full extent of the layer.
	 * 
	 * @return Extent
	 */
	public final native Extent getFullExtent() /*-{
		return this.fullExtent;
	}-*/;
	
	/**
	 * Geometry type of the features in the layer. 
	 * Can be one of the following: "esriGeometryPoint", "esriGeometryPolygon" or "esriGeometryPolyline".
	 * 
	 * @return String
	 */
	public final native String getGeometryType() /*-{
		return this.geometryType;
	}-*/;
	
	/**
	 * The globalIdField for the layer.
	 * 
	 * @return String 
	 */
	public final native String getGlobalIdField() /*-{
		return this.globalIdField;
	}-*/;
	
	// getGraphics implemented by GraphicsLayer
	
	/**
	 * True if attachments are enabled on the feature layer. Use the queryAttachmentInfos method to determine if
	 * the the feature has attachments. If the layer is editable (isEditable) and supports attachments the following
	 * operations can be performed.
	 *   
	 * - Add attachments to features.
     * - Delete existing attachments.
	 * 
	 * @return boolean
	 */
	public final native boolean hasAttachments() /*-{
		return this.hasAttachments;
	}-*/;
	
	/**
	 * The html popup type defined for the layer. View the constants table for a list of valid values.
	 * 
	 * @return String
	 */
	public final native String htmlPopupType() /*-{
		return this.htmlPopupType;
	}-*/;
	
	/**
	 * Unique ID of the layer that the FeatureLayer was contructed against.
	 * 
	 * @return int
	 */
	public final native int getLayerId() /*-{
		return this.layerId;
	}-*/;
	
	/**
	 * The maximum number of results that will be returned from a query. Requires 
	 * ArcGIS Server version 10.1 or greater. (As of v2.6)
	 * 
	 * @return int
	 */
	public final native int getMaxRecordCount() /*-{
		return this.maxRecordCount;
	}-*/;
	
	/**
	 * Maximum visible scale for the layer. If the map is zoomed in beyond this scale,
	 *  the layer will not be visible. A value of 0 means that the layer does not have a maxium scale.
	 * 
	 * @return float
	 */
	public final native float getMaxScale()  /*-{
		return this.maxScale;
	}-*/;
	
	/**
	 * Minimum visible scale for the layer. If the map is zoomed out beyond this scale, the layer will 
	 * not be visible. A value of 0 means that the layer does not have a minimum scale.
	 * 
	 * @return float
	 */
	public final native float getMinScale()  /*-{
		return this.minScale;
	}-*/;
	
	/**
	 * The name of the layer as defined in the map service.
	 * 
	 * @return String
	 */
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	/**
	 * The name of the field that contains the Object ID field for the layer.
	 * 
	 * @return String
	 */
	public final native String getObjectIdField() /*-{
		return this.objectIdField;
	}-*/;
	
	/**
	 * Indicates the ownership access control configuration. If ownership based access control 
	 * is not enabled for the feature service the value will be null. If ownership based access 
	 * control is not enabled for the feature service the value will be null. This object has 
	 * two properties allowDeleteToOthers and allowUpdateToOthers. When true features can 
	 * be deleted or updated by users other than the creator.
	 * 
	 * @return OwnershipAccessControl
	 */
	public final native OwnershipAccessControl getOwnershipBasedAccessControlForFeatures() /*-{
		return this.ownershipBasedAccessControlForFeatures;
	}-*/;
	
	/**
	 * Each element in the array is an object that describes the layer's relationship with another
	 * layer or table. Use the queryRelatedFeatures method to retrieve features or records
	 * related to a feature in this layer.
	 * 
	 * @return JsArray<Relationship>
	 */
	public final native JsArray<Relationship> getRelationships() /*-{
		return this.relationships;
	}-*/;

	// getRenderer implemented by GraphicsLayer
	
	/**
	 * The dynamic layer or table source
	 * 
	 * @return LayerMapSource
	 */
	public final native LayerMapSource getSourceAsLayerMapSource() /*-{
		return this.source;
	}-*/;
	
	/**
	 * The dynamic layer or table source
	 * 
	 * @return LayerMapSource
	 */
	public final native LayerDataSource getSourceAsLayerDataSource() /*-{
		return this.source;
	}-*/;
	
	/**
	 * When true, the layer supports orderByFields in a query operation. Requires ArcGIS 
	 * Server service version 10.1 or greater (As of v2.6)
	 * 
	 * @return boolean
	 */
	public final native boolean supportsAdvancedQueries() /*-{
		return this.supportsAdvancedQueries;
	}-*/;
	
	/**
	 * When true, the layer supports statistical functions in query operations. Requires 
	 * ArcGIS Server service version 10.1 or greater (As of v2.6)
	 * 
	 * @return boolean
	 */
	public final native boolean supportsStatistics() /*-{
		return this.supportsStatistics;
	}-*/;
	
	/**
	 * An array of feature templates defined in the Feature Service layer.
	 * Only applicable for ArcGIS Server Feature Service layers.
	 * 
	 * @return JsArray<FeatureTemplate>
	 */
	public final native JsArray<FeatureTemplate> getTemplates() /*-{
		return this.templates;
	 }-*/;
	
	/**
	 * Time information for the layer, such as start time field, end time field, track id field,
	 * layers time extent and the draw time interval. Only applicable if the layer is time aware.
	 * 
	 * @return TimeInfo
	 */
	public final native TimeInfo getTimeInfo() /*-{
		return this.timeInfo;
	}-*/;
	
	/**
	 * Specifies the type of layer. Can be "Feature Layer" or "Table".
	 * 
	 * @return String
	 */
	public final native String getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * The field that represents the Type ID field. Only applicable for ArcGIS Server Feature Service layers.
	 * 
	 * @return String
	 */
	public final native String getTypeIdField() /*-{
		return this.typeIdField;
	 }-*/;
	
	/**
	 * An array of sub types defined in the Feature Service layer. Only applicable for ArcGIS Server
	 * Feature Service layers.
	 * 
	 * @return JsArray<FeatureType>
	 */
	public final native JsArray<FeatureType> getTypes() /*-{
		return this.types;
	}-*/;
	
	/**
	 * The version of ArcGIS Server where the layer is published. 
	 * 
	 * @return float
	 */
	public final native double getVersion() /*-{
		return this.version;
	}-*/;
	
	/**
	 * Add an attachment to the feature specified by the ObjectId. Only applicable if isEditable and hasAttachments are true.
	 * 
	 * @param objectId - The ObjectId of the feature to which the attachment is added.
	 * @param formNode - GWT FormPanel that contains a file upload field pointing to the file to be added as an attachment.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred addAttachment(int objectId, FormPanel formNode, AddAttachmentCallback callback) /*-{
		var formEle = formNode.@com.google.gwt.user.client.ui.FormPanel::getElement();
		return this.addAttachment(objectId, formEle,
			function(result) {
				callback.@edu.ucdavis.cstars.client.callback.AddAttachmentCallback::onAddAttachmentComplete(Ledu/ucdavis/cstars/client/layers/FeatureEditResult;)(result);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.AddAttachmentCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Add an attachment to the feature specified by the ObjectId. Only applicable if isEditable and hasAttachments are true.
	 * 
	 * @param objectId - The ObjectId of the feature to which the attachment is added.
	 * @param formNode - GWT FormPanel that contains a file upload field pointing to the file to be added as an attachment.
	 * @return Deferred
	 */
	public final native Deferred addAttachment(int objectId, FormPanel formNode) /*-{
		var formEle = formNode.@com.google.gwt.user.client.ui.FormPanel::getElement();
		return this.addAttachment(objectId, formEle);
	}-*/;
	
	/**
	 * Apply edits to the feature layer. Only applicable for layers in a feature service.
	 * 
	 * @param adds - Array of features to add to the layer in the feature service. New features are typically created using the Draw toolbar.
	 * @param updates - Array of features whose geometry and/or attributes have changed. Features must have a valid OBJECTID. The 
	 * geometry of features is typically modified using the Edit toolbar. Attributes are modified using the Attribute Inspector. 
	 * @param deletes - Array of features to delete. Must have valid ObjectId
	 * @param callback - This function will be called when the operation is complete.
	 * @return Deferred
	 */
	public final Deferred applyEdits(Graphic[] adds, Graphic[] updates, Graphic[] deletes,  ApplyEditsCallback callback) {
		return _applyEdits( Util.objectArrayToJSO(adds), Util.objectArrayToJSO(updates), Util.objectArrayToJSO(deletes), callback );
	}
	
	private final native Deferred _applyEdits( JavaScriptObject adds, JavaScriptObject updates, JavaScriptObject deletes, ApplyEditsCallback callback ) /*-{
		return this.applyEdits(adds, updates, deletes,
			function(addResult, updateResult, deleteResult) {
				callback.@edu.ucdavis.cstars.client.callback.ApplyEditsCallback::onEditsComplete(Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;)(addResult, updateResult, deleteResult);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.ApplyEditsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Apply edits to the feature layer. Only applicable for layers in a feature service.
	 * 
	 * @param adds - Array of features to add to the layer in the feature service. New features are typically created using the Draw toolbar.
	 * @param updates - Array of features whose geometry and/or attributes have changed. Features must have a valid OBJECTID. The 
	 * geometry of features is typically modified using the Edit toolbar. Attributes are modified using the Attribute Inspector. 
	 * @param deletes - Array of features to delete. Must have valid ObjectId
	 * @return Deferred
	 */
	public final Deferred applyEdits(Graphic[] adds, Graphic[] updates, Graphic[] deletes) {
		return _applyEdits( Util.objectArrayToJSO(adds), Util.objectArrayToJSO(updates), Util.objectArrayToJSO(deletes));
	}
	
	private final native Deferred _applyEdits( JavaScriptObject adds, JavaScriptObject updates, JavaScriptObject deletes) /*-{
		return this.applyEdits(adds, updates, deletes);
	}-*/;
	
	/**
	 * Clears the current selection.
	 * 
	 * @return FeatureLayer
	 */
	public final native FeatureLayer clearSelection() /*-{
		return this.clearSelection();
	}-*/;
	
	/**
	 * Delete one or more attachments for the feature specified by the input ObjectId. Only applicable if isEditable 
	 * and hasAttachments are true.
	 * 
	 * @param objectId - The ObjectId of the feature from which the attachment is removed.
	 * @param attachmentIds - The array of attachment ids to delete.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final  Deferred deleteAttachments(int objectId, int[] attachmentIds, DeleteAttachmentsCallback callback) {
		return _deleteAttachments(objectId, Util.intArrayToJSO(attachmentIds), callback);
	}
	
	private final native Deferred _deleteAttachments(int objectId, JavaScriptObject attachmentIds, DeleteAttachmentsCallback callback) /*-{
		return this.deleteAttachments(objectId, attachmentIds,
			function(result) {
				callback.@edu.ucdavis.cstars.client.callback.DeleteAttachmentsCallback::onDeleteAttachmentsComplete(Lcom/google/gwt/core/client/JsArray;)(callback);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.DeleteAttachmentsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Delete one or more attachments for the feature specified by the input ObjectId. Only applicable if isEditable 
	 * and hasAttachments are true.
	 * 
	 * @param objectId - The ObjectId of the feature from which the attachment is removed.
	 * @param attachmentIds - The array of attachment ids to delete.
	 * @return Deferred
	 */
	public final  Deferred deleteAttachments(int objectId, int[] attachmentIds) {
		return _deleteAttachments(objectId, Util.intArrayToJSO(attachmentIds));
	}
	
	private final native Deferred _deleteAttachments(int objectId, JavaScriptObject attachmentIds) /*-{
		return this.deleteAttachments(objectId, attachmentIds);
	}-*/;
	
	/**
	 * Returns the current definition expression.
	 * 
	 * @return String
	 */
	public final native String getDefinitionExpression() /*-{
		return this.getDefinitionExpression();
	}-*/;
	
	/**
	 * Returns an object that describes the edit capabilities of the layer. 
	 * 
	 * @return EditCapabilities
	 */
	public final native EditCapabilities getEditCapabilities() /*-{
		return this.editCapabilities();
	}-*/;
	
	/**
	 * Returns an object that describes the edit capabilities of the layer. 
	 * 
	 * If the layer supports ownership based access control, use the options to determine if 
	 * the specified user can edit features. Ownership based access control requires ArcGIS 
	 * Server services version 10.1 or greater.
	 * 
	 * @param graphic - Check to see if the specified feature can be edited by the specified user.
	 * @param userId - The name of the currently logged in user. If the application uses the IdentityManager 
	 * the IdentityManager supplies the layer with the userId so this parameter is not required.
	 * @return EditCapabilities
	 */
	public final native EditCapabilities getEditCapabilities(Graphic graphic, String userId) /*-{
		return this.editCapabilities({"graphic":graphic,"userId":userId});
	}-*/;
	
	/**
	 * Returns the current value of the maxAllowableOffset used by the layer. For non-editable layers 
	 * in on-demand mode if autoGeneralize is enabled the maxAllowableOffset is set to the current 
	 * map resolution. (As of v2.7)
	 * 
	 * @return
	 */
	public final native double getMaxAllowableOffset() /*-{
		return this.getMaxAllowableOffset();
	}-*/;
	
	/**
	 * Gets the currently selected features.
	 * 
	 * @return JsArray<Graphic>
	 */
	public final native JsArray<Graphic> getSelectedFeatures() /*-{
		return this.getSelectedFeatures();
	}-*/;
	
	/**
	 * Gets the current selection symbol.
	 * 
	 * @return Symbol
	 */
	public final native Symbol getSelectionSymbol() /*-{
		return getSelectionSymbol();
	}-*/;
	
	/**
	 * Get the current time definition applied to the feature layer.
	 * 
	 * @return TimeExtent
	 */
	public final native TimeExtent getTimeDefinition() /*-{
		return getTimeDefinition();
	}-*/;
	
	/**
	 * Returns true if the FeatureLayer is editable. If the layer is editable the following operations can be performed.
	 *  - Add new features.
	 *  - Modify the geometry and attributes of existing features.
	 *  - Delete features.
	 * 
	 * @return boolean
	 */
	public final native boolean isEditable() /*-{
		return this.isEditable();
	}-*/;
	
	/**
	 * Query for information about attachments associated with the specified ObjectIds.
	 * 
	 * @param objectId - The ObjectId for the feature to query for attachment information.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred queryAttachmentInfos(int objectId, QueryAttachmentInfosCallback callback) /*-{
		return this.queryAttachmentInfos(objectId,
			function(attachmentInfos) {
				callback.@edu.ucdavis.cstars.client.callback.QueryAttachmentInfosCallback::onQueryAttachmentInfosComplete(Lcom/google/gwt/core/client/JsArray;)(attachmentInfos);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryAttachmentInfosCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Query for information about attachments associated with the specified ObjectIds.
	 * 
	 * @param objectId - The ObjectId for the feature to query for attachment information.
	 * @return Deferred
	 */
	public final native Deferred queryAttachmentInfos(int objectId) /*-{
		return this.queryAttachmentInfos(objectId);
	}-*/;
	
	/**
	 * Get a count of the number of features that satisfy the input query. Valid only for layers published using
	 * ArcGIS Server 10 SP1 or greater. Layers published with earlier versions of ArcGIS Server return an error
	 * to the error callback.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 *  - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 *  - The returnGeometry value specified by the query object is ignored and true is used.
	 *  - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred queryCount(Query query, QueryCountCallback callback) /*-{
		return this.queryCount(query,
			function(count) {
				callback.@edu.ucdavis.cstars.client.callback.QueryCountCallback::onQueryCountComplete(I)(count);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryCountCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Get a count of the number of features that satisfy the input query. Valid only for layers published using
	 * ArcGIS Server 10 SP1 or greater. Layers published with earlier versions of ArcGIS Server return an error
	 * to the error callback.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 *  - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 *  - The returnGeometry value specified by the query object is ignored and true is used.
	 *  - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @return Deferred
	 */
	public final native Deferred queryCount(Query query) /*-{
		return this.queryCount(query);
	}-*/;
	
	/**
	 * Query features from the feature layer. Layer definition and time definition are honored. Whenever possible
	 * the feature layer will perform the query on the client.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred queryFeatures(Query query, QueryFeaturesCallback callback) /*-{
		return this.queryFeatures(query,
			function(featureSet) {
				callback.@edu.ucdavis.cstars.client.callback.QueryFeaturesCallback::onQueryFeaturesComplete(Ledu/ucdavis/cstars/client/tasks/FeatureSet;)(featureSet);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryFeaturesCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Query features from the feature layer. Layer definition and time definition are honored. Whenever possible
	 * the feature layer will perform the query on the client.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @return Deferred
	 */
	public final native Deferred queryFeatures(Query query) /*-{
		return this.queryFeatures(query);
	}-*/;
	
	/**
	 * Query for ObjectIds. There is no limit on the number of ObjectIds that are returned from the server. Like queryFeatures this operation will
	 * perform queries on the client (browser) whenever possible.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred queryIds(Query query, QueryIdsCallback callback) /*-{
		return this.queryIds(query,
			function(ids) {
				callback.@edu.ucdavis.cstars.client.callback.QueryIdsCallback::onQueryIdsComplete(Lcom/google/gwt/core/client/JsArrayInteger;)(ids);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryIdsCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Query for ObjectIds. There is no limit on the number of ObjectIds that are returned from the server. Like queryFeatures this operation will
	 * perform queries on the client (browser) whenever possible.
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @return Deferred
	 */
	public final native Deferred queryIds(Query query) /*-{
		return this.queryIds(query);
	}-*/;
	
	/**
	 * Query features or records, from another layer or table, related to features in this layer.
	 * 
	 * @param relQuery - The input query.
	 * @param callback - The function to call when the method has completed.
	 * @return Deferred
	 */
	public final native Deferred queryRelatedFeatures(RelationshipQuery relQuery, QueryRelatedFeaturesCallback callback) /*-{
		return this.queryRelatedFeatures(relQuery,
			function(relatedFeatures) {
				callback.@edu.ucdavis.cstars.client.callback.QueryRelatedFeaturesCallback::onQueryRelatedFeaturesComplete(Ledu/ucdavis/cstars/client/layers/FeatureLayer$RelatedFeatures;)(relatedFeatures);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.QueryRelatedFeaturesCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Query features or records, from another layer or table, related to features in this layer.
	 * 
	 * @param relQuery - The input query.
	 * @return Deferred
	 */
	public final native Deferred queryRelatedFeatures(RelationshipQuery relQuery) /*-{
		return this.queryRelatedFeatures(relQuery);
	}-*/;
	
	/**
	 * Refreshes the features in the feature layer. The feature layer requeries all the features in the service,
	 * except the selected features, and updates itself.
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
	
	/**
	 * Selects features from the FeatureLayer. Layer properties like layer definition and time definition are honored.
	 * The selection method defines how query results are passed to the selection. The feature layer will highlight the
	 * current selection if a selection symbol has been defined. Whenever possible, the feature layer will perform the
	 * query operation on the client (browser).
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param callback - The function to call when the method has completed.
	 * @return - Deferred
	 */
	public final native Deferred selectFeatures(Query query, SelectFeaturesCallback callback) /*-{
		return this.selectFeatures(query,
			function(features, sm) {
				@edu.ucdavis.cstars.client.layers.FeatureLayer::_onSelectionComplete(Ledu/ucdavis/cstars/client/callback/SelectFeaturesCallback;Lcom/google/gwt/core/client/JsArray;I)(callback, features, selectionMethod);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.SelectFeaturesCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Selects features from the FeatureLayer. Layer properties like layer definition and time definition are honored.
	 * The selection method defines how query results are passed to the selection. The feature layer will highlight the
	 * current selection if a selection symbol has been defined. Whenever possible, the feature layer will perform the
	 * query operation on the client (browser).
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @return - Deferred
	 */
	public final native Deferred selectFeatures(Query query) /*-{
		return this.selectFeatures(query);
	}-*/;
	
	/**
	 * Selects features from the FeatureLayer. Layer properties like layer definition and time definition are honored.
	 * The selection method defines how query results are passed to the selection. The feature layer will highlight the
	 * current selection if a selection symbol has been defined. Whenever possible, the feature layer will perform the
	 * query operation on the client (browser).
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param selectionMethod - The selection method defines how the restul of the selection is combined with the existing selection.
	 * The default option is to create a new selection.
	 * @param callback - The function to call when the method has completed.
	 * @return - Deferred
	 */
	public final Deferred selectFeatures(Query query, Selections selectionMethod, SelectFeaturesCallback callback) {
		return _selectFeatures(query, selectionMethod.getValue(), callback);
	};
	
	private final native Deferred _selectFeatures(Query query, int selectionMethod, SelectFeaturesCallback callback) /*-{
		return this.selectFeatures(query,  selectionMethod,
			function(features, sm) {
				@edu.ucdavis.cstars.client.layers.FeatureLayer::_onSelectionComplete(Ledu/ucdavis/cstars/client/callback/SelectFeaturesCallback;Lcom/google/gwt/core/client/JsArray;I)(callback, features, selectionMethod);
			},
			function(error) {
				callback.@edu.ucdavis.cstars.client.callback.SelectFeaturesCallback::onError(Ledu/ucdavis/cstars/client/Error;)(error);
			}
		);
	}-*/;
	
	/**
	 * Selects features from the FeatureLayer. Layer properties like layer definition and time definition are honored.
	 * The selection method defines how query results are passed to the selection. The feature layer will highlight the
	 * current selection if a selection symbol has been defined. Whenever possible, the feature layer will perform the
	 * query operation on the client (browser).
	 * 
	 * @param query - The input query. The query object has the following restrictions to avoid conflicts between layer and map properties.
	 * - outFields specified by the query object are overriden by the outFields specified in the FeatureLayer constructor.
	 * - The returnGeometry value specified by the query object is ignored and true is used.
	 * - The outSpatialReference set by the query object is ignored and the map's spatial reference is used.
	 * @param callback - The function to call when the method has completed.
	 * @return - Deferred
	 */
	public final Deferred selectFeatures(Query query, Selections selectionMethod) {
		return _selectFeatures(query, selectionMethod.getValue());
	};
	
	private final native Deferred _selectFeatures(Query query, int selectionMethod) /*-{
		return this.selectFeatures(query, selectionMethod);
	}-*/;
	
	/*
	 * When a successful call to selectFeatures is made, the callback actually triggers this function.  onSelectionComplete is used to
	 * translate the int selectionMethod value to the enum Selections.
	 */
	private final static void _onSelectionComplete( SelectFeaturesCallback callback, JsArray<Graphic> features, int selectionMethod) {
		for( int i = 0; i < Selections.values().length; i++ ){
			if( Selections.values()[i].getValue() == selectionMethod ) {
				callback.onSelectionComplete(features, Selections.values()[i] );
				return;
			}
		}
		callback.onSelectionComplete(features, Selections.NOT_SET );
	}
	
	/**
	 * Enable or disable auto generalization for the layer. Note that auto generalization is only applicable to 
	 * non-editable feature layers in on-demand mode. (As of v2.7)
	 * 
	 * @param enable - When true, auto generalize is enabled. Default value for non-editable on-demand feature 
	 * layers is true
	 * @return FeatureLayer
	 */
	public final native FeatureLayer setAutoGeneralize(boolean enable) /*-{
		return this.setAutoGeneralize(enable);
	 }-*/;
	
	/**
	 * Set's the definition expression for the FeatureLayer. Only the features that match the definition expression are
	 * displayed. A definition expression limits the features available for display and queries by applying constraints to
	 * the layer's attribute fields. Setting a definition expression is useful when the dataset is large and you don't want
	 * to bring everything to the client for analysis. This method is typically called before adding the layer to the map.
	 * If the method is called after the layer is added to the map the layer will refresh itself to reflect the new definition
	 * expression.
	 * 
	 * This definition expression is combined with the layer's default definition expression which results in a further
	 * restriction of the layer.
	 * 
	 * @param expression - example: "STATE_NAME = 'South Carolina'"
	 * @return String
	 */
	public final native FeatureLayer setDefinitionExpression(String expression) /*-{
		this.setDefinitionExpression(expression);
	}-*/;
	
	/**
	 * Set the editability of feature layers created from a feature collection. This method is 
	 * only valid for feature layers created from feature collections.
	 * 
	 * When the feature layer's editability is updated the onCapabilitiesChange event is fired. 
	 * Use the isEditable method to determine if the layer is editable.
	 * (As of v2.6)
	 * 
	 * @param editable - When true, the layer will be set as editable.
	 * @return FeatureLayer
	 */
	public final native FeatureLayer setEditable(boolean editable) /*-{
		return this.setEditable(editable);
	}-*/;
	
	/**
	 * Set the layer's data source to the specified geodatabase version. If the versionName is null 
	 * then the data source will be the published map's default version. Only applicable if the layer's 
	 * data source is registered as versioned in SDE. Only valid with ArcGIS Server services version 
	 * 10.1 or greater. (As of v2.7)
	 * 
	 * @param versionName - The name of the geodatabase version to use as the layer's data source.
	 * @return FeatureLayer
	 */
	public final native FeatureLayer setGDBVersion(String versionName) /*-{
		return this.setGDBVersion(versionName);
	}-*/;
	
	// setInfoTemplate implemented in GraphicsLayer
	
	/**
	 * Sets the maximum allowable offset used when generalizing geometries.
	 */
	public final native void setMaxAllowableOffset(double offset) /*-{
		this.setMaxAllowableOffset(offset);
	}-*/;
	
	// setOpacity implemented in GraphicsLayer
	
	// setRenderer implemented in GraphicsLayer
	
	/**
	 * Set the scale range for the layer. If minScale and maxScale are set to 0 then the layer 
	 * will be visible at all scales. (As of v2.5)
	 * 
	 * @param minScale - The minimum scale for the layer. If the map is zoomed out beyond the 
	 * specified scale the layer will not be visible. A value of 0 means the layer does not 
	 * have a minimum scale.
	 * @param maxScale - The maximum scale for the layer. If the map is zoomed out beyond the 
	 * specified scale the layer will not be visible. A value of 0 means the layer does not 
	 * have a maximum scale.
	 */
	public final native void setScaleRange(double minScale, double maxScale) /*-{
		this.setScaleRange(minScale, maxScale);
	}-*/;
	
	/**
	 * Set's the selection symbol for the feature layer. If no symbol is specified, features are drawn using the layer's renderer.
	 * 
	 * @param symbol - Symbol for the current selection. Make sure the symbol type is appropriate for the geometry type of the layer.
	 * @return FeatureLayer
	 */
	public final native FeatureLayer setSelectionSymbol(Symbol symbol) /*-{
		this.setSelectionSymbol(symbol);
	}-*/;
	
	/**
	 * Set's the time definition for the feature layer. A time definition temporarily filters the features in the layer to match the
	 * specified time extent. Only applicable for time-aware layers. Only supported when the feature layer is in snapshot mode.
	 * 
	 * In addition to time definition, time-aware layers also support the time extent set on the map. Time-aware layers
	 * automatically update when the map's time extent is changed, similar to how layers react when the map's spatial reference
	 * is modified. If a layer's time defintion is set to display features between 1970 and 1975 and the map has a time extent set
	 * to 1972-1980, the effective time on the feature layer will be 1972-1975 
	 * 
	 * @param definition - The new time extent used to filter the layer.
	 * @return FeatureLayer
	 */
	public final native FeatureLayer setTimeDefinition(TimeExtent definition) /*-{
		this.setTimeDefinition(definition);
	}-*/;
	
	/**
	 * Time offset allows you to display the features at a different time so they can be overlayed on top of previous or future
	 * time periods. For example, to visualize the growth pattern of two wild fires that happened in two different years, one
	 * of the layers can be given an offset that will cause it to appear as if the fire started at the same time as the other fire.
	 * Note that the offset does not change the temporal component of the data itself and has no effect if the layer is not
	 * time aware.
	 * 
	 * Example: If a layer has data recorded for the year 1970, an offset value of 2 years would temporarily shift the data to
	 * 1972 (for display purposes only, query and selection are not affected by offset).
	 * 
	 * @param offsetValue - The length of time to offset from "this" time. Specify a positive or negative whole number.
	 * @param offsetUnits - Units in wich the offset is specified. 
	 * @return FeatureLayer
	 */
	public final FeatureLayer setTimeOffset(int offsetValue, TimeUnits offsetUnits) {
		return _setTimeOffset(offsetValue, offsetUnits.getValue());
	}
	
	private final native FeatureLayer _setTimeOffset(int offsetValue, String offsetUnits)/*-{
		this.setTimeOffset(offsetValue, offsetUnits);
	}-*/;
	
	/**
	 * Determine if the layer will update its content based on the map's current time extent. Default value is true.
	 * 
	 * @param update - When false the layer will not update its content based on the map's time extent. Default value is true.
	 */
	public final native void setUseMapTime(boolean update) /*-{
		this.setUseMapTime(update);
	}-*/;
	
	/**
	 * Returns an easily serializable object representation of the layer. Regardless of the layer's mode of operation, only
	 * features currently available on the client are included.
	 * 
	 * @return JavaScriptObject
	 */
	public final native JavaScriptObject toJson() /*-{
		return this.toJson();
	}-*/;
	
	/**
	 * Add event handler for onAddAttachmentComplete.
	 * 
	 * @param handler - Fires when addAttachments() is complete.
	 */
	public final native void addAddAttachmentHandler(AddAttachmentHandler handler) /*-{
		$wnd.dojo.connect(this, "onAddAttachmentComplete",
			function(result) {
				handler.@edu.ucdavis.cstars.client.event.AddAttachmentHandler::onAddAttachmentComplete(Ledu/ucdavis/cstars/client/layers/FeatureEditResult;)(result);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onBeforeApplyEdits.
	 * 
	 * @param handler  - Fired before edits are applied to the feature layer.
	 */
	public final native void addBeforeApplyEditsHandler(BeforeApplyEditsHandler handler) /*-{
		$wnd.dojo.connect(this, "onBeforeApplyEdits",
			function(adds, updates, deletes) {
				handler.@edu.ucdavis.cstars.client.event.BeforeApplyEditsHandler::onBeforeEditsComplete(Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;)(adds, updates, deletes);
			}
		);
	}-*/;
	
	/**
	 * Set the capabilities change handler.
	 * 
	 * @param handler - Fired when the capabilities of the layer are modified using the setEditable method. (As of v2.6)
	 */
	public final native void addCapabilitiesChange(CapabilitiesChangeHandler handler) /*-{
		$wnd.dojo.connect(this, "onCapabilitiesChange",
			function() {
				handler.@edu.ucdavis.cstars.client.event.CapabilitiesChangeHandler::onCapabilitiesChange()();
			}
		);
	}-*/;
	
	// dblClick event handled by GraphicsLayer
	
	/**
	 * Add event handler for onDeleteAttachmentsComplete.
	 * 
	 * @param handler - Fires when deleteAttachments is complete.
	 */
	public final native void addDeleteAttachmentsHandler(DeleteAttachmentsHandler handler) /*-{
		$wnd.dojo.connect(this, "onDeleteAttachmentsComplete",
			function(results) {
				handler.@edu.ucdavis.cstars.client.event.DeleteAttachmentsHandler::onDeleteAttachmentsComplete(Lcom/google/gwt/core/client/JsArray;)(results);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onEditsComplete.
	 * 
	 * @param handler - Fires after applyEdits() has been called.
	 */
	public final native void addEditsCompleteHandler(ApplyEditsHandler handler) /*-{
		$wnd.dojo.connect(this, "onEditsComplete",
			function(addResults, updateResults, deleteResults) {
				handler.@edu.ucdavis.cstars.client.event.ApplyEditsHandler::onEditsComplete(Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;Lcom/google/gwt/core/client/JsArray;)(addResults, updateResults, deleteResults);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onQueryAttachmentInfosComplete
	 * 
	 * @param handler - Fires when queryAttachmentInfos() is complete.
	 */
	public final native void addQueryAttachmentInfosHandler(QueryAttachmentInfosHandler handler) /*-{
		$wnd.dojo.connect(this, "onQueryAttachmentInfosComplete",
			function(attachmentInfos) {
				handler.@edu.ucdavis.cstars.client.event.QueryAttachmentInfosHandler::onQueryAttachmentInfosComplete(Lcom/google/gwt/core/client/JsArray;)(attachmentInfos);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onQueryCountComplete.   This event is only available for layers published using ArcGIS Server 10 SP1 or later. 
	 * 
	 * @param handler - Fires when the query for the count is complete.
	 */
	public final native void addQueryCountHandler(QueryCountHandler handler) /*-{
		$wnd.dojo.connect(this, "onQueryCountComplete",
			function(count) {
				handler.@edu.ucdavis.cstars.client.event.QueryCountHandler::onQueryCountComplete(I)(count);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onQueryFeaturesComplete.
	 * 
	 * @param handler - Fires when queryFeatures() is complete.
	 */
	public final native void addQueryFeaturesHandler(QueryFeaturesHandler handler) /*-{
		$wnd.dojo.connect(this, "onQueryFeaturesComplete",
			function(featureSet) {
				handler.@edu.ucdavis.cstars.client.event.QueryFeaturesHandler::onQueryFeaturesComplete(Ledu/ucdavis/cstars/client/tasks/FeatureSet;)(featureSet);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onQueryIdsComplete.
	 * 
	 * @param handler - Fires when queryIds() is complete.
	 */
	public final native void addQueryIdsHandler(QueryIdsHandler handler) /*-{
		$wnd.dojo.connect(this, "onQueryIdsComplete",
			function(ids) {
				handler.@edu.ucdavis.cstars.client.event.QueryIdsHandler::onQueryIdsComplete(Lcom/google/gwt/core/client/JsArrayInteger;)(ids);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onQueryRelatedFeaturesComplete.
	 * 
	 * @param handler - Fires when queryRelatedFeatures() is complete.
	 */
	public final native void addQueryRelatedFeaturesHandler(QueryRelatedFeaturesHandler handler) /*-{
		$wnd.dojo.connect(this, "onQueryRelatedFeaturesComplete",
			function(relatedFeatures) {
				handler.@edu.ucdavis.cstars.client.event.QueryRelatedFeaturesHandler::onQueryRelatedFeaturesComplete(Ledu/ucdavis/cstars/client/layers/FeatureLayer$RelatedFeatures;)(relatedFeatures);
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onSelectionClear. OnSelectionComplete always fires unless there is an error returned by the server.
	 * 
	 * @param handler - Fires when selectFeatures() has completed. 
	 */
	public final native void addClearSelectionHandler(ClearSelectionHandler handler) /*-{
		$wnd.dojo.connect(this, "onSelectionClear",
			function() {
				handler.@edu.ucdavis.cstars.client.event.ClearSelectionHandler::onSelectionClear();
			}
		);
	}-*/;
	
	/**
	 * Add event handler for onSelectionComplete. OnSelectionComplete always fires unless there is an error returned by the server.
	 * 
	 * @param handler - Fires when selectFeatures() has completed. 
	 */
	public final native void addSelectFeaturesHandler(SelectFeaturesHandler handler) /*-{
		$wnd.dojo.connect(this, "onSelectionComplete",
			function(features, selectionMethod) {
				@edu.ucdavis.cstars.client.layers.FeatureLayer::_onSelectionHandlerComplete(Ledu/ucdavis/cstars/client/event/SelectFeaturesHandler;Lcom/google/gwt/core/client/JsArray;I)(handler, features, selectionMethod);
			}
		);
	}-*/;
	
	private final static void _onSelectionHandlerComplete(SelectFeaturesHandler handler, JsArray<Graphic> features, int selectionMethod) {
		for( int i = 0; i < Selections.values().length; i++ ){
			if( Selections.values()[i].getValue() == selectionMethod ) {
				handler.onSelectionComplete(features, Selections.values()[i] );
				return;
			}
		}
		handler.onSelectionComplete(features, Selections.NOT_SET );
	}
	
	// onUpdateEnd implemented by Layer
	
	
	public static class Options extends JavaScriptObject {
		
		protected Options() {}
		
		/**
		 * Create new options for FeatureLayer constructor
		 * 
		 * @return Options
		 */
		public static Options create() {
			return JavaScriptObject.createObject().cast();
		}
		
		/**
		 * Set the autoGeneralize parameter.
		 * 
		 * @param autoGeneralize - Enable or disable the auto generalization of features from a non-editable layer in 
		 * on-demand mode. When true, the layer uses the current map resolution as the maxAllowableOffset 
		 * for all queries issued to the server. The default value is true. As of v2.7
		 */
		public final native void setAutoGeneralize(boolean autoGeneralize) /*-{
			this["autoGeneralize"] = autoGeneralize;
		}-*/;
		
		/**
		 * Set default behavior for graphics.
		 * 
		 * @param displayOnPan - When true, graphics are displayed during panning. When false, the graphics are turned
		 * off during pan movement. Setting to false may improve performance in Internet Explorer.
		 * The default is true. 
		 */
		public final native void setDisplayOnPan(boolean displayOnPan) /*-{
			this["displayOnPan"] = displayOnPan;
		}-*/;
		
		/**
		 * Set the gdbVersion
		 * 
		 * @param gdbVersion - Specify the geodatabase version to display. (As of v2.7). Requires ArcGIS Server 
		 * service 10.1 or greater
		 */
		public final native void setGdbVersion(String gdbVersion) /*-{
			this["gdbVersion"] = gdbVersion;
		}-*/;
		
		/**
		 * Set layers id.
		 * 
		 * @param id - Unique ID to assign to the layer. If not assigned, esri.Map creates a unique ID. 
		 */
		public final native void setId(String id) /*-{
			this["id"] = id;
		}-*/;
		
		/**
		 * Set the layers InfoTemplate.
		 * 
		 * @param infoTemplate - The template that defines the content to display in the map info
		 * window when the user clicks on a feature. If not specified, the info window will not be displayed. 
		 */
		public final native void setInfoTemplate(InfoTemplate infoTemplate) /*-{
			this["infoTemplate"] = infoTemplate;
		}-*/;
		
		/**
		 * Set the max offset for layer.
		 * 
		 * @param offset - The maximum allowable offset, only applicable for layers that are not editable. 
		 */
		public final native void setMaxAllowableOffset(int offset) /*-{
			this["maxAllowableOffset"] = offset;
		}-*/;
		
		/**
		 *  Specify the layers mode of operation. Each mode determines when and how many
		 *  features are sent to the client. 
		 * 
		 * @param mode - mode type
		 */
		public final void setMode(Modes mode) {
			setMode(mode.getValue());
		}
		
		private final native void setMode(int mode) /*-{
			this["mode"] = mode;
		}-*/;
		
		/**
		 * Initial opacity or transparency of layer. Values range from 0.0 to 1.0, where 0.0 is 100%
		 * transparent and 1.0 has no transparency. The default value is 1.0. Not supported in
		 * Internet Explorer. 
		 * 
		 * @param opacity
		 */
		public final native void setOpacity(float opacity) /*-{
			this["opacity"] = opacity;
		}-*/;
		
		/**
		 * Set outFields parameter.
		 * 
		 * @param outFields -  Unique ID to assign to the layer. If not assigned, esri.Map creates a unique ID.
		 */
		public final void setOutFields(String[] outFields) {
			_setOutFields(Util.stringArrayToJSO(outFields));
		}
		
		private final native void _setOutFields(JavaScriptObject outFields) /*-{
			this["outFields"] = outFields;
		}-*/;
		
		/**
		 * Set the source parameter.
		 * 
		 * @param source - The dynamic layer source. Required when the feature layer url is set 
		 * to http://<map service url>/dynamicLayer. As of v 2.7. Requires an ArcGIS Server service 
		 * version 10.1 or greater
		 */
		public final native void setSource(LayerMapSource source) /*-{
			this["source"] = source;
		}-*/;
		
		/**
		 * Set the source parameter.
		 * 
		 * @param source - The dynamic data source. Required when the feature layer url is set 
		 * to http://<map service url>/dynamicLayer. As of v 2.7. Requires an ArcGIS Server service 
		 * version 10.1 or greater
		 */
		public final native void setSource(LayerDataSource source) /*-{
			this["source"] = source;
		}-*/;
		
		/**
		 * Set the tileHeight parameter.
		 * 
		 * @param tileHeight - Specify the size of the virtual tiles, used in on-demand mode. The virtual tile scheme is used in on-demand
		 * mode to make effective use of browser caching. The default value is 512. This option is only valid in on-demand mode and must
		 * be a square. For example, specifying a value like 512x256 is not supported.
		 */
		public final native void setTileHeight(int tileHeight) /*-{
			this["tileHeight"] = tileHeight;
		}-*/;
		
		/**
		 * Set the tileWidth parameter.
		 * 
		 * @param tileWidth - Specify the size of the virtual tiles, used in on-demand mode. The virtual tile scheme is used in on-demand
		 * mode to make effective use of browser caching. The default value is 512. This option is only valid in on-demand mode and must
		 * be a square. For example, specifying a value like 512x256 is not supported.
		 */
		public final native void setTileWidth(int tileWidth) /*-{
			this["tileWidth"] = tileWidth;
		}-*/;
		
		/**
		 * Set the trackIdField parameter.
		 * 
		 * @param trackIdField - The name of the trackIdField.
		 */
		public final native void setTrackIdField(String trackIdField) /*-{
			this["trackIdField"] = tackIdField;
		}-*/;
		
		/**
		 * Set the useMapTime parameter.
		 * 
		 * @param useMapTime - When true, the layer will update its content based on the map's time extent. The default values is true.
		 */
		public final native void useMapTime(boolean useMapTime) /*-{
			this["useMapTime"] = useMapTime;
		}-*/;
		
		/**
		 * Set the visible parameter.
		 * 
		 * @param visible - Initial visibility of the layer. Default is true.
		 */
		public final native void setVisible(boolean visible) /*-{
			this["visible"] = visible;
		}-*/;
		
	}
	
	public static class Relationship extends JavaScriptObject {
		
		protected Relationship() {}
		
		/**
		 * Unique ID for the relationship
		 *
		 * @return int
		 */
		public final native int getId() /*-{
			return this.id;
		}-*/;
		
		/**
		 * name 	Name of the relationship.
		 * 
		 * @return String
		 */
		public final native String getName() /*-{
			return this.name;
		}-*/;
		
		/**
		 * Unique ID of the related table or layer
		 * 
		 * @return int
		 */
		public final native int getRelatedTableId() /*-{
			return this.relatedTableId;
		}-*/;
		
	}
	
	public static class OwnershipAccessControl extends JavaScriptObject {
		
		protected OwnershipAccessControl() {}
		
		public final native boolean allowUpdateToOthers() /*-{
			return this.allowUpdateToOthers;
		}-*/;
		
		public final native boolean allowDeleteToOthers() /*-{
			return this.allowDeleteToOthers;
		}-*/;
		
	}
	
	public static class EditCapabilities extends JavaScriptObject {
		
		protected EditCapabilities() {}
		
		/**
		 * When true, new features can be created.
		 * 
		 * @return boolean
		 */
		public final native boolean canCreate() /*-{
			return this.canCreate;
		}-*/;
		
		/**
		 * When true, existing features can be updated.
		 * 
		 * @return boolean
		 */
		public final native boolean canUpdate() /*-{
			return this.canUpdate;
		}-*/;
		
		/**
		 * When true, features can be deleted.
		 * 
		 * @return boolean
		 */
		public final native boolean canDelete() /*-{
			return this.canDelete;
		}-*/;
		
	}
	
	public static class EditFieldsInfo extends JavaScriptObject {
		
		protected EditFieldsInfo() {}
		
		public final native String getCreatorField() /*-{
			return this.creatorField;
		}-*/;
		
		public final native String getCreationDateField() /*-{
			return this.creationDateField;
		}-*/;
		
		public final native String getEditorField() /*-{
			return this.editorField;
		}-*/;
		
		public final native String getEditDateField() /*-{
			return this.editDateField;
		}-*/;
		
	}
	
	public static class RelatedFeatures extends JavaScriptObject {
		
		protected RelatedFeatures() {}
		
		public final native JsArrayString getFeatureIds() /*-{
			var keys = [];
			for( var i in this ) keys.push(i);
			return keys;
		}-*/;
		
		public final native boolean hasFeature(String id) /*-{
			if( this[id] ) return true;
			return false;
		}-*/;

		public final native FeatureSet getFeatureSet(String id) /*-{
			return this[id];
		}-*/;
		
	}
	
	public static class FeatureCollectionObject extends JavaScriptObject {
		
		protected FeatureCollectionObject() {}
		
		public static FeatureCollectionObject create() {
			return JavaScriptObject.createObject().cast();
		}
		
		public final native void setLayerDefinition(JavaScriptObject layerDefinition) /*-{
			this["layerDefinition"] = layerDefinition;
		}-*/;
		
		public final native void setFeatureSet(JavaScriptObject featureSet) /*-{
			this["featureSet"] = featureSet;
		}-*/;
		
	}

	
}
