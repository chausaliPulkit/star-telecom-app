package me.asiimwedismas.startelecom.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.network.FirebaseStaffMemberNetworkDataSource
import me.asiimwedismas.startelecom.core.network.StaffMemberNetworkDataSource

@Module
@InstallIn(SingletonComponent::class)
interface RemoteSourceDataModule {

    @Binds
    fun bindsStaffMemberRemoteDataSource(
        topicsRepository: FirebaseStaffMemberNetworkDataSource
    ): StaffMemberNetworkDataSource

}
