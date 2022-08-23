package me.asiimwedismas.startelecom.core.network

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.Accessory

interface AccessoryNetworkDataSource {

    suspend fun saveAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun deleteAccessory(accessory: Accessory): Resource<Boolean>

    suspend fun getAllAccessories(): Resource<List<Accessory>>
}