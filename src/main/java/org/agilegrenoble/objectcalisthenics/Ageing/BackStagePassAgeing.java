package org.agilegrenoble.objectcalisthenics.Ageing;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.agilegrenoble.objectcalisthenics.quality.Quality;
import org.hamcrest.Matcher;

public class BackStagePassAgeing extends Ageing {

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
    }

    public void advanceOneDay(Quality quality) {
        
        quality.doIncreaseBy(1).when(daysBefore, greaterThan(10));
        quality.doIncreaseBy(2).when(daysBefore, between(5, 10));
        quality.doIncreaseBy(3).when(daysBefore, between(0, 5));
        quality.doResetToZero().when(daysBefore, lessThanOrEqualTo(0));
        
        updateDaysBefore();
    }

    private static Matcher<Integer> between(int lowerBound, int higherBound) {
        return allOf(greaterThan(lowerBound), lessThanOrEqualTo(higherBound));
    }
    
        
    
}