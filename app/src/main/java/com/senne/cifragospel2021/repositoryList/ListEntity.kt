package com.senne.cifragospel2021.repositoryList

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.senne.cifragospel2021.model.SearchModel


@Entity(tableName = "list")
data class ListEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var titulo: String,
    var banda: String = "",
    var foto: String = ""
)

fun SearchModel.toCifraEntityToList() : ListEntity {
    return with (this) {
        ListEntity (
            titulo = this.titulo,
            banda = this.banda,
            foto = this.foto
        )
    }
}

