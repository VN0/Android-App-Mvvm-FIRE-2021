package com.senne.cifragospel2021.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.AllAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.repository.db.AppDataBase
import com.senne.cifragospel2021.repository.db.CifraDbDataSource
import com.senne.cifragospel2021.repository.db.CifraRepository
import com.senne.cifragospel2021.viewModel.AllViewModel
import kotlinx.android.synthetic.main.all.*


class AllFragment : Fragment(R.layout.all) {

    private val mAllViewModel: AllViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val cifraDAO = AppDataBase.getInstance(requireContext()).cifraDAO()
                val repository : CifraRepository = CifraDbDataSource(cifraDAO)
                return AllViewModel(repository) as T
            }

        }
    }

    private val mAdapter: AllAdapter = AllAdapter(this)
    private lateinit var mListener: MusicListener
    lateinit var mAdView: AdView




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        recycler_all.layoutManager = LinearLayoutManager(context)

        recycler_all.adapter = mAdapter

        MobileAds.initialize(context) {}
        mAdView = adView3
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mListener = object : MusicListener {
            override fun onClick(titulo: String, banda: String, foto: String) {}
            override fun onClickMusics(banda: String, titulo: String) {}

            override fun onClickAll(banda: String, foto: String) {

                val intent = Intent(context, MusicsAcitivity::class.java)

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
    }


}