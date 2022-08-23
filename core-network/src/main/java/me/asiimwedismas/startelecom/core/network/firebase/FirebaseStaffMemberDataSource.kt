package me.asiimwedismas.startelecom.core.network.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.model.StaffMember
import me.asiimwedismas.startelecom.core.network.StaffMemberNetworkDataSource
import me.asiimwedismas.startelecom.core.network.di.StaffCollection
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class FirebaseStaffMemberDataSource @Inject constructor(
    @StaffCollection private val collection: CollectionReference,
) : StaffMemberNetworkDataSource {
    override suspend fun authenticateUser(
        username: String,
        password: String
    ): Resource<StaffMember> {
        return try {
            Resource.Success(
                collection
                    .whereEqualTo("username", username)
                    .whereEqualTo("password", password)
                    .whereEqualTo("has_eps_access", true)
                    .get()
                    .await()
                    .toObjects(StaffMember::class.java)
                    .firstOrNull()
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data")
        }
    }

    override suspend fun save(member: StaffMember): Resource<Boolean> {
        return try {
            val document = if (member.document_id.isBlank()) {
                member.copy(document_id = collection.id)
            } else {
                member
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

    override suspend fun save(members: List<StaffMember>): Resource<Boolean> {
        return try {
            Firebase.firestore.runBatch { batch ->
                members.forEach { member ->
                    val document = if (member.document_id.isBlank()) {
                        member.copy(document_id = collection.id)
                    } else {
                        member
                    }
                    val docRef = collection.document(document.document_id)
                    batch.set(docRef, document)
                }
            }.await()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data", false)
        }
    }

    override suspend fun getAllStaff(): Resource<List<StaffMember>> {
        return try {
            Resource.Success(
                collection
                    .get()
                    .await()
                    .toObjects(StaffMember::class.java)
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Check to see if you have data")
        }
    }
}