class GildedRose(val items: List<Item>) {

    fun updateQuality() = items.forEach { item ->
        val updateQualityIn = ItemUpdateFactory.createQualityUpdateFor(item.name)
        val updateSellInValueIn = ItemUpdateFactory.createSellInUpdateFor(item.name)

        updateQualityIn(item)
        updateSellInValueIn(item)
    }

}