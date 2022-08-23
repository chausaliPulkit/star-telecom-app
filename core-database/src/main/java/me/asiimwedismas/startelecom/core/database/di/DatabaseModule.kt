package me.asiimwedismas.startelecom.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.database.STAppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): STAppDatabase = Room.databaseBuilder(
        context,
        STAppDatabase::class.java,
        "stapp_database"
    ).build()
}