package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.MyListAdapter
import com.senne.cifragospel2021.adapter.SearchAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.SearchModel
import com.senne.cifragospel2021.sharedPreferences.SecurityPreferences
import com.senne.cifragospel2021.viewModel.MyListViewModel
import kotlinx.android.synthetic.main.my_list.*
import kotlinx.android.synthetic.main.search.*

class MyListFragment : Fragment() {

    private lateinit var mMyListViewModel: MyListViewModel
    private var myList: List<SearchModel> = ArrayList()
    private val mAdapter = MyListAdapter(myList)
    private lateinit var mListener: MusicListener
    private lateinit var securityPreferences : SecurityPreferences

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        mMyListViewModel = ViewModelProvider(this).get(MyListViewModel::class.java)
        val root = inflater.inflate(R.layout.my_list, container, false)

        securityPreferences = SecurityPreferences(requireContext())

        var recycler: RecyclerView = root.findViewById(R.id.recycler_myList)
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        var key = securityPreferences.getString("email")

        mMyListViewModel.load("$key").observe(viewLifecycleOwner, Observer {
            if(!it.isEmpty()) {
                myList_empty.visibility = View.GONE
            }else {
                myList_empty.visibility = View.VISIBLE
            }
            myList_progress.visibility = View.GONE
            mAdapter.searchList = it
            mAdapter.notifyDataSetChanged()
        })

        mListener = object : MusicListener {
            override fun onClick(titulo: String, banda: String, foto: String) {

                val intent = Intent(context, CifraActivity::class.java)

                val bundle = Bundle()
                bundle.putString("titulo", titulo)
                bundle.putString("banda", banda)

                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onClickAll(banda: String) {}
            override fun onClickMusics(banda: String, titulo: String) {
                var documento = "$titulo $banda"
                mMyListViewModel.delete("$key","$documento")
                Toast.makeText(context, getString(R.string.apagado), Toast.LENGTH_SHORT).show()
                mMyListViewModel.load("$key").observe(viewLifecycleOwner, Observer {
                    if(!it.isEmpty()) {
                        myList_empty.visibility = View.GONE
                    }else {
                        myList_empty.visibility = View.VISIBLE
                    }
                    mAdapter.searchList = it
                    mAdapter.notifyDataSetChanged()
                })
            }

        }
        mAdapter.attachListener(mListener)
        return root
    }
}