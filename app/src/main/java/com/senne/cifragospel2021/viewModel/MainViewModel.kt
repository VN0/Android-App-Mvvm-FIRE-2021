package com.senne.cifragospel2021.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.AllModel
import com.senne.cifragospel2021.repository.db.CifraRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CifraRepository) : ViewModel() {

    fun loadAll() {

     viewModelScope.launch {
          if(repository.getAll().isEmpty()) {
              FirebaseFirestore.getInstance().collection("Bandas").orderBy("banda").get()
                  .addOnSuccessListener { result ->

                      for (document in result) {
                          val cifra = document.toObject(AllModel::class.java)
                          viewModelScope.launch {
                              repository.createCifra(AllModel("${cifra.banda}", "${cifra.foto}"))
                          }
                      }

                  }
          }
        }

    }

    class RegistrationViewModelFactory(private val repository: CifraRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}