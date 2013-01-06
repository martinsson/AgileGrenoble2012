package org.agilegrenoble.objectcalisthenics;

public class Quality {
    private int quality;

    public Quality() {
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    void increase() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    void decrease() {
        if (getQuality() > 0) {
            setQuality(getQuality() - 1);
        }
    }

    void resetToZero() {
        setQuality(0);
    }
}