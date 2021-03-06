package com.senne.cifragospel2021.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.*
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.adapter.SearchAdapter
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.SearchModel
import com.senne.cifragospel2021.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.search.*
import kotlinx.android.synthetic.main.search.view.*
import kotlinx.android.synthetic.main.search_item_row.*

class SearchFragment : Fragment(R.layout.search) {

    private lateinit var mSearchViewModel: SearchViewModel
    private var searchList: List<SearchModel> = ArrayList()
    private val mAdapter = SearchAdapter(searchList)
    private lateinit var mListener: MusicListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSearchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        recycler_search.hasFixedSize()
        recycler_search.layoutManager = LinearLayoutManager(context)
        recycler_search.adapter = mAdapter

        animationsStart()

        edit_text.setOnFocusChangeListener { view, b ->
            if(!b)  closeKeyboard(view)
        }

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if ("$s".length > 1) {
                    recycler_search.visibility = View.VISIBLE
                    search_progress.visibility = View.VISIBLE
                    tipLayout.visibility = View.GONE
                    mSearchViewModel.load("$s".toLowerCase()).observe(viewLifecycleOwner, Observer {
                        search_progress.visibility = View.GONE
                        if(!it.isEmpty()) {
                            search_results.visibility = View.GONE
                        }else {
                            search_results.visibility = View.VISIBLE
                        }

                        mAdapter.searchList = it
                        mAdapter.notifyDataSetChanged()
                    })
                } else {
                    tipLayout.visibility = View.VISIBLE
                    recycler_search.visibility = View.GONE
                    search_results.visibility = View.GONE
                }
            }
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

            override fun onClickAll(banda: String, foto: String) {
                val intent = Intent(context,MusicsAcitivity::class.java)
                val bundle = Bundle()
                bundle.putString("banda", banda)
                bundle.putString("foto", foto)

                intent.putExtras(bundle)
                startActivity(intent)
            }
            override fun onClickMusics(banda: String, titulo: String) {}

        }
        mAdapter.attachListener(mListener)
    }

    private fun animationsStart() {
        val top_anim = AnimationUtils.loadAnimation(context, R.anim.top_anim)
        foto_tip.startAnimation(top_anim)
    }

    private fun closeKeyboard(view: View) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}