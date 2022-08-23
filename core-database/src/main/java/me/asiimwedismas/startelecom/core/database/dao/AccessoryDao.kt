package me.asiimwedismas.startelecom.core.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import me.asiimwedismas.startelecom.core.model.Accessory

@Dao
interface AccessoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: List<Accessory>)

    @Update
    suspend fun update(products: List<Accessory>)

    @Delete
    suspend fun delete(products: List<Accessory>)

    @Query("SELECT * FROM accessories ORDER BY name")
    fun getAllProducts(): LiveData<List<Accessory>>
}