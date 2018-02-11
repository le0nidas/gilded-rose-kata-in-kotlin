fun updateQualityOf(item: Item) {
	when (item.name) {
		"Aged Brie" -> updateQualityOfAgedBrie(item)
		else -> updateQualityOfBackstage(item)
	}
}


private fun updateQualityOfAgedBrie(item: Item) {
	val value = when {
		item.quality == 50 -> 0
		item.sellIn < 0 -> 2
		else -> 1
	}

	item.quality = item.quality + value
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