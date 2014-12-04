package edu.ucdavis.cstars.client.callback;

import edu.ucdavis.cstars.client.event.ErrorHandler;
import edu.ucdavis.cstars.client.event.PrintTaskHandler;

/**
 * The function to call when the print method has completed. 
 * 
 * @author Justin Merz
 */
public interface PrintTaskCallback extends PrintTaskHandler, ErrorHandler {}
