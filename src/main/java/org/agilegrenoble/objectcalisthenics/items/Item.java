package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Item {
    protected String name;
    public Ageing ageing;
    protected Quality quality;

    public Item(String name, Quality quality, Ageing sellIn) {
        this.name = name;
        this.quality = quality;
        this.ageing = sellIn;
    }

    protected int getDayCountDown() {
        return ageing.getDayCountDown();
    }

    public void updateQuality() {
        ageing.advanceOneDay(quality);
    }

    public int getQualityValue() {
        return quality.getQuality();
    }
}