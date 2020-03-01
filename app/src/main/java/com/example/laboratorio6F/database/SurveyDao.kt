package com.example.laboratorio6.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SurveyDao{

    @Insert
    fun insertPregunta(pregunta:PreguntaEntity)

    @Insert
    fun createEncuesta(encuesta: EncuestaEntity)

    @Query("SELECT*FROM answer_table ")
    fun getAllResponses():LiveData<List<RespuestaEntity>>

    @Query("SELECT * FROM question_table ")
    fun getAllPreguntas():MutableList<PreguntaEntity>

    @Query("SELECT COUNT(id) FROM poll_table")
    fun getNumberOfSurveys():Long?

    @Query("DELETE FROM poll_table")
    fun clearSurveys()

    @Query("DELETE FROM answer_table")
    fun clearResults()

    @Query("DELETE FROM question_table WHERE `default`=:key")
    fun clearPreguntas(key:Int)

    @Query("SELECT * FROM question_table WHERE id=:key")
    fun  getPregunta(key:Int):PreguntaEntity?

    @Query("SELECT COUNT(id) FROM question_table")
    fun getCantidadPreguntas():Int

    @Query("SELECT type FROM question_table")
    fun getTypeQuestion():String


}