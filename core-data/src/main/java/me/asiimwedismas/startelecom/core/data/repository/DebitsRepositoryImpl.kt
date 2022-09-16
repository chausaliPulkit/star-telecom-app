package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.SaleInvoice
import me.asiimwedismas.startelecom.core.network.DebitsNetworkDatasource
import javax.inject.Inject

class DebitsRepositoryImpl @Inject constructor(
    private val networkDatasource: DebitsNetworkDatasource
) : DebitsRepository {
    override suspend fun save(debitInvoice: SaleInvoice): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(debitInvoice: SaleInvoice): Resource<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): Resource<List<SaleInvoice>> {
        TODO("Not yet implemented")
    }
}