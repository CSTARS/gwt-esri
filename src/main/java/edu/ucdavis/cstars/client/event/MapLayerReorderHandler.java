package edu.ucdavis.cstars.client.event;

import edu.ucdavis.cstars.client.layers.Layer;

public interface MapLayerReorderHandler {
	public void onLayerReorder(Layer layer, int index);
}
