package me.asiimwedismas.startelecom.core.network

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.SaleInvoice

interface DebitsNetworkDatasource {
    suspend fun save(debitInvoice: SaleInvoice): Resource<Boolean>

    suspend fun delete(debitInvoice: SaleInvoice): Resource<Boolean>

    suspend fun getAll(): Resource<List<SaleInvoice>>
}