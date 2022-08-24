package me.asiimwedismas.startelecom.core.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import me.asiimwedismas.startelecom.core.model.Accessory
import me.asiimwedismas.startelecom.core.model.StaffMember

@Dao
interface StaffMemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(members: List<StaffMember>)

    @Update
    suspend fun update(members: List<StaffMember>)

    @Delete
    suspend fun delete(members: List<StaffMember>)

    @Query("SELECT * FROM staff_members ORDER BY full_name")
    fun getAllStaff(): LiveData<List<StaffMember>>

    @Query(
        value = """
            SELECT * FROM STAFF_MEMBERS
            WHERE username = :username
            AND password = :password
            AND has_eps_access = :has_access
            LIMIT 1
        """
    )
    suspend fun authenticate(username: String, password: String, has_access: Boolean = true) : StaffMember?
}