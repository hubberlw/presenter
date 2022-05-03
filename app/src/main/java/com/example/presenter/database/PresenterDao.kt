package com.example.presenter.database

// Links for working with multiple related tables - needed for job/person combinations
// https://developer.android.com/training/data-storage/room/accessing-data#multiple-tables
// https://developer.android.com/training/data-storage/room/relationships

import androidx.room.*
import com.example.presenter.database.entity.Role

@Dao
interface PresenterDao {
    // Product
    @Insert
    suspend fun insertRole(role: Role)

    @Update
    suspend fun updateRole(role: Role)

    @Delete
    suspend fun deleteRole(role: Role)

    @Query("SELECT * FROM role_table WHERE role_id = :key")
    suspend fun get(key: Long): Role

    @Query("SELECT * FROM role_table ORDER BY role_name ASC")
    suspend fun getFullRoleList(): List<Role>

    @Query("SELECT * FROM role_table WHERE selected_role = 'TRUE'")
    suspend fun getSelectedRoleList(): List<Role>

    @Query("SELECT * FROM role_table WHERE role_name = :category")
    suspend fun getFilteredRoleList(category: String): List<Role>
}