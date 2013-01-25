package org.agilegrenoble.objectcalisthenics;

import java.math.BigDecimal;
import java.util.List;

public class Inn {
	public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    List<Item> items;

	public Inn(List<Item> initialItems) {
		items = initialItems;
	}
	public Main main = new Main();
	public List<Item> getItems() {
        return items;
    }
}
