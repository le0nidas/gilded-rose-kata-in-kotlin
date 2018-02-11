const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"

fun agedBrie(sellIn: Int, quality: Int) = Item(AGED_BRIE, sellIn, quality)
fun backstagePass(sellIn: Int, quality: Int) = Item(BACKSTAGE_PASS, sellIn, quality)
fun sulfuras(sellIn: Int, quality: Int) = Item(SULFURAS, sellIn, quality)

data class Item(
		val name: String,
		var sellIn: Int,
		var quality: Int) {

	override fun toString() = "$name / sell in $sellIn / quality of $quality"
}