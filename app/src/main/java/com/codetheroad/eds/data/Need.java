package com.codetheroad.eds.data;

import java.util.Map;

public class Need {
    public static final int MIN_PRIORITY = 0;
    public static final int MAX_PRIORITY = 10;

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
}
