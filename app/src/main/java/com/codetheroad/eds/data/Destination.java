package com.codetheroad.eds.data;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Destination {
    protected LatLng location;
    protected ContactInfo contactInfo;
    protected List<Need> needs;

    public Destination(LatLng location, List<Need> needs, ContactInfo contactInfo) {
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

    public List<Need> getNeeds() {
        return needs;
    }

    /** This destination now needs something else */
    public void addNeed(Need need) {
        needs.add(need);
    }

    /** This destination stopped needing something */
    public void removeNeed(Need need) {
        needs.remove(need);
    }

    /**
     * Get the highest priority of all needs at this destination
     * TODO: This could be improved since a location with 100 injuries is a bigger deal than
     * a location with 2 of the same injuries.
     */
    public int getPriority() {
        int priority = Need.MIN_PRIORITY;
        for (Need need : needs) {
            if (need.getPriority() > priority) {
                priority = need.getPriority();
            }
        }
        return priority;
    }
}
