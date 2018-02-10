typealias UpdateSellInDateIn = (Item) -> Unit
typealias UpdateQualityIn = (Item) -> Unit

fun getUpdateFunctionsFor(item: Item): Pair<UpdateSellInDateIn, UpdateQualityIn> {
	return when(item.name) {
		AGED_BRIE -> Pair(decreaseSellInByOne(), increaseQualityForAgedBrie())
		else -> Pair(noOp(), noOp())
	}
}

//
//  For all items
//
private fun noOp() = { _: Item ->
	Unit
}
private fun decreaseSellInByOne() = { item: Item ->
	item.sellIn--
	Unit
}


//
//  Aged Brie
//
private const val AGED_BRIE = "Aged Brie"

private fun increaseQualityForAgedBrie() = { agedBrie: Item ->
	val value = if (agedBrie.quality == 50) 0 else {
		if (agedBrie.sellIn < 0) 2 else 1
	}
	agedBrie.quality = agedBrie.quality + value
	Unit
}