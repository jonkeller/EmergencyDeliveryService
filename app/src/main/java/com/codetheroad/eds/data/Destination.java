package com.codetheroad.eds.data;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Destination {
    protected LatLng location;
    protected ContactInfo contactInfo;
    protected Map<Need, Integer> needs;

    public Destination(LatLng location, Map<Need, Integer> needs, ContactInfo contactInfo) {
        this.location = location;
        this.contactInfo = contactInfo;
        this.needs = needs;
    }

    public LatLng getLocation() {
        return location;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public Map<Need, Integer> getNeeds() {
        return needs;
    }

    /** This destination now needs something else */
    public void addNeed(Need need, int quantity) {
        if (needs.containsKey(need)) {
            int previousQuantity = needs.get(need);
            needs.put(need, quantity + previousQuantity);
        } else {
            needs.put(need, quantity);
        }
    }

    /** This destination stopped needing something */
    public void removeNeed(Need need, int quantity) {
        if (needs.containsKey(need)) {
            int previousQuantity = needs.get(need);
            int newQuantity = previousQuantity - quantity;
            if (newQuantity > 0) {
                needs.put(need, newQuantity);
            } else {
                needs.remove(need);
            }
        }
    }

    /**
     * Get the highest priority of all needs at this destination
     * TODO: This could be improved since a location with 100 injuries is a bigger deal than
     * a location with 2 of the same injuries.
     */
    public int getPriority() {
        int maxPriority = Need.MIN_PRIORITY;

        Iterator<Map.Entry<Need, Integer>> it = needs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Need, Integer> pair = it.next();
            int thisPriority = pair.getKey().getPriority();
            if (thisPriority > maxPriority) {
                maxPriority = thisPriority;
            }
        }

        return maxPriority;
    }

    public Map<Item.Type, Integer> getItemsRequested() {
        Map<Item.Type, Integer> itemsAcrossAllNeeds = new HashMap<Item.Type, Integer>();
        Iterator<Map.Entry<Need, Integer>> it = needs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Need, Integer> pair = it.next();
            Need need = pair.getKey();
            int quantityOfNeeds = pair.getValue();
            Iterator<Map.Entry<Item.Type, Integer>> it2 = need.getItems().entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<Item.Type, Integer> itemPair = it2.next();
                Item.Type itemType = itemPair.getKey();
                int itemQuantityPerNeed = itemPair.getValue();
                if (itemsAcrossAllNeeds.containsKey(itemType)) {
                    int previousQuantity = itemsAcrossAllNeeds.get(itemType);
                    itemsAcrossAllNeeds.put(itemType, previousQuantity + itemQuantityPerNeed * quantityOfNeeds);
                } else {
                    itemsAcrossAllNeeds.put(itemType, itemQuantityPerNeed * quantityOfNeeds);
                }
            }
        }
        return itemsAcrossAllNeeds;
    }

    public String getNeedsAsString() {
        Map<Item.Type, Integer> itemsRequested = getItemsRequested();

        StringBuffer buf = new StringBuffer();
        Iterator<Map.Entry<Item.Type, Integer>> it3 = itemsRequested.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<Item.Type, Integer> entry = it3.next();
            Item.Type itemType = entry.getKey();
            int quantity = entry.getValue();
            if (buf.length() != 0) {
                buf.append(", ");
            }
            buf.append("" + quantity + " " + Item.typeToString(itemType));
        }
        return buf.toString();
    }

}
