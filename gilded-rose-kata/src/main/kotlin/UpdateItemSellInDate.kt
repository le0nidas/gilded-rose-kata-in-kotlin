fun updateSellInDateOf(item: Item) {
	if (item.name == SULFURAS) {
		return
	}

	item.sellIn--
}