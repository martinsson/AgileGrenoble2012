package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
    }

    public void advanceOneDay(Quality quality) {
        if (daysBefore > 10) {
            quality.increase(3);
        
        } else if (daysBefore > 5) {
            quality.increase(2);
        
        } else if (daysBefore > 0) {
            quality.increase();
        
        } else {
            quality.resetToZero();
        }
        
        updateDaysBefore();
    }
}