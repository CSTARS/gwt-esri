package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

public interface MapPanHandler {
	public void onMapPan(Extent extent, Point delta);
}
