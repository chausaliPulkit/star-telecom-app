package me.asiimwedismas.startelecom.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.asiimwedismas.startelecom.core.database.dao.AccessoryDao
import me.asiimwedismas.startelecom.core.database.dao.StaffMemberDao
import me.asiimwedismas.startelecom.core.model.Accessory
import me.asiimwedismas.startelecom.core.model.StaffMember

@Database(
    entities = [
        Accessory::class,
        StaffMember::class
    ],
    version = 1,
    exportSchema = true
)
abstract class STAppDatabase : RoomDatabase() {
    abstract fun accessoryDao(): AccessoryDao
    abstract fun staffMemberDao(): StaffMemberDao
}