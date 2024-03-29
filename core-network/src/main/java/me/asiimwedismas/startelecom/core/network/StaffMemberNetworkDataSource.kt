package me.asiimwedismas.startelecom.core.network

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.StaffMember

interface StaffMemberNetworkDataSource {

    suspend fun authenticateUser(username: String, password: String): Resource<StaffMember>

    suspend fun save(member: StaffMember) : Resource<Boolean>

    suspend fun save(members: List<StaffMember>): Resource<Boolean>

    suspend fun getAllStaff(): Resource<List<StaffMember>>
}