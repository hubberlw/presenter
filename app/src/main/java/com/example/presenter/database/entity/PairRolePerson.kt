package com.example.presenter.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pair_role_person_table")
data class PairRolePerson (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pair_id")
    val pairId: Long = 0L,

    @ColumnInfo(name = "role_id")
    val roleId: Long = 0L,

    @ColumnInfo(name = "person_id")
    val personId: Long = 0L

)