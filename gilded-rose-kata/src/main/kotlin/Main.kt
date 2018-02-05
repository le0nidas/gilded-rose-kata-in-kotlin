fun main(args: Array<String>) {
	val items = mutableListOf(
			Item("+5 Dexterity Vest", 10, 20),
			Item("Aged Brie", 2, 0),
			Item("Elixir of the Mongoose", 5, 7),
			Item("Sulfuras, Hand of Ragnaros", 0, 80),
			Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
			Item("Conjured Mana Cake", 15, 20))

	val gildedRose = GildedRose(items)

	repeat(20) { day ->
		println("---- Day #${day+1} ----")

		gildedRose.updateQuality()
		items.forEach { item -> println(item) }

		println()
	}
}