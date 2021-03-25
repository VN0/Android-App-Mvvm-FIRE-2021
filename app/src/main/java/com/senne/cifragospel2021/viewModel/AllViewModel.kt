package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.AllModel

class AllViewModel : ViewModel() {

    fun load(): LiveData<MutableList<AllModel>> {
        val mutableData = MutableLiveData<MutableList<AllModel>>()

        FirebaseFirestore.getInstance().collection("Bandas").get()
                .addOnSuccessListener {result ->
                    val list = mutableListOf<AllModel>()
                    for(document in result) {
                        val cifra = document.toObject(AllModel::class.java)
                        list.add( AllModel("${cifra.banda}","${cifra.foto}") )
                    }

                    mutableData.value = list

                }

        return mutableData

    }
}