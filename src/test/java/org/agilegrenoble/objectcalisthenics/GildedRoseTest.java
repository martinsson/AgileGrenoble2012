package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.agilegrenoble.objectcalisthenics.GildedRose.Stock;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
    private GildedRose gildedRose;
    private List<Item> items;
    private Random rand = new Random(3456789);

    @Before
    public void setup() {
        gildedRose = new GildedRose();
        items = gildedRose.makeItems();
    }
    
    @Test public void 
    after_one_day() throws Exception {
        updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(items);
        assertThat(qualities).containsOnly(19, 1, 6, 80, 21, 5);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(items);
        assertThat(sellIns).containsOnly(9, 1, 4, 0, 14, 2);
    }

    private void updateQuality() {
        Stock stock = new Stock(items);
        stock.updateQuality();
    }

    @Test public void 
    after_three_days() throws Exception {
        updateQuality();
        updateQuality();
        updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(items);
        assertThat(qualities).containsOnly(17, 4, 4, 80, 23, 3);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(items);
        assertThat(sellIns).containsOnly(7, -1, 2, 0, 12, 0);
    }
    
    @Test public void 
    after_a_shitload_of_days() throws Exception {
         for (int i = 0; i < 500; i++) {
            updateQuality();
        }
         Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(items);
         assertThat(qualities).containsOnly(0, 50, 0, 80, 0, 0);
         Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(items);
         assertThat(sellIns).containsOnly(-490, -498, -495, 0, -485, -497);
    }
    
    @Test public void 
    backstage_pass() throws Exception {
        List<Item> items2 = aBunchOfBackstagePasses();
        updateQualityManyTimes(items2);
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(items2);
        assertThat(qualities).containsOnly(30, 48, 45, 0, 11, 0, 0, 0, 36, 15, 33, 50, 50, 27, 0, 26, 42, 50, 0, 50, 50, 0, 29, 0, 0, 36, 50, 41, 50,
                0, 49, 25, 0, 12, 0, 50, 0, 0, 0, 43, 0, 50, 23, 27, 33, 0, 0, 37, 0, 43, 0, 0, 45, 50, 22, 43, 0, 30, 14, 44, 50, 0, 17, 0, 17, 50,
                16, 50, 19, 44, 0, 0, 37, 34, 0, 0, 0, 50, 0, 29, 40, 50, 50, 47, 0, 0, 47, 0, 26, 11, 26, 16, 0, 50, 0, 0, 0, 35, 0, 50);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(items2);
        assertThat(sellIns).containsOnly(1, 18, -7, 6, 8, 16, -8, 6, 4, -9, 4, -2, -9, 8, 14, 7, 9, -9, 12, 2, -9, 12, -7, 5, -6, -1, -11, 2, -4, 9,
                4, 15, 13, -4, -4, 12, -7, 9, -4, -7, 4, 0, 11, 6, -8, 3, 17, 12, 9, -4, 13, -5, 10, 4, 14, 6, 14, 1, -5, -3, 15, 11, -2, -6, -2, 2,
                -11, 17, 10, 18, 2, 14, -8, -5, 1, -1, 0, 14, 7, 9, -3, 2, -9, -1, -6, 5, -5, 8, -5, 11, 3, 17, 17, 13, 5, 11, 16, -3, 6, 11);
    }

    private void updateQualityManyTimes(List<Item> list) {
        for (int i = 0; i < 11; i++) {
            Stock stock = new Stock(list);
            stock.updateQuality();
        }
    }

    private List<Item> aBunchOfBackstagePasses() {
        List<Item> listOfPasses = new ArrayList<Item>();
        for (int i = 0; i < 100; i++) {
            listOfPasses.add(makeBackstagePass(quality(), sellIn()));
        }
        return listOfPasses;
    }

    private int sellIn() {
        return rand.nextInt(30);
    }

    private int quality() {
        return rand.nextInt(50);
    }

    private Item makeBackstagePass(int quality, int sellIn) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

}
