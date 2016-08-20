import spock.lang.Specification


class GildedRoseShould extends Specification {

    static final String AN_ITEM = "An item"
    static final int GOOD_PRODUCT = 15
    static final int EXPIRED_PRODUCT = -1
    static final int TOP_QUALITY_VALUE = 50


    def "not increase the quality of an aged brie or a backstage pass more than fifty"() {
        given:
            Item agedBrie = new Item(ItemNames.AGED_BRIE, GOOD_PRODUCT, TOP_QUALITY_VALUE)
            Item backstagePass = new Item(ItemNames.BACKSTAGE_PASS, GOOD_PRODUCT, TOP_QUALITY_VALUE)

        when:
            new GildedRose([agedBrie, backstagePass]).updateQuality()

        then:
            agedBrie.quality == TOP_QUALITY_VALUE
            backstagePass.quality == TOP_QUALITY_VALUE
    }


    def "increase the quality of aged brie by one when it has not expired"() {
        given:
            Item agedBrie = new Item(ItemNames.AGED_BRIE, GOOD_PRODUCT, 1)

        when:
            new GildedRose([agedBrie]).updateQuality()

        then:
            agedBrie.quality == 2
    }

    def "increase the quality of an expired aged brie by two"() {
        given:
            Item agedBrie = new Item(ItemNames.AGED_BRIE, EXPIRED_PRODUCT, 1)

        when:
            new GildedRose([agedBrie]).updateQuality()

        then:
            agedBrie.quality == 3
    }


    def "increase the quality of a backstage pass according to its expiration days"() {
        given:
            Item backstagePass = new Item(ItemNames.BACKSTAGE_PASS, daysLeftForExpiration, 1)

        when:
            new GildedRose([backstagePass]).updateQuality()

        then:
            backstagePass.quality == newQuality

        where:
            daysLeftForExpiration || newQuality
            51                    || 2
            11                    || 2
            10                    || 3
            6                     || 3
            5                     || 4
            1                     || 4
            0                     || 0
           -1                     || 0
    }


    def "not decrease the quality of sulfuras"() {
        given:
            Item sulfuras = new Item(ItemNames.SULFURAS, GOOD_PRODUCT, 1)
            Item expiredSulfuras = new Item(ItemNames.SULFURAS, EXPIRED_PRODUCT, 1)

        when:
            new GildedRose([sulfuras]).updateQuality()

        then:
            sulfuras.quality == 1
            expiredSulfuras.quality == 1
    }

    def "not decrease the sell in value of sulfuras"() {
        given:
            Item sulfuras = new Item(ItemNames.SULFURAS, 1, TOP_QUALITY_VALUE)

        when:
            new GildedRose([sulfuras]).updateQuality()

        then:
            sulfuras.sellIn == 1
    }


    def "not decrease the quality of any item less than zero"() {
        given:
            Item item = new Item(AN_ITEM, GOOD_PRODUCT, 0)
            Item conjuredItem = new Item(ItemNames.CONJURED, GOOD_PRODUCT, 0)

        when:
            new GildedRose([item, conjuredItem]).updateQuality()

        then:
            item.quality == 0
            conjuredItem.quality == 0
    }


    def "decrease the quality of an item by one when it is not expired"() {
        given:
            Item item = new Item(AN_ITEM, GOOD_PRODUCT, 1)

        when:
            new GildedRose([item]).updateQuality()

        then:
            item.quality == 0
    }

    def "decrease the quality of an item by two when it has expired"() {
        given:
            Item item = new Item(AN_ITEM, EXPIRED_PRODUCT, 2)

        when:
            new GildedRose([item]).updateQuality()

        then:
            item.quality == 0

    }

    def "decrease the sell in value of an item"() {
        given:
            Item item = new Item(AN_ITEM, 1, TOP_QUALITY_VALUE)

        when:
            new GildedRose([item]).updateQuality()

        then:
            item.sellIn == 0
    }


    def "decrease the quality of a conjured item by two when it is not expired"() {
        given:
            Item conjuredItem = new Item(ItemNames.CONJURED, GOOD_PRODUCT, 2)

        when:
            new GildedRose([conjuredItem]).updateQuality()

        then:
            conjuredItem.quality == 0
    }

    def "decrease the quality of conjured item by four when it has expired"() {
        given:
            Item conjuredItem = new Item(ItemNames.CONJURED, EXPIRED_PRODUCT, 4)

        when:
            new GildedRose([conjuredItem]).updateQuality()

        then:
            conjuredItem.quality == 0
    }

}
