package com.senne.cifragospel2021.repositoryList

import com.senne.cifragospel2021.model.SearchModel

interface ListRepository {

    suspend fun createCifra(registrationViewParams: SearchModel)

    suspend fun getAll(): MutableList<SearchModel>
}