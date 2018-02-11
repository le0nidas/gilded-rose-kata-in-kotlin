fun updateQualityOf(item: Item) {
	val value = when (item.name) {
		AGED_BRIE -> updateValueOfAgedBrie(item)
		BACKSTAGE_PASS -> updateValueOfBackstage(item)
		SULFURAS -> 0
		CONJURED -> 2 * updateValueOfNormal(item)

		else -> updateValueOfNormal(item)
	}

	val valueInLimits = when {
		item.quality + value > 50 -> 50 - item.quality
		item.quality + value < 0 -> -item.quality
		else -> value
	}

	item.quality = item.quality + valueInLimits
}

private fun updateValueOfAgedBrie(item: Item) = when {
	item.quality == 50 -> 0
	item.sellIn < 0 -> 2
	else -> 1
}

private fun updateValueOfBackstage(item: Item) = when {
	item.quality == 50 -> 0
	item.sellIn < 0 -> -item.quality
	item.sellIn <= 5 -> 3
	item.sellIn <= 10 -> 2
	else -> 1
}

private fun updateValueOfNormal(item: Item) = when {
	item.sellIn < 0 -> -2
	else -> -1
}
