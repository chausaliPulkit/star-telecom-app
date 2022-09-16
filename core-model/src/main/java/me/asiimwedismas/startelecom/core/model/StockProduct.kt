package me.asiimwedismas.startelecom.core.model


data class StockProduct(
    var date: String = "",
    var utc: Long = -1L,
    var document_id: String = "",
    var document_author_id: String = "",
    var document_author_name: String = "",
    var isLocked: Boolean = false,

    var name: String = "",
    var category: String = "",
    var serial: MutableList<String> = ArrayList(),
    var unit_cost: Int = 0,
    var recommended_sale_px: Int = 0,
    var last_sale_px: Int = 0,
    var profit: Int = 0,
    var opened: Int = 0,
    var added: Int = 0,
    var sold: Int = 0,
    var balance: Int = 0,
    var counted: Int = 0,
) {
    override fun toString(): String {
        return name
    }

    fun calculateProfit() {
        profit = last_sale_px - unit_cost
    }
}