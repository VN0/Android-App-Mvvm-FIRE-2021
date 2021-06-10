package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.*
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.AllModel
import com.senne.cifragospel2021.repository.db.CifraRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: CifraRepository) : ViewModel() {

    private val mAllCifras = MutableLiveData<MutableList<AllModel>>()
    var allCifras: LiveData<MutableList<AllModel>> = mAllCifras


    fun loadAll() {

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

    class RegistrationViewModelFactory(private val repository: CifraRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}