package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.SearchModel

class MyListViewModel: ViewModel() {

    fun load(myList: String): LiveData<MutableList<SearchModel>> {
        val mutableData = MutableLiveData<MutableList<SearchModel>>()
        FirebaseFirestore.getInstance().collection("MyList ${myList}").get()
            .addOnSuccessListener {result ->
                val list = mutableListOf<SearchModel>()
                for(document in result) {
                    val cifra = document.toObject(SearchModel::class.java)
                    list.add( SearchModel("${cifra.titulo}","${cifra.banda}", "${cifra.foto}"))
                }
                mutableData.value = list
            }
        return mutableData
    }
}