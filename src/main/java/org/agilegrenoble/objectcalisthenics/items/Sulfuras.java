package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.Ageing.NoAgeing;
import org.agilegrenoble.objectcalisthenics.quality.UnchangeableQuality;

public class Sulfuras extends NormalItem {

    public Sulfuras() {
        this(new NoAgeing(0)); // TODO 0 is surprise, NoAging is here but could be in factory?
    }
    
    public Sulfuras(int startSellIn) {
        this(new NoAgeing(startSellIn));
    }
    
    private Sulfuras(Ageing sellIn) {
	// TODO this is legendary item
        super("Sulfuras, Hand of Ragnaros", sellIn, new UnchangeableQuality(80));
    }

}
