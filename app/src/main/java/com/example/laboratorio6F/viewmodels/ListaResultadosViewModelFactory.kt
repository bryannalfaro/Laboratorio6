package com.example.laboratorio6F.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio6F.database.SurveyDao

/**
 * @author Bryann
 * Factory for the list of results
 */
class ListaResultadosViewModelFactory(
    private val dataSource: SurveyDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaResultadosViewModel::class.java)) {
            return ListaResultadosViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}