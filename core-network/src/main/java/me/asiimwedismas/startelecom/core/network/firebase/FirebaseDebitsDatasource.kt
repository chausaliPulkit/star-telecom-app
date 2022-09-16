package me.asiimwedismas.startelecom.core.network.firebase

import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.SaleInvoice
import me.asiimwedismas.startelecom.core.network.DebitsNetworkDatasource
import me.asiimwedismas.startelecom.core.network.di.DebtCollection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseDebitsDatasource @Inject constructor(
    @DebtCollection private val collection: CollectionReference
) : DebitsNetworkDatasource {
    override suspend fun save(debitInvoice: SaleInvoice): Resource<Boolean> {
        return try {
            val document = if (debitInvoice.document_id.isBlank()) {
                debitInvoice.copy(document_id = collection.id)
            } else {
                debitInvoice
            }
            collection
                .document(document.document_id)
                .set(document)
                .await()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data", false)
        }
    }

    override suspend fun delete(debitInvoice: SaleInvoice): Resource<Boolean> {
        return try {
            collection
                .document(debitInvoice.document_id)
                .delete()
                .await()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data", false)
        }
    }

    override suspend fun getAll(): Resource<List<SaleInvoice>> {
        return try {
            Resource.Success(
                collection
                    .get()
                    .await()
                    .toObjects(SaleInvoice::class.java)
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Chect to see if you have data")
        }
    }
}