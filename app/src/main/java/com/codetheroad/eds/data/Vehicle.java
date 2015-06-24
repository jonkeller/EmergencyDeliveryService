package com.codetheroad.eds.data;

import com.google.android.gms.maps.model.LatLng;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vehicle {
    /** What is in the vehicle */
    protected Map<Item.Type, Integer> itemsOnBoard;

    /** Where the vehicle is */
    protected LatLng location;

    /** Where the vehicle needs to go */
    protected List<Destination> destinations;

    public Vehicle(LatLng location) {
        this(location, null, null);
    }

    public Vehicle(LatLng location, Map<Item.Type, Integer> itemsOnBoard) {
        this(location, itemsOnBoard, null);
    }

    public Vehicle(LatLng location, Map<Item.Type, Integer> itemsOnBoard, List<Destination> destinations) {
        this.location = location;
        this.itemsOnBoard = itemsOnBoard;
        this.destinations = destinations;
    }

    public Map<Item.Type, Integer> getItems() {
        return itemsOnBoard;
    }

    public void addItems(Map<Item.Type, Integer> items) {
        Iterator<Map.Entry<Item.Type, Integer>> it = items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Item.Type, Integer> pair = it.next();
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

    public void beginNavigationToNextDestination() {
        // TODO: Would notify user that help is on the way
    }

    public void addDestination(Destination destination) {
        // TODO Check if this destination already exists, if so then merge needs
        this.destinations.add(destination);
    }

    public void removeNeedsFromDestination() {
        // TODO
    }

    public void deliver(LatLng deliveryLocation) {
        // No longer need to go to this destination
        Iterator<Destination> destinationIterator = this.destinations.iterator();
        boolean foundIt = false;
        Destination destination = null;
        while (destinationIterator.hasNext()) {
            destination = destinationIterator.next();
            if (destination.getLocation().equals(deliveryLocation)) {
                foundIt = true;
                break;
            }
        }

        if (foundIt) {
            this.destinations.remove(destination);

            // Delivered items no longer on board
            Iterator<Map.Entry<Need, Integer>> needIterator = destination.getNeeds().entrySet().iterator();
            while (needIterator.hasNext()) {
                Map.Entry<Need, Integer> needEntry = needIterator.next();
                Need need = needEntry.getKey();
                int needQuantity = needEntry.getValue();
                
                Iterator<Map.Entry<Item.Type, Integer>> itemTypeIterator = need.getItems().entrySet().iterator();
                while (itemTypeIterator.hasNext()) {
                    Map.Entry<Item.Type, Integer> itemEntry = itemTypeIterator.next();
                    Item.Type itemType = itemEntry.getKey();
                    int itemTypeQuantityPerNeed = itemEntry.getValue();

                    // Remove (itemTypeQuantityPerNeed*needQuantity) instances of item from this.itemsOnBoard
                    offload(itemType, itemTypeQuantityPerNeed*needQuantity);
                }
            }
        }
    }

    public void deliverPartial(LatLng deliveryLocation, Map<Need, Integer> needsDelivered) {
        // TODO
    }

    protected void offload(Item.Type itemType, int quantityToOffload) {
        //protected Map<Item, Integer> itemsOnBoard;
        if (itemsOnBoard.containsKey(itemType)) {
            int quantityOnboard = itemsOnBoard.get(itemType);
            int newQuantity = quantityOnboard - quantityToOffload;
            if (newQuantity > 0) {
                itemsOnBoard.put(itemType, newQuantity);
            } else {
                itemsOnBoard.remove(itemType);
            }
        }
    }
}
