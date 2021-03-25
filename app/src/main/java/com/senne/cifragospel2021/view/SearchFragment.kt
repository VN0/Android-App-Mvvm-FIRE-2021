package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.SearchAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.SearchModel
import com.senne.cifragospel2021.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.search.*

class SearchFragment : Fragment() {

    private lateinit var mSearchViewModel: SearchViewModel
    private var searchList : List<SearchModel> = ArrayList()
    private val mAdapter = SearchAdapter(searchList)
    private lateinit var mListener: MusicListener

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mSearchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        val root = inflater.inflate(R.layout.search, container, false)

        var recycler : RecyclerView = root.findViewById(R.id.recycler_search)
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

    val editText: EditText = root.findViewById(R.id.edit_text)
    editText.addTextChangedListener( object: TextWatcher {
        override fun afterTextChanged(p0: Editable?) { }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {  }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if("$s".length > 3) {
                    recycler_search.visibility = View.VISIBLE
                    search_results.visibility = View.GONE
                    mSearchViewModel.load("$s".toLowerCase()).observe(viewLifecycleOwner, Observer {
                        mAdapter.searchList = it
                        mAdapter.notifyDataSetChanged()
                    })
                }else {
                    search_results.visibility = View.VISIBLE
                    recycler_search.visibility = View.GONE
                }

        }

    })


        mListener = object : MusicListener {
            override fun onClick(titulo: String,banda: String, foto: String) {

                val intent = Intent(context,CifraActivity::class.java)

                val bundle = Bundle()
                bundle.putString("titulo", titulo)
                bundle.putString("banda", banda)

                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onClickAll(banda: String) { }
            override fun onClickMusics(banda: String, titulo: String) {}

        }
        mAdapter.attachListener(mListener)

        return root
    }


}