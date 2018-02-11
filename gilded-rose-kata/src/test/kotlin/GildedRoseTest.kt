import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.*
import org.junit.*

class GildedRoseTest {

	@Test fun `the quality of an item is degraded by 1`() {
		val items = listOf(Item("Chocolate", 10, 1))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(0))
	}

	@Test fun `the quality of an item does not degrade any more when it is already 0`() {
		val items = listOf(Item("Chocolate", 10, 0))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(0))
	}

	@Test fun `a "Sulfuras, Hand of Ragnaros" does not degrade`() {
		val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(10))
	}

	@Test fun `an "Aged Brie"'s quality increases by 1`() {
		val items = listOf(Item("Aged Brie", 10, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(11))
	}

	@Test fun `the quality of an "Aged Brie" does not increase more than 50`() {
		val items = listOf(Item("Aged Brie", 10, 50))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(50))
	}

	@Test fun `a "Backstage pass"'s quality increases by 1`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(11))
	}

	@Test fun `a "Backstage pass"'s quality increases by 2 when the sell in date is smaller to 10 days`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(12))
	}

	@Test fun `a "Backstage pass"'s quality increases by 2 when the sell in date is equal to 10 days`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(12))
	}

	@Test fun `a "Backstage pass"'s quality increases by 3 when the sell in date is smaller than 5 days`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(13))
	}

	@Test fun `a "Backstage pass"'s quality increases by 3 when the sell in date is equal to 5 days`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(13))
	}

	@Test fun `a "Backstage pass"'s quality does not increase more than 50 when there are more than 10 days left`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 50))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(50))
	}

	@Test fun `a "Backstage pass"'s quality does not increase more than 50 when there are less than 10 days left`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 7, 49))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(50))
	}

	@Test fun `a "Backstage pass"'s quality does not increase more than 50 when there are less than 5 days left`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 48))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(50))
	}

	@Test fun `an item's sell in day is decreased by one`() {
		val items = listOf(Item("Chocolate", 7, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].sellIn, equalTo(6))
	}

	@Test fun `a "Sulfuras"'s sell in day is never decreased`() {
		val items = listOf(Item("Sulfuras, Hand of Ragnaros", 7, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].sellIn, equalTo(7))
	}

	@Test fun `after expiration date an item's quality degrates twice as fast`() {
		val items = listOf(Item("Chocolate", -1, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(8))
	}

	@Test fun `a "Sulfuras" does not degrade even after expiration date`() {
		val items = listOf(Item("Sulfuras, Hand of Ragnaros", -1, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(10))
	}

	@Test fun `after expiration date a "Backstage pass"'s quality is turned to 0`() {
		val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", -1, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(0))
	}

	@Test fun `after expiration date an "Aged Brie"'s quality is increased twice as fast`() {
		val items = listOf(Item("Aged Brie", -1, 10))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(12))
	}

	@Test fun `after expiration date an "Aged Brie"'s quality does not increase more than 50`() {
		val items = listOf(Item("Aged Brie", -1, 49))

		GildedRose(items).updateQuality()

		assert.that(items[0].quality, equalTo(50))
	}
}