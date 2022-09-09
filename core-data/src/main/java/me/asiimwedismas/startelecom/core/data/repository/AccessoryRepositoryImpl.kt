package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.database.dao.AccessoryDao
import me.asiimwedismas.startelecom.core.model.Accessory
import me.asiimwedismas.startelecom.core.network.AccessoryNetworkDataSource
import javax.inject.Inject

class AccessoryRepositoryImpl @Inject constructor(
    private val networkDataSource: AccessoryNetworkDataSource,
    private val accessoryDao: AccessoryDao
) : AccessoryRepository {
    override suspend fun saveAccessory(accessory: Accessory): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getAccessory(): Resource<Accessory> {
        TODO("Not yet implemented")
    }

    override suspend fun updateAccessory(accessory: Accessory): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAccessory(accessory: Accessory): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAccessories(): Resource<List<Accessory>> {
        TODO("Not yet implemented")
    }
}