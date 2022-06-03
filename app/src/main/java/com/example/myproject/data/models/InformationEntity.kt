package com.example.myproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val results: List<InformationEntity>
)

@Entity
data class InformationEntity(
    @PrimaryKey
    var objectId: String,
    var weeks: String? = null,
    var image: String? = null,
    var info: String? = null,
    var info2: String? = null,
    var advices: String? = null
)