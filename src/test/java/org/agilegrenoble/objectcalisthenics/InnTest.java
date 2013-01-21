package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;
import static org.junit.Assert.*;

import org.junit.Test;

public class InnTest {
    @Test public void 
    after_one_day() throws Exception {
        Inn inn = Main.makeInn();
        inn.updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
        assertThat(qualities).containsOnly(19, 1, 6, 80, 21, 5);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
        assertThat(sellIns).containsOnly(9, 1, 4, 0, 14, 2);
    }
    
    @Test public void 
    after_three_days() throws Exception {
        Inn inn = Main.makeInn();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        Iterable<Integer> qualities = extractProperty("quality", Integer.class).from(inn.getItems());
        assertThat(qualities).containsOnly(17, 4, 4, 80, 23, 3);
        Iterable<Integer> sellIns = extractProperty("sellIn", Integer.class).from(inn.getItems());
        assertThat(sellIns).containsOnly(7, -1, 2, 0, 12, 0);
         
    }

}
