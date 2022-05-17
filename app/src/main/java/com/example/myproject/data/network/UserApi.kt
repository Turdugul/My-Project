package com.example.myproject.data.network

import com.example.myproject.data.models.UserDto
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {

    @GET("example/get_users")
    fun getUsers(): Single<List<UserDto>>
}