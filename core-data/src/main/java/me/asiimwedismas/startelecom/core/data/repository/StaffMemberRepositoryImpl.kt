package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.StaffMember
import me.asiimwedismas.startelecom.core.network.StaffMemberNetworkDataSource
import javax.inject.Inject

class StaffMemberRepositoryImpl @Inject constructor(
    private val networkDataSource: StaffMemberNetworkDataSource
) : StaffMemberRepository {
    override suspend fun authenticateUser(
        username: String,
        password: String
    ): Resource<StaffMember> {
        return networkDataSource.authenticateUser(username, password)
    }
}