package com.codetheroad.eds.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {
    protected String description;
    //protected int volumeCubicInches;
    // ...etc.

    public Item(String description) {
        this.description = description;
        //this.volumeCubicInches = volumeCubicInches;
    }

    public String getDescription() {
        return description;
    }

    /*
    public int getVolumeCubicInches() {
        return volumeCubicInches;
    }
    */
}
