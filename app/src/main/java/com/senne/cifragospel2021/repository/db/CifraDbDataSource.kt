package com.senne.cifragospel2021.repository.db

import com.senne.cifragospel2021.model.AllModel

class CifraDbDataSource(
    private val cifraDAO : CifraDAO
) : CifraRepository {

    override suspend fun createCifra(registrationViewParams: AllModel) {
        val cifraEntity = registrationViewParams.toCifraEntity()
        cifraDAO.save(cifraEntity)
    }

    override suspend fun getAll(): MutableList<AllModel> {
        return cifraDAO.getAllCifra()
    }

}
