package com.konkidevs.deeplinksblog


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putLong("id", 1L)
            bundle.putString("name", "Nombre desde la app")
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }

    }

}
