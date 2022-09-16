package me.asiimwedismas.startelecom.core.data.repository

import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.SaleInvoice

interface DebitsRepository {
    suspend fun save(debitInvoice: SaleInvoice): Resource<Boolean>

    suspend fun delete(debitInvoice: SaleInvoice): Resource<Boolean>

    suspend fun getAll(): Resource<List<SaleInvoice>>
}