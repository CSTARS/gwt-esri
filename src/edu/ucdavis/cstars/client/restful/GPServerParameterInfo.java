package edu.ucdavis.cstars.client.restful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class GPServerParameterInfo extends JavaScriptObject {

    protected GPServerParameterInfo() {}
    
    public final native String getName() /*-{
        if( this.name ) return this.name;
        return "";
    }-*/;
    
    public final native String getDataType() /*-{
        if( this.dataType ) return this.dataType;
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
    
    public final native String getDirection() /*-{
        if( this.direction ) return this.direction;
        return "";
    }-*/;
    
    public final native String getDefaultValue() /*-{
        if( this.defaultValue ) return this.defaultValue;
        return "";
    }-*/;
    
    public final native String getParameterType() /*-{
        if( this.parameterType ) return this.parameterType;
        return "";
    }-*/;
    
    public final native String getCategory() /*-{
        if( this.category ) return this.category;
        return "";
    }-*/;
    
    public final native JsArrayString getChoiceList() /*-{
        if( this.choiceList ) return this.choiceList;
        return [];
    }-*/;
    
}
