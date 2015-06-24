package com.codetheroad.eds.data;

// At this point, we don't really need to instantiate Item since one bottle of water (for
// example) will be viewed as interchangeable with any other bottle of water. So we only
// need to track the quantity of each type.

public class Item {
    public static enum Type { TARP, TENT, FLASHLIGHT, CAMP_STOVE, PILLOW, SLEEPING_BAG, DUCT_TAPE,
        BLANKET, CLOTHING, GLOVES, WATER, SUNSCREEN, HYGIENE_KIT, TOILET_PAPER, TOWEL,
        LARGE_BANDAGE, FIRST_AID_KIT, FOOD, BABY_FORMULA };

    /*
    //protected Type type;
    //protected int volumeCubicInches;
    // ...etc.

    public Item(String description) {
        this.type = type;
        //this.volumeCubicInches = volumeCubicInches;
    }

    public Type getType() {
        return this.type;
    }

    public int getVolumeCubicInches() {
        return volumeCubicInches;
    }
    */
}
