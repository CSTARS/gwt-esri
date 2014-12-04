package edu.ucdavis.cstars.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a message generated during the execution of a geoprocessing task. It includes information such as when the
 * processing started, what parameter values are being used, the task progress, warnings of potential problems and errors.
 * It is composed of a message type and description. 
 * 
 * @author Justin Merz
 */
public class GPMessage extends JavaScriptObject {
	
	public enum MessageType {
		TYPE_ABORT("esriJobMessageTypeAbort"),
		TYPE_EMPTY("esriGPMessageTypeEmpty"),
		TYPE_ERROR("esriGPMessageTypeError"),
		TYPE_INFORMATIVE("esriGPMessageTypeInformative"),
		TYPE_PROCESS_DEFINITION(""),
		TYPE_PROCESS_START(""),
		TYPE_PROCESS_STOP(""),
		TYPE_WARNING("esriGPMessageTypeWarning");
				
		
		private String val  = "";
		MessageType( String value ) {
			val = value; 
		}
		public String getValue() {
			return val;
		}
	}
	
	protected GPMessage() {}
	
	/**
	 * A description of the geoprocessing message.
	 * 
	 * @return String
	 */
	public final native String getDescription() /*-{
		return this.description;
	}-*/;
	
	/**
	 * The geoprocessing message type. 
	 * 
	 * @return MessageType
	 */
	public final MessageType getType() {
		String t = _getType();
		for( int i = 0 ; i < MessageType.values().length; i++ ){
			if( MessageType.values()[i].getValue().contentEquals(t) )
				return MessageType.values()[i];
		}
		return null;
	}

	private final native String _getType() /*-{
		return this.type;
	}-*/;

}
