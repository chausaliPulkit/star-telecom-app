package me.asiimwedismas.startelecom.core.data.repository

import androidx.lifecycle.LiveData
import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.Accessory

interface AccessoryRepository {

    suspend fun saveAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun getAccessory(): Resource<Accessory>

    suspend fun updateAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun deleteAccessory(accessory: Accessory): Resource<Boolean>

    fun getAllAccessories(): LiveData<List<Accessory>>
}