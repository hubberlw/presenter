package com.example.presenter.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    val personId: Long = 0L,

    @ColumnInfo(name = "person_name")
    val personName: String = ""
)
