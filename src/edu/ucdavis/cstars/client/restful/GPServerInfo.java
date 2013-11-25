package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class GPServerInfo extends JavaScriptObject {
    
    protected GPServerInfo() {}
    
    public final native String getName() /*-{
        if( this.name ) return this.name;
        return "";
    }-*/;
    
    public final native String getDisplayName() /*-{
        if( this.displayName ) return this.displayName;
        return "";
    }-*/;
    
    public final native String getDescription() /*-{
        if( this.description ) return this.description;
        return "";
    }-*/;
    
    public final native String getCategory() /*-{
        if( this.category ) return this.category;
        return "";
    }-*/;
    
    public final native String getHelpUrl() /*-{
        if( this.helpUrl ) return this.helpUrl;
        return "";
    }-*/;
    
    public final native String getExecutionType() /*-{
        if( this.executionType ) return this.executionType;
        return "";
    }-*/;
    
    public final native JsArray<GPServerParameterInfo> getParameters() /*-{
        if( this.parameters ) return this.parameters;
        return [];
    }-*/;

}
