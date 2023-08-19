package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // DefaultStrategy Tests
    @Test
    void testDefaultStrategy() {
        Item[] items = new Item[] { new Item("foo", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testDefaultStrategyNegativeSellIn() {
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testDefaultStrategyZeroQuality() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // ConjuredStrategy Tests
    @Test
    void testConjuredStrategy() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testConjuredStrategyNegativeSellIn() {
        Item[] items = new Item[] { new Item("Conjured", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void testConjuredStrategyZeroQuality() {
        Item[] items = new Item[] { new Item("Conjured", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // BackstagePassStrategy Tests
    @Test
    void testBackstagePassStrategy() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testBackstagePassStrategySellInBetween6And10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testBackstagePassStrategySellInGreaterThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testBackstagePassStrategyMaxQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // AgedBrieStrategy Tests
    @Test
    void testAgedBrieStrategy() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testAgedBrieStrategyNegativeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testAgedBrieStrategyMaxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // SulfurasStrategy Tests
    @Test
    void testSulfurasStrategy() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void testSulfurasStrategyNot80Quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(40, app.items[0].quality);
    }
}
