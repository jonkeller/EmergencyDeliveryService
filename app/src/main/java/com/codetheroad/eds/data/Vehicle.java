package com.codetheroad.eds.data;

import com.google.android.gms.maps.model.LatLng;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vehicle {
    /** What is in the vehicle */
    protected Map<Item, Integer> itemsOnBoard;

    /** Where the vehicle is */
    protected LatLng location;

    /** Where the vehicle needs to go */
    protected List<Destination> destinations;

    public Vehicle(LatLng location) {
        this(location, null, null);
    }

    public Vehicle(LatLng location, Map<Item, Integer> itemsOnBoard) {
        this(location, itemsOnBoard, null);
    }

    public Vehicle(LatLng location, Map<Item, Integer> itemsOnBoard, List<Destination> destinations) {
        this.location = location;
        this.itemsOnBoard = itemsOnBoard;
        this.destinations = destinations;
    }

    public Map<Item, Integer> getItems() {
        return itemsOnBoard;
    }

    public void addItems(Map<Item, Integer> items) {
        Iterator<Map.Entry<Item, Integer>> it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Item, Integer> pair = it.next();
            if (itemsOnBoard.containsKey(pair.getKey())) {
                int previousQuantity = itemsOnBoard.get(pair.getKey());
                itemsOnBoard.put(pair.getKey(), pair.getValue() + previousQuantity);
            } else {
                itemsOnBoard.put(pair.getKey(), pair.getValue());
            }
        }
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
