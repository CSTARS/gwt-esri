package edu.ucdavis.cstars.client.dijits;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.ucdavis.cstars.client.TimeExtent;
import edu.ucdavis.cstars.client.Util;
import edu.ucdavis.cstars.client.event.DijitLoadHandler;
import edu.ucdavis.cstars.client.event.TimeExtentChangeHandler;
import edu.ucdavis.cstars.client.layers.TimeInfo.TimeUnits;

/**
 * Widget for visualizing time enabled layers.
 * 
 * @author Justin Merz
 */
public class TimeSlider extends Composite {
	
	private SimplePanel panel = new SimplePanel();
	private Parameters parameters;
	protected JavaScriptObject jso;
	private DijitLoadHandler loadHandler = null;
	
	/**
	 * Creates a new TimeSlider object.
	 * 
	 * @param params - Parameters for the time slider object.
	 * @param loadHandler - handler to fire when dijit is created.  All method calls will fail untill this
	 * event fires. 
	 */	
	public TimeSlider(Parameters params, DijitLoadHandler handler) {
		
		if( !assertLoaded() ) return; 
		
		loadHandler = handler;
		parameters = params;
		
		initWidget(panel);
		
		addAttachHandler(new Handler(){
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if( event.isAttached() && jso == null ) {
					jso = _create(parameters, panel.getElement());
					if( loadHandler != null ) loadHandler.onLoad();
				}
			}
		});
		
	}
	
	private native JavaScriptObject _create(Parameters params, Element ele) /*-{
		return new $wnd.esri.dijit.TimeSlider(params, ele);
	}-*/;
	
	/**
	 * Check that the esri.dijit.TimeSlider package has been loaded
	 * 
	 * @return boolean
	 */
	public static native boolean assertLoaded() /*-{
		if( $wnd.esri.dijit.TimeSlider ) return true;
		$wnd.alert("The ESRI_DIJIT_TIMESLIDER package has not been loaded");
		return false;
	}-*/;
	
	public JavaScriptObject getTimeSliderObject() {
		return jso;
	}

	/**
	 * Default value is false.
	 * 
	 * @return boolean
	 */
	public native boolean isLoop() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.loop;
	}-*/;
	
	/**
	 * Default value is false.
	 * 
	 * @return boolean
	 */
	public native boolean isPlaying() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.playing;
	}-*/;
	
	/**
	 * Default value is 1.
	 * 
	 * @return int
	 */
	public native int getThumbCount() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.thumbCount;
	}-*/;
	
	/**
	 * Rate at which the time animation plays. Default value is 1000 milliseconds.
	 * 
	 * @return int
	 */
	public native int getThumbMovingRate() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.thumbMovingRate;
	}-*/;

	/**
	 * An array of dates representing the stops (tics) on the TimeSlider.
	 * 
	 * @return JsArray<JsDate>
	 */
	public native JsArray<JsDate> getTimeStops() /*-{
		return this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.timeStops;
	}-*/;
	
	/**
	 * The specified number of time stops are created for the input time extent.
	 * 
	 * @param timeExtent - The time extent used to define the time slider's start and end time stops.
	 */
	public native void createTimeStopsByCount(TimeExtent timeExtent) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.createTimeStopsByCount(timeExtent);
	}-*/;
	
	/**
	 * The specified number of time stops are created for the input time extent.
	 * 
	 * @param timeExtent - The time extent used to define the time slider's start and end time stops.
	 * @param count - The number of time stops to create.
	 */
	public native void createTimeStopsByCount(TimeExtent timeExtent, int count) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.createTimeStopsByCount(timeExtent, count);
	}-*/;

	/**
	 * Create a time stop for each interval specified, i.e.(week,month, day).
	 * 
	 * @param timeExtent - The time extent used to define the time slider's start and end time stops.
	 */
	public native void createTimeStopsByTimeInterval(TimeExtent timeExtent) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.createTimeStopsByTimeInterval(timeExtent);
	}-*/;

	/**
	 * Create a time stop for each interval specified, i.e.(week,month, day).
	 * 
	 * @param timeExtent - The time extent used to define the time slider's start and end time stops.
	 * @param timeInterval - The length of the time interval.
	 * @param timeIntervalUnits - Time units.
	 */
	public void createTimeStopsByTimeInterval(TimeExtent timeExtent, int timeInterval, TimeUnits timeIntervalUnits) {
		_createTimeStopsByTimeInterval(timeExtent, timeInterval, timeIntervalUnits.getValue());
	}
	
	private native void _createTimeStopsByTimeInterval(TimeExtent timeExtent, int timeInterval, String timeIntervalUnits) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.createTimeStopsByTimeInterval(timeExtent, timeInterval, timeIntervalUnits);
	}-*/;
	
	/**
	 * Gets the current time extent for the time slider.
	 * 
	 * @return TimeExtent
	 */
	public native TimeExtent getCurrentTimeExtent() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.getCurrentTimeExtent();
	}-*/;
	
	/**
	 * Move to the next time step.
	 */
	public native void next() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.next();
	}-*/;
	
	/**
	 * Pause the time slider.
	 */
	public native void pause() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.pause();
	}-*/;
	
	/**
	 * Play the time slider.
	 */
	public native void play() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.play();
	}-*/;
	
	/**
	 * Move to the previous time step.
	 */
	public native void previous() /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.previous();
	}-*/;
	
	/**
	 * Specify an array of strings to be used as labels. The array position
	 * for each string defines which tick it will be placed on.
	 * 
	 * @param labels - An array of strings that define the labels for each tick.
	 */
	public void setLabels(String[] labels) {
		JavaScriptObject arr = JavaScriptObject.createArray();
		for( int i = 0; i < labels.length; i++ ) Util.addStringToArray( labels[i], arr );
		_setLabels(arr);
	};
	
	private native void _setLabels(JavaScriptObject array) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setLabels(array);
	}-*/;
	
	/**
	 * Determines whether or not loop. Default value is false.
	 * 
	 * @param loop - True plays the time slider continuously. Default value is false.
	 */
	public native void setLoop(boolean loop) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setLoop(loop);
	}-*/;
	
	/**
	 * The number of thumbs to display. A value of one displays a single thumb. Setting the
	 * value to 2 displays a range slider.
	 * 
	 * @param thumbCount - The number of thumbs to display. Default value is one.
	 */
	public native void setThumbCount(int thumbCount) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setThumbCount(thumbCount);
	}-*/;
	
	/**  
	 * 
	 * @param first - determinds where to put the first thumb.
	 * @param second - If it is a two thumb slider the second value determines where to place the additional thumb.
	 */
	public native void setThumbIndexes(int first, int second) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setThumbIndexes([first, second]);
	}-*/;
	
	/**
	 * Change the rate at which the time animation plays.
	 * 
	 * @param thumbMovingRate - The rate at which the time slider plays. Default value is 1500.
	 */
	public native void setThumbMovingRate(int thumbMovingRate) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setThumbMovingRate(thumbMovingRate);
	}-*/;
	
	/**
	 * Specify the number of ticks to display on the time slider.
	 * 
	 * @param tickCount - The number of ticks to display on the slider.
	 */
	public native void setTickCount(int tickCount) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setTickCount(tickCount);
	}-*/;
	
	/**
	 * Manually define the time stop locations by providing an array of dates.
	 * 
	 * @param stops - Array of dates
	 */
	public void setTimeStops(JsDate[] stops) {
		JavaScriptObject arr = JavaScriptObject.createObject();
		for( int i = 0; i < stops.length; i++ ) Util.addObjectToArray( stops[i], arr );
		_setTimeStops(arr);
	}
	
	private native void _setTimeStops(JavaScriptObject array) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.setTimeStops(array);
	}-*/;

	/**
	 * Determine if the time is displayed for an instant in time. Only valid when the thumb
	 * count is set to one.
	 * 
	 * @param createTimeInstants - When true, the time slider displays features for the
	 * current point in time. When false cumulative data is displayed from the start time
	 * to the current thumb location. The default value is false.
	 */
	public native void singleThumbAsTimeInstant(boolean createTimeInstants) /*-{
		this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.singleThumbAsTimeInstant(createTimeInstants);
	}-*/;

	/**
	 * This is not in the docs but in the examples.  Required to start the dijit.  Seems to error so
	 * I have wrapped it up till the bug is figured out.
	 */
	public native void startup() /*-{
		try {
			this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso.startup()();
		} catch (e) {}
	}-*/;
	
	/**
	 * Add time extent changed handler.
	 * 
	 * @param handler - Fires when the timeExtent of the TimeSlider is changed.
	 */
	public final native void addTimeExtentChangeHandler(TimeExtentChangeHandler handler ) /*-{
		$wnd.dojo.connect(
		 	this.@edu.ucdavis.cstars.client.dijits.TimeSlider::jso,
		 	"onTimeExtentChange",
		 	function(timeExtent) {
		 		handler.@edu.ucdavis.cstars.client.event.TimeExtentChangeHandler::onTimeExtentChange(Ledu/ucdavis/cstars/client/TimeExtent;)(timeExtent);
			}
		);
	}-*/;
	
	public static class Parameters extends JavaScriptObject {
	
		protected Parameters() {}
		
		public static native Parameters create(int width) /*-{
			var w = "width: "+width+"px;}";
			return {"style": w};
		}-*/;
		
		/**
		 * 
		 * @param excludeDataAtLeadingThumb - When true, subtracts one second to the time extent's end time to exclude data at
		 * the exact end time instant.
		 */
		public native final void setExcludeDataAtLeadingThumb(boolean excludeDataAtLeadingThumb) /*-{
			this["excludeDataAtLeadingThumb"] = excludeDataAtLeadingThumb;
		}-*/;
		
		/**
		 * 
		 * @param excludeDataAtTrailingThumb - When true, adds one second to the time extent's start time to exclude data at
		 * the exact start time instant.
		 */
		public native final void setExcludeDataAtTrailingThumb(boolean excludeDataAtTrailingThumb) /*-{
			this["excludeDataAtTrailingThumb"] = excludeDataAtTrailingThumb;
		}-*/;
		
	}
	
}
