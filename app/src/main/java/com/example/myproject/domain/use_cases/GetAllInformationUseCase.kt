package com.example.myproject.domain.use_cases

import com.example.myproject.data.models.InformationEntity
import com.example.myproject.data.repo.InformationRepo
import com.example.myproject.domain.models.toInformationEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetAllInformationUseCase @Inject constructor(
    private val informationRepo: InformationRepo,
) {
    operator fun invoke(): Single<List<InformationEntity>> {
        return informationRepo.getAllInformation()
            .subscribeOn(Schedulers.io())
            .map {
                it
            }
            .map {
                val listDB = mutableListOf<InformationEntity>()
                it.forEach {
                    listDB.add(it.toInformationEntity())
                }
                listDB.toList()
            }
            .map {
                informationRepo.insertList(it)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}