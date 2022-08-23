package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.Accessory

interface AccessoryRepository {

    suspend fun saveAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun getAccessory(): Resource<Accessory>

    suspend fun updateAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun deleteAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun getAllAccessories(): Resource<List<Accessory>>
}