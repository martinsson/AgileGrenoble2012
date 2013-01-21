package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class InnTest {
    @Test public void 
    testname() throws Exception {
        Inn inn = Main.makeInn();
        inn.updateQuality();
        assertThat(inn.getItems()).isNotNull();
    }
}
