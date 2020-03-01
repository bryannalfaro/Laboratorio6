package com.example.laboratorio6F.viewmodels

import androidx.lifecycle.ViewModel

/**
 * @author Bryann
 * ViewModel for the results
 */
class ResultadoViewModel : ViewModel() {


     var cantidadSurveys:Int=0
     var promedioRating:Float=0.0f
    private var respuestas=ArrayList<String>()


    fun endSurvey(){
        cantidadSurveys++
    }
    fun rating(ratingbar:Float){
        promedioRating=(promedioRating+ratingbar)/cantidadSurveys
    }

    fun returnAll():ArrayList<String>{
        return respuestas
    }

    fun establecerRespuesta(respuesta:String){
        respuestas.add(respuesta)
    }


}
