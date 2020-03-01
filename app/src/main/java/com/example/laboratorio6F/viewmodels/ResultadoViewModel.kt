package com.example.laboratorio6F.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.laboratorio6F.database.SurveyDao

/**
 * @author Bryann
 * ViewModel for the results
 */
class ResultadoViewModel  (val database: SurveyDao, application: Application): AndroidViewModel(application) {


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
