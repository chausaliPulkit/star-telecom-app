package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.StaffMember

interface StaffMemberRepository {

    suspend fun authenticateUser(username: String, password: String) : Resource<StaffMember>
}