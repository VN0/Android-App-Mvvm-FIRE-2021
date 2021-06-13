package com.senne.cifragospel2021.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.senne.cifragospel2021.model.AllModel

@Dao
interface CifraDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cifra: AllModelEntity)

    @Query("SELECT * FROM cifra")
    suspend fun getAllCifra(): MutableList<AllModel>


}