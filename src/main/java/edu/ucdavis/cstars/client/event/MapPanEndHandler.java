package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.geometry.Extent;
import edu.ucdavis.cstars.client.geometry.Point;

public interface MapPanEndHandler {
	public void onMapPanEnd(Extent extent, Point endPoint);
}
