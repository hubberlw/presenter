package com.example.presenter.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "role_table")
data class Role (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "role_id")
    val roleId: Long = 0L,

    @ColumnInfo(name = "role_name")
    val roleName: String = "",

    @ColumnInfo(name = "category_name")
    val categoryName: String = "",

    @ColumnInfo(name = "selected_role")
    val selectedRole: Boolean = false
): Parcelable
