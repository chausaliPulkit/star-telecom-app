package me.asiimwedismas.startelecom.core.model

data class Accessory(
    override val date: String = "",
    override val utc: Long = 0L,
    override val document_id: String = "",
    override val document_author_id: String = "",
    override val document_author_name: String = "",
    override val isLocked: Boolean = false,
    val name: String = "",
    val recommended_price: Int = 0,
    val minimum_price: Int = 0
) : BaseDocument()
