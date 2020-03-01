package com.example.laboratorio6F.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laboratorio6F.R

/**
 * @author Bryann Alfaro
 * Fragment that shows the About view
 */
class About : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


}
