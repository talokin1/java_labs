package com.gildedrose;

abstract class ItemCategory {
    abstract void updateQuality(Item item);
    abstract void updateSellIn(Item item);

    void borderQuality(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        } else if (item.quality > 50) {
            item.quality = 50;
        }
    }
}


class RegularItemCategory extends ItemCategory {
    @Override
    void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1;
        }
        borderQuality(item);
    }

    @Override
    void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}


class AgedBrieCategory extends ItemCategory {
    @Override
    void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
        borderQuality(item);
    }

    @Override
    void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}


class BackstagePassCategory extends ItemCategory {
    @Override
    void updateQuality(Item item) {
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
        borderQuality(item);
    }

    @Override
    void updateSellIn(Item item) {
        item.sellIn -= 1;
    }
}


class SulfurasCategory extends ItemCategory {
    @Override
    void updateQuality(Item item) {}

    @Override
    void updateSellIn(Item item) {}
}


class ItemCategoryFactory {
    static ItemCategory getCategory(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieCategory();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassCategory();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasCategory();
            default:
                return new RegularItemCategory();
        }
    }
}


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory category = ItemCategoryFactory.getCategory(item);
            category.updateQuality(item);
            category.updateSellIn(item);
        }
    }
}




