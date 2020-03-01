package com.example.laboratorio6F.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poll_table")
data class EncuestaEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name = "create_date")
    var startTimeMilli:Long = System.currentTimeMillis()
    )