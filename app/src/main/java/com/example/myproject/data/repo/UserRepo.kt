package com.example.myproject.data.repo

import com.example.myproject.data.models.UserEntity
import com.example.myproject.data.network.UserApi
import com.example.myproject.data.storage.UserDao
import javax.inject.Inject


class UserRepo @Inject constructor(
    private var userDao: UserDao,
    private var userApi: UserApi
) {

    fun getUserFromApi() = userApi.getUsers()

    fun saveUsersToDb(users: List<UserEntity>) = userDao.insertUsers(users)
}