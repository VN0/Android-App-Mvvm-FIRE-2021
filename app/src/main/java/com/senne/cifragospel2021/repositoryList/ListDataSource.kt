package com.senne.cifragospel2021.repositoryList

import com.senne.cifragospel2021.model.SearchModel

class ListDataSource(
    private val cifraDAO : ListDAO
) : ListRepository {
    override suspend fun createCifra(registrationViewParams: SearchModel) {
        val cifraEntity = registrationViewParams.toCifraEntityToList()
        cifraDAO.save(cifraEntity)
    }

    override suspend fun getAll(): MutableList<SearchModel> {
        return cifraDAO.getAllCifra()
    }
}