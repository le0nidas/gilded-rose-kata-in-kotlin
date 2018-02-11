class GildedRose(
		val items: List<Item>
) {

	fun updateQuality() {
		items.forEach { item ->
			updateSellInDateOf(item)
			updateQualityOf(item)
		}
	}

}