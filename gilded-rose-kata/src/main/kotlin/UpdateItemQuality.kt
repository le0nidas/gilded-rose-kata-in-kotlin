fun updateQualityOf(item: Item) {
	when (item.name) {
		"Aged Brie" -> updateQualityOfAgedBrie(item)
		"Backstage passes to a TAFKAL80ETC concert" -> updateQualityOfBackstage(item)
		"Sulfuras, Hand of Ragnaros" -> updateQualityOfSulfuras(item)
		else -> updateQualityOfNormal(item)
	}
}

private fun updateQualityOfAgedBrie(item: Item) {
	val value = when {
		item.quality == 50 -> 0
		item.sellIn < 0 -> 2
		else -> 1
	}

	item.quality = if (item.quality + value > 50) 50 else item.quality + value
}

private fun updateQualityOfBackstage(item: Item) {
	val value = when {
		item.quality == 50 -> 0
		item.sellIn < 0 -> -item.quality
		item.sellIn <= 5 -> 3
		item.sellIn <= 10 -> 2
		else -> 1
	}

	item.quality = if (item.quality + value > 50) 50 else item.quality + value
}

private fun updateQualityOfSulfuras(item: Item) {

}

private fun updateQualityOfNormal(item: Item) {
	val value = when {
		item.sellIn < 0 -> 2
		else -> 1
	}

	item.quality = if (item.quality - value < 0) 0 else item.quality - value
}