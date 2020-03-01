package com.example.laboratorio6F.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laboratorio6F.R
import com.example.laboratorio6F.database.SurveyDatabase
import com.example.laboratorio6F.viewmodels.EncuestaViewModelFactory
import com.example.laboratorio6F.viewmodels.ListaResultadosViewModel
import com.example.laboratorio6F.viewmodels.ListaResultadosViewModelFactory


class ListaResultados : Fragment() {

    companion object {
        fun newInstance() = ListaResultados()
    }

    private lateinit var viewModel: ListaResultadosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_resultados_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        val application= requireNotNull(this.activity).application
        val dataSource= SurveyDatabase.getInstance(application).surveyDao
        val ListaFactory= ListaResultadosViewModelFactory(dataSource,application)
        viewModel = ViewModelProviders.of(activity!!,ListaFactory).get(ListaResultadosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
