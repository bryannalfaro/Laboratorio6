package com.example.laboratorio6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")
data class PreguntaEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    @ColumnInfo(name = "name")
    var name:String="",
    @ColumnInfo(name = "type") //Si es texto o numero
    var tipoPregunta:String="",
    @ColumnInfo(name= "default")  //si pregunta establecida o no
    var defect:Int=1

)