package me.asiimwedismas.startelecom.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.asiimwedismas.startelecom.core.database.dao.AccessoryDao
import me.asiimwedismas.startelecom.core.model.Accessory

@Database(
    entities = [
        Accessory::class
    ],
    version = 1,
    exportSchema = true
)
abstract class STAppDatabase: RoomDatabase() {
    abstract fun accessoryDao(): AccessoryDao
}