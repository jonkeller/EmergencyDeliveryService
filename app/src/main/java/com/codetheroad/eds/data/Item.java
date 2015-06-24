package com.codetheroad.eds.data;

public class Item {
    protected String description;
    protected int volumeCubicInches;
    // ...etc.

    public Item(String description, int volumeCubicInches) {
        this.description = description;
        this.volumeCubicInches = volumeCubicInches;
    }

    public String getDescription() {
        return description;
    }

    public int getVolumeCubicInches() {
        return volumeCubicInches;
    }
}
