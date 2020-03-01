package com.example.laboratorio6F.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Bryann
 * ViewModel for the encuesta
 */
class EncuestaViewModel : ViewModel() {


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

    override fun onCleared() {
        super.onCleared()
        Log.i("EncuestaViewModel","OnCleared Model")
    }
}
