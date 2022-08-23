package me.asiimwedismas.startelecom.core.network.firebase

import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.Accessory
import me.asiimwedismas.startelecom.core.network.AccessoryNetworkDataSource
import me.asiimwedismas.startelecom.core.network.di.AccessoriesCollection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAccessoryDataSource @Inject constructor(
    @AccessoriesCollection private val collection: CollectionReference
) : AccessoryNetworkDataSource {
    override suspend fun saveAccessory(accessory: Accessory): Resource<Boolean> {
        return try {
            val document = if (accessory.document_id.isBlank()) {
                accessory.copy(document_id = collection.id)
            } else {
                accessory
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

    override suspend fun deleteAccessory(accessory: Accessory): Resource<Boolean> {
        return try {
            collection
                .document(accessory.document_id)
                .delete()
                .await()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data", false)
        }
    }

    override suspend fun getAllAccessories(): Resource<List<Accessory>> {
        return try {
            Resource.Success(
                collection
                    .get()
                    .await()
                    .toObjects(Accessory::class.java)
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Chect to see if you have data")
        }
    }
}