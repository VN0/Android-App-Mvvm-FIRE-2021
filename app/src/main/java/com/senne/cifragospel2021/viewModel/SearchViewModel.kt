package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.CifraModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private var searchJob: Job? = null


    fun load(searchText: String): LiveData<MutableList<CifraModel>> {
        val mutableData = MutableLiveData<MutableList<CifraModel>>()

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500)


            FirebaseFirestore.getInstance().collection("Cifras")
                .whereArrayContains("key_words", searchText).get()
                .addOnSuccessListener { result ->

                    val list = mutableListOf<CifraModel>()
                    for (document in result) {

                        val cifra = document.toObject(CifraModel::class.java)
                        list.add(
                            CifraModel(
                                "${cifra.titulo}",
                                "${cifra.banda}",
                                "${cifra.tom}",
                                "${cifra.cifra}",
                                "${cifra.foto}"
                            )
                        )
                    }

                    mutableData.value = list

                }


        }




        return mutableData

    }


}