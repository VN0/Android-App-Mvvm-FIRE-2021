package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.senne.cifragospel2021.model.MusicsModel

class MusicsViewModel : ViewModel() {

    private var mFoto = MutableLiveData<String>()
    val photo : LiveData<String> = mFoto

    private var mBanda = MutableLiveData<String>()
    val banda : LiveData<String> = mBanda

    fun load( banda: String): LiveData<MutableList<MusicsModel>> {
        val mutableData = MutableLiveData<MutableList<MusicsModel>>()

        FirebaseFirestore.getInstance().collection("Search").whereEqualTo("banda", "$banda").get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<MusicsModel>()
                for (document in result) {
                    val cifra = document.toObject(MusicsModel::class.java)
                    list.add( MusicsModel("${cifra.titulo}","${cifra.banda}") )
                }

                mutableData.value = list
            }

        return mutableData

    }

    fun foto(foto: String, banda: String) {
        mFoto.value = foto
        mBanda.value = banda
    }

}