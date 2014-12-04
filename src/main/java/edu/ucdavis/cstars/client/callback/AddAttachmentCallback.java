package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.AddAttachmentHandler;
import edu.ucdavis.cstars.client.event.ErrorHandler;

/**
 * Fires when addAttachments() is complete.
 * 
 * @author Justin Merz
 */
public interface AddAttachmentCallback extends ErrorHandler, AddAttachmentHandler {}
