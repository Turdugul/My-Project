package com.example.myproject.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.myproject.data.models.InformationEntity
import com.example.myproject.data.repo.InformationRepo
import javax.inject.Inject

class GetInformationAsLiveDataUseCase @Inject constructor(
    private val informationRepo: InformationRepo
) {
    operator fun invoke(): LiveData<List<InformationEntity>> {
        return informationRepo.getInformationAsLiveData()
    }
}