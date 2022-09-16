package me.asiimwedismas.startelecom.core.model

data class SalePayment(
    var utc: Long? = -1L,
    var amount: Int? = 0
)



data class SaleInvoice(
    var date: String = "",
    var utc: Long = -1L,
    var document_id: String = "",
    var document_author_id: String = "",
    var document_author_name: String = "",
    var isLocked: Boolean = false,

    var customer_name: String = "",
    var contact_1: String = "",
    var sales_person: String = "",
    var sales_person_id: String = "",
    var sales_commission: Int = 0,
    var cash_balance: Int = 0,
    var total_sales: Int = 0,
    var payments: MutableList<SalePayment> = ArrayList(),
    var items: MutableList<StockProduct> = ArrayList()
) {
    fun calculateTotalsAndProfits() {
        val paymentsSum = payments.sumOf { it.amount!! }
        total_sales = items.sumOf { it.last_sale_px }
        cash_balance = paymentsSum - total_sales

        items.forEach {
            if (it.unit_cost > 0)
                it.calculateProfit()
        }
    }
}