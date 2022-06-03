package com.example.myproject.domain.models

import com.example.myproject.data.models.InformationDto
import com.example.myproject.data.models.InformationEntity

fun InformationDto.toInformationEntity(): InformationEntity {

    return InformationEntity(
        objectId = this.objectId,
        weeks = this.weeks,
        image = this.image,
        info = this.info,
        info2 = this.info2,
        advices = this.advices
    )
}

