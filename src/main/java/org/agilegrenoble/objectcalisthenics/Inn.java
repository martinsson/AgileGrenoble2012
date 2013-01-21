package org.agilegrenoble.objectcalisthenics;

import java.math.BigDecimal;
import java.util.List;

public class Inn {
	public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private List<Item> items;

	public Inn(List<Item> initialItems) {
		items = initialItems;
	}

	public void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			if (!items.get(i).getName().equals("Aged Brie")
					&& !items
							.get(i)
							.getName()
							.equals(BACKSTAGE_PASS)) {
				if (items.get(i).getQuality() > 0) {
					if (!items.get(i).getName()
							.equals("Sulfuras, Hand of Ragnaros")) {
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					}
				}
			} else {
				if (items.get(i).getQuality() < 50) {
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if (items
							.get(i)
							.getName()
							.equals(BACKSTAGE_PASS)) {
						if (items.get(i).getSellIn() < 11) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(
										items.get(i).getQuality() + 1);
							}
						}

						if (items.get(i).getSellIn() < 6) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(
										items.get(i).getQuality() + 1);
							}
						}
					}
				}
			}

			if (!items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			if (items.get(i).getSellIn() < 0) {
				if (!items.get(i).getName().equals("Aged Brie")) {
					if (!items
							.get(i)
							.getName()
							.equals(BACKSTAGE_PASS)) {
						if (items.get(i).getQuality() > 0) {
							if (!items.get(i).getName()
									.equals("Sulfuras, Hand of Ragnaros")) {
								items.get(i).setQuality(
										items.get(i).getQuality() - 1);
							}
						}
					} else {
						items.get(i).setQuality(
								items.get(i).getQuality()
										- items.get(i).getQuality());
					}
				} else {
					if (items.get(i).getQuality() < 50) {
						items.get(i).setQuality(items.get(i).getQuality() + 1);
					}
				}
			}
		}
	}

    public List<Item> getItems() {
        return items;
    }
}
