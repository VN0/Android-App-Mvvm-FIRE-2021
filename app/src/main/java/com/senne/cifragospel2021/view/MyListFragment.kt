package com.senne.cifragospel2021.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.viewModel.MyListViewModel

class MyListFragment : Fragment() {

    private lateinit var slideshowViewModel: MyListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
                ViewModelProvider(this).get(MyListViewModel::class.java)
        val root = inflater.inflate(R.layout.list, container, false)
        val textView: TextView = root.findViewById(R.id.text_myList)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}