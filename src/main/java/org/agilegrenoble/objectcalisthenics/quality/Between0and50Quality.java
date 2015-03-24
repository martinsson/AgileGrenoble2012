package org.agilegrenoble.objectcalisthenics.quality;

public class Between0and50Quality implements Quality {

    protected int quality;

    public Between0and50Quality(int quality) {
        this.quality = quality;
    }


    public int getQuality() {
        return quality;
    }

    public void decrease(int value) {
        if (quality > 0) {
	    quality -= value;
	}
    }

    public void increase(int value) {
        if (quality < 50)
            quality += value;
    }
    
    public void increase() {
        increase(1);
    }
    
    public void decrease() {
        decrease(1);
    }

    public void resetToZero() {
        quality = 0;
    }

    @Override
    public String toString() {
        return "Between0and50Quality [quality=" + quality + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + quality;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Between0and50Quality other = (Between0and50Quality) obj;
        if (quality != other.quality)
            return false;
        return true;
    }
    
}