package com.senne.cifragospel2021.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.viewModel.AllViewModel
import com.senne.cifragospel2021.viewModel.CifraViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cifra.*

class CifraActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private lateinit var mCifraViewModel: CifraViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cifra)

        mCifraViewModel = ViewModelProvider(this).get(CifraViewModel::class.java)

        val bundle = intent.extras
        if(bundle != null) {
            val titulo = bundle.getString("titulo")
            val banda = bundle.getString("banda")
            val tom = bundle.getString("tom")
            val cifra = bundle.getString("cifra")
            val foto = bundle.getString("foto")
            mCifraViewModel.load("$titulo","$banda","$tom","$cifra","$foto")
        }

        mCifraViewModel.titulo.observe(this, Observer {
            cifra_titulo.text = it
        })

        mCifraViewModel.banda.observe(this, Observer {
            cifra_banda.text = it
        })

        //Spinner

        cifra_tom.onItemSelectedListener = this

        val mListMaior = listOf("C","C#","D","D#","E","F","F#","G","G#","A","A#","B","Bb","Ab","Gb","Eb","Db")
        val mListMenor = listOf("Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m","Am","A#m","Bm","Bbm","Abm","Gbm","Ebm","Dbm")

        mCifraViewModel.tom.observe(this, Observer {

            if((it == 0) || (it == 1) || (it == 2) || (it == 3) || (it == 4) || (it == 5) || (it == 6) || (it == 7) || (it == 8) || (it == 9) || (it == 10) || (it == 11) || (it == 12) || (it == 13) || (it == 14) || (it == 15) || (it == 16) ){
                cifra_tom.adapter =  ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mListMaior)
                cifra_tom.setSelection(it)
            }else {
                val pos = it - 17
                cifra_tom.adapter =  ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mListMenor)
                cifra_tom.setSelection(pos)
            }

        })

        mCifraViewModel.cifra.observe(this, Observer {
            cifra_cifra.text = it
        })

        mCifraViewModel.novoTom.observe(this, Observer {
            cifra_cifra.text = it
        })

        mCifraViewModel.foto.observe(this, Observer {
            Picasso.get().load(it).into(cifra_foto)
        })

    }

    override fun onClick(v: View) {  }

    override fun onNothingSelected(p0: AdapterView<*>?) { Toast.makeText(this,"Tom da música não disponível", Toast.LENGTH_LONG).show() }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (parent?.id) {
            R.id.cifra_tom -> {
              val nota = parent?.getItemAtPosition(position)
                mCifraViewModel.mudaTom("$nota")
            }
    }


}

}