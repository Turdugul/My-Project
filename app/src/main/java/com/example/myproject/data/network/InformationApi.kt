package com.example.myproject.data.network

import com.example.myproject.data.models.InformationDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InformationApi {
    @GET("api/data/myproject")
    fun getInformation(
        @Query("pageSize") size: Int = 41
    ): Single<List<InformationDto>>
    @GET("api/data/myproject/{objectId}")
    fun getInfoById(@Path("objectId") objectId: String): Single<InformationDto>
}

