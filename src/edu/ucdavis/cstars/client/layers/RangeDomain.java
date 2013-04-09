package edu.ucdavis.cstars.client.layers;

/**
 * Information about the range of values belonging to the domain. Range domains specify a valid range of values for a numeric attribute.
 * 
 * @author Justin Merz
 */
public class RangeDomain extends Domain {
	
	protected RangeDomain() {}
	
	/**
	 * The maximum valid value.
	 * 
	 * @return double
	 */
	public final native double getMaxValue() /*-{
		return this.maxValue;
	}-*/;

	/**
	 * The minimum valid value.
	 * 
	 * @return double
	 */
	public final native double getMinValue() /*-{
		return this.minValue;
	}-*/;
	
}
