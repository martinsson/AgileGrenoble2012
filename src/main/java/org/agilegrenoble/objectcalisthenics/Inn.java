package org.agilegrenoble.objectcalisthenics;

import java.util.List;

public class Inn {
    private List<Item> items;

    public Inn(List<Item> initialItems) {
        items = initialItems;
    }

    public void updateQuality() {
        for (Item item : items)
            item.update();
    }
}
