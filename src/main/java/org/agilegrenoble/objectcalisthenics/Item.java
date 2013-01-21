package org.agilegrenoble.objectcalisthenics;

public class Item {
    private String name;
    private int sellIn;
    protected Quality quality = new Quality();

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.quality.setQuality(quality);
        this.sellIn = sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality.getQuality();
    }

    void update() {

        if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
            setSellIn(getSellIn() - 1);
        }
        
        if ("Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
            quality.increase();

            if (getSellIn() < 10) {
                quality.increase();
            }

            if (getSellIn() < 5) {
                quality.increase();
            }
            if (getSellIn() < 0) {
                quality.resetToZero();
            }
        } else {
            doUpdate();
            if (getSellIn() < 0) {
                doUpdate();
            }
        }
    }

    private void doUpdate() {
        if ("Aged Brie".equals(getName()))
            quality.increase();
        else if ("Sulfuras, Hand of Ragnaros".equals(getName())) {
        } else {
            quality.decrease();
        }
    }
}
