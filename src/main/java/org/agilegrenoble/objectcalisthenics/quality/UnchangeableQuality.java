package org.agilegrenoble.objectcalisthenics.quality;

public class UnchangeableQuality implements Quality {

    private final int value;

    public UnchangeableQuality(int value) {
	this.value = value;
	

    }

    @Override
    public int getQuality() {

	return value;
    }

    @Override
    public void decrease(int value) {
    }

    @Override
    public void increase(int value) {
    }

    @Override
    public void increase() {
    }

    @Override
    public void decrease() {
    }

    @Override
    public void resetToZero() {
    }

}
