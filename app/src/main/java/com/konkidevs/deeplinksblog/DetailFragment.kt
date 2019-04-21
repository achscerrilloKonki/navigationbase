package com.konkidevs.deeplinksblog


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var safeArgs: DetailFragmentArgs? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            safeArgs = DetailFragmentArgs.fromBundle(it)
        }

        detailInfo.visibility = if (safeArgs != null) {
            detailInfo.text = getString(R.string.id_and_name, safeArgs?.id, safeArgs?.name)
            View.VISIBLE
        }else {
            View.GONE
        }

    }

}
