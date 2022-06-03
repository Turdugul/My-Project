package com.example.myproject.data.models

data class ResponseDto(
    val results: List<InformationDto>
)

data class InformationDto(
    var objectId: String,
    var weeks: String? = null,
    var image: String? = null,
    var info1: String? = null,
    var info2: String? = null,
    var advices: String? = null
)
