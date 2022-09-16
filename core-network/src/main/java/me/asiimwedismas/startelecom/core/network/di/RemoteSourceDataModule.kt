package me.asiimwedismas.startelecom.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.network.AccessoryNetworkDataSource
import me.asiimwedismas.startelecom.core.network.DebitsNetworkDatasource
import me.asiimwedismas.startelecom.core.network.StaffMemberNetworkDataSource
import me.asiimwedismas.startelecom.core.network.firebase.FirebaseAccessoryDataSource
import me.asiimwedismas.startelecom.core.network.firebase.FirebaseDebitsDatasource
import me.asiimwedismas.startelecom.core.network.firebase.FirebaseStaffMemberDataSource

@Module
@InstallIn(SingletonComponent::class)
interface RemoteSourceDataModule {

    @Binds
    fun bindsStaffMemberRemoteDataSource(
        dataSource: FirebaseStaffMemberDataSource
    ): StaffMemberNetworkDataSource

    @Binds
    fun bindsAccessoriesRemoteDataSource(
        dataSource: FirebaseAccessoryDataSource
    ): AccessoryNetworkDataSource

    @Binds
    fun bindsDebitsRemoteDatasource(
        datasource: FirebaseDebitsDatasource
    ) : DebitsNetworkDatasource

}
