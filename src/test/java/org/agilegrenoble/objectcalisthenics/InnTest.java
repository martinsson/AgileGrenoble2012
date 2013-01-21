package org.agilegrenoble.objectcalisthenics;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class InnTest {
    private Inn inn;

    @Before
    public void setup() {
        inn = Main.makeInn();
    }
    
    @Test public void 
    after_one_day() throws Exception {
        inn.updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
        assertThat(qualities).containsOnly(19, 1, 6, 80, 21, 5);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
        assertThat(sellIns).containsOnly(9, 1, 4, 0, 14, 2);
    }
    
    @Test public void 
    after_three_days() throws Exception {
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
        assertThat(qualities).containsOnly(17, 4, 4, 80, 23, 3);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
        assertThat(sellIns).containsOnly(7, -1, 2, 0, 12, 0);
    }
    
    @Test public void 
    after_a_shitload_of_days() throws Exception {
         for (int i = 0; i < 500; i++) {
            inn.updateQuality();
        }
         Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
         assertThat(qualities).containsOnly(0, 50, 0, 80, 0, 0);
         Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
         assertThat(sellIns).containsOnly(-490, -498, -495, 0, -485, -497);
    }
    
    Random rand = new Random(3456789);
    @Test public void 
    backstage_pass() throws Exception {
        List<Item> listOfPasses = asList(
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()), 
                makeBackstagePass(quality(), sellIn()) );
        Inn inn = new Inn(listOfPasses);
        inn.updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
        assertThat(qualities).containsOnly(20, 27, 35, 6, 1, 46, 38);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
        assertThat(sellIns).containsOnly(371, 282, 53, 162, 41, 93, 142);
    }

    private int sellIn() {
        return rand.nextInt(400);
    }

    private int quality() {
        return rand.nextInt(50);
    }

    private Item makeBackstagePass(int quality, int sellIn) {
        Item backstagePass = new Item(Inn.BACKSTAGE_PASS, sellIn, quality);
        return backstagePass;
    }

}
