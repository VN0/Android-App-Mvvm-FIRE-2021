package com.senne.cifragospel2021.view

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.sharedPreferences.SecurityPreferences
import com.senne.cifragospel2021.viewModel.CifraViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cifra.*


class CifraActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private lateinit var mCifraViewModel: CifraViewModel
    private var ourFontSize = 14f
    private lateinit var securityPreferences : SecurityPreferences
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cifra)

        if(supportActionBar != null) supportActionBar!!.hide()

        securityPreferences = SecurityPreferences(this)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        cifra_less.setOnClickListener(this)
        cifra_more.setOnClickListener(this)
        cifra_btn.setOnClickListener(this)
        cifra_banda.setOnClickListener(this)
        back.setOnClickListener(this)

        mCifraViewModel = ViewModelProvider(this).get(CifraViewModel::class.java)

        val bundle = intent.extras
        if (bundle != null) {
            val titulo = bundle.getString("titulo")
            val banda = bundle.getString("banda")
            mCifraViewModel.load("$titulo", "$banda")
        }

        mCifraViewModel.titulo.observe(this, Observer {
            cifra_titulo.text = it
        })

        mCifraViewModel.banda.observe(this, Observer {
            cifra_banda.text = it
        })
        //Spinner
        cifra_tom.onItemSelectedListener = this

        val mListMaior = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "Bb", "Ab", "Gb", "Eb", "Db" )
        val mListMenor = listOf("Cm","C#m","Dm", "D#m", "Em", "Fm", "F#m", "Gm","G#m", "Am", "A#m", "Bm", "Bbm", "Abm", "Gbm", "Ebm", "Dbm" )

        mCifraViewModel.tom.observe(this, Observer {

            for(i in 0..16) {
                if (it == i) {
                    cifra_tom.adapter = ArrayAdapter(this, R.layout.sppiner_item, mListMaior)
                    cifra_tom.setSelection(it)
                    break
                } else {
                    val pos = it - 17
                    cifra_tom.adapter = ArrayAdapter(this, R.layout.sppiner_item, mListMenor)
                    cifra_tom.setSelection(pos)
                }
            }

        })

        mCifraViewModel.novoTom.observe(this, Observer {

            val itEdited = it.toString().replace("<b>", "&.").replace("</b>", "*.")

            cifra_cifra.text = setCifra(itEdited)
            cifra_progress.visibility = View.GONE
        })

        mCifraViewModel.foto.observe(this, Observer {
            Picasso.get().load(it).into(cifra_foto)
        })
    }

    fun setCifra(text: String): SpannableStringBuilder {
        val span = SpannableStringBuilder(text)

            var offset = 0
            var offset2 = 0
            var start: Int
            var end: Int

            start = text.indexOf("&.", offset, true)
            end = text.indexOf("*.", offset2, true)

            while (start >= 0) {

               span.setSpan(StyleSpan(Typeface.BOLD), start + 2 , end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
               span.setSpan( ForegroundColorSpan(resources.getColor(R.color.red)),  start + 2 , end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
               span.setSpan( ForegroundColorSpan(resources.getColor(R.color.white)),  start  , start + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
               span.setSpan( ForegroundColorSpan(resources.getColor(R.color.white)),  end  , end + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

                offset2 = end + 2
                offset = start + 2
                start = text.indexOf("&.", offset, true)
                end = text.indexOf("*.", offset2, true)
            }
        return span
    }

    override fun onClick(v: View) {
        val id = v.id
        when(id) {
            R.id.cifra_less -> {
                ourFontSize -= 1f
                cifra_cifra.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontSize)
            }
            R.id.cifra_more -> {
                ourFontSize += 1f
                cifra_cifra.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontSize)
            }
            R.id.back -> {
                finish()
            }
            R.id.cifra_btn -> {
                var key = securityPreferences.getString("email")
                val bundle = intent.extras
                    val titulo = bundle?.getString("titulo")
                    val banda = bundle?.getString("banda")

                mCifraViewModel.add("$key", "$titulo", "$banda")

               Toast.makeText(this, getString(R.string.adicionado), Toast.LENGTH_LONG).show()
            }
            R.id.cifra_banda -> {
                val intent = Intent(this,MusicsAcitivity::class.java)
                val bundle = Bundle()
                mCifraViewModel.banda.observe(this, Observer {
                    bundle.putString("banda", it)
                })
                mCifraViewModel.foto.observe(this, Observer {
                    bundle.putString("foto", it)
                })
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) { Toast.makeText(this, "Tom da música não disponível", Toast.LENGTH_LONG).show()}

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (parent?.id) {
            R.id.cifra_tom -> {
                val nota = parent?.getItemAtPosition(position)
                mCifraViewModel.mudaTom("$nota")
            }
        }
    }
}