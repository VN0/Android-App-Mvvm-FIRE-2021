package com.senne.cifragospel2021.viewModel

import androidx.lifecycle.*
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel2021.model.AllModel
import com.senne.cifragospel2021.repository.db.CifraRepository
import kotlinx.coroutines.launch

class AllViewModel(private val repository: CifraRepository) : ViewModel() {

    fun load(): LiveData<MutableList<AllModel>> {
        val mutableData = MutableLiveData<MutableList<AllModel>>()

               viewModelScope.launch {
                   mutableData.value = repository.getAll()
               }

        return mutableData

    }

}