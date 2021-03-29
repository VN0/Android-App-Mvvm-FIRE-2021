package com.senne.cifragospel2021.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.MusicsAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.MusicsModel
import com.senne.cifragospel2021.viewModel.MusicsViewModel
import kotlinx.android.synthetic.main.activity_musics.*
import kotlinx.android.synthetic.main.all.*


class MusicsAcitivity : AppCompatActivity() {

    private lateinit var mMusicsViewModel: MusicsViewModel
    private var searchList : List<MusicsModel> = ArrayList()
    private val mAdapter = MusicsAdapter(searchList)
    private lateinit var mListener: MusicListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musics)

        if(supportActionBar != null) supportActionBar!!.hide()



        mMusicsViewModel = ViewModelProvider(this).get(MusicsViewModel::class.java)

        var recycler : RecyclerView = findViewById(R.id.recycler_musics)
        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        val bundle = intent.extras
        if (bundle != null) {
            val banda = bundle.getString("banda")
            val photo = bundle.getString("foto")
            mMusicsViewModel.foto("$photo", "$banda")
            mMusicsViewModel.load("$banda").observe(this, Observer {
                mAdapter.searchList = it
                mAdapter.notifyDataSetChanged()
                musics_progress.visibility = View.GONE
            })
        }

        mListener = object : MusicListener {
            override fun onClick(titulo: String,banda: String, foto: String) { }

            override fun onClickAll(banda: String) { }
            override fun onClickMusics(banda: String, titulo: String) {
                val intent = Intent(this@MusicsAcitivity,CifraActivity::class.java)

                val bundle = Bundle()
                bundle.putString("titulo", titulo)
                bundle.putString("banda", banda)
                intent.putExtras(bundle)

                startActivity(intent)
            }

        }
        mAdapter.attachListener(mListener)
    }



}