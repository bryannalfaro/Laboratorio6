package com.example.laboratorio6F.views

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratorio6F.R
import com.example.laboratorio6F.databinding.PreguntasFragmentBinding
import com.example.laboratorio6F.viewmodels.EncuestaViewModel

/**
 * @author Bryann Alfaro
 * Fragment that displays the view for the question
 */
@Suppress("DEPRECATION")
class Preguntas : Fragment() {



    var texto:String=""
    private lateinit var viewModel: EncuestaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        val bindingPreguntas=DataBindingUtil.inflate<PreguntasFragmentBinding>(inflater,R.layout.preguntas_fragment,container,false)

        setHasOptionsMenu(true)

        return bindingPreguntas.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.save_menu,menu)
    }
    //when the button save is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val edit:EditText = view!!.findViewById(R.id.editText)
        texto=edit.text.toString()
        viewModel=ViewModelProviders.of(activity!!).get(EncuestaViewModel::class.java)
        viewModel.addPregunta(texto)
        edit.setText("")
        view!!.findNavController().navigate(R.id.action_preguntas_to_principal)
        return super.onOptionsItemSelected(item)
    }
}
