package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;

public interface MapResizeHandler {
	public void onMapResize(Extent extent, int width, int height);
}
