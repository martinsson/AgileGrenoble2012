package org.agilegrenoble.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20, new SellIn(sellIn), new Quality(quality)));
		items.add(new Item("Aged Brie", 2, 0, new SellIn(sellIn), new Quality(quality)));
		items.add(new Item("Elixir of the Mongoose", 5, 7, new SellIn(sellIn), new Quality(quality)));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80, new SellIn(sellIn), new Quality(quality)));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, new SellIn(sellIn), new Quality(quality)));
		items.add(new Item("Conjured Mana Cake", 3, 6, new SellIn(sellIn), new Quality(quality)));
		new Inn(items).updateQuality();
	}

}
