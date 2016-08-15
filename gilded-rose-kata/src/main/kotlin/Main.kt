fun main(args: Array<String>) {
    val items = mutableListOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Conjured Mana Cake", 15, 20))


    val gildedRose = GildedRose(items)
    gildedRose.runFor(20)
}


private fun GildedRose.runFor(days: Int) {
    for (day in 1..days) {
        println("---- Day #$day ----")
        updateQuality()
        print()
        println()
    }
}

private fun GildedRose.print() = items.forEach { item -> println(item) }