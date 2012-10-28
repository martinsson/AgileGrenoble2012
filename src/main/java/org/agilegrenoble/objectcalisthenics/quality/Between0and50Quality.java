package org.agilegrenoble.objectcalisthenics.quality;

import org.hamcrest.Matcher;

public class Between0and50Quality implements Quality {

    protected int quality;

    public Between0and50Quality(int quality) {
        this.quality = quality;
    }


    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#getQuality()
     */
    public int getQuality() {
        return quality;
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#decrease(int)
     */
    public void decrease(int value) {
        if (quality > 0)
            quality -= value;
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#increase(int)
     */
    public void increaseBy(int value) {
        if (quality < 50)
            quality += value;
    }
    
    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#increase()
     */
    public void increase() {
        increaseBy(1);
    }
    
    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#decrease()
     */
    public void decrease() {
        decrease(1);
    }

    /* (non-Javadoc)
     * @see org.agilegrenoble.objectcalisthenics.quality.Quality#resetToZero()
     */
    public void resetToZero() {
        quality = 0;
    }


    @Override
    public PotentialUpdater doIncreaseBy(final int amount) {
        final Quality q = this; //trick!
        return new PotentialUpdater(){
            @Override
            public void when(int daysBefore, Matcher<Integer> matcher) {
                if (matcher.matches(daysBefore))
                    q.increaseBy(amount);
            }
            
        };
    }


    @Override
    public PotentialUpdater doResetToZero() {
        final Quality q = this; 
        return new PotentialUpdater(){
            @Override
            public void when(int daysBefore, Matcher<Integer> matcher) {
                if (matcher.matches(daysBefore))
                    q.resetToZero();
            }
            
        };
    }
    
}