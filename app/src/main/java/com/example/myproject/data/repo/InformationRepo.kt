package com.example.myproject.data.repo

import com.example.myproject.data.local.InformationDao
import com.example.myproject.data.models.InformationDto
import com.example.myproject.data.models.InformationEntity
import com.example.myproject.data.network.InformationApi
import io.reactivex.Single
import javax.inject.Inject

class InformationRepo @Inject constructor(
    private var informationDao: InformationDao,
    private var informationApi: InformationApi,
) {
    fun getAllInformation(): Single<List<InformationDto>> {
        return informationApi.getInformation()
    }


    fun insertList(characterList: List<InformationEntity>) {
        informationDao.insertList(characterList)
    }

    fun getInformationById(id: String): Single<InformationDto> {
        return informationApi.getInfoById(id)
    }

    fun getInformationAsLiveData() = informationDao.getAll()
}