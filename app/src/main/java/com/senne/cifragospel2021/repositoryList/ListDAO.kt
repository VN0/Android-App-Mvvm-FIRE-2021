package com.senne.cifragospel2021.repositoryList

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.senne.cifragospel2021.model.SearchModel

interface ListDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cifra: ListEntity)

    @Query("SELECT * FROM list")
    suspend fun getAllCifra(): MutableList<SearchModel>
}