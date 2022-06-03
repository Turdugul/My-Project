package com.example.myproject.domain.models

import com.example.myproject.data.models.InformationDto
import com.example.myproject.data.models.InformationEntity

fun InformationDto.toInformationEntity(): InformationEntity {

    return InformationEntity(
        objectId = this.objectId,
        weeks = this.weeks,
        image = this.image,
        info1 = this.info1,
        info2 = this.info2,
        info3 = this.info3,
        advices1 = this.advices1,
        advices2 = this.advices2
    )
}

