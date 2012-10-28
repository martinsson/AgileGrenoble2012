package org.agilegrenoble.objectcalisthenics.quality;

import org.hamcrest.Matcher;

public interface Quality {

    int getQuality();

    /**
     * Decrease quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    void decrease(int value);

    /**
     * Increase quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    void increaseBy(int value);

    void increase();

    void decrease();

    /**
     * Reset quality to zero
     */
    void resetToZero();

    PotentialUpdater doIncreaseBy(int i);

    PotentialUpdater doResetToZero();

    interface PotentialUpdater {

        void when(int daysBefore, Matcher<Integer> matches);
        
    }
}