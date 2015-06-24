package com.codetheroad.eds.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Need {
    public static final int MIN_PRIORITY = 0;
    public static final int MAX_PRIORITY = 10;
    public static final String SHELTER = "shelter";
    public static final String COLD = "cold exposure";
    public static final String HEAT = "heat exposure";
    public static final String HYGIENE = "hygiene";
    public static final String MEDICAL = "medical";
    public static final String MEAL = "meal";

    /** What items+quantities needed to satisfy one occurrence of this need */
    protected Map<Item.Type, Integer> itemTypes;

    /** The triage priority of satisfying this need */
    protected int priority;

    public Need(Map<Item.Type, Integer> itemTypes, int priority) {
        this.itemTypes = itemTypes;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public Map<Item.Type, Integer> getItems() {
        return itemTypes;
    }

    // Convenience method
    public int getQuantityNeededOf(Item.Type itemType) {
        return itemTypes.get(itemType);
    }

    /**
     * Implements for instance that the "shelter" need = 1x sleeping bag + 1x tent + etc.
     * TODO: Make String constants for all of these.
     */
    public static Need fromCategory(String category) {
        Map<Item.Type, Integer> itemTypes = new HashMap<Item.Type, Integer>();
        int priority = MIN_PRIORITY;
        if (SHELTER.equals(category)) {
            itemTypes.put(Item.Type.TARP, 1);
            itemTypes.put(Item.Type.TENT, 1);
            itemTypes.put(Item.Type.FLASHLIGHT, 1);
            itemTypes.put(Item.Type.CAMP_STOVE, 1);
            itemTypes.put(Item.Type.PILLOW, 2);
            itemTypes.put(Item.Type.SLEEPING_BAG, 2);
            itemTypes.put(Item.Type.DUCT_TAPE, 4);
            priority = 6;
        } else if (COLD.equals(category)) {
            itemTypes.put(Item.Type.BLANKET, 1);
            itemTypes.put(Item.Type.CLOTHING, 2);
            itemTypes.put(Item.Type.GLOVES, 1);
            priority = 5;
        } else if (HEAT.equals(category)) {
            itemTypes.put(Item.Type.WATER, 12);
            itemTypes.put(Item.Type.SUNSCREEN, 1);
            priority = 4;
        } else if (HYGIENE.equals(category)) {
            itemTypes.put(Item.Type.HYGIENE_KIT, 4);
            itemTypes.put(Item.Type.TOILET_PAPER, 3);
            itemTypes.put(Item.Type.TOWEL, 1);
            priority = 2;
        } else if (MEDICAL.equals(category)) {
            itemTypes.put(Item.Type.LARGE_BANDAGE, 4);
            itemTypes.put(Item.Type.FIRST_AID_KIT, 1);
            priority = 10;
        } else if (MEAL.equals(category)) {
            itemTypes.put(Item.Type.FOOD, 6);
            itemTypes.put(Item.Type.WATER, 12);
            itemTypes.put(Item.Type.BABY_FORMULA, 4);
            priority = 8;
        } else {
            // TODO throw...
        }
        return new Need(itemTypes, priority);
    }
}
