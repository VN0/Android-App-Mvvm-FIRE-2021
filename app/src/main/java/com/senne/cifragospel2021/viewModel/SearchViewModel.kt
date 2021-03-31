package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.SearchModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private var searchJob: Job? = null


    fun load(searchText: String): LiveData<MutableList<SearchModel>> {
        val mutableData = MutableLiveData<MutableList<SearchModel>>()

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(600)


            FirebaseFirestore.getInstance().collection("Search")
                .whereArrayContains("key_words", searchText).get()
                .addOnSuccessListener { result ->

                    val list = mutableListOf<SearchModel>()
                    for (document in result) {

                        val cifra = document.toObject(SearchModel::class.java)
                        list.add(
                            SearchModel(
                                "${cifra.titulo}",
                                "${cifra.banda}",
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