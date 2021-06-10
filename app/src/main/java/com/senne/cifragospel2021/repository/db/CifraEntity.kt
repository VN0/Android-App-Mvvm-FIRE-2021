package com.senne.cifragospel2021.repository.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.senne.cifragospel2021.model.AllModel

@Entity(tableName = "cifra")
data class AllModelEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var banda: String = "",
    var foto: String = ""
)

fun AllModel.toCifraEntity() : AllModelEntity {
    return with (this) {
        AllModelEntity (
            banda = this.banda,
            foto = this.foto
       )
    }
}

fun AllModel.toCifraModel() : AllModel {
    return with (this) {
        AllModel (
            banda = this.banda,
            foto = this.foto
        )
    }
}