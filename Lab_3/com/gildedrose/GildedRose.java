package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateItemQuality(Item item) {
        if (isRegularItem(item)) {
            updateRegularItem(item);
        }
        else if (isAgedBrie(item)) {
            updateAgedBrie(item);
        }
        else if (isBackstagePass(item)) {
            updateBackstagePasses(item);
        }
    }


    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }


    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
        }
    }


    private boolean isRegularItem(Item item) {
        return !item.name.equals("Aged Brie") && 
               !item.name.equals("Backstage passes to a TAFKAL80ETC concert") &&
               !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateRegularItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1;
        }
    }


    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
    

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality += 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality += 1;
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
    
    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }


}




