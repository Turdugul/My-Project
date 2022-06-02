package com.example.myproject.domain.use_cases

import com.example.myproject.data.models.InformationEntity
import com.example.myproject.data.repo.InformationRepo
import com.example.myproject.domain.models.toInformationEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetInformationByIdUseCase @Inject constructor(
    private val repo: InformationRepo,
) {
    operator fun invoke(id: String): Single<InformationEntity> {
        return repo.getInformationById(id)
            .subscribeOn(Schedulers.io())
            .map {
                it.toInformationEntity()
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}