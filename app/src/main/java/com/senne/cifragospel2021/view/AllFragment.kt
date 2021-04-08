package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.AllAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.viewModel.AllViewModel
import kotlinx.android.synthetic.main.all.*


class AllFragment : Fragment() {

    private lateinit var mAllViewModel: AllViewModel
    private val mAdapter: AllAdapter = AllAdapter(this)
    private lateinit var mListener: MusicListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mAllViewModel = ViewModelProvider(this).get(AllViewModel::class.java)

        val root = inflater.inflate(R.layout.all, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all)


        recycler.layoutManager = LinearLayoutManager(context)

       recycler.adapter = mAdapter

        mListener = object : MusicListener {
            override fun onClick(titulo: String, banda: String, foto: String) { }
            override fun onClickMusics(banda: String, titulo: String) {}

            override fun onClickAll(banda: String, foto: String) {

                val intent = Intent(context,MusicsAcitivity::class.java)

                val bundle = Bundle()
                bundle.putString("banda", banda)
                bundle.putString("foto", foto)

                intent.putExtras(bundle)

                startActivity(intent)
            }


        }

        mAdapter.attachListener(mListener)

        mAllViewModel.load().observe(viewLifecycleOwner, Observer {
            mAdapter.setListData(it)
            mAdapter.notifyDataSetChanged()
            progress.visibility = View.GONE
        })

        return root
    }



}