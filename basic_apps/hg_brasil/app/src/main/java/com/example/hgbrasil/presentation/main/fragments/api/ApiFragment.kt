package com.example.hgbrasil.presentation.main.fragments.api


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.hgbrasil.R

/**
 * A simple [Fragment] subclass.
 */
class ApiFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_api, container, false)

        mContext = rootView.context

        return rootView
    }

    override fun onResume() {
        super.onResume()

        loadFragment()
    }

    override fun onClick(view: View) {
        when(view.id) {}
    }

    private fun loadFragment() {}
}
