package com.codetheroad.eds.data;

// At this point, we don't really need to instantiate Item since one bottle of water (for
// example) will be viewed as interchangeable with any other bottle of water. So we only
// need to track the quantity of each type.

public class Item {
    public static enum Type { TARP, TENT, FLASHLIGHT, CAMP_STOVE, PILLOW, SLEEPING_BAG, DUCT_TAPE,
        BLANKET, CLOTHING, GLOVES, WATER, SUNSCREEN, HYGIENE_KIT, TOILET_PAPER, TOWEL,
        LARGE_BANDAGE, FIRST_AID_KIT, FOOD, BABY_FORMULA };

    public static String typeToString(Type itemType) {
        switch (itemType) {
            case TARP: return "tarp";
            case TENT: return "tent";
            case FLASHLIGHT: return "flashlight";
            case CAMP_STOVE: return "camp stove";
            case PILLOW: return "pillow";
            case SLEEPING_BAG: return "sleeping bag";
            case DUCT_TAPE: return "duct tape";
            case BLANKET: return "blanket";
            case CLOTHING: return "clothing";
            case GLOVES: return "gloves";
            case WATER: return "water";
            case SUNSCREEN: return "sunscreen";
            case HYGIENE_KIT: return "hygiene kit";
            case TOILET_PAPER: return "toilet paper";
            case TOWEL: return "towel";
            case LARGE_BANDAGE: return "large bandage";
            case FIRST_AID_KIT: return "first aid kit";
            case FOOD: return "food";
            case BABY_FORMULA: return "baby formula";
        }
        return null;
    }

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
