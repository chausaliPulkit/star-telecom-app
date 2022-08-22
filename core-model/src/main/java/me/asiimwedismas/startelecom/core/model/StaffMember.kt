package me.asiimwedismas.startelecom.core.model

data class StaffMember(
    override val date: String ="",
    override val utc: Long =0L,
    override val document_id: String ="",
    override val document_author_id: String ="",
    override val document_author_name: String ="",
    override val isLocked: Boolean = false,
    val full_name: String = "",
    val fcm_token: String = "",
    val position: String = "",
    val phone_number: String = "",
    val read_rights: List<String> = ArrayList(),
    val write_rights: List<String> = ArrayList(),
    val username: String = "",
    val password: String = "",
    val has_eps_access: Boolean = false,
) : BaseDocument(){
    override fun toString(): String {
        return full_name
    }

    fun isAdmin() = position == VarConstants.ROLE_ADMIN || position == VarConstants.ROLE_SHOP_ADMIN
}
