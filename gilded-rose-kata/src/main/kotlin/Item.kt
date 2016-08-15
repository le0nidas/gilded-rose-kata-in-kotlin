data class Item(
        val name: String,
        var sellIn: Int,
        var quality: Int) {

    override fun toString() = "$name / sell in $sellIn / quality of $quality"

}