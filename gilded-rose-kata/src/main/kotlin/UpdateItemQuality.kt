fun updateQualityOf(item: Item) {
	val value = when {
		item.quality == 50 -> 0
		item.sellIn < 0 -> 2
		else -> 1
	}

	item.quality = item.quality + value
}