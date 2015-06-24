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
    protected Map<Item, Integer> items;

    /** The triage priority of satisfying this need */
    protected int priority;

    public Need(Map<Item, Integer> items, int priority) {
        this.items = items;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    // Convenience method
    public int getQuantityNeededOf(Item item) {
        return items.get(item);
    }

    /**
     * Implements for instance that the "shelter" need = 1x sleeping bag + 1x tent + etc.
     * TODO: Make String constants for all of these.
     */
    public static Need fromCategory(String category) {
        Map<Item, Integer> items = new HashMap<Item, Integer>();
        int priority = MIN_PRIORITY;
        if (SHELTER.equals(category)) {
            items.put(new Item("tarp"), 1);
            items.put(new Item("tent"), 1);
            items.put(new Item("flashlight"), 1);
            items.put(new Item("camp stove"), 1);
            items.put(new Item("pillow"), 2);
            items.put(new Item("sleeping bag"), 2);
            items.put(new Item("duct tape"), 4);
            priority = 6;
        } else if (COLD.equals(category)) {
            items.put(new Item("blanket"), 1);
            items.put(new Item("clothing"), 2);
            items.put(new Item("gloves"), 1);
            priority = 5;
        } else if (HEAT.equals(category)) {
            items.put(new Item("water"), 12);
            items.put(new Item("sunscreen"), 1);
            priority = 4;
        } else if (HYGIENE.equals(category)) {
            items.put(new Item("hygiene kit"), 4);
            items.put(new Item("toilet paper"), 3);
            priority = 2;
        } else if (MEDICAL.equals(category)) {
            items.put(new Item("large bandage"), 4);
            items.put(new Item("first aid kit"), 1);
            priority = 10;
        } else if (MEAL.equals(category)) {
            items.put(new Item("food"), 6);
            items.put(new Item("water"), 12);
            items.put(new Item("baby formula"), 4);
            priority = 8;
        } else {
            // TODO throw...
        }
        return new Need(items, priority);
    }
}
