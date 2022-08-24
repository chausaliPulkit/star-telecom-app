package me.asiimwedismas.startelecom.core.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import me.asiimwedismas.startelecom.core.model.Accessory

@Dao
interface AccessoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(accessory: List<Accessory>)

    @Update
    suspend fun update(accessory: List<Accessory>)

    @Delete
    suspend fun delete(accessory: List<Accessory>)

    @Query("SELECT * FROM accessories ORDER BY name")
    fun getAllProducts(): LiveData<List<Accessory>>
}