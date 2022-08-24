package me.asiimwedismas.startelecom.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.database.STAppDatabase
import me.asiimwedismas.startelecom.core.database.dao.AccessoryDao
import me.asiimwedismas.startelecom.core.database.dao.StaffMemberDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun provideAccessoryDao(
        database: STAppDatabase
    ): AccessoryDao = database.accessoryDao()

    @Provides
    fun providesStaffMemberDao(
        database: STAppDatabase
    ): StaffMemberDao = database.staffMemberDao()
}