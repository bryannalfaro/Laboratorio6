package com.example.laboratorio6F.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio6F.database.PreguntaEntity
import com.example.laboratorio6F.database.SurveyDao
import kotlinx.coroutines.*

/**
 * @author Bryann
 * ViewModel for the encuesta
 */
class EncuestaViewModel (val database: SurveyDao, application: Application): AndroidViewModel(application) {
    private var viewModelJob= Job()
    private val uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)

    private  var _pregunta=MutableLiveData<String>()

    val preguntas:LiveData<String>
        get() = _pregunta

    lateinit var preguntasList:MutableList<String>
    var preguntaMade:String?=null

    init {
        Log.i("EncuestaView","Creado View Model")
    }

     fun makePregunta(){
        if (preguntaMade.isNullOrEmpty()) {
            preguntasList = mutableListOf(
                "Cual es tu opinion",
                "Calificanos"
            )

        }else{
            preguntasList= mutableListOf(
                preguntaMade.toString()
            )

            preguntasList.add("Cual es tu opinion")
            preguntasList.add("Calificanos")
        }


    }
     fun selectPregunta() {
         if (preguntasList.isNotEmpty()){
             _pregunta.value=preguntasList.removeAt(0)
             Log.i("EncuestaView: ","Removido")
         }

    }

    fun addPregunta(pregunta:String){
        preguntaMade=pregunta
    }

    fun onAddQuestionRequested(pregunta: String,tipo:String){
        uiScope.launch {
            val pregunta=PreguntaEntity()
            pregunta.name=pregunta.toString()
            pregunta.tipoPregunta=tipo.toString()
            addQuestionDatabase(pregunta)
        }
    }

    suspend fun addQuestionDatabase(pregunta:PreguntaEntity){
        withContext(Dispatchers.IO){
            database.insertPregunta(pregunta)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("EncuestaViewModel","OnCleared Model")
    }
}
