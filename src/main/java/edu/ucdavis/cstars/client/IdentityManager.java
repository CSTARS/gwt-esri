package edu.ucdavis.cstars.client;


/**
 * This singleton class is automatically instantiated when the module containing this class is imported into the application. This class 
 * extends esri.IdentityManagerBase so it inherits is properties and methods.
 * 
 * This class provides the framework and helper methods required to implement a solution for managing user credentials for the following resources:
 * 	ArcGIS Server resources secured using token-based authentication. Note that only ArcGIS Server versions 10 SP 1 and greater are supported.
 * 	Secured ArcGIS.com resources (i.e. web maps).
 * 
 * @author Justin Merz
 */
public abstract class IdentityManager extends IdentityManagerBase {
	
	protected IdentityManager(){};
	
	/**
	 * This method is called by the base identity manager implementation. When invoked, this method will do the following:
	 * 	Display a modal dialog box for the application end-user to enter username and password.
	 * 	Generate a token and creates a Credential object.
	 * 	Return the Credential object to the caller (IdentityManagerBase) via a Deferred object.
	 */
	//public abstract Deferred signIn();

}
