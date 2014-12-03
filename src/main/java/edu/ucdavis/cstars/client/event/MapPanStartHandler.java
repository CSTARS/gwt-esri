package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

public interface MapPanStartHandler {
	public void onMapPanStart(Extent extent, Point startPoint);
}
