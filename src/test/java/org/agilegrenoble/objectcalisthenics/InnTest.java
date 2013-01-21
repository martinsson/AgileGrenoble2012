package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;
import static org.junit.Assert.*;

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

}
