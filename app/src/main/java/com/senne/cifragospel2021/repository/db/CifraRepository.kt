package com.senne.cifragospel2021.repository.db

import com.senne.cifragospel2021.model.AllModel

interface CifraRepository {

    suspend fun createCifra(registrationViewParams: AllModel)

    suspend fun getAll(): MutableList<AllModel>

}