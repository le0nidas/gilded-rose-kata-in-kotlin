fun updateSellInDateOf(item: Item) {
	if (item.name == "Sulfuras, Hand of Ragnaros") {
		return
	}

	item.sellIn--
}